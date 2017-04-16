package com.example.yeol.daggertest.data.model;

/**
 * Created by gyl115 on 17. 4. 16.
 */

public class User {
    private String name;
    private int age;

    public User(){

    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return "User {"+ " name: "+name + " age: "+ age;
    }
}
