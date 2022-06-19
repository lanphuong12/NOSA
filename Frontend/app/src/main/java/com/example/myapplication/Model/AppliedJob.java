package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppliedJob implements Serializable {

    @SerializedName("id_nopcv")
    @Expose
    private Integer idNopcv;
    @SerializedName("id_congviec")
    @Expose
    private Integer idCongviec;
    @SerializedName("tenjob")
    @Expose
    private String tenjob;
    @SerializedName("minsalary")
    @Expose
    private Integer minsalary;
    @SerializedName("maxsalary")
    @Expose
    private Integer maxsalary;
    @SerializedName("ngaynopcv")
    @Expose
    private String ngaynopcv;
    @SerializedName("tencty")
    @Expose
    private String tencty;
    @SerializedName("diachicty")
    @Expose
    private String diachicty;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("CV")
    @Expose
    private String cv;
    @SerializedName("trangthai")
    @Expose
    private Integer trangthai;

    public Integer getIdNopcv() {
        return idNopcv;
    }

    public void setIdNopcv(Integer idNopcv) {
        this.idNopcv = idNopcv;
    }

    public Integer getIdCongviec() {
        return idCongviec;
    }

    public void setIdCongviec(Integer idCongviec) {
        this.idCongviec = idCongviec;
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

    public String getNgaynopcv() {
        return ngaynopcv;
    }

    public void setNgaynopcv(String ngaynopcv) {
        this.ngaynopcv = ngaynopcv;
    }

    public String getTencty() {
        return tencty;
    }

    public void setTencty(String tencty) {
        this.tencty = tencty;
    }

    public String getDiachicty() {
        return diachicty;
    }

    public void setDiachicty(String diachicty) {
        this.diachicty = diachicty;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }
}
