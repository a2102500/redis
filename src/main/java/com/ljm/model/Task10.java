package com.ljm.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by liujm on 2017/6/15.
 */
//implements Serializable
public class Task10 implements Serializable{
     long id;
     String name;
    String password;
    String hope;
     String course;
     String date;
     String school;
     String qq;
     String yinjian;
     String shenhe;
     long create;
     long update;
     String phone;
    String company;


    public Task10(){

    }
    public Task10(int id, String name, String password, String hope, String course, String date, String school, String qq, String yinjian, String shenhe, long create, long update, String phone, String company) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.hope = hope;
        this.course = course;
        this.date = date;
        this.school = school;
        this.qq = qq;
        this.yinjian = yinjian;
        this.shenhe = shenhe;
        this.create = create;
        this.update = update;
        this.phone = phone;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHope() {
        return hope;
    }

    public void setHope(String hope) {
        this.hope = hope;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getYinjian() {
        return yinjian;
    }

    public void setYinjian(String yinjian) {
        this.yinjian = yinjian;
    }

    public String getShenhe() {
        return shenhe;
    }

    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }

    public long getCreate() {
        return create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "task10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", hope='" + hope + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", school='" + school + '\'' +
                ", qq='" + qq + '\'' +
                ", yinjian='" + yinjian + '\'' +
                ", shenhe='" + shenhe + '\'' +
                ", create=" + create +
                ", update=" + update +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }


}