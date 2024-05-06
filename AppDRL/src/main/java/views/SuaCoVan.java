/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.Controller;
import java.awt.Choice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.CoVan;
import models.Khoa;

/**
 *
 * @author Dat
 */
public final class SuaCoVan extends javax.swing.JFrame {

    /**
     * Creates new form SuaKhoa
     */
    private ArrayList <Khoa> dsKhoa;
    private ArrayList <CoVan> dsCoVan;
    private Choice ch;
    private JTable table;
    private int chon;
    private Khoa khoa;
    
    public void edit(){
        setLocationRelativeTo(null);
        Object cellValue = table.getValueAt(chon, 0);
        System.out.println(cellValue);
        int hub = 0;
        for(int i=0; i<dsCoVan.size(); i++){
            if(dsCoVan.get(i).getMaCV().equals(cellValue.toString())){
                hub = i;
                //xoa = i;
            }
        }
        CoVan cv = dsCoVan.get(hub);
        //jTextFieldMaCoVan.setText(cv.getMaCV());
        jTextFieldTenCoVan.setText(cv.getTenCV());
        jTextFieldSdt.setText(cv.getSdt());
        jTextFieldQueQuan.setText(cv.getQueQuan());
        jTextFieldDiaChi.setText(cv.getDiaChi());
        //cho
        Controller.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
       //jTextFieldTenCoVan.setText(khoa.)
        //jTextFieldNgay.setText(khoa.getNgayThanhLap());
        //jTextFieldKhoa.setText(khoa.getMaKhoa());
        //jPasswordFieldPass.set
        
        choiceKhoa_CoVan.remove("Tất cả");
        choiceKhoa_CoVan.select(Controller.doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa));
        choiceGioiTinh_Sua.add("Nam");
        choiceGioiTinh_Sua.add("Nữ");
        choiceGioiTinh_Sua.select(Controller.doiBoolToGioiTinh(cv.getGioiTinh()));
        String[] parts = cv.getNgaySinh().split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        jTextFieldYear.setText(year);
        Controller.addChoiceMonths(choiceMonth);
        Controller.addChoiceDay(choiceDate, 31);
        int m = Integer.parseInt(month);
        month = Integer.toString(m);
        choiceMonth.select(month);
        int d = Integer.parseInt(day);
        day = Integer.toString(d);
        choiceDate.select(day);
        jPasswordFieldPass.setText(cv.getMk());
        
    }
    public SuaCoVan() {
        //this.khoa = dsKhoa.get(chon);
        initComponents();
    }
    
    public SuaCoVan(ArrayList<Khoa> khoa, JTable table, int chon, ArrayList<CoVan> coVan, Choice ch){
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.chon = chon;
        this.ch = ch;
        this.dsCoVan = coVan;
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
        jLabelTitle = new javax.swing.JLabel();
        jTextFieldSdt = new javax.swing.JTextField();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelSubmit = new javax.swing.JLabel();
        choiceGioiTinh_Sua = new java.awt.Choice();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldYear = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        choiceMonth = new java.awt.Choice();
        jLabel9 = new javax.swing.JLabel();
        choiceDate = new java.awt.Choice();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTenCoVan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldQueQuan = new javax.swing.JTextField();
        choiceKhoa_CoVan = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("SỬA THÔNG TIN CỐ VẤN");

        jPasswordFieldPass.setText("jPasswordField1");

        jLabel3.setText("Tên cố vấn");

        jLabel4.setText("Ngày sinh");

        jLabel6.setText("Mật khẩu");

        jLabelSubmit.setBackground(new java.awt.Color(221, 51, 51));
        jLabelSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubmit.setText("SỬA");
        jLabelSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSubmit.setOpaque(true);
        jLabelSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSubmitMouseClicked(evt);
            }
        });

        choiceGioiTinh_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceGioiTinh_Sua.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        choiceGioiTinh_Sua.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceGioiTinh_Sua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceGioiTinh_SuaItemStateChanged(evt);
            }
        });

        jLabel7.setText("Giới tính");

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Năm");

        jTextFieldYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldYearMouseExited(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Tháng");

        choiceMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceMonth.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        choiceMonth.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choiceMonthMouseExited(evt);
            }
        });
        choiceMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceMonthItemStateChanged(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Ngày");

        choiceDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceDate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        choiceDate.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choiceDateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choiceDateMouseEntered(evt);
            }
        });
        choiceDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceDateItemStateChanged(evt);
            }
        });

        jLabel5.setText("Khoa");

        jLabel10.setText("Số điện thoại");

        jLabel12.setText("Quê quán");

        jLabel13.setText("Địa chỉ");

        choiceKhoa_CoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_CoVan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_CoVanItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTenCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(choiceGioiTinh_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(choiceMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(choiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldTenCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(choiceGioiTinh_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addComponent(choiceMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabelSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choiceKhoa_CoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_CoVanItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceKhoa_CoVanItemStateChanged

    private void choiceDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceDateItemStateChanged
        // TODO add your handling code here:
        //        String year = jTextFieldYear.getSelectedText();
        //        if(year.equals("")){
            //            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập năm!");
            //        }
        //        else if(year.length()!=4 || Integer.parseInt(year) <= 0){
            //            JOptionPane.showMessageDialog(rootPane, "Năm không đúng định dạng!");
            //        }
        //        else{
            //            String thang = choiceMonth.getSelectedItem();
            //            switch (thang) {
                //                case "Tháng 1", "Tháng 3", "Tháng 5", "Tháng 7", "Tháng 8", "Tháng 10", "Tháng 12" -> Controller.addChoiceDay(choiceDate, 31);
                //                case "Tháng 4", "Tháng 6", "Tháng 9", "Tháng 11" -> Controller.addChoiceDay(choiceDate, 30);
                //                default -> {
                    //                    if(Integer.parseInt(year)%2024==0){
                        //                        Controller.addChoiceDay(choiceDate, 29);
                        //                    }
                    //                    else{
                        //                        Controller.addChoiceDay(choiceDate, 28);
                        //                    }
                    //                }
                //            }
            //        }
        String year = jTextFieldYear.getText();

        //choiceDate.removeAll();
        if(year.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập năm!");
            choiceMonth.select("1");
            choiceDate.select("1");
        }
        else if(year.length()!=4 || Integer.parseInt(year) <= 0){
            JOptionPane.showMessageDialog(rootPane, "Năm không đúng định dạng!");
            choiceMonth.select("1");
            choiceDate.select("1");
        }
    }//GEN-LAST:event_choiceDateItemStateChanged

    private void choiceDateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceDateMouseEntered

    }//GEN-LAST:event_choiceDateMouseEntered

    private void choiceDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceDateMouseClicked

    private void choiceMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceMonthItemStateChanged
        String year = jTextFieldYear.getText();

    //choiceDate.removeAll();
    if(year.equals("")){
        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập năm!");
        choiceMonth.select("1");
        choiceDate.select("1");
    }
    else if(year.length()!=4 || Integer.parseInt(year) <= 0){
        JOptionPane.showMessageDialog(rootPane, "Năm không đúng định dạng!");
        choiceMonth.select("1");
        choiceDate.select("1");
    }
    else{
        String thang = choiceMonth.getSelectedItem();
        choiceDate.removeAll();
        switch (thang) {
            case "1", "3", "5", "7", "8", "10", "12" -> Controller.addChoiceDay(choiceDate, 31);
            case "4", "6", "9", "11" -> Controller.addChoiceDay(choiceDate, 30);
            default -> {
                if(Integer.parseInt(year)%2024==0){
                    Controller.addChoiceDay(choiceDate, 29);
                }
                else{
                    Controller.addChoiceDay(choiceDate, 28);
                }
            }
        }
    }
    }//GEN-LAST:event_choiceMonthItemStateChanged

    private void choiceMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceMonthMouseExited
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceMonthMouseExited

    private void jTextFieldYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldYearMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldYearMouseExited

    private void choiceGioiTinh_SuaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceGioiTinh_SuaItemStateChanged
        // TODO add your handling code here:
        //        String maKhoa = Controller.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa);
        //        if(maKhoa.equals("")){
            //            Controller.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa);
            //        }
        //        else{
            //            Controller.addListCoVanToTable_MaKhoa(dsCoVan, jTableCoVan, dsKhoa, maKhoa);
            //        }
    }//GEN-LAST:event_choiceGioiTinh_SuaItemStateChanged

    private void jLabelSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSubmitMouseClicked
        // Lấy mật khẩu từ JPasswordField
        char[] passwordChars = jPasswordFieldPass.getPassword();
        String password = new String(passwordChars);
        //System.out.println(password);
        // Kiểm tra xem các trường thông tin đã được nhập đầy đủ chưa
        if(jTextFieldTenCoVan.getText().equals("") || jTextFieldSdt.getText().equals("") || jTextFieldQueQuan.getText().equals("") || jTextFieldDiaChi.getText().equals("") || password.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
        } else {
            // Hiển thị hộp thoại xác nhận trước khi sửa
            //int xoa = 0;
            int sua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa thông tin không?");
            if(sua == JOptionPane.YES_OPTION){
                
                // Cập nhật thông tin trong dsCoVan
                        //CoVan cv = dsCoVan.get(chon);
                        int hub=0;
                        String thang = choiceMonth.getSelectedItem();
                        if(thang.length()<2) thang = "0" + thang;
                        String ngay = choiceDate.getSelectedItem();
                        if(ngay.length()<2) ngay = "0" + ngay;
                        String ngaySinh = jTextFieldYear.getText() + "-" + thang + "-" + ngay; // Ngày sinh
                        Object cellValue = table.getValueAt(chon, 0);
                        
                        for(int i=0; i<dsCoVan.size(); i++){
                            if(dsCoVan.get(i).getMaCV().equals(cellValue.toString())){
                                hub = i;
                                //xoa = i;
                            }
                        }
                        dsCoVan.get(hub).setTenCV(jTextFieldTenCoVan.getText());
                        dsCoVan.get(hub).setKhoa(Controller.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa));
                        dsCoVan.get(hub).setGioiTinh(Controller.doiGioiTinhToBool(choiceGioiTinh_Sua.getSelectedItem()));
                        dsCoVan.get(hub).setNgaySinh(ngaySinh);
                        dsCoVan.get(hub).setSdt(jTextFieldSdt.getText());
                        dsCoVan.get(hub).setQueQuan(jTextFieldQueQuan.getText());
                        dsCoVan.get(hub).setDiaChi(jTextFieldDiaChi.getText());
                        dsCoVan.get(hub).setMk(password);
                        if(ch.getSelectedItem().equals("Tất cả")){
                            Controller.addListCoVanToTable(dsCoVan, table, dsKhoa);
                        }
                        else{
                            Controller.addListCoVanToTable_MaKhoa(dsCoVan, table, dsKhoa, Controller.doiTenKhoaThanhMaKhoa(ch.getSelectedItem(), dsKhoa));
                        }

                try {
                    // Cập nhật thông tin trong bảng CoVan
                    try ( // Tạo kết nối tới cơ sở dữ liệu
                            Connection con = Controller.getConnection()) {
                        // Cập nhật thông tin trong bảng CoVan
                        String updateQuery = "UPDATE CoVan SET TenCoVan=?, khoa=?, gioiTinh=?, ngaySinh=?, sdt=?, queQuan=?, diaChi=? WHERE MaCoVan=?";
                        PreparedStatement pstmt = con.prepareStatement(updateQuery);
                        pstmt.setString(1, jTextFieldTenCoVan.getText()); // Tên cố vấn
                        pstmt.setString(2, Controller.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa)); // Mã khoa
                        pstmt.setString(3, Controller.doiGioiTinhToBool(choiceGioiTinh_Sua.getSelectedItem())); // Giới tính

                        pstmt.setString(4, ngaySinh);
                        pstmt.setString(5, jTextFieldSdt.getText()); // Số điện thoại
                        //pstmt.setString(6, ""); // Email (bạn chưa có trường này trong giao diện)
                        pstmt.setString(6, jTextFieldQueQuan.getText()); // Quê quán
                        pstmt.setString(7, jTextFieldDiaChi.getText()); // Địa chỉ
                        pstmt.setString(8, dsCoVan.get(hub).getMaCV()); // Mã cố vấn
                        pstmt.executeUpdate();
                        
                        
                        
                        // Cập nhật mật khẩu trong bảng TaiKhoan
                        String updatePassQuery = "UPDATE TaiKhoan SET MatKhau=? WHERE TenTK=?";
                        PreparedStatement pstmtPass = con.prepareStatement(updatePassQuery);
                        pstmtPass.setString(1, password); // Mật khẩu
                        pstmtPass.setString(2, dsCoVan.get(hub).getMaCV()); // Tên tài khoản (Mã cố vấn)
                        pstmtPass.executeUpdate();
                        
                    }
                } catch (SQLException ex) {
                    // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
                    //ex.printStackTrace();
                }
                this.setVisible(false);

            } else if(sua == JOptionPane.NO_OPTION){
                // Đóng cửa sổ nếu không muốn sửa nữa
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jLabelSubmitMouseClicked

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
            java.util.logging.Logger.getLogger(SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaCoVan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceDate;
    private java.awt.Choice choiceGioiTinh_Sua;
    private java.awt.Choice choiceKhoa_CoVan;
    private java.awt.Choice choiceMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSubmit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldQueQuan;
    private javax.swing.JTextField jTextFieldSdt;
    private javax.swing.JTextField jTextFieldTenCoVan;
    private javax.swing.JTextField jTextFieldYear;
    // End of variables declaration//GEN-END:variables
}
