/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.KhachHang;
import com.g7.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class KhachHangRepository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    String select_Pagination_kh = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
            + "FROM dbo.KhachHang\n"
            + "WHERE dbo.KhachHang.TrangThai = 1 ORDER BY ID\n"
            + "OFFSET ? ROWS\n"
            + "FETCH NEXT  ? ROWS ONLY;";

    String sqlCount = "select count(*) from dbo.KhachHang where KhachHang.Trangthai = 1";

    public List<KhachHang> selectWithPagination(int offset, int fetchSize) {

        String sql = select_Pagination_kh;

        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> selectWithPaginationNoActive(int offset, int fetchSize) {

        String sql = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
                + "FROM dbo.KhachHang\n"
                + "WHERE dbo.KhachHang.TrangThai = 0 ORDER BY ID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT  ? ROWS ONLY;";

        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getTotalItems() {
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

    public int getNoActiveTotal() {
        String sql = "SELECT COUNT(*) FROM KhachHang WHERE TrangThai = 0;";

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

    public int create(Object o) {
        String sql = "INSERT INTO KhachHang(MaKhachHang,TenKhachHang,SoDienThoai,NgayTao)\n"
                + "VALUES(?,?,?,?);";
        try {
            KhachHang kh = (KhachHang) o;
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, kh.getMaKhachHang());
            preparedStatement.setString(2, kh.getTenKhachHang());
            preparedStatement.setString(3, kh.getSDT());
            preparedStatement.setDate(4, (Date) kh.getNgayTao());

            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int update(Object o) {
        String sql = "UPDATE KhachHang SET MaKhachHang = ?, TenKhachHang = ?, SoDienThoai = ?\n"
                + "WHERE ID = ?;";
        try {
            KhachHang kh = (KhachHang) o;
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, kh.getMaKhachHang());
            preparedStatement.setString(2, kh.getTenKhachHang());
            preparedStatement.setString(3, kh.getSDT());
            preparedStatement.setInt(4, kh.getIDKhachHang());

            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int remove(int id) {
        String sql = "UPDATE KhachHang SET TrangThai = 0\n"
                + "WHERE ID = " + id;
        try {
            connect = JdbcHelper.openDbConnection();

            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public boolean ktrMaKH(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareCall(sql);
            preparedStatement.setString(1, maKH);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public KhachHang findById(int id) {
        String sql = "SELECT Id,MaKhachHang,TenKhachHang,SoDienThoai,NgayTao,TrangThai FROM KhachHang \n"
                + "WHERE id =" + id;

        KhachHang entity = new KhachHang();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public List<KhachHang> findByMaKH(String maKH, int offset, int fetchSize) {

        String sql = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
                + "FROM dbo.KhachHang\n"
                + "WHERE dbo.KhachHang.TrangThai = 1 AND dbo.KhachHang.MaKhachHang LIKE ?\n"
                + "ORDER BY ID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT  ? ROWS ONLY";

        maKH = "%" + maKH + "%";

        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, maKH, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> findByTenKH(String tenKH, int offset, int fetchSize) {

        String sql = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
                + "FROM dbo.KhachHang\n"
                + "WHERE dbo.KhachHang.TrangThai = 1 AND dbo.KhachHang.TenKhachHang LIKE ?\n"
                + "ORDER BY ID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT  ? ROWS ONLY";

        tenKH = "%" + tenKH + "%";
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, tenKH, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> findBySDT(String SDT, int offset, int fetchSize) {

        String sql = "SELECT dbo.KhachHang.id,dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,dbo.KhachHang.SoDienThoai,dbo.KhachHang.NgayTao,dbo.KhachHang.TrangThai\n"
                + "FROM dbo.KhachHang\n"
                + "WHERE dbo.KhachHang.TrangThai = 1 AND dbo.KhachHang.SoDienThoai LIKE ?\n"
                + "ORDER BY ID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT  ? ROWS ONLY";
        
        SDT = "%" + SDT + "%";
        
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, SDT, offset, fetchSize);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                entity.setMaKhachHang(rs.getString(2));
                entity.setTenKhachHang(rs.getString(3));
                entity.setSDT(rs.getString(4));
                entity.setNgayTao(rs.getDate(5));
                entity.setTrangThai(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setIDKhachHang(rs.getInt(1));
                list.add(entity);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
