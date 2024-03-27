/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class RoundedPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(7,7);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ hình chữ nhật bo tròn
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
    }
    
    public static JPanel createRoundedPanel() {
        JPanel panel = new RoundedPanel();
        panel.setOpaque(false);
        return panel;
    }
}


class RoundedPanel2 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(20,20);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ hình chữ nhật bo tròn
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
    }
    
    public static JPanel createRoundedPanel() {
        JPanel panel = new RoundedPanel2();
        panel.setOpaque(false);
        return panel;
    }
}


/**
 *
 * @author Dat
 */
public class FormDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form FormDangNhap
     */
    public void suKienMenu(){
        setLocationRelativeTo(null);
        
    }
    
    
    public FormDangNhap() {
        initComponents();
        suKienMenu();
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
        jLabelLogo = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelPhanMem = new javax.swing.JLabel();
        jTextFieldTenDN = new javax.swing.JTextField();
        jLabelMatKhau = new javax.swing.JLabel();
        jLabelTenDN = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanelDangNhap = new javax.swing.JPanel();
        jLabelDangNhap = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dat\\Documents\\GitHub\\QLDRL\\AppDRL\\src\\main\\java\\icons\\logo_ptit.png")); // NOI18N
        jPanelMain.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 21, 390, 119));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Đăng nhập");
        jPanelMain.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 390, -1));

        jLabelPhanMem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPhanMem.setForeground(new java.awt.Color(51, 51, 51));
        jLabelPhanMem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhanMem.setText("Phần mềm chấm ĐRL");
        jPanelMain.add(jLabelPhanMem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 390, 34));

        jTextFieldTenDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldTenDN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextFieldTenDN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMain.add(jTextFieldTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 370, 40));

        jLabelMatKhau.setForeground(new java.awt.Color(153, 153, 153));
        jLabelMatKhau.setText("Mật khẩu");
        jPanelMain.add(jLabelMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 370, -1));

        jLabelTenDN.setForeground(new java.awt.Color(153, 153, 153));
        jLabelTenDN.setText("Tên đăng nhập");
        jPanelMain.add(jLabelTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 370, -1));

        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPasswordField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMain.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 370, 40));

        jPanelDangNhap.setBackground(new java.awt.Color(221, 51, 51));

        jLabelDangNhap.setBackground(new java.awt.Color(221, 25, 25));
        jLabelDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDangNhap.setText("Đăng nhập");
        jLabelDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDangNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDangNhapLayout = new javax.swing.GroupLayout(jPanelDangNhap);
        jPanelDangNhap.setLayout(jPanelDangNhapLayout);
        jPanelDangNhapLayout.setHorizontalGroup(
            jPanelDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanelDangNhapLayout.setVerticalGroup(
            jPanelDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 370, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ban quản lý học viện", "Cố vấn học tập", "Ban cán sự lớp", "Sinh viên" }));
        jComboBox1.setToolTipText("");
        jPanelMain.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 370, 40));

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Bạn là??? (demo trước khi có tài khoản và mật khẩu)");
        jPanelMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDangNhapMouseClicked
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem().equals("Ban quản lý học viện")){
            new FormQuanLy().setVisible(true);
            
        }
        else if(jComboBox1.getSelectedItem().equals("Cố vấn học tập")){
            new FormCoVan().setVisible(true);
            
        }
        else if(jComboBox1.getSelectedItem().equals("Sinh viên")){
            new FormSinhVien().setVisible(true);
            
        }
        else if(jComboBox1.getSelectedItem().equals("Ban cán sự lớp")){
            new FormBanCanSu().setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập, mật khẩu không đúng!");
        }
        
    }//GEN-LAST:event_jLabelDangNhapMouseClicked

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
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDangNhap;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMatKhau;
    private javax.swing.JLabel jLabelPhanMem;
    private javax.swing.JLabel jLabelTenDN;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelDangNhap;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldTenDN;
    // End of variables declaration//GEN-END:variables
}
