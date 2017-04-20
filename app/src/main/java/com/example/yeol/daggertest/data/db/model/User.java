package com.example.yeol.daggertest.data.db.model;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public class User {
    String name;
    int age;
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
