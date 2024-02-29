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
public class KhuyenMaiViewModel {
    private int id;
    private String ten;
    private int soluong;
    private int soluongSD;
    private boolean kieu;
    private Double mucGiamGia;
    private int trangThai;
    
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
