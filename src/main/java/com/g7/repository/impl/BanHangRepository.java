/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.g7.repository.impl;

import com.g7.entity.HoaDon;
import com.g7.entity.HoaDonChiTiet;
import com.g7.entity.KhuyenMai;
import com.g7.entity.SanPhamChiTiet;
import com.g7.utils.JdbcHelper;
import com.g7.viewmodel.CTSPBanHangViewModel;
import com.g7.viewmodel.GioHangViewModel;
import com.g7.viewmodel.HoaDonViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ddawng
 */
public class BanHangRepository {

    String select_Pagination_sp = "SELECT dbo.ChiTietSanPham.Id, dbo.ChiTietSanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.KichCo.KichCo, dbo.MauSac.TenMauSac, dbo.DanhMuc.TenDanhMuc, dbo.NSX.TenNSX, dbo.ChiTietSanPham.SoLuong, \n"
            + "                  dbo.ChiTietSanPham.GiaBan\n"
            + "FROM     dbo.ChiTietSanPham LEFT JOIN\n"
            + "                  dbo.DanhMuc ON dbo.ChiTietSanPham.Id = dbo.DanhMuc.Id LEFT JOIN\n"
            + "                  dbo.HinhAnh ON dbo.ChiTietSanPham.IdHinhAnh = dbo.HinhAnh.Id LEFT JOIN\n"
            + "                  dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id LEFT JOIN\n"
            + "                  dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id LEFT JOIN\n"
            + "                  dbo.NSX ON dbo.ChiTietSanPham.Id = dbo.NSX.Id LEFT JOIN\n"
            + "                  dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "				  WHERE ChiTietSanPham.TrangThai = 1		  \n"
            + "				  ORDER BY ID desc \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY;";

    String TotalItems_sp = "SELECT COUNT(*)\n"
            + "FROM     dbo.ChiTietSanPham INNER JOIN\n"
            + "                  dbo.DanhMuc ON dbo.ChiTietSanPham.Id = dbo.DanhMuc.Id LEFT JOIN\n"
            + "                  dbo.HinhAnh ON dbo.ChiTietSanPham.IdHinhAnh = dbo.HinhAnh.Id LEFT JOIN\n"
            + "                  dbo.KichCo ON dbo.ChiTietSanPham.IdKichCo = dbo.KichCo.Id LEFT JOIN\n"
            + "                  dbo.MauSac ON dbo.ChiTietSanPham.IdMauSac = dbo.MauSac.Id LEFT JOIN\n"
            + "                  dbo.NSX ON dbo.ChiTietSanPham.Id = dbo.NSX.Id LEFT JOIN\n"
            + "                  dbo.SanPham ON dbo.ChiTietSanPham.IdSanPham = dbo.SanPham.Id\n"
            + "				  WHERE ChiTietSanPham.TrangThai = 1";

    String select_Pagination_hdc = " SELECT dbo.HoaDon.MaHD, dbo.NhanVien.TenNhanVien, dbo.HoaDon.NgayTao, dbo.KhachHang.TenKhachHang, dbo.HoaDon.TrangThai, dbo.HoaDon.Id\n"
            + "FROM     dbo.HoaDon LEFT JOIN\n"
            + "                  dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id LEFT JOIN\n"
            + "                  dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
            + "				  WHERE HoaDon.TrangThai = 1\n"
            + "				  ORDER BY HoaDon.Id desc \n"
            + "				  OFFSET ? ROWS \n"
            + "				  FETCH NEXT ? ROWS ONLY";

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

    String TotalItimeHDC = " 	  SELECT COUNT(*)\n"
            + "            FROM     dbo.HoaDon LEFT JOIN\n"
            + "                              dbo.KhachHang ON dbo.HoaDon.IdKhachHang = dbo.KhachHang.Id LEFT JOIN\n"
            + "                           dbo.NhanVien ON dbo.HoaDon.IdNhanVien = dbo.NhanVien.Id\n"
            + "            			  WHERE HoaDon.TrangThai = 1";
    String select_byMaHd = "SELECT Id FROM dbo.HoaDon WHERE MaHD = ?";
    String Insert_hd = "INSERT INTO hoadon (IdNhanVien, IdKhachHang, MaHD) VALUES (?,?,?)";
    String select_byKH = " SELECT id FROM dbo.KhachHang WHERE MaKhachHang = ? ";
    String updateSoLuong = "UPDATE ChiTietSanPham SET SoLuong = ? WHERE Id = ?";
    String updateSoLuongGH = "UPDATE hoadonchitiet SET SoLuong = ? WHERE Id = ?";
    String selectID_byMaSP = "SELECT id FROM chitietsanpham WHERE masanpham = ?";
    String updateSoLuongMA = "UPDATE ChiTietSanPham SET SoLuong = ? WHERE maSanPham = ?";
//    String delete_giohang = "update hoadonchitiet set TrangThai = 2 where id = ?";
    String delete_giohang = "delete from hoadonchitiet where id = ?";
    String TotalSL = "select soluong from chitietsanpham where masanpham = ?";
    String select_slSP_HT = "select soluong from chitietsanpham where masanpham = ?";
    String delete_HDCT_ByidHD = "delete from hoadonchitiet where idhoadon = ?";
    String delete_HD_byID = "delete from hoadon where id = ?";
    String update_thanhtoan = "UPDATE HoaDon set NgayThanhToan = GETDATE(), TongTien = ?, IdPhuocThucThanhToan = ?, TrangThai = ? WHERE MaHD = ?";
    String selectMaNV_BySDT = "select makhachhang from khachhang where sodienthoai = ?";
    String selectTenNV_BySDT = "select tenkhachhang from khachhang where sodienthoai = ?";
    String selectMaKH_ByTenKH = "select MaKhachHang FROM khachhang where TenKhachHang = ?";
    String select_Pagination_KM = "select * from khuyenmai where trangthai = 1\n"
            + "ORDER BY ID \n"
            + "OFFSET ? ROWS \n"
            + "FETCH NEXT ? ROWS ONLY";
    String select_KieuGG = "select kieugiamgia from khuyenmai where id =?";
    String select_MucGG = "select mucgiamgia from khuyenmai where id = ?";

    public String selectMucGG(int id) {
        String mucGG = null;
        try {
            ResultSet rs = JdbcHelper.query(select_MucGG, id);

            if (rs.next()) {
                mucGG = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mucGG;
    }

    public int selectKieuGG(int id) {
        int kieuGG = 0;
        try {
            ResultSet rs = JdbcHelper.query(select_KieuGG, id);

            if (rs.next()) {
                kieuGG = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kieuGG;
    }

    public String selectMaKHByTenKH(String tenKH) {
        String ma = null;

        try {
            ResultSet rs = JdbcHelper.query(selectMaKH_ByTenKH, tenKH);

            if (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ma;
    }

    public String selectBySDTnvMa(String sdt) {
        String ma = null;

        try {
            ResultSet rs = JdbcHelper.query(selectMaNV_BySDT, sdt);

            if (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ma;
    }

    public String selectBySDTnvTen(String sdt) {
        String ten = null;

        try {
            ResultSet rs = JdbcHelper.query(selectTenNV_BySDT, sdt);

            if (rs.next()) {
                ten = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ten;
    }

    public String deleteHDCT(int idHD) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(delete_HDCT_ByidHD)) {
            ps.setObject(1, idHD);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Ôi hỏng";
    }

    public String deleteHD(int idHD) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(delete_HD_byID)) {
            ps.setObject(1, idHD);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Ôi hỏng";
    }

    public String deleteGioHang(int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(delete_giohang)) {
            ps.setObject(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("Deleted successfully");
                return "Xóa sản phẩm thành công";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("Delete failed");
        return "Để xác nhận vui lòng chọn lại sản phẩm cần xóa";
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

    public List<HoaDonViewModel> selectWithPaginationHDC(int offset, int fetchSize) {
        String sql = select_Pagination_hdc;

        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                HoaDonViewModel entity = new HoaDonViewModel();
                entity.setMahd(rs.getString(1));
                entity.setTenNV(rs.getString(2));
                entity.setNgayTao(rs.getDate(3));
                entity.setTenKH(rs.getString(4));
                entity.setTrangThai(rs.getInt(5));
                entity.setIdhd(rs.getInt(6));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<CTSPBanHangViewModel> selectWithPagination(int offset, int fetchSize) {

        String sql = select_Pagination_sp;

        List<CTSPBanHangViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                CTSPBanHangViewModel entity = new CTSPBanHangViewModel();
                entity.setId(rs.getString(1));
                entity.setMasp(rs.getString(2));
                entity.setTensp(rs.getString(3));
                entity.setKichco(rs.getString(4));
                entity.setMausac(rs.getString(5));
                entity.setDanhmuc(rs.getString(6));
                entity.setNsx(rs.getString(7));
                entity.setSoluong(rs.getInt(8));
                entity.setGiaban(rs.getDouble(9));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<KhuyenMai> selectWithPaginationKM(int offset, int fetchSize) {
        String sql = select_Pagination_KM;

        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, offset, fetchSize);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setIDKhuyenMai(rs.getInt(1));
                entity.setTenKhuyenMai(rs.getString(2));
                entity.setMoTa(rs.getString(3));
                entity.setKieuGiamGia(rs.getBoolean(4));
                entity.setMucGiamGia(rs.getDouble(5));
                entity.setNgayBatDau(rs.getDate(6));
                entity.setNgayKetThuc(rs.getDate(7));
                entity.setTrangThai(rs.getInt(8));
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
            ResultSet rs = JdbcHelper.query(TotalItems_sp);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }

    public int getTotalItemsHDC() {
        int totalItems = 0;

        try {
            ResultSet rs = JdbcHelper.query(TotalItimeHDC);

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }

    public int selectByMa(String maHd) {
        int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(select_byMaHd, maHd);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public List<HoaDonViewModel> selectBySql(String sql, Object... args) {
        List<HoaDonViewModel> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonViewModel entity = new HoaDonViewModel();
                entity.setIdhd(rs.getInt(1));
                list.add(entity);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int selectMaxIDHD() {
        int id = 0;
        String QuerymaxID = "SELECT MAX(id) FROM HoaDon";
        try {
            ResultSet rs = JdbcHelper.query(QuerymaxID);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public String selectByIdHD(int id) {
        String ma = null;

        String select_ByIDHD = "SELECT MaHD FROM dbo.HoaDon WHERE Id = ?";
        try {
            ResultSet rs = JdbcHelper.query(select_byKH, id);

            if (rs.next()) {
                ma = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ma;
    }

    public String addHoaDon(HoaDon hd) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(Insert_hd)) {

//            String query = "SELECT MAX(MaHD) FROM HoaDon";
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            if (resultSet.next()) {
//                int maxID = resultSet.getInt(1);
//                if (maxID != null) {
//                    int maxMaHDNumber = Integer.parseInt(maxMaHD.replace("HD", ""));
//                    int nextMaHDNumber = maxMaHDNumber + 1;
//                    String nextMaHD = "HD" + String.format("%05d", nextMaHDNumber);
//                    hd.setMaHD(nextMaHD);
//                }
//            }
//            int idmax = selectMaxIDHD();
//            String maHD =  selectByIdHD(idmax);
//            if(maHD != null){
//                int maxMaHDNumber = Integer.parseInt(maHD.replace("HD", ""));
//                int nextMaHDNumber = maxMaHDNumber + 1;
//                String nextMaHD = "HD" + String.format("%03d", nextMaHDNumber);
//                System.out.println(nextMaHD);
//                hd.setMaHD(nextMaHD);
//            }
            ps.setObject(1, hd.getIdNhanVien());
            ps.setObject(2, hd.getIdKhachHang());
            ps.setObject(3, hd.getMaHD());
            if (ps.executeUpdate() > 0) {
                return "Thêm hóa đơn thành công";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Thêm hóa đơn thất bại";
    }

    public int selectIdByMaKH(String makh) {
        int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(select_byKH, makh);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public String updateSoLuong(SanPhamChiTiet ctsp, int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuong)) {
            ps.setObject(1, ctsp.getSoLuong());
            ps.setObject(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String updateSoLuongGH(GioHangViewModel gh, int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuongGH)) {
            ps.setObject(1, gh.getSoluong());
            ps.setObject(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String updateSoLuongTM(SanPhamChiTiet ctsp, String ma) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuongMA)) {
            ps.setObject(1, ctsp.getSoLuong());
            ps.setObject(2, ma);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int selectIdByMaSP(String maSP) {
        int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(selectID_byMaSP, maSP);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public int TongSLTrongCTSP(String maSP) {
        int id = 0;

        try {
            ResultSet rs = JdbcHelper.query(TotalSL, maSP);

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public int getSLHT(String maSP) {
        int sl = 0;

        try {
            ResultSet rs = JdbcHelper.query(select_slSP_HT, maSP);

            if (rs.next()) {
                sl = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sl;
    }

    public String updateSoLuong2(SanPhamChiTiet ctsp, int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(updateSoLuong)) {
            ps.setObject(1, ctsp.getSoLuong());
            ps.setObject(2, id);

            if (ps.executeUpdate() > 0) {
                return "Sửa thành công";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Sửa không thành công";
    }

    public String addHDCT(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO HoaDonChiTiet(IdHoaDon,IdCTSanPham,SoLuong, DonGia) VALUES (?,?,?,?)";
        try (Connection con = JdbcHelper.openDbConnection(); 
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hdct.getIdHoaDon());
            ps.setObject(2, hdct.getIdCtSanPham());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());

            if (ps.executeUpdate() > 0) {
                return "Thêm hóa đơn ct thành công";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thêm hóa đơn ct thất bại";
    }

    private static final String UPDATE_HOADONCHITIET_TRANGTHAI = "UPDATE hoadonchitiet SET TrangThai = 2 WHERE id = ?";

    public String updateHoaDonChiTietTrangThai(int id) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_HOADONCHITIET_TRANGTHAI)) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return "Cập nhật trạng thái thành công";
            } else {
                return "Không tìm thấy hóa đơn chi tiết có ID tương ứng hoặc không có sự thay đổi";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Đã xảy ra lỗi khi cập nhật trạng thái hóa đơn chi tiết", e);
        }
    }

    public String updateThanhToan(HoaDonViewModel hd, String ma) {
        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(update_thanhtoan)) {
            ps.setObject(1, hd.getTongTien());
            ps.setObject(2, hd.getHinhThucThanhToan());
            ps.setObject(3, hd.getTrangThai());
            ps.setObject(4, ma);
            if (ps.executeUpdate() > 0) {
                return "Thành công";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Thất bại";
    }

//    public String deleteSPInGH(int id) {
//        try (Connection con = JdbcHelper.openDbConnection(); PreparedStatement ps = con.prepareStatement(delete_giohang)) {
//            ps.setObject(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
}
