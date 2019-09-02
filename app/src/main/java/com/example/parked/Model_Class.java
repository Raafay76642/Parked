package com.example.parked;

public class Model_Class {
    private String COname;

    public Model_Class() {
    }

    public Model_Class(String COname, String COage, String CLN) {
        this.COname = COname;
        this.COage = COage;
        this.CLN = CLN;
    }

    private String COage;
    private String CLN;

    public String getRnumber() {
        return Rnumber;
    }

    public void setRnumber(String rnumber) {
        Rnumber = rnumber;
    }

    public String getVtype() {
        return Vtype;
    }

    public void setVtype(String vtype) {
        Vtype = vtype;
    }

    private String Rnumber;
    private String Vtype;

    public String getCOname() {
        return COname;
    }

    public void setCOname(String COname) {
        this.COname = COname;
    }

    public String getCOage() {
        return COage;
    }

    public void setCOage(String COage) {
        this.COage = COage;
    }

    public String getCLN() {
        return CLN;
    }

    public void setCLN(String CLN) {
        this.CLN = CLN;
    }
}
