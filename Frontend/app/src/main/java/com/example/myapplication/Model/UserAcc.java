package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserAcc implements Serializable {

    @SerializedName("id_user")
    @Expose
    private Integer idUser;

    @SerializedName("hoten")
    @Expose
    private String hoten;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("diachi")
    @Expose
    private String diachi;

    @SerializedName("dienthoai")
    @Expose
    private String dienthoai;

    @SerializedName("gioitinh")
    @Expose
    private String gioitinh;

    @SerializedName("role")
    @Expose
    private Integer role;

    @SerializedName("trangthai")
    @Expose
    private Integer trangthai;

    @SerializedName("ngaysinh")
    @Expose
    private String ngaysinh;
    @SerializedName("tuoi")
    @Expose
    private Integer tuoi;

    @SerializedName("tentrinhdo")
    @Expose
    private String tentrinhdo;

    @SerializedName("anh")
    @Expose
    private String anh;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getTentrinhdo() {
        return tentrinhdo;
    }

    public void setTentrinhdo(String tentrinhdo) {
        this.tentrinhdo = tentrinhdo;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }


}
