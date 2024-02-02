/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.HoaDonChiTiet;
import com.g7.entity.KhuyenMai;
import com.g7.repository.G7Repository;
import com.g7.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng Nguyễn
 */
public class KhuyenMaiRepository extends G7Repository<KhuyenMai, Integer> {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    String INSERT_KM = "INSERT [dbo].[KhuyenMai] ([TenKhuyenMai], [MoTa], [SoLuong], [KieuGiamGia], [MucGiamGia], [NgayBatDau], [NgayKetThuc]) VALUES (?,?,?,?,?,?,?)";
    String UPDATE_KM = "UPDATE KhuyenMai set TenKhuyenMai = ?, MoTa = ?, SoLuong = ?, KieuGiamGia = ?, MucGiamGia = ?, NgayBatDau = ?, NgayKetThuc = ? Where Id = ?";
    String DELETE_KM = "UPDATE KhuyenMai set TrangThai = 0 where Id = ?";
    String SELECT_ALL_KM = "select * from KhuyenMai where TrangThai = '1'";
    String SELECT_BY_ID_SQL = "select * from KhuyenMai where TenKhuyenMai = ?";

    public void insert(KhuyenMai entity) {
        JdbcHelper.update(INSERT_KM, entity.getTenKhuyenMai(), entity.getMoTa(),entity.getSoLuong() ,entity.isKieuGiamGia(), entity.getMucGiamGia(), entity.getNgayBatDau(), entity.getNgayKetThuc());
    }

    @Override
    public void update(KhuyenMai entity) {
        JdbcHelper.update(UPDATE_KM, entity.getTenKhuyenMai(), entity.getMoTa(),entity.getSoLuong(), entity.isKieuGiamGia(), entity.getMucGiamGia(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getIDKhuyenMai());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_KM, id);
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return this.selectBySql(SELECT_ALL_KM);
    }

    @Override
    public KhuyenMai selectById(Integer id) {
        List<KhuyenMai> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setIDKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setMoTa(rs.getString(3));
                km.setSoLuong(rs.getInt(4));
                km.setKieuGiamGia(rs.getBoolean(5));
                km.setMucGiamGia(rs.getDouble(6));
                km.setNgayBatDau(rs.getDate(7));
                km.setNgayKetThuc(rs.getDate(8));
                km.setTrangThai(rs.getInt(9));
                list.add(km);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void update21(String entity) {
        JdbcHelper.update(DELETE_KM, entity);
    }


    public List<KhuyenMai> selectWithPagination(int offset, int fetchSize) {
            String sql = "SELECT KhuyenMai.Id, KhuyenMai.TenKhuyenMai, KhuyenMai.MoTa,KhuyenMai.SoLuong, KhuyenMai.KieuGiamGia, KhuyenMai.MucGiamGia, KhuyenMai.NgayBatDau, KhuyenMai.NgayKetThuc, KhuyenMai.TrangThai FROM KhuyenMai\n"
                + "WHERE TrangThai = 1\n"
                + "ORDER BY KhuyenMai.Id\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {                
                KhuyenMai km = new KhuyenMai();
                km.setIDKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setMoTa(rs.getString(3));
                km.setSoLuong(rs.getInt(4));
                km.setKieuGiamGia(rs.getBoolean(5));
                km.setMucGiamGia(rs.getDouble(6));
                km.setNgayBatDau(rs.getDate(7));
                km.setNgayKetThuc(rs.getDate(8));
                km.setTrangThai(rs.getInt(9));
                list.add(km);   
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<KhuyenMai> selectWithPaginationNoActive(int offset, int fetchSize) {
        String sql = "SELECT KhuyenMai.Id, KhuyenMai.TenKhuyenMai, KhuyenMai.MoTa,KhuyenMai.SoLuong, KhuyenMai.KieuGiamGia, KhuyenMai.MucGiamGia, KhuyenMai.NgayBatDau, KhuyenMai.NgayKetThuc, KhuyenMai.TrangThai FROM KhuyenMai\n"
                + "WHERE TrangThai = 0\n"
                + "ORDER BY KhuyenMai.Id\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {                
                KhuyenMai km = new KhuyenMai();
                km.setIDKhuyenMai(rs.getInt(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setMoTa(rs.getString(3));
                km.setSoLuong(rs.getInt(4));
                km.setKieuGiamGia(rs.getBoolean(5));
                km.setMucGiamGia(rs.getDouble(6));
                km.setNgayBatDau(rs.getDate(7));
                km.setNgayKetThuc(rs.getDate(8));
                km.setTrangThai(rs.getInt(9));
                list.add(km);   
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
    public int getTotalItems() {
        String sqlCount = "select count(*) from dbo.KhuyenMai where KhuyenMai.Trangthai = 1";

        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(sqlCount);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }
    
    
    public int getNoActiveTotal(){
        String sql = "SELECT COUNT(*) FROM KhuyenMai WHERE TrangThai = 0;";
        
        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(sql);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }
    
    
    
    

}
