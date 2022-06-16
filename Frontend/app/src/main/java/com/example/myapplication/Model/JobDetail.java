package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JobDetail implements Serializable {

    @SerializedName("id_congviec")
    @Expose
    private Integer idCongviec;
    @SerializedName("tenjob")
    @Expose
    private String tenjob;
    @SerializedName("id_congty")
    @Expose
    private Integer idCongty;
    @SerializedName("tendanhmuc")
    @Expose
    private String tendanhmuc;
    @SerializedName("tenloaicv")
    @Expose
    private String tenloaicv;
    @SerializedName("tenloaihinhcv")
    @Expose
    private String tenloaihinhcv;
    @SerializedName("tentrinhdo")
    @Expose
    private String tentrinhdo;
    @SerializedName("gioitinh")
    @Expose
    private Object gioitinh;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("kinhnghiemchitiet")
    @Expose
    private String kinhnghiemchitiet;
    @SerializedName("ngaybatdau")
    @Expose
    private String ngaybatdau;
    @SerializedName("ngayketthuc")
    @Expose
    private String ngayketthuc;
    @SerializedName("minsalary")
    @Expose
    private Integer minsalary;
    @SerializedName("maxsalary")
    @Expose
    private Integer maxsalary;
    @SerializedName("soluongtuyendung")
    @Expose
    private Integer soluongtuyendung;

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

    public Integer getIdCongty() {
        return idCongty;
    }

    public void setIdCongty(Integer idCongty) {
        this.idCongty = idCongty;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getTenloaicv() {
        return tenloaicv;
    }

    public void setTenloaicv(String tenloaicv) {
        this.tenloaicv = tenloaicv;
    }

    public String getTenloaihinhcv() {
        return tenloaihinhcv;
    }

    public void setTenloaihinhcv(String tenloaihinhcv) {
        this.tenloaihinhcv = tenloaihinhcv;
    }

    public String getTentrinhdo() {
        return tentrinhdo;
    }

    public void setTentrinhdo(String tentrinhdo) {
        this.tentrinhdo = tentrinhdo;
    }

    public Object getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Object gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getKinhnghiemchitiet() {
        return kinhnghiemchitiet;
    }

    public void setKinhnghiemchitiet(String kinhnghiemchitiet) {
        this.kinhnghiemchitiet = kinhnghiemchitiet;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
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

}
