package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Nganhnghe implements Serializable {
    @SerializedName("id_nganh")
    @Expose
    private Integer idNganh;

    @SerializedName("id_danhmucnganh")
    @Expose
    private Integer idDanhmucnganh;

    @SerializedName("tennganh")
    @Expose
    private String tennganh;

    private boolean checked = false;

    public Integer getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(Integer idNganh) {
        this.idNganh = idNganh;
    }

    public Integer getIdDanhmucnganh() {
        return idDanhmucnganh;
    }

    public void setIdDanhmucnganh(Integer idDanhmucnganh) {
        this.idDanhmucnganh = idDanhmucnganh;
    }

    public String getTennganh() {
        return tennganh;
    }

    public void setTennganh(String tennganh) {
        this.tennganh = tennganh;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return (idNganh + " - " + tennganh);
    }
}
