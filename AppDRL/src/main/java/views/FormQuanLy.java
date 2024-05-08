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
import com.raven.swing.ScrollBar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.CoVan;
import models.HocKy;
import models.Khoa;
import models.KhoaHoc;
import models.Lop;
import models.TaiKhoan;
import models.TieuChi;

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
        private ArrayList <HocKy> dsHocKy = null;
        private ArrayList <KhoaHoc> dsKhoaHoc = null;
        private ArrayList <Lop> dsLop = null;
        private ArrayList <TaiKhoan> dsTaiKhoan = null;
        private ArrayList <TieuChi> dsTieuChi = null;
        //private final static Color textColor = new Color(0, 0, 139);
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
        buttonHoverEvent(jLabelNutThemTieuChi, jPanelNutThemTieuChi);
        buttonHoverEvent(jLabelNutThemKhoaHoc, jPanelNutThemKhoaHoc);
        buttonHoverEvent(jLabelNutThem6, jPanelNutThem6);
        buttonHoverEvent(jLabelNutThemLop, jPanelNutThemLop);
        buttonHoverEvent(jLabelNutThemCoVan, jPanelNutThemCoVan);
        buttonHoverEvent(jLabelNutThemKhoa, jPanelNutThemKhoa);
        buttonHoverEvent(jLabelNutXem, jPanelNutXem);
        buttonHoverEvent(jLabelNutXoaKhoa, jPanelNutXoaKhoa);
        
        buttonHoverEvent(jLabelNutLienHe, jPanelNutLienHe);
        //nút xóa
        buttonHoverEvent(jLabelNutXoaTieuChi, jPanelNutXoaTieuChi);
        buttonHoverEvent(jLabelNutThemHK, jPanelNutThemHK);
        buttonHoverEvent(jLabelNutXoa6, jPanelNutXoa6);
        buttonHoverEvent(jLabelNutXoaLop, jPanelNutXoaLop);
        buttonHoverEvent(jLabelNutXoaCoVan, jPanelNutXoaCoVan);
        //buttonHoverEvent(jLabelNutXoa, jPanelNutXoa);
        
        //nút sửa
        buttonHoverEvent(jLabelNutSuaTieuChi, jPanelNutSuaTieuChi);
        buttonHoverEvent(jLabelNutDoiTT, jPanelNutDoiTT);
        buttonHoverEvent(jLabelNutSua6, jPanelNutSua6);
        buttonHoverEvent(jLabelNutSuaLop, jPanelNutSuaLop);
        buttonHoverEvent(jLabelNutSuaCoVan, jPanelNutSuaCoVan);
        buttonHoverEvent(jLabelNutSuaKhoa, jPanelNutSuaKhoa);
    }
    
    public FormQuanLy() {
        initComponents();
        suKienMenu();
    }
    
    //covan
    public FormQuanLy(ArrayList<TaiKhoan> dsTaiKhoan, ArrayList <Khoa>dsKhoa, ArrayList <CoVan>dsCoVan, ArrayList<HocKy>dsHocKy, ArrayList<KhoaHoc>dsKhoaHoc, ArrayList<Lop> dsLop, ArrayList<TieuChi> dsTieuChi) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsHocKy = dsHocKy;
        this.dsKhoaHoc = dsKhoaHoc;
        this.dsLop = dsLop;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsTieuChi = dsTieuChi;
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
            Controller.addListKhoaToTable(dsKhoa, jTableKhoa, dsTaiKhoan);
        }
        else if (text.contains("CỐ VẤN")){
            Controller.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa);
            Controller.addChoiceKhoa(choiceKhoa_CoVan, dsKhoa);
        }
        else if(text.contains("HỌC KỲ")){
            Controller.addListHocKyToTable(dsHocKy, jTableHocKy);
            Controller.addListKhoaHocToTable(dsKhoaHoc, jTableKhoaHoc);
        }
        else if(text.contains("LỚP")){
            Controller.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
            Controller.addChoiceKhoa(choiceKhoa_Lop, dsKhoa);
        }
        else if(text.contains("TIÊU CHÍ")){
            Controller.addListTieuChiToTable(dsTieuChi, jTableTieuChi);
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
        jPanelThanhTieuDeHK = RoundedPanel.createRoundedPanel();
        jPanelNutTieuDeHK = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeHK = new javax.swing.JLabel();
        jPanelBorderHocKy = new com.raven.swing.PanelBorder();
        jLabelTitleHocKy = new javax.swing.JLabel();
        jScrollPaneHocKy = new javax.swing.JScrollPane();
        jTableHocKy = new com.raven.swing.TableHocKy();
        jPanelNutThemHK = RoundedPanel.createRoundedPanel();
        jLabelNutThemHK = new javax.swing.JLabel();
        jPanelNutDoiTT = RoundedPanel.createRoundedPanel();
        jLabelNutDoiTT = new javax.swing.JLabel();
        jPanelBorderKhoaHoc = new com.raven.swing.PanelBorder();
        jLabelTitleKhoaHoc = new javax.swing.JLabel();
        jScrollPaneKhoaHoc = new javax.swing.JScrollPane();
        jTableKhoaHoc = new com.raven.swing.TableKhoaHoc();
        jPanelNutThemKhoaHoc = RoundedPanel.createRoundedPanel();
        jLabelNutThemKhoaHoc = new javax.swing.JLabel();
        jPanelKhoaMain = new javax.swing.JPanel();
        jPanelThanhTieuDeKhoa = new javax.swing.JPanel();
        jPanelNutTieuDeKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa = new javax.swing.JLabel();
        jPanelNutXoaKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutXoaKhoa = new javax.swing.JLabel();
        jPanelNutSuaKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutSuaKhoa = new javax.swing.JLabel();
        jPanelNutThemKhoa = RoundedPanel.createRoundedPanel();
        jLabelNutThemKhoa = new javax.swing.JLabel();
        panelBorderTableKhoa = new com.raven.swing.PanelBorder();
        jLabelTableTitleKhoa = new javax.swing.JLabel();
        jScrollPaneKhoa = new javax.swing.JScrollPane();
        jTableKhoa = new com.raven.swing.TableKhoa();
        jPanelTieuChiMain = new javax.swing.JPanel();
        jPanelThanhTieuDeTieuChi = new javax.swing.JPanel();
        jPanelNutTieuDeTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTieuChi = new javax.swing.JLabel();
        jPanelNutXoaTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutXoaTieuChi = new javax.swing.JLabel();
        jPanelNutSuaTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutSuaTieuChi = new javax.swing.JLabel();
        jPanelNutThemTieuChi = RoundedPanel.createRoundedPanel();
        jLabelNutThemTieuChi = new javax.swing.JLabel();
        jPanelBorderTieuChi = new com.raven.swing.PanelBorder();
        jLabelTitleTieuChi = new javax.swing.JLabel();
        jScrollPaneTieuChi = new javax.swing.JScrollPane();
        jTableTieuChi = new com.raven.swing.TableTieuChi();
        jPanelNutChiTietTC = RoundedPanel.createRoundedPanel();
        jLabelNutChiTietTC = new javax.swing.JLabel();
        jPanelCoVanMain = new javax.swing.JPanel();
        jPanelThanhTieuDeCoVan = new javax.swing.JPanel();
        jPanelNutTieuDeCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeCoVan = new javax.swing.JLabel();
        jPanelNutXoaCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutXoaCoVan = new javax.swing.JLabel();
        jPanelNutSuaCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutSuaCoVan = new javax.swing.JLabel();
        jPanelNutThemCoVan = RoundedPanel.createRoundedPanel();
        jLabelNutThemCoVan = new javax.swing.JLabel();
        jPanelTableCoVan = new com.raven.swing.PanelBorder();
        jLabelTableTitleCoVan = new javax.swing.JLabel();
        jScrollPaneCoVan = new javax.swing.JScrollPane();
        jTableCoVan = new com.raven.swing.TableCoVan();
        choiceKhoa_CoVan = new java.awt.Choice();
        jLabelChon1 = new javax.swing.JLabel();
        jPanelLopMain = new javax.swing.JPanel();
        jPanelThanhTieuDeLop = new javax.swing.JPanel();
        jPanelNutTieuDeLop = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa2 = new javax.swing.JLabel();
        jPanelNutXoaLop = RoundedPanel.createRoundedPanel();
        jLabelNutXoaLop = new javax.swing.JLabel();
        jPanelNutSuaLop = RoundedPanel.createRoundedPanel();
        jLabelNutSuaLop = new javax.swing.JLabel();
        jPanelNutThemLop = RoundedPanel.createRoundedPanel();
        jLabelNutThemLop = new javax.swing.JLabel();
        jPanelTableLop = new com.raven.swing.PanelBorder();
        jLabelTableTitleLop = new javax.swing.JLabel();
        jScrollPaneLop = new javax.swing.JScrollPane();
        jTableLop = new com.raven.swing.TableLop();
        choiceKhoa_Lop = new java.awt.Choice();
        jLabelChonKhoa_Lop = new javax.swing.JLabel();
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

jPanelHocKyMain.setPreferredSize(new java.awt.Dimension(790, 620));
jPanelHocKyMain.setRequestFocusEnabled(false);
jPanelHocKyMain.setVerifyInputWhenFocusTarget(false);
jPanelHocKyMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jPanelThanhTieuDeHK.setBackground(new java.awt.Color(255, 255, 255));
jPanelThanhTieuDeHK.setPreferredSize(new java.awt.Dimension(770, 34));

jPanelNutTieuDeHK.setBackground(new java.awt.Color(221, 51, 51));

jLabelNutTieuDeHK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabelNutTieuDeHK.setForeground(new java.awt.Color(255, 255, 255));
jLabelNutTieuDeHK.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitecalender.png")));
jLabelNutTieuDeHK.setText("Học kỳ");
jLabelNutTieuDeHK.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
jLabelNutTieuDeHK.setPreferredSize(new java.awt.Dimension(32, 16));

javax.swing.GroupLayout jPanelNutTieuDeHKLayout = new javax.swing.GroupLayout(jPanelNutTieuDeHK);
jPanelNutTieuDeHK.setLayout(jPanelNutTieuDeHKLayout);
jPanelNutTieuDeHKLayout.setHorizontalGroup(
    jPanelNutTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanelNutTieuDeHKLayout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabelNutTieuDeHK, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeHKLayout.setVerticalGroup(
        jPanelNutTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeHK, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeHKLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeHK);
    jPanelThanhTieuDeHK.setLayout(jPanelThanhTieuDeHKLayout);
    jPanelThanhTieuDeHKLayout.setHorizontalGroup(
        jPanelThanhTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeHKLayout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(597, Short.MAX_VALUE))
    );
    jPanelThanhTieuDeHKLayout.setVerticalGroup(
        jPanelThanhTieuDeHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeHK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelHocKyMain.add(jPanelThanhTieuDeHK, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelBorderHocKy.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTitleHocKy.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTitleHocKy.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTitleHocKy.setText("Học kỳ");

    jScrollPaneHocKy.setBorder(null);
    // Code of sub-components and layout - not shown here

    // Code adding the component to the parent container - not shown here
    jScrollPaneHocKy.setVerticalScrollBar(new ScrollBar());
    jScrollPaneHocKy.getVerticalScrollBar().setBackground(Color.WHITE);
    jScrollPaneHocKy.getViewport().setBackground(Color.WHITE);
    JPanel p4 = new JPanel();
    p4.setBackground(Color.WHITE);
    jScrollPaneHocKy.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p4);

    jTableHocKy.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Số thứ tự", "Học kỳ", "Niên Khóa", "Trạng thái"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            true, false, false, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTableHocKy.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTableHocKy.setShowGrid(true);
    jScrollPaneHocKy.setViewportView(jTableHocKy);
    // Code of sub-components and layout - not shown here

    // Code adding the component to the parent container - not shown here

    jPanelNutThemHK.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThemHK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThemHK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThemHK.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThemHK.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThemHK.setText("Thêm");
    jLabelNutThemHK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThemHK.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThemHK.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThemHKMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThemHKLayout = new javax.swing.GroupLayout(jPanelNutThemHK);
    jPanelNutThemHK.setLayout(jPanelNutThemHKLayout);
    jPanelNutThemHKLayout.setHorizontalGroup(
        jPanelNutThemHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemHKLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelNutThemHK, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(122, 122, 122))
    );
    jPanelNutThemHKLayout.setVerticalGroup(
        jPanelNutThemHKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThemHK, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
    );

    jPanelNutDoiTT.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutDoiTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutDoiTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutDoiTT.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutDoiTT.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutDoiTT.setText("Đổi HK xét");
    jLabelNutDoiTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutDoiTT.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutDoiTT.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutDoiTTMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutDoiTTLayout = new javax.swing.GroupLayout(jPanelNutDoiTT);
    jPanelNutDoiTT.setLayout(jPanelNutDoiTTLayout);
    jPanelNutDoiTTLayout.setHorizontalGroup(
        jPanelNutDoiTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutDoiTTLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutDoiTT, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
    );
    jPanelNutDoiTTLayout.setVerticalGroup(
        jPanelNutDoiTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutDoiTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelBorderHocKyLayout = new javax.swing.GroupLayout(jPanelBorderHocKy);
    jPanelBorderHocKy.setLayout(jPanelBorderHocKyLayout);
    jPanelBorderHocKyLayout.setHorizontalGroup(
        jPanelBorderHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBorderHocKyLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanelBorderHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanelBorderHocKyLayout.createSequentialGroup()
                    .addComponent(jLabelTitleHocKy)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNutThemHK, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanelNutDoiTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9))
                .addComponent(jScrollPaneHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(15, Short.MAX_VALUE))
    );
    jPanelBorderHocKyLayout.setVerticalGroup(
        jPanelBorderHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBorderHocKyLayout.createSequentialGroup()
            .addGroup(jPanelBorderHocKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBorderHocKyLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabelTitleHocKy))
                .addGroup(jPanelBorderHocKyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelNutDoiTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelBorderHocKyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelNutThemHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPaneHocKy, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
            .addContainerGap())
    );

    jPanelHocKyMain.add(jPanelBorderHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 430, 520));

    jPanelBorderKhoaHoc.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTitleKhoaHoc.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTitleKhoaHoc.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTitleKhoaHoc.setText("Khóa học");

    jScrollPaneKhoaHoc.setBorder(null);

    jTableKhoaHoc.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Số thứ tự", "Khóa học", "Số năm học"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTableKhoaHoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTableKhoaHoc.setShowGrid(true);
    jScrollPaneKhoaHoc.setViewportView(jTableKhoaHoc);

    jPanelNutThemKhoaHoc.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThemKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThemKhoaHoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThemKhoaHoc.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThemKhoaHoc.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThemKhoaHoc.setText("Thêm");
    jLabelNutThemKhoaHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThemKhoaHoc.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThemKhoaHoc.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThemKhoaHocMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThemKhoaHocLayout = new javax.swing.GroupLayout(jPanelNutThemKhoaHoc);
    jPanelNutThemKhoaHoc.setLayout(jPanelNutThemKhoaHocLayout);
    jPanelNutThemKhoaHocLayout.setHorizontalGroup(
        jPanelNutThemKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemKhoaHocLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelNutThemKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(117, 117, 117))
    );
    jPanelNutThemKhoaHocLayout.setVerticalGroup(
        jPanelNutThemKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThemKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelBorderKhoaHocLayout = new javax.swing.GroupLayout(jPanelBorderKhoaHoc);
    jPanelBorderKhoaHoc.setLayout(jPanelBorderKhoaHocLayout);
    jPanelBorderKhoaHocLayout.setHorizontalGroup(
        jPanelBorderKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBorderKhoaHocLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanelBorderKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBorderKhoaHocLayout.createSequentialGroup()
                    .addComponent(jScrollPaneKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
                .addGroup(jPanelBorderKhoaHocLayout.createSequentialGroup()
                    .addComponent(jLabelTitleKhoaHoc)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNutThemKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28))))
    );
    jPanelBorderKhoaHocLayout.setVerticalGroup(
        jPanelBorderKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBorderKhoaHocLayout.createSequentialGroup()
            .addGroup(jPanelBorderKhoaHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBorderKhoaHocLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabelTitleKhoaHoc))
                .addGroup(jPanelBorderKhoaHocLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelNutThemKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPaneKhoaHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
            .addContainerGap())
    );

    jScrollPaneKhoaHoc.setVerticalScrollBar(new ScrollBar());
    jScrollPaneKhoaHoc.getVerticalScrollBar().setBackground(Color.WHITE);
    jScrollPaneKhoaHoc.getViewport().setBackground(Color.WHITE);
    JPanel p3 = new JPanel();
    p3.setBackground(Color.WHITE);
    jScrollPaneKhoaHoc.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p3);

    jPanelHocKyMain.add(jPanelBorderKhoaHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 310, 520));

    jLayeredPaneMain.add(jPanelHocKyMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelKhoaMain.setPreferredSize(new java.awt.Dimension(621, 436));
    jPanelKhoaMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDeKhoa.setBackground(new java.awt.Color(255, 255, 255));
    jPanelThanhTieuDeKhoa.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeKhoa.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeKhoa.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteschool.png")));
    jLabelNutTieuDeKhoa.setText("Khoa");
    jLabelNutTieuDeKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeKhoa.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeKhoaLayout = new javax.swing.GroupLayout(jPanelNutTieuDeKhoa);
    jPanelNutTieuDeKhoa.setLayout(jPanelNutTieuDeKhoaLayout);
    jPanelNutTieuDeKhoaLayout.setHorizontalGroup(
        jPanelNutTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeKhoaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutTieuDeKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
    );
    jPanelNutTieuDeKhoaLayout.setVerticalGroup(
        jPanelNutTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoaKhoa.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoaKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoaKhoa.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoaKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoaKhoa.setText("Xóa");
    jLabelNutXoaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoaKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutXoaKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutXoaKhoaMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutXoaKhoaLayout = new javax.swing.GroupLayout(jPanelNutXoaKhoa);
    jPanelNutXoaKhoa.setLayout(jPanelNutXoaKhoaLayout);
    jPanelNutXoaKhoaLayout.setHorizontalGroup(
        jPanelNutXoaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaKhoaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoaKhoaLayout.setVerticalGroup(
        jPanelNutXoaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSuaKhoa.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSuaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutSuaKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSuaKhoa.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSuaKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSuaKhoa.setText("Cập nhật");
    jLabelNutSuaKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSuaKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutSuaKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutSuaKhoaMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutSuaKhoaLayout = new javax.swing.GroupLayout(jPanelNutSuaKhoa);
    jPanelNutSuaKhoa.setLayout(jPanelNutSuaKhoaLayout);
    jPanelNutSuaKhoaLayout.setHorizontalGroup(
        jPanelNutSuaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaKhoaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSuaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
    );
    jPanelNutSuaKhoaLayout.setVerticalGroup(
        jPanelNutSuaKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSuaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThemKhoa.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThemKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThemKhoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThemKhoa.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThemKhoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThemKhoa.setText("Thêm");
    jLabelNutThemKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThemKhoa.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThemKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThemKhoaMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThemKhoaLayout = new javax.swing.GroupLayout(jPanelNutThemKhoa);
    jPanelNutThemKhoa.setLayout(jPanelNutThemKhoaLayout);
    jPanelNutThemKhoaLayout.setHorizontalGroup(
        jPanelNutThemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemKhoaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
    );
    jPanelNutThemKhoaLayout.setVerticalGroup(
        jPanelNutThemKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeKhoaLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeKhoa);
    jPanelThanhTieuDeKhoa.setLayout(jPanelThanhTieuDeKhoaLayout);
    jPanelThanhTieuDeKhoaLayout.setHorizontalGroup(
        jPanelThanhTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeKhoaLayout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
            .addComponent(jPanelNutThemKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSuaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeKhoaLayout.setVerticalGroup(
        jPanelThanhTieuDeKhoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSuaKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThemKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelKhoaMain.add(jPanelThanhTieuDeKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    panelBorderTableKhoa.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTableTitleKhoa.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTableTitleKhoa.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTableTitleKhoa.setText("Danh sách các khoa");

    jScrollPaneKhoa.setBorder(null);
    jScrollPaneKhoa.setVerticalScrollBar(new ScrollBar());
    jScrollPaneKhoa.getVerticalScrollBar().setBackground(Color.WHITE);
    jScrollPaneKhoa.getViewport().setBackground(Color.WHITE);
    JPanel p1 = new JPanel();
    p1.setBackground(Color.WHITE);
    jScrollPaneKhoa.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p1);

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
    jTableKhoa.setShowGrid(true);
    jTableKhoa.setShowVerticalLines(false);
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

    jPanelTieuChiMain.setPreferredSize(new java.awt.Dimension(790, 620));
    jPanelTieuChiMain.setRequestFocusEnabled(false);
    jPanelTieuChiMain.setVerifyInputWhenFocusTarget(false);
    jPanelTieuChiMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDeTieuChi.setBackground(new java.awt.Color(255, 255, 255));
    jPanelThanhTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeTieuChi.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeTieuChi.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeTieuChi.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitetieuchi.png")));
    jLabelNutTieuDeTieuChi.setText("Tiêu chí");
    jLabelNutTieuDeTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTieuChi);
    jPanelNutTieuDeTieuChi.setLayout(jPanelNutTieuDeTieuChiLayout);
    jPanelNutTieuDeTieuChiLayout.setHorizontalGroup(
        jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDeTieuChiLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeTieuChiLayout.setVerticalGroup(
        jPanelNutTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoaTieuChi.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoaTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoaTieuChi.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoaTieuChi.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoaTieuChi.setText("Xóa");
    jLabelNutXoaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoaTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutXoaTieuChiLayout = new javax.swing.GroupLayout(jPanelNutXoaTieuChi);
    jPanelNutXoaTieuChi.setLayout(jPanelNutXoaTieuChiLayout);
    jPanelNutXoaTieuChiLayout.setHorizontalGroup(
        jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaTieuChiLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
    );
    jPanelNutXoaTieuChiLayout.setVerticalGroup(
        jPanelNutXoaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSuaTieuChi.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSuaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutSuaTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSuaTieuChi.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSuaTieuChi.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSuaTieuChi.setText("Cập nhật");
    jLabelNutSuaTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSuaTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutSuaTieuChiLayout = new javax.swing.GroupLayout(jPanelNutSuaTieuChi);
    jPanelNutSuaTieuChi.setLayout(jPanelNutSuaTieuChiLayout);
    jPanelNutSuaTieuChiLayout.setHorizontalGroup(
        jPanelNutSuaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaTieuChiLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSuaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
    );
    jPanelNutSuaTieuChiLayout.setVerticalGroup(
        jPanelNutSuaTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSuaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThemTieuChi.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThemTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThemTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThemTieuChi.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThemTieuChi.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThemTieuChi.setText("Thêm");
    jLabelNutThemTieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThemTieuChi.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutThemTieuChiLayout = new javax.swing.GroupLayout(jPanelNutThemTieuChi);
    jPanelNutThemTieuChi.setLayout(jPanelNutThemTieuChiLayout);
    jPanelNutThemTieuChiLayout.setHorizontalGroup(
        jPanelNutThemTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemTieuChiLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThemTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
    );
    jPanelNutThemTieuChiLayout.setVerticalGroup(
        jPanelNutThemTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThemTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeTieuChiLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTieuChi);
    jPanelThanhTieuDeTieuChi.setLayout(jPanelThanhTieuDeTieuChiLayout);
    jPanelThanhTieuDeTieuChiLayout.setHorizontalGroup(
        jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeTieuChiLayout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
            .addComponent(jPanelNutThemTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSuaTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeTieuChiLayout.setVerticalGroup(
        jPanelThanhTieuDeTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSuaTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThemTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelTieuChiMain.add(jPanelThanhTieuDeTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelBorderTieuChi.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTitleTieuChi.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTitleTieuChi.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTitleTieuChi.setText("Tiêu chí đánh giá");

    jScrollPaneTieuChi.setBorder(null);

    jTableTieuChi.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Số thứ tự", "Nội dung", "Điểm quyết định"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTableTieuChi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTableTieuChi.setShowGrid(true);
    jScrollPaneTieuChi.setViewportView(jTableTieuChi);

    jPanelNutChiTietTC.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutChiTietTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutChiTietTC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutChiTietTC.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutChiTietTC.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutChiTietTC.setText("Chi tiết tiêu chí");
    jLabelNutChiTietTC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutChiTietTC.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutChiTietTC.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutChiTietTCMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutChiTietTCLayout = new javax.swing.GroupLayout(jPanelNutChiTietTC);
    jPanelNutChiTietTC.setLayout(jPanelNutChiTietTCLayout);
    jPanelNutChiTietTCLayout.setHorizontalGroup(
        jPanelNutChiTietTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutChiTietTCLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutChiTietTC, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
    );
    jPanelNutChiTietTCLayout.setVerticalGroup(
        jPanelNutChiTietTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutChiTietTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelBorderTieuChiLayout = new javax.swing.GroupLayout(jPanelBorderTieuChi);
    jPanelBorderTieuChi.setLayout(jPanelBorderTieuChiLayout);
    jPanelBorderTieuChiLayout.setHorizontalGroup(
        jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                    .addComponent(jScrollPaneTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE))
                .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                    .addComponent(jLabelTitleTieuChi)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNutChiTietTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34))))
    );
    jPanelBorderTieuChiLayout.setVerticalGroup(
        jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanelBorderTieuChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelNutChiTietTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBorderTieuChiLayout.createSequentialGroup()
                    .addComponent(jLabelTitleTieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPaneTieuChi, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
            .addContainerGap())
    );

    jScrollPaneTieuChi.setVerticalScrollBar(new ScrollBar());
    jScrollPaneTieuChi.getVerticalScrollBar().setBackground(Color.WHITE);
    jScrollPaneTieuChi.getViewport().setBackground(Color.WHITE);
    JPanel p6 = new JPanel();
    p6.setBackground(Color.WHITE);
    jScrollPaneTieuChi.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p6);

    jPanelTieuChiMain.add(jPanelBorderTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

    jLayeredPaneMain.add(jPanelTieuChiMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

    jPanelCoVanMain.setPreferredSize(new java.awt.Dimension(645, 461));
    jPanelCoVanMain.setRequestFocusEnabled(false);
    jPanelCoVanMain.setVerifyInputWhenFocusTarget(false);
    jPanelCoVanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDeCoVan.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeCoVan.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeCoVan.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeCoVan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteteacher.png")));
    jLabelNutTieuDeCoVan.setText("Cố vấn");
    jLabelNutTieuDeCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeCoVan.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeCoVanLayout = new javax.swing.GroupLayout(jPanelNutTieuDeCoVan);
    jPanelNutTieuDeCoVan.setLayout(jPanelNutTieuDeCoVanLayout);
    jPanelNutTieuDeCoVanLayout.setHorizontalGroup(
        jPanelNutTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDeCoVanLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDeCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeCoVanLayout.setVerticalGroup(
        jPanelNutTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoaCoVan.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoaCoVan.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoaCoVan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoaCoVan.setText("Xóa");
    jLabelNutXoaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoaCoVan.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutXoaCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutXoaCoVanMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutXoaCoVanLayout = new javax.swing.GroupLayout(jPanelNutXoaCoVan);
    jPanelNutXoaCoVan.setLayout(jPanelNutXoaCoVanLayout);
    jPanelNutXoaCoVanLayout.setHorizontalGroup(
        jPanelNutXoaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaCoVanLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoaCoVanLayout.setVerticalGroup(
        jPanelNutXoaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSuaCoVan.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSuaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutSuaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSuaCoVan.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSuaCoVan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSuaCoVan.setText("Cập nhật");
    jLabelNutSuaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSuaCoVan.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutSuaCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutSuaCoVanMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutSuaCoVanLayout = new javax.swing.GroupLayout(jPanelNutSuaCoVan);
    jPanelNutSuaCoVan.setLayout(jPanelNutSuaCoVanLayout);
    jPanelNutSuaCoVanLayout.setHorizontalGroup(
        jPanelNutSuaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaCoVanLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
    );
    jPanelNutSuaCoVanLayout.setVerticalGroup(
        jPanelNutSuaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThemCoVan.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThemCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThemCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThemCoVan.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThemCoVan.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThemCoVan.setText("Thêm");
    jLabelNutThemCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThemCoVan.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThemCoVan.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThemCoVanMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThemCoVanLayout = new javax.swing.GroupLayout(jPanelNutThemCoVan);
    jPanelNutThemCoVan.setLayout(jPanelNutThemCoVanLayout);
    jPanelNutThemCoVanLayout.setHorizontalGroup(
        jPanelNutThemCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemCoVanLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
    );
    jPanelNutThemCoVanLayout.setVerticalGroup(
        jPanelNutThemCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeCoVanLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeCoVan);
    jPanelThanhTieuDeCoVan.setLayout(jPanelThanhTieuDeCoVanLayout);
    jPanelThanhTieuDeCoVanLayout.setHorizontalGroup(
        jPanelThanhTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeCoVanLayout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
            .addComponent(jPanelNutThemCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSuaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoaCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeCoVanLayout.setVerticalGroup(
        jPanelThanhTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelCoVanMain.add(jPanelThanhTieuDeCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelTableCoVan.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTableTitleCoVan.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTableTitleCoVan.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTableTitleCoVan.setText("Danh sách các cố vấn");

    jScrollPaneCoVan.setBorder(null);
    jScrollPaneCoVan.setVerticalScrollBar(new ScrollBar());
    jScrollPaneCoVan.getVerticalScrollBar().setBackground(Color.WHITE);
    jScrollPaneCoVan.getViewport().setBackground(Color.WHITE);
    JPanel p2 = new JPanel();
    p2.setBackground(Color.WHITE);
    jScrollPaneCoVan.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p2);

    jTableCoVan.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "STT", "Mã cố vấn", "  Tên cố vấn", "  Email trường cấp", "  Khoa"
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
    jTableCoVan.setShowGrid(true);
    jTableCoVan.setShowVerticalLines(false);
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

    jPanelLopMain.setPreferredSize(new java.awt.Dimension(684, 505));
    jPanelLopMain.setRequestFocusEnabled(false);
    jPanelLopMain.setVerifyInputWhenFocusTarget(false);
    jPanelLopMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanelThanhTieuDeLop.setBackground(new java.awt.Color(255, 255, 255));
    jPanelThanhTieuDeLop.setPreferredSize(new java.awt.Dimension(770, 34));

    jPanelNutTieuDeLop.setBackground(new java.awt.Color(221, 51, 51));

    jLabelNutTieuDeKhoa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutTieuDeKhoa2.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutTieuDeKhoa2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteclass.png")));
    jLabelNutTieuDeKhoa2.setText("Lớp");
    jLabelNutTieuDeKhoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    jLabelNutTieuDeKhoa2.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutTieuDeLopLayout = new javax.swing.GroupLayout(jPanelNutTieuDeLop);
    jPanelNutTieuDeLop.setLayout(jPanelNutTieuDeLopLayout);
    jPanelNutTieuDeLopLayout.setHorizontalGroup(
        jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNutTieuDeLopLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(28, Short.MAX_VALUE))
    );
    jPanelNutTieuDeLopLayout.setVerticalGroup(
        jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoaLop.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoaLop.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoaLop.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoaLop.setText("Xóa");
    jLabelNutXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoaLop.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutXoaLop.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutXoaLopMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutXoaLopLayout = new javax.swing.GroupLayout(jPanelNutXoaLop);
    jPanelNutXoaLop.setLayout(jPanelNutXoaLopLayout);
    jPanelNutXoaLopLayout.setHorizontalGroup(
        jPanelNutXoaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXoaLopLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
    );
    jPanelNutXoaLopLayout.setVerticalGroup(
        jPanelNutXoaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutSuaLop.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutSuaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutSuaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutSuaLop.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutSuaLop.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutSuaLop.setText("Cập nhật");
    jLabelNutSuaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutSuaLop.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutSuaLop.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutSuaLopMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutSuaLopLayout = new javax.swing.GroupLayout(jPanelNutSuaLop);
    jPanelNutSuaLop.setLayout(jPanelNutSuaLopLayout);
    jPanelNutSuaLopLayout.setHorizontalGroup(
        jPanelNutSuaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutSuaLopLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
    );
    jPanelNutSuaLopLayout.setVerticalGroup(
        jPanelNutSuaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutThemLop.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutThemLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutThemLop.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutThemLop.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteplus.png")));
    jLabelNutThemLop.setText("Thêm");
    jLabelNutThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutThemLop.setPreferredSize(new java.awt.Dimension(32, 16));
    jLabelNutThemLop.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelNutThemLopMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelNutThemLopLayout = new javax.swing.GroupLayout(jPanelNutThemLop);
    jPanelNutThemLop.setLayout(jPanelNutThemLopLayout);
    jPanelNutThemLopLayout.setHorizontalGroup(
        jPanelNutThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutThemLopLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
    );
    jPanelNutThemLopLayout.setVerticalGroup(
        jPanelNutThemLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jPanelThanhTieuDeLopLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeLop);
    jPanelThanhTieuDeLop.setLayout(jPanelThanhTieuDeLopLayout);
    jPanelThanhTieuDeLopLayout.setHorizontalGroup(
        jPanelThanhTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelThanhTieuDeLopLayout.createSequentialGroup()
            .addComponent(jPanelNutTieuDeLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
            .addComponent(jPanelNutThemLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSuaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDeLopLayout.setVerticalGroup(
        jPanelThanhTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDeLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelLopMain.add(jPanelThanhTieuDeLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

    jPanelTableLop.setBackground(new java.awt.Color(255, 255, 255));

    jLabelTableTitleLop.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
    jLabelTableTitleLop.setForeground(new java.awt.Color(127, 127, 127));
    jLabelTableTitleLop.setText("Danh sách các lớp");

    jScrollPaneLop.setBorder(null);
    jScrollPaneLop.setVerticalScrollBar(new ScrollBar());
    jScrollPaneLop.getVerticalScrollBar().setBackground(Color.WHITE);
    jScrollPaneLop.getViewport().setBackground(Color.WHITE);
    JPanel p5 = new JPanel();
    p5.setBackground(Color.WHITE);
    jScrollPaneLop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p5);

    jTableLop.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "STT", "   Lớp", "  Khoa", "  Cố vấn", "  Khóa học"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jTableLop.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    jTableLop.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTableLop.setShowGrid(true);
    jTableLop.setShowVerticalLines(false);
    jScrollPaneLop.setViewportView(jTableLop);

    choiceKhoa_Lop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    choiceKhoa_Lop.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    choiceKhoa_Lop.setPreferredSize(new java.awt.Dimension(28, 50));
    choiceKhoa_Lop.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            choiceKhoa_LopItemStateChanged(evt);
        }
    });

    jLabelChonKhoa_Lop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelChonKhoa_Lop.setText("Chọn khoa:");

    javax.swing.GroupLayout jPanelTableLopLayout = new javax.swing.GroupLayout(jPanelTableLop);
    jPanelTableLop.setLayout(jPanelTableLopLayout);
    jPanelTableLopLayout.setHorizontalGroup(
        jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTableLopLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelTableLopLayout.createSequentialGroup()
                    .addComponent(jLabelTableTitleLop)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelChonKhoa_Lop)
                    .addGap(2, 2, 2)
                    .addComponent(choiceKhoa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(17, Short.MAX_VALUE))
    );
    jPanelTableLopLayout.setVerticalGroup(
        jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelTableLopLayout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(jPanelTableLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabelTableTitleLop)
                .addComponent(choiceKhoa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelChonKhoa_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanelLopMain.add(jPanelTableLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 540));

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

    private void jLabelNutXoaKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaKhoaMouseClicked
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
                String maKhoa = dsKhoa.get(selectedRow).getMaKhoa().trim();
                DefaultTableModel model = (DefaultTableModel) jTableKhoa.getModel();
                model.removeRow(selectedRow);
                for(int i=0; i<dsTaiKhoan.size(); i++){
                    TaiKhoan tk = dsTaiKhoan.get(i);
                    if(tk.getTenTK().equals(maKhoa)){
                        dsTaiKhoan.remove(i);
                    }
                }
                dsKhoa.remove(selectedRow);
                
                dsTaiKhoan.remove(1);
                Controller.suaKhoaTrongCoVan(dsCoVan, maKhoa, "");
                Controller.suaKhoaTrongLop(dsLop, maKhoa, "");
                Controller.addListToLop(dsLop);
                Controller.addListToCoVan(dsCoVan);
                Controller.addListToKhoa(dsKhoa);
                Controller.addListToTaiKhoan(dsTaiKhoan);
            }
        }
    }//GEN-LAST:event_jLabelNutXoaKhoaMouseClicked

    private void jLabelNutSuaKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaKhoaMouseClicked
        // TODO add your handling code here:
        int chon = jTableKhoa.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            new SuaKhoa(dsKhoa, jTableKhoa, chon, dsTaiKhoan, dsCoVan, dsLop).setVisible(true);
        }
    }//GEN-LAST:event_jLabelNutSuaKhoaMouseClicked

    private void jLabelNutThemKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemKhoaMouseClicked
        // TODO add your handling code here:
        new ThemKhoa(dsTaiKhoan, dsKhoa, jTableKhoa).setVisible(true);
    }//GEN-LAST:event_jLabelNutThemKhoaMouseClicked

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

    private void jLabelNutSuaCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaCoVanMouseClicked
        // TODO add your handling code here:
        int chon = jTableCoVan.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            new SuaCoVan(dsTaiKhoan, dsKhoa, jTableCoVan, chon, dsCoVan, choiceKhoa_CoVan).setVisible(true);
        }
    }//GEN-LAST:event_jLabelNutSuaCoVanMouseClicked

    private void jLabelNutXoaCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaCoVanMouseClicked
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
    }//GEN-LAST:event_jLabelNutXoaCoVanMouseClicked

    private void jLabelNutThemCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemCoVanMouseClicked
        // TODO add your handling code here:
        new ThemCoVan(dsTaiKhoan, dsKhoa, jTableCoVan,  dsCoVan, choiceKhoa_CoVan).setVisible(true);
    }//GEN-LAST:event_jLabelNutThemCoVanMouseClicked

    private void jLabelNutThemKhoaHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemKhoaHocMouseClicked
        // TODO add your handling code here:
        LocalDate currentDate = LocalDate.now();
        
        // Lấy năm từ ngày hiện tại
        int currentYear = currentDate.getYear();
        String khoa1 = Integer.toString(currentYear)+ "-" +Integer.toString(currentYear+4);
        String khoa2 = Integer.toString(currentYear)+ "-" +Integer.toString(currentYear+5);
        if(dsKhoaHoc.getLast().getMaKhoaHoc().equals(khoa1) || dsKhoaHoc.getLast().getMaKhoaHoc().equals(khoa2)){
            JOptionPane.showMessageDialog(rootPane, "Khóa học mới của năm nay đã được thêm!");
        }
        else{
            int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn thêm 2 khóa học của năm nay?");
            if(chon ==  JOptionPane.YES_OPTION){
                KhoaHoc kh = new KhoaHoc();
                kh.setMaKhoaHoc(khoa1);
                kh.setNamBD(Integer.toString(currentYear));
                kh.setMamKT(Integer.toString(currentYear+4));
                kh.setTGHoc((float)4);
                dsKhoaHoc.add(kh);
                KhoaHoc kh2 = new KhoaHoc();
                kh2.setMaKhoaHoc(khoa1);
                kh2.setNamBD(Integer.toString(currentYear));
                kh2.setMamKT(Integer.toString(currentYear+5));
                kh2.setTGHoc((float) 4.5);
                dsKhoaHoc.add(kh2);
                String sql = "INSERT INTO KhoaHoc (MaKhoaHoc, NamBD, MamKT, TGHoc) VALUES (?, ?, ?, ?)";
                DefaultTableModel model = (DefaultTableModel) jTableKhoaHoc.getModel();
                Object[] row = {String.valueOf(dsKhoaHoc.size()-1),kh.getNamBD()+"-"+kh.getMamKT()+"", Float.toString(kh.getTGHoc())};
                Object[] row2 = {String.valueOf(dsKhoaHoc.size()),kh2.getNamBD()+"-"+kh2.getMamKT()+"", Float.toString(kh2.getTGHoc())};
                model.addRow(row);
                model.addRow(row2);
                try (
                    // Kết nối đến cơ sở dữ liệu
                    Connection conn = Controller.getConnection();
                    // Tạo một câu lệnh PreparedStatement để thực thi lệnh SQL
                    PreparedStatement pstmt = conn.prepareStatement(sql)
                ) {
                    // Lấy năm hiện tại
                    // Thiết lập thông tin cho câu lệnh PreparedStatement
                    pstmt.setString(1, khoa1);
                    pstmt.setString(2, Integer.toString(currentYear));
                    pstmt.setString(3, Integer.toString(currentYear + 4));
                    pstmt.setFloat(4, (float)4);

                    // Thực thi câu lệnh SQL
                    int rowsAffected = pstmt.executeUpdate();
                    pstmt.setString(1, khoa2);
                    pstmt.setString(2, Integer.toString(currentYear));
                    pstmt.setString(3, Integer.toString(currentYear + 5));
                    pstmt.setFloat(4, (float)4.5);

                    // Thực thi câu lệnh SQL
                    int rowsAffected2 = pstmt.executeUpdate();
            }   catch (SQLException ex) {
                Logger.getLogger(FormQuanLy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
        
    }//GEN-LAST:event_jLabelNutThemKhoaHocMouseClicked

    private void jLabelNutThemHKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemHKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelNutThemHKMouseClicked

    private void jLabelNutDoiTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutDoiTTMouseClicked
        // TODO add your handling code here:
        
       int chonHang = jTableHocKy.getSelectedRow();
       
        if(chonHang == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn học kỳ cần đổi!");
        }
        else{
            if(dsHocKy.get(chonHang).getXet().equals("Đang xét")){
                JOptionPane.showMessageDialog(rootPane, "Học kỳ đang được xét điểm!");
            }
            else{
                //System.out.println(dsHocKy.get(chonHang).getNienKhoa()+ " " +dsHocKy.get(chonHang).getXet());
                String nam = dsHocKy.get(chonHang).getNienKhoa();
                System.out.println(nam);
                String parts[] = nam.split("-");
                LocalDate currentDate = LocalDate.now();      
                // Lấy năm từ ngày hiện tại
                int currentYear = currentDate.getYear();
                if(currentYear > Integer.parseInt(parts[1])){
                    JOptionPane.showMessageDialog(rootPane, "Không thể đổi học kỳ của năm cũ!");
                }else{
                    //
                    if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn đổi?")==JOptionPane.YES_OPTION){
                        int xetCu = 0;
                        for(int i=0; i<dsHocKy.size(); i++){
                            if(dsHocKy.get(i).getXet().equals("Đang xét")){
                                dsHocKy.get(i).setXet("x");
                                xetCu = i;
                                break;
                            }
                        }
                        dsHocKy.get(chonHang).setXet("Đang xét");
                        jTableHocKy.setValueAt("Đang xét", chonHang, 3);
                        jTableHocKy.setValueAt("x", xetCu, 3);


                         String sql = "UPDATE HK_NK SET Xet = ? WHERE MaHK_NK = ?";

                         try (
                            // Kết nối đến cơ sở dữ liệu
                            Connection conn = Controller.getConnection();
                            // Tạo một câu lệnh PreparedStatement để thực thi lệnh SQL
                            PreparedStatement pstmt = conn.prepareStatement(sql);
                         
                        ) {
                            // Thiết lập thông tin cho câu lệnh PreparedStatement
                            String ketQua;

                            pstmt.setBoolean(1, true);
                            pstmt.setString(2, dsHocKy.get(chonHang).getMaHK_NK());
                             //System.out.println(nam);
                            // Thực thi câu lệnh SQL
                            pstmt.executeUpdate();

                            pstmt.setBoolean(1, false);
                            pstmt.setString(2, dsHocKy.get(xetCu).getMaHK_NK());
                            //System.out.println(dsHocKy.get(xetCu).getNienKhoa());
                            pstmt.executeUpdate();

                        } catch (SQLException e) {
                            //System.out.println("Lỗi khi cập nhật dữ liệu trong bảng HK_NK: " + e.getMessage());
                        }
                    }
                    
                }
            }
            
            
        }
    }//GEN-LAST:event_jLabelNutDoiTTMouseClicked

    private void choiceKhoa_LopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_LopItemStateChanged
        // TODO add your handling code here:
        String maKhoa = Controller.doiTenKhoaThanhMaKhoa(choiceKhoa_Lop.getSelectedItem(), dsKhoa);
        if(maKhoa.equals("")){
            Controller.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
        }
        else{
            Controller.addListLopToTable_Khoa(dsLop, jTableLop, dsKhoa, dsCoVan, maKhoa);
        }
    }//GEN-LAST:event_choiceKhoa_LopItemStateChanged

    private void jLabelNutXoaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaLopMouseClicked
        // TODO add your handling code here:
        int choose = jTableLop.getSelectedRow();
        if(choose == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
        }
        else{
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?") == JOptionPane.YES_OPTION){
                Object cellValue = jTableLop.getValueAt(choose , 1);
                int temp = 0;
                for(int i=0; i<dsLop.size(); i++){
                    if(dsLop.get(i).getLop().equals(cellValue.toString())){
                        temp = i; break;
                    }
                }
                dsLop.remove(temp);
                if(choiceKhoa_Lop.getSelectedItem().equals("Tất cả")){
                    Controller.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
                    
                }
                else{
                    Controller.addListLopToTable_Khoa(dsLop, jTableLop, dsKhoa, dsCoVan, choiceKhoa_Lop.getSelectedItem());
                }
                Controller.addListToLop(dsLop);
            }
        }
    }//GEN-LAST:event_jLabelNutXoaLopMouseClicked

    private void jLabelNutThemLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemLopMouseClicked
        // TODO add your handling code here:
        new ThemLop(dsKhoa, dsCoVan, dsKhoaHoc, dsLop, jTableLop, choiceKhoa_Lop).setVisible(true);
    }//GEN-LAST:event_jLabelNutThemLopMouseClicked

    private void jLabelNutSuaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaLopMouseClicked
        // TODO add your handling code here:
        int choose = jTableLop.getSelectedRow();
        if(choose == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn lớp cần sửa!");
        }
        else{
            new SuaLop(dsKhoa, dsCoVan, dsKhoaHoc, dsLop, jTableLop, choiceKhoa_Lop, choose).setVisible(true);
        }
        
    }//GEN-LAST:event_jLabelNutSuaLopMouseClicked

    private void jLabelNutChiTietTCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutChiTietTCMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelNutChiTietTCMouseClicked

    

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
    private java.awt.Choice choiceKhoa4;
    private java.awt.Choice choiceKhoa5;
    private java.awt.Choice choiceKhoa_CoVan;
    private java.awt.Choice choiceKhoa_Lop;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelChon1;
    private javax.swing.JLabel jLabelChon4;
    private javax.swing.JLabel jLabelChon5;
    private javax.swing.JLabel jLabelChonKhoa_Lop;
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
    private javax.swing.JLabel jLabelNutChiTietTC;
    private javax.swing.JLabel jLabelNutDoiTT;
    private javax.swing.JLabel jLabelNutLienHe;
    private javax.swing.JLabel jLabelNutSua6;
    private javax.swing.JLabel jLabelNutSuaCoVan;
    private javax.swing.JLabel jLabelNutSuaKhoa;
    private javax.swing.JLabel jLabelNutSuaLop;
    private javax.swing.JLabel jLabelNutSuaTieuChi;
    private javax.swing.JLabel jLabelNutThem6;
    private javax.swing.JLabel jLabelNutThemCoVan;
    private javax.swing.JLabel jLabelNutThemHK;
    private javax.swing.JLabel jLabelNutThemKhoa;
    private javax.swing.JLabel jLabelNutThemKhoaHoc;
    private javax.swing.JLabel jLabelNutThemLop;
    private javax.swing.JLabel jLabelNutThemTieuChi;
    private javax.swing.JLabel jLabelNutTieuDe2;
    private javax.swing.JLabel jLabelNutTieuDeCoVan;
    private javax.swing.JLabel jLabelNutTieuDeHK;
    private javax.swing.JLabel jLabelNutTieuDeKhoa;
    private javax.swing.JLabel jLabelNutTieuDeKhoa2;
    private javax.swing.JLabel jLabelNutTieuDeTieuChi;
    private javax.swing.JLabel jLabelNutXem;
    private javax.swing.JLabel jLabelNutXoa6;
    private javax.swing.JLabel jLabelNutXoaCoVan;
    private javax.swing.JLabel jLabelNutXoaKhoa;
    private javax.swing.JLabel jLabelNutXoaLop;
    private javax.swing.JLabel jLabelNutXoaTieuChi;
    private javax.swing.JLabel jLabelSinhVien;
    private javax.swing.JLabel jLabelSuaThongTin;
    private javax.swing.JLabel jLabelTableTitleCoVan;
    private javax.swing.JLabel jLabelTableTitleKhoa;
    private javax.swing.JLabel jLabelTableTitleLop;
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
    private javax.swing.JLabel jLabelTitleHocKy;
    private javax.swing.JLabel jLabelTitleKhoaHoc;
    private javax.swing.JLabel jLabelTitleTieuChi;
    private javax.swing.JLabel jLabelpanelPtit;
    private javax.swing.JLayeredPane jLayeredPaneMain;
    private com.raven.swing.PanelBorder jPanelBorderHocKy;
    private com.raven.swing.PanelBorder jPanelBorderKhoaHoc;
    private com.raven.swing.PanelBorder jPanelBorderTieuChi;
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
    private javax.swing.JPanel jPanelNutChiTietTC;
    private javax.swing.JPanel jPanelNutDoiTT;
    private javax.swing.JPanel jPanelNutLienHe;
    private javax.swing.JPanel jPanelNutSua6;
    private javax.swing.JPanel jPanelNutSuaCoVan;
    private javax.swing.JPanel jPanelNutSuaKhoa;
    private javax.swing.JPanel jPanelNutSuaLop;
    private javax.swing.JPanel jPanelNutSuaTieuChi;
    private javax.swing.JPanel jPanelNutThem6;
    private javax.swing.JPanel jPanelNutThemCoVan;
    private javax.swing.JPanel jPanelNutThemHK;
    private javax.swing.JPanel jPanelNutThemKhoa;
    private javax.swing.JPanel jPanelNutThemKhoaHoc;
    private javax.swing.JPanel jPanelNutThemLop;
    private javax.swing.JPanel jPanelNutThemTieuChi;
    private javax.swing.JPanel jPanelNutTieuDe2;
    private javax.swing.JPanel jPanelNutTieuDeCoVan;
    private javax.swing.JPanel jPanelNutTieuDeHK;
    private javax.swing.JPanel jPanelNutTieuDeKhoa;
    private javax.swing.JPanel jPanelNutTieuDeLop;
    private javax.swing.JPanel jPanelNutTieuDeTieuChi;
    private javax.swing.JPanel jPanelNutXem;
    private javax.swing.JPanel jPanelNutXoa6;
    private javax.swing.JPanel jPanelNutXoaCoVan;
    private javax.swing.JPanel jPanelNutXoaKhoa;
    private javax.swing.JPanel jPanelNutXoaLop;
    private javax.swing.JPanel jPanelNutXoaTieuChi;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JPanel jPanelSinhVienMain;
    private javax.swing.JPanel jPanelSuaTT;
    private com.raven.swing.PanelBorder jPanelTableCoVan;
    private com.raven.swing.PanelBorder jPanelTableLop;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JPanel jPanelTaiKhoanMain;
    private javax.swing.JPanel jPanelThanhTieuDe2;
    private javax.swing.JPanel jPanelThanhTieuDeCoVan;
    private javax.swing.JPanel jPanelThanhTieuDeHK;
    private javax.swing.JPanel jPanelThanhTieuDeKhoa;
    private javax.swing.JPanel jPanelThanhTieuDeLop;
    private javax.swing.JPanel jPanelThanhTieuDeTieuChi;
    private javax.swing.JPanel jPanelTieuChi;
    private javax.swing.JPanel jPanelTieuChiMain;
    private javax.swing.JPanel jPanelTitle1;
    private javax.swing.JPanel jPanelTitle2;
    private javax.swing.JPanel jPanelTitleColor;
    private javax.swing.JPanel jPanelTitleColor1;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPaneCoVan;
    private javax.swing.JScrollPane jScrollPaneHocKy;
    private javax.swing.JScrollPane jScrollPaneKhoa;
    private javax.swing.JScrollPane jScrollPaneKhoaHoc;
    private javax.swing.JScrollPane jScrollPaneLop;
    private javax.swing.JScrollPane jScrollPaneTieuChi;
    private com.raven.swing.TableCo5Cot jTableCoVan;
    private com.raven.swing.Table jTableHocKy;
    private com.raven.swing.TableCo5Cot jTableKhoa;
    private com.raven.swing.Table jTableKhoaHoc;
    private com.raven.swing.TableCo5Cot jTableLop;
    private com.raven.swing.Table jTableTieuChi;
    private com.raven.swing.PanelBorder panelBorderTableKhoa;
    // End of variables declaration//GEN-END:variables


}
