package com.example.cinemoment;

import java.util.Date;

public class Booking {

    private String grmName;
    private String brdName;
    private Integer contact;
    private String date;
    private String time;
    private String address;
    private String agenda;

    public Booking() {

    }

    public String getGrmName() {
        return grmName;
    }

    public void setGrmName(String grmName) {
        this.grmName = grmName;
    }

    public String getBrdName() {
        return brdName;
    }

    public void setBrdName(String brdName) {
        this.brdName = brdName;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
       this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }


}
