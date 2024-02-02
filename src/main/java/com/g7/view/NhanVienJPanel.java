package com.g7.view;

import com.g7.entity.NhanVien;
import com.g7.repository.impl.NhanVienRepository;
import com.g7.utils.MsgBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class NhanVienJPanel extends javax.swing.JPanel {

    private NhanVienRepository NVrepo = new NhanVienRepository();
    private DefaultTableModel defaultTableModelKH = new DefaultTableModel();

    private int ht = 1;
    private int size = 100;
    int index = 0;

    public NhanVienJPanel() {
        initComponents();
        setOpaque(false);
        updatePageInfo();
        findWithPaginationNV(0, size);
        rdbntActive.setSelected(true);
        CalendarNgaySinh.setDateFormatString("dd-MM-yyyy");
    }

    public void findWithPaginationNV(int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<NhanVien> list = NVrepo.selectWithPagination(ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            String gender = null;
            if (x.getGioiTinh() == 1) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            String chucvu = null;
            if (x.getChucVu() <= 100) {
                chucvu = "Quản lý";
            } else {
                chucvu = "Nhân viên";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(),
                x.getTenNhanVien(),
                gender,
                df.format(x.getNgaySinh()),
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(),
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                chucvu,
                status
            });
        }
    }

    public void findWithNoActiveNV(int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<NhanVien> list = NVrepo.selectWithPaginationNoActive(ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            String gender = null;
            if (x.getGioiTinh() == 1) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            String chucvu = null;
            if (x.getChucVu() <= 100) {
                chucvu = "Quản lý";
            } else {
                chucvu = "Nhân viên";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(),
                x.getTenNhanVien(),
                gender,
                df.format(x.getNgaySinh()),
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(),
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                chucvu,
                status
            });
        }
    }

    private void updatePageInfo() {
        int totalItems = NVrepo.getTotalItems();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lbPresentPage.setText(ht + " / " + maxPage);
    }

    private void edit() {
        try {
            int id = (int) tbNhanVien.getValueAt(this.index, 0);
            NhanVien model = NVrepo.findById(id);
            if (model != null) {
                this.setModel(model);

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void setModel(NhanVien model) {
        txtIDNhanVien.setText(String.valueOf(model.getIDNhanVien()));
        txtHoTen.setText(model.getTenNhanVien());
        if (model.getGioiTinh() == 1) {
            ckbNam.setSelected(true);
        } else if (model.getGioiTinh() == 0) {
            ckbNu.setSelected(true);
        }
        CalendarNgaySinh.setDate(model.getNgaySinh());
        txtSDT.setText(model.getSDT());
        txtDiaChi.setText(model.getDiaChi());
        txtEmail.setText(model.getEmail());
        txtMatKhau.setText(model.getMatKhau());
        if (model.getChucVu() <= 100) {
            ckbQuanLy.setSelected(true);
        } else {
            ckbNhanVien.setSelected(true);
        }
    }

    private NhanVien getModel() {
        java.util.Date ngaysinhUtil = (Date) CalendarNgaySinh.getDate();
        java.sql.Date ngaysinh = new java.sql.Date(ngaysinhUtil.getTime());
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        NhanVien model = new NhanVien();
        model.setTenNhanVien(txtHoTen.getText());
        if (ckbNam.isSelected()) {
            model.setGioiTinh(1);
        } else if (ckbNu.isSelected()) {
            model.setGioiTinh(0);
        }
        model.setNgaySinh(ngaysinh);
        model.setSDT(txtSDT.getText());
        model.setDiaChi(txtDiaChi.getText());
        model.setEmail(txtEmail.getText());
        model.setMatKhau(txtMatKhau.getText());
        model.setNgayTao(date);
        if (ckbQuanLy.isSelected()) {
            model.setChucVu(12);
        } else if (ckbNhanVien.isSelected()) {
            model.setChucVu(123);
        }
        return model;

    }

    private void ResetForm() {
        txtIDNhanVien.setText("Không Cần Nhập");
        txtHoTen.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        CalendarNgaySinh.setCalendar(null);
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtConfMatKhau.setText("");
        txtTimKiem.setText("");
    }

    public boolean checkNV() {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        Date date = (Date) CalendarNgaySinh.getDate();
        if (txtHoTen.getText().equals("") || buttonGroup1.getSelection() == null || buttonGroup2.getSelection() == null || date.equals("")
                || txtSDT.equals("") || txtDiaChi.equals("") || txtEmail.equals("") || txtMatKhau.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ dữ liệu", "Error", 1);
            return false;
//        } else if (!(txtEmail.getText()).matches("^ (. +) @ (\\ S +) $.")) {
//            JOptionPane.showMessageDialog(this, "Sai định dạng Email \n VD : abc@def.com", "Error", 1);
//            txtEmail.requestFocus();
//            return false;
        } else if (!(txtSDT.getText()).matches(reg)) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng định dạng số điện thoại", "Error", 1);
            txtSDT.requestFocus();
            return false;
        } else if (!txtMatKhau.getText().equals(txtConfMatKhau.getText())) {
            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không đúng", "Error", 1);
            txtConfMatKhau.requestFocus();
            return false;
        } else if (NVrepo.ktrEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Trùng Email", "Error", 1);
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }

    private void insert() {
        NhanVien model = getModel();
        try {
            NVrepo.insert(model);
            updatePageInfo();
            findWithPaginationNV(0, size);
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    private void update() {
        NhanVien model = getModel();
        int id = Integer.parseInt(txtIDNhanVien.getText());
        model.setIDNhanVien(id);
        try {
            NVrepo.update(model);
            updatePageInfo();
            findWithPaginationNV(0, size);
            MsgBox.alert(this, "Sửa lại thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Sửa lại thất bại!");
        }
    }

    private void delete() {
        if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?")) {
            int id = Integer.parseInt(txtIDNhanVien.getText());
            try {
                NVrepo.remove(id);
                updatePageInfo();
                findWithPaginationNV(0, size);
                ResetForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }

    private boolean checkTimKiem() {
        if (txtTimKiem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập từ khóa", "Error", 1);
            return false;
        }

        return true;
    }

    public void findbyIdNV(int id) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        NhanVien nv = NVrepo.findById(id);
        List<NhanVien> list = new ArrayList<>();
        list.add(nv);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            String gender = null;
            if (x.getGioiTinh() == 1) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            String chucvu = null;
            if (x.getChucVu() <= 100) {
                chucvu = "Quản lý";
            } else {
                chucvu = "Nhân viên";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(),
                x.getTenNhanVien(),
                gender,
                df.format(x.getNgaySinh()),
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(),
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                chucvu,
                status
            });
        }
    }

    public void findbySDT(String sdt, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<NhanVien> list = NVrepo.findBySDT(sdt, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            String gender = null;
            if (x.getGioiTinh() == 1) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            String chucvu = null;
            if (x.getChucVu() <= 100) {
                chucvu = "Quản lý";
            } else {
                chucvu = "Nhân viên";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(),
                x.getTenNhanVien(),
                gender,
                df.format(x.getNgaySinh()),
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(),
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                chucvu,
                status
            });
        }
    }

    public void findbyEmail(String email, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<NhanVien> list = NVrepo.findByEmail(email, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            String gender = null;
            if (x.getGioiTinh() == 1) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            String chucvu = null;
            if (x.getChucVu() <= 100) {
                chucvu = "Quản lý";
            } else {
                chucvu = "Nhân viên";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(),
                x.getTenNhanVien(),
                gender,
                df.format(x.getNgaySinh()),
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(),
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                chucvu,
                status
            });
        }
    }

    public void findbyTenNV(String tenNV, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<NhanVien> list = NVrepo.findByTenNV(tenNV, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbNhanVien.getModel();
        for (NhanVien x : list) {
            String gender = null;
            if (x.getGioiTinh() == 1) {
                gender = "Nam";
            } else {
                gender = "Nữ";
            }
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            String chucvu = null;
            if (x.getChucVu() <= 100) {
                chucvu = "Quản lý";
            } else {
                chucvu = "Nhân viên";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDNhanVien(),
                x.getTenNhanVien(),
                gender,
                df.format(x.getNgaySinh()),
                x.getSDT(),
                x.getDiaChi(),
                x.getEmail(),
                df.format(x.getNgayTao()),
                x.getMatKhau(),
                chucvu,
                status
            });
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        pnlNhanVien = new javax.swing.JPanel();
        bntLamMoi = new javax.swing.JButton();
        lbIDNhanVien = new javax.swing.JLabel();
        bntThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        lbSoDT = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        ckbNam = new javax.swing.JCheckBox();
        ckbNu = new javax.swing.JCheckBox();
        txtSDT = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtIDNhanVien = new javax.swing.JTextField();
        lbHoTen = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        ckbNhanVien = new javax.swing.JCheckBox();
        ckbQuanLy = new javax.swing.JCheckBox();
        lbMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        lbQuanLyNhanVien = new javax.swing.JLabel();
        lbDiaChi1 = new javax.swing.JLabel();
        CalendarNgaySinh = new com.toedter.calendar.JDateChooser();
        lbMatKhau1 = new javax.swing.JLabel();
        txtConfMatKhau = new javax.swing.JTextField();
        pnltbNhanVien = new javax.swing.JPanel();
        rdbntActive = new javax.swing.JRadioButton();
        rdbntNoActive = new javax.swing.JRadioButton();
        bntReloadTB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        bntFirstPage = new javax.swing.JButton();
        bntPrevPage = new javax.swing.JButton();
        bntNextPage = new javax.swing.JButton();
        bntLastPage = new javax.swing.JButton();
        lbPresentPage = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        bntTimKiem = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1083, 643));

        bntLamMoi.setText("Làm mới");
        bntLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLamMoiActionPerformed(evt);
            }
        });

        lbIDNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbIDNhanVien.setText("ID Nhân viên:");

        bntThem.setText("Thêm");
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        bntSua.setText("Sửa");
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEmail.setText("Email:");

        lbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGioiTinh.setText("Giới tính:");

        lbSoDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSoDT.setText("Số điện thoại:");

        buttonGroup1.add(ckbNam);
        ckbNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ckbNam.setText("Nam");

        buttonGroup1.add(ckbNu);
        ckbNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ckbNu.setText("Nữ");

        txtIDNhanVien.setEditable(false);
        txtIDNhanVien.setText("Không Cần Nhập");

        lbHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen.setText("Họ và tên:");

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDiaChi.setText("Địa chỉ:");

        lbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbChucVu.setText("Chức vụ:");

        buttonGroup2.add(ckbNhanVien);
        ckbNhanVien.setText("Nhân viên");

        buttonGroup2.add(ckbQuanLy);
        ckbQuanLy.setText("Quản lý");

        lbMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMatKhau.setText("Mật khẩu:");

        lbQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbQuanLyNhanVien.setText("QUẢN LÝ NHÂN VIÊN");

        lbDiaChi1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDiaChi1.setText("Ngày sinh:");

        lbMatKhau1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMatKhau1.setText("Xác nhận mật khẩu:");

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                                .addComponent(ckbNam)
                                                .addGap(57, 57, 57)
                                                .addComponent(ckbNu)
                                                .addGap(50, 50, 50))
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addComponent(lbIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(txtEmail)
                                    .addComponent(txtMatKhau)))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CalendarNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(ckbNhanVien)
                                        .addGap(57, 57, 57)
                                        .addComponent(ckbQuanLy))
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addComponent(lbMatKhau1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtConfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntLamMoi, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32))))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIDNhanVien)
                    .addComponent(txtIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbHoTen)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbEmail)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbGioiTinh)
                        .addComponent(ckbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ckbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbMatKhau)))
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDiaChi1)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMatKhau1)
                        .addComponent(txtConfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CalendarNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbChucVu)
                        .addComponent(ckbNhanVien)
                        .addComponent(ckbQuanLy))
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbSoDT)))
                .addGap(0, 5, Short.MAX_VALUE))
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(bntThem)
                .addGap(18, 18, 18)
                .addComponent(bntSua)
                .addGap(18, 18, 18)
                .addComponent(bntLamMoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup3.add(rdbntActive);
        rdbntActive.setText("Đang hoạt động");
        rdbntActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdbntActiveMousePressed(evt);
            }
        });

        buttonGroup3.add(rdbntNoActive);
        rdbntNoActive.setText("Dừng hoạt động");
        rdbntNoActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdbntNoActiveMousePressed(evt);
            }
        });

        bntReloadTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntReloadTBActionPerformed(evt);
            }
        });

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID NHÂN VIÊN", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "EMAIL", "NGÀY TẠO", "MẬT KHẨU", "CHỨC VỤ", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbNhanVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        bntFirstPage.setText("|<");
        bntFirstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFirstPageActionPerformed(evt);
            }
        });

        bntPrevPage.setText("<<");
        bntPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPrevPageActionPerformed(evt);
            }
        });

        bntNextPage.setText(">>");
        bntNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextPageActionPerformed(evt);
            }
        });

        bntLastPage.setText(">|");
        bntLastPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLastPageActionPerformed(evt);
            }
        });

        lbPresentPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPresentPage.setText("?");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        bntTimKiem.setText("Tìm kiếm");
        bntTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTimKiemActionPerformed(evt);
            }
        });

        bntXoa.setText("Xóa Nhân Viên");
        bntXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnltbNhanVienLayout = new javax.swing.GroupLayout(pnltbNhanVien);
        pnltbNhanVien.setLayout(pnltbNhanVienLayout);
        pnltbNhanVienLayout.setHorizontalGroup(
            pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltbNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnltbNhanVienLayout.createSequentialGroup()
                        .addComponent(rdbntActive)
                        .addGap(18, 18, 18)
                        .addComponent(rdbntNoActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntReloadTB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnltbNhanVienLayout.createSequentialGroup()
                        .addComponent(bntXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntFirstPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntPrevPage)
                        .addGap(7, 7, 7)
                        .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntNextPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntLastPage)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        pnltbNhanVienLayout.setVerticalGroup(
            pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltbNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbntActive)
                        .addComponent(rdbntNoActive))
                    .addComponent(bntReloadTB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bntTimKiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnltbNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntFirstPage)
                    .addComponent(bntPrevPage)
                    .addComponent(bntNextPage)
                    .addComponent(bntLastPage)
                    .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntXoa))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnltbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnltbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        // TODO add your handling code here:
        try {

            this.update();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi, Vui lòng xem lại");
            e.printStackTrace();
        }
    }//GEN-LAST:event_bntSuaActionPerformed

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        // TODO add your handling code here:
        try {

            if (checkNV()) {
                this.insert();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi, Vui lòng xem lại");
            e.printStackTrace();
        }
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLamMoiActionPerformed
        // TODO add your handling code here:
        ResetForm();
        findWithPaginationNV(0, size);
        updatePageInfo();
    }//GEN-LAST:event_bntLamMoiActionPerformed

    private void bntTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText();
        try {
            if (checkTimKiem()) {
                if (txtTimKiem.getText().matches("^(0|\\+84|\\84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
                    findbySDT(keyword, 0, size);
                } else if (txtTimKiem.getText().contains("@gmail.com")) {
                    findbyEmail(keyword, 0, size);
                } else if (txtTimKiem.getText().matches("\\d{4}") || txtTimKiem.getText().matches("\\d{3}") || txtTimKiem.getText().matches("\\d{2}") || txtTimKiem.getText().matches("\\d{1}")) {
                    findbyIdNV(Integer.parseInt(keyword));
                } else {
                    findbyTenNV(keyword, 0, size);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_bntTimKiemActionPerformed

    private void bntFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFirstPageActionPerformed
        // TODO add your handling code here:
        ht = 1;
        findWithPaginationNV(0, size);
        updatePageInfo();
    }//GEN-LAST:event_bntFirstPageActionPerformed

    private void bntPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPrevPageActionPerformed
        // TODO add your handling code here:
        if (ht > 1) {
            ht--;
        }
        int page = (ht - 1) * size;
        findWithPaginationNV(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntPrevPageActionPerformed

    private void bntNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextPageActionPerformed
        // TODO add your handling code here:
        int TotalItime = NVrepo.getTotalItems();
        int TotalPage = TotalItime / size;
        System.out.println(TotalItime);
        System.out.println(TotalPage);
        if (ht < TotalPage) {
            ht++;
            int page = (ht - 1) * size;
            findWithPaginationNV(page, size);
            updatePageInfo();

        } else {
            ht = 1;
            findWithPaginationNV(0, size);
            updatePageInfo();
        }
    }//GEN-LAST:event_bntNextPageActionPerformed

    private void bntLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLastPageActionPerformed
        // TODO add your handling code here:
        int totalItems = NVrepo.getTotalItems();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        ht = lastPage;
        int page = (ht - 1) * size;
        findWithPaginationNV(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntLastPageActionPerformed

    private void tbNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMousePressed
        // TODO add your handling code here:
        this.index = tbNhanVien.rowAtPoint(evt.getPoint());
        this.edit();
        
    }//GEN-LAST:event_tbNhanVienMousePressed

    private void bntXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntXoaActionPerformed
        // TODO add your handling code here:
        try {

            this.delete();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi, Vui lòng xem lại");
            e.printStackTrace();
        }
    }//GEN-LAST:event_bntXoaActionPerformed

    private void bntReloadTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntReloadTBActionPerformed
        // TODO add your handling code here:
        txtTimKiem.setText("");
        updatePageInfo();
        findWithPaginationNV(0, size);
    }//GEN-LAST:event_bntReloadTBActionPerformed

    private void rdbntActiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbntActiveMousePressed
        // TODO add your handling code here:
        findWithPaginationNV(0, size);
        updatePageInfo();
    }//GEN-LAST:event_rdbntActiveMousePressed

    private void rdbntNoActiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbntNoActiveMousePressed
        // TODO add your handling code here:
        findWithNoActiveNV(0, size);
        int totalItems = NVrepo.getNoActiveTotal();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lbPresentPage.setText(ht + " / " + maxPage);
    }//GEN-LAST:event_rdbntNoActiveMousePressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bntTimKiemActionPerformed(e);
            }
        };
        txtTimKiem.addActionListener(action);
        bntTimKiem.addActionListener(action);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CalendarNgaySinh;
    private javax.swing.JButton bntFirstPage;
    private javax.swing.JButton bntLamMoi;
    private javax.swing.JButton bntLastPage;
    private javax.swing.JButton bntNextPage;
    private javax.swing.JButton bntPrevPage;
    private javax.swing.JButton bntReloadTB;
    private javax.swing.JButton bntSua;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntTimKiem;
    private javax.swing.JButton bntXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox ckbNam;
    private javax.swing.JCheckBox ckbNhanVien;
    private javax.swing.JCheckBox ckbNu;
    private javax.swing.JCheckBox ckbQuanLy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbDiaChi1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbIDNhanVien;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbMatKhau1;
    private javax.swing.JLabel lbPresentPage;
    private javax.swing.JLabel lbQuanLyNhanVien;
    private javax.swing.JLabel lbSoDT;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnltbNhanVien;
    private javax.swing.JRadioButton rdbntActive;
    private javax.swing.JRadioButton rdbntNoActive;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtConfMatKhau;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtIDNhanVien;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
