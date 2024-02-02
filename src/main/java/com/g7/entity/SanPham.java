package com.g7.entity;

public class SanPham {

    private int idSanPham, idNhaSX, idDanhMuc, idChatLieu;
    private String tenSanPham, tenNhaSX, tenChatLieu, tenDanhMuc;

    public SanPham() {
    }

    public SanPham(int idSanPham, int idNhaSX, int idDanhMuc, int idChatLieu, String tenSanPham, String tenNhaSX, String tenChatLieu, String tenDanhMuc) {
        this.idSanPham = idSanPham;
        this.idNhaSX = idNhaSX;
        this.idDanhMuc = idDanhMuc;
        this.idChatLieu = idChatLieu;
        this.tenSanPham = tenSanPham;
        this.tenNhaSX = tenNhaSX;
        this.tenChatLieu = tenChatLieu;
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdNhaSX() {
        return idNhaSX;
    }

    public void setIdNhaSX(int idNhaSX) {
        this.idNhaSX = idNhaSX;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenNhaSX() {
        return tenNhaSX;
    }

    public void setTenNhaSX(String tenNhaSX) {
        this.tenNhaSX = tenNhaSX;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

}
