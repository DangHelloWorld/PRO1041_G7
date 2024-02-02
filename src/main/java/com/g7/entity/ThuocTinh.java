package com.g7.entity;
public class ThuocTinh {
    int id;
    String tenThuocTinh;

    public ThuocTinh() {
    }

    public ThuocTinh(int id, String tenThuocTinh) {
        this.id = id;
        this.tenThuocTinh = tenThuocTinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThuocTinh() {
        return tenThuocTinh;
    }

    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }
    
    
    
}
