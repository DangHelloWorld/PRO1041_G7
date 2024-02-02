/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.viewmodel;

import java.sql.Date;
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
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonViewModel {

    private String mahd;
    private String tenNV;
    private String tenKH;
    private Date ngayThanhToan;
    private Date ngayTao;
    private int trangThai;
    private int idhd;
    private Double TongTien;
    private int hinhThucThanhToan;
    private double SoTienDuocGiam;

    public String trangThai(int trangthai) {
        if (trangthai == 1) {
            return "Chưa thanh toán";
        } else {
            return "Đã thanh toán";
        }
    }

}
