/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import com.raven.swing.RoundedTextField;
import com.raven.swing.RoundedPasswordField;
import controller.Database;
import controller.ThuatToan;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import models.CoVan;
import models.Khoa;
import models.Lop;
import models.TaiKhoan;

/**
 *
 * @author Dat
 */
public final class FormThem_SuaCoVan extends javax.swing.JFrame {

    /**
     * Creates new form SuaKhoa
     */
    private Khoa khoaMau;
    private ArrayList <Khoa> dsKhoa;
    private ArrayList <CoVan> dsCoVan;
    private ArrayList <Lop> dsLop;
    private ArrayList <TaiKhoan> dsTaiKhoan;
    private String chucNang;
    private Choice ch;
    private JTable table;
    private int chon;
    private Khoa khoa;
    private final Color buttonHoverColor = new Color(30,115,190);
    private final Color buttonColor = new Color(221,51,51);
    
    public void edit() throws ParseException{
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        this.setIconImage(logo);  
        Database.saveKhoaToList(dsKhoa);
        if(chucNang.equals("Sua") || chucNang.equals("SuaND")){
            sua();
        }else{
            them();
        }
        
    }
    
    
    public FormThem_SuaCoVan() {
        //this.khoa = dsKhoa.get(chon);
        initComponents();
    }
    
    public FormThem_SuaCoVan(ArrayList<TaiKhoan> dsTaiKhoan,  ArrayList<Khoa> khoa, JTable table,  ArrayList<CoVan> coVan, Choice ch, String chucNang) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.ch = ch;
        this.dsCoVan = coVan;
        this.chucNang = chucNang;
        this.dsTaiKhoan = dsTaiKhoan;
        edit();
    }
    
    public FormThem_SuaCoVan(ArrayList<TaiKhoan> dsTaiKhoan, Khoa khoaMau,  ArrayList<Khoa> khoa, JTable table,  ArrayList<CoVan> coVan, Choice ch, String chucNang) throws ParseException{
        initComponents();
        this.table = table;
        this.khoaMau = khoaMau;
        this.dsKhoa = khoa;
        this.ch = ch;
        this.dsCoVan = coVan;
        this.chucNang = chucNang;
        this.dsTaiKhoan = dsTaiKhoan;
        edit();
    }
    
    //Sửa cố vấn
    public FormThem_SuaCoVan(ArrayList<TaiKhoan> dsTaiKhoan, ArrayList<Khoa> khoa, JTable table, int chon, ArrayList<CoVan> coVan, Choice ch, String chucNang, ArrayList<Lop> dsLop) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.chon = chon;
        this.ch = ch;
        this.chucNang = chucNang;
        this.dsCoVan = coVan;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsLop = dsLop;
        edit();
    }
    
    public FormThem_SuaCoVan(ArrayList<TaiKhoan> dsTaiKhoan, Khoa khoaMau, ArrayList<Khoa> khoa, JTable table, int chon, ArrayList<CoVan> coVan, Choice ch, String chucNang, ArrayList<Lop> dsLop) throws ParseException{
        initComponents();
        this.table = table;
        this.dsKhoa = khoa;
        this.khoaMau = khoaMau;
        this.chon = chon;
        this.ch = ch;
        this.chucNang = chucNang;
        this.dsCoVan = coVan;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsLop = dsLop;
        edit();
    }
    
    public void sua() throws ParseException{
        Object cellValue = table.getValueAt(chon, 1);
        //System.out.println(cellValue);
        int hub = 0;
        for(int i=0; i<dsCoVan.size(); i++){
            if(dsCoVan.get(i).getMaCV().equals(cellValue.toString())){
                hub = i;
                //xoa = i;
            }
        }
        jLabelNutTieuDeTieuChi.setText("Cập nhật thông tin cố vấn");
        CoVan cv = dsCoVan.get(hub);
        jTextFieldMaCoVan.setText(cv.getMaCV());
        //jTextFieldMaCoVan.setText(cv.getMaCV());
        jTextFieldTenCoVan.setText(cv.getTenCV());
        jTextFieldSdt.setText(cv.getSdt());
        jTextFieldQueQuan.setText(cv.getQueQuan());
        jTextFieldDiaChi.setText(cv.getDiaChi());
        //cho
        jTextFieldEmail.setText(cv.getEmail().toLowerCase());
        ThuatToan.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);


        choiceKhoa_CoVan.remove("Tất cả");
        choiceKhoa_CoVan.select(ThuatToan.doiMaKhoaThanhTenKhoa(cv.getKhoa(), dsKhoa));
        choiceGioiTinh_Sua.add("Nam");
        choiceGioiTinh_Sua.add("Nữ");
        choiceGioiTinh_Sua.select(ThuatToan.doiBoolToGioiTinh(cv.getGioiTinh()));
        String dateString = cv.getNgaySinh();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateString);
        jDateChooserNgaySinh.setDate(date);
        jPasswordFieldPass.setText(ThuatToan.getMatKhau(dsTaiKhoan, cellValue.toString()));
        jDateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
        if(chucNang.equals("SuaND")){
            choiceKhoa_CoVan.removeAll();
            choiceKhoa_CoVan.add(khoaMau.getTenKhoa());
        }
    }
    
    public void them(){
        jLabelNutTieuDeTieuChi.setText("Thêm cố vấn");
        choiceGioiTinh_Sua.add("Nam");
        choiceGioiTinh_Sua.add("Nữ");
        ThuatToan.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
        choiceKhoa_CoVan.remove("Tất cả");
        jDateChooserNgaySinh.setDateFormatString("yyyy-MM-dd");
        if(chucNang.equals("ThemND")){
            choiceKhoa_CoVan.removeAll();
            choiceKhoa_CoVan.add(khoaMau.getTenKhoa());
        }
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
        jPanel1 = new javax.swing.JPanel();
        jTextFieldMaCoVan = new RoundedTextField(15, 10, 10);
        jTextFieldEmail = new RoundedTextField(15, 10, 10);
        choiceKhoa_CoVan = new java.awt.Choice();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jTextFieldQueQuan = new RoundedTextField(15, 10, 10);
        jTextFieldDiaChi = new RoundedTextField(15, 10, 10);
        jPasswordFieldPass = new RoundedPasswordField(15, 10, 10);
        choiceGioiTinh_Sua = new java.awt.Choice();
        jTextFieldSdt = new RoundedTextField(15, 10, 10);
        jTextFieldTenCoVan = new RoundedTextField(15, 10, 10);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTieuChi.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTieuChi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTieuChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteteacher.png"))); // NOI18N
        jLabelNutTieuDeTieuChi.setText("Thêm");
        jLabelNutTieuDeTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi);
        jPanelNutTieuDeTieuChi.setLayout(jPanelNutTieuDeTieuChiLayout);
        jPanelNutTieuDeTieuChiLayout.setHorizontalGroup(
            jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(jPanelNutLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTieuChiLayout.setVerticalGroup(
            jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanelThanhTieuDeTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, 460, 39));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        FormDangNhap.setBorderTextField(jTextFieldMaCoVan);
        jTextFieldMaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderTextField(jTextFieldEmail);
        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        choiceKhoa_CoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_CoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_CoVanItemStateChanged(evt);
            }
        });

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

        FormDangNhap.setBorderTextField(jTextFieldQueQuan);
        jTextFieldQueQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        FormDangNhap.setBorderTextField(jTextFieldDiaChi);
        jTextFieldDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        FormDangNhap.setBorderPassword(jPasswordFieldPass);
        jPasswordFieldPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        choiceGioiTinh_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceGioiTinh_Sua.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceGioiTinh_Sua.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceGioiTinh_Sua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceGioiTinh_SuaItemStateChanged(evt);
            }
        });

        FormDangNhap.setBorderTextField(jTextFieldSdt);
        jTextFieldSdt.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N

        FormDangNhap.setBorderTextField(jTextFieldTenCoVan);
        jTextFieldTenCoVan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(" Mã cố vấn:");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(" Họ và tên:");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" Email:");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel18.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText(" Số điện thoại:");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel19.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(" Khoa:");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel20.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(102, 102, 102));
        jLabel21.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(" Giới tính:");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText(" Ngày sinh:");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(102, 102, 102));
        jLabel23.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText(" Mật khẩu:");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel23.setOpaque(true);

        jLabel24.setBackground(new java.awt.Color(102, 102, 102));
        jLabel24.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" Quê quán:");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel24.setOpaque(true);

        jLabel25.setBackground(new java.awt.Color(102, 102, 102));
        jLabel25.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText(" Địa chỉ:");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel25.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldQueQuan)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceGioiTinh_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldSdt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMaCoVan)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTenCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTenCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceGioiTinh_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24))
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choiceKhoa_CoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_CoVanItemStateChanged
        // TODO add your handling code here:
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

    private void jLabelNutLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLuuMouseClicked
        // Lấy mật khẩu từ JPasswordField
        char[] passwordChars = jPasswordFieldPass.getPassword();
        String password = new String(passwordChars);
        //System.out.println(password);
        // Kiểm tra xem các trường thông tin đã được nhập đầy đủ chưa
        if(jTextFieldMaCoVan.getText().equals("")||
            jTextFieldTenCoVan.getText().equals("") || 
            jTextFieldEmail.getText().equals("") ||
            jTextFieldSdt.getText().equals("") || 
            jTextFieldQueQuan.getText().equals("") || 
            jDateChooserNgaySinh.getDate() == null||
            jTextFieldDiaChi.getText().equals("") || 
            password.equals("")){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin!");
                return;
        }
        if(jTextFieldMaCoVan.getText().trim().length() != 6){
            JOptionPane.showMessageDialog(rootPane, "Mã cố vấn phải có 6 ký tự!");
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
        if(chucNang.equals("Sua")|| chucNang.equals("SuaND")){
            String maCVMoi = jTextFieldMaCoVan.getText().toUpperCase();
            Object cellValue = table.getValueAt(chon, 1);
            String maCVCu = cellValue.toString();
            if(!maCVMoi.equals(maCVCu)){
                if(ThuatToan.isRepeatMaCoVan(dsCoVan, maCVMoi)){
                    JOptionPane.showMessageDialog(rootPane, "Mã cố vấn đã tồn tại trên hệ thống!");
                    return;
                }
            }
            int sua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa thông tin không?");
            if(sua == JOptionPane.YES_OPTION){
                suaCoVan(password);
            } else if(sua == JOptionPane.NO_OPTION){
                this.dispose();
            }
        }
            else{
                String maKhoa = jTextFieldMaCoVan.getText().toUpperCase();
                if(ThuatToan.isRepeatMaCoVan(dsCoVan, maKhoa)){
                    JOptionPane.showMessageDialog(rootPane, "Mã cố vấn đã tồn tại trên hệ thống!");
                    return;
                }
                // Hiển thị hộp thoại xác nhận trước khi thêm
                int them = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thêm cố vấn không?");
                if(them == JOptionPane.YES_OPTION){
                    themCoVan(password);
                } else if(them == JOptionPane.NO_OPTION){
                    // Đóng cửa sổ nếu không muốn thêm nữa
                    this.dispose();
                }
            }
        
    }//GEN-LAST:event_jLabelNutLuuMouseClicked

    public void themCoVan(String password){
        new Thread(() -> {
            Database.saveCoVanToList(dsCoVan);
            Database.saveTaiKhoanToList(dsTaiKhoan);
            String maKhoa = jTextFieldMaCoVan.getText().toUpperCase();
            // Tạo mới đối tượng CoVan từ thông tin nhập liệu
            CoVan newCoVan = new CoVan();
            newCoVan.setMaCV(jTextFieldMaCoVan.getText().toUpperCase());
            newCoVan.setTenCV(ThuatToan.chuanHoaDiaDanh(jTextFieldTenCoVan.getText()));
            newCoVan.setKhoa(ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem().trim(), dsKhoa));
            newCoVan.setGioiTinh(ThuatToan.doiGioiTinhToBool(choiceGioiTinh_Sua.getSelectedItem()));
            //Date date = jDateChooserNgaySinh.getDate();
            String day = ThuatToan.getDate((java.util.Date)jDateChooserNgaySinh.getDate());

            newCoVan.setNgaySinh(day);
            newCoVan.setSdt(jTextFieldSdt.getText());
            newCoVan.setQueQuan(ThuatToan.chuanHoaDiaDanh(jTextFieldQueQuan.getText()));
            newCoVan.setDiaChi(ThuatToan.chuanHoaDiaDanh(jTextFieldDiaChi.getText()));
            newCoVan.setEmail(jTextFieldEmail.getText().toLowerCase());

            // Thêm cố vấn mới vào danh sách dsCoVan
            dsCoVan.add(newCoVan);
            Database.saveListCoVanToDB(dsCoVan);
            TaiKhoan tk = new TaiKhoan();
            tk.setTenTK(newCoVan.getMaCV());
            tk.setMatKhau(password);
            tk.setLoaiTK("covan");
            tk.setTrangThai(true);
            dsTaiKhoan.add(tk);
            Database.saveListTaiKhoanToDB(dsTaiKhoan);
            // Cập nhật lại bảng để hiển thị cố vấn mới
            if(ch.getSelectedItem().equals("Tất cả")){
                Database.addListCoVanToTable(dsCoVan, table, dsKhoa, dsTaiKhoan);
            } else {
                Database.addListCoVanToTable_MaKhoa(dsCoVan, table, dsKhoa, ThuatToan.doiTenKhoaThanhMaKhoa(ch.getSelectedItem(), dsKhoa), dsTaiKhoan);
            }
            
        }).start();
        this.dispose();
    }
    
    public void suaCoVan(String password){
        new Thread(() -> {
            Database.saveLopToList(dsLop);
            Database.saveCoVanToList(dsCoVan);
            Database.saveTaiKhoanToList(dsTaiKhoan);
            Object cellValue = table.getValueAt(chon, 1);
            int hub = 0;
            for(int i=0; i<dsCoVan.size(); i++){
                if(dsCoVan.get(i).getMaCV().equals(cellValue.toString())){
                    hub = i;
                    //xoa = i;
                }
            }
            String maCV = jTextFieldMaCoVan.getText().toUpperCase();
            Database.saveTaiKhoanToList(dsTaiKhoan);
            for(TaiKhoan tk: dsTaiKhoan){
                if(tk.getTenTK().equals(cellValue)){
                    tk.setTenTK(maCV);
                    tk.setMatKhau(password);
                }
            }
            dsCoVan.get(hub).setMaCV(jTextFieldMaCoVan.getText().toUpperCase());
            dsCoVan.get(hub).setTenCV(ThuatToan.chuanHoaDiaDanh(jTextFieldTenCoVan.getText()));
            dsCoVan.get(hub).setKhoa(ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa));
            dsCoVan.get(hub).setGioiTinh(ThuatToan.doiGioiTinhToBool(choiceGioiTinh_Sua.getSelectedItem()));
            String day = ThuatToan.getDate((java.util.Date)jDateChooserNgaySinh.getDate());
            dsCoVan.get(hub).setNgaySinh(day);
            dsCoVan.get(hub).setEmail(jTextFieldEmail.getText().toLowerCase());
            dsCoVan.get(hub).setSdt(jTextFieldSdt.getText());
            dsCoVan.get(hub).setQueQuan(ThuatToan.chuanHoaDiaDanh(jTextFieldQueQuan.getText()));
            dsCoVan.get(hub).setDiaChi(ThuatToan.chuanHoaDiaDanh(jTextFieldDiaChi.getText()));
            if(ch.getSelectedItem().equals("Tất cả")){
                Database.addListCoVanToTable(dsCoVan, table, dsKhoa, dsTaiKhoan);
            }
            else{
                Database.addListCoVanToTable_MaKhoa(dsCoVan, table, dsKhoa, ThuatToan.doiTenKhoaThanhMaKhoa(ch.getSelectedItem(), dsKhoa), dsTaiKhoan);
            }
            ThuatToan.suaCoVanTrongLop(dsLop, cellValue.toString(), maCV);
            Database.saveListCoVanToDB(dsCoVan);
            Database.saveListTaiKhoanToDB(dsTaiKhoan);
            Database.saveListLopToDB(dsLop);

       }).start();
       this.dispose();
    }
    
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
            java.util.logging.Logger.getLogger(FormThem_SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThem_SuaCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            new FormThem_SuaCoVan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceGioiTinh_Sua;
    private java.awt.Choice choiceKhoa_CoVan;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
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
    private javax.swing.JLabel jLabelNutLuu;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanel1;
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
