package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Jobnew implements Serializable {

    @SerializedName("id_congviec")
    @Expose
    private Integer idCongviec;
    @SerializedName("AmountCVApplied")
    @Expose
    private Integer amountCVApplied;
    @SerializedName("tenjob")
    @Expose
    private String tenjob;
    @SerializedName("minsalary")
    @Expose
    private Integer minsalary;
    @SerializedName("maxsalary")
    @Expose
    private Integer maxsalary;
    @SerializedName("soluongtuyendung")
    @Expose
    private Integer soluongtuyendung;
    @SerializedName("tenloaihinhcv")
    @Expose
    private String tenloaihinhcv;
    @SerializedName("tencty")
    @Expose
    private String tencty;
    @SerializedName("ngayhethan")
    @Expose
    private String ngayhethan;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("trangthai")
    @Expose
    private Integer trangthai;

    public Integer getIdCongviec() {
        return idCongviec;
    }

    public void setIdCongviec(Integer idCongviec) {
        this.idCongviec = idCongviec;
    }

    public Integer getAmountCVApplied() {
        return amountCVApplied;
    }

    public void setAmountCVApplied(Integer amountCVApplied) {
        this.amountCVApplied = amountCVApplied;
    }

    public String getTenjob() {
        return tenjob;
    }

    public void setTenjob(String tenjob) {
        this.tenjob = tenjob;
    }

    public Integer getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(Integer minsalary) {
        this.minsalary = minsalary;
    }

    public Integer getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(Integer maxsalary) {
        this.maxsalary = maxsalary;
    }

    public Integer getSoluongtuyendung() {
        return soluongtuyendung;
    }

    public void setSoluongtuyendung(Integer soluongtuyendung) {
        this.soluongtuyendung = soluongtuyendung;
    }

    public String getTenloaihinhcv() {
        return tenloaihinhcv;
    }

    public void setTenloaihinhcv(String tenloaihinhcv) {
        this.tenloaihinhcv = tenloaihinhcv;
    }

    public String getTencty() {
        return tencty;
    }

    public void setTencty(String tencty) {
        this.tencty = tencty;
    }

    public String getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(String ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }
}
