package com.example.emergencyreferralrhodes;

public class Hospital {

    String hName, hTown, hDistrict;

    public Hospital(){

    }

    public Hospital(String hName, String hTown, String hDistrict) {
        this.hName = hName;
        this.hTown = hTown;
        this.hDistrict = hDistrict;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethTown() {
        return hTown;
    }

    public void sethTown(String hTown) {
        this.hTown = hTown;
    }

    public String gethDistrict() {
        return hDistrict;
    }

    public void sethDistrict(String hDistrict) {
        this.hDistrict = hDistrict;
    }
}
