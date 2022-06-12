package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SkillUser implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("idloaikynang")
    @Expose
    private Integer idloaikynang;
    @SerializedName("loaikynang")
    @Expose
    private String loaikynang;
    @SerializedName("idtenkynang")
    @Expose
    private Integer idtenkynang;
    @SerializedName("tenkynang")
    @Expose
    private String tenkynang;
    @SerializedName("mota")
    @Expose
    private String mota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdloaikynang() {
        return idloaikynang;
    }

    public void setIdloaikynang(Integer idloaikynang) {
        this.idloaikynang = idloaikynang;
    }

    public String getLoaikynang() {
        return loaikynang;
    }

    public void setLoaikynang(String loaikynang) {
        this.loaikynang = loaikynang;
    }

    public Integer getIdtenkynang() {
        return idtenkynang;
    }

    public void setIdtenkynang(Integer idtenkynang) {
        this.idtenkynang = idtenkynang;
    }

    public String getTenkynang() {
        return tenkynang;
    }

    public void setTenkynang(String tenkynang) {
        this.tenkynang = tenkynang;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

}
