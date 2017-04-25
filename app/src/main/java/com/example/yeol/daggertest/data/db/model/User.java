package com.example.yeol.daggertest.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gyl115 on 17. 4. 16.
 */

@Entity(nameInDb = "user")
public class User {

    @Id(autoincrement = true)
    private long id;

    @Property(nameInDb = "name")
    String name;

    @Property(nameInDb = "age")
    int age;

    @Property(nameInDb = "imgURL")
    String imgURL;

    public User(){
        this.name="empty";
        this.age=0;
        this.imgURL="empty";
    }
    public User(String name,int age, String imgURL){
        this.name=name;
        this.age=age;
        this.imgURL=imgURL;

    }
    @Generated(hash = 87735073)
    public User(long id, String name, int age, String imgURL) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.imgURL = imgURL;
    }

    public long getId() { return id;}

    public void setId(long id){ this.id = id;}

    public void setName(String name){
        this.name=name;
    }

    public void setImgURL(String imgURL){
        this.imgURL=imgURL;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getName(){
        return this.name;
    }

    public String getImgURL(){
        return this.imgURL;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return "User {"+ " name: "+name + " age: "+ age;
    }
}
