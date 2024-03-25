/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
//import javax.swing.BorderFactory;
import icons.Icon;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dat
 * 
 * 
 */




public final class FormQuanLy extends javax.swing.JFrame {

/**
     * Creates new form FormSinhVien
     */
        private final static Color textColor = new Color(0, 0, 139);
        private final static Color white = Color.WHITE;
        private final static Color hoveColor = new Color(255,204,102);//màu đậm
        private final static Color hoveColor2 = new Color(255, 228, 181);//màu lợt
        private final Color buttonHoverColor = new Color(30,115,190);
        private final Color buttonColor = new Color(221,51,51);
    // Màu của viền

        // Sử dụng màu này trong ứng dụng của bạn
    
    public void viewMenuClick(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        main.setBackground(hoveColor);
        main.revalidate(); // Cập nhật giao diện
        main.repaint();    // Vẽ lại giao diện
        
        p2.setBackground(white);
        p2.revalidate(); // Cập nhật giao diện
        p2.repaint();    // Vẽ lại giao diện
        
        p3.setBackground(white);
        p3.revalidate(); // Cập nhật giao diện
        p3.repaint();    // Vẽ lại giao diện
        
        p4.setBackground(white);
        p4.revalidate(); // Cập nhật giao diện
        p4.repaint();    // Vẽ lại giao diện
        
        p5.setBackground(white);
        p5.revalidate(); // Cập nhật giao diện
        p5.repaint();    // Vẽ lại giao diện
        
        p6.setBackground(white);
        p6.revalidate(); // Cập nhật giao diện
        p6.repaint();    // Vẽ lại giao diện
        
        p7.setBackground(white);
        p7.revalidate(); // Cập nhật giao diện
        p7.repaint();    // Vẽ lại giao diện
        
    }    
    
    public void viewMenuHover(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        if(main.getBackground().equals(white)){
            main.setBackground(hoveColor2);
            main.revalidate(); // Cập nhật giao diện
            main.repaint();    // Vẽ lại giao diện
        }
        if(!p2.getBackground().equals(hoveColor)){
            p2.setBackground(white);
            p2.revalidate(); // Cập nhật giao diện
            p2.repaint();    // Vẽ lại giao diện
        }
        if(!p3.getBackground().equals(hoveColor)){
            p3.setBackground(white);
            p3.revalidate(); // Cập nhật giao diện
            p3.repaint();    // Vẽ lại giao diện
        }
        if(!p4.getBackground().equals(hoveColor)){
            p4.setBackground(white);
            p4.revalidate(); // Cập nhật giao diện
            p4.repaint();    // Vẽ lại giao diện
        }
        if(!p5.getBackground().equals(hoveColor)){
            p5.setBackground(white);
            p5.revalidate(); // Cập nhật giao diện
            p5.repaint();    // Vẽ lại giao diện
        }
        if(!p6.getBackground().equals(hoveColor)){
            p6.setBackground(white);
            p6.revalidate(); // Cập nhật giao diện
            p6.repaint();    // Vẽ lại giao diện
        }
        if(!p7.getBackground().equals(hoveColor)){
            p7.setBackground(white);
            p7.revalidate(); // Cập nhật giao diện
            p7.repaint();    // Vẽ lại giao diện
        }
        
    }
    
    public void viewExit(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        if(!main.getBackground().equals(hoveColor)){
            main.setBackground(white);
            main.revalidate(); // Cập nhật giao diện
            main.repaint();    // Vẽ lại giao diện
        }
        if(!p2.getBackground().equals(hoveColor)){
            p2.setBackground(white);
            p2.revalidate(); // Cập nhật giao diện
            p2.repaint();    // Vẽ lại giao diện
        }
        if(!p3.getBackground().equals(hoveColor)){
            p3.setBackground(white);
            p3.revalidate(); // Cập nhật giao diện
            p3.repaint();    // Vẽ lại giao diện
        }
        if(!p4.getBackground().equals(hoveColor)){
            p4.setBackground(white);
            p4.revalidate(); // Cập nhật giao diện
            p4.repaint();    // Vẽ lại giao diện
        }
        if(!p5.getBackground().equals(hoveColor)){
            p5.setBackground(white);
            p5.revalidate(); // Cập nhật giao diện
            p5.repaint();    // Vẽ lại giao diện
        }
        if(!p6.getBackground().equals(hoveColor)){
            p6.setBackground(white);
            p6.revalidate(); // Cập nhật giao diện
            p6.repaint();    // Vẽ lại giao diện
        }
        if(!p7.getBackground().equals(hoveColor)){
            p7.setBackground(white);
            p7.revalidate(); // Cập nhật giao diện
            p7.repaint();    // Vẽ lại giao diện
        }
    }
        
    public void suKienMenu(){
        setLocationRelativeTo(null);
        
        
        
       ClickEvent(jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       ClickEvent(jPanelCoVan, jLabelCoVan, jLabelLeft2, jPanelKhoa, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       ClickEvent(jPanelLop, jLabelLop, jLabelLeft3, jPanelCoVan, jPanelKhoa, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       ClickEvent(jPanelHocKy, jLabelHocKy, jLabelLeft4, jPanelCoVan, jPanelLop, jPanelKhoa, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       ClickEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft5, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelKhoa, jPanelChamDiem, jPanelXemDiem);
       ClickEvent(jPanelChamDiem, jLabelChamDiem, jLabelLeft6, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelKhoa, jPanelXemDiem);
       ClickEvent(jPanelXemDiem, jLabelXemDiem, jLabelLeft7, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelKhoa);
       
       EnterEvent(jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       EnterEvent(jPanelCoVan, jLabelCoVan, jLabelLeft2, jPanelKhoa, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       EnterEvent(jPanelLop, jLabelLop, jLabelLeft3, jPanelCoVan, jPanelKhoa, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       EnterEvent(jPanelHocKy, jLabelHocKy, jLabelLeft4, jPanelCoVan, jPanelLop, jPanelKhoa, jPanelTaiKhoan, jPanelChamDiem, jPanelXemDiem);
       EnterEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft5, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelKhoa, jPanelChamDiem, jPanelXemDiem);
       EnterEvent(jPanelChamDiem, jLabelChamDiem, jLabelLeft6, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelKhoa, jPanelXemDiem);
       EnterEvent(jPanelXemDiem, jLabelXemDiem, jLabelLeft7, jPanelCoVan, jPanelLop, jPanelHocKy, jPanelTaiKhoan, jPanelChamDiem, jPanelKhoa);
        
       jPanelTaiKhoan.setBackground(hoveColor);
        hienManHinhCanMo(jPanelTaiKhoanMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelHocKyMain, jPanelXemDiemMain);
       
        ClickMenuEvent(jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelKhoaMain, jPanelHocKyMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, jPanelXemDiemMain);
        ClickMenuEvent(jPanelCoVan, jLabelCoVan, jLabelLeft2, jPanelCoVanMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelHocKyMain, jPanelLopMain, jPanelTaiKhoanMain, jPanelXemDiemMain);
        ClickMenuEvent(jPanelLop, jLabelLop, jLabelLeft3, jPanelLopMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelHocKyMain, jPanelTaiKhoanMain, jPanelXemDiemMain);
        ClickMenuEvent(jPanelHocKy, jLabelHocKy, jLabelLeft4, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, jPanelXemDiemMain);
        ClickMenuEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft5, jPanelTaiKhoanMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelHocKyMain, jPanelXemDiemMain);
        ClickMenuEvent(jPanelChamDiem, jLabelChamDiem, jLabelLeft6, jPanelChamDiemMain, jPanelKhoaMain, jPanelHocKyMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, jPanelXemDiemMain);
        ClickMenuEvent(jPanelXemDiem, jLabelXemDiem, jLabelLeft7, jPanelXemDiemMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, jPanelHocKyMain);
    }
    
    public FormQuanLy() {
        initComponents();
        suKienMenu();
    }
    
    public void ClickEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        
        main1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5, p6, p7);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5, p6, p7);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5, p6, p7);
            }
        });
        
    }
    //jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, PanelXemDiemMain
    public void ClickMenuEvent(JPanel main, JLabel main2, JLabel main3, JPanel main1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7);
            }
        });
        
    }
    
    public void EnterEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5, p6, p7);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelKhoa2
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5, p6, p7);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelLeft
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5, p6, p7);
                }
            });
            
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5, p6, p7);
                }
            });
            
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5, p6, p7);
                }
            });
            
            main3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5, p6, p7);
                }
            });
    }
   
    public void hienManHinhCanMo(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        main.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
        p7.setVisible(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelView = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanelKhoa = new javax.swing.JPanel();
        jLabelKhoa = new javax.swing.JLabel();
        jLabelLeft1 = new javax.swing.JLabel();
        jPanelCoVan = new javax.swing.JPanel();
        jLabelCoVan = new javax.swing.JLabel();
        jLabelLeft2 = new javax.swing.JLabel();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jLabelLeft3 = new javax.swing.JLabel();
        jPanelHocKy = new javax.swing.JPanel();
        jLabelHocKy = new javax.swing.JLabel();
        jLabelLeft4 = new javax.swing.JLabel();
        jPanelTaiKhoan = new javax.swing.JPanel();
        jLabelTaiKhoan = new javax.swing.JLabel();
        jLabelLeft5 = new javax.swing.JLabel();
        jPanelChamDiem = new javax.swing.JPanel();
        jLabelChamDiem = new javax.swing.JLabel();
        jLabelLeft6 = new javax.swing.JLabel();
        jPanelXemDiem = new javax.swing.JPanel();
        jLabelXemDiem = new javax.swing.JLabel();
        jLabelLeft7 = new javax.swing.JLabel();
        jPanelNull1 = new javax.swing.JPanel();
        jLabel3Dots = new javax.swing.JLabel();
        jPanelNull2 = new javax.swing.JPanel();
        jPanelNull3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelHelp = new javax.swing.JPanel();
        jLabelHelp = new javax.swing.JLabel();
        jLabelLeft8 = new javax.swing.JLabel();
        jPanelLogOut = new javax.swing.JPanel();
        jLabelLogOut = new javax.swing.JLabel();
        jLabelLeft9 = new javax.swing.JLabel();
        jPanelPanel = new javax.swing.JPanel();
        jPanelContact = new javax.swing.JPanel();
        jLabelMail = new javax.swing.JLabel();
        jPanelPtit = new javax.swing.JPanel();
        jLabelpanelPtit = new javax.swing.JLabel();
        jPanelLienHe = new javax.swing.JPanel();
        jLabelLienHe = new javax.swing.JLabel();
        jLabelCloud = new javax.swing.JLabel();
        jLabelFb = new javax.swing.JLabel();
        jLayeredPaneMain = new javax.swing.JLayeredPane();
        jPanelHocKyMain = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelKhoaMain = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanelChamDiemMain = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelCoVanMain = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanelLopMain = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanelTaiKhoanMain = new javax.swing.JPanel();
        jPanelTitle1 = new javax.swing.JPanel();
        jPanelTitleColor = new javax.swing.JPanel();
        jLabelTitile = new javax.swing.JLabel();
        jPanelTitle2 = new javax.swing.JPanel();
        jPanelTitleColor1 = new javax.swing.JPanel();
        jLabelTitile1 = new javax.swing.JLabel();
        jLabelTieuDeTen = new javax.swing.JLabel();
        jLabelTieuDeMSV = new javax.swing.JLabel();
        jLabelTieuDeLop = new javax.swing.JLabel();
        jLabelTieuDeGioiTinh = new javax.swing.JLabel();
        jLabelTieuDeNgaySinh = new javax.swing.JLabel();
        jLabelTieuDeDRL = new javax.swing.JLabel();
        jLabelTieuDeSdt = new javax.swing.JLabel();
        jLabelTieuDeMailTruong = new javax.swing.JLabel();
        jLabelTieuDeMailCaNhan = new javax.swing.JLabel();
        jLabelTieuDeNganh = new javax.swing.JLabel();
        jLabelTieuDeQue = new javax.swing.JLabel();
        jLabelSuaThongTin = new javax.swing.JLabel();
        jLabelNoiDungTen = new javax.swing.JLabel();
        jLabelNoiDungLop = new javax.swing.JLabel();
        jLabelNoiDungGioiTinh = new javax.swing.JLabel();
        jLabelNoiDungDRL = new javax.swing.JLabel();
        jLabelNoiDungMailTruong = new javax.swing.JLabel();
        jLabelNoiDungMSV = new javax.swing.JLabel();
        jLabelNoiDungNganh = new javax.swing.JLabel();
        jLabelNoiDungNgaySinh = new javax.swing.JLabel();
        jLabelNoiDungSdt = new javax.swing.JLabel();
        jLabelNoiDungQue = new javax.swing.JLabel();
        jLabelTieuDeNoiO = new javax.swing.JLabel();
        jLabelNoiDungNoiO = new javax.swing.JLabel();
        jLabelTieuDeTenDN = new javax.swing.JLabel();
        jLabelTieuDeMK = new javax.swing.JLabel();
        jLabelDoiMatKhau = new javax.swing.JLabel();
        jLabelTenDangNhap = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelNoiDungMailCaNhan = new javax.swing.JLabel();
        jPanelXemDiemMain = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Điểm rèn luyện sinh viên");

        jPanelView.setBackground(new java.awt.Color(189, 56, 27));
        jPanelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setRequestFocusEnabled(false);
        jPanelMenu.setVerifyInputWhenFocusTarget(false);
        jPanelMenu.setLayout(new java.awt.GridLayout(12, 1));

        jPanelKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jPanelKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelKhoa.setPreferredSize(new java.awt.Dimension(160, 48));
        jPanelKhoa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelKhoaMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelKhoaMouseMoved(evt);
            }
        });
        jPanelKhoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanelKhoaFocusGained(evt);
            }
        });
        jPanelKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelKhoaMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelKhoaMouseReleased(evt);
            }
        });

        jLabelKhoa.setBackground(new java.awt.Color(255, 255, 102));
        jLabelKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelKhoa.setForeground(new java.awt.Color(227, 70, 34));
        jLabelKhoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("khoa.png")));
        jLabelKhoa.setText(" KHOA");
        jLabelKhoa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelKhoaMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelKhoaMouseMoved(evt);
            }
        });
        jLabelKhoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabelKhoaFocusGained(evt);
            }
        });
        jLabelKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelKhoaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelKhoaMouseExited(evt);
            }
        });

        jLabelLeft1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));
        jLabelLeft1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelLeft1MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanelKhoaLayout = new javax.swing.GroupLayout(jPanelKhoa);
        jPanelKhoa.setLayout(jPanelKhoaLayout);
        jPanelKhoaLayout.setHorizontalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelKhoaLayout.setVerticalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelKhoa);

        jPanelCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jLabelCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCoVan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelCoVan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("covan.png")));
        jLabelCoVan.setText("CỐ VẤN");

        jLabelLeft2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelCoVanLayout = new javax.swing.GroupLayout(jPanelCoVan);
        jPanelCoVan.setLayout(jPanelCoVanLayout);
        jPanelCoVanLayout.setHorizontalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCoVanLayout.setVerticalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelCoVan);

        jPanelLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLop.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLop.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("lop.png")));
        jLabelLop.setText(" LỚP");

        jLabelLeft3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLop, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLop);

        jPanelHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHocKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHocKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHocKy.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHocKy.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("hocky.png")));
        jLabelHocKy.setText("HỌC KỲ");

        jLabelLeft4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelHocKyLayout = new javax.swing.GroupLayout(jPanelHocKy);
        jPanelHocKy.setLayout(jPanelHocKyLayout);
        jPanelHocKyLayout.setHorizontalGroup(
            jPanelHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHocKyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelHocKyLayout.setVerticalGroup(
            jPanelHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHocKy, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHocKy);

        jPanelTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTaiKhoan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTaiKhoan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("acc.png")));
        jLabelTaiKhoan.setText("TÀI KHOẢN");
        jLabelTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLeft5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelTaiKhoanLayout = new javax.swing.GroupLayout(jPanelTaiKhoan);
        jPanelTaiKhoan.setLayout(jPanelTaiKhoanLayout);
        jPanelTaiKhoanLayout.setHorizontalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTaiKhoanLayout.setVerticalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelLeft5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTaiKhoan);

        jPanelChamDiem.setBackground(new java.awt.Color(255, 255, 255));
        jPanelChamDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelChamDiem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelChamDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelChamDiem.setForeground(new java.awt.Color(227, 70, 34));
        jLabelChamDiem.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("danhgia.png")));
        jLabelChamDiem.setText("ĐÁNH GIÁ ĐIỂM");

        jLabelLeft6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelChamDiemLayout = new javax.swing.GroupLayout(jPanelChamDiem);
        jPanelChamDiem.setLayout(jPanelChamDiemLayout);
        jPanelChamDiemLayout.setHorizontalGroup(
            jPanelChamDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChamDiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelChamDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelChamDiemLayout.setVerticalGroup(
            jPanelChamDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelChamDiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelLeft6, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelChamDiem);

        jPanelXemDiem.setBackground(new java.awt.Color(255, 255, 255));
        jPanelXemDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelXemDiem.setBackground(new java.awt.Color(255, 255, 255));
        jLabelXemDiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelXemDiem.setForeground(new java.awt.Color(227, 70, 34));
        jLabelXemDiem.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("xem.png")));
        jLabelXemDiem.setText("XEM ĐIỂM");

        jLabelLeft7.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelXemDiemLayout = new javax.swing.GroupLayout(jPanelXemDiem);
        jPanelXemDiem.setLayout(jPanelXemDiemLayout);
        jPanelXemDiemLayout.setHorizontalGroup(
            jPanelXemDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelXemDiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelXemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelXemDiemLayout.setVerticalGroup(
            jPanelXemDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelXemDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelXemDiem);

        jPanelNull1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3Dots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3Dots.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

        javax.swing.GroupLayout jPanelNull1Layout = new javax.swing.GroupLayout(jPanelNull1);
        jPanelNull1.setLayout(jPanelNull1Layout);
        jPanelNull1Layout.setHorizontalGroup(
            jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3Dots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNull1Layout.setVerticalGroup(
            jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNull1Layout.createSequentialGroup()
                .addComponent(jLabel3Dots, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelNull1);

        jPanelNull2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNull2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelNull2Layout = new javax.swing.GroupLayout(jPanelNull2);
        jPanelNull2.setLayout(jPanelNull2Layout);
        jPanelNull2Layout.setHorizontalGroup(
            jPanelNull2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelNull2Layout.setVerticalGroup(
            jPanelNull2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelNull2);

        jPanelNull3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNull3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNull3.setRequestFocusEnabled(false);
        jPanelNull3.setVerifyInputWhenFocusTarget(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

        javax.swing.GroupLayout jPanelNull3Layout = new javax.swing.GroupLayout(jPanelNull3);
        jPanelNull3.setLayout(jPanelNull3Layout);
        jPanelNull3Layout.setHorizontalGroup(
            jPanelNull3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNull3Layout.setVerticalGroup(
            jPanelNull3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNull3Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMenu.add(jPanelNull3);

        jPanelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelHelpMouseExited(evt);
            }
        });

        jLabelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHelp.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHelp.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("help.png")));
        jLabelHelp.setText("Trợ giúp");
        jLabelHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHelpMouseExited(evt);
            }
        });

        jLabelLeft8.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));
        jLabelLeft8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeft8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeft8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHelpLayout.setVerticalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHelp);

        jPanelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelLogOutMouseExited(evt);
            }
        });

        jLabelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLogOut.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLogOut.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("logout.png")));
        jLabelLogOut.setText("Thoát");
        jLabelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseExited(evt);
            }
        });

        jLabelLeft9.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));
        jLabelLeft9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLeft9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLeft9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelLogOutLayout = new javax.swing.GroupLayout(jPanelLogOut);
        jPanelLogOut.setLayout(jPanelLogOutLayout);
        jPanelLogOutLayout.setHorizontalGroup(
            jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLogOutLayout.setVerticalGroup(
            jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLeft9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLogOut);

        jPanelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContact.setBackground(new java.awt.Color(189, 56, 27));
        jPanelContact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMail.setBackground(new java.awt.Color(221, 51, 51));
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("mail.png")));
        jLabelMail.setText("Liên kết đào tạo quốc tế");
        jLabelMail.setToolTipText("");
        jLabelMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMail.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelMailMouseMoved(evt);
            }
        });
        jLabelMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMailMouseExited(evt);
            }
        });
        jPanelContact.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 170, -1));

        jPanelPtit.setBackground(new java.awt.Color(255, 255, 255));

        jLabelpanelPtit.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("logoptithcm.png")));
        jLabelpanelPtit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelLienHe.setBackground(new java.awt.Color(221, 51, 51));
        jPanelLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelLienHe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelLienHeMouseMoved(evt);
            }
        });
        jPanelLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelLienHeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelLienHeMouseExited(evt);
            }
        });

        jLabelLienHe.setBackground(new java.awt.Color(221, 51, 51));
        jLabelLienHe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLienHe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLienHe.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("mail2.png")));
        jLabelLienHe.setText("Liên hệ hỗ trợ");
        jLabelLienHe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelLienHeMouseMoved(evt);
            }
        });
        jLabelLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLienHeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLienHeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelLienHeLayout = new javax.swing.GroupLayout(jPanelLienHe);
        jPanelLienHe.setLayout(jPanelLienHeLayout);
        jPanelLienHeLayout.setHorizontalGroup(
            jPanelLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLienHeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelLienHeLayout.setVerticalGroup(
            jPanelLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPtitLayout = new javax.swing.GroupLayout(jPanelPtit);
        jPanelPtit.setLayout(jPanelPtitLayout);
        jPanelPtitLayout.setHorizontalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jPanelLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanelPtitLayout.setVerticalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanelLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContact.add(jPanelPtit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, -1));

        jLabelCloud.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("cloud.png")));
        jLabelCloud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelContact.add(jLabelCloud, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        jLabelFb.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("fb.png"
            + "")));
jLabelFb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
jPanelContact.add(jLabelFb, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, -1));

jPanelPanel.add(jPanelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 130));

jLayeredPaneMain.setRequestFocusEnabled(false);
jLayeredPaneMain.setVerifyInputWhenFocusTarget(false);

jPanelHocKyMain.setBackground(new java.awt.Color(204, 255, 204));
jPanelHocKyMain.setPreferredSize(new java.awt.Dimension(790, 620));
jPanelHocKyMain.setRequestFocusEnabled(false);
jPanelHocKyMain.setVerifyInputWhenFocusTarget(false);

jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabel16.setText("Học kỳ");

jPanel1.setBackground(new java.awt.Color(238, 238, 238));

jPanel2.setBackground(new java.awt.Color(221, 51, 51));

jLabel1.setBackground(new java.awt.Color(221, 51, 51));
jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel1.setForeground(new java.awt.Color(255, 255, 255));
jLabel1.setText(" Thông tin tài khoản");

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel1)
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    javax.swing.GroupLayout jPanelHocKyMainLayout = new javax.swing.GroupLayout(jPanelHocKyMain);
    jPanelHocKyMain.setLayout(jPanelHocKyMainLayout);
    jPanelHocKyMainLayout.setHorizontalGroup(
        jPanelHocKyMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelHocKyMainLayout.createSequentialGroup()
            .addGap(224, 224, 224)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(236, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHocKyMainLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelHocKyMainLayout.setVerticalGroup(
        jPanelHocKyMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelHocKyMainLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(237, 237, 237)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(274, Short.MAX_VALUE))
    );

    jPanelKhoaMain.setBackground(new java.awt.Color(255, 255, 0));
    jPanelKhoaMain.setPreferredSize(new java.awt.Dimension(621, 436));

    jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel12.setText("Khoa");

    javax.swing.GroupLayout jPanelKhoaMainLayout = new javax.swing.GroupLayout(jPanelKhoaMain);
    jPanelKhoaMain.setLayout(jPanelKhoaMainLayout);
    jPanelKhoaMainLayout.setHorizontalGroup(
        jPanelKhoaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelKhoaMainLayout.createSequentialGroup()
            .addGap(224, 224, 224)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(236, Short.MAX_VALUE))
    );
    jPanelKhoaMainLayout.setVerticalGroup(
        jPanelKhoaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelKhoaMainLayout.createSequentialGroup()
            .addGap(261, 261, 261)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanelChamDiemMain.setBackground(new java.awt.Color(255, 153, 153));
    jPanelChamDiemMain.setPreferredSize(new java.awt.Dimension(790, 620));
    jPanelChamDiemMain.setRequestFocusEnabled(false);
    jPanelChamDiemMain.setVerifyInputWhenFocusTarget(false);

    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("Chấm điểm");

    javax.swing.GroupLayout jPanelChamDiemMainLayout = new javax.swing.GroupLayout(jPanelChamDiemMain);
    jPanelChamDiemMain.setLayout(jPanelChamDiemMainLayout);
    jPanelChamDiemMainLayout.setHorizontalGroup(
        jPanelChamDiemMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChamDiemMainLayout.createSequentialGroup()
            .addGap(224, 224, 224)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(236, Short.MAX_VALUE))
    );
    jPanelChamDiemMainLayout.setVerticalGroup(
        jPanelChamDiemMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChamDiemMainLayout.createSequentialGroup()
            .addGap(261, 261, 261)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(288, Short.MAX_VALUE))
    );

    jPanelCoVanMain.setBackground(new java.awt.Color(51, 255, 255));
    jPanelCoVanMain.setPreferredSize(new java.awt.Dimension(645, 461));
    jPanelCoVanMain.setRequestFocusEnabled(false);
    jPanelCoVanMain.setVerifyInputWhenFocusTarget(false);

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel13.setText("Khoa");

    javax.swing.GroupLayout jPanelCoVanMainLayout = new javax.swing.GroupLayout(jPanelCoVanMain);
    jPanelCoVanMain.setLayout(jPanelCoVanMainLayout);
    jPanelCoVanMainLayout.setHorizontalGroup(
        jPanelCoVanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelCoVanMainLayout.createSequentialGroup()
            .addGap(224, 224, 224)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(236, Short.MAX_VALUE))
    );
    jPanelCoVanMainLayout.setVerticalGroup(
        jPanelCoVanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelCoVanMainLayout.createSequentialGroup()
            .addGap(261, 261, 261)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(288, Short.MAX_VALUE))
    );

    jPanelLopMain.setBackground(new java.awt.Color(204, 204, 255));
    jPanelLopMain.setPreferredSize(new java.awt.Dimension(684, 505));
    jPanelLopMain.setRequestFocusEnabled(false);
    jPanelLopMain.setVerifyInputWhenFocusTarget(false);

    jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel14.setText("Lớp");

    javax.swing.GroupLayout jPanelLopMainLayout = new javax.swing.GroupLayout(jPanelLopMain);
    jPanelLopMain.setLayout(jPanelLopMainLayout);
    jPanelLopMainLayout.setHorizontalGroup(
        jPanelLopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelLopMainLayout.createSequentialGroup()
            .addGap(230, 230, 230)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(230, Short.MAX_VALUE))
    );
    jPanelLopMainLayout.setVerticalGroup(
        jPanelLopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelLopMainLayout.createSequentialGroup()
            .addGap(261, 261, 261)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(288, Short.MAX_VALUE))
    );

    jPanelTaiKhoanMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelTaiKhoanMain.setPreferredSize(new java.awt.Dimension(804, 612));
    jPanelTaiKhoanMain.setRequestFocusEnabled(false);
    jPanelTaiKhoanMain.setVerifyInputWhenFocusTarget(false);

    jPanelTitleColor.setBackground(new java.awt.Color(221, 51, 51));

    jLabelTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTitile.setForeground(new java.awt.Color(255, 255, 255));
    jLabelTitile.setIcon(new javax.swing.ImageIcon("D:\\Project\\AppDRL\\src\\main\\java\\icons\\person.png")); // NOI18N
    jLabelTitile.setText("THÔNG TIN CÁ NHÂN");
    jLabelTitile.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

    javax.swing.GroupLayout jPanelTitleColorLayout = new javax.swing.GroupLayout(jPanelTitleColor);
    jPanelTitleColor.setLayout(jPanelTitleColorLayout);
    jPanelTitleColorLayout.setHorizontalGroup(
        jPanelTitleColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTitleColorLayout.createSequentialGroup()
            .addComponent(jLabelTitile, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanelTitleColorLayout.setVerticalGroup(
        jPanelTitleColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelTitile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelTitle1Layout = new javax.swing.GroupLayout(jPanelTitle1);
    jPanelTitle1.setLayout(jPanelTitle1Layout);
    jPanelTitle1Layout.setHorizontalGroup(
        jPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTitle1Layout.createSequentialGroup()
            .addComponent(jPanelTitleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 531, Short.MAX_VALUE))
    );
    jPanelTitle1Layout.setVerticalGroup(
        jPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelTitleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jPanelTitleColor1.setBackground(new java.awt.Color(221, 51, 51));
    jPanelTitleColor1.setPreferredSize(new java.awt.Dimension(219, 32));

    jLabelTitile1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTitile1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelTitile1.setIcon(new javax.swing.ImageIcon("D:\\Project\\AppDRL\\src\\main\\java\\icons\\whiteacc.png")); // NOI18N
    jLabelTitile1.setText("THÔNG TIN TÀI KHOẢN");
    jLabelTitile1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelTitile1.setPreferredSize(new java.awt.Dimension(219, 32));

    javax.swing.GroupLayout jPanelTitleColor1Layout = new javax.swing.GroupLayout(jPanelTitleColor1);
    jPanelTitleColor1.setLayout(jPanelTitleColor1Layout);
    jPanelTitleColor1Layout.setHorizontalGroup(
        jPanelTitleColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTitleColor1Layout.createSequentialGroup()
            .addComponent(jLabelTitile1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelTitleColor1Layout.setVerticalGroup(
        jPanelTitleColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelTitile1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelTitle2Layout = new javax.swing.GroupLayout(jPanelTitle2);
    jPanelTitle2.setLayout(jPanelTitle2Layout);
    jPanelTitle2Layout.setHorizontalGroup(
        jPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTitle2Layout.createSequentialGroup()
            .addComponent(jPanelTitleColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 533, Short.MAX_VALUE))
    );
    jPanelTitle2Layout.setVerticalGroup(
        jPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelTitleColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jLabelTieuDeTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeTen.setText("Họ và tên:");
    jLabelTieuDeTen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    jLabelTieuDeMSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMSV.setText("Mã số sinh viên:");

    jLabelTieuDeLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeLop.setText("Lớp:");

    jLabelTieuDeGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeGioiTinh.setText("Giới tính:");

    jLabelTieuDeNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeNgaySinh.setText("Ngày sinh:");

    jLabelTieuDeDRL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeDRL.setText("Điểm rèn luyện:");

    jLabelTieuDeSdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeSdt.setText("Số điện thoại:");

    jLabelTieuDeMailTruong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMailTruong.setText("Email trường cấp:");

    jLabelTieuDeMailCaNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMailCaNhan.setText("Email cá nhân:");

    jLabelTieuDeNganh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeNganh.setText("Chuyên ngành:");

    jLabelTieuDeQue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeQue.setText("Quê quán:");

    jLabelSuaThongTin.setBackground(new java.awt.Color(221, 51, 51));
    jLabelSuaThongTin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
    jLabelSuaThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelSuaThongTin.setIcon(new javax.swing.ImageIcon("D:\\Project\\AppDRL\\src\\main\\java\\icons\\changepersonal.png")); // NOI18N
    jLabelSuaThongTin.setText("SỬA THÔNG TIN CÁ NHÂN");
    jLabelSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelSuaThongTin.setOpaque(true);
    jLabelSuaThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabelSuaThongTinMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabelSuaThongTinMouseExited(evt);
        }
    });

    jLabelNoiDungTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungTen.setText("Ngô Văn Đạt");

    jLabelNoiDungLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungLop.setText("D21CQAT01-N");

    jLabelNoiDungGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungGioiTinh.setText("Nam");

    jLabelNoiDungDRL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungDRL.setText("72");

    jLabelNoiDungMailTruong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungMailTruong.setText("n21dcat010@student.ptithcm.edu.vn");

    jLabelNoiDungMSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungMSV.setText("N21DCAT010");

    jLabelNoiDungNganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungNganh.setText("An toàn thông tin");

    jLabelNoiDungNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungNgaySinh.setText("05/06/2003");

    jLabelNoiDungSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungSdt.setText("0352752950");

    jLabelNoiDungQue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungQue.setText("Thôn Ngọc Lâm 1, xã Hòa Mỹ Tây, huyện Tây Hòa, tỉnh Phú Yên");

    jLabelTieuDeNoiO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeNoiO.setText("Nơi ở hiện tại:");

    jLabelNoiDungNoiO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungNoiO.setText("Phường Bình Thọ, thành phố Thủ Đức, thành phố Hồ Chí Minh");

    jLabelTieuDeTenDN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeTenDN.setText("Tên đăng nhập:");

    jLabelTieuDeMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMK.setText("Mật khẩu:");

    jLabelDoiMatKhau.setBackground(new java.awt.Color(221, 51, 51));
    jLabelDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
    jLabelDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelDoiMatKhau.setIcon(new javax.swing.ImageIcon("D:\\Project\\AppDRL\\src\\main\\java\\icons\\changepass.png")); // NOI18N
    jLabelDoiMatKhau.setText("ĐỔI MẬT KHẨU");
    jLabelDoiMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelDoiMatKhau.setOpaque(true);
    jLabelDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabelDoiMatKhauMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabelDoiMatKhauMouseExited(evt);
        }
    });

    jLabelTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelTenDangNhap.setText("N21DCAT010");

    jPasswordField1.setEditable(false);
    jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jPasswordField1.setText("jPasswordField1");
    jPasswordField1.setAutoscrolls(false);
    jPasswordField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jPasswordField1.setEnabled(false);

    jLabelNoiDungMailCaNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungMailCaNhan.setText("vandatngongo@gmail.com");

    javax.swing.GroupLayout jPanelTaiKhoanMainLayout = new javax.swing.GroupLayout(jPanelTaiKhoanMain);
    jPanelTaiKhoanMain.setLayout(jPanelTaiKhoanMainLayout);
    jPanelTaiKhoanMainLayout.setHorizontalGroup(
        jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                    .addComponent(jLabelTieuDeMailCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabelNoiDungMailCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                    .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTieuDeMailTruong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTieuDeQue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTieuDeLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTieuDeGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTieuDeDRL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTieuDeNoiO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                            .addComponent(jLabelTieuDeTen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelNoiDungMailTruong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelNoiDungTen, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(jLabelNoiDungGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNoiDungDRL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabelNoiDungLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelTieuDeMSV, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addComponent(jLabelTieuDeNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTieuDeNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTieuDeSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelNoiDungSdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNoiDungNganh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                .addComponent(jLabelNoiDungMSV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNoiDungNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabelNoiDungQue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGap(198, 198, 198))
        .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabelNoiDungNoiO, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                                .addComponent(jLabelTieuDeTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabelTieuDeMK, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabelSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabelDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(0, 196, Short.MAX_VALUE))
    );
    jPanelTaiKhoanMainLayout.setVerticalGroup(
        jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTaiKhoanMainLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeTen)
                .addComponent(jLabelTieuDeMSV)
                .addComponent(jLabelNoiDungTen)
                .addComponent(jLabelNoiDungMSV))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeLop)
                .addComponent(jLabelNoiDungLop)
                .addComponent(jLabelTieuDeNganh)
                .addComponent(jLabelNoiDungNganh))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeGioiTinh)
                .addComponent(jLabelNoiDungGioiTinh)
                .addComponent(jLabelTieuDeNgaySinh)
                .addComponent(jLabelNoiDungNgaySinh))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeDRL)
                .addComponent(jLabelNoiDungDRL)
                .addComponent(jLabelTieuDeSdt)
                .addComponent(jLabelNoiDungSdt))
            .addGap(14, 14, 14)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeMailTruong)
                .addComponent(jLabelNoiDungMailTruong))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeMailCaNhan)
                .addComponent(jLabelNoiDungMailCaNhan))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelNoiDungQue)
                .addComponent(jLabelTieuDeQue))
            .addGap(18, 18, 18)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelTieuDeNoiO)
                .addComponent(jLabelNoiDungNoiO, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(18, 18, 18)
            .addComponent(jLabelSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeTenDN)
                .addComponent(jLabelTenDangNhap))
            .addGap(23, 23, 23)
            .addGroup(jPanelTaiKhoanMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelTieuDeMK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jLabelDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(30, Short.MAX_VALUE))
    );

    jPanelXemDiemMain.setBackground(new java.awt.Color(204, 0, 0));
    jPanelXemDiemMain.setPreferredSize(new java.awt.Dimension(574, 409));
    jPanelXemDiemMain.setRequestFocusEnabled(false);
    jPanelXemDiemMain.setVerifyInputWhenFocusTarget(false);

    jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel17.setText("Xem điểm");

    javax.swing.GroupLayout jPanelXemDiemMainLayout = new javax.swing.GroupLayout(jPanelXemDiemMain);
    jPanelXemDiemMain.setLayout(jPanelXemDiemMainLayout);
    jPanelXemDiemMainLayout.setHorizontalGroup(
        jPanelXemDiemMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelXemDiemMainLayout.createSequentialGroup()
            .addGap(224, 224, 224)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(236, Short.MAX_VALUE))
    );
    jPanelXemDiemMainLayout.setVerticalGroup(
        jPanelXemDiemMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelXemDiemMainLayout.createSequentialGroup()
            .addGap(261, 261, 261)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(288, Short.MAX_VALUE))
    );

    jLayeredPaneMain.setLayer(jPanelHocKyMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jLayeredPaneMain.setLayer(jPanelKhoaMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jLayeredPaneMain.setLayer(jPanelChamDiemMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jLayeredPaneMain.setLayer(jPanelCoVanMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jLayeredPaneMain.setLayer(jPanelLopMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jLayeredPaneMain.setLayer(jPanelTaiKhoanMain, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jLayeredPaneMain.setLayer(jPanelXemDiemMain, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout jLayeredPaneMainLayout = new javax.swing.GroupLayout(jLayeredPaneMain);
    jLayeredPaneMain.setLayout(jLayeredPaneMainLayout);
    jLayeredPaneMainLayout.setHorizontalGroup(
        jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jLayeredPaneMainLayout.createSequentialGroup()
            .addComponent(jPanelKhoaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCoVanMain, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLopMain, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHocKyMain, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTaiKhoanMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelChamDiemMain, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelXemDiemMain, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
    );
    jLayeredPaneMainLayout.setVerticalGroup(
        jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelKhoaMain, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCoVanMain, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLopMain, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHocKyMain, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneMainLayout.createSequentialGroup()
                .addComponent(jPanelTaiKhoanMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelChamDiemMain, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
        .addGroup(jLayeredPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelXemDiemMain, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelViewLayout = new javax.swing.GroupLayout(jPanelView);
    jPanelView.setLayout(jPanelViewLayout);
    jPanelViewLayout.setHorizontalGroup(
        jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(jPanelViewLayout.createSequentialGroup()
            .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLayeredPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
    );
    jPanelViewLayout.setVerticalGroup(
        jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelViewLayout.createSequentialGroup()
            .addComponent(jPanelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(9, 9, 9)
            .addGroup(jPanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPaneMain)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelView, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelKhoaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelKhoaFocusGained

        
    }//GEN-LAST:event_jLabelKhoaFocusGained

    private void jPanelKhoaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanelKhoaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelKhoaFocusGained

    private void jLabelKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKhoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelKhoaMouseClicked

    private void jLabelLeft1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelLeft1MouseMoved

    private void jPanelKhoaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelKhoaMouseMoved

        

    }//GEN-LAST:event_jPanelKhoaMouseMoved

    private void jLabelKhoaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKhoaMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelKhoaMouseMoved

    private void jLabelKhoaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKhoaMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelKhoaMouseDragged

    private void jLabelKhoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKhoaMouseExited
        // TODO add your handling code
    }//GEN-LAST:event_jLabelKhoaMouseExited

    private void jPanelKhoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelKhoaMouseExited
        // TODO add your handling code here:
        //jPanelKhoa.setBackground(Color.WHITE);
        //jPanelKhoa.revalidate(); // Cập nhật giao diện
        //jPanelKhoa.repaint();    // Vẽ lại giao diện
       
    }//GEN-LAST:event_jPanelKhoaMouseExited

    private void jPanelKhoaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelKhoaMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanelKhoaMouseDragged

    private void jLabelLienHeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLienHeMouseMoved
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jLabelLienHeMouseMoved

    private void jPanelLienHeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLienHeMouseMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanelLienHeMouseMoved

    private void jPanelLienHeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLienHeMouseExited
        // TODO add your handling code here:
        jPanelLienHe.setBackground(buttonHoverColor);
        jPanelLienHe.revalidate(); // Cập nhật giao diện
        jPanelLienHe.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelLienHeMouseExited

    private void jLabelLienHeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLienHeMouseExited
        // TODO add your handling code here:
        jPanelLienHe.setBackground(buttonColor);
        jPanelLienHe.revalidate(); // Cập nhật giao diện
        jPanelLienHe.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLienHeMouseExited

    private void jLabelMailMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMailMouseMoved
        // TODO add your handling code here:
        jLabelMail.setForeground(textColor);
    }//GEN-LAST:event_jLabelMailMouseMoved

    private void jLabelMailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMailMouseExited
        // TODO add your handling code here:
        jLabelMail.setForeground(white);
    }//GEN-LAST:event_jLabelMailMouseExited

    private void jPanelKhoaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelKhoaMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanelKhoaMouseReleased

    private void jLabelLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseEntered
        // TODO add your handling code here:
        jPanelLogOut.setBackground(hoveColor2);
        jPanelLogOut.revalidate(); // Cập nhật giao diện
        jPanelLogOut.repaint();    // Vẽ lại giao diện
        
    }//GEN-LAST:event_jLabelLogOutMouseEntered

    private void jPanelLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLogOutMouseExited
        // TODO add your handling code here:
        jPanelLogOut.setBackground(white);
        jPanelLogOut.revalidate(); // Cập nhật giao diện
        jPanelLogOut.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelLogOutMouseExited

    private void jPanelLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLogOutMouseEntered
        // TODO add your handling code here:
        jPanelLogOut.setBackground(hoveColor2);
        jPanelLogOut.revalidate(); // Cập nhật giao diện
        jPanelLogOut.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelLogOutMouseEntered

    private void jLabelHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHelpMouseEntered
        // TODO add your handling code here:
        jPanelHelp.setBackground(hoveColor2);
        jPanelHelp.revalidate(); // Cập nhật giao diện
        jPanelHelp.repaint();    // Vẽ lại giao diện
        
    }//GEN-LAST:event_jLabelHelpMouseEntered

    private void jPanelHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHelpMouseEntered
        // TODO add your handling code here:
        jPanelHelp.setBackground(hoveColor2);
        jPanelHelp.revalidate(); // Cập nhật giao diện
        jPanelHelp.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelHelpMouseEntered

    private void jPanelHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHelpMouseExited
        // TODO add your handling code here:
        jPanelHelp.setBackground(white);
        jPanelHelp.revalidate(); // Cập nhật giao diện
        jPanelHelp.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelHelpMouseExited

    private void jLabelLeft8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft8MouseEntered
        // TODO add your handling code here:
        jPanelHelp.setBackground(hoveColor2);
        jPanelHelp.revalidate(); // Cập nhật giao diện
        jPanelHelp.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLeft8MouseEntered

    private void jLabelHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHelpMouseExited
        // TODO add your handling code here:
        jPanelHelp.setBackground(white);
        jPanelHelp.revalidate(); // Cập nhật giao diện
        jPanelHelp.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelHelpMouseExited

    private void jLabelLeft9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft9MouseEntered
        // TODO add your handling code here:
        jPanelLogOut.setBackground(hoveColor2);
        jPanelLogOut.revalidate(); // Cập nhật giao diện
        jPanelLogOut.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLeft9MouseEntered

    private void jLabelLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseExited
        // TODO add your handling code here:
        jPanelLogOut.setBackground(white);
        jPanelLogOut.revalidate(); // Cập nhật giao diện
        jPanelLogOut.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLogOutMouseExited

    private void jLabelLeft9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft9MouseExited
        // TODO add your handling code here:
        jPanelLogOut.setBackground(white);
        jPanelLogOut.revalidate(); // Cập nhật giao diện
        jPanelLogOut.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLeft9MouseExited

    private void jLabelLeft8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft8MouseExited
        // TODO add your handling code here:
        jPanelHelp.setBackground(white);
        jPanelHelp.revalidate(); // Cập nhật giao diện
        jPanelHelp.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLeft8MouseExited

    private void jLabelLienHeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLienHeMouseEntered
        // TODO add your handling code here:
        // TODO add your handling code here:
        jPanelLienHe.setBackground(buttonHoverColor);
        jPanelLienHe.revalidate(); // Cập nhật giao diện
        jPanelLienHe.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelLienHeMouseEntered

    private void jPanelLienHeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLienHeMouseEntered
        // TODO add your handling code here:
        // TODO add your handling code here:
        jPanelLienHe.setBackground(buttonHoverColor);
        jPanelLienHe.revalidate(); // Cập nhật giao diện
        jPanelLienHe.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelLienHeMouseEntered

    private void jLabelSuaThongTinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaThongTinMouseEntered
        // TODO add your handling code here:
        jLabelSuaThongTin.setBackground(buttonHoverColor);
    }//GEN-LAST:event_jLabelSuaThongTinMouseEntered

    private void jLabelSuaThongTinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaThongTinMouseExited
        // TODO add your handling code here:
        jLabelSuaThongTin.setBackground(buttonColor);
    }//GEN-LAST:event_jLabelSuaThongTinMouseExited

    private void jLabelDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMatKhauMouseEntered
        // TODO add your handling code here:
        jLabelDoiMatKhau.setBackground(buttonHoverColor);
    }//GEN-LAST:event_jLabelDoiMatKhauMouseEntered

    private void jLabelDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMatKhauMouseExited
        // TODO add your handling code here:
        jLabelDoiMatKhau.setBackground(buttonColor);
    }//GEN-LAST:event_jLabelDoiMatKhauMouseExited

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
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormQuanLy().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3Dots;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelChamDiem;
    private javax.swing.JLabel jLabelCloud;
    private javax.swing.JLabel jLabelCoVan;
    private javax.swing.JLabel jLabelDoiMatKhau;
    private javax.swing.JLabel jLabelFb;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelHocKy;
    private javax.swing.JLabel jLabelKhoa;
    private javax.swing.JLabel jLabelLeft1;
    private javax.swing.JLabel jLabelLeft2;
    private javax.swing.JLabel jLabelLeft3;
    private javax.swing.JLabel jLabelLeft4;
    private javax.swing.JLabel jLabelLeft5;
    private javax.swing.JLabel jLabelLeft6;
    private javax.swing.JLabel jLabelLeft7;
    private javax.swing.JLabel jLabelLeft8;
    private javax.swing.JLabel jLabelLeft9;
    private javax.swing.JLabel jLabelLienHe;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLop;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNoiDungDRL;
    private javax.swing.JLabel jLabelNoiDungGioiTinh;
    private javax.swing.JLabel jLabelNoiDungLop;
    private javax.swing.JLabel jLabelNoiDungMSV;
    private javax.swing.JLabel jLabelNoiDungMailCaNhan;
    private javax.swing.JLabel jLabelNoiDungMailTruong;
    private javax.swing.JLabel jLabelNoiDungNganh;
    private javax.swing.JLabel jLabelNoiDungNgaySinh;
    private javax.swing.JLabel jLabelNoiDungNoiO;
    private javax.swing.JLabel jLabelNoiDungQue;
    private javax.swing.JLabel jLabelNoiDungSdt;
    private javax.swing.JLabel jLabelNoiDungTen;
    private javax.swing.JLabel jLabelSuaThongTin;
    private javax.swing.JLabel jLabelTaiKhoan;
    private javax.swing.JLabel jLabelTenDangNhap;
    private javax.swing.JLabel jLabelTieuDeDRL;
    private javax.swing.JLabel jLabelTieuDeGioiTinh;
    private javax.swing.JLabel jLabelTieuDeLop;
    private javax.swing.JLabel jLabelTieuDeMK;
    private javax.swing.JLabel jLabelTieuDeMSV;
    private javax.swing.JLabel jLabelTieuDeMailCaNhan;
    private javax.swing.JLabel jLabelTieuDeMailTruong;
    private javax.swing.JLabel jLabelTieuDeNganh;
    private javax.swing.JLabel jLabelTieuDeNgaySinh;
    private javax.swing.JLabel jLabelTieuDeNoiO;
    private javax.swing.JLabel jLabelTieuDeQue;
    private javax.swing.JLabel jLabelTieuDeSdt;
    private javax.swing.JLabel jLabelTieuDeTen;
    private javax.swing.JLabel jLabelTieuDeTenDN;
    private javax.swing.JLabel jLabelTitile;
    private javax.swing.JLabel jLabelTitile1;
    private javax.swing.JLabel jLabelXemDiem;
    private javax.swing.JLabel jLabelpanelPtit;
    private javax.swing.JLayeredPane jLayeredPaneMain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelChamDiem;
    private javax.swing.JPanel jPanelChamDiemMain;
    private javax.swing.JPanel jPanelCoVan;
    private javax.swing.JPanel jPanelCoVanMain;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelHocKy;
    private javax.swing.JPanel jPanelHocKyMain;
    private javax.swing.JPanel jPanelKhoa;
    private javax.swing.JPanel jPanelKhoaMain;
    private javax.swing.JPanel jPanelLienHe;
    private javax.swing.JPanel jPanelLogOut;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNull1;
    private javax.swing.JPanel jPanelNull2;
    private javax.swing.JPanel jPanelNull3;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JPanel jPanelTaiKhoanMain;
    private javax.swing.JPanel jPanelTitle1;
    private javax.swing.JPanel jPanelTitle2;
    private javax.swing.JPanel jPanelTitleColor;
    private javax.swing.JPanel jPanelTitleColor1;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPanel jPanelXemDiem;
    private javax.swing.JPanel jPanelXemDiemMain;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
