/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import com.raven.swing.RoundedTextField;
import models.CoVan;
import models.Khoa;
import models.KhoaHoc;
import models.Lop;
import controller.Database;
import controller.ThuatToan;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import models.SinhVien;
/**
 *
 * @author Dat
 */
public final class FormThem_SuaLop extends javax.swing.JFrame {

    /**
     * Creates new form ThemLop
     */
    private Choice choice;
    private JTable table;
    private ArrayList<SinhVien> dsSinhVien;
    private int chon;
    private Khoa khoa;
 
    private ArrayList <Khoa> dsKhoa = null;
    private ArrayList <CoVan> dsCoVan = null;
    private ArrayList <KhoaHoc> dsKhoaHoc = null;
    private ArrayList <Lop> dsLop = null;
    private String chucNang;
    private final Color buttonHoverColor = new Color(30,115,190);
    private final Color buttonColor = new Color(221,51,51);
    
    public FormThem_SuaLop() {
        initComponents();
    }
    
    public void edit(){
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        this.setIconImage(logo);  
        //choiceKhoa.removeAll();
        Database.saveCoVanToList(dsCoVan);
        Database.saveKhoaToList(dsKhoa);
        Database.saveKhoaHocToList(dsKhoaHoc);
        switch (chucNang) {
            case "Them" -> {
                them();
            }
            case "ThemND" -> {
                themND();
            }
            case "SuaND" -> {
                suaND();
            }
            default -> {
                sua();
            }
                    
        }
    }
    
    public void them(){
        ThuatToan.addChoiceKhoa(choiceKhoa, dsKhoa);
        choiceKhoa.select("");
        ThuatToan.addChoiceKhoaHoc(choiceKhoaHoc, dsKhoaHoc);
        jLabelNutTieuDeTieuChi.setText("Thêm lớp");
    }
    
    public void themND(){
        ThuatToan.addChoiceKhoa(choiceKhoa, dsKhoa);
        choiceKhoa.removeAll();
        choiceKhoa.add(khoa.getTenKhoa());
        //choiceKhoa.add("");
        ThuatToan.addChoiceKhoaHoc(choiceKhoaHoc, dsKhoaHoc);
        ThuatToan.addChoiceCoVanTheoTen(choiceCoVan, dsCoVan, dsKhoa, khoa.getTenKhoa());
        jLabelNutTieuDeTieuChi.setText("Thêm lớp");
    }
    
    public void suaND(){
        ThuatToan.addChoiceKhoa(choiceKhoa, dsKhoa);
        choiceKhoa.select("");
        ThuatToan.addChoiceKhoaHoc(choiceKhoaHoc, dsKhoaHoc);
        Object  cell = table.getValueAt(chon, 1);
        String maLop = cell.toString();
        int temp = 0;
        for(Lop lop:dsLop){
            if(lop.getLop().equals(maLop)){
                temp = dsLop.indexOf(lop);
                break;
            }
        }       jLabelNutTieuDeTieuChi.setText("Sửa thông tin lớp");
        Lop lop = dsLop.get(temp);
        jTextFieldLop.setText(maLop);
        choiceKhoa.select(ThuatToan.doiMaKhoaThanhTenKhoa(lop.getMaKhoa(), dsKhoa));
        choiceKhoaHoc.select(lop.getMaKhoaHoc());
        jTextFieldName.setText(ThuatToan.doiMaCVThanhTen(lop.getMaCoVan(), dsCoVan));
        choiceKhoa.removeAll();
        choiceKhoa.add(khoa.getTenKhoa());
        //choiceKhoa.add("");
        ThuatToan.addChoiceKhoaHoc(choiceKhoaHoc, dsKhoaHoc);
        ThuatToan.addChoiceCoVanTheoTen(choiceCoVan, dsCoVan, dsKhoa, khoa.getTenKhoa());
        choiceCoVan.select(lop.getMaCoVan());
    }
    
    public void sua(){
        ThuatToan.addChoiceKhoa(choiceKhoa, dsKhoa);
        choiceKhoa.select("");
        ThuatToan.addChoiceKhoaHoc(choiceKhoaHoc, dsKhoaHoc);
        Object  cell = table.getValueAt(chon, 1);
        String maLop = cell.toString();
        int temp = 0;
        for(Lop lop:dsLop){
            if(lop.getLop().equals(maLop)){
                temp = dsLop.indexOf(lop);
                break;
            }
        }       jLabelNutTieuDeTieuChi.setText("Sửa thông tin lớp");
        Lop lop = dsLop.get(temp);
        jTextFieldLop.setText(maLop);
        choiceKhoa.select(ThuatToan.doiMaKhoaThanhTenKhoa(lop.getMaKhoa(), dsKhoa));
        ThuatToan.addChoiceCoVanTheoTen(choiceCoVan, dsCoVan, dsKhoa, 
                ThuatToan.doiMaKhoaThanhTenKhoa(lop.getMaKhoa(), dsKhoa));

        choiceCoVan.select(lop.getMaCoVan());
        choiceKhoaHoc.select(lop.getMaKhoaHoc());
        jTextFieldName.setText(ThuatToan.doiMaCVThanhTen(lop.getMaCoVan(), dsCoVan));
    
    }
    
    public FormThem_SuaLop(ArrayList <Khoa> dsKhoa, Khoa khoa, ArrayList <CoVan> dsCoVan, ArrayList <KhoaHoc> dsKhoaHoc, ArrayList <Lop> dsLop, JTable table, Choice choice, String chucNang) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsKhoaHoc = dsKhoaHoc;
        this.table = table;
        this.dsLop = dsLop;
        this.choice = choice;
        this.khoa = khoa;
        this.chucNang = chucNang;
        initComponents();
        edit();
    }
    
    public FormThem_SuaLop(ArrayList <Khoa> dsKhoa, ArrayList <CoVan> dsCoVan, ArrayList <KhoaHoc> dsKhoaHoc, ArrayList <Lop> dsLop, JTable table, Choice choice, String chucNang) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsKhoaHoc = dsKhoaHoc;
        this.table = table;
        this.dsLop = dsLop;
        this.choice = choice;
        this.chucNang = chucNang;
        initComponents();
        edit();
    }
    
    public FormThem_SuaLop(ArrayList <Khoa> dsKhoa, ArrayList <CoVan> dsCoVan, ArrayList <KhoaHoc> dsKhoaHoc, ArrayList <Lop> dsLop, JTable table, Choice choice, int chon, ArrayList<SinhVien> dsSinhVien, String chucNang) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsKhoaHoc = dsKhoaHoc;
        this.dsSinhVien = dsSinhVien;
        this.table = table;
        this.dsLop = dsLop;
        this.choice = choice;
        this.chon = chon;
        this.chucNang = chucNang;
        initComponents();
        edit();
    }
    
    public FormThem_SuaLop(ArrayList <Khoa> dsKhoa, Khoa khoa, ArrayList <CoVan> dsCoVan, ArrayList <KhoaHoc> dsKhoaHoc, ArrayList <Lop> dsLop, JTable table, Choice choice, int chon, ArrayList<SinhVien> dsSinhVien, String chucNang) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.khoa = khoa;
        this.dsKhoaHoc = dsKhoaHoc;
        this.dsSinhVien = dsSinhVien;
        this.table = table;
        this.dsLop = dsLop;
        this.choice = choice;
        this.chon = chon;
        this.chucNang = chucNang;
        initComponents();
        edit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelThanhTieuDeTieuChi = new javax.swing.JPanel();
        jPanelNutTieuDeTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTieuChi = new javax.swing.JLabel();
        jPanelNutLuu = RoundedPanel.createRoundedPanel();
        jLabelNutLuu = new javax.swing.JLabel();
        jPanelMainInput = new javax.swing.JPanel();
        jTextFieldLop = new RoundedTextField(15, 10, 10);
        jLabelLop = new javax.swing.JLabel();
        choiceKhoa = new java.awt.Choice();
        jLabelLop2 = new javax.swing.JLabel();
        choiceKhoaHoc = new java.awt.Choice();
        jLabelLop3 = new javax.swing.JLabel();
        choiceCoVan = new java.awt.Choice();
        jTextFieldName = new RoundedTextField(15, 10, 10);
        jLabelLop1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTieuChi.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclass.png"))); // NOI18N
        jLabelNutTieuDeTieuChi.setText("Thêm");
        jLabelNutTieuDeTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi);
        jPanelNutTieuDeTieuChi.setLayout(jPanelNutTieuDeTieuChiLayout);
        jPanelNutTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTieuChiLayout.setVerticalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutLuu.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout jPanelNutLuuLayout = new javax.swing.GroupLayout(jPanelNutLuu);
        jPanelNutLuu.setLayout(jPanelNutLuuLayout);
        jPanelNutLuuLayout.setHorizontalGroup(
            jPanelNutLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutLuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutLuuLayout.setVerticalGroup(
            jPanelNutLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTieuChi);
        jPanelThanhTieuDeTieuChi.setLayout(jPanelThanhTieuDeTieuChiLayout);
        jPanelThanhTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTieuChiLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jPanelNutLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTieuChiLayout.setVerticalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelThanhTieuDeTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 40));

        jPanelMainInput.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMainInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanelMainInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FormDangNhap.setBorderTextField(jTextFieldLop);
        jTextFieldLop.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jTextFieldLop.setForeground(new java.awt.Color(51, 51, 51));
        jTextFieldLop.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMainInput.add(jTextFieldLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 350, 41));

        jLabelLop.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabelLop.setText("Khoa");
        jLabelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMainInput.add(jLabelLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 58, -1, 32));

        choiceKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choiceKhoaMouseClicked(evt);
            }
        });
        choiceKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoaItemStateChanged(evt);
            }
        });
        jPanelMainInput.add(choiceKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 58, 190, 32));

        jLabelLop2.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabelLop2.setText("Khóa học");
        jLabelLop2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMainInput.add(jLabelLop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, 32));

        choiceKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoaHoc.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoaHoc.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoaHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoaHocItemStateChanged(evt);
            }
        });
        jPanelMainInput.add(choiceKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 58, 90, 32));

        jLabelLop3.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabelLop3.setText("Cố vấn");
        jLabelLop3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMainInput.add(jLabelLop3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 100, 40, 40));

        choiceCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceCoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceCoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceCoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceCoVanItemStateChanged(evt);
            }
        });
        jPanelMainInput.add(choiceCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 100, 104, 30));

        FormDangNhap.setBorderTextField(jTextFieldName);
        jTextFieldName.setEditable(false);
        jTextFieldName.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldName.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jTextFieldName.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldName.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jPanelMainInput.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 100, 220, 30));

        jLabelLop1.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabelLop1.setText("Lớp");
        jLabelLop1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMainInput.add(jLabelLop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 46));

        jPanelMain.add(jPanelMainInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 410, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choiceKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoaItemStateChanged
        // TODO add your handling code here:
        ThuatToan.addChoiceCoVanTheoTen(choiceCoVan, dsCoVan, dsKhoa, choiceKhoa.getSelectedItem());
        CoVan c = new CoVan();
        for(CoVan cv : dsCoVan){
            if(cv.getKhoa().equals(ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa.getSelectedItem(), dsKhoa))){
                c = cv;
                break;
            }
        }
        jTextFieldName.setText(c.getTenCV());
    }//GEN-LAST:event_choiceKhoaItemStateChanged

    private void choiceKhoaHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoaHocItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_choiceKhoaHocItemStateChanged

    private void choiceCoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceCoVanItemStateChanged
        // TODO add your handling code here:
        String ten = ThuatToan.doiMaCVThanhTen(choiceCoVan.getSelectedItem(), dsCoVan);
        jTextFieldName.setText(ten);
    }//GEN-LAST:event_choiceCoVanItemStateChanged

    private void choiceKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceKhoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceKhoaMouseClicked

    public void luuLop_Them(){
        new Thread(() -> {
            Database.saveLopToList(dsLop);
            Lop lop = new Lop();
            lop.setLop(jTextFieldLop.getText().toUpperCase());
            lop.setMaKhoa(ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa.getSelectedItem(), dsKhoa));
            String maCoVan;
            if(choiceCoVan.getSelectedItem()==null){
                maCoVan = lop.getMaCoVan();
            }else{
                maCoVan = choiceCoVan.getSelectedItem();
            }
            lop.setMaCoVan(maCoVan);
            lop.setMaKhoaHoc(choiceKhoaHoc.getSelectedItem());
            dsLop.add(lop);

            if(choice.getSelectedItem().equals("Tất cả")){
                Database.addListLopToTable(dsLop, table, dsKhoa, dsCoVan);
            } else {
               Database.addListLopToTable_Khoa(dsLop, table, dsKhoa, dsCoVan, ThuatToan.doiTenKhoaThanhMaKhoa(choice.getSelectedItem(), dsKhoa));
            }
            Database.saveListLopToDB(dsLop);
        }).start();
        this.dispose();
    }
    
    public void getCell(){
        
    }
    
    public void luuLop_Sua(){
        new Thread(() -> {
            Object  cell = table.getValueAt(chon, 1);
            String maLop = cell.toString();
            int temp = 0;
            Database.saveLopToList(dsLop);
            Database.saveSinhVienToList(dsSinhVien);
            for(int i=0; i<dsLop.size(); i++){
                if(dsLop.get(i).getLop().equals(maLop)){
                    temp = i;
                    break;
                }
            }

            dsLop.get(temp).setLop(jTextFieldLop.getText().toUpperCase());
            dsLop.get(temp).setMaKhoa(ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa.getSelectedItem(), dsKhoa));
            dsLop.get(temp).setMaKhoaHoc(choiceKhoaHoc.getSelectedItem());
            if(choiceCoVan.getSelectedItem()!=null){
                dsLop.get(temp).setMaCoVan(choiceCoVan.getSelectedItem());
            }
            Database.saveListLopToDB(dsLop);
            if(choice.getSelectedItem().trim().equals("Tất cả")){
                Database.addListLopToTable(dsLop, table, dsKhoa, dsCoVan);
            } else {
                Database.addListLopToTable_Khoa(dsLop, table, dsKhoa, dsCoVan, ThuatToan.doiTenKhoaThanhMaKhoa(choice.getSelectedItem(), dsKhoa));
            }
            ThuatToan.doiLopDsSV(dsSinhVien, maLop, jTextFieldLop.getText().toUpperCase());
            Database.saveListSinhVienToDB(dsSinhVien);
            Database.saveListLopToDB(dsLop);
        }).start();
        this.dispose();
    }
    
    private void jLabelNutLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseClicked
        if(jTextFieldLop.getText().equals("") || 
            choiceCoVan.getSelectedItem()==null ||
            choiceKhoa.getSelectedItem().equals("Tất cả")){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
        }
        else{
            if(chucNang.equals("Them") || chucNang.equals("ThemND")){
                if(ThuatToan.isRepeatLop(dsLop, jTextFieldLop.getText().toUpperCase())){
                    JOptionPane.showMessageDialog(rootPane, "Lớp đã có trên hệ thống!");
                    return;
                }
                int them = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thêm không?");
                if( them == JOptionPane.YES_OPTION){
                    luuLop_Them();
                }else if(them == JOptionPane.NO_OPTION){
                    this.dispose();
                }
            }
            
            
            else{  
                Object  cell = table.getValueAt(chon, 1);
                String maLop = cell.toString();
                Database.saveLopToList(dsLop);
                if(!maLop.equals(jTextFieldLop.getText().toUpperCase())){
                    if(ThuatToan.isRepeatLop(dsLop, jTextFieldLop.getText().toUpperCase())){
                        JOptionPane.showMessageDialog(rootPane, "Lớp đã có trên hệ thống!");
                        return;
                    }
                }
                int them = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa không?");
                if( them == JOptionPane.YES_OPTION) {
                    luuLop_Sua();
                }
                else if(them == JOptionPane.NO_OPTION){
                    this.dispose();
                }
            }
        }
            
        
    }//GEN-LAST:event_jLabelNutLuuMouseClicked

    private void jLabelNutLuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseEntered
        // TODO add your handling code here:
        jPanelNutLuu.setBackground(buttonHoverColor);
    }//GEN-LAST:event_jLabelNutLuuMouseEntered

    private void jLabelNutLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseExited
        // TODO add your handling code here:
        jPanelNutLuu.setBackground(buttonColor);
    }//GEN-LAST:event_jLabelNutLuuMouseExited

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
            java.util.logging.Logger.getLogger(FormThem_SuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormThem_SuaLop().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceCoVan;
    private java.awt.Choice choiceKhoa;
    private java.awt.Choice choiceKhoaHoc;
    private javax.swing.JLabel jLabelLop;
    private javax.swing.JLabel jLabelLop1;
    private javax.swing.JLabel jLabelLop2;
    private javax.swing.JLabel jLabelLop3;
    private javax.swing.JLabel jLabelNutLuu;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMainInput;
    private javax.swing.JPanel jPanelNutLuu;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi;
    private javax.swing.JTextField jTextFieldLop;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
