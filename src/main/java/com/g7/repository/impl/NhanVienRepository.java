/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.NhanVien;
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
public class NhanVienRepository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    public List<NhanVien> selectWithPagination(int offset, int fetchSize) {

        String sql = "SELECT NhanVien.Id,NhanVien.TenNhanVien, NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.Email,NhanVien.NgayTao,NhanVien.MatKhau,NhanVien.idChucVU,NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "WHERE NhanVien.TrangThai = 1\n"
                + "ORDER BY NhanVien.Id \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY;";

        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<NhanVien> selectWithPaginationNoActive(int offset, int fetchSize) {

        String sql = "SELECT NhanVien.Id,NhanVien.TenNhanVien, NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.Email,NhanVien.NgayTao,NhanVien.MatKhau,NhanVien.idChucVU,NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "WHERE NhanVien.TrangThai = 0\n"
                + "ORDER BY NhanVien.Id \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY;";

        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getTotalItems() {
        String sqlCount = "select count(*) from dbo.NhanVien where NhanVien.Trangthai = 1";

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
        String sql = "SELECT COUNT(*) FROM NhanVien WHERE TrangThai = 0;";

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

    public int insert(Object o) {
        String sql = "INSERT INTO NhanVien(TenNhanVien,GioiTinh,NgaySinh,SoDienThoai,DiaChi,Email,NgayTao,MatKhau,IdChucVU)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            NhanVien nv = (NhanVien) o;
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTenNhanVien());
            preparedStatement.setInt(2, nv.getGioiTinh());
            preparedStatement.setDate(3, (Date) nv.getNgaySinh());
            preparedStatement.setString(4, nv.getSDT());
            preparedStatement.setString(5, nv.getDiaChi());
            preparedStatement.setString(6, nv.getEmail());
            preparedStatement.setDate(7, (Date) nv.getNgayTao());
            preparedStatement.setString(8, nv.getMatKhau());
            preparedStatement.setInt(9, nv.getChucVu());
            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int update(Object o) {
        String sql = "UPDATE NhanVien SET TenNhanVien = ?, GioiTinh = ?, NgaySinh = ?, SoDienThoai = ?, DiaChi = ?, Email = ?, MatKhau = ?, IdChucVU = ?\n"
                + "WHERE ID =?";
        try {
            NhanVien nv = (NhanVien) o;
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTenNhanVien());
            preparedStatement.setInt(2, nv.getGioiTinh());
            preparedStatement.setDate(3, (Date) nv.getNgaySinh());
            preparedStatement.setString(4, nv.getSDT());
            preparedStatement.setString(5, nv.getDiaChi());
            preparedStatement.setString(6, nv.getEmail());
            preparedStatement.setString(7, nv.getMatKhau());
            preparedStatement.setInt(8, nv.getChucVu());
            preparedStatement.setInt(9, nv.getIDNhanVien());

            preparedStatement.executeUpdate();

            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int remove(int id) {
        String sql = "UPDATE NhanVien SET TrangThai = 0\n"
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

    public boolean ktrEmail(String Email) {
        String sql = "SELECT * FROM NhanVien WHERE Email = ?";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareCall(sql);
            preparedStatement.setString(1, Email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public NhanVien findById(int id) {
        String sql = "SELECT Id,TenNhanVien,GioiTinh,NgaySinh,SoDienThoai,DiaChi,Email,NgayTao,MatKhau,IdChucVU,TrangThai FROM NhanVien \n"
                + "WHERE Id = " + id;

        NhanVien entity = new NhanVien();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public List<NhanVien> findByEmail(String email, int offset, int fetchSize) {

        String sql = "SELECT NhanVien.Id,NhanVien.TenNhanVien, NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.Email,NhanVien.NgayTao,NhanVien.MatKhau,NhanVien.idChucVU,NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "WHERE NhanVien.TrangThai = 1 AND NhanVien.Email LIKE ?\n"
                + "ORDER BY NhanVien.Id \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY;";

        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, email, offset, fetchSize);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<NhanVien> findByTenNV(String tenNV, int offset, int fetchSize) {

        String sql = "SELECT NhanVien.Id,NhanVien.TenNhanVien, NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.Email,NhanVien.NgayTao,NhanVien.MatKhau,NhanVien.idChucVU,NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "WHERE NhanVien.TrangThai = 1 AND NhanVien.TenNhanVien LIKE ?\n"
                + "ORDER BY NhanVien.Id \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY;";

        tenNV = "%" + tenNV + "%";

        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, tenNV, offset, fetchSize);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<NhanVien> findBySDT(String SDT, int offset, int fetchSize) {

        String sql = "SELECT NhanVien.Id,NhanVien.TenNhanVien, NhanVien.GioiTinh,NhanVien.NgaySinh,NhanVien.SoDienThoai,NhanVien.DiaChi,NhanVien.Email,NhanVien.NgayTao,NhanVien.MatKhau,NhanVien.idChucVU,NhanVien.TrangThai\n"
                + "FROM NhanVien\n"
                + "WHERE NhanVien.TrangThai = 1 AND NhanVien.SoDienThoai LIKE ?\n"
                + "ORDER BY NhanVien.Id \n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY;";

        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, SDT, offset, fetchSize);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public NhanVien selectAccout(String eMail, String passWord) {
        NhanVien entity = new NhanVien();
        entity.setChucVu(-1);
        String sql
                = "SELECT Id, "
                + "TenNhanVien, "
                + "GioiTinh,"
                + " NgaySinh,"
                + " SoDienThoai,"
                + " DiaChi,"
                + " Email,"
                + " NgayTao,"
                + " MatKhau,"
                + " idChucVU,"
                + " TrangThai"
                + " FROM NhanVien"
                + " WHERE TrangThai = 1"
                + " AND Email =?"
                + " AND MatKhau =? ";
        try {
            ResultSet rs = JdbcHelper.query(sql, eMail, passWord);
            while (rs.next()) {
                entity.setIDNhanVien(rs.getInt(1));
                entity.setTenNhanVien(rs.getString(2));
                entity.setGioiTinh(rs.getInt(3));
                entity.setNgaySinh(rs.getDate(4));
                entity.setSDT(rs.getString(5));
                entity.setDiaChi(rs.getString(6));
                entity.setEmail(rs.getString(7));
                entity.setNgayTao(rs.getDate(8));
                entity.setMatKhau(rs.getString(9));
                entity.setChucVu(rs.getInt(10));
                entity.setTrangThai(rs.getInt(11));
                return entity;
            }
        } catch (SQLException e) {
            System.out.println("Lỗi LoGin: " + e.getMessage());
            entity.setChucVu(-2);
            return entity;
        }
        return entity;
    }
}
