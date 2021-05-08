package com.example.mydetails;

public class Appointment {
    private String cpName;
    private Integer cpConNo;
    private String apDate;
    private String apTime;
    private String apReason;
    private String apNote;

    public Appointment() {
    }

    public String getName() {
        return cpName;
    }

    public void setName(String name) {
        this.cpName = name;
    }

    public Integer getConNo() {
        return cpConNo;
    }

    public void setConNo(Integer conNo) {
        this.cpConNo = conNo;
    }

    public String getDate() {
        return apDate;
    }

    public void setDate(String date) {
        this.apDate = date;
    }

    public String getTime() {
        return apTime;
    }

    public void setTime(String time) {
        this.apTime = time;
    }

    public String getReason() {
        return apReason;
    }

    public void setReason(String reason) {
        this.apReason = reason;
    }

    public String getNote() {
        return apNote;
    }

    public void setNote(String note) {
        this.apNote = note;
    }

    public String toString(){
        return this.cpName + "\n" + "Contact Number : " + cpConNo + "\n" + "Appointment Date : " + apDate + "\n" + "Appointment Time : " + apTime ;
    }
}
