/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ddawng
 */
public class KhachHang implements Serializable {

    private int IDKhachHang;
    private String MaKhachHang;
    private String TenKhachHang;
    private String SDT;
    private Date NgayTao;
    private int TrangThai;

    @Override
    public String toString() {
        return this.TenKhachHang;
    }

    public KhachHang() {
    }

    public KhachHang(int IDKhachHang, String maKH, String TenKhachHang, String SDT, Date NgayTao, int TrangThai) {
        this.IDKhachHang = IDKhachHang;
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.SDT = SDT;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public String getSDT() {
        return SDT;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }
}
