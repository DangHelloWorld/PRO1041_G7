package com.g7.view;

import com.g7.entity.ThuocTinh;
import com.g7.repository.impl.ThuocTinhRepository;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class viewCRUDThuocTinh extends javax.swing.JFrame {

    public viewCRUDThuocTinh(int indexThuocTinh) {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.indexThuocTinh = indexThuocTinh;
        loadData();
    }

    int indexThuocTinh;
    int index = -1;

    DefaultTableModel Model = new DefaultTableModel();
    ThuocTinhRepository Service = new ThuocTinhRepository();

    private void loadData() {
        Model = (DefaultTableModel) tblThuocTinh.getModel();
        Model.setRowCount(0);
        for (Object o : Service.selectOffset(index, indexThuocTinh)) {
            ThuocTinh tt = (ThuocTinh) o;
            Model.addRow(new Object[]{
                tt.getId(),
                tt.getTenThuocTinh()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtThuocTinh = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Thuộc Tính"
            }
        ));
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThuocTinh);
        if (tblThuocTinh.getColumnModel().getColumnCount() > 0) {
            tblThuocTinh.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jLabel1.setText("Thuộc Tính");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnDong.setText("X");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnThem))
                            .addComponent(txtThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDong)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addGap(6, 6, 6)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtThuocTinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Thuộc Tính");
        } else {
            int checktontaiTT = Service.ktrTonTaiTT(indexThuocTinh, txtThuocTinh.getText());
            if (checktontaiTT == -1) {
                if (Service.create(new ThuocTinh(0, txtThuocTinh.getText()), indexThuocTinh) == 1) {
                    JOptionPane.showMessageDialog(this, "Thành Công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thất Bại");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Thuộc Tính Đã Tồn Tại\n ID Là : " + checktontaiTT + "\n Vui Lòng Nhập Thuộc Tính Khác");
            }
        }
        loadData();
        index = -1;
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Thuộc Tính");
            return;
        }
        int id = Integer.parseInt(tblThuocTinh.getValueAt(index, 0).toString());
        if (txtThuocTinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Thuộc Tính");
        } else {
            if (!tblThuocTinh.getValueAt(index, 1).equals(txtThuocTinh.getText())) {
                int checktontaiTT = Service.ktrTonTaiTT(indexThuocTinh, txtThuocTinh.getText());
                if (checktontaiTT == -1) {
                    if (Service.update(new ThuocTinh(id, txtThuocTinh.getText()), indexThuocTinh) == 1) {
                        JOptionPane.showMessageDialog(this, "Thành Công");
                        index = -1;
                    } else {
                        JOptionPane.showMessageDialog(this, "Thất Bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thuộc Tính Đã Tồn Tại\n ID Là : " + checktontaiTT + "\n Vui Lòng Nhập Thuộc Tính Khác");
                }
            }
        }
        loadData();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Hãy Chọn Thuộc Tính");
            return;
        }
        int id = Integer.parseInt(tblThuocTinh.getValueAt(index, 0).toString());
        Service.remove(id, indexThuocTinh);
        loadData();
        index = -1;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        index = tblThuocTinh.getSelectedRow();
        txtThuocTinh.setText(tblThuocTinh.getValueAt(index, 1).toString());
    }//GEN-LAST:event_tblThuocTinhMouseClicked
    public static void main(String args[]) {
        new viewCRUDThuocTinh(1).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtThuocTinh;
    // End of variables declaration//GEN-END:variables
}
