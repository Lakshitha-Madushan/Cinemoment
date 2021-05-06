package com.example.cinemoment;

public class Package {
    private String pkType;
    private String pkName;
    private Integer noOfCam;
    private String drone;
    private String pkDescription;
    private Integer pkAmount;

    public Package() {
    }

    public String getPkType() {
        return pkType;
    }

    public void setPkType(String pkType) {
        this.pkType = pkType;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public Integer getNoOfCam() {
        return noOfCam;
    }

    public void setNoOfCam(int noOfCam) {
        this.noOfCam = noOfCam;
    }

    public String getDrone() {
        return drone;
    }

    public void setDrone(String drone) {
        this.drone = drone;
    }

    public String getPkDescription() {
        return pkDescription;
    }

    public void setPkDescription(String pkDescription) {
        this.pkDescription = pkDescription;
    }

    public Integer getPkAmount() {
        return pkAmount;
    }

    public void setPkAmount(int pkAmount) {
        this.pkAmount = pkAmount;
    }
}
