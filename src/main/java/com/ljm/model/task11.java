package com.ljm.model;

import java.io.Serializable;

/**
 * Created by liujm on 2017/6/15.
 */
public class task11 implements Serializable {

    private int id;
    private String head;
    private String name;
    private String speak;
    private int door;
    private int easy;
    private String year;
    private String company;
    private String money1;
    private String money2;
    private String money3;
    private String learn;
    private String tips;

    public task11(int id, String head, String name, String speak, int door, int easy, String year, String company, String money1, String money2, String money3, String learn, String tips) {
        this.id = id;
        this.head = head;
        this.name = name;
        this.speak = speak;
        this.door = door;
        this.easy = easy;
        this.year = year;
        this.company = company;
        this.money1 = money1;
        this.money2 = money2;
        this.money3 = money3;
        this.learn = learn;
        this.tips = tips;
    }
    public task11(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getEasy() {
        return easy;
    }

    public void setEasy(int easy) {
        this.easy = easy;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMoney1() {
        return money1;
    }

    public void setMoney1(String money1) {
        this.money1 = money1;
    }

    public String getMoney2() {
        return money2;
    }

    public void setMoney2(String money2) {
        this.money2 = money2;
    }

    public String getMoney3() {
        return money3;
    }

    public void setMoney3(String money3) {
        this.money3 = money3;
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "task11{" +
                "id=" + id +
                ", head='" + head + '\'' +
                ", name='" + name + '\'' +
                ", speak='" + speak + '\'' +
                ", door=" + door +
                ", easy=" + easy +
                ", year='" + year + '\'' +
                ", company='" + company + '\'' +
                ", money1='" + money1 + '\'' +
                ", money2='" + money2 + '\'' +
                ", money3='" + money3 + '\'' +
                ", learn='" + learn + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
