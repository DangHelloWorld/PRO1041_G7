package com.g7.repository.impl;

import com.g7.entity.ThuocTinh;
import com.g7.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThuocTinhRepository implements com.g7.repository.ThuocTinhRepository {

    private Connection connect = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    String tenBang;
    String tenThuocTinh;

    @Override
    public ArrayList selectOffset(int indexOffset, int indexThuocTinh) {
        setUpSql(indexThuocTinh);
        try {
            ArrayList list = new ArrayList();
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement("select id," + tenThuocTinh + " from " + tenBang + " where trangThai=1");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new ThuocTinh(
                        resultSet.getInt(1),
                        resultSet.getString(tenThuocTinh)));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Lỗi C-01: " + e.getMessage());
            return null;
        }
    }

    public int selectIdByName(String tenThuocTinh, int indexThuocTinh) {
        setUpSql(indexThuocTinh);
        try {
            ArrayList list = new ArrayList();
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement("select id  from " + tenBang + " where " + this.tenThuocTinh + "='" + tenThuocTinh + "'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Lỗi C-01: " + e.getMessage());
            return -1;
        }
    }

    @Override
    public int create(Object o, int indexThuocTinh) {
        setUpSql(indexThuocTinh);
        try {
            ArrayList list = new ArrayList();
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement("insert into " + tenBang + "(" + tenThuocTinh + ") values(?)");
            ThuocTinh tt = (ThuocTinh) o;
            preparedStatement.setString(1, tt.getTenThuocTinh());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Lỗi C-02: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int update(Object o, int indexThuocTinh) {
        setUpSql(indexThuocTinh);
        try {
            ArrayList list = new ArrayList();
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement("update " + tenBang + " set " + tenThuocTinh + " =? where id=?");
            ThuocTinh tt = (ThuocTinh) o;
            preparedStatement.setString(1, tt.getTenThuocTinh());
            preparedStatement.setInt(2, tt.getId());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Lỗi C-02: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int remove(int id, int indexThuocTinh) {
        setUpSql(indexThuocTinh);
        try {
            ArrayList list = new ArrayList();
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement("update " + tenBang + " set trangthai=0 where id=" + id);
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Lỗi C-02: " + e.getMessage());
            return 0;
        }
    }

    private void setUpSql(int indexThuocTinh) {
        switch (indexThuocTinh) {
            case 0 -> {
                tenBang = "NSX";
                tenThuocTinh = "tenNSX";
            }
            case 1 -> {
                tenBang = "DanhMuc";
                tenThuocTinh = "tenDanhMuc";
            }
            case 2 -> {
                tenBang = "ChatLieu";
                tenThuocTinh = "tenChatLieu";
            }
            case 3 -> {
                tenBang = "MauSac";
                tenThuocTinh = "tenMauSac";
            }
            case 4 -> {
                tenBang = "KichCo";
                tenThuocTinh = "KichCo";
            }
        }
    }

    public int ktrTonTaiTT(int indexThuocTinh, String tenThuocTinh) {
        setUpSql(indexThuocTinh);
        try {
            connect = JdbcHelper.openDbConnection();
            preparedStatement = connect.prepareStatement("select id from " + tenBang + " where trangThai=1 and " + this.tenThuocTinh + "='" + tenThuocTinh + "'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Lỗi C-05: " + e.getMessage());
            return -1;
        }
    }

}
