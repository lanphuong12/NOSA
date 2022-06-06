package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Danhmucnganhnghe implements Serializable {
    @SerializedName("id_danhmucnganh")
    @Expose
    private Integer idDanhmucnganh;

    @SerializedName("tendanhmuc")
    @Expose
    private String tendanhmuc;

    public Integer getIdDanhmucnganh() {
        return idDanhmucnganh;
    }

    public void setIdDanhmucnganh(Integer idDanhmucnganh) {
        this.idDanhmucnganh = idDanhmucnganh;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

}
