package com.example.hitesh_pc.volleyexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hitesh-PC on 27-08-2016.
 */

public class Phone {
    @SerializedName("home")
    private String homeNumber;

    @SerializedName("mobile")
    private String mobileNumber;

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
