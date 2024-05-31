/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.raven.swing.ScrollBar;
import com.raven.swing.RoundedTextField;
import com.raven.swing.RoundedScrollPane;
import controller.Database;
import controller.ThuatToan;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.NoiDungTieuChi;
import models.TieuChi;

/**
 *
 * @author Dat
 */


public final class FormThem_SuaTieuChi extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private int chonTC;
    private int chonND;
    private String chucNang;
    private JTable tableTieuChi;
    private JTable tableNoiDung; 
   private ArrayList<TieuChi> dsTieuChi;
    private ArrayList<NoiDungTieuChi> dsNoiDung;
    private String noiDung, loaiLuu;
    private int diem;
    
    public void edit(){
        setLocationRelativeTo(null);
        FormDangNhap.setBorderTextArea(jTextAreaChiTiet);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        this.setIconImage(logo);  
        
        switch (chucNang) {
            case "ChiTiet" -> {
                jTextAreaChiTiet.setText(noiDung);
                jTextFieldDiem.setText(Integer.toString(diem));
                jLabelLoaiTC.setVisible(false);
                choiceLoaiTC.setVisible(false);
                jLabelNutTieuDeTieuChi.setText("Chi tiết tiêu chí");
            }
            case "ThemTC" -> {
                jLabelLoaiTC.setVisible(true);
                choiceLoaiTC.setVisible(true);
                choiceLoaiTC.add("Đơn nội dung");
                choiceLoaiTC.add("Đa nội dung");
                jLabelNutTieuDeTieuChi.setText("Thêm tiêu chí");
            }
            case "ThemND" -> {
                jLabelLoaiTC.setVisible(false);
                choiceLoaiTC.setVisible(false);
                jLabelNutTieuDeTieuChi.setText("Thêm nội dung");
            }
            case "ChamDiemTC" -> {
                jTextAreaChiTiet.setText(noiDung);
                jTextFieldDiem.setText(Integer.toString(diem));
                jLabelLoaiTC.setVisible(false);
                choiceLoaiTC.setVisible(false);
                jLabelNutTieuDeTieuChi.setText("Chi tiết tiêu chí");
                jPanelNutXoaTieuChi.setVisible(false);
                jLabelNutLuu.setVisible(false);
                jTextAreaChiTiet.setEditable(false);
                jTextFieldDiem.setEditable(false);
            }
            default -> {
                jLabelLoaiTC.setVisible(false);
                choiceLoaiTC.setVisible(false);
                ArrayList<NoiDungTieuChi> ds = dsTieuChi.get(chonTC).getDsNoiDung();
                String nd = ds.get(chonND).getNoiDung();
                String diemQD = Integer.toString(ds.get(chonND).getDiem());
                jTextAreaChiTiet.setText(nd);
                String text = "";
                if(!diemQD.equals("-50")){
                    text = diemQD;
                }
                jTextFieldDiem.setText(text);
                jLabelNutTieuDeTieuChi.setText("Cập nhật nội dung");
            }
        }
        
        

    }
    public FormThem_SuaTieuChi() {
        initComponents();
        edit();
    }
    
    public FormThem_SuaTieuChi(String noiDung, int diem) {
        initComponents();
        this.diem = diem;
        this.noiDung = noiDung;
        chucNang = "ChiTiet";
        edit();
    }
    
    public FormThem_SuaTieuChi(ArrayList<TieuChi> dsTieuChi, JTable tableTieuChi) {
        initComponents();
        this.dsTieuChi = dsTieuChi;
        this.tableTieuChi = tableTieuChi;
        chucNang = "ThemTC";
        edit();
    }
    
    public FormThem_SuaTieuChi(ArrayList<TieuChi> dsTieuChi, JTable tableTieuChi, int chonTC, JTable table) {
        initComponents();
        this.dsTieuChi = dsTieuChi;
        this.tableTieuChi = tableTieuChi;
        this.chonTC = chonTC;
        chucNang = "ThemND";
        this.tableNoiDung = table;
        edit();
    }
    
    public FormThem_SuaTieuChi(ArrayList<TieuChi> dsTieuChi, int chonTC, JTable table, int chonND) {
        initComponents();
        this.dsTieuChi = dsTieuChi;
        this.chonTC = chonTC;
        this.chonND = chonND;
        chucNang = "ChiTietND";
        this.tableNoiDung = table;
        edit();
    }
    
    
    
    public FormThem_SuaTieuChi(String noiDung, int diem, int chon, ArrayList<TieuChi> dsTieuChi, JTable tableTieuChi) {
        initComponents();
        this.diem = diem;
        this.tableTieuChi = tableTieuChi;
        this.chonTC = chon;
        this.dsTieuChi = dsTieuChi;
        this.noiDung = noiDung;
        chucNang = "ChiTiet";
        edit();
    }
    
    public FormThem_SuaTieuChi(String noiDung, int diem, int chon, ArrayList<TieuChi> dsTieuChi, JTable tableTieuChi, String a) {
        initComponents();
        this.diem = diem;
        this.tableTieuChi = tableTieuChi;
        this.chonTC = chon;
        this.dsTieuChi = dsTieuChi;
        this.noiDung = noiDung;
        chucNang = "ChamDiemTC";
        edit();
    }
    
    public FormThem_SuaTieuChi(String noiDung, int diem, int chonTC, int chonND, ArrayList<TieuChi> dsTieuChi, ArrayList<NoiDungTieuChi> dsNoiDung, JTable tableNoiDung) {
        initComponents();
        this.diem = diem;
        this.chonTC = chonTC;
        this.chonND = chonND;
        this.dsTieuChi = dsTieuChi;
        this.dsNoiDung = dsNoiDung;
        this.noiDung = noiDung;
        this.tableNoiDung = tableNoiDung;
        edit();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jPanelThanhTieuDeTieuChi = new javax.swing.JPanel();
        jPanelNutTieuDeTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTieuChi = new javax.swing.JLabel();
        jPanelNutXoaTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutLuu = new javax.swing.JLabel();
        jPanelMain1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneChiTiet = new RoundedScrollPane(jTextAreaChiTiet, 10, 10);
        jTextAreaChiTiet = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDiem = new RoundedTextField(15, 10, 10);
        jLabelLoaiTC = new javax.swing.JLabel();
        choiceLoaiTC = new java.awt.Choice();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Giải thích tiêu chí");

        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTieuChi.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetieuchi.png"))); // NOI18N
        jLabelNutTieuDeTieuChi.setText("Tiêu chí");
        jLabelNutTieuDeTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi);
        jPanelNutTieuDeTieuChi.setLayout(jPanelNutTieuDeTieuChiLayout);
        jPanelNutTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeTieuChiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTieuChiLayout.setVerticalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaTieuChi.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutLuu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitesave.png"))); // NOI18N
        jLabelNutLuu.setText("Lưu");
        jLabelNutLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutLuu.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutLuuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNutLuuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelNutLuuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutXoaTieuChiLayout = new javax.swing.GroupLayout(jPanelNutXoaTieuChi);
        jPanelNutXoaTieuChi.setLayout(jPanelNutXoaTieuChiLayout);
        jPanelNutXoaTieuChiLayout.setHorizontalGroup(
            jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaTieuChiLayout.setVerticalGroup(
            jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTieuChi);
        jPanelThanhTieuDeTieuChi.setLayout(jPanelThanhTieuDeTieuChiLayout);
        jPanelThanhTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTieuChiLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTieuChiLayout.setVerticalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelThanhTieuDeTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 570, 40));

        jPanelMain1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nội dung");
        jLabel4.setOpaque(true);
        jPanelMain1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 430, -1));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Điểm");
        jLabel5.setOpaque(true);
        jPanelMain1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 60, -1));

        jPanelMain.add(jPanelMain1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0)));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Nội dung");
        jLabel1.setOpaque(true);

        jScrollPaneChiTiet.setVerticalScrollBar(new ScrollBar());
        jScrollPaneChiTiet.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneChiTiet.getViewport().setBackground(Color.WHITE);
        JPanel p9 = new JPanel();
        p9.setBackground(Color.WHITE);
        jScrollPaneChiTiet.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p9);
        jScrollPaneChiTiet.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneChiTiet.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        jTextAreaChiTiet.setColumns(20);
        jTextAreaChiTiet.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jTextAreaChiTiet.setForeground(new java.awt.Color(102, 102, 102));
        jTextAreaChiTiet.setRows(5);
        jTextAreaChiTiet.setAutoscrolls(false);
        jTextAreaChiTiet.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextAreaChiTiet.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextAreaChiTiet.setOpaque(false);
        jTextAreaChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextAreaChiTietMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextAreaChiTietMouseExited(evt);
            }
        });
        jTextAreaChiTiet.setLineWrap(true);
        jTextAreaChiTiet.setWrapStyleWord(true);
        jScrollPaneChiTiet.setViewportView(jTextAreaChiTiet);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Điểm");
        jLabel2.setOpaque(true);

        //FormDangNhap.setBorderTextField(jTextFieldDiem);
        jTextFieldDiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabelLoaiTC.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLoaiTC.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoaiTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoaiTC.setText("Loại tiêu chí");
        jLabelLoaiTC.setOpaque(true);

        choiceLoaiTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceLoaiTC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        choiceLoaiTC.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceLoaiTC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceLoaiTCItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPaneChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLoaiTC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choiceLoaiTC, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jTextFieldDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLoaiTC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceLoaiTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 570, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAreaChiTietMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaChiTietMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaChiTietMouseEntered

    private void jTextAreaChiTietMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaChiTietMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaChiTietMouseExited

    private void jLabelNutLuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseEntered
        // TODO add your handling code here:
        jPanelNutXoaTieuChi.setBackground(new Color(30,115,190));
    }//GEN-LAST:event_jLabelNutLuuMouseEntered

    private void jLabelNutLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseExited
        // TODO add your handling code here:
        jPanelNutXoaTieuChi.setBackground(new Color(221,51,51));
    }//GEN-LAST:event_jLabelNutLuuMouseExited

    private void jLabelNutLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseClicked
        // TODO add your handling code here:
        
        if(jTextAreaChiTiet.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        if(chucNang.equals("ChiTietND") || chucNang.equals("ThemND")){
            if(!jTextFieldDiem.getText().trim().equals("") && !ThuatToan.isInteger(jTextFieldDiem.getText().trim())){
                JOptionPane.showMessageDialog(rootPane, "Điểm quyết định phải là số nguyên!");
                return;
            }
        }
        else if(!ThuatToan.isInteger(jTextFieldDiem.getText().trim()) ){
                JOptionPane.showMessageDialog(rootPane, "Điểm quyết định phải là số nguyên!");
                return;
        }
        if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn lưu không?") == JOptionPane.YES_OPTION){
            switch (chucNang) {
                //Xem chi tiết tiêu chí lớn
                case "ChiTiet" -> {
                    if(jTextFieldDiem.getText().equals("")){
                        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
                        return;
                    }
                    dsTieuChi.get(chonTC).setNoiDung(jTextAreaChiTiet.getText());
                    dsTieuChi.get(chonTC).setDiem(Integer.parseInt(jTextFieldDiem.getText()));
                    new Thread(() -> {
                        Database.saveTieuChiToDB(dsTieuChi);
                        Database.addListTieuChiToTable(dsTieuChi, tableTieuChi);
                    }).start();
                    
                }
                case "ThemTC" -> {
                    if(jTextFieldDiem.getText().equals("")){
                        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
                        return;
                    }
                    TieuChi tc = new TieuChi();
                    tc.setMaTieuChi(ThuatToan.taoMaTC(dsTieuChi));
                    tc.setNoiDung(jTextAreaChiTiet.getText());
                    tc.setDiem(Integer.parseInt(jTextFieldDiem.getText()));
                    ArrayList<NoiDungTieuChi> dsND = new ArrayList<>();
                    if(choiceLoaiTC.getSelectedItem().equals("Đa nội dung")){
                        NoiDungTieuChi e = new NoiDungTieuChi();
                        
                        e.setNoiDung("Chỉnh sửa nội dung ở đây");
                        e.setDiem(10);
                        dsND.add(e);
                    }   tc.setDsNoiDung(dsND);
                    dsTieuChi.add(tc);
                    new Thread(() -> {
                        Database.saveTieuChiToDB(dsTieuChi);
                        Database.addListTieuChiToTable(dsTieuChi, tableTieuChi);
                    }).start();
                    
                }
                case "ThemND" ->{
                    int SoDiem;
                    if(jTextFieldDiem.getText().equals("")){
                        SoDiem = -50;
                    }
                    else{
                        SoDiem = Integer.parseInt(jTextFieldDiem.getText());
                    }
                    ArrayList<NoiDungTieuChi> ds = dsTieuChi.get(chonTC).getDsNoiDung();
                    NoiDungTieuChi nd = new NoiDungTieuChi();
                    nd.setNoiDung(jTextAreaChiTiet.getText());
                    nd.setDiem(SoDiem);
                    ds.add(nd);
                    dsTieuChi.get(chonTC).setDsNoiDung(ds);
                    new Thread(() -> {
                        Database.addListGiaiThichToTable(ds, tableNoiDung);
                        Database.saveTieuChiToDB(dsTieuChi);
                    }).start();
                    
                }
                default ->{
                    ArrayList<NoiDungTieuChi> ds = dsTieuChi.get(chonTC).getDsNoiDung();
                    ds.get(chonND).setNoiDung(jTextAreaChiTiet.getText());
                    int SoDiem;
                    if(jTextFieldDiem.getText().equals("")){
                        SoDiem = -50;
                    }
                    else{
                        SoDiem = Integer.parseInt(jTextFieldDiem.getText());
                    }
                    ds.get(chonND).setDiem(SoDiem);
                    dsTieuChi.get(chonTC).setDsNoiDung(ds);
                    new Thread(() -> {
                        Database.saveTieuChiToDB(dsTieuChi);
                        Database.addListGiaiThichToTable(ds, tableNoiDung);
                    }).start();
                    
                }


            }
            this.dispose();
            //Controller.saveTieuChiToDatabase(dsTieuChi);
            
        }
        
    }//GEN-LAST:event_jLabelNutLuuMouseClicked

    private void choiceLoaiTCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceLoaiTCItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_choiceLoaiTCItemStateChanged

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
            java.util.logging.Logger.getLogger(FormThem_SuaTieuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaTieuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaTieuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaTieuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormThem_SuaTieuChi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceLoaiTC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLoaiTC;
    private javax.swing.JLabel jLabelNutLuu;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMain1;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelNutXoaTieuChi;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi;
    private javax.swing.JScrollPane jScrollPaneChiTiet;
    private javax.swing.JTextArea jTextAreaChiTiet;
    private javax.swing.JTextField jTextFieldDiem;
    // End of variables declaration//GEN-END:variables
}
