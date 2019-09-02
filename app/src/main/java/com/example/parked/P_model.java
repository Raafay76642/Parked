package com.example.parked;

public class P_model {
    public P_model() {
    }

    private String Owner_name;
    private String P_name;
    private String Longi;

    public String getOwner_name() {
        return Owner_name;
    }

    public String getP_name() {
        return P_name;
    }

    public String getLongi() {
        return Longi;
    }

    public String getLati() {
        return Lati;
    }

    public String getAddress() {
        return Address;
    }

    public String getP_space() {
        return P_space;
    }

    public String getId() {
        return Id;
    }

    public String getB_fee() {
        return B_fee;
    }

    public String getC_fee() {
        return C_fee;
    }

    private String Lati;
    private String Address;
    private String P_space;

    public void setP_space(String p_space) {
        P_space = p_space;
    }

    private String Id;
    private String B_fee;
    private String C_fee;
}
