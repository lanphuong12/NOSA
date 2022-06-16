package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SkillJob implements Serializable {

    @SerializedName("id_skill")
    @Expose
    private Integer idSkill;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("mota")
    @Expose
    private Object mota;

    public Integer getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Integer idSkill) {
        this.idSkill = idSkill;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Object getMota() {
        return mota;
    }

    public void setMota(Object mota) {
        this.mota = mota;
    }

}
