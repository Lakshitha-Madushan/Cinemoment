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

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public Integer getCpConNo() {
        return cpConNo;
    }

    public void setCpConNo(Integer cpConNo) {
        this.cpConNo = cpConNo;
    }

    public String getApDate() {
        return apDate;
    }

    public void setApDate(String apDate) {
        this.apDate = apDate;
    }

    public String getApTime() {
        return apTime;
    }

    public void setApTime(String apTime) {
        this.apTime = apTime;
    }

    public String getApReason() {
        return apReason;
    }

    public void setApReason(String apReason) {
        this.apReason = apReason;
    }

    public String getApNote() {
        return apNote;
    }

    public void setApNote(String apNote) {
        this.apNote = apNote;
    }

}
