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
public class NhanVien implements Serializable {

    private int IDNhanVien;
    private String TenNhanVien;
    private int GioiTinh;
    private Date NgaySinh;
    private String SDT;
    private String DiaChi;
    private String Email;
    private Date NgayTao;
    private String MatKhau;
    private int ChucVu;
    private int TrangThai;

    @Override
    public String toString() {
        return this.TenNhanVien;
    }

    
    public NhanVien() {
    }

    public NhanVien(int IDNhanVien, String TenNhanVien, int GioiTinh, Date NgaySinh, String SDT, String DiaChi, String Email, Date NgayTao, String MatKhau, int ChucVu, int TrangThai) {
        this.IDNhanVien = IDNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.NgayTao = NgayTao;
        this.MatKhau = MatKhau;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
    }

    public int getIDNhanVien() {
        return IDNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setIDNhanVien(int IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

}
