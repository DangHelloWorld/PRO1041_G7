/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.viewmodel;

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
public class GioHangViewModel {

    private int id;
    private String masp;
    private String tensp;
    private int soluong;
    private Double dongia;
    private String KickCo;
    private String MauSac;
    private String DanhMuc;
    private String nsx;

    public GioHangViewModel(int soluong) {
        this.soluong = soluong;
    }

}
