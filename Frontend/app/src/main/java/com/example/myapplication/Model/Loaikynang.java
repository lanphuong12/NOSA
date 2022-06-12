package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Loaikynang implements Serializable {

    @SerializedName("id_loaikynang")
    @Expose
    private Integer idLoaikynang;

    @SerializedName("ten")
    @Expose
    private String ten;

    @SerializedName("mota")
    @Expose
    private String mota;

    public Integer getIdLoaikynang() {
        return idLoaikynang;
    }

    public void setIdLoaikynang(Integer idLoaikynang) {
        this.idLoaikynang = idLoaikynang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
