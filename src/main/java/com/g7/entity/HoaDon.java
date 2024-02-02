package com.g7.entity;

import java.math.BigDecimal;
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
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

    private int id;
    private String MaHD;
    private String ngayTao;
    private String ngayThanhToan;
    private BigDecimal tongTien;
    private BigDecimal soTienGiam;
    private String ghiChu;
    private int trangThai;
    private String idKhachHang;
    private String idNhanVien;
     private String tenKhachHang;
      private String soDienThoai;


//    public String trangThai(int trangthai){
//        if(trangthai == 1){
//            return "Chưa thanh toán";
//        }else{
//            return "Đã thanh toán";
//        }
//    }
    public String trangThai(int trangthai){
    switch (trangthai) {
        case 1:
            return "Chưa thanh toán";
        case 3:
            return "Đã thanh toán";
        default:
            return "Trạng thái không xác định";
    }
}
    
}
