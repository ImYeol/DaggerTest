package com.example.yeol.daggertest.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.yeol.daggertest.data.db.model.BtImageData;
import com.example.yeol.daggertest.data.db.model.PictureInfo;
import com.example.yeol.daggertest.util.ImageUtil;
import com.github.ivbaranov.rxbluetooth.BluetoothConnection;
import com.github.ivbaranov.rxbluetooth.RxBluetooth;
import com.github.ivbaranov.rxbluetooth.events.AclEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by gyl115 on 17. 5. 4.
 */

public class BluetoothSyncService extends Service {
    private static final String TAG = "BluetoothClientService";

    private RxBluetooth rxBluetooth;
    private Subscription connectSubscription;
    private IBinder mBinder = new btBinder();
    private BluetoothConnection bluetoothConnection;
    private AcceptThread acceptThread;
    private Callback mCallback;

    public class btBinder extends Binder {
        public BluetoothSyncService getService(){
            return BluetoothSyncService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "BluetoothService started!");
        rxBluetooth = new RxBluetooth(this);

        if (!rxBluetooth.isBluetoothAvailable()) {
            // handle the lack of bluetooth support
            Log.d(TAG, "Bluetooth is not supported!");
        } else {
            // check if bluetooth is currently enabled and ready for use
            if (!rxBluetooth.isBluetoothEnabled()) {
                Log.d(TAG, "Bluetooth should be enabled first!");
            } else {
                acceptThread = new AcceptThread();
                acceptThread.start();
                connectSubscription = rxBluetooth.observeAclEvent() //
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new Action1<AclEvent>() {
                            @Override
                            public void call(AclEvent aclEvent) {
                                switch (aclEvent.getAction()) {
                                    case BluetoothDevice.ACTION_ACL_CONNECTED:
                                        //...
                                        break;
                                    case BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED:
                                        //...
                                        break;
                                    case BluetoothDevice.ACTION_ACL_DISCONNECTED:
                                        //...
                                        if (acceptThread.isAlive()) {
                                            acceptThread.interrupt();
                                        }
                                        break;
                                }
                            }
                        });
            }


        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(acceptThread == null){
            acceptThread = new AcceptThread();
            acceptThread.start();
            connectSubscription = rxBluetooth.observeAclEvent() //
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(new Action1<AclEvent>() {
                        @Override
                        public void call(AclEvent aclEvent) {
                            switch (aclEvent.getAction()) {
                                case BluetoothDevice.ACTION_ACL_CONNECTED:
                                    //...
                                    break;
                                case BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED:
                                    //...
                                    break;
                                case BluetoothDevice.ACTION_ACL_DISCONNECTED:
                                    //...
                                    if (acceptThread.isAlive()) {
                                        acceptThread.interrupt();
                                    }
                                    break;
                            }
                        }
                    });
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "BluetoothService stopped!");
        rxBluetooth.cancelDiscovery();
        acceptThread.interrupt();
        acceptThread = null;
        unsubscribe(connectSubscription);
    }

    private static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            subscription = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    class AcceptThread extends Thread {

        private BluetoothServerSocket mServerSock;
        public final UUID MY_UUID =
                UUID.fromString("D04E3068-E15B-4482-8306-4CABFA1726E7");
        private BluetoothAdapter mAdapter;
        private static final String TAG= "AcceptThread";

        public AcceptThread(){
            try {
                mServerSock = mAdapter.listenUsingInsecureRfcommWithServiceRecord(TAG, MY_UUID);
            } catch (IOException e) {
                Log.d(TAG,"error get server socket");
            }
        }

        @Override
        public void run() {
            BluetoothSocket socket = null;
            Log.d(TAG, "Accept Thread run");

            while (true) {
                // 서버소켓으로부터 클라이언트의 연결 요청 기다림
                try {
                    socket = mServerSock.accept();
                    Log.d(TAG," success to connect socket");
                    if(bluetoothConnection != null){
                        bluetoothConnection.closeConnection();
                        bluetoothConnection = null;
                    }
                    bluetoothConnection = new BluetoothConnection(socket);
                    TransferThread t = new TransferThread();
                    t.start();

                } catch (IOException e) {
                    Log.e(TAG, "Failed to get socket from client request.");
                    break;
                } catch (Exception e) {
                    Log.e(TAG,"failed to get stream");
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    class TransferThread extends Thread {
        @Override
        public void run() {
            bluetoothConnection.observeStringStream()
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Action1<String>() {
                        @Override public void call(String string) {
                            // This will be called every string received
                            GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
                            final Gson gson = builder.create();
                            BtImageData data = gson.fromJson(string, BtImageData.class);
                            Log.d(TAG,data.getFileName());
                            Uri uri = saveImage(data);
                            PictureInfo picture = new PictureInfo();
                            picture.fileName =data.getFileName();
                            picture.image = uri;
                            mCallback.onRecevied(picture);


                        }
                    }, new Action1<Throwable>() {
                        @Override public void call(Throwable throwable) {
                            // Error occured
                            Log.e(TAG,"error");
                        }
                    });
        }

        public Uri saveImage(BtImageData data){
            String path = Environment.getExternalStorageDirectory() + data.getFileName();
            File file = new File(path);
            Matrix m = new Matrix();
            m.postRotate(0);
            Bitmap bitmap = ImageUtil.getBitmapFromString(data.getRawImageData());
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),m, false);

            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uri = Uri.fromFile(file);
            Log.d(TAG, " uri : "+uri);
            return uri;
        }
    }

    public void setCallback(Callback cb){
        this.mCallback = cb;
    }

    public interface Callback {

        void onRecevied(PictureInfo picture);
    }
}
