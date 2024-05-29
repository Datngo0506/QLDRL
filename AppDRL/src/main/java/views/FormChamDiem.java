/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.raven.swing.ScrollBar;
import controller.Database;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.DRL;
import models.SinhVien;
import models.TieuChi;

/**
 *
 * @author Dat
 */
public class FormChamDiem extends javax.swing.JFrame {

    private ArrayList<DRL> dsDRL;
    private ArrayList<TieuChi> dsTieuChi;
    private String msv;
    private JTable table;
    private String hocky;
    private int row;
    private String ngCham;
    
    /**
     * Creates new form FormChamDiem
     */
    public FormChamDiem() {
        initComponents();
    }
    
    public FormChamDiem(ArrayList<DRL>dsDRL, ArrayList<TieuChi>dsTieuChi, String hocky, String msv, JTable table, int row, String ngCham) {
        
        initComponents();
        setLocationRelativeTo(null);
        Database.addListTieuChiToTable_Cham(dsTieuChi, jTableTieuChi);
        this.dsTieuChi = dsTieuChi;
        this.hocky = hocky;
        this.msv = msv;
        this.row = row;
        this.table = table;
        this.dsDRL = dsDRL;
        this.ngCham = ngCham;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTieuChiMain2 = new javax.swing.JPanel();
        jPanelThanhTieuDeTieuChi2 = new javax.swing.JPanel();
        jPanelNutTieuDeTieuChi2 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTieuChi2 = new javax.swing.JLabel();
        jPanelNutXoaTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutXoaTieuChi = new javax.swing.JLabel();
        jPanelBorderTieuChi = new com.raven.swing.PanelBorder();
        jLabelTitleTieuChi = new javax.swing.JLabel();
        jScrollPaneTieuChi = new javax.swing.JScrollPane();
        jTableTieuChi = new com.raven.swing.TableChamDiem();
        jPanelNutChiTietTC = RoundedPanel.createRoundedPanel();
        jLabelNutChiTietTC = new javax.swing.JLabel();
        jLabelHKXet_DRL = new javax.swing.JLabel();
        jPanelNutTong = RoundedPanel.createRoundedPanel();
        jLabelTong = new javax.swing.JLabel();
        jPanelTong = RoundedPanel.createRoundedPanel();
        jLabelDiemTong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chấm điểm rèn luyện");

        jPanelTieuChiMain2.setPreferredSize(new java.awt.Dimension(790, 620));
        jPanelTieuChiMain2.setRequestFocusEnabled(false);
        jPanelTieuChiMain2.setVerifyInputWhenFocusTarget(false);
        jPanelTieuChiMain2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTieuChi2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTieuChi2.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTieuChi2.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTieuChi2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTieuChi2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTieuChi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetieuchi.png"))); // NOI18N
        jLabelNutTieuDeTieuChi2.setText("Tiêu chí");
        jLabelNutTieuDeTieuChi2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTieuChi2.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTieuChi2Layout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi2);
        jPanelNutTieuDeTieuChi2.setLayout(jPanelNutTieuDeTieuChi2Layout);
        jPanelNutTieuDeTieuChi2Layout.setHorizontalGroup(
            jPanelNutTieuDeTieuChi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeTieuChi2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTieuChi2Layout.setVerticalGroup(
            jPanelNutTieuDeTieuChi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTieuChi2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaTieuChi.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetick2.png"))); // NOI18N
        jLabelNutXoaTieuChi.setText("Nộp");
        jLabelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutXoaTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutXoaTieuChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutXoaTieuChiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutXoaTieuChiLayout = new javax.swing.GroupLayout(jPanelNutXoaTieuChi);
        jPanelNutXoaTieuChi.setLayout(jPanelNutXoaTieuChiLayout);
        jPanelNutXoaTieuChiLayout.setHorizontalGroup(
            jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaTieuChiLayout.setVerticalGroup(
            jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTieuChi2Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeTieuChi2);
        jPanelThanhTieuDeTieuChi2.setLayout(jPanelThanhTieuDeTieuChi2Layout);
        jPanelThanhTieuDeTieuChi2Layout.setHorizontalGroup(
            jPanelThanhTieuDeTieuChi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTieuChi2Layout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTieuChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 540, Short.MAX_VALUE)
                .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTieuChi2Layout.setVerticalGroup(
            jPanelThanhTieuDeTieuChi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTieuChi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTieuChiMain2.add(jPanelThanhTieuDeTieuChi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelBorderTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderTieuChi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

        jLabelTitleTieuChi.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleTieuChi.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleTieuChi.setText("Tiêu chí đánh giá");

        jScrollPaneTieuChi.setBorder(null);

        jTableTieuChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Nội dung", "Điểm QĐ", "Đánh giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTieuChi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTieuChi.setShowGrid(true);
        jScrollPaneTieuChi.setViewportView(jTableTieuChi);

        jPanelNutChiTietTC.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutChiTietTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutChiTietTC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutChiTietTC.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutChiTietTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteview.png"))); // NOI18N
        jLabelNutChiTietTC.setText("Xem chi tiết");
        jLabelNutChiTietTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutChiTietTC.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutChiTietTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutChiTietTCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutChiTietTCLayout = new javax.swing.GroupLayout(jPanelNutChiTietTC);
        jPanelNutChiTietTC.setLayout(jPanelNutChiTietTCLayout);
        jPanelNutChiTietTCLayout.setHorizontalGroup(
            jPanelNutChiTietTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutChiTietTCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutChiTietTC, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );
        jPanelNutChiTietTCLayout.setVerticalGroup(
            jPanelNutChiTietTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutChiTietTC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jLabelHKXet_DRL.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHKXet_DRL.setText("Học kỳ đang xét là: II 2023-2024");

        jPanelNutTong.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutTong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNutTong.setPreferredSize(new java.awt.Dimension(114, 40));

        jLabelTong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTong.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelTong.setText("Tính tổng");
        jLabelTong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelTong.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelTong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutTongLayout = new javax.swing.GroupLayout(jPanelNutTong);
        jPanelNutTong.setLayout(jPanelNutTongLayout);
        jPanelNutTongLayout.setHorizontalGroup(
            jPanelNutTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTong, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
        );
        jPanelNutTongLayout.setVerticalGroup(
            jPanelNutTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTong.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

        jLabelDiemTong.setFont(new java.awt.Font("Segoe UI Variable", 1, 16)); // NOI18N
        jLabelDiemTong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDiemTong.setText("00");

        javax.swing.GroupLayout jPanelTongLayout = new javax.swing.GroupLayout(jPanelTong);
        jPanelTong.setLayout(jPanelTongLayout);
        jPanelTongLayout.setHorizontalGroup(
            jPanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDiemTong, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanelTongLayout.setVerticalGroup(
            jPanelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDiemTong, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelBorderTieuChiLayout = new javax.swing.GroupLayout(jPanelBorderTieuChi);
        jPanelBorderTieuChi.setLayout(jPanelBorderTieuChiLayout);
        jPanelBorderTieuChiLayout.setHorizontalGroup(
            jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                        .addComponent(jPanelNutTong, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                            .addComponent(jLabelTitleTieuChi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelNutChiTietTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPaneTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                    .addGap(274, 274, 274)
                    .addComponent(jLabelHKXet_DRL)
                    .addContainerGap(275, Short.MAX_VALUE)))
        );
        jPanelBorderTieuChiLayout.setVerticalGroup(
            jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelNutChiTietTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitleTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelNutTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(jLabelHKXet_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE)))
        );

        jScrollPaneTieuChi.setVerticalScrollBar(new ScrollBar());
        jScrollPaneTieuChi.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneTieuChi.getViewport().setBackground(Color.WHITE);
        JPanel p6 = new JPanel();
        p6.setBackground(Color.WHITE);
        jScrollPaneTieuChi.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p6);

        jPanelTieuChiMain2.add(jPanelBorderTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTieuChiMain2, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTieuChiMain2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelNutXoaTieuChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaTieuChiMouseClicked
        // TODO add your handling code here:
        if(jLabelDiemTong.getText().equals("00")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra điểm tổng trước khi nộp!");
            return;
        }
        if(Integer.parseInt(jLabelDiemTong.getText()) <=0){
            JOptionPane.showMessageDialog(rootPane, "Điểm rèn luyện không hợp lệ!");
            return;
        }
        if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn nộp điểm không?") ==  JOptionPane.YES_OPTION){
            int diem = Integer.parseInt(jLabelDiemTong.getText());
            new Thread(() -> {
                switch (ngCham) {
                    case "SV" -> Database.updateDRLSV_SV(msv, hocky, diem, 0, 0);
                    case "CS" -> Database.updateDRLSV_CS(msv, hocky, diem, 0);
                    default -> Database.updateDRLSV_CV(msv, hocky, diem);
                }
            }).start();
            new Thread(() -> {
                switch (ngCham) {
                    case "SV" -> table.setValueAt(jLabelDiemTong.getText(), row, 3);
                    case "CS" -> table.setValueAt(jLabelDiemTong.getText(), row, 4);
                    default -> table.setValueAt(jLabelDiemTong.getText(), row, 5);
                }
            }).start();
            new Thread(() -> {
                for(DRL drl : dsDRL){
                    if(drl.getMSSV().equals(msv) && drl.getMaHK().equals(hocky)){
                        switch (ngCham) {
                            case "SV" -> drl.setDiem1(diem);
                            case "CS" -> drl.setDiem2(diem);
                            default -> drl.setDiem3(diem);
                        }
                    }
                }
            }).start();
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_jLabelNutXoaTieuChiMouseClicked

    private void jLabelNutChiTietTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutChiTietTCMouseClicked
        // TODO add your handling code here:
        int chon = jTableTieuChi.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn tiêu chí cần xem chi tiết!");
        }
        else{
            String noiDung = dsTieuChi.get(chon).getNoiDung();
            int diem = dsTieuChi.get(chon).getDiem();
            if(dsTieuChi.get(chon).getDsNoiDung().isEmpty() ){

                new FormThem_SuaTieuChi(noiDung, diem, chon, dsTieuChi, jTableTieuChi, "a").setVisible(true);
            }
            else{
                new FormNoiDungTieuChi(dsTieuChi, dsTieuChi.get(chon).getDsNoiDung(), noiDung, chon, "AnND").setVisible(true);
            }

        }
        evt.consume();

    }//GEN-LAST:event_jLabelNutChiTietTCMouseClicked

    private void jLabelTongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTongMouseClicked
        // TODO add your handling code here:
        for (int i=0; i<jTableTieuChi.getRowCount(); i++){
            Object cell = jTableTieuChi.getValueAt(i, 3);
            String diem = cell.toString();
            if(diem.equals("")){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng đánh giá đầy đủ các cột điểm!");
                return;
            }
            try {
                Integer num = Integer.valueOf(diem);
                if (num != null) {
                    //System.out.println("Chuỗi là số nguyên.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Điểm đánh giá phải là số nguyên!\n(Cột điểm không hợp lệ ở STT: "+(i+1)+").");
                return;
            }
            int diemDG = Integer.parseInt(diem);
            Object cell2 = jTableTieuChi.getValueAt(i, 2);
            String diem2 = cell2.toString();
            int diemQD = Integer.parseInt(diem2);
            if(diemQD < 0 && diemDG >0){
                JOptionPane.showMessageDialog(rootPane, "Điểm vi phạm không được lớn hơn 0!\n(Cột điểm không hợp lệ ở STT: "+(i+1)+").");
                return;
            }
            if(diemQD < 0 && diemDG <diemQD){
                JOptionPane.showMessageDialog(rootPane, "Điểm đánh giá không đc nhỏ hơn điểm vi phạm!\n(Cột điểm không hợp lệ ở STT: "+(i+1)+").");
                return;
            }
            if(diemQD > 0 && diemDG <0){
                JOptionPane.showMessageDialog(rootPane, "Điểm cộng không được nhỏ hơn 0!\n(Cột điểm không hợp lệ ở STT: "+(i+1)+").");
                return;
            }
            if(diemQD < diemDG && diemQD >=0){
                JOptionPane.showMessageDialog(rootPane, """
                                                        \u0110i\u1ec3m \u0111\u00e1nh gi\u00e1 kh\u00f4ng v\u01b0\u1ee3t qu\u00e1 \u0111i\u1ec3m quy\u1ebft \u0111\u1ecbnh!
                                                        (C\u1ed9t \u0111i\u1ec3m kh\u00f4ng h\u1ee3p l\u1ec7 \u1edf STT: """+(i+1)+").");
                return;
            }
        }
        int tong = 0;
        for (int i=0; i<jTableTieuChi.getRowCount(); i++){
            Object cell = jTableTieuChi.getValueAt(i, 3);
            String diem = cell.toString();
            tong += Integer.parseInt(diem);
        }
        jLabelDiemTong.setText(Integer.toString(tong));
    }//GEN-LAST:event_jLabelTongMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormChamDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormChamDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormChamDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormChamDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormChamDiem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDiemTong;
    private javax.swing.JLabel jLabelHKXet_DRL;
    private javax.swing.JLabel jLabelNutChiTietTC;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi1;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi2;
    private javax.swing.JLabel jLabelNutXoaTieuChi;
    private javax.swing.JLabel jLabelTitleTieuChi;
    private javax.swing.JLabel jLabelTong;
    private com.raven.swing.PanelBorder jPanelBorderTieuChi;
    private javax.swing.JPanel jPanelNutChiTietTC;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi1;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi2;
    private javax.swing.JPanel jPanelNutTong;
    private javax.swing.JPanel jPanelNutXoaTieuChi;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi1;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi2;
    private javax.swing.JPanel jPanelTieuChiMain;
    private javax.swing.JPanel jPanelTieuChiMain1;
    private javax.swing.JPanel jPanelTieuChiMain2;
    private javax.swing.JPanel jPanelTong;
    private javax.swing.JScrollPane jScrollPaneTieuChi;
    private com.raven.swing.Table jTableTieuChi;
    // End of variables declaration//GEN-END:variables
}