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
public class NhanVienViewModel {
    private int id;
    private String ten;
    private int solan;
    private int trangthai;
    
    public String tt(int trangthai){
        if(trangthai == 1){
            return "Còn làm";
        }else{
            return "Nghỉ làm";
        }
    }
    
    
}
