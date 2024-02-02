package com.g7.view;

import com.g7.entity.KhachHang;
import com.g7.repository.impl.KhachHangRepository;
import com.g7.utils.MsgBox;
import java.awt.event.ActionEvent;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhachHangJPanel extends javax.swing.JPanel {

    private KhachHangRepository KHrepo = new KhachHangRepository();
    private DefaultTableModel defaultTableModelKH = new DefaultTableModel();

    private int ht = 1;
    private int size = 100;
    int index = 0;

    public KhachHangJPanel() {
        initComponents();
        setOpaque(false);

        updatePageInfo();
        findWithPaginationKH(0, size);
        rdbntActive.setSelected(true);
    }

    public void findWithPaginationKH(int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<KhachHang> list = KHrepo.selectWithPagination(ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), status
            });
        }
    }

    public void findWithNoActiveKH(int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<KhachHang> list = KHrepo.selectWithPaginationNoActive(ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), status
            });
        }
    }

    public void findByIdKH(int id) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        KhachHang kh = KHrepo.findById(id);
        List<KhachHang> list = new ArrayList<>();
        list.add(kh);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), status
            });
        }
    }

    public void findByMaKH(String maKH, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<KhachHang> list = KHrepo.findByMaKH(maKH, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), status
            });
        }
    }

    public void findByTenKH(String tenKH, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<KhachHang> list = KHrepo.findByTenKH(tenKH, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), status
            });
        }
    }

    public void findbySDT(String sdt, int ht, int c) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat f = new DecimalFormat("#,##0.##");
        List<KhachHang> list = KHrepo.findBySDT(sdt, ht, c);
        defaultTableModelKH.setRowCount(0);
        defaultTableModelKH = (DefaultTableModel) tbKhachHang.getModel();
        for (KhachHang x : list) {
            String status = null;
            if (x.getTrangThai() == 1) {
                status = "Đang hoạt động";
            } else {
                status = "Dừng hoạt động";
            }
            defaultTableModelKH.addRow(new Object[]{
                x.getIDKhachHang(), x.getMaKhachHang(), x.getTenKhachHang(), x.getSDT(), df.format(x.getNgayTao()), status
            });
        }
    }

    private void updatePageInfo() {
        int totalItems = KHrepo.getTotalItems();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lbPresentPage.setText(ht + " / " + maxPage);
    }

    private void edit() {
        try {
            int id = (int) tbKhachHang.getValueAt(this.index, 0);
            KhachHang model = KHrepo.findById(id);
            if (model != null) {
                this.setModel(model);

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void setModel(KhachHang model) {
        txtIDKhachHang.setText(String.valueOf(model.getIDKhachHang()));
        txtMaKhachHang.setText(model.getMaKhachHang());
        txtHoTen.setText(model.getTenKhachHang());
        txtSoDT.setText(model.getSDT());
    }

    private KhachHang getModel() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        KhachHang model = new KhachHang();
        model.setMaKhachHang(txtMaKhachHang.getText());
        model.setTenKhachHang(txtHoTen.getText());
        model.setSDT(txtSoDT.getText());
        model.setNgayTao(date);
        return model;

    }

    private void ResetForm() {
        txtIDKhachHang.setText("Không Cần Nhập");
        txtMaKhachHang.setText("");
        txtHoTen.setText("");
        txtSoDT.setText("");
        txtTimKiem.setText("");
    }

    public boolean checkKH() {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (txtMaKhachHang.getText().equals("") || txtHoTen.getText().equals("") || txtSoDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ dữ liệu", "Error", 1);
            return false;
        } else if (!(txtMaKhachHang.getText()).matches("KH\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng mã \n VD : KH0001", "Error", 1);
            txtMaKhachHang.requestFocus();
            return false;
        } else if (!(txtSoDT.getText()).matches(reg)) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng số điện thoại", "Error", 1);
            txtSoDT.requestFocus();
            return false;
        } else if (KHrepo.ktrMaKH(txtMaKhachHang.getText())) {
            JOptionPane.showMessageDialog(this, "Trùng Mã Khách Hàng", "Error", 1);
            txtMaKhachHang.requestFocus();
            return false;
        }
        return true;
    }

    private void insert() {
        KhachHang model = getModel();
        try {
            KHrepo.create(model);
            updatePageInfo();
            findWithPaginationKH(0, size);
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    private void update() {
        KhachHang model = getModel();
        int id = Integer.parseInt(txtIDKhachHang.getText());
        model.setIDKhachHang(id);
        try {
            KHrepo.update(model);
            updatePageInfo();
            findWithPaginationKH(0, size);
            MsgBox.alert(this, "Sửa lại thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Sửa lại thất bại!");
        }
    }

    private void delete() {
        if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?")) {
            int id = Integer.parseInt(txtIDKhachHang.getText());
            try {
                KHrepo.remove(id);
                updatePageInfo();
                findWithPaginationKH(0, size);
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
            txtTimKiem.requestFocus();
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbMaKhachHang = new javax.swing.JLabel();
        txtIDKhachHang = new javax.swing.JTextField();
        lbHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        bntThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        bntLamMoi = new javax.swing.JButton();
        lbIDKhachHang = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        bntTimKiem = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();
        bntFirstPage = new javax.swing.JButton();
        bntPrevPage = new javax.swing.JButton();
        bntNextPage = new javax.swing.JButton();
        bntLastPage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        lbPresentPage = new javax.swing.JLabel();
        rdbntActive = new javax.swing.JRadioButton();
        rdbntNoActive = new javax.swing.JRadioButton();
        lbQuanLyKhachHang = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1083, 643));

        lbMaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaKhachHang.setText("Mã Khách Hàng:");

        txtIDKhachHang.setEditable(false);
        txtIDKhachHang.setText("Không Cần Nhập");

        lbHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoTen.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại:");

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

        bntLamMoi.setText("Làm mới");
        bntLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLamMoiActionPerformed(evt);
            }
        });

        lbIDKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbIDKhachHang.setText("ID Khách Hàng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIDKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaKhachHang))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSoDT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIDKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(bntThem)
                        .addGap(79, 79, 79)
                        .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(bntLamMoi)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIDKhachHang)
                    .addComponent(txtIDKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaKhachHang)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
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

        bntXoa.setText("Xóa Khách Hàng");
        bntXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntXoaActionPerformed(evt);
            }
        });

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

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID KHÁCH HÀNG", "MÃ KHÁCH HÀNG", "HỌ VÀ TÊN", "SỐ ĐIỆN THOẠI", "NGÀY TẠO", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbKhachHangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        lbPresentPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPresentPage.setText("?");

        buttonGroup1.add(rdbntActive);
        rdbntActive.setText("Đang hoạt động");
        rdbntActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbntActiveMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdbntNoActive);
        rdbntNoActive.setText("Dừng hoạt động");
        rdbntNoActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbntNoActiveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bntXoa)
                        .addGap(23, 23, 23)
                        .addComponent(bntFirstPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntPrevPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntNextPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntLastPage))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdbntActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbntNoActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntTimKiem)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbntActive)
                    .addComponent(rdbntNoActive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntLastPage)
                    .addComponent(bntXoa)
                    .addComponent(bntFirstPage)
                    .addComponent(bntPrevPage)
                    .addComponent(bntNextPage)
                    .addComponent(lbPresentPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbQuanLyKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbQuanLyKhachHang)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLamMoiActionPerformed
        // TODO add your handling code here:
        ResetForm();
        findWithPaginationKH(0, size);
        updatePageInfo();
    }//GEN-LAST:event_bntLamMoiActionPerformed

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

            if (checkKH()) {
                this.insert();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi, Vui lòng xem lại");
            e.printStackTrace();
        }

    }//GEN-LAST:event_bntThemActionPerformed

    private void bntFirstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFirstPageActionPerformed
        // TODO add your handling code here:
        ht = 1;
        findWithPaginationKH(0, size);
        updatePageInfo();
    }//GEN-LAST:event_bntFirstPageActionPerformed

    private void bntPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPrevPageActionPerformed
        // TODO add your handling code here:
        if (ht > 1) {
            ht--;
        }
        int page = (ht - 1) * size;
        findWithPaginationKH(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntPrevPageActionPerformed

    private void bntNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextPageActionPerformed
        // TODO add your handling code here:
        int TotalItime = KHrepo.getTotalItems();
        int TotalPage = TotalItime / size;
        System.out.println(TotalItime);
        System.out.println(TotalPage);
        if (ht < TotalPage) {
            ht++;
            int page = (ht - 1) * size;
            findWithPaginationKH(page, size);
            updatePageInfo();

        } else {
            ht = 1;
            findWithPaginationKH(0, size);
            updatePageInfo();
        }
    }//GEN-LAST:event_bntNextPageActionPerformed

    private void bntLastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLastPageActionPerformed
        // TODO add your handling code here:
        int totalItems = KHrepo.getTotalItems();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        ht = lastPage;
        int page = (ht - 1) * size;
        findWithPaginationKH(page, size);
        updatePageInfo();
    }//GEN-LAST:event_bntLastPageActionPerformed

    private void bntTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTimKiemActionPerformed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText();
        try {
            if (checkTimKiem()) {
                if (txtTimKiem.getText().matches("^(0|\\+84|\\84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
                    findbySDT(keyword, 0, size);
                } else if (txtTimKiem.getText().matches("^KH\\d{4}")) {
                    findByMaKH(keyword, 0, size);
                } else if (txtTimKiem.getText().matches("\\d{4}") || txtTimKiem.getText().matches("\\d{3}") || txtTimKiem.getText().matches("\\d{2}") || txtTimKiem.getText().matches("\\d{1}")) {
                    findByIdKH(Integer.parseInt(keyword));
                } else {
                    findByTenKH(keyword, 0, size);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_bntTimKiemActionPerformed

    private void tbKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMousePressed
        // TODO add your handling code here:

        this.index = tbKhachHang.rowAtPoint(evt.getPoint());
        if (this.index >= 0) {
            this.edit();
        }

    }//GEN-LAST:event_tbKhachHangMousePressed

    private void bntXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntXoaActionPerformed
        // TODO add your handling code here:
        try {

            this.delete();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi, Vui lòng xem lại");
            e.printStackTrace();
        }

    }//GEN-LAST:event_bntXoaActionPerformed

    private void rdbntActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbntActiveMouseClicked
        // TODO add your handling code here:
        findWithPaginationKH(0, size);
        updatePageInfo();
    }//GEN-LAST:event_rdbntActiveMouseClicked

    private void rdbntNoActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbntNoActiveMouseClicked
        // TODO add your handling code here:
        findWithNoActiveKH(0, size);
        int totalItems = KHrepo.getNoActiveTotal();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lbPresentPage.setText(ht + " / " + maxPage);
    }//GEN-LAST:event_rdbntNoActiveMouseClicked

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

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntFirstPage;
    private javax.swing.JButton bntLamMoi;
    private javax.swing.JButton bntLastPage;
    private javax.swing.JButton bntNextPage;
    private javax.swing.JButton bntPrevPage;
    private javax.swing.JButton bntSua;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntTimKiem;
    private javax.swing.JButton bntXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbIDKhachHang;
    private javax.swing.JLabel lbMaKhachHang;
    private javax.swing.JLabel lbPresentPage;
    private javax.swing.JLabel lbQuanLyKhachHang;
    private javax.swing.JRadioButton rdbntActive;
    private javax.swing.JRadioButton rdbntNoActive;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtIDKhachHang;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
