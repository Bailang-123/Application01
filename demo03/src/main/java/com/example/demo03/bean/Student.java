package com.example.demo03.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
@Entity
public class Student{
    @Id(autoincrement = true)
    private  Long id;
    private  String name;
    private  int age;
    private String sex;
    private String hobby;
    @Generated(hash = 1329802632)
    public Student(Long id, String name, int age, String sex, String hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getHobby() {
        return this.hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
