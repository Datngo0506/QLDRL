/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import models.CoVan;
import models.Khoa;
import models.Lop;
import models.TaiKhoan;


///đâyỷ
/**
 *
 * @author Dat
 */
public final class SuaKhoa extends javax.swing.JFrame {

    /**
     * Creates new form SuaKhoa
     */
    private ArrayList <Khoa> dsKhoa;
    private ArrayList <TaiKhoan> TaiKhoan;
    private ArrayList <CoVan> dsCoVan;
    private ArrayList <Lop> dsLop;
    private JTable table;
    private int chon;
    private Khoa khoa;
    
    public void edit(){
        setLocationRelativeTo(null);
      
        khoa = dsKhoa.get(chon);
         String[] parts = khoa.getNgayThanhLap().split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        jTextFieldMaKhoa.setText(khoa.getMaKhoa());
        jTextFieldTenKhoa.setText(khoa.getTenKhoa());
        jTextFieldYear.setText(year);
        Controller.addChoiceMonths(choiceMonth);
        Controller.addChoiceDay(choiceDate, 31);
        int m = Integer.parseInt(month);
        month = Integer.toString(m);
        choiceMonth.select(month);
        int d = Integer.parseInt(day);
        day = Integer.toString(d);
        choiceDate.select(day);
        jPasswordFieldPass.setText(Controller.getMatKhau(TaiKhoan,khoa.getMaKhoa()));
        //jTextFieldTenDangNhap.setText(khoa.getMaKhoa());
        //jPasswordFieldPass.set
    }
    public SuaKhoa() {
        this.khoa = dsKhoa.get(chon);
        initComponents();
    }
    
    public SuaKhoa(ArrayList<Khoa> khoa, JTable table, int chon, ArrayList<TaiKhoan> TaiKhoan, ArrayList<CoVan> dsCoVan, ArrayList<Lop> dsLop){
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.chon = chon;
        this.TaiKhoan = TaiKhoan;
        this.dsCoVan = dsCoVan;
        this.dsLop = dsLop;
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
        jTextFieldMaKhoa = new javax.swing.JTextField();
        jTextFieldTenKhoa = new javax.swing.JTextField();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelSubmit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldYear = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        choiceMonth = new java.awt.Choice();
        jLabel8 = new javax.swing.JLabel();
        choiceDate = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("SỬA THÔNG TIN KHOA");

        jTextFieldMaKhoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextFieldMaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextFieldTenKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPasswordFieldPass.setText("jPasswordField1");

        jLabel2.setText("Mã khoa");

        jLabel3.setText("Tên khoa");

        jLabel4.setText("Ngày thành lập");

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

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Nhập năm ( 4 chữ số )");

        jTextFieldYear.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldYearMouseExited(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Chọn tháng");

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

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Chọn ngày");

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

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSubmit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTenKhoa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldMaKhoa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jTextFieldMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(choiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSubmitMouseClicked
        // TODO add your handling code here:
        char[] passwordChars = jPasswordFieldPass.getPassword();
            // Chuyển mật khẩu thành chuỗi String
            String password = new String(passwordChars);
        if((((jTextFieldMaKhoa.getText().equals("") || jTextFieldTenKhoa.getText().equals("") || jTextFieldYear.getText().equals("")) || password.equals("")) || choiceDate.getSelectedItem().equals(""))||choiceMonth.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
        }
        else{
            int sua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa thông tin không?");
            if(sua == JOptionPane.YES_OPTION){
                String maKhoa = jTextFieldMaKhoa.getText().toUpperCase();
                if(!maKhoa.equals(dsKhoa.get(chon).getMaKhoa())){
                    if(Controller.isRepeatMaKhoa(dsKhoa, maKhoa)){
                        JOptionPane.showMessageDialog(rootPane, "Mã khoa đã tồn tại trên hệ thống!");
                        return;
                    }
                }
                String thang = choiceMonth.getSelectedItem();
                if(thang.length()<2) thang = "0" + thang;
                String ngay = choiceDate.getSelectedItem();
                if(ngay.length()<2) ngay = "0" + ngay;
                String rs = jTextFieldYear.getText()+"-"+ngay+"-"+thang;

                String tenKhoa = Controller.chuanHoaTen(jTextFieldTenKhoa.getText());
                //Thêm vào bảng
                table.setValueAt(maKhoa, chon , 0);
                table.setValueAt(tenKhoa, chon , 1);
                table.setValueAt(rs, chon , 2);
                table.setValueAt(maKhoa, chon , 3);
                table.setValueAt(Controller.changePass(password), chon, 4);
                Controller.suaKhoaTrongCoVan(dsCoVan, dsKhoa.get(chon).getMaKhoa(), maKhoa);
                Controller.suaKhoaTrongLop(dsLop, dsKhoa.get(chon).getMaKhoa(), maKhoa);
                for(TaiKhoan tk: TaiKhoan){
                    if(tk.getTenTK().equals(dsKhoa.get(chon).getMaKhoa())){
                        tk.setTenTK(maKhoa);
                        tk.setMaTK("TK"+maKhoa);
                        tk.setMatKhau(password);
                    }
                }

                dsKhoa.get(chon).setMaKhoa(maKhoa);
                dsKhoa.get(chon).setTenKhoa(tenKhoa);
                dsKhoa.get(chon).setNgayThanhLap(rs);
                Controller.addListToLop(dsLop);
                Controller.addListToCoVan(dsCoVan);
                Controller.addListToKhoa(dsKhoa);
                //Controller.doiMatKhau(TaiKhoan, dsKhoa.get(chon).getMaKhoa(), password);
                Controller.addListToTaiKhoan(TaiKhoan);
                this.setVisible(false);
                
            }
            else if(sua == JOptionPane.NO_OPTION){
                this.setVisible(false);
            }
        }
        //System.out.println(dsKhoa.get(chon).getTenKhoa());
    }//GEN-LAST:event_jLabelSubmitMouseClicked

    private void jTextFieldYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldYearMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldYearMouseExited

    private void choiceMonthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceMonthMouseExited
        // TODO add your handling code here:
        // TODO add your handling code here:

    }//GEN-LAST:event_choiceMonthMouseExited

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

    private void choiceDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceDateMouseClicked

    private void choiceDateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choiceDateMouseEntered

    }//GEN-LAST:event_choiceDateMouseEntered

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
            java.util.logging.Logger.getLogger(SuaKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaKhoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceDate;
    private java.awt.Choice choiceMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelSubmit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldMaKhoa;
    private javax.swing.JTextField jTextFieldTenKhoa;
    private javax.swing.JTextField jTextFieldYear;
    // End of variables declaration//GEN-END:variables
}
