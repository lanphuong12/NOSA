package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Trinhdohocvan implements Serializable {

    @SerializedName("id_trinhdo")
    @Expose
    private Integer idTrinhdo;

    @SerializedName("ten")
    @Expose
    private String ten;

    public Integer getIdTrinhdo() {
        return idTrinhdo;
    }

    public void setIdTrinhdo(Integer idTrinhdo) {
        this.idTrinhdo = idTrinhdo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
