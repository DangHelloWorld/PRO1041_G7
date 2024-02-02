package com.g7.repository.impl;

import com.g7.entity.HoaDonChiTiet;
import com.g7.utils.JdbcHelper;

import java.util.ArrayList;
import java.sql.*;

public class HoaDonCtRepository {

    public ArrayList<HoaDonChiTiet> listHdct;
    Connection con = JdbcHelper.openDbConnection();

    public ArrayList<HoaDonChiTiet> getListHdct(int id) {
        listHdct = new ArrayList<>();
        try {
            String sql = "SELECT [Id], [IdHoaDon], [IdCTSanPham], [SoLuong], [DonGia], [TrangThai] \" +\n"
                    + "             \"FROM [dbo].[HoaDonChiTiet] \" +\n"
                    + "             \"WHERE [IdHoaDon] = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.listHdct.add(new HoaDonChiTiet(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHdct;
    }

    public void setListhdct(ArrayList<HoaDonChiTiet> listHdct) {
        this.listHdct = listHdct;
    }

}
