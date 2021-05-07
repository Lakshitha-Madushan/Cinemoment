package com.example.cinemoment;

public class Package {

    private String pName;
    private Double pPrice;
    private Double pAdvance;

    public Package(String pName, Double pPrice, Double pAdvance) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pAdvance = pAdvance;
    }

    public Package() {
    }

    public String getPName() {
        return pName;
    }

    public Double getPPrice() {
        return pPrice;
    }

    public Double getPAdvance() {
        return pAdvance;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public void setPPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public void setPAdvance(Double pAdvance) {
        this.pAdvance = pAdvance;
    }
}
