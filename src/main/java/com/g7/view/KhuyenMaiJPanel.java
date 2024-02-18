/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.g7.view;

import com.g7.entity.KhuyenMai;
import com.g7.repository.impl.KhuyenMaiRepository;
import com.g7.utils.MsgBox;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ddawng
 */
public class KhuyenMaiJPanel extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    KhuyenMai km = new KhuyenMai();
    KhuyenMaiRepository kmr = new KhuyenMaiRepository();
    DecimalFormat fomat = new DecimalFormat("###,###,###");
    SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");

    private int ht = 1;
    private int size = 100;

    /**
     * Creates new form KhuyenMaiJPanel
     */
    public KhuyenMaiJPanel() {
        initComponents();
        findWithPaginationKH(0, size);
        updatePageInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        txtNgayBDTK = new com.toedter.calendar.JDateChooser();
        txtNgayKTTK = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        txtMucGG = new javax.swing.JTextField();
        cboLoaiGG = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KM", "Tên KM", "Loại KM", "Mức giảm", "Số lượng", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái", "Mô tả"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhuyenMai);

        jLabel11.setText("Tìm kiếm");

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSearchMouseReleased(evt);
            }
        });

        btnTim.setText("Tìm");

        jLabel12.setText("Start");

        jLabel13.setText("End");

        btnFirst.setText("<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setText("<<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        lblPage.setText("?");

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtNgayBDTK, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtNgayKTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(224, 224, 224))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayKTTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayBDTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPre)
                    .addComponent(lblPage)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jLabel1.setText("Mã khuyến mãi");

        jLabel2.setText("Tên khuyến mãi");

        jLabel3.setText("Loại giảm giá");

        jLabel4.setText("Mức giảm");

        jLabel5.setText("Số lượng");

        jLabel6.setText("Ngày bắt đầu");

        jLabel7.setText("Ngày kết thúc");

        lblID.setText("?");

        txtMucGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMucGGActionPerformed(evt);
            }
        });

        cboLoaiGG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VND", "%" }));

        jLabel9.setText("Mô tả");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtNgayBatDau.setDateFormatString("dd-MM-yyyy");

        txtNgayKetThuc.setDateFormatString("dd-MM-yyyy");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Khuyến mãi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSoLuong)
                        .addComponent(txtMucGG)
                        .addComponent(cboLoaiGG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenKM)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLoaiGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMucGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMucGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMucGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMucGGActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        if (ht > 1) {
            ht--;
        }
        int page = (ht - 1) * size;
        findWithPaginationKH(page, size);
        updatePageInfo();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        ht = 1;
        findWithPaginationKH(0, size);
        updatePageInfo();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        int totalItems = kmr.getTotalItems();
        int lastPage = (int) Math.ceil((double) totalItems / size);
        ht = lastPage;
        int page = (ht - 1) * size;
        findWithPaginationKH(page, size);
        updatePageInfo();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        int TotalItime = kmr.getTotalItems();
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
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.insert();

    }//GEN-LAST:event_btnThemActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        // TODO add your handling code here:
        int index = tblKhuyenMai.getSelectedRow();
        ShowData(index);
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboLoaiGG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPage;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtMucGG;
    private com.toedter.calendar.JDateChooser txtNgayBDTK;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKTTK;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables

            
    void LoadData() {
        List<KhuyenMai> list = kmr.selectAll();
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        for (KhuyenMai km : list) {
            model.addRow(new Object[]{
                km.getIDKhuyenMai(), km.getTenKhuyenMai(), km.KieuKM(km.isKieuGiamGia()), fomat.format(km.getMucGiamGia()), km.getSoLuong(), km.getNgayBatDau(), km.getNgayKetThuc(), km.trangThai(km.getTrangThai()), km.getMoTa()

            });
        }
 
    }

    void ShowData(int index) {
        KhuyenMai km = kmr.selectAll().get(index);
        lblID.setText(String.valueOf(km.getIDKhuyenMai()));
        txtTenKM.setText(km.getTenKhuyenMai());
        txtMoTa.setText(km.getMoTa());
        txtSoLuong.setText(String.valueOf(km.getSoLuong()));
        System.out.println(cboLoaiGG.getSelectedIndex());
        System.out.println(km.isKieuGiamGia());
        if (km.isKieuGiamGia() == true) {
            cboLoaiGG.setSelectedIndex(0);
        }
        if (km.isKieuGiamGia() == false) {
            cboLoaiGG.setSelectedIndex(1);
        }
        txtMucGG.setText(String.valueOf(km.getMucGiamGia()));
        txtNgayBatDau.setDate(km.getNgayBatDau());
        txtNgayKetThuc.setDate(km.getNgayKetThuc());
    }

    KhuyenMai getForm() {
//        String idKM = lblID.getText();
//        String tenKM = txtTenKM.getText();
//        String moTa = txtMoTa.getText();
//        String soLuong = txtSoLuong.getText();
//        boolean loaiGG = false;
//        if (cboLoaiGG.getSelectedIndex() == 0) {
//            loaiGG = true;
//        }
//        if (cboLoaiGG.getSelectedIndex() == 1) {
//            loaiGG =false;
//        }
//        String mucGG = txtMucGG.getText();
//        Date ngayBD = txtNgayBatDau.getDate();
//        Date ngayKT = txtNgayKetThuc.getDate();
//        return new KhuyenMai(idKM, tenKM, loaiGG, mucGG, soLuong, ngayBD, ngayKT, moTa);

        KhuyenMai km = new KhuyenMai();
//        km.setIDKhuyenMai(Integer.valueOf(lblID.getText()));
        km.setTenKhuyenMai(txtTenKM.getText());
        if (cboLoaiGG.getSelectedItem() == "VND") {
            km.setKieuGiamGia(true);
        } else {
            km.setKieuGiamGia(false);
        }
        km.setMoTa(txtMoTa.getText());
        km.setMucGiamGia(Double.valueOf(txtMucGG.getText()));
        km.setNgayBatDau(txtNgayBatDau.getDate());
        km.setNgayKetThuc(txtNgayKetThuc.getDate());
        km.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        return km;
    }

    void clearForm() {
        lblID.setText("?");
        txtTenKM.setText(null);
        txtSoLuong.setText(null);
        txtMucGG.setText(null);
        txtNgayBatDau.setDate(null);
        txtNgayKetThuc.setDate(null);
        cboLoaiGG.setSelectedIndex(0);
        txtMoTa.setText(null);
    }

    void insert() {
        KhuyenMai kmcc = getForm();
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Thêm khuyến mãi", "Bạn có muốn thêm khuyến mãi này không?", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                kmr.insert(kmcc);
                this.LoadData();
                this.clearForm();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm không thành công");

        }
    }
   

    void update() {
        KhuyenMai km = new KhuyenMai();
        km.setIDKhuyenMai(Integer.valueOf(lblID.getText()));
        km.setTenKhuyenMai(txtTenKM.getText());
        if (cboLoaiGG.getSelectedItem() == "VND") {
            km.setKieuGiamGia(true);
        } else {
            km.setKieuGiamGia(false);
        }
        km.setMoTa(txtMoTa.getText());
        km.setMucGiamGia(Double.valueOf(txtMucGG.getText()));
        km.setNgayBatDau(txtNgayBatDau.getDate());
        km.setNgayKetThuc(txtNgayKetThuc.getDate());
        km.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Sửa khuyến mãi", "Bạn có muốn sửa khuyến mãi này không?", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                kmr.update(km);
                this.LoadData();
                this.clearForm();
                JOptionPane.showMessageDialog(this, "sửa thành công");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "sửa không thành công");

        }

    }

    void delete() {
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Xóa khuyến mãi", "Bạn có muốn xoá khuyến mãi này không?", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                kmr.update21(lblID.getText());
                this.LoadData();
                JOptionPane.showMessageDialog(this, "xóa thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa ko thành công");
        }
    }

    public void findWithPaginationKH(int ht, int c) {
        List<KhuyenMai> list = kmr.selectWithPagination(ht, c);
        model.setRowCount(0);
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        for (KhuyenMai x : list) {
            model.addRow(new Object[]{
                x.getIDKhuyenMai(),
                x.getTenKhuyenMai(),
                x.KieuKM(x.isKieuGiamGia()),
                fomat.format(x.getMucGiamGia()),
                x.getSoLuong(),
                
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.trangThai(x.getTrangThai()),
                x.getMoTa()});

        }
    }

    public void findWithNoActiveKH(int ht, int c) {
        List<KhuyenMai> list = kmr.selectWithPaginationNoActive(ht, c);
        model.setRowCount(0);
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        for (KhuyenMai x : list) {           
            model.addRow(new Object[]{
                x.getIDKhuyenMai(),
                x.getTenKhuyenMai(),
                x.KieuKM(x.isKieuGiamGia()),
                fomat.format(x.getMucGiamGia()),
                x.getSoLuong(),
                
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.trangThai(x.getTrangThai()),
                x.getMoTa()
            });

        }
    }

    private void updatePageInfo() {
        int totalItems = kmr.getTotalItems();
        int maxPage = (int) Math.ceil((double) totalItems / size);

        if (ht > maxPage) {
            ht = (maxPage == 0) ? 1 : maxPage;
        }

        lblPage.setText(ht + " / " + maxPage);
    }
//    public void Search(String nbd, String nkt, int ht, int size){
//        List<KhuyenMai> list = kmr
//    }
    public void validate() {
        try {
            Date date1 = txtNgayBDTK.getDate();
            Date date2 = txtNgayKTTK.getDate();

            if (date1 != null && date2 != null) {
                long differenceInMillis = Math.abs(date1.getTime() - date2.getTime());
                long differenceInDays = differenceInMillis / (24 * 60 * 60 * 1000);

                if (differenceInDays >= 31) {
                    JOptionPane.showMessageDialog(this, "Chỉ tìm kiểm trong khoảng 31 ngày");
                } else {
                    String nbd = ft.format(txtNgayBDTK.getDate());
                    String nkt = ft.format(txtNgayKetThuc.getDate());
//                    Search(nbd, nkt, 0, size);
                }

            } else {
                System.out.println("chịu");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
