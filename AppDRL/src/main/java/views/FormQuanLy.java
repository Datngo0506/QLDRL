/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
//import javax.swing.BorderFactory;
import icons.Icon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        
        
        //Kích vào menu nào thì đó hiện màu vàng đậm
       ClickEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft1, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       ClickEvent(jPanelKhoa, jLabelKhoa, jLabelLeft2, jPanelTaiKhoan, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       ClickEvent(jPanelHocKy, jLabelHocKy, jLabelLeft3, jPanelKhoa, jPanelTaiKhoan, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       ClickEvent(jPanelLop, jLabelLop, jLabelLeft4, jPanelKhoa, jPanelHocKy, jPanelTaiKhoan, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       ClickEvent(jPanelCoVan, jLabelCoVan, jLabelLeft5, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelTaiKhoan, jPanelTieuChi, jPanelSinhVien);
       ClickEvent(jPanelTieuChi, jLabelTieuChi, jLabelLeft6, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTaiKhoan, jPanelSinhVien);
       ClickEvent(jPanelSinhVien, jLabelSinhVien, jLabelLeft7, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelTaiKhoan);
       
       //rê vào menu nào thì menu đó màu vàng nhạt
       EnterEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft1, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       EnterEvent(jPanelKhoa, jLabelKhoa, jLabelLeft2, jPanelTaiKhoan, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       EnterEvent(jPanelHocKy, jLabelHocKy, jLabelLeft3, jPanelKhoa, jPanelTaiKhoan, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       EnterEvent(jPanelLop, jLabelLop, jLabelLeft4, jPanelKhoa, jPanelHocKy, jPanelTaiKhoan, jPanelCoVan, jPanelTieuChi, jPanelSinhVien);
       EnterEvent(jPanelCoVan, jLabelCoVan, jLabelLeft5, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelTaiKhoan, jPanelTieuChi, jPanelSinhVien);
       EnterEvent(jPanelTieuChi, jLabelTieuChi, jLabelLeft6, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTaiKhoan, jPanelSinhVien);
       EnterEvent(jPanelSinhVien, jLabelSinhVien, jLabelLeft7, jPanelKhoa, jPanelHocKy, jPanelLop, jPanelCoVan, jPanelTieuChi, jPanelTaiKhoan);
        

        //Mặc định khi mở sẽ hiện màn hình tài khoản khi kích vào nút nào thì nút đó hiện ra phần màn hình đó
       jPanelTaiKhoan.setBackground(hoveColor);
        hienManHinhCanMo(jPanelTaiKhoanMain, jPanelKhoaMain, jPanelTieuChiMain, jPanelCoVanMain, jPanelLopMain, jPanelHocKyMain, jPanelSinhVienMain);
       
        ClickMenuEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft1, jPanelTaiKhoanMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain);
        ClickMenuEvent(jPanelKhoa, jLabelKhoa, jLabelLeft2, jPanelKhoaMain, jPanelTaiKhoanMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain);
        ClickMenuEvent(jPanelHocKy, jLabelHocKy, jLabelLeft3, jPanelHocKyMain, jPanelKhoaMain, jPanelTaiKhoanMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain);
        ClickMenuEvent(jPanelLop, jLabelLop, jLabelLeft4, jPanelLopMain, jPanelKhoaMain, jPanelHocKyMain, jPanelTaiKhoanMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelSinhVienMain);
        ClickMenuEvent(jPanelCoVan, jLabelCoVan, jLabelLeft5, jPanelCoVanMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelTaiKhoanMain, jPanelTieuChiMain, jPanelSinhVienMain);
        ClickMenuEvent(jPanelTieuChi, jLabelTieuChi, jLabelLeft6, jPanelTieuChiMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTaiKhoanMain, jPanelSinhVienMain);
        ClickMenuEvent(jPanelSinhVien, jLabelSinhVien, jLabelLeft7, jPanelSinhVienMain, jPanelKhoaMain, jPanelHocKyMain, jPanelLopMain, jPanelCoVanMain, jPanelTieuChiMain, jPanelTaiKhoanMain);
        
        //thêm vào các choice
        choiceKhoa1.add("CNTT2");
        choiceKhoa1.add("Viễn Thông");
        choiceKhoa1.add("Đa phương tiện");
        choiceKhoa1.add("Marketing");
        
        choiceKhoa2.add("CNTT2");
        choiceKhoa2.add("Viễn Thông");
        choiceKhoa2.add("Đa phương tiện");
        choiceKhoa2.add("Marketing");
        
        
        choiceKhoa3.add("HK1 2022-2023");
        choiceKhoa3.add("HK2 2022-2023");
        choiceKhoa3.add("HK1 2023-2024");
        choiceKhoa3.add("HK1 2023-2024");
        
        choiceKhoa4.add("CNTT2");
        choiceKhoa4.add("Viễn Thông");
        choiceKhoa4.add("Đa phương tiện");
        choiceKhoa4.add("Marketing");
        
        choiceKhoa5.add("D18CAQT01-N");
        choiceKhoa5.add("D19CAQT01-N");
        choiceKhoa5.add("D20CAQT01-N");
        choiceKhoa5.add("D21CAQT01-N");
        
        
        //rê vào các nút thêm sửa xóa sẽ đổi màu xanh
        
        //nút thêm
        buttonHoverEvent(jLabelNutThem1, jPanelNutThem1);
        buttonHoverEvent(jLabelNutThem2, jPanelNutThem2);
        buttonHoverEvent(jLabelNutThem3, jPanelNutThem3);
        buttonHoverEvent(jLabelNutThem4, jPanelNutThem4);
        buttonHoverEvent(jLabelNutThem5, jPanelNutThem5);
        buttonHoverEvent(jLabelNutThem6, jPanelNutThem6);
        buttonHoverEvent(jLabelNutXem, jPanelNutXem);
        
        //nút xóa
        buttonHoverEvent(jLabelNutXoa1, jPanelNutXoa1);
        buttonHoverEvent(jLabelNutXoa2, jPanelNutXoa2);
        buttonHoverEvent(jLabelNutXoa3, jPanelNutXoa3);
        buttonHoverEvent(jLabelNutXoa4, jPanelNutXoa4);
        buttonHoverEvent(jLabelNutXoa5, jPanelNutXoa5);
        buttonHoverEvent(jLabelNutXoa6, jPanelNutXoa6);
        
        //nút sửa
        buttonHoverEvent(jLabelNutSua1, jPanelNutSua1);
        buttonHoverEvent(jLabelNutSua2, jPanelNutSua2);
        buttonHoverEvent(jLabelNutSua3, jPanelNutSua3);
        buttonHoverEvent(jLabelNutSua4, jPanelNutSua4);
        buttonHoverEvent(jLabelNutSua5, jPanelNutSua5);
        buttonHoverEvent(jLabelNutSua6, jPanelNutSua6);

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
    
    public void buttonHoverEvent(JLabel label, JPanel panel){
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
        jPanelTaiKhoan = new javax.swing.JPanel();
        jLabelTaiKhoan = new javax.swing.JLabel();
        jLabelLeft1 = new javax.swing.JLabel();
        jPanelKhoa = new javax.swing.JPanel();
        jLabelKhoa = new javax.swing.JLabel();
        jLabelLeft2 = new javax.swing.JLabel();
        jPanelHocKy = new javax.swing.JPanel();
        jLabelHocKy = new javax.swing.JLabel();
        jLabelLeft3 = new javax.swing.JLabel();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jLabelLeft4 = new javax.swing.JLabel();
        jPanelCoVan = new javax.swing.JPanel();
        jLabelCoVan = new javax.swing.JLabel();
        jLabelLeft5 = new javax.swing.JLabel();
        jPanelTieuChi = new javax.swing.JPanel();
        jLabelTieuChi = new javax.swing.JLabel();
        jLabelLeft6 = new javax.swing.JLabel();
        jPanelSinhVien = new javax.swing.JPanel();
        jLabelSinhVien = new javax.swing.JLabel();
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
        jPanelLienHe = RoundedPanel.createRoundedPanel();
        jLabelLienHe = new javax.swing.JLabel();
        jLabelCloud = new javax.swing.JLabel();
        jLabelFb = new javax.swing.JLabel();
        jLayeredPaneMain = new javax.swing.JLayeredPane();
        jPanelHocKyMain = new javax.swing.JPanel();
        jPanelThanhTieuDe4 = new javax.swing.JPanel();
        jPanelNutTieuDe4 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe4 = new javax.swing.JLabel();
        jPanelNutSua4 = RoundedPanel.createRoundedPanel();
        jLabelNutSua4 = new javax.swing.JLabel();
        jPanelNutXoa4 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa4 = new javax.swing.JLabel();
        jPanelNutThem4 = RoundedPanel.createRoundedPanel();
        jLabelNutThem4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelKhoaMain = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelThanhTieuDe2 = new javax.swing.JPanel();
        jPanelNutTieuDe2 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe2 = new javax.swing.JLabel();
        jPanelNutSua2 = RoundedPanel.createRoundedPanel();
        jLabelNutSua2 = new javax.swing.JLabel();
        jPanelNutXoa2 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa2 = new javax.swing.JLabel();
        jPanelNutThem2 = RoundedPanel.createRoundedPanel();
        jLabelNutThem2 = new javax.swing.JLabel();
        jPanelTieuChiMain = new javax.swing.JPanel();
        jPanelThanhTieuDe3 = new javax.swing.JPanel();
        jPanelNutTieuDe3 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe3 = new javax.swing.JLabel();
        jPanelNutSua3 = RoundedPanel.createRoundedPanel();
        jLabelNutSua3 = new javax.swing.JLabel();
        jPanelNutXoa3 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa3 = new javax.swing.JLabel();
        jPanelNutThem3 = RoundedPanel.createRoundedPanel();
        jLabelNutThem3 = new javax.swing.JLabel();
        jPanelChoice3 = new javax.swing.JPanel();
        jLabelChon3 = new javax.swing.JLabel();
        choiceKhoa3 = new java.awt.Choice();
        jLabel5 = new javax.swing.JLabel();
        jPanelCoVanMain = new javax.swing.JPanel();
        jPanelThanhTieuDe1 = new javax.swing.JPanel();
        jPanelNutTieuDe1 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe1 = new javax.swing.JLabel();
        jPanelNutSua1 = RoundedPanel.createRoundedPanel();
        jLabelNutSua1 = new javax.swing.JLabel();
        jPanelNutXoa1 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa1 = new javax.swing.JLabel();
        jPanelNutThem1 = RoundedPanel.createRoundedPanel();
        jLabelNutThem1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelChoice1 = new javax.swing.JPanel();
        jLabelChon1 = new javax.swing.JLabel();
        choiceKhoa1 = new java.awt.Choice();
        jPanelLopMain = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelChoice2 = new javax.swing.JPanel();
        jLabelChon2 = new javax.swing.JLabel();
        choiceKhoa2 = new java.awt.Choice();
        jPanelThanhTieuDe5 = new javax.swing.JPanel();
        jPanelNutTieuDe5 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe5 = new javax.swing.JLabel();
        jPanelNutSua5 = RoundedPanel.createRoundedPanel();
        jLabelNutSua5 = new javax.swing.JLabel();
        jPanelNutXoa5 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa5 = new javax.swing.JLabel();
        jPanelNutThem5 = RoundedPanel.createRoundedPanel();
        jLabelNutThem5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelTaiKhoanMain = new javax.swing.JPanel();
        jPanelTitle1 = RoundedPanel.createRoundedPanel();
        jPanelTitleColor = RoundedPanel.createRoundedPanel();
        jLabelTitile = new javax.swing.JLabel();
        jPanelTitle2 = RoundedPanel.createRoundedPanel();
        jPanelTitleColor1 = RoundedPanel.createRoundedPanel();
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
        jLabelTenDangNhap = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelNoiDungMailCaNhan = new javax.swing.JLabel();
        jPanelSuaTT = RoundedPanel.createRoundedPanel();
        jLabelSuaThongTin = new javax.swing.JLabel();
        jPanelDoiMK = RoundedPanel.createRoundedPanel();
        jLabelDoiMatKhau = new javax.swing.JLabel();
        jPanelSinhVienMain = new javax.swing.JPanel();
        jPanelThanhTieuDe6 = new javax.swing.JPanel();
        jPanelNutTieuDe6 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe6 = new javax.swing.JLabel();
        jPanelNutSua6 = RoundedPanel.createRoundedPanel();
        jLabelNutSua6 = new javax.swing.JLabel();
        jPanelNutXoa6 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa6 = new javax.swing.JLabel();
        jPanelNutThem6 = RoundedPanel.createRoundedPanel();
        jLabelNutThem6 = new javax.swing.JLabel();
        jPanelNutXem = RoundedPanel.createRoundedPanel();
        jLabelNutXem = new javax.swing.JLabel();
        jPanelChoice4 = new javax.swing.JPanel();
        jLabelChon4 = new javax.swing.JLabel();
        choiceKhoa4 = new java.awt.Choice();
        jLabelChon5 = new javax.swing.JLabel();
        choiceKhoa5 = new java.awt.Choice();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ABC");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelView.setBackground(new java.awt.Color(189, 56, 27));
        jPanelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setRequestFocusEnabled(false);
        jPanelMenu.setVerifyInputWhenFocusTarget(false);
        jPanelMenu.setLayout(new java.awt.GridLayout(12, 1));

        jPanelTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelTaiKhoan.setPreferredSize(new java.awt.Dimension(160, 48));

        jLabelTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTaiKhoan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTaiKhoan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("acc.png")));
        jLabelTaiKhoan.setText("TÀI KHOẢN");
        jLabelTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLeft1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelTaiKhoanLayout = new javax.swing.GroupLayout(jPanelTaiKhoan);
        jPanelTaiKhoan.setLayout(jPanelTaiKhoanLayout);
        jPanelTaiKhoanLayout.setHorizontalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTaiKhoanLayout.setVerticalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTaiKhoan);

        jPanelKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jPanelKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelKhoa.setBackground(new java.awt.Color(255, 255, 102));
        jLabelKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelKhoa.setForeground(new java.awt.Color(227, 70, 34));
        jLabelKhoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("khoa.png")));
        jLabelKhoa.setText(" KHOA");
        jLabelLeft2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));
        javax.swing.GroupLayout jPanelKhoaLayout = new javax.swing.GroupLayout(jPanelKhoa);
        jPanelKhoa.setLayout(jPanelKhoaLayout);
        jPanelKhoaLayout.setHorizontalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelKhoaLayout.setVerticalGroup(
            jPanelKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelKhoa);

        jPanelHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHocKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHocKy.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHocKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHocKy.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHocKy.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("hocky.png")));
        jLabelHocKy.setText("HỌC KỲ");

        jLabelLeft3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelHocKyLayout = new javax.swing.GroupLayout(jPanelHocKy);
        jPanelHocKy.setLayout(jPanelHocKyLayout);
        jPanelHocKyLayout.setHorizontalGroup(
            jPanelHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHocKyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHocKyLayout.setVerticalGroup(
            jPanelHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHocKy, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHocKy);

        jPanelLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLop.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLop.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("lop.png")));
        jLabelLop.setText(" LỚP");

        jLabelLeft4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLop, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLop);

        jPanelCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jLabelCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCoVan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelCoVan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("covan.png")));
        jLabelCoVan.setText("CỐ VẤN");

        jLabelLeft5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelCoVanLayout = new javax.swing.GroupLayout(jPanelCoVan);
        jPanelCoVan.setLayout(jPanelCoVanLayout);
        jPanelCoVanLayout.setHorizontalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCoVanLayout.setVerticalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelCoVan);

        jPanelTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTieuChi.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTieuChi.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTieuChi.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("danhgia.png")));
        jLabelTieuChi.setText("TIÊU CHÍ ĐRL");

        jLabelLeft6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelTieuChiLayout = new javax.swing.GroupLayout(jPanelTieuChi);
        jPanelTieuChi.setLayout(jPanelTieuChiLayout);
        jPanelTieuChiLayout.setHorizontalGroup(
            jPanelTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTieuChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTieuChiLayout.setVerticalGroup(
            jPanelTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTieuChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelLeft6, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTieuChi);

        jPanelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSinhVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSinhVien.setForeground(new java.awt.Color(227, 70, 34));
        jLabelSinhVien.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redstudent32.png")));
        jLabelSinhVien.setText("SINH VIÊN");

        jLabelLeft7.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

        javax.swing.GroupLayout jPanelSinhVienLayout = new javax.swing.GroupLayout(jPanelSinhVien);
        jPanelSinhVien.setLayout(jPanelSinhVienLayout);
        jPanelSinhVienLayout.setHorizontalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSinhVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelSinhVienLayout.setVerticalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelSinhVien);

        jPanelNull1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3Dots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3Dots.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

        javax.swing.GroupLayout jPanelNull1Layout = new javax.swing.GroupLayout(jPanelNull1);
        jPanelNull1.setLayout(jPanelNull1Layout);
        jPanelNull1Layout.setHorizontalGroup(
            jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3Dots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
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
            .addGap(0, 205, Short.MAX_VALUE)
        );
        jPanelNull2Layout.setVerticalGroup(
            jPanelNull2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
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
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelHelpMouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHelpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHelpMouseExited(evt);
            }
        });

        jLabelLeft8.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));
        jLabelLeft8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeft8MouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelLogOutMouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseExited(evt);
            }
        });

        jLabelLeft9.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));
        jLabelLeft9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLeft9MouseClicked(evt);
            }
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

        jPanelView.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 140, 200, -1));

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

jPanelView.add(jPanelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

jLayeredPaneMain.setRequestFocusEnabled(false);
jLayeredPaneMain.setVerifyInputWhenFocusTarget(false);
jLayeredPaneMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jPanelHocKyMain.setBackground(new java.awt.Color(255, 255, 255));
jPanelHocKyMain.setPreferredSize(new java.awt.Dimension(790, 620));
jPanelHocKyMain.setRequestFocusEnabled(false);
jPanelHocKyMain.setVerifyInputWhenFocusTarget(false);
jPanelHocKyMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jPanelThanhTieuDe4.setPreferredSize(new java.awt.Dimension(770, 34));

jPanelNutTieuDe4.setBackground(new java.awt.Color(221, 51, 51));

jLabelNutTieuDe4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabelNutTieuDe4.setForeground(new java.awt.Color(255, 255, 255));
jLabelNutTieuDe4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitecalender.png")));
jLabelNutTieuDe4.setText("Học kỳ");
jLabelNutTieuDe4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
jLabelNutTieuDe4.setPreferredSize(new java.awt.Dimension(32, 16));

javax.swing.GroupLayout jPanelNutTieuDe4Layout = new javax.swing.GroupLayout(jPanelNutTieuDe4);
jPanelNutTieuDe4.setLayout(jPanelNutTieuDe4Layout);
jPanelNutTieuDe4Layout.setHorizontalGroup(
    jPanelNutTieuDe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanelNutTieuDe4Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabelNutTieuDe4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanelNutTieuDe4Layout.setVerticalGroup(
        jPanelNutTieuDe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua4.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     jLabelNutSua4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua4.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua4.setText("Sửa");
    jLabelNutSua4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua4.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutSua4Layout = new javax.swing.GroupLayout(jPanelNutSua4);
    jPanelNutSua4.setLayout(jPanelNutSua4Layout);
    jPanelNutSua4Layout.setHorizontalGroup(
        jPanelNutSua4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSua4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutSua4Layout.setVerticalGroup(
        jPanelNutSua4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutXoa4.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa4.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa4.setText("Xóa");
    jLabelNutXoa4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa4.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutXoa4Layout = new javax.swing.GroupLayout(jPanelNutXoa4);
    jPanelNutXoa4.setLayout(jPanelNutXoa4Layout);
    jPanelNutXoa4Layout.setHorizontalGroup(
        jPanelNutXoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelNutXoa4Layout.setVerticalGroup(
        jPanelNutXoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutThem4.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem4.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem4.setText("Thêm");
    jLabelNutThem4.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutThem4Layout = new javax.swing.GroupLayout(jPanelNutThem4);
    jPanelNutThem4.setLayout(jPanelNutThem4Layout);
    jPanelNutThem4Layout.setHorizontalGroup(
        jPanelNutThem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem4Layout.createSequentialGroup()
            .addGap(0, 8, Short.MAX_VALUE)
            .addComponent(jLabelNutThem4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutThem4Layout.setVerticalGroup(
        jPanelNutThem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe4Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe4);
    jPanelThanhTieuDe4.setLayout(jPanelThanhTieuDe4Layout);
    jPanelThanhTieuDe4Layout.setHorizontalGroup(
        jPanelThanhTieuDe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe4Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
            .addComponent(jPanelNutThem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe4Layout.setVerticalGroup(
        jPanelThanhTieuDe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelHocKyMain.add(jPanelThanhTieuDe4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel7.setText("(Bảng danh sách các học kỳ)");
    jPanelHocKyMain.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 54, 772, 560));

    jLayeredPaneMain.add(jPanelHocKyMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelKhoaMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelKhoaMain.setPreferredSize(new java.awt.Dimension(621, 436));
    jPanelKhoaMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("(Bảng danh sách các khoa)");
    jPanelKhoaMain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 764, 470));

    jPanelThanhTieuDe2.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe2.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteschool.png")));
    jLabelNutTieuDe2.setText("Khoa");
    jLabelNutTieuDe2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe2.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDe2Layout = new javax.swing.GroupLayout(jPanelNutTieuDe2);
    jPanelNutTieuDe2.setLayout(jPanelNutTieuDe2Layout);
    jPanelNutTieuDe2Layout.setHorizontalGroup(
        jPanelNutTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDe2Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDe2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanelNutTieuDe2Layout.setVerticalGroup(
        jPanelNutTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua2.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua2.setText("Sửa");
    jLabelNutSua2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua2.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutSua2Layout = new javax.swing.GroupLayout(jPanelNutSua2);
    jPanelNutSua2.setLayout(jPanelNutSua2Layout);
    jPanelNutSua2Layout.setHorizontalGroup(
        jPanelNutSua2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSua2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutSua2Layout.setVerticalGroup(
        jPanelNutSua2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutXoa2.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa2.setText("Xóa");
    jLabelNutXoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa2.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutXoa2Layout = new javax.swing.GroupLayout(jPanelNutXoa2);
    jPanelNutXoa2.setLayout(jPanelNutXoa2Layout);
    jPanelNutXoa2Layout.setHorizontalGroup(
        jPanelNutXoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelNutXoa2Layout.setVerticalGroup(
        jPanelNutXoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutThem2.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem2.setText("Thêm");
    jLabelNutThem2.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutThem2Layout = new javax.swing.GroupLayout(jPanelNutThem2);
    jPanelNutThem2.setLayout(jPanelNutThem2Layout);
    jPanelNutThem2Layout.setHorizontalGroup(
        jPanelNutThem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem2Layout.createSequentialGroup()
            .addGap(0, 8, Short.MAX_VALUE)
            .addComponent(jLabelNutThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutThem2Layout.setVerticalGroup(
        jPanelNutThem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe2Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe2);
    jPanelThanhTieuDe2.setLayout(jPanelThanhTieuDe2Layout);
    jPanelThanhTieuDe2Layout.setHorizontalGroup(
        jPanelThanhTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe2Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
            .addComponent(jPanelNutThem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe2Layout.setVerticalGroup(
        jPanelThanhTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelKhoaMain.add(jPanelThanhTieuDe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLayeredPaneMain.add(jPanelKhoaMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelTieuChiMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelTieuChiMain.setPreferredSize(new java.awt.Dimension(790, 620));
    jPanelTieuChiMain.setRequestFocusEnabled(false);
    jPanelTieuChiMain.setVerifyInputWhenFocusTarget(false);
    jPanelTieuChiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDe3.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe3.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe3.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitetieuchi.png")));
    jLabelNutTieuDe3.setText("Tiêu chí");
    jLabelNutTieuDe3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe3.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDe3Layout = new javax.swing.GroupLayout(jPanelNutTieuDe3);
    jPanelNutTieuDe3.setLayout(jPanelNutTieuDe3Layout);
    jPanelNutTieuDe3Layout.setHorizontalGroup(
        jPanelNutTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDe3Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDe3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanelNutTieuDe3Layout.setVerticalGroup(
        jPanelNutTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua3.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua3.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua3.setText("Sửa");
    jLabelNutSua3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua3.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutSua3Layout = new javax.swing.GroupLayout(jPanelNutSua3);
    jPanelNutSua3.setLayout(jPanelNutSua3Layout);
    jPanelNutSua3Layout.setHorizontalGroup(
        jPanelNutSua3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSua3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutSua3Layout.setVerticalGroup(
        jPanelNutSua3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutXoa3.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa3.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa3.setText("Xóa");
    jLabelNutXoa3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa3.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutXoa3Layout = new javax.swing.GroupLayout(jPanelNutXoa3);
    jPanelNutXoa3.setLayout(jPanelNutXoa3Layout);
    jPanelNutXoa3Layout.setHorizontalGroup(
        jPanelNutXoa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelNutXoa3Layout.setVerticalGroup(
        jPanelNutXoa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutThem3.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem3.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem3.setText("Thêm");
    jLabelNutThem3.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutThem3Layout = new javax.swing.GroupLayout(jPanelNutThem3);
    jPanelNutThem3.setLayout(jPanelNutThem3Layout);
    jPanelNutThem3Layout.setHorizontalGroup(
        jPanelNutThem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem3Layout.createSequentialGroup()
            .addGap(0, 8, Short.MAX_VALUE)
            .addComponent(jLabelNutThem3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutThem3Layout.setVerticalGroup(
        jPanelNutThem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe3Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe3);
    jPanelThanhTieuDe3.setLayout(jPanelThanhTieuDe3Layout);
    jPanelThanhTieuDe3Layout.setHorizontalGroup(
        jPanelThanhTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe3Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
            .addComponent(jPanelNutThem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe3Layout.setVerticalGroup(
        jPanelThanhTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelTieuChiMain.add(jPanelThanhTieuDe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelChoice3.setBackground(new java.awt.Color(255, 255, 255));

    jLabelChon3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChon3.setText("Chọn học kỳ - niên khóa:");

    choiceKhoa3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa3.setPreferredSize(new java.awt.Dimension(28, 50));

    javax.swing.GroupLayout jPanelChoice3Layout = new javax.swing.GroupLayout(jPanelChoice3);
    jPanelChoice3.setLayout(jPanelChoice3Layout);
    jPanelChoice3Layout.setHorizontalGroup(
        jPanelChoice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice3Layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addComponent(jLabelChon3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(choiceKhoa3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(344, Short.MAX_VALUE))
    );
    jPanelChoice3Layout.setVerticalGroup(
        jPanelChoice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice3Layout.createSequentialGroup()
            .addGroup(jPanelChoice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(choiceKhoa3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelChon3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 14, Short.MAX_VALUE))
    );

    jPanelTieuChiMain.add(jPanelChoice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 764, -1));

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("(Bảng danh sách các tiêu chí đánh giá thuộc học kỳ được chọn)");
    jPanelTieuChiMain.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 764, 370));

    jLayeredPaneMain.add(jPanelTieuChiMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelCoVanMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelCoVanMain.setPreferredSize(new java.awt.Dimension(645, 461));
    jPanelCoVanMain.setRequestFocusEnabled(false);
    jPanelCoVanMain.setVerifyInputWhenFocusTarget(false);
    jPanelCoVanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDe1.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe1.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteteacher.png")));
    jLabelNutTieuDe1.setText("Cố vấn");
    jLabelNutTieuDe1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe1.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDe1Layout = new javax.swing.GroupLayout(jPanelNutTieuDe1);
    jPanelNutTieuDe1.setLayout(jPanelNutTieuDe1Layout);
    jPanelNutTieuDe1Layout.setHorizontalGroup(
        jPanelNutTieuDe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDe1Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanelNutTieuDe1Layout.setVerticalGroup(
        jPanelNutTieuDe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua1.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua1.setText("Sửa");
    jLabelNutSua1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua1.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutSua1Layout = new javax.swing.GroupLayout(jPanelNutSua1);
    jPanelNutSua1.setLayout(jPanelNutSua1Layout);
    jPanelNutSua1Layout.setHorizontalGroup(
        jPanelNutSua1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSua1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutSua1Layout.setVerticalGroup(
        jPanelNutSua1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutXoa1.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa1.setText("Xóa");
    jLabelNutXoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa1.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutXoa1Layout = new javax.swing.GroupLayout(jPanelNutXoa1);
    jPanelNutXoa1.setLayout(jPanelNutXoa1Layout);
    jPanelNutXoa1Layout.setHorizontalGroup(
        jPanelNutXoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelNutXoa1Layout.setVerticalGroup(
        jPanelNutXoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutThem1.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem1.setText("Thêm");
    jLabelNutThem1.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutThem1Layout = new javax.swing.GroupLayout(jPanelNutThem1);
    jPanelNutThem1.setLayout(jPanelNutThem1Layout);
    jPanelNutThem1Layout.setHorizontalGroup(
        jPanelNutThem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem1Layout.createSequentialGroup()
            .addGap(0, 8, Short.MAX_VALUE)
            .addComponent(jLabelNutThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutThem1Layout.setVerticalGroup(
        jPanelNutThem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe1Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe1);
    jPanelThanhTieuDe1.setLayout(jPanelThanhTieuDe1Layout);
    jPanelThanhTieuDe1Layout.setHorizontalGroup(
        jPanelThanhTieuDe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe1Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
            .addComponent(jPanelNutThem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe1Layout.setVerticalGroup(
        jPanelThanhTieuDe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelCoVanMain.add(jPanelThanhTieuDe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("(Bảng danh sách các cố vấn thuộc khoa được chọn)");
    jPanelCoVanMain.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 764, 370));

    jPanelChoice1.setBackground(new java.awt.Color(255, 255, 255));

    jLabelChon1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChon1.setText("Chọn khoa:");

    choiceKhoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa1.setPreferredSize(new java.awt.Dimension(28, 50));

    javax.swing.GroupLayout jPanelChoice1Layout = new javax.swing.GroupLayout(jPanelChoice1);
    jPanelChoice1.setLayout(jPanelChoice1Layout);
    jPanelChoice1Layout.setHorizontalGroup(
        jPanelChoice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice1Layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addComponent(jLabelChon1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(choiceKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelChoice1Layout.setVerticalGroup(
        jPanelChoice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice1Layout.createSequentialGroup()
            .addGroup(jPanelChoice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(choiceKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelChon1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 14, Short.MAX_VALUE))
    );

    jPanelCoVanMain.add(jPanelChoice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 764, -1));

    jLayeredPaneMain.add(jPanelCoVanMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelLopMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelLopMain.setPreferredSize(new java.awt.Dimension(684, 505));
    jPanelLopMain.setRequestFocusEnabled(false);
    jPanelLopMain.setVerifyInputWhenFocusTarget(false);
    jPanelLopMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText("Bảng danh sách các lớp");
    jPanelLopMain.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

    jPanelChoice2.setBackground(new java.awt.Color(255, 255, 255));

    jLabelChon2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChon2.setText("Chọn khoa:");

    choiceKhoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa2.setPreferredSize(new java.awt.Dimension(28, 50));

    javax.swing.GroupLayout jPanelChoice2Layout = new javax.swing.GroupLayout(jPanelChoice2);
    jPanelChoice2.setLayout(jPanelChoice2Layout);
    jPanelChoice2Layout.setHorizontalGroup(
        jPanelChoice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice2Layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addComponent(jLabelChon2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(choiceKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(433, Short.MAX_VALUE))
    );
    jPanelChoice2Layout.setVerticalGroup(
        jPanelChoice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(choiceKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabelChon2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jPanelLopMain.add(jPanelChoice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 764, -1));

    jPanelThanhTieuDe5.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe5.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteclass.png")));
    jLabelNutTieuDe5.setText("Lớp");
    jLabelNutTieuDe5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe5.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDe5Layout = new javax.swing.GroupLayout(jPanelNutTieuDe5);
    jPanelNutTieuDe5.setLayout(jPanelNutTieuDe5Layout);
    jPanelNutTieuDe5Layout.setHorizontalGroup(
        jPanelNutTieuDe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDe5Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDe5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanelNutTieuDe5Layout.setVerticalGroup(
        jPanelNutTieuDe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua5.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua5.setText("Sửa");
    jLabelNutSua5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua5.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutSua5Layout = new javax.swing.GroupLayout(jPanelNutSua5);
    jPanelNutSua5.setLayout(jPanelNutSua5Layout);
    jPanelNutSua5Layout.setHorizontalGroup(
        jPanelNutSua5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSua5, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutSua5Layout.setVerticalGroup(
        jPanelNutSua5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutXoa5.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa5.setText("Xóa");
    jLabelNutXoa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa5.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutXoa5Layout = new javax.swing.GroupLayout(jPanelNutXoa5);
    jPanelNutXoa5.setLayout(jPanelNutXoa5Layout);
    jPanelNutXoa5Layout.setHorizontalGroup(
        jPanelNutXoa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa5, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelNutXoa5Layout.setVerticalGroup(
        jPanelNutXoa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutThem5.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem5.setText("Thêm");
    jLabelNutThem5.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutThem5Layout = new javax.swing.GroupLayout(jPanelNutThem5);
    jPanelNutThem5.setLayout(jPanelNutThem5Layout);
    jPanelNutThem5Layout.setHorizontalGroup(
        jPanelNutThem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem5Layout.createSequentialGroup()
            .addGap(0, 8, Short.MAX_VALUE)
            .addComponent(jLabelNutThem5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutThem5Layout.setVerticalGroup(
        jPanelNutThem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe5Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe5);
    jPanelThanhTieuDe5.setLayout(jPanelThanhTieuDe5Layout);
    jPanelThanhTieuDe5Layout.setHorizontalGroup(
        jPanelThanhTieuDe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe5Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
            .addComponent(jPanelNutThem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe5Layout.setVerticalGroup(
        jPanelThanhTieuDe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelLopMain.add(jPanelThanhTieuDe5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("(Bảng danh sách các sinh viên thuộc khoa, thuộc lớp kỳ được chọn)");
    jPanelLopMain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 764, 420));

    jLayeredPaneMain.add(jPanelLopMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelTaiKhoanMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelTaiKhoanMain.setPreferredSize(new java.awt.Dimension(804, 612));
    jPanelTaiKhoanMain.setRequestFocusEnabled(false);
    jPanelTaiKhoanMain.setVerifyInputWhenFocusTarget(false);
    jPanelTaiKhoanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelTitleColor.setBackground(new java.awt.Color(221, 51, 51));

    jLabelTitile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTitile.setForeground(new java.awt.Color(255, 255, 255));
    jLabelTitile.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("person.png")));
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
        .addGroup(jPanelTitleColorLayout.createSequentialGroup()
            .addComponent(jLabelTitile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelTitle1Layout = new javax.swing.GroupLayout(jPanelTitle1);
    jPanelTitle1.setLayout(jPanelTitle1Layout);
    jPanelTitle1Layout.setHorizontalGroup(
        jPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTitle1Layout.createSequentialGroup()
            .addComponent(jPanelTitleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 551, Short.MAX_VALUE))
    );
    jPanelTitle1Layout.setVerticalGroup(
        jPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelTitleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jPanelTaiKhoanMain.add(jPanelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 770, -1));

    jPanelTitleColor1.setBackground(new java.awt.Color(221, 51, 51));
    jPanelTitleColor1.setPreferredSize(new java.awt.Dimension(219, 32));

    jLabelTitile1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTitile1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelTitile1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteacc.png")));
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
            .addGap(0, 551, Short.MAX_VALUE))
    );
    jPanelTitle2Layout.setVerticalGroup(
        jPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelTitleColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jPanelTaiKhoanMain.add(jPanelTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 372, 770, -1));

    jLabelTieuDeTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeTen.setText("Họ và tên:");
    jLabelTieuDeTen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jPanelTaiKhoanMain.add(jLabelTieuDeTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 44, 126, -1));

    jLabelTieuDeMSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMSV.setText("Mã giảng viên:");
    jPanelTaiKhoanMain.add(jLabelTieuDeMSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 44, 116, -1));

    jLabelTieuDeLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeLop.setText("Ngày về trường:");
    jPanelTaiKhoanMain.add(jLabelTieuDeLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 76, 126, -1));

    jLabelTieuDeGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeGioiTinh.setText("Giới tính:");
    jPanelTaiKhoanMain.add(jLabelTieuDeGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 108, 126, -1));

    jLabelTieuDeNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeNgaySinh.setText("Ngày sinh:");
    jPanelTaiKhoanMain.add(jLabelTieuDeNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 108, 116, -1));

    jLabelTieuDeDRL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeDRL.setText("Chức vụ:");
    jPanelTaiKhoanMain.add(jLabelTieuDeDRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 140, 126, -1));

    jLabelTieuDeSdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeSdt.setText("Số điện thoại:");
    jPanelTaiKhoanMain.add(jLabelTieuDeSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 116, -1));

    jLabelTieuDeMailTruong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMailTruong.setText("Email trường cấp:");
    jPanelTaiKhoanMain.add(jLabelTieuDeMailTruong, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 174, 126, -1));

    jLabelTieuDeMailCaNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMailCaNhan.setText("Email cá nhân:");
    jPanelTaiKhoanMain.add(jLabelTieuDeMailCaNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 206, 116, -1));

    jLabelTieuDeNganh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeNganh.setText("Trình độ:");
    jPanelTaiKhoanMain.add(jLabelTieuDeNganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 76, 116, -1));

    jLabelTieuDeQue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeQue.setText("Quê quán:");
    jPanelTaiKhoanMain.add(jLabelTieuDeQue, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 238, 126, -1));

    jLabelNoiDungTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungTen.setText("Thầy Trần Văn A");
    jPanelTaiKhoanMain.add(jLabelNoiDungTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 44, 226, -1));

    jLabelNoiDungLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungLop.setText("04/03/2012");
    jPanelTaiKhoanMain.add(jLabelNoiDungLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 76, 226, -1));

    jLabelNoiDungGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungGioiTinh.setText("Nam");
    jPanelTaiKhoanMain.add(jLabelNoiDungGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 108, 226, -1));

    jLabelNoiDungDRL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungDRL.setText("Đảng viên");
    jPanelTaiKhoanMain.add(jLabelNoiDungDRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 140, 226, -1));

    jLabelNoiDungMailTruong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungMailTruong.setText("tranvana@ptithcm.edu.vn");
    jPanelTaiKhoanMain.add(jLabelNoiDungMailTruong, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 174, 598, -1));

    jLabelNoiDungMSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungMSV.setText("QT123456");
    jPanelTaiKhoanMain.add(jLabelNoiDungMSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 44, 244, -1));

    jLabelNoiDungNganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungNganh.setText("Thạc sĩ");
    jPanelTaiKhoanMain.add(jLabelNoiDungNganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 76, 244, -1));

    jLabelNoiDungNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungNgaySinh.setText("05/06/1987");
    jPanelTaiKhoanMain.add(jLabelNoiDungNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 108, 244, -1));

    jLabelNoiDungSdt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungSdt.setText("0352862650");
    jPanelTaiKhoanMain.add(jLabelNoiDungSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 140, 244, -1));

    jLabelNoiDungQue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungQue.setText("Thôn Ông A, xã Bà B, huyện Chị C, tỉnh Tiền Giang");
    jPanelTaiKhoanMain.add(jLabelNoiDungQue, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 238, 598, -1));

    jLabelTieuDeNoiO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeNoiO.setText("Nơi ở hiện tại:");
    jPanelTaiKhoanMain.add(jLabelTieuDeNoiO, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 276, 126, -1));

    jLabelNoiDungNoiO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungNoiO.setText("Phường Bình Thọ, thành phố Thủ Đức, thành phố Hồ Chí Minh");
    jPanelTaiKhoanMain.add(jLabelNoiDungNoiO, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 276, 600, -1));

    jLabelTieuDeTenDN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeTenDN.setText("Tên đăng nhập:");
    jPanelTaiKhoanMain.add(jLabelTieuDeTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 428, 125, -1));

    jLabelTieuDeMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelTieuDeMK.setText("Mật khẩu:");
    jPanelTaiKhoanMain.add(jLabelTieuDeMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 473, 125, 39));

    jLabelTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelTenDangNhap.setText("QT123456");
    jPanelTaiKhoanMain.add(jLabelTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 428, 306, -1));

    jPasswordField1.setEditable(false);
    jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jPasswordField1.setText("jPasswordField1");
    jPasswordField1.setAutoscrolls(false);
    jPasswordField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    jPasswordField1.setEnabled(false);
    jPanelTaiKhoanMain.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 471, 282, 39));

    jLabelNoiDungMailCaNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabelNoiDungMailCaNhan.setText("tranvana132@gmail.com");
    jPanelTaiKhoanMain.add(jLabelNoiDungMailCaNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 206, 596, -1));

    jPanelSuaTT.setBackground(new java.awt.Color(221, 51, 51));
    jPanelSuaTT.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jPanelSuaTTMouseEntered(evt);
        }
    });

    jLabelSuaThongTin.setBackground(new java.awt.Color(221, 51, 51));
    jLabelSuaThongTin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
    jLabelSuaThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelSuaThongTin.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("changepersonal.png")));
    jLabelSuaThongTin.setText("SỬA THÔNG TIN");
    jLabelSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelSuaThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabelSuaThongTinMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabelSuaThongTinMouseExited(evt);
        }
    });

    javax.swing.GroupLayout jPanelSuaTTLayout = new javax.swing.GroupLayout(jPanelSuaTT);
    jPanelSuaTT.setLayout(jPanelSuaTTLayout);
    jPanelSuaTTLayout.setHorizontalGroup(
        jPanelSuaTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelSuaThongTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
    );
    jPanelSuaTTLayout.setVerticalGroup(
        jPanelSuaTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuaTTLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabelSuaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanelTaiKhoanMain.add(jPanelSuaTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 314, 170, -1));

    jPanelDoiMK.setBackground(new java.awt.Color(221, 51, 51));

    jLabelDoiMatKhau.setBackground(new java.awt.Color(221, 51, 51));
    jLabelDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
    jLabelDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelDoiMatKhau.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("changepass.png")));
    jLabelDoiMatKhau.setText("ĐỔI MẬT KHẨU");
    jLabelDoiMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jLabelDoiMatKhauMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jLabelDoiMatKhauMouseExited(evt);
        }
    });

    javax.swing.GroupLayout jPanelDoiMKLayout = new javax.swing.GroupLayout(jPanelDoiMK);
    jPanelDoiMK.setLayout(jPanelDoiMKLayout);
    jPanelDoiMKLayout.setHorizontalGroup(
        jPanelDoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelDoiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
    );
    jPanelDoiMKLayout.setVerticalGroup(
        jPanelDoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelDoiMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelTaiKhoanMain.add(jPanelDoiMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 529, 160, 40));

    jLayeredPaneMain.add(jPanelTaiKhoanMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    jPanelSinhVienMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelSinhVienMain.setPreferredSize(new java.awt.Dimension(574, 409));
    jPanelSinhVienMain.setRequestFocusEnabled(false);
    jPanelSinhVienMain.setVerifyInputWhenFocusTarget(false);
    jPanelSinhVienMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDe6.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe6.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe6.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitestudent.png")));
    jLabelNutTieuDe6.setText("Sinh viên");
    jLabelNutTieuDe6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe6.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDe6Layout = new javax.swing.GroupLayout(jPanelNutTieuDe6);
    jPanelNutTieuDe6.setLayout(jPanelNutTieuDe6Layout);
    jPanelNutTieuDe6Layout.setHorizontalGroup(
        jPanelNutTieuDe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDe6Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDe6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(21, Short.MAX_VALUE))
    );
    jPanelNutTieuDe6Layout.setVerticalGroup(
        jPanelNutTieuDe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua6.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua6.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua6.setText("Sửa");
    jLabelNutSua6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua6.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutSua6Layout = new javax.swing.GroupLayout(jPanelNutSua6);
    jPanelNutSua6.setLayout(jPanelNutSua6Layout);
    jPanelNutSua6Layout.setHorizontalGroup(
        jPanelNutSua6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSua6, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutSua6Layout.setVerticalGroup(
        jPanelNutSua6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutXoa6.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoa6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa6.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa6.setText("Xóa");
    jLabelNutXoa6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa6.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutXoa6Layout = new javax.swing.GroupLayout(jPanelNutXoa6);
    jPanelNutXoa6.setLayout(jPanelNutXoa6Layout);
    jPanelNutXoa6Layout.setHorizontalGroup(
        jPanelNutXoa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa6, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanelNutXoa6Layout.setVerticalGroup(
        jPanelNutXoa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelNutThem6.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem6.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem6.setText("Thêm");
    jLabelNutThem6.setPreferredSize(new java.awt.Dimension(32, 16));
    javax.swing.GroupLayout jPanelNutThem6Layout = new javax.swing.GroupLayout(jPanelNutThem6);
    jPanelNutThem6.setLayout(jPanelNutThem6Layout);
    jPanelNutThem6Layout.setHorizontalGroup(
        jPanelNutThem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem6Layout.createSequentialGroup()
            .addGap(0, 14, Short.MAX_VALUE)
            .addComponent(jLabelNutThem6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutThem6Layout.setVerticalGroup(
        jPanelNutThem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXem.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXem.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXem.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteview.png")));
    jLabelNutXem.setText("Xem điểm");
    jLabelNutXem.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutXemLayout = new javax.swing.GroupLayout(jPanelNutXem);
    jPanelNutXem.setLayout(jPanelNutXemLayout);
    jPanelNutXemLayout.setHorizontalGroup(
        jPanelNutXemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXemLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXem, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
    );
    jPanelNutXemLayout.setVerticalGroup(
        jPanelNutXemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe6Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe6);
    jPanelThanhTieuDe6.setLayout(jPanelThanhTieuDe6Layout);
    jPanelThanhTieuDe6Layout.setHorizontalGroup(
        jPanelThanhTieuDe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe6Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
            .addComponent(jPanelNutXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutThem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe6Layout.setVerticalGroup(
        jPanelThanhTieuDe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelSinhVienMain.add(jPanelThanhTieuDe6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelChoice4.setBackground(new java.awt.Color(255, 255, 255));

    jLabelChon4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChon4.setText("Chọn khoa:");

    choiceKhoa4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa4.setPreferredSize(new java.awt.Dimension(28, 50));

    jLabelChon5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChon5.setText("Chọn lớp:");

    choiceKhoa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa5.setPreferredSize(new java.awt.Dimension(28, 50));

    javax.swing.GroupLayout jPanelChoice4Layout = new javax.swing.GroupLayout(jPanelChoice4);
    jPanelChoice4.setLayout(jPanelChoice4Layout);
    jPanelChoice4Layout.setHorizontalGroup(
        jPanelChoice4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice4Layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addComponent(jLabelChon4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(choiceKhoa4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabelChon5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(choiceKhoa5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(142, Short.MAX_VALUE))
    );
    jPanelChoice4Layout.setVerticalGroup(
        jPanelChoice4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelChoice4Layout.createSequentialGroup()
            .addGroup(jPanelChoice4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(choiceKhoa4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelChon4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelChon5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(choiceKhoa5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 24, Short.MAX_VALUE))
    );

    jPanelSinhVienMain.add(jPanelChoice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 764, -1));

    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("(Bảng danh sách các sinh viên thuộc khoa, thuộc lớp kỳ được chọn)");
    jPanelSinhVienMain.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 764, 370));

    jLayeredPaneMain.add(jPanelSinhVienMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelView.add(jLayeredPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 784, -1));

    getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 748));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    

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

    

    private void jLabelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Bạn có chắc chắc thoát?");
        this.setVisible(false);
    }//GEN-LAST:event_jLabelLogOutMouseClicked

    private void jLabelLeft9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft9MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Bạn có chắc chắc thoát?");
        this.setVisible(false);
    }//GEN-LAST:event_jLabelLeft9MouseClicked

    private void jPanelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelLogOutMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Bạn có chắc chắc thoát?");
        this.setVisible(false);
    }//GEN-LAST:event_jPanelLogOutMouseClicked

    private void jLabelHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHelpMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "ABCXYZ");
    }//GEN-LAST:event_jLabelHelpMouseClicked

    private void jLabelLeft8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLeft8MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "ABCXYZ");
    }//GEN-LAST:event_jLabelLeft8MouseClicked

    private void jPanelHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelHelpMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "ABCXYZ");
    }//GEN-LAST:event_jPanelHelpMouseClicked

    private void jLabelSuaThongTinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaThongTinMouseEntered
        // TODO add your handling code here:
        jPanelSuaTT.setBackground(buttonHoverColor);
        jPanelSuaTT.revalidate(); // Cập nhật giao diện
        jPanelSuaTT.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelSuaThongTinMouseEntered

    private void jLabelSuaThongTinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaThongTinMouseExited
        // TODO add your handling code here:
        jPanelSuaTT.setBackground(buttonColor);
        jPanelSuaTT.revalidate(); // Cập nhật giao diện
        jPanelSuaTT.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelSuaThongTinMouseExited

    private void jPanelSuaTTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSuaTTMouseEntered
        // TODO add your handling code here:
        jPanelSuaTT.setBackground(buttonHoverColor);
        jPanelSuaTT.revalidate(); // Cập nhật giao diện
        jPanelSuaTT.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelSuaTTMouseEntered

    private void jLabelDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMatKhauMouseEntered
        // TODO add your handling code here:
        jPanelDoiMK.setBackground(buttonHoverColor);
        jPanelDoiMK.revalidate(); // Cập nhật giao diện
        jPanelDoiMK.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelDoiMatKhauMouseEntered

    private void jLabelDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMatKhauMouseExited
        // TODO add your handling code here:
        jPanelDoiMK.setBackground(buttonColor);
        jPanelDoiMK.revalidate(); // Cập nhật giao diện
        jPanelDoiMK.repaint();    // Vẽ lại giao diện
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
    private java.awt.Choice choiceKhoa1;
    private java.awt.Choice choiceKhoa2;
    private java.awt.Choice choiceKhoa3;
    private java.awt.Choice choiceKhoa4;
    private java.awt.Choice choiceKhoa5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3Dots;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelChon1;
    private javax.swing.JLabel jLabelChon2;
    private javax.swing.JLabel jLabelChon3;
    private javax.swing.JLabel jLabelChon4;
    private javax.swing.JLabel jLabelChon5;
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
    private javax.swing.JLabel jLabelNutSua1;
    private javax.swing.JLabel jLabelNutSua2;
    private javax.swing.JLabel jLabelNutSua3;
    private javax.swing.JLabel jLabelNutSua4;
    private javax.swing.JLabel jLabelNutSua5;
    private javax.swing.JLabel jLabelNutSua6;
    private javax.swing.JLabel jLabelNutThem1;
    private javax.swing.JLabel jLabelNutThem2;
    private javax.swing.JLabel jLabelNutThem3;
    private javax.swing.JLabel jLabelNutThem4;
    private javax.swing.JLabel jLabelNutThem5;
    private javax.swing.JLabel jLabelNutThem6;
    private javax.swing.JLabel jLabelNutTieuDe1;
    private javax.swing.JLabel jLabelNutTieuDe2;
    private javax.swing.JLabel jLabelNutTieuDe3;
    private javax.swing.JLabel jLabelNutTieuDe4;
    private javax.swing.JLabel jLabelNutTieuDe5;
    private javax.swing.JLabel jLabelNutTieuDe6;
    private javax.swing.JLabel jLabelNutXem;
    private javax.swing.JLabel jLabelNutXoa1;
    private javax.swing.JLabel jLabelNutXoa2;
    private javax.swing.JLabel jLabelNutXoa3;
    private javax.swing.JLabel jLabelNutXoa4;
    private javax.swing.JLabel jLabelNutXoa5;
    private javax.swing.JLabel jLabelNutXoa6;
    private javax.swing.JLabel jLabelSinhVien;
    private javax.swing.JLabel jLabelSuaThongTin;
    private javax.swing.JLabel jLabelTaiKhoan;
    private javax.swing.JLabel jLabelTenDangNhap;
    private javax.swing.JLabel jLabelTieuChi;
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
    private javax.swing.JLabel jLabelpanelPtit;
    private javax.swing.JLayeredPane jLayeredPaneMain;
    private javax.swing.JPanel jPanelChoice1;
    private javax.swing.JPanel jPanelChoice2;
    private javax.swing.JPanel jPanelChoice3;
    private javax.swing.JPanel jPanelChoice4;
    private javax.swing.JPanel jPanelCoVan;
    private javax.swing.JPanel jPanelCoVanMain;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelDoiMK;
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
    private javax.swing.JPanel jPanelNutSua1;
    private javax.swing.JPanel jPanelNutSua2;
    private javax.swing.JPanel jPanelNutSua3;
    private javax.swing.JPanel jPanelNutSua4;
    private javax.swing.JPanel jPanelNutSua5;
    private javax.swing.JPanel jPanelNutSua6;
    private javax.swing.JPanel jPanelNutThem1;
    private javax.swing.JPanel jPanelNutThem2;
    private javax.swing.JPanel jPanelNutThem3;
    private javax.swing.JPanel jPanelNutThem4;
    private javax.swing.JPanel jPanelNutThem5;
    private javax.swing.JPanel jPanelNutThem6;
    private javax.swing.JPanel jPanelNutTieuDe1;
    private javax.swing.JPanel jPanelNutTieuDe2;
    private javax.swing.JPanel jPanelNutTieuDe3;
    private javax.swing.JPanel jPanelNutTieuDe4;
    private javax.swing.JPanel jPanelNutTieuDe5;
    private javax.swing.JPanel jPanelNutTieuDe6;
    private javax.swing.JPanel jPanelNutXem;
    private javax.swing.JPanel jPanelNutXoa1;
    private javax.swing.JPanel jPanelNutXoa2;
    private javax.swing.JPanel jPanelNutXoa3;
    private javax.swing.JPanel jPanelNutXoa4;
    private javax.swing.JPanel jPanelNutXoa5;
    private javax.swing.JPanel jPanelNutXoa6;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JPanel jPanelSinhVienMain;
    private javax.swing.JPanel jPanelSuaTT;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JPanel jPanelTaiKhoanMain;
    private javax.swing.JPanel jPanelThanhTieuDe1;
    private javax.swing.JPanel jPanelThanhTieuDe2;
    private javax.swing.JPanel jPanelThanhTieuDe3;
    private javax.swing.JPanel jPanelThanhTieuDe4;
    private javax.swing.JPanel jPanelThanhTieuDe5;
    private javax.swing.JPanel jPanelThanhTieuDe6;
    private javax.swing.JPanel jPanelTieuChi;
    private javax.swing.JPanel jPanelTieuChiMain;
    private javax.swing.JPanel jPanelTitle1;
    private javax.swing.JPanel jPanelTitle2;
    private javax.swing.JPanel jPanelTitleColor;
    private javax.swing.JPanel jPanelTitleColor1;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
