package com.g7.view;

import com.g7.entity.SanPham;
import com.g7.entity.SanPhamChiTiet;
import com.g7.entity.ThuocTinh;
import com.g7.repository.impl.SanPhamCTRepository;
import com.g7.repository.impl.SanPhamRepository;
import com.g7.repository.impl.ThuocTinhRepository;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SanPhamJPanel extends javax.swing.JPanel {

    public SanPhamJPanel() {
        initComponents();
        openApp();
    }

    SanPhamRepository Service_SanPham = new SanPhamRepository();
    SanPhamCTRepository Service_SanPhamCT = new SanPhamCTRepository();
    ThuocTinhRepository Service_ThuocTinh = new ThuocTinhRepository();

    DefaultTableModel Model = new DefaultTableModel();

    int loc = 0;
    int locCT = 0;
    int locTheo = 0;
    int locTheoCT = 0;
    int indexSP = -1;
    int indexSPCT = -1;
    int indexOffsetSP = 0;
    int indexOffsetSPCT = 0;

    String pathHinhAnh = "";

    private void openApp() {
        loadDataSanPham(Service_SanPham.selectOffset(0));
        loadDataSanPhamCT(Service_SanPhamCT.selectOffset(0));
        loadDataCbo(0);
        loadDataCbo(1);
        loadDataCbo(2);
        loadDataCbo(3);
        loadDataCbo(4);
        loadDataCbo(5);
        lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
        lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
        cbo_Loc.setVisible(false);
        cbo_LocCT.setVisible(false);
    }

    private void loadDataCbo(int loaiTT) {
        switch (loaiTT) {
            case 0 -> {
                cbo_NSX.removeAllItems();;
                cbo_NSX.addItem("Chọn");
                for (Object o : Service_ThuocTinh.selectOffset(0, 0)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_NSX.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 1 -> {
                cbo_DanhMuc.removeAllItems();;
                cbo_DanhMuc.addItem("Chọn");
                for (Object o : Service_ThuocTinh.selectOffset(0, 1)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_DanhMuc.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 2 -> {
                cbo_ChatLieu.removeAllItems();;
                cbo_ChatLieu.addItem("Chọn");
                for (Object o : Service_ThuocTinh.selectOffset(0, 2)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_ChatLieu.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 3 -> {
                cbo_Mau.removeAllItems();;
                cbo_Mau.addItem("Chọn");
                for (Object o : Service_ThuocTinh.selectOffset(0, 3)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_Mau.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 4 -> {
                cbo_KichThuoc.removeAllItems();;
                cbo_KichThuoc.addItem("Chọn");
                for (Object o : Service_ThuocTinh.selectOffset(0, 4)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_KichThuoc.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 5 -> {
                cbo_SanPham.removeAllItems();;
                cbo_SanPham.addItem("Chọn");
                for (SanPham o : Service_SanPham.selectOffset(-1)) {
                    cbo_SanPham.addItem(o.getTenSanPham());
                }
                break;
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPanel = new javax.swing.JTabbedPane();
        Fame_SanPham = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        lbl_5 = new javax.swing.JLabel();
        lbl_IDSanPham = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        lbl_TieuDe = new javax.swing.JLabel();
        lbl_2 = new javax.swing.JLabel();
        lbl_6 = new javax.swing.JLabel();
        lbl_9 = new javax.swing.JLabel();
        btn_Xoa = new javax.swing.JButton();
        btn_VeCuoi = new javax.swing.JButton();
        btn_VeSau = new javax.swing.JButton();
        btn_VeTruoc = new javax.swing.JButton();
        btn_VeDau = new javax.swing.JButton();
        btn_XemCTSP = new javax.swing.JButton();
        btn_ThemChatLieu = new javax.swing.JButton();
        btn_ThemDanhMuc = new javax.swing.JButton();
        btn_ThemNSX = new javax.swing.JButton();
        btn_Moi = new javax.swing.JButton();
        btn_ThemSp = new javax.swing.JButton();
        btn_SuaSp = new javax.swing.JButton();
        cbo_ChatLieu = new javax.swing.JComboBox<>();
        cbo_NSX = new javax.swing.JComboBox<>();
        cbo_DanhMuc = new javax.swing.JComboBox<>();
        SP1 = new javax.swing.JScrollPane();
        tbl_DanhSachSP = new javax.swing.JTable();
        txt_TenSanPham = new javax.swing.JTextField();
        lbl_TrangSo = new javax.swing.JLabel();
        txt_TimKiemSP = new javax.swing.JTextField();
        lbl_8 = new javax.swing.JLabel();
        cbo_LocTheo = new javax.swing.JComboBox<>();
        lbl_7 = new javax.swing.JLabel();
        cbo_Loc = new javax.swing.JComboBox<>();
        Fame_SanPhamCT = new javax.swing.JPanel();
        lbl_14 = new javax.swing.JLabel();
        lbl_IDSPCT = new javax.swing.JLabel();
        lbl_12 = new javax.swing.JLabel();
        lbl_17 = new javax.swing.JLabel();
        lbl_15 = new javax.swing.JLabel();
        lbl_10 = new javax.swing.JLabel();
        lbl_13 = new javax.swing.JLabel();
        lbl_TieuDe1 = new javax.swing.JLabel();
        lbl_11 = new javax.swing.JLabel();
        lbl_18 = new javax.swing.JLabel();
        lbl_TenSPCT = new javax.swing.JLabel();
        lbl_19 = new javax.swing.JLabel();
        lbl_20 = new javax.swing.JLabel();
        btn_VeTruoc1 = new javax.swing.JButton();
        btn_VeDau1 = new javax.swing.JButton();
        btn_SuaCT = new javax.swing.JButton();
        btn_XoaCT = new javax.swing.JButton();
        btn_VeCuoiCT = new javax.swing.JButton();
        btn_VeSauCT = new javax.swing.JButton();
        btn_MoiCT = new javax.swing.JButton();
        btn_ThemCT = new javax.swing.JButton();
        btn_ThemMau = new javax.swing.JButton();
        btn_ThemKichThuoc = new javax.swing.JButton();
        cbo_KichThuoc = new javax.swing.JComboBox<>();
        cbo_SanPham = new javax.swing.JComboBox<>();
        cbo_Mau = new javax.swing.JComboBox<>();
        txt_SoLuongCT = new javax.swing.JTextField();
        txt_GiaBanCT = new javax.swing.JTextField();
        SP3 = new javax.swing.JScrollPane();
        txt_GhiChuCT = new javax.swing.JTextArea();
        SP4 = new javax.swing.JScrollPane();
        tbl_DanhSachSPCT = new javax.swing.JTable();
        HinhAnh = new javax.swing.JPanel();
        lbl_HinhAnh = new javax.swing.JLabel();
        btn_Anh = new javax.swing.JButton();
        txt_MaSanPham = new javax.swing.JTextField();
        txt_TimKiemSPCT = new javax.swing.JTextField();
        lbl_16 = new javax.swing.JLabel();
        cbo_LocTheoCT = new javax.swing.JComboBox<>();
        lbl_21 = new javax.swing.JLabel();
        cbo_LocCT = new javax.swing.JComboBox<>();
        lbl_TrangCTSo = new javax.swing.JLabel();

        TabPanel.setBackground(new java.awt.Color(255, 255, 255));

        Fame_SanPham.setBackground(new java.awt.Color(255, 255, 255));

        lbl_1.setText("ID Sản Phẩm:");

        lbl_5.setText("Danh Mục:");

        lbl_IDSanPham.setText("Không Cần Nhập");

        lbl_4.setText("Tên Sản Phẩm:");

        lbl_TieuDe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TieuDe.setText("Quản Lý Sản Phẩm");

        lbl_2.setText("Nhà Sản Xuất:");

        lbl_6.setText("Chất Liệu:");

        lbl_9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_9.setText("Chọn Sản Phẩm Để Xem Sản Phẩm Chi Tiết");

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_VeCuoi.setText(">>");
        btn_VeCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeCuoiActionPerformed(evt);
            }
        });

        btn_VeSau.setText(">");
        btn_VeSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeSauActionPerformed(evt);
            }
        });

        btn_VeTruoc.setText("<");
        btn_VeTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeTruocActionPerformed(evt);
            }
        });

        btn_VeDau.setText("<<");
        btn_VeDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeDauActionPerformed(evt);
            }
        });

        btn_XemCTSP.setText("Xem Chi Tiết");
        btn_XemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemCTSPActionPerformed(evt);
            }
        });

        btn_ThemChatLieu.setText("+");
        btn_ThemChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemChatLieuActionPerformed(evt);
            }
        });

        btn_ThemDanhMuc.setText("+");
        btn_ThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemDanhMucActionPerformed(evt);
            }
        });

        btn_ThemNSX.setText("+");
        btn_ThemNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNSXActionPerformed(evt);
            }
        });

        btn_Moi.setText("Mới");
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });

        btn_ThemSp.setText("Thêm");
        btn_ThemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSpActionPerformed(evt);
            }
        });

        btn_SuaSp.setText("Sửa");
        btn_SuaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSpActionPerformed(evt);
            }
        });

        cbo_ChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_ChatLieu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbo_ChatLieuFocusGained(evt);
            }
        });

        cbo_NSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_NSX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbo_NSXFocusGained(evt);
            }
        });

        cbo_DanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_DanhMuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbo_DanhMucFocusGained(evt);
            }
        });

        tbl_DanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Nhà SX", "Danh Muc", "Chất Liệu"
            }
        ));
        tbl_DanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhSachSPMouseClicked(evt);
            }
        });
        SP1.setViewportView(tbl_DanhSachSP);
        if (tbl_DanhSachSP.getColumnModel().getColumnCount() > 0) {
            tbl_DanhSachSP.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        txt_TenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TenSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_TenSanPham.setOpaque(true);

        lbl_TrangSo.setText("0/0");

        txt_TimKiemSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TimKiemSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_TimKiemSP.setOpaque(true);
        txt_TimKiemSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKiemSPKeyReleased(evt);
            }
        });

        lbl_8.setText("Tìm Kiếm:");

        cbo_LocTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Nhà Sản Xuất", "Danh Mục", "Chất Liệu" }));
        cbo_LocTheo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_LocTheoItemStateChanged(evt);
            }
        });

        lbl_7.setText("Lọc:");

        cbo_Loc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_Loc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_LocItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout Fame_SanPhamLayout = new javax.swing.GroupLayout(Fame_SanPham);
        Fame_SanPham.setLayout(Fame_SanPhamLayout);
        Fame_SanPhamLayout.setHorizontalGroup(
            Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                .addGap(516, 516, 516)
                .addComponent(lbl_TrangSo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SP1)
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addComponent(lbl_9)
                        .addGap(152, 152, 152)
                        .addComponent(btn_VeDau)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeTruoc)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeSau)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeCuoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_XemCTSP)
                        .addGap(10, 10, 10))
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                                        .addComponent(lbl_1)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_IDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                        .addComponent(lbl_2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_NSX, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(btn_ThemNSX)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                                .addComponent(lbl_8)
                                .addGap(29, 29, 29)
                                .addComponent(txt_TimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_7)
                                .addGap(80, 80, 80)))
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                    .addComponent(lbl_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                    .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_4)
                                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_5)
                                            .addComponent(lbl_6, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGap(29, 29, 29)
                                    .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_TenSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Fame_SanPhamLayout.createSequentialGroup()
                                            .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cbo_ChatLieu, javax.swing.GroupLayout.Alignment.LEADING, 0, 256, Short.MAX_VALUE)
                                                .addComponent(cbo_DanhMuc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btn_ThemDanhMuc, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btn_ThemChatLieu, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                                    .addComponent(btn_ThemSp)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_SuaSp)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_Xoa)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_Moi)))
                            .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                                .addComponent(cbo_LocTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cbo_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59))
        );
        Fame_SanPhamLayout.setVerticalGroup(
            Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamLayout.createSequentialGroup()
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_1)
                            .addComponent(lbl_IDSanPham))
                        .addGap(19, 19, 19)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_2)
                            .addComponent(cbo_NSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemNSX)))
                    .addGroup(Fame_SanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_4)
                            .addComponent(txt_TenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_5)
                            .addComponent(cbo_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemDanhMuc))
                        .addGap(19, 19, 19)
                        .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_6)
                            .addComponent(cbo_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemChatLieu))))
                .addGap(36, 36, 36)
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Moi)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_SuaSp)
                    .addComponent(btn_ThemSp))
                .addGap(35, 35, 35)
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_8)
                    .addComponent(txt_TimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_7)
                    .addComponent(cbo_LocTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SP1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fame_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_XemCTSP)
                        .addComponent(btn_VeCuoi)
                        .addComponent(btn_VeSau)
                        .addComponent(btn_VeTruoc)
                        .addComponent(btn_VeDau))
                    .addComponent(lbl_9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_TrangSo))
        );

        TabPanel.addTab("Sản Phẩm", Fame_SanPham);

        Fame_SanPhamCT.setBackground(new java.awt.Color(255, 255, 255));

        lbl_14.setText("Màu:");

        lbl_IDSPCT.setText("1");

        lbl_12.setText("Ghi Chú:");

        lbl_17.setText("Giá Bán:");

        lbl_15.setText("Kích Thước:");

        lbl_10.setText("ID Sản Phẩm CT:");

        lbl_13.setText("Tên Sản Phẩm CT:");

        lbl_TieuDe1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_TieuDe1.setText("Sản Phẩm Chi Tiết");

        lbl_11.setText("Sản Phẩm");

        lbl_18.setText("Số Lượng:");

        lbl_TenSPCT.setText("NIKEEE");

        lbl_19.setText("VND");

        lbl_20.setText("Mã Sản Phẩm:");

        btn_VeTruoc1.setText("<");
        btn_VeTruoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeTruoc1ActionPerformed(evt);
            }
        });

        btn_VeDau1.setText("<<");
        btn_VeDau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeDau1ActionPerformed(evt);
            }
        });

        btn_SuaCT.setText("Sửa");
        btn_SuaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaCTActionPerformed(evt);
            }
        });

        btn_XoaCT.setText("Xóa");
        btn_XoaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaCTActionPerformed(evt);
            }
        });

        btn_VeCuoiCT.setText(">>");
        btn_VeCuoiCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeCuoiCTActionPerformed(evt);
            }
        });

        btn_VeSauCT.setText(">");
        btn_VeSauCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VeSauCTActionPerformed(evt);
            }
        });

        btn_MoiCT.setText("Mới");
        btn_MoiCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiCTActionPerformed(evt);
            }
        });

        btn_ThemCT.setText("Thêm");
        btn_ThemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemCTActionPerformed(evt);
            }
        });

        btn_ThemMau.setText("+");
        btn_ThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemMauActionPerformed(evt);
            }
        });

        btn_ThemKichThuoc.setText("+");
        btn_ThemKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKichThuocActionPerformed(evt);
            }
        });

        cbo_KichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_KichThuoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbo_KichThuocFocusGained(evt);
            }
        });

        cbo_SanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_SanPham.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbo_SanPhamFocusGained(evt);
            }
        });

        cbo_Mau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_Mau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbo_MauFocusGained(evt);
            }
        });

        txt_SoLuongCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SoLuongCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_SoLuongCT.setOpaque(true);
        txt_SoLuongCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SoLuongCTKeyReleased(evt);
            }
        });

        txt_GiaBanCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_GiaBanCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_GiaBanCT.setOpaque(true);
        txt_GiaBanCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_GiaBanCTKeyReleased(evt);
            }
        });

        txt_GhiChuCT.setColumns(20);
        txt_GhiChuCT.setRows(5);
        SP3.setViewportView(txt_GhiChuCT);

        tbl_DanhSachSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Sản Phẩm", "Tên", "Màu", "Kích Thước", "Số Lượng", "Giá Bán"
            }
        ));
        tbl_DanhSachSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhSachSPCTMouseClicked(evt);
            }
        });
        SP4.setViewportView(tbl_DanhSachSPCT);
        if (tbl_DanhSachSPCT.getColumnModel().getColumnCount() > 0) {
            tbl_DanhSachSPCT.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        HinhAnh.setBackground(new java.awt.Color(204, 204, 204));
        HinhAnh.setMaximumSize(new java.awt.Dimension(200, 210));

        lbl_HinhAnh.setBackground(new java.awt.Color(0, 0, 0));
        lbl_HinhAnh.setText("                   Không Hiện Thị");
        lbl_HinhAnh.setMaximumSize(new java.awt.Dimension(200, 210));

        javax.swing.GroupLayout HinhAnhLayout = new javax.swing.GroupLayout(HinhAnh);
        HinhAnh.setLayout(HinhAnhLayout);
        HinhAnhLayout.setHorizontalGroup(
            HinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        HinhAnhLayout.setVerticalGroup(
            HinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_HinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_Anh.setText("+");
        btn_Anh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnhActionPerformed(evt);
            }
        });

        txt_TimKiemSPCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TimKiemSPCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_TimKiemSPCT.setOpaque(true);
        txt_TimKiemSPCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKiemSPCTKeyReleased(evt);
            }
        });

        lbl_16.setText("Tìm Kiếm:");

        cbo_LocTheoCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Màu", "Kích Cỡ" }));
        cbo_LocTheoCT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_LocTheoCTItemStateChanged(evt);
            }
        });

        lbl_21.setText("Lọc:");

        cbo_LocCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn" }));
        cbo_LocCT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_LocCTItemStateChanged(evt);
            }
        });

        lbl_TrangCTSo.setText("0/0");

        javax.swing.GroupLayout Fame_SanPhamCTLayout = new javax.swing.GroupLayout(Fame_SanPhamCT);
        Fame_SanPhamCT.setLayout(Fame_SanPhamCTLayout);
        Fame_SanPhamCTLayout.setHorizontalGroup(
            Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(HinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(btn_Anh)))
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(btn_ThemCT)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_SuaCT)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_XoaCT)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_MoiCT))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(lbl_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))))
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                            .addComponent(lbl_10)
                                            .addGap(18, 18, 18)
                                            .addComponent(lbl_IDSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_12)
                                                    .addComponent(SP3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(48, 48, 48))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Fame_SanPhamCTLayout.createSequentialGroup()
                                                .addComponent(lbl_11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbo_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(lbl_20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addComponent(lbl_17)
                                        .addGap(29, 29, 29)
                                        .addComponent(txt_GiaBanCT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_13)
                                            .addComponent(lbl_15)
                                            .addComponent(lbl_14))
                                        .addGap(29, 29, 29)
                                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_TenSPCT)
                                            .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                                    .addGap(99, 99, 99)
                                                    .addComponent(lbl_19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl_18)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txt_SoLuongCT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                                    .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(cbo_KichThuoc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbo_Mau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn_ThemMau)
                                                        .addComponent(btn_ThemKichThuoc)))))))
                                .addGap(1, 1, 1))))
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Fame_SanPhamCTLayout.createSequentialGroup()
                                .addComponent(lbl_16)
                                .addGap(29, 29, 29)
                                .addComponent(txt_TimKiemSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_21)
                                .addGap(80, 80, 80)
                                .addComponent(cbo_LocTheoCT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(cbo_LocCT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SP4, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(btn_VeDau1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeTruoc1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeSauCT)
                        .addGap(18, 18, 18)
                        .addComponent(btn_VeCuoiCT))
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGap(498, 498, 498)
                        .addComponent(lbl_TrangCTSo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Fame_SanPhamCTLayout.setVerticalGroup(
            Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Fame_SanPhamCTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addComponent(lbl_TieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_13)
                                    .addComponent(lbl_TenSPCT))
                                .addGap(19, 19, 19)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_14)
                                    .addComponent(cbo_Mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ThemMau))
                                .addGap(19, 19, 19)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_15)
                                    .addComponent(cbo_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ThemKichThuoc))
                                .addGap(18, 18, 18)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_17)
                                    .addComponent(lbl_18)
                                    .addComponent(txt_GiaBanCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_SoLuongCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_19)))
                            .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_10)
                                    .addComponent(lbl_IDSPCT))
                                .addGap(11, 11, 11)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_20)
                                    .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_11)
                                    .addComponent(cbo_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SP3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Fame_SanPhamCTLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(HinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MoiCT)
                    .addComponent(btn_XoaCT)
                    .addComponent(btn_SuaCT)
                    .addComponent(btn_ThemCT)
                    .addComponent(btn_Anh))
                .addGap(18, 18, 18)
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_16)
                    .addComponent(txt_TimKiemSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_21)
                    .addComponent(cbo_LocTheoCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_LocCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SP4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Fame_SanPhamCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_VeCuoiCT)
                    .addComponent(btn_VeSauCT)
                    .addComponent(btn_VeTruoc1)
                    .addComponent(btn_VeDau1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_TrangCTSo))
        );

        TabPanel.addTab("Chi Tiết Sản Phẩm", Fame_SanPhamCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPanel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNSXActionPerformed
        new viewCRUDThuocTinh(0).setVisible(true);
    }//GEN-LAST:event_btn_ThemNSXActionPerformed

    private void btn_ThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemDanhMucActionPerformed
        new viewCRUDThuocTinh(1).setVisible(true);
    }//GEN-LAST:event_btn_ThemDanhMucActionPerformed

    private void btn_ThemChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemChatLieuActionPerformed
        new viewCRUDThuocTinh(2).setVisible(true);
    }//GEN-LAST:event_btn_ThemChatLieuActionPerformed

    private void btn_ThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemMauActionPerformed
        new viewCRUDThuocTinh(3).setVisible(true);
    }//GEN-LAST:event_btn_ThemMauActionPerformed

    private void btn_ThemKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKichThuocActionPerformed
        new viewCRUDThuocTinh(4).setVisible(true);
    }//GEN-LAST:event_btn_ThemKichThuocActionPerformed

    private void tbl_DanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhSachSPMouseClicked
        indexSP = tbl_DanhSachSP.getSelectedRow();
        showData(Service_SanPham.selectById(Integer.parseInt(tbl_DanhSachSP.getValueAt(indexSP, 0).toString())));
    }//GEN-LAST:event_tbl_DanhSachSPMouseClicked

    private void btn_ThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSpActionPerformed
        SanPham sp = getInputFromSP(false);
        if (sp != null) {
            if (Service_SanPham.create(sp) == 0) {
                JOptionPane.showMessageDialog(this, "Thành Công.");
                loadDataSanPham(Service_SanPham.selectOffset(indexOffsetSP));
                lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
            } else {
                JOptionPane.showMessageDialog(this, "Thất Bại");
            }
        }
        indexSP = -1;
    }//GEN-LAST:event_btn_ThemSpActionPerformed

    private void btn_SuaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSpActionPerformed
        if (indexSP != -1) {
            SanPham sp = getInputFromSP(true);
            if (sp != null) {
                if (Service_SanPham.update(sp) == 0) {
                    JOptionPane.showMessageDialog(this, "Thành Công.");
                    loadDataSanPham(Service_SanPham.selectOffset(indexOffsetSP));
                    indexSP = -1;
                } else {
                    JOptionPane.showMessageDialog(this, "Thất Bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Sản Phẩm.");
        }
    }//GEN-LAST:event_btn_SuaSpActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        if (indexSP != -1) {
            if (Service_SanPham.remove(Integer.parseInt(tbl_DanhSachSP.getValueAt(indexSP, 0).toString())) == 0) {
                JOptionPane.showMessageDialog(this, "Thành Công.");
                lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
                loadDataSanPham(Service_SanPham.selectOffset(indexOffsetSP));
                indexSP = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Thất Bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Sản Phẩm.");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_MoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiActionPerformed
        newForm();
        indexSP = -1;
    }//GEN-LAST:event_btn_MoiActionPerformed

    private void btn_VeDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeDauActionPerformed
        indexOffsetSP = 0;
        loadDataSanPham(Service_SanPham.selectOffset(0));
        lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
    }//GEN-LAST:event_btn_VeDauActionPerformed

    private void btn_VeTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeTruocActionPerformed
        if (indexOffsetSP > 0) {
            indexOffsetSP -= 1;
            loadDataSanPham(Service_SanPham.selectOffset(indexOffsetSP));
            lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
        }
    }//GEN-LAST:event_btn_VeTruocActionPerformed

    private void btn_VeSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeSauActionPerformed
        if (indexOffsetSP < Service_SanPham.soDongData() - 1) {
            indexOffsetSP += 1;
            loadDataSanPham(Service_SanPham.selectOffset(indexOffsetSP));
            lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
        }
    }//GEN-LAST:event_btn_VeSauActionPerformed

    private void btn_VeCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeCuoiActionPerformed
        indexOffsetSP = Service_SanPham.soDongData() - 1;
        loadDataSanPham(Service_SanPham.selectOffset(indexOffsetSP));
        lbl_TrangSo.setText(indexOffsetSP + 1 + "/" + Service_SanPham.soDongData());
    }//GEN-LAST:event_btn_VeCuoiActionPerformed

    private void btn_XemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemCTSPActionPerformed
        loadDataSanPhamCT(Service_SanPhamCT.selectByIdSanPham(Integer.parseInt(tbl_DanhSachSP.getValueAt(indexSP, 0).toString())));
        TabPanel.setSelectedIndex(1);
    }//GEN-LAST:event_btn_XemCTSPActionPerformed

    private void loadDataSanPham(ArrayList<SanPham> list) {
        Model = (DefaultTableModel) tbl_DanhSachSP.getModel();
        Model.setRowCount(0);
        for (SanPham o : list) {
            Model.addRow(new Object[]{
                o.getIdSanPham(),
                o.getTenSanPham(),
                o.getTenNhaSX(),
                o.getTenDanhMuc(),
                o.getTenChatLieu()
            });
        }
    }

    private void newForm() {
        lbl_IDSanPham.setText("Không Cần Nhập");
        cbo_NSX.setSelectedIndex(0);
        cbo_DanhMuc.setSelectedIndex(0);
        cbo_ChatLieu.setSelectedIndex(0);
        txt_TenSanPham.setText("");
    }

    private SanPham getInputFromSP(boolean layID) {
        if (txt_TenSanPham.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập Tên Sản Phẩm.");
            return null;
        }
        if (indexSPCT != -1) {
            if (!txt_TenSanPham.getText().equals(tbl_DanhSachSP.getValueAt(indexSP, 1).toString())) {
                if (Service_SanPham.selectIdByName(txt_TenSanPham.getText()) != -1) {
                    JOptionPane.showMessageDialog(this, "Tên Sản Phầm Đã Tồn Tại");
                    return null;
                }
            }
        } else {
            if (Service_SanPham.selectIdByName(txt_TenSanPham.getText()) != -1) {
                JOptionPane.showMessageDialog(this, "Tên Sản Phầm Đã Tồn Tại");
                return null;
            }
        }
        if (cbo_NSX.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Nhà Sản Xuất.");
            return null;
        }
        if (cbo_DanhMuc.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Danh Mục.");
            return null;
        }
        if (cbo_ChatLieu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Chất Liệu.");
            return null;
        }
        int checkTonTaiTT = Service_SanPham.ktrThuocTinh(
                Service_ThuocTinh.selectIdByName(cbo_NSX.getSelectedItem().toString(), 0),
                Service_ThuocTinh.selectIdByName(cbo_ChatLieu.getSelectedItem().toString(), 2),
                Service_ThuocTinh.selectIdByName(cbo_DanhMuc.getSelectedItem().toString(), 1));
        if (checkTonTaiTT != -1) {
            JOptionPane.showMessageDialog(this, "Sản Phầm Bạn Thêm Đã Trùng Các Thuộc Tính Của Sản Phẩm Có ID Là: " + checkTonTaiTT);
            return null;
        }
        int idSanPham = 0;
        if (layID) {
            idSanPham = Integer.parseInt(tbl_DanhSachSP.getValueAt(indexSP, 0).toString());
        }
        return new SanPham(
                idSanPham,
                Service_ThuocTinh.selectIdByName(cbo_NSX.getSelectedItem().toString(), 0),
                Service_ThuocTinh.selectIdByName(cbo_DanhMuc.getSelectedItem().toString(), 1),
                Service_ThuocTinh.selectIdByName(cbo_ChatLieu.getSelectedItem().toString(), 2),
                txt_TenSanPham.getText(),
                null,
                null,
                null);
    }

    private void showData(SanPham o) {
        txt_TenSanPham.setText(o.getTenSanPham());
        lbl_IDSanPham.setText(String.valueOf(o.getIdSanPham()));
        cbo_ChatLieu.setSelectedItem(o.getTenChatLieu());
        cbo_DanhMuc.setSelectedItem(o.getTenDanhMuc());
        cbo_NSX.setSelectedItem(o.getTenNhaSX());
    }

    //====================================SẢN PHẨM CHI TIẾT===================================================

    private void btn_ThemCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemCTActionPerformed
        SanPhamChiTiet sp = getInputFromSPCT(false);
        if (sp != null) {
            if (Service_SanPhamCT.create(sp) == 0) {
                JOptionPane.showMessageDialog(this, "Thành Công");
                loadDataSanPhamCT(Service_SanPhamCT.selectOffset(indexOffsetSPCT));
                lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
            } else {
                JOptionPane.showMessageDialog(this, "Thất Bại");
            }
        }
    }//GEN-LAST:event_btn_ThemCTActionPerformed

    private void btn_SuaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaCTActionPerformed
        if (indexSPCT != -1) {
            SanPhamChiTiet sp = getInputFromSPCT(true);
            if (sp != null) {
                if (Service_SanPhamCT.update(sp) == 0) {
                    JOptionPane.showMessageDialog(this, "Thành Công");
                    loadDataSanPhamCT(Service_SanPhamCT.selectOffset(indexOffsetSPCT));
                    indexSPCT = -1;
                } else {
                    JOptionPane.showMessageDialog(this, "Thất Bại");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Chi tiết Sản Phẩm");
        }
    }//GEN-LAST:event_btn_SuaCTActionPerformed

    private void btn_XoaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaCTActionPerformed
        if (indexSPCT != -1) {
            if (Service_SanPhamCT.remove(Integer.parseInt(tbl_DanhSachSPCT.getValueAt(indexSPCT, 0).toString())) == 0) {
                JOptionPane.showMessageDialog(this, "Thành Công");
                loadDataSanPhamCT(Service_SanPhamCT.selectOffset(indexOffsetSPCT));
                lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
                indexSPCT = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Thất Bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Chi tiết Sản Phẩm");
        }
    }//GEN-LAST:event_btn_XoaCTActionPerformed

    private void btn_MoiCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiCTActionPerformed
        newFormCT();
    }//GEN-LAST:event_btn_MoiCTActionPerformed

    private void btn_VeDau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeDau1ActionPerformed
        indexOffsetSPCT = 0;
        loadDataSanPhamCT(Service_SanPhamCT.selectOffset(0));
        lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
    }//GEN-LAST:event_btn_VeDau1ActionPerformed

    private void btn_VeTruoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeTruoc1ActionPerformed
        if (indexOffsetSPCT > 0) {
            indexOffsetSPCT -= 1;
            loadDataSanPhamCT(Service_SanPhamCT.selectOffset(indexOffsetSPCT));
            lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
        }
    }//GEN-LAST:event_btn_VeTruoc1ActionPerformed

    private void btn_VeSauCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeSauCTActionPerformed
        if (indexOffsetSPCT < Service_SanPhamCT.soDongData() - 1) {
            indexOffsetSPCT += 1;
            loadDataSanPhamCT(Service_SanPhamCT.selectOffset(indexOffsetSPCT));
            lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
        }
    }//GEN-LAST:event_btn_VeSauCTActionPerformed

    private void btn_VeCuoiCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VeCuoiCTActionPerformed
        indexOffsetSPCT = Service_SanPhamCT.soDongData() - 1;
        loadDataSanPhamCT(Service_SanPhamCT.selectOffset(19));
        lbl_TrangCTSo.setText(indexOffsetSPCT + 1 + "/" + Service_SanPhamCT.soDongData());
    }//GEN-LAST:event_btn_VeCuoiCTActionPerformed

    private void tbl_DanhSachSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhSachSPCTMouseClicked
        indexSPCT = tbl_DanhSachSPCT.getSelectedRow();
        showDataCT(Service_SanPhamCT.selectById(Integer.parseInt(tbl_DanhSachSPCT.getValueAt(indexSPCT, 0).toString())));
    }//GEN-LAST:event_tbl_DanhSachSPCTMouseClicked

    private void btn_AnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnhActionPerformed
        JFileChooser Jfile = new JFileChooser("D:/AVATAR");
        int luaChon = Jfile.showOpenDialog(this);
        if (luaChon == 0) {
            pathHinhAnh = Jfile.getSelectedFile().getPath();
            showHinhAnh();
        }
    }//GEN-LAST:event_btn_AnhActionPerformed

    private void cbo_NSXFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbo_NSXFocusGained
        loadDataCbo(0);
    }//GEN-LAST:event_cbo_NSXFocusGained

    private void cbo_DanhMucFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbo_DanhMucFocusGained
        loadDataCbo(1);

    }//GEN-LAST:event_cbo_DanhMucFocusGained

    private void cbo_ChatLieuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbo_ChatLieuFocusGained
        loadDataCbo(2);
    }//GEN-LAST:event_cbo_ChatLieuFocusGained

    private void cbo_MauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbo_MauFocusGained
        loadDataCbo(3);
    }//GEN-LAST:event_cbo_MauFocusGained

    private void cbo_KichThuocFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbo_KichThuocFocusGained
        loadDataCbo(4);
    }//GEN-LAST:event_cbo_KichThuocFocusGained

    private void cbo_SanPhamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbo_SanPhamFocusGained
        loadDataCbo(5);
    }//GEN-LAST:event_cbo_SanPhamFocusGained

    private void txt_GiaBanCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_GiaBanCTKeyReleased
        String GiaBan = txt_GiaBanCT.getText();
        if (!GiaBan.isEmpty()) {
            try {
                Integer.valueOf(GiaBan);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Giá Bán Chỉ Chứa Số");
                txt_GiaBanCT.setText(GiaBan.substring(0, GiaBan.length() - 1));
            }
        }
    }//GEN-LAST:event_txt_GiaBanCTKeyReleased

    private void txt_SoLuongCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SoLuongCTKeyReleased
        String SoLuong = txt_SoLuongCT.getText();
        if (!SoLuong.isEmpty()) {
            try {
                Integer.valueOf(SoLuong);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Số Lượng Chỉ Chứa Số");
                txt_SoLuongCT.setText(SoLuong.substring(0, SoLuong.length() - 1));
            }
        }
    }//GEN-LAST:event_txt_SoLuongCTKeyReleased

    private void txt_TimKiemSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemSPKeyReleased
        loadDataSanPham(Service_SanPham.listTimKiem(txt_TimKiemSP.getText()));
    }//GEN-LAST:event_txt_TimKiemSPKeyReleased

    private void cbo_LocTheoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_LocTheoItemStateChanged
        cbo_Loc.removeAllItems();
        cbo_Loc.addItem("Tất Cả");
        locTheo = cbo_LocTheo.getSelectedIndex();
        switch (locTheo) {
            case 0 -> {
                cbo_Loc.setVisible(false);
                loadDataSanPham(Service_SanPham.selectOffset(0));
            }
            case 1 -> {
                cbo_Loc.setVisible(true);
                for (Object o : Service_ThuocTinh.selectOffset(0, 0)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_Loc.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 2 -> {
                cbo_Loc.setVisible(true);
                for (Object o : Service_ThuocTinh.selectOffset(0, 1)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_Loc.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 3 -> {
                cbo_Loc.setVisible(true);
                for (Object o : Service_ThuocTinh.selectOffset(0, 2)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_Loc.addItem(sp.getTenThuocTinh());
                }
                break;
            }
        }
    }//GEN-LAST:event_cbo_LocTheoItemStateChanged

    private void cbo_LocTheoCTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_LocTheoCTItemStateChanged
        cbo_LocCT.removeAllItems();
        cbo_LocCT.addItem("Tất Cả");
        locTheoCT = cbo_LocTheoCT.getSelectedIndex();
        switch (locTheoCT) {
            case 0 -> {
                cbo_LocCT.setVisible(false);
                loadDataSanPhamCT(Service_SanPhamCT.selectOffset(indexOffsetSPCT));
            }
            case 1 -> {
                cbo_LocCT.setVisible(true);
                for (Object o : Service_ThuocTinh.selectOffset(0, 3)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_LocCT.addItem(sp.getTenThuocTinh());
                }
                break;
            }
            case 2 -> {
                cbo_LocCT.setVisible(true);
                for (Object o : Service_ThuocTinh.selectOffset(0, 4)) {
                    ThuocTinh sp = (ThuocTinh) o;
                    cbo_LocCT.addItem(sp.getTenThuocTinh());
                }
                break;
            }
        }
    }//GEN-LAST:event_cbo_LocTheoCTItemStateChanged

    private void cbo_LocCTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_LocCTItemStateChanged
        try {
            loadDataSanPhamCT(Service_SanPhamCT.listLoc(locTheoCT, Service_ThuocTinh.selectIdByName(cbo_LocCT.getSelectedItem().toString(), locTheoCT + 2)));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_LocCTItemStateChanged

    private void cbo_LocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_LocItemStateChanged
        try {
            loadDataSanPham(Service_SanPham.listLoc(locTheo, Service_ThuocTinh.selectIdByName(cbo_Loc.getSelectedItem().toString(), locTheo - 1)));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_LocItemStateChanged

    private void txt_TimKiemSPCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemSPCTKeyReleased
        loadDataSanPhamCT(Service_SanPhamCT.listTimKiem(txt_TimKiemSPCT.getText()));
    }//GEN-LAST:event_txt_TimKiemSPCTKeyReleased

    private void loadDataSanPhamCT(ArrayList<SanPhamChiTiet> list) {
        Model = (DefaultTableModel) tbl_DanhSachSPCT.getModel();
        Model.setRowCount(0);
        for (SanPhamChiTiet o : list) {
            Model.addRow(new Object[]{
                o.getIdSanPhamCT(),
                o.getMaSanPham(),
                o.getTenSanPhamCT(),
                o.getMau(),
                o.getKichThuoc(),
                o.getSoLuong(),
                o.getGiaBan()
            }
            );
        }
    }

    private void newFormCT() {
        lbl_IDSPCT.setText("Không Cần Nhập.");
        cbo_SanPham.setSelectedIndex(0);
        cbo_KichThuoc.setSelectedIndex(0);
        cbo_Mau.setSelectedIndex(0);
        txt_GhiChuCT.setText("");
        txt_SoLuongCT.setText("");
        txt_GiaBanCT.setText("");
        txt_MaSanPham.setText("");
        lbl_TenSPCT.setText("");
        lbl_HinhAnh.setIcon(null);
        lbl_HinhAnh.setText("    Chọn Hình Ảnh");
        pathHinhAnh = "";
    }

    private SanPhamChiTiet getInputFromSPCT(boolean layId) {
        if (txt_MaSanPham.getText().length() <= 5) {
            JOptionPane.showMessageDialog(this, "Mã Sản Phẩm Cần Phải Hơn 6 Ký Tự.");
            return null;
        }
        if (!txt_MaSanPham.getText().equals(tbl_DanhSachSPCT.getValueAt(indexSPCT, 1).toString())) {
            if (!Service_SanPhamCT.checkMaSp(txt_MaSanPham.getText())) {
                JOptionPane.showMessageDialog(this, "Mã Sản Phẩm Đã Tồn Tại");
                return null;
            }
        }
        if (cbo_SanPham.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Sản Phẩm.");
            return null;
        }
        if (cbo_Mau.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Màu Sắc.");
            return null;
        }
        if (cbo_KichThuoc.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Kích Thước.");
            return null;
        }
        if (txt_GiaBanCT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập Giá Bán");
            return null;
        }
        if (Integer.parseInt(txt_GiaBanCT.getText()) < 1000) {
            JOptionPane.showMessageDialog(this, "Giá Bán Phải Lớn Hơn 1000");
            return null;
        }
        if (txt_SoLuongCT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập Số Lượng");
            return null;
        }
        if (Integer.parseInt(txt_SoLuongCT.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0");
            return null;
        }
        if (pathHinhAnh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Hình Ảnh.");
            return null;
        }
        int checkThuocTinh = Service_SanPhamCT.checkThuocTinhCT(
                Service_SanPham.selectIdByName(cbo_SanPham.getSelectedItem().toString()),
                Service_ThuocTinh.selectIdByName(cbo_Mau.getSelectedItem().toString(), 3),
                Service_ThuocTinh.selectIdByName(cbo_KichThuoc.getSelectedItem().toString(), 4));
        System.out.println("Id:" + checkThuocTinh);
        if (checkThuocTinh != -1 && checkThuocTinh != Integer.parseInt(tbl_DanhSachSPCT.getValueAt(indexSPCT, 0).toString())) {
            JOptionPane.showMessageDialog(this, "Sản Phẩm Này Đã Tồn Tại, Có Id Là:" + checkThuocTinh);
            return null;
        }
        int idSanPham = 0;
        if (layId) {
            idSanPham = Integer.parseInt(tbl_DanhSachSPCT.getValueAt(indexSPCT, 0).toString());
        }
        System.out.println(pathHinhAnh);
        return new SanPhamChiTiet(
                Service_SanPham.selectIdByName(cbo_SanPham.getSelectedItem().toString()),
                idSanPham,
                Service_ThuocTinh.selectIdByName(cbo_Mau.getSelectedItem().toString(), 3),
                Service_ThuocTinh.selectIdByName(cbo_KichThuoc.getSelectedItem().toString(), 4),
                Integer.parseInt(txt_GiaBanCT.getText()),
                Integer.parseInt(txt_SoLuongCT.getText()),
                null,
                pathHinhAnh,
                null,
                txt_GhiChuCT.getText(),
                null,
                txt_MaSanPham.getText());
    }

    private void showDataCT(SanPhamChiTiet o) {
        lbl_IDSPCT.setText(String.valueOf(o.getIdSanPhamCT()));
        cbo_SanPham.setSelectedItem(o.getTenSanPham());
        cbo_Mau.setSelectedIndex(o.getIdMau());
        cbo_KichThuoc.setSelectedIndex(o.getIdKichThuoc());
        txt_GiaBanCT.setText(String.valueOf(o.getGiaBan()));
        txt_SoLuongCT.setText(String.valueOf(o.getSoLuong()));
        txt_GhiChuCT.setText(o.getGhiChu());
        lbl_TenSPCT.setText(o.getMaSanPham() + "-"
                + cbo_SanPham.getSelectedItem().toString() + " - "
                + cbo_Mau.getSelectedItem().toString() + " - "
                + cbo_KichThuoc.getSelectedItem().toString());
        txt_MaSanPham.setText(o.getMaSanPham());
        pathHinhAnh = o.getHinhAnh();
        showHinhAnh();
    }

    public void showHinhAnh() {
        System.out.println(pathHinhAnh);
        try {
            lbl_HinhAnh.setIcon(new ImageIcon(pathHinhAnh));
            lbl_HinhAnh.setText("");
        } catch (Exception e) {
            lbl_HinhAnh.setText("Không Phải Hình");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fame_SanPham;
    private javax.swing.JPanel Fame_SanPhamCT;
    private javax.swing.JPanel HinhAnh;
    private javax.swing.JScrollPane SP1;
    private javax.swing.JScrollPane SP3;
    private javax.swing.JScrollPane SP4;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JButton btn_Anh;
    private javax.swing.JButton btn_Moi;
    private javax.swing.JButton btn_MoiCT;
    private javax.swing.JButton btn_SuaCT;
    private javax.swing.JButton btn_SuaSp;
    private javax.swing.JButton btn_ThemCT;
    private javax.swing.JButton btn_ThemChatLieu;
    private javax.swing.JButton btn_ThemDanhMuc;
    private javax.swing.JButton btn_ThemKichThuoc;
    private javax.swing.JButton btn_ThemMau;
    private javax.swing.JButton btn_ThemNSX;
    private javax.swing.JButton btn_ThemSp;
    private javax.swing.JButton btn_VeCuoi;
    private javax.swing.JButton btn_VeCuoiCT;
    private javax.swing.JButton btn_VeDau;
    private javax.swing.JButton btn_VeDau1;
    private javax.swing.JButton btn_VeSau;
    private javax.swing.JButton btn_VeSauCT;
    private javax.swing.JButton btn_VeTruoc;
    private javax.swing.JButton btn_VeTruoc1;
    private javax.swing.JButton btn_XemCTSP;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaCT;
    private javax.swing.JComboBox<String> cbo_ChatLieu;
    private javax.swing.JComboBox<String> cbo_DanhMuc;
    private javax.swing.JComboBox<String> cbo_KichThuoc;
    private javax.swing.JComboBox<String> cbo_Loc;
    private javax.swing.JComboBox<String> cbo_LocCT;
    private javax.swing.JComboBox<String> cbo_LocTheo;
    private javax.swing.JComboBox<String> cbo_LocTheoCT;
    private javax.swing.JComboBox<String> cbo_Mau;
    private javax.swing.JComboBox<String> cbo_NSX;
    private javax.swing.JComboBox<String> cbo_SanPham;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_10;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_15;
    private javax.swing.JLabel lbl_16;
    private javax.swing.JLabel lbl_17;
    private javax.swing.JLabel lbl_18;
    private javax.swing.JLabel lbl_19;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_20;
    private javax.swing.JLabel lbl_21;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JLabel lbl_9;
    private javax.swing.JLabel lbl_HinhAnh;
    private javax.swing.JLabel lbl_IDSPCT;
    private javax.swing.JLabel lbl_IDSanPham;
    private javax.swing.JLabel lbl_TenSPCT;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JLabel lbl_TieuDe1;
    private javax.swing.JLabel lbl_TrangCTSo;
    private javax.swing.JLabel lbl_TrangSo;
    private javax.swing.JTable tbl_DanhSachSP;
    private javax.swing.JTable tbl_DanhSachSPCT;
    private javax.swing.JTextArea txt_GhiChuCT;
    private javax.swing.JTextField txt_GiaBanCT;
    private javax.swing.JTextField txt_MaSanPham;
    private javax.swing.JTextField txt_SoLuongCT;
    private javax.swing.JTextField txt_TenSanPham;
    private javax.swing.JTextField txt_TimKiemSP;
    private javax.swing.JTextField txt_TimKiemSPCT;
    // End of variables declaration//GEN-END:variables
}
