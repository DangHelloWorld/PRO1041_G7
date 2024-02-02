/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.entity;

import java.io.Serializable;

/**
 *
 * @author Ddawng
 */
public class ChucVu implements  Serializable{
    private int IDChucVu;
    private String TenChucVu;
    private int TrangThai;
    
    @Override
    public String toString() { 
        return this.TenChucVu;
    }

    public ChucVu() {
    }

    public ChucVu(int IDChucVu, String TenChucVu, int TrangThai) {
        this.IDChucVu = IDChucVu;
        this.TenChucVu = TenChucVu;
        this.TrangThai = TrangThai;
    }

    public int getIDChucVu() {
        return IDChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setIdChucVu(int idChucVu) {
        this.IDChucVu = idChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
