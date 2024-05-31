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
import controller.Database;
import java.awt.Color;
import java.awt.Image;
import com.raven.swing.RoundedTextField;
import com.raven.swing.RoundedPasswordField;
import controller.ThuatToan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import models.ChucVu;
import models.CoVan;
import models.DRL;
import models.HocKy;
import models.Khoa;
import models.KhoaHoc;
import models.Lop;
import models.SinhVien;
import models.TaiKhoan;
import models.ThongBao;
import models.TieuChi;



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
public final class FormDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form FormDangNhap
     * @param frame
     */
    
    
    private final ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
    private final ArrayList<Khoa> dsKhoa = new ArrayList<>();
    private final ArrayList<CoVan> dsCoVan = new ArrayList<>();
    private final ArrayList<HocKy> dsHocKy = new ArrayList<>();
    private final ArrayList<KhoaHoc> dsKhoaHoc = new ArrayList<>();
    private final ArrayList<Lop> dsLop = new ArrayList<>();
    private final ArrayList<TieuChi> dsTieuChi = new ArrayList<>();
    private final ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
    private final ArrayList<ChucVu> dsChucVu = new ArrayList<>();
    private final ArrayList<ThongBao> dsThongBao = new ArrayList<>();
    private final ArrayList<DRL> dsDRL = new ArrayList<>();
    private Khoa khoa = new Khoa();
    private Lop lop = new Lop();
    private SinhVien sv = new SinhVien();
    private CoVan cv = new CoVan();
    private TaiKhoan tk = new TaiKhoan();
    private String role = "";
    private boolean flag = false;
    
    
    public void setIconFrame(JFrame frame){
        //JFrame.setDefaultLookAndFeelDecorated(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        frame.setIconImage(logo);
    }


    public static void setBorderTextField( JTextField textField){
        Border currentBorder = textField.getBorder();

        // Tạo một EmptyBorder với khoảng cách 5px
        Border emptyBorder = new EmptyBorder(0, 10, 0, 10);

        // Kết hợp border hiện tại và emptyBorder bằng CompoundBorder
        Border compoundBorder = new CompoundBorder(currentBorder, emptyBorder);

        // Đặt compoundBorder cho JTextField
        textField.setBorder(compoundBorder);
    }
    
    public static void setBorderTextArea( JTextArea textField){
        Border currentBorder = textField.getBorder();

        // Tạo một EmptyBorder với khoảng cách 5px
        Border emptyBorder = new EmptyBorder(0, 10, 0, 10);

        // Kết hợp border hiện tại và emptyBorder bằng CompoundBorder
        Border compoundBorder = new CompoundBorder(currentBorder, emptyBorder);

        // Đặt compoundBorder cho JTextField
        textField.setBorder(compoundBorder);
    }
    
    public static void setBorderPassword( JPasswordField textField){
        Border currentBorder = textField.getBorder();

        // Tạo một EmptyBorder với khoảng cách 5px
        Border emptyBorder = new EmptyBorder(10, 10, 10, 10);

        // Kết hợp border hiện tại và emptyBorder bằng CompoundBorder
        Border compoundBorder = new CompoundBorder(currentBorder, emptyBorder);

        // Đặt compoundBorder cho JTextField
        textField.setBorder(compoundBorder);
    }
    
    public void suKienMenu(){
        
        setLocationRelativeTo(null);
        setIconFrame(this);
        setBorderTextField(jTextFieldTenDN);
        setBorderTextField(jPasswordField);
        jButton1.addActionListener((ActionEvent e) -> {
            click();
        });
        bindKeyStroke(jButton1, "enter");
        // Ẩn các nút tắt trên cửa sổ
        //setUndecorated(true);
    }

    public FormDangNhap() {
        //setRootPaneCheckingEnabled(false);
        getData();
        if(dsTaiKhoan.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Lỗi kết nối, xin hãy khởi động lại!");
            System.exit(0);
        }
        initComponents();
        suKienMenu();
        
    }
    
    private void getData(){
        // Tạo một ExecutorService để thực hiện các tác vụ bất đồng bộ
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Tạo một Future để theo dõi tiến trình của tác vụ
        Future<?> future = executor.submit(() -> {
            Database.saveTaiKhoanToList(dsTaiKhoan);
            Database.saveKhoaToList(dsKhoa);
            Database.saveCoVanToList(dsCoVan);
            Database.saveHocKyToList(dsHocKy);
            Database.saveKhoaHocToList(dsKhoaHoc);
            Database.saveLopToList(dsLop);
            Database.saveTieuChiToList(dsTieuChi);
            Database.saveSinhVienToList(dsSinhVien);
            Database.saveChucVuToList(dsChucVu);
            Database.saveThongBaoToList(dsThongBao);
            Database.saveDRLToList(dsDRL);
        });

        try {
            // Chờ tác vụ hoàn thành
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            //e.printStackTrace();
        } finally {
            // Kết thúc ExecutorService sau khi tất cả các tác vụ đã hoàn thành
            executor.shutdown();
        }
        
        

        // Sau khi tất cả các tác vụ đã hoàn thành, bạn có thể thực hiện xử lý tiếp theo
        new Thread(() -> {
            ThuatToan.sapXepTheoDRL(dsDRL);
            ThuatToan.sapXepTheoDRL_HK(dsDRL);
        }).start();

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
        jTextFieldTenDN = new RoundedTextField(15, 10, 10);
        jLabelQuenMatKhau = new javax.swing.JLabel();
        jLabelTenDN = new javax.swing.JLabel();
        jPasswordField = new RoundedPasswordField(15, 10, 10);
        jLabelSubmit = new javax.swing.JLabel();
        jLabelMatKhau = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo_ptit.png"))); // NOI18N
        jPanelMain.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 21, 390, 119));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(51, 51, 51));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Đăng nhập");
        jPanelMain.add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 390, -1));

        jLabelPhanMem.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelPhanMem.setForeground(new java.awt.Color(51, 51, 51));
        jLabelPhanMem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPhanMem.setText("PTITHCM's Student Training Point");
        jPanelMain.add(jLabelPhanMem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 390, 34));

        jTextFieldTenDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldTenDN.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldTenDN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jTextFieldTenDN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldTenDN.setMargin(new java.awt.Insets(2, 20, 2, 20));
        jPanelMain.add(jTextFieldTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 370, 40));

        jLabelQuenMatKhau.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelQuenMatKhau.setForeground(new java.awt.Color(221, 25, 25));
        jLabelQuenMatKhau.setText("Quên mật khẩu?");
        jLabelQuenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelQuenMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelQuenMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelQuenMatKhauMouseExited(evt);
            }
        });
        jPanelMain.add(jLabelQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 346, 100, 30));

        jLabelTenDN.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelTenDN.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTenDN.setText("Tên đăng nhập");
        jPanelMain.add(jLabelTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 370, -1));

        jPasswordField.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPasswordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelMain.add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 370, 40));

        jLabelSubmit.setBackground(new java.awt.Color(221, 25, 25));
        jLabelSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSubmit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubmit.setText("Đăng nhập");
        jLabelSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSubmit.setOpaque(true);
        jLabelSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSubmitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSubmitMouseExited(evt);
            }
        });
        jLabelSubmit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabelSubmitKeyTyped(evt);
            }
        });
        jPanelMain.add(jLabelSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 370, 40));

        jLabelMatKhau.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        jLabelMatKhau.setText("Mật khẩu");
        jPanelMain.add(jLabelMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 370, -1));

        jButton1.setText("jButton1");
        jPanelMain.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 0, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void click(){
        // TODO add your handling code here:
        String username = jTextFieldTenDN.getText().trim();
        char[] passwordChars = jPasswordField.getPassword();
        String password = new String(passwordChars);
        if(username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập tên đăng nhập và mật khẩu!");
            return;
        }
        //System.out.println(username + " " + password);
        flag = false;
        Thread searchThread = new Thread(() -> {
            for(TaiKhoan t: dsTaiKhoan) {
                if((t.getTenTK().toLowerCase()).equals(username.toLowerCase()) 
                        && t.getMatKhau().equals(password) && t.isTrangThai()) {
                    role = t.getLoaiTK();
                    tk = t;
                    flag = true;
                    break;
                }
            }
        });
        searchThread.start(); // Bắt đầu luồng tìm kiếm
        try {
            searchThread.join(); // Chờ luồng tìm kiếm kết thúc
        } catch (InterruptedException e) {
        }

        if(!flag) {
            JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập hoặc mật khẩu không đúng!");
            return;
        }
        
        switch (role.toLowerCase()) {
            case "admin" -> {
                new FormQuanLy(this, dsTaiKhoan, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop,
                    dsTieuChi, dsChucVu, dsSinhVien, dsThongBao, dsDRL).setVisible(true);
                
                jTextFieldTenDN.setText("");
                jPasswordField.setText("");
                this.setVisible(false);
            }
            case "khoa" -> {
                for(Khoa k: dsKhoa){
                    if(k.getMaKhoa().toLowerCase().equals(username.toLowerCase())){
                        khoa = k;
                        break;
                    }
                }   
                new FormHoiDongKhoa(this, khoa, dsTaiKhoan, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, 
                    dsChucVu, dsSinhVien, dsThongBao, dsDRL).setVisible(true);
                jTextFieldTenDN.setText("");
                jPasswordField.setText("");
                this.setVisible(false);
            }
            case "covan" -> {
                for(CoVan c: dsCoVan){
                    if(c.getMaCV().toLowerCase().equals(username.toLowerCase())){
                        cv = c;
                        break;
                    }
                }   for(Khoa k: dsKhoa){
                    if(k.getMaKhoa().toLowerCase().equals(cv.getKhoa().toLowerCase())){
                        khoa = k;
                        break;
                    }
                }   
                new FormCoVanHT(this, khoa, cv, tk, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, 
                    dsChucVu, dsTaiKhoan, dsSinhVien, dsThongBao, dsDRL, dsTieuChi).setVisible(true);
                jTextFieldTenDN.setText("");
                jPasswordField.setText("");    
                this.setVisible(false);
            }
            default -> {
                Thread searchSV = new Thread(() -> {
                    for(SinhVien s: dsSinhVien){
                        if(s.getMaSV().toLowerCase().equals(username.toLowerCase())){
                            sv = s;
                            break;
                        }
                    }
                }); searchSV.start();
                try {
                    searchSV.join(); // Chờ luồng tìm kiếm kết thúc
                } catch (InterruptedException e) {
                }   for(Lop l: dsLop){
                    if(l.getLop().toLowerCase().equals(sv.getLop().toLowerCase())){
                        lop = l;
                        break;
                    }
                }   for(Khoa k: dsKhoa){
                    if(k.getMaKhoa().toLowerCase().equals(lop.getMaKhoa().toLowerCase())){
                        khoa = k;
                        break;
                    }
                }   
                if(sv.getChucVu().equals(ThuatToan.getMaChucVuFromTen("sinh viên", dsChucVu))){
                    new FormSinhVien(this, khoa, sv, lop, tk, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, dsChucVu,
                            dsTaiKhoan, dsSinhVien, dsThongBao, dsDRL, dsTieuChi).setVisible(true);
                    jTextFieldTenDN.setText("");
                    jPasswordField.setText("");
                    this.setVisible(false);
                }
                else{
                    new FormBanCanSu(this, khoa, sv, lop, tk, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc, dsLop, dsChucVu,
                            dsTaiKhoan, dsSinhVien, dsThongBao, dsDRL, dsTieuChi).setVisible(true);
                    jTextFieldTenDN.setText("");
                    jPasswordField.setText("");
                    this.setVisible(false);
                }   
            }
        }
    }
    
    private void jLabelSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSubmitMouseClicked
        click();
    }//GEN-LAST:event_jLabelSubmitMouseClicked

    Color color = new Color(221,25,25);
    Color colorHover = new Color(30,115,190);
    
    private void jLabelQuenMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuenMatKhauMouseEntered
        // TODO add your handling code here:
        jLabelQuenMatKhau.setForeground(colorHover);
    }//GEN-LAST:event_jLabelQuenMatKhauMouseEntered

    private void jLabelQuenMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuenMatKhauMouseExited
        // TODO add your handling code here:
        jLabelQuenMatKhau.setForeground(color);
    }//GEN-LAST:event_jLabelQuenMatKhauMouseExited

    private void jLabelSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSubmitMouseEntered
        // TODO add your handling code here:
        jLabelSubmit.setBackground(colorHover);
    }//GEN-LAST:event_jLabelSubmitMouseEntered

    private void jLabelSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSubmitMouseExited
        // TODO add your handling code here:
        jLabelSubmit.setBackground(color);
    }//GEN-LAST:event_jLabelSubmitMouseExited

    private void jLabelQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelQuenMatKhauMouseClicked
        // TODO add your handling code here:
        new FormNhapMail(dsTaiKhoan, dsSinhVien, dsCoVan).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabelQuenMatKhauMouseClicked

    private void jLabelSubmitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelSubmitKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelSubmitKeyTyped

    public static void bindKeyStroke(final JButton btn, String ks) {
        final ActionListener[] alist = btn.getActionListeners();
        if (alist.length != 0) {
            AbstractAction action = new AbstractAction(btn.getText(), btn.getIcon()) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (ActionListener al : alist) {
                        ActionEvent ae = new ActionEvent(e.getSource(), e.getID(), Action.ACCELERATOR_KEY);
                        al.actionPerformed(ae);
                    }
                }
            };

            KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0); // Chỉ định phím Enter
            btn.setAction(action);
            btn.getActionMap().put(Action.ACCELERATOR_KEY, action);
            btn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, Action.ACCELERATOR_KEY);
        }
    }
    
    
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormDangNhap().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMatKhau;
    private javax.swing.JLabel jLabelPhanMem;
    private javax.swing.JLabel jLabelQuenMatKhau;
    private javax.swing.JLabel jLabelSubmit;
    private javax.swing.JLabel jLabelTenDN;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldTenDN;
    // End of variables declaration//GEN-END:variables
        
}



