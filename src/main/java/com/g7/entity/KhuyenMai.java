/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ddawng
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {
    private int IDKhuyenMai;
    private String TenKhuyenMai;
    private boolean KieuGiamGia;
    private double MucGiamGia;
    private int SoLuong;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private String MoTa;
    private int TrangThai;

    public KhuyenMai(int IDKhuyenMai, String TenKhuyenMai, boolean KieuGiamGia, double MucGiamGia,int SoLuong, Date NgayBatDau, Date NgayKetThuc, String MoTa) {
        this.IDKhuyenMai = IDKhuyenMai;
        this.TenKhuyenMai = TenKhuyenMai;
        this.KieuGiamGia = KieuGiamGia;
        this.MucGiamGia = MucGiamGia;
        this.SoLuong = SoLuong;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.MoTa = MoTa;
    }

    
   public String KieuKM(boolean k){
       if(k == true){
           return "VND";
       }else{
           return "%";
       }
   }
    

    public String trangThai(int trangThai){
        if (trangThai == 1) {
            return "Đang hoạt động";
        }else{
            return "Ngừng hoạt động";
        }
    }
}
