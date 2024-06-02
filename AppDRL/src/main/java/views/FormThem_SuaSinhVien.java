/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controller.Database;
import controller.ThuatToan;
import com.raven.swing.RoundedTextField;
import com.raven.swing.RoundedPasswordField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import models.ChucVu;
import models.Khoa;
import models.Lop;
import models.SinhVien;
import models.TaiKhoan;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Dat
 */
public final class FormThem_SuaSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form SuaKhoa
     */
    private final Color buttonHoverColor = new Color(30,115,190);
    private final Color buttonColor = new Color(221,51,51);
    private int chon;
    private Khoa khoaMau;
    private ArrayList <Khoa> dsKhoa;
    private ArrayList <TaiKhoan> dsTaiKhoan;
    private ArrayList <Lop> dsLop;
    private ArrayList <SinhVien> dsSV;
    private ArrayList <ChucVu> dsCV;
    private Choice choice_khoa;
    private Choice choice_lop;
    private JTable table;
    private String chucNang;

    
    public void edit() throws ParseException{
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        this.setIconImage(logo);  
        setLocationRelativeTo(null);
        Database.saveKhoaToList(dsKhoa);
        Database.saveLopToList(dsLop);
        Database.saveChucVuToList(dsCV);
        switch (chucNang) {
            case "Them", "ThemND" -> {
                setND_Them();
            }
            default -> {
                setND_Sua();
            }
        }
        
        
        
        
        
    }
    public FormThem_SuaSinhVien() {
        //this.khoa = dsKhoa.get(chon);
        initComponents();
    }
    
    
    
    //Thêm của nhà trường
    public FormThem_SuaSinhVien(ArrayList<TaiKhoan> dsTaiKhoan, ArrayList<Khoa> khoa, JTable table,  Choice ch, Choice ch2,ArrayList<Lop> dsLop, ArrayList <SinhVien> dsSV, ArrayList <ChucVu> dsCV, String chucNang) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.choice_khoa = ch;
        this.choice_lop = ch2;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsLop = dsLop;
        this.dsSV = dsSV;
        this.dsCV = dsCV;
        this.chucNang = chucNang;
        edit();
    }
    
    
    public FormThem_SuaSinhVien(ArrayList<TaiKhoan> dsTaiKhoan, Khoa khoaMau, ArrayList<Khoa> khoa, JTable table,  Choice ch, Choice ch2,ArrayList<Lop> dsLop, ArrayList <SinhVien> dsSV, ArrayList <ChucVu> dsCV, String chucNang) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.khoaMau = khoaMau;
        this.choice_khoa = ch;
        this.choice_lop = ch2;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsLop = dsLop;
        this.dsSV = dsSV;
        this.dsCV = dsCV;
        this.chucNang = chucNang;
        edit();
    }
    
    //Sửa của nhà trường
    public FormThem_SuaSinhVien(ArrayList<TaiKhoan> dsTaiKhoan, ArrayList<Khoa> khoa, JTable table, int chon, ArrayList<SinhVien> dsSinhVien, Choice ch, Choice ch2, ArrayList<Lop>dsLop, ArrayList<ChucVu>dsChucVu, String chucNang) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.chon = chon;
        this.choice_khoa = ch;
        this.choice_lop = ch2;
        this.dsLop = dsLop;
        this.dsCV = dsChucVu;
        this.dsSV = dsSinhVien;
        this.dsTaiKhoan = dsTaiKhoan;
        this.chucNang = chucNang;
        edit();
    }
    
    public FormThem_SuaSinhVien(ArrayList<TaiKhoan> dsTaiKhoan, Khoa khoaMau, ArrayList<Khoa> khoa, JTable table, int chon, ArrayList<SinhVien> dsSinhVien, Choice ch, Choice ch2, ArrayList<Lop>dsLop, ArrayList<ChucVu>dsChucVu, String chucNang) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.chon = chon;
        this.khoaMau = khoaMau;
        this.choice_khoa = ch;
        this.choice_lop = ch2;
        this.dsLop = dsLop;
        this.dsCV = dsChucVu;
        this.dsSV = dsSinhVien;
        this.dsTaiKhoan = dsTaiKhoan;
        this.chucNang = chucNang;
        edit();
    }
    
    public void setND_Sua() throws ParseException{
        jLabelNutTieuDeTieuChi.setText("Cập nhật thông tin sinh viên");
        Object cellValue = table.getValueAt(chon, 1);
        //System.out.println(cellValue);
        int hub = 0;
        for(int i=0; i<dsSV.size(); i++){
            if(dsSV.get(i).getMaSV().equals(cellValue.toString())){
                hub = i;
                //xoa = i;
            }
        }   //jLabelNutTieuDeTieuChi.setText("Cập nhật");
        SinhVien sv = dsSV.get(hub);
        jTextFieldMaCoVan.setText(sv.getMaSV());
        //jTextFieldMaCoVan.setText(cv.getMaCV());
        jTextFieldTenCoVan.setText(sv.getHoTen());
        jTextFieldSdt.setText(sv.getSdt());
        jTextFieldQueQuan.setText(sv.getQueQuan());
        jTextFieldDiaChi.setText(sv.getDiaChi());
        jTextFieldEmail.setText(sv.getEmail().toLowerCase());
        //cho
        ThuatToan.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
        ThuatToan.addChoiceChucVu(choiceChucVu, dsCV);
        choiceChucVu.remove("Tất cả");
        choiceChucVu.select(ThuatToan.doiMaChucVuThanhTen(sv.getChucVu(), dsCV));
        choiceKhoa_CoVan.remove("Tất cả");
        choiceKhoa_CoVan.select(ThuatToan.getKhoaFromSinhVien(dsLop, sv.getLop()));
        choiceGioiTinh_Sua.add("Nam");
        choiceGioiTinh_Sua.add("Nữ");
        //System.out.println(sv.isGioiTinh());
        String gt = "Nam";
        if(sv.isGioiTinh() == false){
            gt = "Nữ";
        }
        System.out.println(gt);
        choiceGioiTinh_Sua.select(gt);
        ThuatToan.addChoiceLop(choiceLop, dsLop,ThuatToan.doiMaKhoaThanhTenKhoa(ThuatToan.getKhoaFromSinhVien(dsLop, sv.getLop()), dsKhoa) , dsKhoa);
        choiceLop.select(sv.getLop());
        String dateString = sv.getNgaySinh();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateString);
        jDateChooserNgaySinh.setDate(date);
        jPasswordFieldPass.setText(ThuatToan.getMatKhau(dsTaiKhoan, cellValue.toString()));
        jDateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
        if(chucNang.equals("SuaND")){
            choiceKhoa_CoVan.removeAll();
            choiceKhoa_CoVan.add(khoaMau.getTenKhoa());
            ThuatToan.addChoiceLop_1Khoa(dsLop, khoaMau.getMaKhoa(), choiceLop);
        }
    
    }
    
    public void setND_Them(){
        choiceGioiTinh_Sua.add("Nam");
        choiceGioiTinh_Sua.add("Nữ");
        buttonHoverEvent(jLabelNutLuu, jPanelNutLuu);
        jDateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
        ThuatToan.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
        choiceKhoa_CoVan.remove("Tất cả");
        ThuatToan.addChoiceChucVu(choiceChucVu, dsCV);
        choiceChucVu.remove("Tất cả");
        jLabelNutTieuDeTieuChi.setText("Thêm sinh viên");
        if(chucNang.equals("ThemND")){
            choiceKhoa_CoVan.removeAll();
            choiceKhoa_CoVan.add(khoaMau.getTenKhoa());
            ThuatToan.addChoiceLop_1Khoa(dsLop, khoaMau.getMaKhoa(), choiceLop);
        }
    }
    
    public  void buttonHoverEvent(JLabel label, JPanel panel){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(buttonHoverColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(buttonHoverColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(buttonColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(buttonColor);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanelMain = new javax.swing.JPanel();
        jTextFieldSdt = new RoundedTextField(15, 10, 10);
        jPasswordFieldPass = new RoundedPasswordField(15, 10, 10);
        jLabel3 = new javax.swing.JLabel();
        choiceGioiTinh_Sua = new java.awt.Choice();
        jTextFieldTenCoVan = new RoundedTextField(15, 10, 10);
        jTextFieldDiaChi = new RoundedTextField(15, 10, 10);
        jTextFieldQueQuan = new RoundedTextField(15, 10, 10);
        choiceKhoa_CoVan = new java.awt.Choice();
        jTextFieldMaCoVan = new RoundedTextField(15, 10, 10);
        jTextFieldEmail = new RoundedTextField(15, 10, 10);
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        choiceLop = new java.awt.Choice();
        choiceChucVu = new java.awt.Choice();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanelThanhTieuDeTieuChi = new javax.swing.JPanel();
        jPanelNutTieuDeTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTieuChi = new javax.swing.JLabel();
        jPanelNutLuu = RoundedPanel.createRoundedPanel();
        jLabelNutLuu = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm tài khoản sinh viên");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FormDangNhap.setBorderTextField(jTextFieldSdt);
        jTextFieldSdt.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jPanelMain.add(jTextFieldSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 100, 180, 41));

        FormDangNhap.setBorderPassword(jPasswordFieldPass);
        jPasswordFieldPass.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jPanelMain.add(jPasswordFieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 500, 44));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Họ và tên:");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel3.setOpaque(true);
        jPanelMain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 320, 16));

        choiceGioiTinh_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceGioiTinh_Sua.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceGioiTinh_Sua.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceGioiTinh_Sua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceGioiTinh_SuaItemStateChanged(evt);
            }
        });
        jPanelMain.add(choiceGioiTinh_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 238, 90, 40));

        FormDangNhap.setBorderTextField(jTextFieldTenCoVan);
        jTextFieldTenCoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jPanelMain.add(jTextFieldTenCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 30, 321, 41));

        FormDangNhap.setBorderTextField(jTextFieldDiaChi);
        jTextFieldDiaChi.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jPanelMain.add(jTextFieldDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 502, 41));

        FormDangNhap.setBorderTextField(jTextFieldQueQuan);
        jTextFieldQueQuan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jPanelMain.add(jTextFieldQueQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 502, 41));

        choiceKhoa_CoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_CoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_CoVanItemStateChanged(evt);
            }
        });
        jPanelMain.add(choiceKhoa_CoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 166, 290, 42));

        FormDangNhap.setBorderTextField(jTextFieldMaCoVan);
        jTextFieldMaCoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jPanelMain.add(jTextFieldMaCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 169, 41));

        FormDangNhap.setBorderTextField(jTextFieldEmail);
        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jPanelMain.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 98, 310, 44));

        jDateChooserNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserNgaySinh.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jDateChooserNgaySinh.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserNgaySinhPropertyChange(evt);
            }
        });
        jDateChooserNgaySinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserNgaySinhKeyReleased(evt);
            }
        });
        jPanelMain.add(jDateChooserNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 248, 175, 20));

        choiceLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceLop.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceLop.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceLopItemStateChanged(evt);
            }
        });
        jPanelMain.add(choiceLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 166, 198, 42));

        choiceChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceChucVu.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceChucVu.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceChucVu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceChucVuItemStateChanged(evt);
            }
        });
        jPanelMain.add(choiceChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 238, 214, 40));

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(" Mật khẩu:");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel15.setOpaque(true);
        jPanelMain.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 500, 16));

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(" Mã số sinh viên:");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel16.setOpaque(true);
        jPanelMain.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, 170, 16));

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(" Email:");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel17.setOpaque(true);
        jPanelMain.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 80, 310, 16));

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" Số điện thoại:");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel18.setOpaque(true);
        jPanelMain.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 180, 16));

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText(" Khoa:");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel19.setOpaque(true);
        jPanelMain.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 290, 16));

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(" Lớp:");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel20.setOpaque(true);
        jPanelMain.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 200, 16));

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(" Giới tính:");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel21.setOpaque(true);
        jPanelMain.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 16));

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText(" Ngày sinh:");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel22.setOpaque(true);
        jPanelMain.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 170, 16));

        jLabel23.setBackground(new java.awt.Color(102, 102, 102));
        jLabel23.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText(" Chức vụ:");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel23.setOpaque(true);
        jPanelMain.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 220, 16));

        jLabel24.setBackground(new java.awt.Color(102, 102, 102));
        jLabel24.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" Quê quán:");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel24.setOpaque(true);
        jPanelMain.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 500, 16));

        jLabel25.setBackground(new java.awt.Color(102, 102, 102));
        jLabel25.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText(" Địa chỉ:");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel25.setOpaque(true);
        jPanelMain.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 500, 16));

        jPanel1.add(jPanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, 520, 500));

        jPanelThanhTieuDeTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTieuChi.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitestudent.png"))); // NOI18N
        jLabelNutTieuDeTieuChi.setText("Thêm");
        jLabelNutTieuDeTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi);
        jPanelNutTieuDeTieuChi.setLayout(jPanelNutTieuDeTieuChiLayout);
        jPanelNutTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeTieuChiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNutTieuDeTieuChiLayout.setVerticalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jPanelNutLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTieuChiLayout.setVerticalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelThanhTieuDeTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 15, 520, 39));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choiceKhoa_CoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_CoVanItemStateChanged
        // TODO add your handling code here:
        ThuatToan.addChoiceLop(choiceLop, dsLop, choiceKhoa_CoVan.getSelectedItem(), dsKhoa);
    }//GEN-LAST:event_choiceKhoa_CoVanItemStateChanged

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

    private void jDateChooserNgaySinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserNgaySinhPropertyChange

    }//GEN-LAST:event_jDateChooserNgaySinhPropertyChange

    private void jDateChooserNgaySinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserNgaySinhKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserNgaySinhKeyReleased

    private void choiceLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceLopItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceLopItemStateChanged

    private void choiceChucVuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceChucVuItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceChucVuItemStateChanged

    public void saveThem(String password){
        new Thread(() -> {
            //System.out.println("views.ThemSinhVien.jLabelSubmitMouseClicked()");
            // Tạo mới đối tượng CoVan từ thông tin nhập liệu
            Database.saveSinhVienToList(dsSV);
            SinhVien newCoVan = new SinhVien();
            newCoVan.setMaSV(jTextFieldMaCoVan.getText().toUpperCase());
            newCoVan.setHoTen(ThuatToan.chuanHoaDiaDanh(jTextFieldTenCoVan.getText()));
            newCoVan.setLop(choiceLop.getSelectedItem());
            boolean gt;
            gt = choiceGioiTinh_Sua.getSelectedItem().equals("Nam");
            newCoVan.setGioiTinh(gt);
            //Date date = jDateChooserNgaySinh.getDate();
            //String day = Controller.getDate((java.util.Date)jDateChooserNgaySinh.getDate());
            newCoVan.setChucVu(ThuatToan.doiTenChucVuThanhMa(choiceChucVu.getSelectedItem(), dsCV));
            String day = ThuatToan.getDate((java.util.Date)jDateChooserNgaySinh.getDate());
            newCoVan.setNgaySinh(day);
            newCoVan.setSdt(jTextFieldSdt.getText());
            newCoVan.setQueQuan(ThuatToan.chuanHoaDiaDanh(jTextFieldQueQuan.getText()));
            newCoVan.setDiaChi(ThuatToan.chuanHoaDiaDanh(jTextFieldDiaChi.getText()));
            newCoVan.setEmail(jTextFieldEmail.getText().toLowerCase());

            // Thêm cố vấn mới vào danh sách dsCoVan
            dsSV.add(newCoVan);
            Database.saveTaiKhoanToList(dsTaiKhoan);
            TaiKhoan tk = new TaiKhoan();
            tk.setTenTK(jTextFieldMaCoVan.getText().toUpperCase());
            tk.setLoaiTK("sinhvien");
            tk.setMatKhau(password);
            tk.setTrangThai(true);
            dsTaiKhoan.add(tk);
            Database.saveListTaiKhoanToDB(dsTaiKhoan);

            if(choice_khoa.getSelectedItem().equals(choiceKhoa_CoVan.getSelectedItem()) &&
                    (choice_lop.getSelectedItem().equals("Tất cả") || choice_lop.getSelectedItem().equals(choiceLop.getSelectedItem()))){
                //System.out.println(".run()");
                Database.addOneSinhVienToTable(table, newCoVan, dsCV, dsTaiKhoan);
            }
            Database.saveListSinhVienToDB(dsSV);
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
        }).start();

        this.dispose(); // Đóng cửa sổ sau khi thêm thành công
    }
    
    public void saveSua(String password){
        new Thread(() -> {
            Object cellValue = table.getValueAt(chon, 1);
            int hub = 0;
            for(int i=0; i<dsSV.size(); i++){
                if(dsSV.get(i).getMaSV().equals(cellValue.toString())){
                    hub = i;
                    //xoa = i;
                }
            }
            String maSV = jTextFieldMaCoVan.getText().toUpperCase().trim();
            for(TaiKhoan tk: dsTaiKhoan){
                if(tk.getTenTK().equals(cellValue.toString())){
                    tk.setTenTK(maSV.toUpperCase());
                    tk.setMatKhau(password);

                }
            }
            dsSV.get(hub).setMaSV(jTextFieldMaCoVan.getText().toUpperCase());
            dsSV.get(hub).setHoTen(ThuatToan.chuanHoaDiaDanh(jTextFieldTenCoVan.getText()));
            dsSV.get(hub).setLop(choiceLop.getSelectedItem());
            boolean gt;
            gt = choiceGioiTinh_Sua.getSelectedItem().equals("Nam");
            dsSV.get(hub).setGioiTinh(gt);
            String day = ThuatToan.getDate((java.util.Date)jDateChooserNgaySinh.getDate());
            dsSV.get(hub).setChucVu(ThuatToan.doiTenChucVuThanhMa(choiceChucVu.getSelectedItem(), dsCV));
            dsSV.get(hub).setNgaySinh(day);
            dsSV.get(hub).setSdt(jTextFieldSdt.getText());
            dsSV.get(hub).setEmail(jTextFieldEmail.getText().toLowerCase());
            dsSV.get(hub).setQueQuan((ThuatToan.chuanHoaDiaDanh(jTextFieldQueQuan.getText())));
            dsSV.get(hub).setDiaChi((ThuatToan.chuanHoaDiaDanh(jTextFieldDiaChi.getText())));
            choice_khoa.select("Tất cả");
            choice_lop.select("Tất cả");
            table.setValueAt(jTextFieldMaCoVan.getText().toUpperCase(), chon, 1);
            table.setValueAt(ThuatToan.chuanHoaDiaDanh(jTextFieldTenCoVan.getText()), chon, 2);
            table.setValueAt(choiceLop.getSelectedItem(), chon, 3);
            table.setValueAt(choiceChucVu.getSelectedItem(), chon, 4);
            Database.saveListSinhVienToDB(dsSV);
            Database.saveListTaiKhoanToDB(dsTaiKhoan);
        }).start();


        this.dispose();
    }
    
    private void jLabelNutLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseClicked
        // TODO add your handling code here:
         // Lấy mật khẩu từ JPasswordField
        char[] passwordChars = jPasswordFieldPass.getPassword();
        String password = new String(passwordChars);
        // Kiểm tra xem các trường thông tin đã được nhập đầy đủ chưa
        if (jTextFieldMaCoVan.getText().equals("") || 
            jTextFieldTenCoVan.getText().equals("") || 
            jTextFieldSdt.getText().equals("") || 
            jTextFieldQueQuan.getText().equals("") || 
            jTextFieldEmail.getText().equals("") ||
            jTextFieldDiaChi.getText().equals("") || 
            password.equals("") || 
            jDateChooserNgaySinh.getDate() == null || 
            choiceLop.getItemCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");  
            return;
        }
        if(jTextFieldMaCoVan.getText().trim().length() != 10){
            JOptionPane.showMessageDialog(rootPane, "Mã sinh viên phải có 10 ký tự!");
            return;
        }
        if(ThuatToan.containsDigit(jTextFieldTenCoVan.getText())){
            JOptionPane.showMessageDialog(rootPane, "Tên không được có chữ số!");
            return;
        }
        if(!ThuatToan.isEmail(jTextFieldEmail.getText().trim())){
            JOptionPane.showMessageDialog(rootPane, "Email không đúng định dạng");
            return;
        }
        if(!ThuatToan.isPhoneNumber(jTextFieldSdt.getText().trim())){
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại phải đầu 0 và có đủ 10 chữ số!");
            return;
        }
        // Hiển thị hộp thoại xác nhận trước khi thêm
        if(chucNang.equals("Them") || chucNang.equals("ThemND")){
            Database.saveSinhVienToList(dsSV);
            String maKhoa = jTextFieldMaCoVan.getText().toUpperCase();
            if(!ThuatToan.isRepeatMaSV(dsSV, maKhoa)){
                int them = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thêm sinh viên không?");
                switch (them) {
                    case JOptionPane.YES_OPTION -> saveThem(password);
                    case JOptionPane.NO_OPTION -> this.dispose();
                    default -> {
                    }
                } 
            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã sinh viên đã tồn tại trên hệ thống!");
            }

        }
        else{
            Object cellValue = table.getValueAt(chon, 1);
            int hub = 0;
            for(int i=0; i<dsSV.size(); i++){
                if(dsSV.get(i).getMaSV().equals(cellValue.toString())){
                    hub = i;
                    //xoa = i;
                }
            }

            String maSV = jTextFieldMaCoVan.getText().toUpperCase().trim();
            if(!maSV.equals(dsSV.get(hub).getMaSV())){
                if(ThuatToan.isRepeatMaSV(dsSV, maSV)){
                    JOptionPane.showMessageDialog(rootPane, "Mã sinh viên đã tồn tại trên hệ thống!");
                    return;
                }
            }
            int sua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa thông tin không?");
            if(sua == JOptionPane.YES_OPTION){
                saveSua(password);

            } else if(sua == JOptionPane.NO_OPTION){
                // Đóng cửa sổ nếu không muốn sửa nữa
                this.dispose();
            }
            
        }
    }//GEN-LAST:event_jLabelNutLuuMouseClicked

    private void jLabelNutLuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseEntered
        // TODO add your handling code here:
        jPanelNutLuu.setBackground(new Color(30,115,190));
    }//GEN-LAST:event_jLabelNutLuuMouseEntered

    private void jLabelNutLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseExited
        // TODO add your handling code here:
        jPanelNutLuu.setBackground(new Color(221,51,51));
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
            java.util.logging.Logger.getLogger(FormThem_SuaSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormThem_SuaSinhVien().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceChucVu;
    private java.awt.Choice choiceGioiTinh_Sua;
    private java.awt.Choice choiceKhoa_CoVan;
    private java.awt.Choice choiceLop;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNutLuu;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelNutLuu;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMaCoVan;
    private javax.swing.JTextField jTextFieldQueQuan;
    private javax.swing.JTextField jTextFieldSdt;
    private javax.swing.JTextField jTextFieldTenCoVan;
    // End of variables declaration//GEN-END:variables
}
