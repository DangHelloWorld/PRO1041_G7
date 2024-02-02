package com.g7.view;

import com.g7.entity.HoaDon;
import com.g7.entity.HoaDonChiTiet;
import com.g7.repository.impl.HoaDonRepository;
import com.g7.repository.impl.HoaDonCtRepository;
import com.g7.viewmodel.GioHangViewModel;
import com.g7.viewmodel.HoaDonViewModel;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class HoaDonJPanel extends javax.swing.JPanel {

    private ArrayList<HoaDon> listh = new ArrayList<>();
    private HoaDonRepository hdsv = new HoaDonRepository();
    private HoaDonCtRepository hdctsv = new HoaDonCtRepository();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtmgh = new DefaultTableModel();
    int id;
    int size = 100;

    int ht = 0;

    public HoaDonJPanel() {
        initComponents();
        FindDataHD(0, size);
    }
    public void Search(String nbd, String nkt, int ht, int size) {
        List<HoaDonViewModel> list = hdsv.selectWithPaginationHDS(nbd, nkt, ht, size);
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tblhoaDon.getModel();
        for (HoaDonViewModel x : list) {
            dtm.addRow(new Object[]{
                x.getIdhd(), x.getMahd(), x.getNgayTao(), x.getNgayThanhToan(), x.getTongTien(), x.getSoTienDuocGiam(), x.getTenNV(), x.getTenKH(), x.trangThai(x.getTrangThai())
            });
        }
    }

    public void FindDataHD(int ht, int size) {
        List<HoaDonViewModel> list = hdsv.selectWithPaginationHDC(ht, size);
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tblhoaDon.getModel();
        for (HoaDonViewModel x : list) {
            dtm.addRow(new Object[]{
                x.getIdhd(), x.getMahd(), x.getNgayTao(), x.getNgayThanhToan(), x.getTongTien(), x.getSoTienDuocGiam(), x.getTenNV(), x.getTenKH(), x.trangThai(x.getTrangThai())
            });
        }
    }

    public void FindDataGH(int id) {
        List<GioHangViewModel> list = hdsv.selectWithPaginationGH(id);
        dtmgh.setRowCount(0);
        dtmgh = (DefaultTableModel) tblhoaDonChiTiet.getModel();
        for (GioHangViewModel x : list) {
            dtmgh.addRow(new Object[]{
                x.getId(), x.getMasp(), x.getTensp(), x.getKickCo(), x.getMauSac(), x.getDanhMuc(), x.getNsx(), x.getSoluong(), x.getDongia()
            });
        }
    }

    public void validate() {
        try {
            Date date1 = CalendarTu.getDate();
            Date date2 = CalendarDen.getDate();

            if (date1 != null && date2 != null) {
                long differenceInMillis = Math.abs(date1.getTime() - date2.getTime());
                long differenceInDays = differenceInMillis / (24 * 60 * 60 * 1000);

                if (differenceInDays >= 31) {
                    JOptionPane.showMessageDialog(this, "Chỉ tìm kiểm trong khoảng 31 ngày");
                } else {
                    String nbd = ft.format(CalendarTu.getDate());
                    String nkt = ft.format(CalendarDen.getDate());
                    Search(nbd, nkt, 0, size);
                }

            } else {
                System.out.println("chịu");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoaDonChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnlon = new javax.swing.JButton();
        btnnhoMax = new javax.swing.JButton();
        btnnho = new javax.swing.JButton();
        btnlonMax = new javax.swing.JButton();
        rdodaThanhToan = new javax.swing.JRadioButton();
        rdochuaThanhToan = new javax.swing.JRadioButton();
        CalendarTu = new com.toedter.calendar.JDateChooser();
        CalendarDen = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSearchMaHD1 = new javax.swing.JButton();

        tblhoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Mã Hoá Đơn", "Ngày Tạo", "Ngày Thanh Toán", "Tổng Tiền", "Số Tiền Giảm", "Tên nhân viên", "Tên khách hàng", "Trạng Thái"
            }
        ));
        tblhoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblhoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã sản phẩm", "Tên sản phẩm", "Kích cỡ", "Màu sắc", "Danh mục", "NSX", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblhoaDonChiTiet);
        if (tblhoaDonChiTiet.getColumnModel().getColumnCount() > 0) {
            tblhoaDonChiTiet.getColumnModel().getColumn(0).setMaxWidth(30);
            tblhoaDonChiTiet.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Hóa đơn");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Chi tiết hóa đơn");

        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });
        txtMaHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHoaDonKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Từ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Trạng Thái:");

        btnlon.setText(">");
        btnlon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlonActionPerformed(evt);
            }
        });

        btnnhoMax.setText("<<");
        btnnhoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhoMaxActionPerformed(evt);
            }
        });

        btnnho.setText("<");
        btnnho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhoActionPerformed(evt);
            }
        });

        btnlonMax.setText(">>");
        btnlonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlonMaxActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdodaThanhToan);
        rdodaThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdodaThanhToan.setText("Đã Thanh Toán");
        rdodaThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdodaThanhToanItemStateChanged(evt);
            }
        });
        rdodaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdodaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdochuaThanhToan);
        rdochuaThanhToan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdochuaThanhToan.setSelected(true);
        rdochuaThanhToan.setText("Chưa Thanh Toán");
        rdochuaThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdochuaThanhToanItemStateChanged(evt);
            }
        });

        CalendarTu.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                CalendarTuCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                CalendarTuInputMethodTextChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tìm Hoá Đơn:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Đến");

        btnSearchMaHD1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSearchMaHD1.setText("Lọc");
        btnSearchMaHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMaHD1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CalendarTu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CalendarDen, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdodaThanhToan)
                                .addGap(18, 18, 18)
                                .addComponent(rdochuaThanhToan)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSearchMaHD1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(50, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(btnnhoMax)
                .addGap(18, 18, 18)
                .addComponent(btnnho)
                .addGap(41, 41, 41)
                .addComponent(btnlon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlonMax)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(CalendarTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchMaHD1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(CalendarDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdodaThanhToan)
                    .addComponent(rdochuaThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnhoMax)
                    .addComponent(btnnho)
                    .addComponent(btnlon)
                    .addComponent(btnlonMax))
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblhoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoaDonMouseClicked
        int selectedRow = tblhoaDon.getSelectedRow();
        if (selectedRow >= 0) {
            id = (int) tblhoaDon.getValueAt(selectedRow, 0);
            FindDataGH(id);
        }
        FindDataGH(id);
    }//GEN-LAST:event_tblhoaDonMouseClicked

    private void txtMaHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHoaDonKeyReleased

        String duLieuDauVao = txtMaHoaDon.getText().trim();
//        loadDataHd(hdsv.timKiem(duLieuDauVao, 0));

//        DefaultTableModel dtm = (DefaultTableModel) tblhoaDon.getModel();
//        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dtm);
//        tblhoaDon.setRowSorter(obj);
//        
//        if (!dưLieuDauVao.isEmpty()) {
//            obj.setRowFilter(RowFilter.regexFilter(dưLieuDauVao, 1));
//            obj.setRowFilter(RowFilter.regexFilter(dưLieuDauVao, 7));
//        } else {
//            tblhoaDon.setRowSorter(obj);
//            obj.setRowFilter(null);
//        }
    }//GEN-LAST:event_txtMaHoaDonKeyReleased

    private void btnnhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhoMaxActionPerformed
//        ht = 0;
//        FindDataHD(ht * 100, size);
    }//GEN-LAST:event_btnnhoMaxActionPerformed

    private void btnnhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhoActionPerformed
//        ht--;
//        if (ht < 1) {
//            ht = 10;
//        }
//        FindDataHD(ht * 100, size);
    }//GEN-LAST:event_btnnhoActionPerformed

    private void btnlonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlonActionPerformed
//        ht++;
//        if (ht > 10) {
//            ht = 0;
//        }
//        FindDataHD(ht * 100, size);
    }//GEN-LAST:event_btnlonActionPerformed

    private void rdodaThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdodaThanhToanItemStateChanged

    }//GEN-LAST:event_rdodaThanhToanItemStateChanged

    private void rdochuaThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdochuaThanhToanItemStateChanged

    }//GEN-LAST:event_rdochuaThanhToanItemStateChanged

    private void rdodaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdodaThanhToanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rdodaThanhToanActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void CalendarTuInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_CalendarTuInputMethodTextChanged
        JOptionPane.showMessageDialog(this, "SHow");
    }//GEN-LAST:event_CalendarTuInputMethodTextChanged

    private void CalendarTuCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_CalendarTuCaretPositionChanged
        JOptionPane.showMessageDialog(this, "SHow");
    }//GEN-LAST:event_CalendarTuCaretPositionChanged

    private void btnSearchMaHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMaHD1ActionPerformed
        validate();

//      
//        java.util.Date ngayTao = (java.util.Date) CalendarNgayTao.getDate();
//        
//        java.util.Date ngayThanhToan = (java.util.Date) CalendarNgayThanhToan.getDate();
//        
//        if(ngayTao==null && ngayThanhToan == null) JOptionPane.showMessageDialog(this, "Trường dữ liệu ngày còn thiếu");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            
//        String dinhDangNgayTao ="";
//        // Chuyển đổi đối tượng Date thành chuỗi có định dạng "yyyy-MM-dd"
//        try{
//            dinhDangNgayTao = dateFormat.format(ngayTao);
//        }catch(Exception ex){
//          
//        }
//        
//        String dinhDangNgayThanhToan="";
//        try{
//            dinhDangNgayThanhToan = dateFormat.format(ngayTao);
//    
//        }catch(Exception ex){
//        }
//        
//        System.out.println(dinhDangNgayThanhToan + "\n");
//        
//        if(!dinhDangNgayTao.isBlank() || !dinhDangNgayThanhToan.isBlank())
//            loadDataHd(hdsv.timKiemByDate(dinhDangNgayTao,dinhDangNgayThanhToan, 0));
//        else if(!dinhDangNgayTao.isBlank())
//            loadDataHd(hdsv.timKiemByCreatedDate(dinhDangNgayTao, 0));
//        else
//            loadDataHd(hdsv.timKiemByEndDate(dinhDangNgayThanhToan,0));
    }//GEN-LAST:event_btnSearchMaHD1ActionPerformed

    private void btnlonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlonMaxActionPerformed
//        FindDataHD(900, size);
    }//GEN-LAST:event_btnlonMaxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CalendarDen;
    private com.toedter.calendar.JDateChooser CalendarTu;
    private javax.swing.JButton btnSearchMaHD1;
    private javax.swing.JButton btnlon;
    private javax.swing.JButton btnlonMax;
    private javax.swing.JButton btnnho;
    private javax.swing.JButton btnnhoMax;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdochuaThanhToan;
    private javax.swing.JRadioButton rdodaThanhToan;
    private javax.swing.JTable tblhoaDon;
    private javax.swing.JTable tblhoaDonChiTiet;
    private javax.swing.JTextField txtMaHoaDon;
    // End of variables declaration//GEN-END:variables
}
