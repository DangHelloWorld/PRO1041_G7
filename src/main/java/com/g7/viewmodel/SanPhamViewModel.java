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
public class SanPhamViewModel {
    private int id;
    private String tensp;
    private int soluong;
    private Double tongTien;
    private int trangthai;
    
    public String tt(int trangthai){
        if(trangthai == 1){
            return "Còn Bán";
        }else{
            return "Ngừng bán";
        } 
    }
    
}
