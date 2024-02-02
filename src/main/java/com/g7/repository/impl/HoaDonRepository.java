package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.utils.JdbcHelper;
import com.g7.viewmodel.GioHangViewModel;
import com.g7.viewmodel.HoaDonViewModel;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {

    ArrayList<HoaDon> listHoaDon;
    Connection con = JdbcHelper.openDbConnection();

    String select_Pagination_gh = "SELECT \n"
            + "    dbo.ChiTietSanPham.MaSanPham, \n"
            + "    dbo.SanPham.TenSanPham, \n"
            + "    dbo.HoaDonChiTiet.SoLuong, \n"
            + "    dbo.HoaDonChiTiet.DonGia, \n"
            + "    dbo.HoaDonChiTiet.id,\n"
            + "    dbo.KichCo.KichCo,\n"
            + "    dbo.MauSac.TenMauSac,\n"
            + "    dbo.DanhMuc.TenDanhMuc,\n"
            + "    dbo.NSX.TenNSX\n"
            + "FROM dbo.HoaDonChiTiet\n"
            + "LEFT JOIN dbo.HoaDon ON dbo.HoaDonChiTiet.IdHoaDon = dbo.HoaDon.Id\n"
            + "LEFT JOIN dbo.ChiTietSanPham ON dbo.HoaDonChiTiet.IdCTSanPham = dbo.ChiTietSanPham.Id\n"
            + "LEFT JOIN dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "LEFT JOIN dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id\n"
            + "LEFT JOIN dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id\n"
            + "LEFT JOIN dbo.DanhMuc ON dbo.SanPham.idDanhMuc = dbo.DanhMuc.Id\n"
            + "LEFT JOIN dbo.NSX ON dbo.SanPham.idNSX = dbo.NSX.Id\n"
            + "WHERE dbo.HoaDon.Id = ?\n"
            + "AND dbo.HoaDonChiTiet.TrangThai = 1;";

//    public ArrayList<HoaDon> getlistHoaDon() {
//        listHoaDon = new ArrayList();
//        try {
//            String sql = "SELECT HoaDon.Id, HoaDon.MaHD, HoaDon.NgayTao, HoaDon.NgayThanhToan,HoaDon.TongTien, HoaDon.SoTienDuocGiam,\n"
//                    + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, .HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai \n"
//                    + "FROM HoaDon\n"
//                    + "Inner JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String maHD = rs.getString(2);
//                String ngayTao = rs.getString(3);
//                String ngayThanhToan = rs.getString(4);
//                BigDecimal tongTien = rs.getBigDecimal(5);
//                BigDecimal soTienGiam = rs.getBigDecimal(6);
//                String ghiChu = rs.getString(7);
//                int trangThai = rs.getInt(8);
//                String idNhanVien = rs.getString(9);
//                String idKhachHang = rs.getString(10);
//                String tenKhachHang = rs.getString(11);
//                String soDienThoai = rs.getString(12);
//
//                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
//                listHoaDon.add(hd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listHoaDon;
//    }
//
    public ArrayList<HoaDon> getlistHoaDon(int page) {
        listHoaDon = new ArrayList();
        try {
            // Số dòng bắt đầu của trang hiện tại

            // Câu lệnh SQL sử dụng OFFSET và FETCH để phân trang
            String sql = "SELECT HoaDon.Id, HoaDon.MaHD, HoaDon.NgayTao, HoaDon.NgayThanhToan, HoaDon.TongTien, HoaDon.SoTienDuocGiam, "
                    + "HoaDon.GhiChu, HoaDon.TrangThai, HoaDon.IdNhanVien, HoaDon.IdKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai "
                    + "FROM HoaDon "
                    + "INNER JOIN KhachHang ON HoaDon.IdKhachHang = KhachHang.Id "
                    + "ORDER BY HoaDon.Id desc "
                    + "OFFSET " + page * 50 + " ROWS FETCH NEXT 50 ROWS ONLY";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String maHD = rs.getString(2);
                String ngayTao = rs.getString(3);
                String ngayThanhToan = rs.getString(4);
                BigDecimal tongTien = rs.getBigDecimal(5);
                BigDecimal soTienGiam = rs.getBigDecimal(6);
                String ghiChu = rs.getString(7);
                int trangThai = rs.getInt(8);
                String idNhanVien = rs.getString(9);
                String idKhachHang = rs.getString(10);
                String tenKhachHang = rs.getString(11);
                String soDienThoai = rs.getString(12);

                HoaDon hd = new HoaDon(id, maHD, ngayTao, ngayThanhToan, tongTien, soTienGiam, ghiChu, trangThai, idKhachHang, idNhanVien, tenKhachHang, soDienThoai);
                listHoaDon.add(hd);
            }
        } catch (SQLException e) {
            System.out.println("lỗi: " + e.getMessage());
        }
        return listHoaDon;
    }

    public List<HoaDonViewModel> selectWithPaginationHDC(int offset, int fetchSize) {
        String sql = "SELECT dbo.HoaDon.Id, dbo.HoaDon.MaHD, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HoaDon.SoTienDuocGiam, dbo.KhachHang.TenKhachHang, dbo.NhanVien.TenNhanVien, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon LEFT JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id LEFT JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
                + "				  WHERE dbo.HoaDon.trangThai = 3\n"
                + "				ORDER BY HoaDon.Id \n"
                + "                OFFSET	? ROWS\n"
                + "                FETCH NEXT ? ROWS ONLY";

        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                HoaDonViewModel entity = new HoaDonViewModel();
                entity.setIdhd(rs.getInt(1));
                entity.setMahd(rs.getString(2));
                entity.setNgayTao(rs.getDate(3));
                entity.setNgayThanhToan(rs.getDate(4));
                entity.setTongTien(rs.getDouble(5));
                entity.setSoTienDuocGiam(rs.getDouble(6));
                entity.setTenKH(rs.getString(7));
                entity.setTenNV(rs.getString(8));
                entity.setTrangThai(rs.getInt(9));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<HoaDonViewModel> selectWithPaginationHDS(String nbd, String nkt, int offset, int fetchSize) {
        String sql = "SELECT dbo.HoaDon.Id, dbo.HoaDon.MaHD, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.TongTien, dbo.HoaDon.SoTienDuocGiam, dbo.KhachHang.TenKhachHang, dbo.NhanVien.TenNhanVien, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon LEFT JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id LEFT JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
                + "				  WHERE dbo.HoaDon.trangThai = 3 AND HoaDon.NgayThanhToan BETWEEN ? AND ?\n"
                + "				ORDER BY HoaDon.Id \n"
                + "                OFFSET	? ROWS\n"
                + "                FETCH NEXT ? ROWS ONLY";

        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, nbd, nkt,offset, fetchSize);
            while (rs.next()) {
                HoaDonViewModel entity = new HoaDonViewModel();
                entity.setIdhd(rs.getInt(1));
                entity.setMahd(rs.getString(2));
                entity.setNgayTao(rs.getDate(3));
                entity.setNgayThanhToan(rs.getDate(4));
                entity.setTongTien(rs.getDouble(5));
                entity.setSoTienDuocGiam(rs.getDouble(6));
                entity.setTenKH(rs.getString(7));
                entity.setTenNV(rs.getString(8));
                entity.setTrangThai(rs.getInt(9));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<GioHangViewModel> selectWithPaginationGH(int id) {
        String sql = select_Pagination_gh;

        List<GioHangViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, id);
            while (rs.next()) {
                GioHangViewModel entity = new GioHangViewModel();
                entity.setMasp(rs.getString(1));
                entity.setTensp(rs.getString(2));
                entity.setSoluong(rs.getInt(3));
                entity.setDongia(rs.getDouble(4));
                entity.setId(rs.getInt(5));
                entity.setKickCo(rs.getString(6));
                entity.setMauSac(rs.getString(7));
                entity.setDanhMuc(rs.getString(8));
                entity.setNsx(rs.getString(9));

                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
