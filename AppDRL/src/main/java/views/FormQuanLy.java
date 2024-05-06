/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;
import icons.Icon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import controller.Controller;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.CoVan;
import models.Khoa;

/**
 *
 * @author Dat
 * 
 * 
 */




public final class FormQuanLy extends javax.swing.JFrame {

/**
     * Creates new form FormSinhVien
     */ private ArrayList <Khoa> dsKhoa = null;
        private ArrayList <CoVan> dsCoVan = null;
        private final static Color textColor = new Color(0, 0, 139);
        private final static Color white = Color.WHITE;
        private final static Color hoveColor = new Color(255,204,102);//màu đậm
        private final static Color hoveColor2 = new Color(255, 228, 181);//màu lợt
        private final Color buttonHoverColor = new Color(30,115,190);
        private final Color buttonColor = new Color(221,51,51);
    // Màu của viền

        // Sử dụng màu này trong ứng dụng của bạn
    
    //Khi chọn vào menu nào thì menu đó có màu vàng còn tất cả còn lại reset màu trắng    
    public void viewMenuClick(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        main.setBackground(hoveColor);
        main.revalidate(); // Cập nhật giao diện
        main.repaint();    // Vẽ lại giao diện
        //updatejadsjkfadkj
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
    // rê vào menu nào thì menu đó có màu vàng lợt, trừ menu được chọn
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
    // rê ra khỏi menu thì menu màu trắng
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
    //Khi click vào đăng xuất thì thoát    
    public void dangXuat(JPanel jpanelLogOut, JLabel jlabelLogOut, JLabel jlabelLeft9, JFrame main, JFrame next){
        jpanelLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thoát không?");
                    if(chon == JOptionPane.YES_OPTION) {
                // Thực hiện hành động khi người dùng chọn "Yes"
                // Ví dụ: thoát chương trình
                    main.setVisible(false);
                    next.setVisible(true);
            }
                
            }
        });
        jlabelLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thoát không?");
                    if(chon == JOptionPane.YES_OPTION) {
                // Thực hiện hành động khi người dùng chọn "Yes"
                // Ví dụ: thoát chương trình
                    main.setVisible(false);
                    next.setVisible(true);
                
                }
            }
        });
        jlabelLeft9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thoát không?");
                    if(chon == JOptionPane.YES_OPTION) {
                // Thực hiện hành động khi người dùng chọn "Yes"
                // Ví dụ: thoát chương trình
                    main.setVisible(false);
                    next.setVisible(true);
                }
            }
        });
    }
    //Các sự kiện của menu
    public void suKienMenu(){
        setLocationRelativeTo(null);
        
        
        //jTableKhoa.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        //Xử lí đăng xuất
        dangXuat(jPanelLogOut, jLabelLogOut,jLabelLeft9, this, new FormDangNhap());
        
        //Xử lý khi rê vào trợ giúp và đăng xuất
        buttonMenuHoverEvent(jLabelHelp, jPanelHelp, jLabelLeft8);
        buttonMenuHoverEvent(jLabelLogOut, jPanelLogOut, jLabelLeft9);
        
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
        buttonHoverEvent(jLabelNutThem6, jPanelNutThem6);
        buttonHoverEvent(jLabelNutThem4, jPanelNutThem4);
        buttonHoverEvent(jLabelNutThem5, jPanelNutThem5);
        buttonHoverEvent(jLabelNutThem, jPanelNutThem);
        buttonHoverEvent(jLabelNutXem, jPanelNutXem);
        buttonHoverEvent(jLabelNutXoa, jPanelNutXoa);
        
        buttonHoverEvent(jLabelNutLienHe, jPanelNutLienHe);
        //nút xóa
        buttonHoverEvent(jLabelNutXoa1, jPanelNutXoa1);
        buttonHoverEvent(jLabelNutXoa2, jPanelNutXoa2);
        buttonHoverEvent(jLabelNutXoa6, jPanelNutXoa6);
        buttonHoverEvent(jLabelNutXoa4, jPanelNutXoa4);
        buttonHoverEvent(jLabelNutXoa5, jPanelNutXoa5);
        //buttonHoverEvent(jLabelNutXoa, jPanelNutXoa);
        
        //nút sửa
        buttonHoverEvent(jLabelNutSua1, jPanelNutSua1);
        buttonHoverEvent(jLabelNutSua2, jPanelNutSua2);
        buttonHoverEvent(jLabelNutSua6, jPanelNutSua6);
        buttonHoverEvent(jLabelNutSua4, jPanelNutSua4);
        buttonHoverEvent(jLabelNutSua5, jPanelNutSua5);
        buttonHoverEvent(jLabelNutSua, jPanelNutSua);
    }
    
    public FormQuanLy() {
        initComponents();
        suKienMenu();
    }
    
    //covan
    public FormQuanLy(ArrayList <Khoa>dsKhoa, ArrayList <CoVan>dsCoVan) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        initComponents();
        suKienMenu();
    }
    
    //Xử lý các sự kiện click
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
    
    //Xử lý khi click vào menu nào thì bảng của menu đó có dữ liệu
    public void addTable(String text){
        if(text.contains("KHOA")){
            Controller.addListKhoaToTable(dsKhoa, jTableKhoa);
        }
        else if (text.contains("CỐ VẤN")){
            Controller.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa);
            Controller.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
        }
    }
    
    //kích vô menu nào hiện màn hình đó
    //jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, PanelXemDiemMain
    public void ClickMenuEvent(JPanel main, JLabel main2, JLabel main3, JPanel main1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7){
        
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7);
                addTable(main2.getText());
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7);
                addTable(main2.getText());
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5, p6, p7);
                addTable(main2.getText());
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
    
    //Xử lý khi rê các nút thêm, xóa sửa, chấm điểm
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
   
    public void buttonMenuHoverEvent(JLabel label, JPanel panel, JLabel icon){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoveColor2);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoveColor2);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(hoveColor2);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(white);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(white);
                panel.revalidate(); // Cập nhật giao diện
                panel.repaint();    // Vẽ lại giao diện
            }
        });
        icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(white);
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
        jLabelThreedots = new javax.swing.JLabel();
        jPanelNull2 = new javax.swing.JPanel();
        jPanelNull3 = new javax.swing.JPanel();
        jLabelThreeDots = new javax.swing.JLabel();
        jPanelHelp = new javax.swing.JPanel();
        jLabelHelp = new javax.swing.JLabel();
        jLabelLeft8 = new javax.swing.JLabel();
        jPanelLogOut = new javax.swing.JPanel();
        jLabelLogOut = new javax.swing.JLabel();
        jLabelLeft9 = new javax.swing.JLabel();
        jPanelPanel = new javax.swing.JPanel();
        jPanelContact = new javax.swing.JPanel();
        jPanelPtit = new javax.swing.JPanel();
        jLabelpanelPtit = new javax.swing.JLabel();
        jPanelNutLienHe = RoundedPanel.createRoundedPanel();
        jLabelNutLienHe = new javax.swing.JLabel();
        jLabelCloud = new javax.swing.JLabel();
        jLabelFb = new javax.swing.JLabel();
        jLayeredPaneMain = new javax.swing.JLayeredPane();
        jPanelHocKyMain = new javax.swing.JPanel();
        jPanelThanhTieuDeKhoa1 = new javax.swing.JPanel();
        jPanelNutTieuDeKhoa1 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa1 = new javax.swing.JLabel();
        jPanelNutXoa2 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa2 = new javax.swing.JLabel();
        jPanelNutSua2 = RoundedPanel.createRoundedPanel();
        jLabelNutSua2 = new javax.swing.JLabel();
        jPanelNutThem2 = RoundedPanel.createRoundedPanel();
        jLabelNutThem2 = new javax.swing.JLabel();
        jPanelKhoaMain = new javax.swing.JPanel();
        jPanelThanhTieuDe = new javax.swing.JPanel();
        jPanelNutTieuDe = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe = new javax.swing.JLabel();
        jPanelNutXoa = RoundedPanel.createRoundedPanel();
        jLabelNutXoa = new javax.swing.JLabel();
        jPanelNutSua = RoundedPanel.createRoundedPanel();
        jLabelNutSua = new javax.swing.JLabel();
        jPanelNutThem = RoundedPanel.createRoundedPanel();
        jLabelNutThem = new javax.swing.JLabel();
        panelBorderTableKhoa = new com.raven.swing.PanelBorder();
        jLabelTableTitleKhoa = new javax.swing.JLabel();
        jScrollPaneKhoa = new javax.swing.JScrollPane();
        jTableKhoa = new com.raven.swing.Table();
        jPanelTieuChiMain = new javax.swing.JPanel();
        jPanelChoice3 = new javax.swing.JPanel();
        jLabelChon3 = new javax.swing.JLabel();
        choiceKhoa3 = new java.awt.Choice();
        jLabel5 = new javax.swing.JLabel();
        jPanelThanhTieuDeKhoa4 = new javax.swing.JPanel();
        jPanelNutTieuDeKhoa4 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa4 = new javax.swing.JLabel();
        jPanelNutXoa1 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa1 = new javax.swing.JLabel();
        jPanelNutSua1 = RoundedPanel.createRoundedPanel();
        jLabelNutSua1 = new javax.swing.JLabel();
        jPanelNutThem1 = RoundedPanel.createRoundedPanel();
        jLabelNutThem1 = new javax.swing.JLabel();
        jPanelCoVanMain = new javax.swing.JPanel();
        jPanelThanhTieuDeKhoa3 = new javax.swing.JPanel();
        jPanelNutTieuDeKhoa3 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa3 = new javax.swing.JLabel();
        jPanelNutXoa5 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa5 = new javax.swing.JLabel();
        jPanelNutSua5 = RoundedPanel.createRoundedPanel();
        jLabelNutSua5 = new javax.swing.JLabel();
        jPanelNutThem5 = RoundedPanel.createRoundedPanel();
        jLabelNutThem5 = new javax.swing.JLabel();
        jPanelTableCoVan = new com.raven.swing.PanelBorder();
        jLabelTableTitleCoVan = new javax.swing.JLabel();
        jScrollPaneCoVan = new javax.swing.JScrollPane();
        jTableCoVan = new com.raven.swing.Table();
        choiceKhoa_CoVan = new java.awt.Choice();
        jLabelChon1 = new javax.swing.JLabel();
        jPanelLopMain = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelChoice2 = new javax.swing.JPanel();
        jLabelChon2 = new javax.swing.JLabel();
        choiceKhoa2 = new java.awt.Choice();
        jLabel9 = new javax.swing.JLabel();
        jPanelThanhTieuDeKhoa2 = new javax.swing.JPanel();
        jPanelNutTieuDeKhoa2 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa2 = new javax.swing.JLabel();
        jPanelNutXoa4 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa4 = new javax.swing.JLabel();
        jPanelNutSua4 = RoundedPanel.createRoundedPanel();
        jLabelNutSua4 = new javax.swing.JLabel();
        jPanelNutThem4 = RoundedPanel.createRoundedPanel();
        jLabelNutThem4 = new javax.swing.JLabel();
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
        jPanelChoice4 = new javax.swing.JPanel();
        jLabelChon4 = new javax.swing.JLabel();
        choiceKhoa4 = new java.awt.Choice();
        jLabelChon5 = new javax.swing.JLabel();
        choiceKhoa5 = new java.awt.Choice();
        jLabel8 = new javax.swing.JLabel();
        jPanelThanhTieuDe2 = new javax.swing.JPanel();
        jPanelNutTieuDe2 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe2 = new javax.swing.JLabel();
        jPanelNutXoa6 = RoundedPanel.createRoundedPanel();
        jLabelNutXoa6 = new javax.swing.JLabel();
        jPanelNutSua6 = RoundedPanel.createRoundedPanel();
        jLabelNutSua6 = new javax.swing.JLabel();
        jPanelNutThem6 = RoundedPanel.createRoundedPanel();
        jLabelNutThem6 = new javax.swing.JLabel();
        jPanelNutXem = RoundedPanel.createRoundedPanel();
        jLabelNutXem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ban quản lý học viện");
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

        jLabelTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTaiKhoan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTaiKhoan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("acc.png")));
        jLabelTaiKhoan.setText("TÀI KHOẢN");

        jLabelLeft1.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabelKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jLabelKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelKhoa.setForeground(new java.awt.Color(227, 70, 34));
        jLabelKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("khoa.png")));
        jLabelKhoa.setText("KHOA");

        jLabelLeft2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
            .addComponent(jLabelLeft2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
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
        jPanelNull1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThreedots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThreedots.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

        javax.swing.GroupLayout jPanelNull1Layout = new javax.swing.GroupLayout(jPanelNull1);
        jPanelNull1.setLayout(jPanelNull1Layout);
        jPanelNull1Layout.setHorizontalGroup(
            jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThreedots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNull1Layout.setVerticalGroup(
            jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNull1Layout.createSequentialGroup()
                .addComponent(jLabelThreedots, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
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
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelNull2);

        jPanelNull3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNull3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThreeDots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThreeDots.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

        javax.swing.GroupLayout jPanelNull3Layout = new javax.swing.GroupLayout(jPanelNull3);
        jPanelNull3.setLayout(jPanelNull3Layout);
        jPanelNull3Layout.setHorizontalGroup(
            jPanelNull3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThreeDots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNull3Layout.setVerticalGroup(
            jPanelNull3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNull3Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(jLabelThreeDots, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMenu.add(jPanelNull3);

        jPanelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHelp.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHelp.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("help.png")));
        jLabelHelp.setText("Trợ giúp");

        jLabelLeft8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft8.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

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
            .addComponent(jLabelLeft8, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHelp);

        jPanelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLogOut.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLogOut.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("logout.png")));
        jLabelLogOut.setText("Thoát");

        jLabelLeft9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft9.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

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
            .addComponent(jLabelLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLabelLeft9, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLogOut);

        jPanelView.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 140, 200, -1));

        jPanelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContact.setBackground(new java.awt.Color(189, 56, 27));
        jPanelContact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPtit.setBackground(new java.awt.Color(255, 255, 255));

        jLabelpanelPtit.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("logoptithcm.png")));
        jLabelpanelPtit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelNutLienHe.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutLienHe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutLienHe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutLienHe.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("mail2.png")));
        jLabelNutLienHe.setText("Liên hệ với chúng tôi");
        jLabelNutLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutLienHe.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutLienHeLayout = new javax.swing.GroupLayout(jPanelNutLienHe);
        jPanelNutLienHe.setLayout(jPanelNutLienHeLayout);
        jPanelNutLienHeLayout.setHorizontalGroup(
            jPanelNutLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutLienHeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNutLienHeLayout.setVerticalGroup(
            jPanelNutLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPtitLayout = new javax.swing.GroupLayout(jPanelPtit);
        jPanelPtit.setLayout(jPanelPtitLayout);
        jPanelPtitLayout.setHorizontalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jPanelNutLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanelPtitLayout.setVerticalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanelNutLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

jPanelThanhTieuDeKhoa1.setPreferredSize(new java.awt.Dimension(770, 34));

jPanelNutTieuDeKhoa1.setBackground(new java.awt.Color(221, 51, 51));

jLabelNutTieuDeKhoa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabelNutTieuDeKhoa1.setForeground(new java.awt.Color(255, 255, 255));
jLabelNutTieuDeKhoa1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitecalender.png")));
jLabelNutTieuDeKhoa1.setText("Học kỳ");
jLabelNutTieuDeKhoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
jLabelNutTieuDeKhoa1.setPreferredSize(new java.awt.Dimension(32, 16));

javax.swing.GroupLayout jPanelNutTieuDeKhoa1Layout = new javax.swing.GroupLayout(jPanelNutTieuDeKhoa1);
jPanelNutTieuDeKhoa1.setLayout(jPanelNutTieuDeKhoa1Layout);
jPanelNutTieuDeKhoa1Layout.setHorizontalGroup(
    jPanelNutTieuDeKhoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanelNutTieuDeKhoa1Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabelNutTieuDeKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeKhoa1Layout.setVerticalGroup(
        jPanelNutTieuDeKhoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeKhoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addComponent(jLabelNutXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoa2Layout.setVerticalGroup(
        jPanelNutXoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addGap(0, 9, Short.MAX_VALUE)
            .addComponent(jLabelNutSua2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutSua2Layout.setVerticalGroup(
        jPanelNutSua2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThem2.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem2.setText("Thêm");
    jLabelNutThem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem2.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutThem2Layout = new javax.swing.GroupLayout(jPanelNutThem2);
    jPanelNutThem2.setLayout(jPanelNutThem2Layout);
    jPanelNutThem2Layout.setHorizontalGroup(
        jPanelNutThem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThem2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
    );
    jPanelNutThem2Layout.setVerticalGroup(
        jPanelNutThem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeKhoa1Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeKhoa1);
    jPanelThanhTieuDeKhoa1.setLayout(jPanelThanhTieuDeKhoa1Layout);
    jPanelThanhTieuDeKhoa1Layout.setHorizontalGroup(
        jPanelThanhTieuDeKhoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeKhoa1Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeKhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
            .addComponent(jPanelNutThem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeKhoa1Layout.setVerticalGroup(
        jPanelThanhTieuDeKhoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeKhoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelHocKyMain.add(jPanelThanhTieuDeKhoa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLayeredPaneMain.add(jPanelHocKyMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelKhoaMain.setPreferredSize(new java.awt.Dimension(621, 436));
    jPanelKhoaMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDe.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteschool.png")));
    jLabelNutTieuDe.setText("Khoa");
    jLabelNutTieuDe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeLayout = new javax.swing.GroupLayout(jPanelNutTieuDe);
    jPanelNutTieuDe.setLayout(jPanelNutTieuDeLayout);
    jPanelNutTieuDeLayout.setHorizontalGroup(
        jPanelNutTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
    );
    jPanelNutTieuDeLayout.setVerticalGroup(
        jPanelNutTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoa.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa.setText("Xóa");
    jLabelNutXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutXoa.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutXoaMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutXoaLayout = new javax.swing.GroupLayout(jPanelNutXoa);
    jPanelNutXoa.setLayout(jPanelNutXoaLayout);
    jPanelNutXoaLayout.setHorizontalGroup(
        jPanelNutXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoaLayout.setVerticalGroup(
        jPanelNutXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua.setText("Sửa");
    jLabelNutSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutSua.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutSuaMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutSuaLayout = new javax.swing.GroupLayout(jPanelNutSua);
    jPanelNutSua.setLayout(jPanelNutSuaLayout);
    jPanelNutSuaLayout.setHorizontalGroup(
        jPanelNutSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaLayout.createSequentialGroup()
            .addGap(0, 9, Short.MAX_VALUE)
            .addComponent(jLabelNutSua, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutSuaLayout.setVerticalGroup(
        jPanelNutSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThem.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem.setText("Thêm");
    jLabelNutThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThem.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThemMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThemLayout = new javax.swing.GroupLayout(jPanelNutThem);
    jPanelNutThem.setLayout(jPanelNutThemLayout);
    jPanelNutThemLayout.setHorizontalGroup(
        jPanelNutThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThem, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
    );
    jPanelNutThemLayout.setVerticalGroup(
        jPanelNutThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeLayout = new javax.swing.GroupLayout(jPanelThanhTieuDe);
    jPanelThanhTieuDe.setLayout(jPanelThanhTieuDeLayout);
    jPanelThanhTieuDeLayout.setHorizontalGroup(
        jPanelThanhTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeLayout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
            .addComponent(jPanelNutThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeLayout.setVerticalGroup(
        jPanelThanhTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelKhoaMain.add(jPanelThanhTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    panelBorderTableKhoa.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTableTitleKhoa.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTableTitleKhoa.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTableTitleKhoa.setText("Danh sách các khoa");

    jScrollPaneKhoa.setBorder(null);

    jTableKhoa.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Mã khoa", "Tên khoa", "Ngày thành lập", "Tên đăng nhập", "Mật khẩu"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTableKhoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    jTableKhoa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPaneKhoa.setViewportView(jTableKhoa);

    javax.swing.GroupLayout panelBorderTableKhoaLayout = new javax.swing.GroupLayout(panelBorderTableKhoa);
    panelBorderTableKhoa.setLayout(panelBorderTableKhoaLayout);
    panelBorderTableKhoaLayout.setHorizontalGroup(
        panelBorderTableKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorderTableKhoaLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(panelBorderTableKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelTableTitleKhoa))
            .addContainerGap(17, Short.MAX_VALUE))
    );
    panelBorderTableKhoaLayout.setVerticalGroup(
        panelBorderTableKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelBorderTableKhoaLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(jLabelTableTitleKhoa)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPaneKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(16, Short.MAX_VALUE))
    );

    jPanelKhoaMain.add(panelBorderTableKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 760, 540));

    jLayeredPaneMain.add(jPanelKhoaMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelTieuChiMain.setBackground(new java.awt.Color(255, 255, 255));
    jPanelTieuChiMain.setPreferredSize(new java.awt.Dimension(790, 620));
    jPanelTieuChiMain.setRequestFocusEnabled(false);
    jPanelTieuChiMain.setVerifyInputWhenFocusTarget(false);
    jPanelTieuChiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

    jPanelThanhTieuDeKhoa4.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeKhoa4.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeKhoa4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeKhoa4.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeKhoa4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitetieuchi.png")));
    jLabelNutTieuDeKhoa4.setText("Tiêu chí");
    jLabelNutTieuDeKhoa4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeKhoa4.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeKhoa4Layout = new javax.swing.GroupLayout(jPanelNutTieuDeKhoa4);
    jPanelNutTieuDeKhoa4.setLayout(jPanelNutTieuDeKhoa4Layout);
    jPanelNutTieuDeKhoa4Layout.setHorizontalGroup(
        jPanelNutTieuDeKhoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDeKhoa4Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDeKhoa4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeKhoa4Layout.setVerticalGroup(
        jPanelNutTieuDeKhoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeKhoa4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addComponent(jLabelNutXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoa1Layout.setVerticalGroup(
        jPanelNutXoa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addGap(0, 9, Short.MAX_VALUE)
            .addComponent(jLabelNutSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutSua1Layout.setVerticalGroup(
        jPanelNutSua1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThem1.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem1.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem1.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem1.setText("Thêm");
    jLabelNutThem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem1.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutThem1Layout = new javax.swing.GroupLayout(jPanelNutThem1);
    jPanelNutThem1.setLayout(jPanelNutThem1Layout);
    jPanelNutThem1Layout.setHorizontalGroup(
        jPanelNutThem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThem1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
    );
    jPanelNutThem1Layout.setVerticalGroup(
        jPanelNutThem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeKhoa4Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeKhoa4);
    jPanelThanhTieuDeKhoa4.setLayout(jPanelThanhTieuDeKhoa4Layout);
    jPanelThanhTieuDeKhoa4Layout.setHorizontalGroup(
        jPanelThanhTieuDeKhoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeKhoa4Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeKhoa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
            .addComponent(jPanelNutThem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeKhoa4Layout.setVerticalGroup(
        jPanelThanhTieuDeKhoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeKhoa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelTieuChiMain.add(jPanelThanhTieuDeKhoa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLayeredPaneMain.add(jPanelTieuChiMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelCoVanMain.setPreferredSize(new java.awt.Dimension(645, 461));
    jPanelCoVanMain.setRequestFocusEnabled(false);
    jPanelCoVanMain.setVerifyInputWhenFocusTarget(false);
    jPanelCoVanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDeKhoa3.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeKhoa3.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeKhoa3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeKhoa3.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeKhoa3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteteacher.png")));
    jLabelNutTieuDeKhoa3.setText("Cố vấn");
    jLabelNutTieuDeKhoa3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeKhoa3.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeKhoa3Layout = new javax.swing.GroupLayout(jPanelNutTieuDeKhoa3);
    jPanelNutTieuDeKhoa3.setLayout(jPanelNutTieuDeKhoa3Layout);
    jPanelNutTieuDeKhoa3Layout.setHorizontalGroup(
        jPanelNutTieuDeKhoa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDeKhoa3Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDeKhoa3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeKhoa3Layout.setVerticalGroup(
        jPanelNutTieuDeKhoa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeKhoa3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoa5.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoa5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa5.setText("Xóa");
    jLabelNutXoa5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa5.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutXoa5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutXoa5MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutXoa5Layout = new javax.swing.GroupLayout(jPanelNutXoa5);
    jPanelNutXoa5.setLayout(jPanelNutXoa5Layout);
    jPanelNutXoa5Layout.setHorizontalGroup(
        jPanelNutXoa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoa5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoa5, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoa5Layout.setVerticalGroup(
        jPanelNutXoa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSua5.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSua5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutSua5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSua5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSua5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSua5.setText("Sửa");
    jLabelNutSua5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSua5.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutSua5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutSua5MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutSua5Layout = new javax.swing.GroupLayout(jPanelNutSua5);
    jPanelNutSua5.setLayout(jPanelNutSua5Layout);
    jPanelNutSua5Layout.setHorizontalGroup(
        jPanelNutSua5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSua5Layout.createSequentialGroup()
            .addGap(0, 9, Short.MAX_VALUE)
            .addComponent(jLabelNutSua5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutSua5Layout.setVerticalGroup(
        jPanelNutSua5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThem5.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThem5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem5.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem5.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem5.setText("Thêm");
    jLabelNutThem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem5.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThem5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThem5MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThem5Layout = new javax.swing.GroupLayout(jPanelNutThem5);
    jPanelNutThem5.setLayout(jPanelNutThem5Layout);
    jPanelNutThem5Layout.setHorizontalGroup(
        jPanelNutThem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThem5, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
    );
    jPanelNutThem5Layout.setVerticalGroup(
        jPanelNutThem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeKhoa3Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeKhoa3);
    jPanelThanhTieuDeKhoa3.setLayout(jPanelThanhTieuDeKhoa3Layout);
    jPanelThanhTieuDeKhoa3Layout.setHorizontalGroup(
        jPanelThanhTieuDeKhoa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeKhoa3Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeKhoa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
            .addComponent(jPanelNutThem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeKhoa3Layout.setVerticalGroup(
        jPanelThanhTieuDeKhoa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeKhoa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelCoVanMain.add(jPanelThanhTieuDeKhoa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelTableCoVan.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTableTitleCoVan.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTableTitleCoVan.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTableTitleCoVan.setText("Danh sách các cố vấn");

    jScrollPaneCoVan.setBorder(null);

    jTableCoVan.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Mã cố vấn", "Tên cố vấn", "Email", "Khoa", "Mật khẩu"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTableCoVan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    jTableCoVan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPaneCoVan.setViewportView(jTableCoVan);

    choiceKhoa_CoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa_CoVan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
    choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            choiceKhoa_CoVanItemStateChanged(evt);
        }
    });

    jLabelChon1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChon1.setText("Chọn khoa:");

    javax.swing.GroupLayout jPanelTableCoVanLayout = new javax.swing.GroupLayout(jPanelTableCoVan);
    jPanelTableCoVan.setLayout(jPanelTableCoVanLayout);
    jPanelTableCoVanLayout.setHorizontalGroup(
        jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTableCoVanLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPaneCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelTableCoVanLayout.createSequentialGroup()
                    .addComponent(jLabelTableTitleCoVan)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelChon1)
                    .addGap(2, 2, 2)
                    .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(17, Short.MAX_VALUE))
    );
    jPanelTableCoVanLayout.setVerticalGroup(
        jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTableCoVanLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(jPanelTableCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabelTableTitleCoVan)
                .addComponent(choiceKhoa_CoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelChon1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPaneCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanelCoVanMain.add(jPanelTableCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 540));

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

    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("(Bảng danh sách các sinh viên thuộc khoa, thuộc lớp kỳ được chọn)");
    jPanelLopMain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 764, 420));

    jPanelThanhTieuDeKhoa2.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeKhoa2.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeKhoa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeKhoa2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeKhoa2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteclass.png")));
    jLabelNutTieuDeKhoa2.setText("Lớp");
    jLabelNutTieuDeKhoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeKhoa2.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeKhoa2Layout = new javax.swing.GroupLayout(jPanelNutTieuDeKhoa2);
    jPanelNutTieuDeKhoa2.setLayout(jPanelNutTieuDeKhoa2Layout);
    jPanelNutTieuDeKhoa2Layout.setHorizontalGroup(
        jPanelNutTieuDeKhoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDeKhoa2Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeKhoa2Layout.setVerticalGroup(
        jPanelNutTieuDeKhoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addComponent(jLabelNutXoa4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoa4Layout.setVerticalGroup(
        jPanelNutXoa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addGap(0, 9, Short.MAX_VALUE)
            .addComponent(jLabelNutSua4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutSua4Layout.setVerticalGroup(
        jPanelNutSua4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThem4.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThem4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem4.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem4.setText("Thêm");
    jLabelNutThem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem4.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutThem4Layout = new javax.swing.GroupLayout(jPanelNutThem4);
    jPanelNutThem4.setLayout(jPanelNutThem4Layout);
    jPanelNutThem4Layout.setHorizontalGroup(
        jPanelNutThem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThem4, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
    );
    jPanelNutThem4Layout.setVerticalGroup(
        jPanelNutThem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThem4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeKhoa2Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeKhoa2);
    jPanelThanhTieuDeKhoa2.setLayout(jPanelThanhTieuDeKhoa2Layout);
    jPanelThanhTieuDeKhoa2Layout.setHorizontalGroup(
        jPanelThanhTieuDeKhoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeKhoa2Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
            .addComponent(jPanelNutThem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeKhoa2Layout.setVerticalGroup(
        jPanelThanhTieuDeKhoa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelLopMain.add(jPanelThanhTieuDeKhoa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

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

    jPanelThanhTieuDe2.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDe2.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDe2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDe2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDe2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteclass.png")));
    jLabelNutTieuDe2.setText("Danh sách sinh viên");
    jLabelNutTieuDe2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDe2.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDe2Layout = new javax.swing.GroupLayout(jPanelNutTieuDe2);
    jPanelNutTieuDe2.setLayout(jPanelNutTieuDe2Layout);
    jPanelNutTieuDe2Layout.setHorizontalGroup(
        jPanelNutTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDe2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
    );
    jPanelNutTieuDe2Layout.setVerticalGroup(
        jPanelNutTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addComponent(jLabelNutXoa6, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoa6Layout.setVerticalGroup(
        jPanelNutXoa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoa6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addGap(0, 9, Short.MAX_VALUE)
            .addComponent(jLabelNutSua6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelNutSua6Layout.setVerticalGroup(
        jPanelNutSua6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSua6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThem6.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThem6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThem6.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThem6.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThem6.setText("Thêm");
    jLabelNutThem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThem6.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutThem6Layout = new javax.swing.GroupLayout(jPanelNutThem6);
    jPanelNutThem6.setLayout(jPanelNutThem6Layout);
    jPanelNutThem6Layout.setHorizontalGroup(
        jPanelNutThem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThem6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThem6, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
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
    jLabelNutXem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXem.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutXemLayout = new javax.swing.GroupLayout(jPanelNutXem);
    jPanelNutXem.setLayout(jPanelNutXemLayout);
    jPanelNutXemLayout.setHorizontalGroup(
        jPanelNutXemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXemLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXem, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
    );
    jPanelNutXemLayout.setVerticalGroup(
        jPanelNutXemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXem, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDe2Layout = new javax.swing.GroupLayout(jPanelThanhTieuDe2);
    jPanelThanhTieuDe2.setLayout(jPanelThanhTieuDe2Layout);
    jPanelThanhTieuDe2Layout.setHorizontalGroup(
        jPanelThanhTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDe2Layout.createSequentialGroup()
            .addComponent(jPanelNutTieuDe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
            .addComponent(jPanelNutXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutThem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe2Layout.setVerticalGroup(
        jPanelThanhTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelSinhVienMain.add(jPanelThanhTieuDe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jLayeredPaneMain.add(jPanelSinhVienMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelView.add(jLayeredPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 784, -1));

    getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 748));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    


    

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

    private void jLabelNutXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTableKhoa.getSelectedRow();
        
        // Kiểm tra xem có hàng nào được chọn không
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
        }
        else {
            // Xóa hàng được chọn từ bảng
            int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?");
            if(chon == JOptionPane.YES_OPTION){
                String maKhoa = dsKhoa.get(selectedRow).getMaKhoa();
                DefaultTableModel model = (DefaultTableModel) jTableKhoa.getModel();
                model.removeRow(selectedRow);
                dsKhoa.remove(selectedRow);
                // Cập nhật dữ liệu trong cơ sở dữ liệu (nếu cần)
                try {
                    try ( // Tạo kết nối tới cơ sở dữ liệu và thực hiện các thao tác cần thiết để xóa dữ liệu từ cơ sở dữ liệu.
                    // Ví dụ: Xóa dữ liệu từ bảng SQL.
                        Connection conn = Controller.getConnection()) {
                        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Khoa WHERE MaKhoa = ?");
                        pstmt.setString(1, maKhoa);
                        pstmt.executeUpdate();
                    }
                } catch (SQLException ex) {
                    // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
                    //ex.printStackTrace();
                }
                } else {
                    // Nếu không có hàng nào được chọn, bạn có thể thông báo cho người dùng hoặc xử lý theo cách mong muốn.
                }
        }
    }//GEN-LAST:event_jLabelNutXoaMouseClicked

    private void jLabelNutSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaMouseClicked
        // TODO add your handling code here:
        int chon = jTableKhoa.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            new SuaKhoa(dsKhoa, jTableKhoa, chon).setVisible(true);
        }
    }//GEN-LAST:event_jLabelNutSuaMouseClicked

    private void jLabelNutThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemMouseClicked
        // TODO add your handling code here:
        new ThemKhoa(dsKhoa, jTableKhoa).setVisible(true);
    }//GEN-LAST:event_jLabelNutThemMouseClicked

    private void choiceKhoa_CoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_CoVanItemStateChanged
        // TODO add your handling code here:
        String maKhoa = Controller.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa);
        if(maKhoa.equals("")){
            Controller.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa);
        }
        else{
            Controller.addListCoVanToTable_MaKhoa(dsCoVan, jTableCoVan, dsKhoa, maKhoa);
        }
        
    }//GEN-LAST:event_choiceKhoa_CoVanItemStateChanged

    private void jLabelNutSua5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSua5MouseClicked
        // TODO add your handling code here:
        int chon = jTableCoVan.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            new SuaCoVan(dsKhoa, jTableCoVan, chon, dsCoVan, choiceKhoa_CoVan).setVisible(true);
        }
    }//GEN-LAST:event_jLabelNutSua5MouseClicked

    private void jLabelNutXoa5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoa5MouseClicked
        int selectedRow = jTableCoVan.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
        }
        else {
            // Xóa hàng được chọn từ bảng
            int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?");
            if(chon == JOptionPane.YES_OPTION){
                Object cellValue = jTableCoVan.getValueAt(selectedRow, 0); // Lấy dữ liệu từ cột MaCV
                String maCoVan = cellValue.toString().trim();
                System.out.println(maCoVan);
                int hub = 0;
                for(int i=0; i<dsCoVan.size(); i++){
                    if(dsCoVan.get(i).getMaCV().equals(maCoVan)){
                        hub = i;
                        break;
                    }
                }
                //System.out.println(hub);
                // Xóa cố vấn khỏi danh sách dsCoVan
                dsCoVan.remove(hub);

                // Xóa hàng từ bảng
                DefaultTableModel model = (DefaultTableModel) jTableCoVan.getModel();
                model.removeRow(selectedRow);

                // Cập nhật dữ liệu trong cơ sở dữ liệu (nếu cần)
                try {
                    // Tạo kết nối tới cơ sở dữ liệu và thực hiện các thao tác cần thiết để xóa dữ liệu từ cơ sở dữ liệu.
                    // Ví dụ: Xóa dữ liệu từ bảng SQL.
                    try (Connection con = Controller.getConnection()) {
                        PreparedStatement pstmt = con.prepareStatement("DELETE FROM CoVan WHERE MaCoVan = ?");
                        pstmt.setString(1, maCoVan);
                        //System.out.println(maCoVan);
                        pstmt.executeUpdate();
                        PreparedStatement pstmt2 = con.prepareStatement("DELETE FROM TaiKhoan WHERE TenTK = ?");
                        pstmt2.setString(1, maCoVan);
                        //System.out.println(maCoVan);
                        pstmt2.executeUpdate();
                    }
                } catch (SQLException ex) {
                    // Xử lý ngoại lệ nếu có lỗi xảy ra khi thực hiện truy vấn SQL
                    //ex.printStackTrace();
                }
            } else {
                // Nếu không xác nhận xóa, bạn có thể xử lý tùy ý ở đây
            }
        }
    }//GEN-LAST:event_jLabelNutXoa5MouseClicked

    private void jLabelNutThem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThem5MouseClicked
        // TODO add your handling code here:
        new ThemCoVan(dsKhoa, jTableCoVan,  dsCoVan, choiceKhoa_CoVan).setVisible(true);
    }//GEN-LAST:event_jLabelNutThem5MouseClicked

    

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
    private java.awt.Choice choiceKhoa2;
    private java.awt.Choice choiceKhoa3;
    private java.awt.Choice choiceKhoa4;
    private java.awt.Choice choiceKhoa5;
    private java.awt.Choice choiceKhoa_CoVan;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLop;
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
    private javax.swing.JLabel jLabelNutLienHe;
    private javax.swing.JLabel jLabelNutSua;
    private javax.swing.JLabel jLabelNutSua1;
    private javax.swing.JLabel jLabelNutSua2;
    private javax.swing.JLabel jLabelNutSua4;
    private javax.swing.JLabel jLabelNutSua5;
    private javax.swing.JLabel jLabelNutSua6;
    private javax.swing.JLabel jLabelNutThem;
    private javax.swing.JLabel jLabelNutThem1;
    private javax.swing.JLabel jLabelNutThem2;
    private javax.swing.JLabel jLabelNutThem4;
    private javax.swing.JLabel jLabelNutThem5;
    private javax.swing.JLabel jLabelNutThem6;
    private javax.swing.JLabel jLabelNutTieuDe;
    private javax.swing.JLabel jLabelNutTieuDe2;
    private javax.swing.JLabel jLabelNutTieuDeKhoa1;
    private javax.swing.JLabel jLabelNutTieuDeKhoa2;
    private javax.swing.JLabel jLabelNutTieuDeKhoa3;
    private javax.swing.JLabel jLabelNutTieuDeKhoa4;
    private javax.swing.JLabel jLabelNutXem;
    private javax.swing.JLabel jLabelNutXoa;
    private javax.swing.JLabel jLabelNutXoa1;
    private javax.swing.JLabel jLabelNutXoa2;
    private javax.swing.JLabel jLabelNutXoa4;
    private javax.swing.JLabel jLabelNutXoa5;
    private javax.swing.JLabel jLabelNutXoa6;
    private javax.swing.JLabel jLabelSinhVien;
    private javax.swing.JLabel jLabelSuaThongTin;
    private javax.swing.JLabel jLabelTableTitleCoVan;
    private javax.swing.JLabel jLabelTableTitleKhoa;
    private javax.swing.JLabel jLabelTaiKhoan;
    private javax.swing.JLabel jLabelTenDangNhap;
    private javax.swing.JLabel jLabelThreeDots;
    private javax.swing.JLabel jLabelThreedots;
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
    private javax.swing.JPanel jPanelLogOut;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNull1;
    private javax.swing.JPanel jPanelNull2;
    private javax.swing.JPanel jPanelNull3;
    private javax.swing.JPanel jPanelNutLienHe;
    private javax.swing.JPanel jPanelNutSua;
    private javax.swing.JPanel jPanelNutSua1;
    private javax.swing.JPanel jPanelNutSua2;
    private javax.swing.JPanel jPanelNutSua4;
    private javax.swing.JPanel jPanelNutSua5;
    private javax.swing.JPanel jPanelNutSua6;
    private javax.swing.JPanel jPanelNutThem;
    private javax.swing.JPanel jPanelNutThem1;
    private javax.swing.JPanel jPanelNutThem2;
    private javax.swing.JPanel jPanelNutThem4;
    private javax.swing.JPanel jPanelNutThem5;
    private javax.swing.JPanel jPanelNutThem6;
    private javax.swing.JPanel jPanelNutTieuDe;
    private javax.swing.JPanel jPanelNutTieuDe2;
    private javax.swing.JPanel jPanelNutTieuDeKhoa1;
    private javax.swing.JPanel jPanelNutTieuDeKhoa2;
    private javax.swing.JPanel jPanelNutTieuDeKhoa3;
    private javax.swing.JPanel jPanelNutTieuDeKhoa4;
    private javax.swing.JPanel jPanelNutXem;
    private javax.swing.JPanel jPanelNutXoa;
    private javax.swing.JPanel jPanelNutXoa1;
    private javax.swing.JPanel jPanelNutXoa2;
    private javax.swing.JPanel jPanelNutXoa4;
    private javax.swing.JPanel jPanelNutXoa5;
    private javax.swing.JPanel jPanelNutXoa6;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JPanel jPanelSinhVienMain;
    private javax.swing.JPanel jPanelSuaTT;
    private com.raven.swing.PanelBorder jPanelTableCoVan;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JPanel jPanelTaiKhoanMain;
    private javax.swing.JPanel jPanelThanhTieuDe;
    private javax.swing.JPanel jPanelThanhTieuDe2;
    private javax.swing.JPanel jPanelThanhTieuDeKhoa1;
    private javax.swing.JPanel jPanelThanhTieuDeKhoa2;
    private javax.swing.JPanel jPanelThanhTieuDeKhoa3;
    private javax.swing.JPanel jPanelThanhTieuDeKhoa4;
    private javax.swing.JPanel jPanelTieuChi;
    private javax.swing.JPanel jPanelTieuChiMain;
    private javax.swing.JPanel jPanelTitle1;
    private javax.swing.JPanel jPanelTitle2;
    private javax.swing.JPanel jPanelTitleColor;
    private javax.swing.JPanel jPanelTitleColor1;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPaneCoVan;
    private javax.swing.JScrollPane jScrollPaneKhoa;
    private com.raven.swing.Table jTableCoVan;
    private com.raven.swing.Table jTableKhoa;
    private com.raven.swing.PanelBorder panelBorderTableKhoa;
    // End of variables declaration//GEN-END:variables



    // Thiết lập renderer cho tất cả các cột trong JTable
    // Tạo một renderer mới
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Lấy Component mặc định của ô
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Thiết lập thụt vào đầu dòng
            ((JLabel) cellComponent).setBorder(new EmptyBorder(0, 100, 0, 0)); // Đặt thụt vào đầu dòng là 10px
            return cellComponent;
        }
    };
    

    
}
