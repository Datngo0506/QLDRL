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
        if(chucNang.equals("Sua") || chucNang.equals("SuaND")){
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
        }else{
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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMaCoVan = new RoundedTextField(15, 10, 10);
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldEmail = new RoundedTextField(15, 10, 10);
        jLabel5 = new javax.swing.JLabel();
        choiceKhoa_CoVan = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldQueQuan = new RoundedTextField(15, 10, 10);
        jLabel13 = new javax.swing.JLabel();
        jTextFieldDiaChi = new RoundedTextField(15, 10, 10);
        jLabel6 = new javax.swing.JLabel();
        jPasswordFieldPass = new RoundedPasswordField(15, 10, 10);
        jLabel7 = new javax.swing.JLabel();
        choiceGioiTinh_Sua = new java.awt.Choice();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSdt = new RoundedTextField(15, 10, 10);
        jTextFieldTenCoVan = new RoundedTextField(15, 10, 10);

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
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel3.setText("Mã cố vấn");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderTextField(jTextFieldMaCoVan);
        jTextFieldMaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldMaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel11.setText("Họ và tên");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel14.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel14.setText("Email");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderTextField(jTextFieldEmail);
        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel5.setText("Khoa");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        choiceKhoa_CoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_CoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_CoVanItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel4.setText("Ngày sinh");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

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

        jLabel12.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel12.setText("Quê quán");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderTextField(jTextFieldQueQuan);
        jTextFieldQueQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel13.setText("Địa chỉ");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderTextField(jTextFieldDiaChi);
        jTextFieldDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel6.setText("Mật khẩu");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderPassword(jPasswordFieldPass);
        jPasswordFieldPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel7.setText("Giới tính");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        choiceGioiTinh_Sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceGioiTinh_Sua.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        choiceGioiTinh_Sua.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceGioiTinh_Sua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceGioiTinh_SuaItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel10.setText("Số điện thoại");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        FormDangNhap.setBorderTextField(jTextFieldSdt);
        jTextFieldSdt.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N

        FormDangNhap.setBorderTextField(jTextFieldTenCoVan);
        jTextFieldTenCoVan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQueQuan)
                            .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(choiceGioiTinh_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordFieldPass))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(118, 118, 118)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldMaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldTenCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTenCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choiceGioiTinh_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        }
        
        else if(jTextFieldMaCoVan.getText().trim().length() != 6){
            JOptionPane.showMessageDialog(rootPane, "Mã cố vấn phải có 6 ký tự!");
            
        }
        else if(ThuatToan.containsDigit(jTextFieldTenCoVan.getText())){
            JOptionPane.showMessageDialog(rootPane, "Tên không được có chữ số!");
        }
        else if(!ThuatToan.isEmail(jTextFieldEmail.getText().trim())){
            JOptionPane.showMessageDialog(rootPane, "Email không đúng định dạng");
        }
        else if(!ThuatToan.isPhoneNumber(jTextFieldSdt.getText().trim())){
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại phải đầu 0 và có đủ 10 chữ số!");
        }
        else {
            // Hiển thị hộp thoại xác nhận trước khi sửa
            //int xoa = 0;
            if(chucNang.equals("Sua")|| chucNang.equals("SuaND")){
                int sua = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn sửa thông tin không?");
                if(sua == JOptionPane.YES_OPTION){
                    
                    new Thread(() -> {
                         Database.saveKhoaToList(dsKhoa);
                        Database.saveCoVanToList(dsCoVan);
                        Object cellValue = table.getValueAt(chon, 1);
                        int hub = 0;
                        for(int i=0; i<dsCoVan.size(); i++){
                            if(dsCoVan.get(i).getMaCV().equals(cellValue.toString())){
                                hub = i;
                                //xoa = i;
                            }
                        }

                        String maCV = jTextFieldMaCoVan.getText().toUpperCase();
                        if(!maCV.equals(dsCoVan.get(hub).getMaCV())){
                            if(ThuatToan.isRepeatMaCoVan(dsCoVan, maCV)){
                                JOptionPane.showMessageDialog(rootPane, "Mã cố vấn đã tồn tại trên hệ thống!");
                                return;
                            }
                        }
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

                } else if(sua == JOptionPane.NO_OPTION){
                    // Đóng cửa sổ nếu không muốn sửa nữa
                    this.dispose();
                }
            }
            else{
                // Hiển thị hộp thoại xác nhận trước khi thêm
                int them = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn thêm cố vấn không?");
                if(them == JOptionPane.YES_OPTION){
                    new Thread(() -> {
                         Database.saveKhoaToList(dsKhoa);
                        Database.saveCoVanToList(dsCoVan);
                        String maKhoa = jTextFieldMaCoVan.getText().toUpperCase();
                        if(!ThuatToan.isRepeatMaCoVan(dsCoVan, maKhoa)){
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
                            Database.saveTaiKhoanToList(dsTaiKhoan);
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
                        }
                        else{

                            JOptionPane.showMessageDialog(rootPane, "Mã cố vấn đã tồn tại trên hệ thống!");

                        }
                    }).start();

                    this.dispose(); // Đóng cửa sổ sau khi thêm thành công
                } else if(them == JOptionPane.NO_OPTION){
                    // Đóng cửa sổ nếu không muốn thêm nữa
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
