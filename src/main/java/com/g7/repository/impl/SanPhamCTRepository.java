package com.g7.repository.impl;

import com.g7.entity.SanPhamChiTiet;
import com.g7.repository.SP_SPCT_Repository;
import com.g7.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamCTRepository implements SP_SPCT_Repository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public ArrayList<SanPhamChiTiet> selectOffset(int indexOffset) {
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "                         CTS.[Id] AS ChiTietSanPham_Id,\n"
                + "                         CTS.IdSanPham AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         CTS.IdKichCo AS KichCo_Id,\n"
                + "                         KC.KichCo,\n"
                + "                         CTS.IdMauSac AS MauSac_Id,\n"
                + "                         MS.TenMauSac,\n"
                + "                         HA.TenHinhAnh,\n"
                + "                         CTS.GiaBan,\n"
                + "                         CTS.SoLuong,\n"
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
                + "                     FROM\n"
                + "                         ChiTietSanPham CTS\n"
                + "                     JOIN\n"
                + "                         SanPham SP ON CTS.IdSanPham = SP.Id\n"
                + "                     JOIN\n"
                + "                         KichCo KC ON CTS.IdKichCo = KC.Id\n"
                + "                     JOIN\n"
                + "                         MauSac MS ON CTS.IdMauSac = MS.Id\n"
                + "                     JOIN\n"
                + "                         HinhAnh HA ON CTS.IdHinhAnh = HA.Id\n"
                + "                     WHERE\n"
                + "                         CTS.TrangThai = 1 And SP.TrangThai=1\n"
                + "                     ORDER BY\n"
                + "                         CTS.Id DESC\n"
                + "                     OFFSET " + (indexOffset * 5) + "0 ROWS\n"
                + "                     FETCH NEXT 50 ROWS ONLY;";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenHinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi B-01: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<SanPhamChiTiet> selectByIdSanPham(int idSanPham) {
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "                         CTS.[Id] AS ChiTietSanPham_Id,\n"
                + "                         CTS.IdSanPham AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         CTS.IdKichCo AS KichCo_Id,\n"
                + "                         KC.KichCo,\n"
                + "                         CTS.IdMauSac AS MauSac_Id,\n"
                + "                         MS.TenMauSac,\n"
                + "                         HA.HinhAnh,\n"
                + "                         CTS.GiaBan,\n"
                + "                         CTS.SoLuong,\n"
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
                + "                     FROM\n"
                + "                         ChiTietSanPham CTS\n"
                + "                     JOIN\n"
                + "                         SanPham SP ON CTS.IdSanPham = SP.Id\n"
                + "                     JOIN\n"
                + "                         KichCo KC ON CTS.IdKichCo = KC.Id\n"
                + "                     JOIN\n"
                + "                         MauSac MS ON CTS.IdMauSac = MS.Id\n"
                + "                     JOIN\n"
                + "                         HinhAnh HA ON CTS.IdHinhAnh = HA.Id\n"
                + "                     WHERE\n"
                + "                         CTS.TrangThai = 1 And SP.TrangThai=1 "
                + "                         And CTS.IdSanPham=?\n"
                + "                     ORDER BY\n"
                + "                         CTS.Id DESC";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, idSanPham);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("HinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi B-01: " + e.getMessage());
            return null;
        }
    }

    public SanPhamChiTiet selectById(int id) {
        String sql = "SELECT\n"
                + "                         CTS.[Id] AS ChiTietSanPham_Id,\n"
                + "                         CTS.IdSanPham AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         CTS.IdKichCo AS KichCo_Id,\n"
                + "                         KC.KichCo,\n"
                + "                         CTS.IdMauSac AS MauSac_Id,\n"
                + "                         MS.TenMauSac,\n"
                + "                         HA.HinhAnh,\n"
                + "                         CTS.GiaBan,\n"
                + "                         CTS.SoLuong,\n"
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
                + "                     FROM\n"
                + "                         ChiTietSanPham CTS\n"
                + "                     JOIN\n"
                + "                         SanPham SP ON CTS.IdSanPham = SP.Id\n"
                + "                     JOIN\n"
                + "                         KichCo KC ON CTS.IdKichCo = KC.Id\n"
                + "                     JOIN\n"
                + "                         MauSac MS ON CTS.IdMauSac = MS.Id\n"
                + "                     JOIN\n"
                + "                         HinhAnh HA ON CTS.IdHinhAnh = HA.Id\n"
                + "                     WHERE\n"
                + "                         CTS.TrangThai = 1 and CTS.id=\n" + id
                + "                     ORDER BY\n"
                + "                         CTS.Id \n";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            SanPhamChiTiet sp = null;
            while (resultSet.next()) {
                sp = new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("HinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham"));
            }
            return sp;
        } catch (SQLException e) {
            System.out.println("Lỗi B-05: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int create(Object o) {
        String sql = "INSERT INTO ChiTietSanPham\n"
                + "           (IdSanPham\n"
                + "           ,IdKichCo\n"
                + "           ,IdMauSac\n"
                + "           ,IdHinhAnh\n"
                + "           ,GiaBan\n"
                + "           ,SoLuong\n"
                + "           ,MoTa"
                + "           ,MaSanPham)  \n"
                + "     VALUES "
                + "  (?,?,?,?,?,?,?,?)";
        try {
            SanPhamChiTiet sp = (SanPhamChiTiet) o;

            int idHinhAnh = createImage(sp.getHinhAnh(), "HinhAnh-" + sp.getMaSanPham());
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, sp.getIdSanPham());
            preparedStatement.setInt(2, sp.getIdKichThuoc());
            preparedStatement.setInt(3, sp.getIdMau());
            preparedStatement.setInt(4, idHinhAnh);
            preparedStatement.setInt(5, sp.getGiaBan());
            preparedStatement.setInt(6, sp.getSoLuong());
            preparedStatement.setString(7, sp.getGhiChu());
            preparedStatement.setString(8, sp.getMaSanPham());

            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi B-02: " + e.getMessage());
            return 1;
        }
    }

    public int createImage(String path, String tenHinhAnh) {
        String sql = "INSERT INTO HinhAnh(hinhanh, tenhinhanh) OUTPUT INSERTED.id VALUES (?, ?)";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, path);
            preparedStatement.setString(2, tenHinhAnh);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                throw new SQLException("Lỗi: Không thể lấy ID sau khi thêm hình ảnh.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi B-09: " + e.getMessage());
        }
        return -1; // hoặc giá trị mặc định khác tùy vào yêu cầu của bạn
    }

    @Override
    public int update(Object o) {
        String sql = "update chitietsanpham set idsanpham=?,idkichco=?,idmausac=?,idhinhanh=?,giaban=?,soluong=?,mota=?,masanpham=? where id=?";

        try {
            SanPhamChiTiet sp = (SanPhamChiTiet) o;
            int idHinhAnh = createImage(sp.getHinhAnh(), "Hinh Anh "+sp.getMaSanPham());
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, sp.getIdSanPham());
            preparedStatement.setInt(2, sp.getIdKichThuoc());
            preparedStatement.setInt(3, sp.getIdMau());
            preparedStatement.setInt(4,idHinhAnh);
            preparedStatement.setInt(5, sp.getGiaBan());
            preparedStatement.setInt(6, sp.getSoLuong());
            preparedStatement.setString(7, sp.getGhiChu());
            preparedStatement.setString(8, sp.getMaSanPham());
            preparedStatement.setInt(9, sp.getIdSanPhamCT());

            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi B-03:" + e.getMessage());
            return 1;
        }
    }

    @Override
    public int remove(int id) {
        String sql = "update chitietsanpham set trangthai=0 where id=" + id;
        try {

            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);

            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            System.out.println("Lỗi B-04:" + e.getMessage());
            return 1;
        }
    }

    public int checkThuocTinhCT(int idSanPham, int idMau, int idKichThuoc) {
        System.out.println(idSanPham + "+" + idMau + "+" + idKichThuoc);
        String sql = "Select id from chitietsanpham where idSanPham=? and idmausac=? and idkichco=?;";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, idSanPham);
            preparedStatement.setInt(2, idMau);
            preparedStatement.setInt(3, idKichThuoc);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                return resultSet.getInt("id");
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Lỗi B-06:" + e.getMessage());
            return -1;
        }
    }

    public boolean checkMaSp(String maSp) {
        String sql = "select id from chitietsanpham where masanpham='" + maSp + "'";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi B-07:" + e.getMessage());
            return false;
        }
    }

    public ArrayList<SanPhamChiTiet> listTimKiem(String tuKhoa) {
        System.out.println(tuKhoa);
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "                         CTS.[Id] AS ChiTietSanPham_Id,\n"
                + "                         CTS.IdSanPham AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         CTS.IdKichCo AS KichCo_Id,\n"
                + "                         KC.KichCo,\n"
                + "                         CTS.IdMauSac AS MauSac_Id,\n"
                + "                         MS.TenMauSac,\n"
                + "                         HA.TenHinhAnh,\n"
                + "                         CTS.GiaBan,\n"
                + "                         CTS.SoLuong,\n"
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
                + "                     FROM\n"
                + "                         ChiTietSanPham CTS\n"
                + "                     JOIN\n"
                + "                         SanPham SP ON CTS.IdSanPham = SP.Id\n"
                + "                     JOIN\n"
                + "                         KichCo KC ON CTS.IdKichCo = KC.Id\n"
                + "                     JOIN\n"
                + "                         MauSac MS ON CTS.IdMauSac = MS.Id\n"
                + "                     JOIN\n"
                + "                         HinhAnh HA ON CTS.IdHinhAnh = HA.Id\n"
                + "                     WHERE\n"
                + "                         CTS.TrangThai = 1 "
                + "                         And SP.TrangThai=1\n"
                + "                         AND "
                + "                         (CTS.MaSanPham LIKE ? "
                + "                         OR SP.TenSanPham LIKE ?"
                + "                         OR KC.KichCo LIKE ?"
                + "                         OR MS.TenMauSac LIKE ?"
                + "                         OR CTS.MoTa LIKE ? "
                + "                         OR CTS.GiaBan=?"
                + "                         OR CTS.SoLuong=?"
                + "                         OR CTS.[Id]=?)"
                + "                     ORDER BY\n"
                + "                         CTS.Id \n";

        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, "%" + tuKhoa + "%");
            preparedStatement.setString(2, "%" + tuKhoa + "%");
            preparedStatement.setString(3, "%" + tuKhoa + "%");
            preparedStatement.setString(4, "%" + tuKhoa + "%");
            preparedStatement.setString(5, "%" + tuKhoa + "%");
            try {
                int tuKhoaInt = Integer.parseInt(tuKhoa);
                preparedStatement.setInt(6, tuKhoaInt);
                preparedStatement.setInt(7, tuKhoaInt);
                preparedStatement.setInt(8, tuKhoaInt);
            } catch (NumberFormatException | SQLException e) {
                preparedStatement.setInt(6, -1);
                preparedStatement.setInt(7, -1);
                preparedStatement.setInt(8, -1);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenHinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi B-07: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<SanPhamChiTiet> listLoc(int locTheo, int idLoc) {
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "                         CTS.[Id] AS ChiTietSanPham_Id,\n"
                + "                         CTS.IdSanPham AS SanPham_Id,\n"
                + "                         SP.TenSanPham,\n"
                + "                         CTS.IdKichCo AS KichCo_Id,\n"
                + "                         KC.KichCo,\n"
                + "                         CTS.IdMauSac AS MauSac_Id,\n"
                + "                         MS.TenMauSac,\n"
                + "                         HA.TenHinhAnh,\n"
                + "                         CTS.GiaBan,\n"
                + "                         CTS.SoLuong,\n"
                + "                         CTS.MoTa,\n"
                + "                         CTS.MaSanPham"
                + "                     FROM\n"
                + "                         ChiTietSanPham CTS\n"
                + "                     JOIN\n"
                + "                         SanPham SP ON CTS.IdSanPham = SP.Id\n"
                + "                     JOIN\n"
                + "                         KichCo KC ON CTS.IdKichCo = KC.Id\n"
                + "                     JOIN\n"
                + "                         MauSac MS ON CTS.IdMauSac = MS.Id\n"
                + "                     JOIN\n"
                + "                         HinhAnh HA ON CTS.IdHinhAnh = HA.Id\n"
                + "                     WHERE\n"
                + "                         CTS.TrangThai = 1 "
                + "                         And SP.TrangThai=1";

        switch (locTheo) {
            case 1 -> {
                sql += " AND CTS.IdMauSac = ? ";
                break;
            }
            case 2 -> {
                sql += " AND CTS.IdKichCo = ? ";
                break;
            }
        }

        sql += " ORDER BY CTS.Id";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement(sql);
            if (locTheo != 0) {
                preparedStatement.setInt(1, idLoc);
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new SanPhamChiTiet(
                        resultSet.getInt("SanPham_Id"),
                        resultSet.getInt("ChiTietSanPham_Id"),
                        resultSet.getInt("MauSac_Id"),
                        resultSet.getInt("KichCo_Id"),
                        resultSet.getInt("GiaBan"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getString("TenSanPham"),
                        resultSet.getString("TenHinhAnh"),
                        resultSet.getString("TenMauSac"),
                        resultSet.getString("MoTa"),
                        resultSet.getString("KichCo"),
                        resultSet.getString("MaSanPham")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi B-08: " + e.getMessage());
            return null;
        }
    }

    public int soDongData() {
        String sql = "select count(*) as soDong from chitietsanpham where trangThai=1";
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("soDong") % 50 != 0) {
                    return resultSet.getInt("soDong") / 50;
                } else {
                    return resultSet.getInt("soDong") / 50 - 1;
                }
            }
            return -1;
        } catch (SQLException e) {
            return -1;
        }
    }
}
