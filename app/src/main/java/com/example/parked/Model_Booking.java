package com.example.parked;

public class Model_Booking {
    String pid;
    String uid;

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    String coname;
    String pname;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Model_Booking(String pid, String uid, String fee, String bhours, String stime, String bid, String pname, String coname) {
        this.pid = pid;
        this.uid = uid;
        this.fee = fee;
        this.bhours = bhours;
        this.stime = stime;
        this.bid = bid;
        this.pname=pname;
        this.coname=coname;
    }

    public Model_Booking() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getBhours() {
        return bhours;
    }

    public void setBhours(String bhours) {
        this.bhours = bhours;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    String fee;
    String bhours;
    String stime;
    String bid;
}
