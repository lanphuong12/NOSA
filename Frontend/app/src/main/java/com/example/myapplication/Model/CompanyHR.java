package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CompanyHR implements Serializable {
    @SerializedName("id_congty")
    @Expose
    private Integer idCongty;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("dienthoai")
    @Expose
    private String dienthoai;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("gioithieu")
    @Expose
    private String gioithieu;
    @SerializedName("url_website")
    @Expose
    private String urlWebsite;
    @SerializedName("AmountJobCreated")
    @Expose
    private Integer amountJobCreated;

    public Integer getIdCongty() {
        return idCongty;
    }

    public void setIdCongty(Integer idCongty) {
        this.idCongty = idCongty;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public Integer getAmountJobCreated() {
        return amountJobCreated;
    }

    public void setAmountJobCreated(Integer amountJobCreated) {
        this.amountJobCreated = amountJobCreated;
    }

}
