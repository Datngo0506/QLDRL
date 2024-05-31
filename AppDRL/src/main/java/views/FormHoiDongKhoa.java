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
import controller.Database;
import controller.Link;
import com.raven.swing.ScrollBar;
import controller.ThuatToan;
import java.awt.Cursor;
import java.awt.Image;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

/**
 *
 * @author Dat
 * 
 * 
 */




public final class FormHoiDongKhoa extends javax.swing.JFrame {

/**
     * Creates new form FormSinhVien
     */ private ArrayList <Khoa> dsKhoa = null;
        private ArrayList <CoVan> dsCoVan = null;
        private ArrayList <HocKy> dsHocKy = null;
        private ArrayList <KhoaHoc> dsKhoaHoc = null;
        private ArrayList <Lop> dsLop = null;
        private ArrayList <TaiKhoan> dsTaiKhoan = null;
        private ArrayList <SinhVien> dsSinhVien = null;
        private ArrayList <ChucVu> dsChucVu = null;
        private ArrayList <ThongBao> dsThongBao = null;
        private ArrayList <DRL> dsDRL = null;
        private Khoa khoa;
        private JFrame frame;
        //private final static Color textColor = new Color(0, 0, 139);
        private final static Color white = Color.WHITE;
        private final static Color hoveColor = new Color(255,204,102);//màu đậm
        private final static Color hoveColor2 = new Color(255, 228, 181);//màu lợt
        private final Color buttonHoverColor = new Color(30,115,190);
        private final Color buttonColor = new Color(221,51,51);
    // Màu của viền
        
    public FormHoiDongKhoa() {
        initComponents();
        suKienMenu();
    }
    
    //covan
    public FormHoiDongKhoa(JFrame frame, Khoa khoa, ArrayList<TaiKhoan> dsTaiKhoan, ArrayList <Khoa>dsKhoa, ArrayList <CoVan>dsCoVan, ArrayList<HocKy>dsHocKy,
            ArrayList<KhoaHoc>dsKhoaHoc, ArrayList<Lop> dsLop, ArrayList<ChucVu>dsChucVu, 
            ArrayList<SinhVien>dsSinhVien, ArrayList <ThongBao> dsThongBao, ArrayList<DRL> dsDRL) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsHocKy = dsHocKy;
        this.khoa = khoa;
        this.dsKhoaHoc = dsKhoaHoc;
        this.dsLop = dsLop;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsSinhVien = dsSinhVien;
        this.dsChucVu = dsChucVu;
        this.frame = frame;
        this.dsThongBao = dsThongBao;
        this.dsDRL = dsDRL;
        initComponents();
        suKienMenu();
    }
    
    //Xử lý khi click vào menu nào thì bảng của menu đó có dữ liệu
    public void addTable(String text){
        if (text.contains("CỐ VẤN")){
            Database.addListCoVanToTable_1Khoa(dsCoVan, jTableCoVan, khoa.getMaKhoa(), khoa.getTenKhoa(), dsTaiKhoan);
            choiceKhoa_CoVan.removeAll();
            choiceKhoa_CoVan.add(khoa.getTenKhoa());
        }
        else if(text.contains("LỚP")){
            Database.addListLopToTable_1Khoa(dsLop, jTableLop, khoa.getMaKhoa(),khoa.getTenKhoa(), dsCoVan);
            choiceKhoa_Lop.removeAll();
            choiceKhoa_Lop.add(khoa.getTenKhoa());
        }

        else if(text.contains("SINH VIÊN")){
            Database.addListSinhVienToTable_1Khoa(dsSinhVien, khoa.getMaKhoa(), dsLop, jTableSV, dsChucVu, dsTaiKhoan, khoa.getTenKhoa());
            choiceKhoa_SV.removeAll();
            choiceKhoa_SV.add(khoa.getTenKhoa());
            
            ThuatToan.addChoiceLop_1Khoa(dsLop, khoa.getMaKhoa(), choiceLop_SV);
        }
        else if(text.contains("DUYỆT ĐIỂM")){
            choiceKhoa_DRL.removeAll();
            choiceKhoa_DRL.add(khoa.getTenKhoa());
            ThuatToan.addChoiceLop(choiceLop_DRL, dsLop, khoa.getTenKhoa(), dsKhoa);
            
            Lop lopDau = new Lop();
            
            for(Lop lop: dsLop){
                if(lop.getMaKhoa().equals(khoa.getMaKhoa())){
                    lopDau = lop;
                    break;
                }
            }
            
            String parts[] = (lopDau.getMaKhoaHoc()).split("-");
            String hocKyDau = parts[0] + "-" + (Integer.parseInt(parts[0]) + 1) + "-1";

            Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, lopDau.getLop(), hocKyDau);
            jPanelNutDuyet.setVisible(false);
            jLabelNutDuyet.setVisible(false);
            jPanelNutChamLai.setVisible(false);
            jLabelNutChamLai.setVisible(false);
        }
        else {
            moTrangChu();
        }
    }    
    
    public void moTrangChu(){
        ThuatToan.addChoiceKhoa(choiceKhoa_LopXet, dsKhoa);
        String hkxet = ThuatToan.getHKXet(dsHocKy);
        jLabelHKXet.setText(Database.chuyenMaHocKy(hkxet));
        ThongBao tb = ThuatToan.getThongBao(dsThongBao, hkxet);
        jLabelNgayBD.setText(ThuatToan.doiNgay(tb.getNgayBD()));
        jLabelHanSV.setText(ThuatToan.doiNgay(tb.getNgayKTSV()));
        jLabelHanCS.setText(ThuatToan.doiNgay(tb.getNgayKTCS()));
        jLabelHanCV.setText(ThuatToan.doiNgay(tb.getNgayKTCV()));
        jLabelHanKhoa.setText(ThuatToan.doiNgay(tb.getNgayKTKhoa()));
        choiceKhoa_LopXet.removeAll();
        choiceKhoa_LopXet.add(khoa.getTenKhoa());
        Database.addListLopToTable_HKXet_Khoa(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, khoa.getTenKhoa(), dsKhoaHoc);
    }
        
        // Sử dụng màu này trong ứng dụng của bạn
    
    //Khi chọn vào menu nào thì menu đó có màu vàng còn tất cả còn lại reset màu trắng    
    public void viewMenuClick(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
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
        
    }    
    // rê vào menu nào thì menu đó có màu vàng lợt, trừ menu được chọn
    public void viewMenuHover(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
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

    }
    // rê ra khỏi menu thì menu màu trắng
    public void viewExit(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
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
                    main.dispose();
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
                    main.dispose();
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
                    main.dispose();
                    next.setVisible(true);
                }
            }
        });
    }
    //Các sự kiện của menu
    
    public void hoverMenu(){
        //rê vào menu nào thì menu đó màu vàng nhạt
        EnterEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft, jPanelSinhVien,  jPanelLop, jPanelCoVan, jPanelDRL);
        EnterEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelLop, jPanelCoVan, jPanelSinhVien, jPanelTrangChu);
        EnterEvent(jPanelLop, jLabelLop, jLabelLopLeft,  jPanelDRL, jPanelCoVan, jPanelSinhVien, jPanelTrangChu);
        EnterEvent(jPanelCoVan, jLabelCoVan, jLabelCoVanLeft,  jPanelLop, jPanelDRL,  jPanelSinhVien, jPanelTrangChu);
        EnterEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft,  jPanelLop, jPanelCoVan, jPanelDRL, jPanelTrangChu);
    }
    
    public void clickMenu(){
        //Kích vào menu nào thì đó hiện màu vàng đậm
       ClickEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft,  jPanelLop, jPanelCoVan,  jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelLop, jLabelLop, jLabelLopLeft,  jPanelDRL, jPanelCoVan,  jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelCoVan, jLabelCoVan, jLabelCoVanLeft,  jPanelLop, jPanelDRL,  jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelLop, jPanelCoVan,  jPanelDRL, jPanelTrangChu);
       ClickEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft,jPanelSinhVien, jPanelLop, jPanelCoVan, jPanelDRL);
    }
    
    public void hoverUnderMenu(){
        //Xử lý khi rê vào trợ giúp và đăng xuất
        buttonMenuHoverEvent(jLabelHelp, jPanelHelp, jLabelLeft8);
        buttonMenuHoverEvent(jLabelLogOut, jPanelLogOut, jLabelLeft9);
    }
    
    public void hoverButton(){
        //rê vào các nút thêm sửa xóa sẽ đổi màu xanh
        
        //nút thêm
        buttonHoverEvent(jLabelNutChamLai, jPanelNutChamLai);
        buttonHoverEvent(jLabelNutDuyet, jPanelNutDuyet);

        buttonHoverEvent(jLabelThemSV, jPanelThemSV);
        buttonHoverEvent(jLabelNutThemLop, jPanelNutThemLop);
        buttonHoverEvent(jLabelNutThemCoVan, jPanelNutThemCoVan);
        buttonHoverEvent(jLabelNutLienHe, jPanelNutLienHe);
        //nút xóa

        buttonHoverEvent(jLabelXoaSV, jPanelXoaSV);
        buttonHoverEvent(jLabelNutXoaLop, jPanelNutXoaLop);
        buttonHoverEvent(jLabelNutXoaCoVan, jPanelNutXoaCoVan);
        //buttonHoverEvent(jLabelNutXoa, jPanelNutXoa);
        
        //nút sửa

        buttonHoverEvent(jLabelSuaSV, jPanelSuaSV);
        buttonHoverEvent(jLabelNutSuaLop, jPanelNutSuaLop);
        buttonHoverEvent(jLabelNutSuaCoVan, jPanelNutSuaCoVan);
    }
    
    public void openFromMenu(){
        ClickMenuEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelDuyetDiem,   jPanelLopMain, jPanelCoVanMain,  jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelLop, jLabelLop, jLabelLopLeft, jPanelLopMain,   jPanelDuyetDiem, jPanelCoVanMain,  jPanelSinhVienMain, jPanelTrangChuMain);
        ClickMenuEvent(jPanelCoVan, jLabelCoVan, jLabelCoVanLeft, jPanelCoVanMain,  jPanelLopMain, jPanelDuyetDiem,  jPanelSinhVienMain, jPanelTrangChuMain);
        
        ClickMenuEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelSinhVienMain,   jPanelLopMain, jPanelCoVanMain,  jPanelDuyetDiem, jPanelTrangChuMain);       
        ClickMenuEvent( jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft,jPanelTrangChuMain, jPanelSinhVienMain,  jPanelLopMain, jPanelCoVanMain,  jPanelDuyetDiem); 
    }
    
    public void suKienMenu(){
        setLocationRelativeTo(null);
        hoverMenu();
        clickMenu();
        hoverUnderMenu();
        hoverButton();
        openFromMenu();
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo_ptit.png")); // Thay "logo.png" bằng đường dẫn của hình ảnh của bạn
        Image logo = icon.getImage();
        this.setIconImage(logo);   
        //Mặc định khi mở sẽ hiện màn hình tài khoản khi kích vào nút nào thì nút đó hiện ra phần màn hình đó
        jPanelTrangChu.setBackground(hoveColor);
        hienManHinhCanMo(jPanelTrangChu, jPanelCoVanMain, jPanelLopMain, jPanelSinhVienMain, jPanelDuyetDiem);
        moTrangChu();
        dangXuat(jPanelLogOut, jLabelLogOut, jLabelLeft9, this, frame);
    }
    
    public void anMenu(JPanel main, JLabel label, JLabel icon){
        main.setVisible(false);
        label.setVisible(false);
        icon.setVisible(false);
    }
    
    
    
    //Xử lý các sự kiện click
    public void ClickEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
        
        main1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4, p5);
            }
        });
        
    }
    
    
    
    //kích vô menu nào hiện màn hình đó
    //jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, PanelXemDiemMain
    public void ClickMenuEvent(JPanel main, JLabel main2, JLabel main3, JPanel main1, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
        
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5);
                addTable(main2.getText());
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5);
                addTable(main2.getText());
            }
        });
        
        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4, p5);
                addTable(main2.getText());
            }
        });
        
    }
    
    public void EnterEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
        
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelKhoa2
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelLeft
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4, p5);
                }
            });
            
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5);
                }
            });
            
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5);
                }
            });
            
            main3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4, p5);
                }
            });
    }
    
    //Xử lý khi rê các nút thêm, xóa sửa, chấm điểm
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
    
    public void hienManHinhCanMo(JPanel main, JPanel p2, JPanel p3, JPanel p4, JPanel p5){
        main.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
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
        jPanelTrangChu = new javax.swing.JPanel();
        jLabelTrangChu = new javax.swing.JLabel();
        jLabelTrangChuLeft = new javax.swing.JLabel();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jLabelLopLeft = new javax.swing.JLabel();
        jPanelCoVan = new javax.swing.JPanel();
        jLabelCoVan = new javax.swing.JLabel();
        jLabelCoVanLeft = new javax.swing.JLabel();
        jPanelSinhVien = new javax.swing.JPanel();
        jLabelSinhVien = new javax.swing.JLabel();
        jLabelSinhVienLeft = new javax.swing.JLabel();
        jPanelDRL = new javax.swing.JPanel();
        jLabelDRL = new javax.swing.JLabel();
        jLabelDRLLeft = new javax.swing.JLabel();
        jPanelNullDot1 = new javax.swing.JPanel();
        jLabelThreedots1 = new javax.swing.JLabel();
        jPanelNullDot4 = new javax.swing.JPanel();
        jPanelNullDot3 = new javax.swing.JPanel();
        jPanelNullDot = new javax.swing.JPanel();
        jPanelNullDot2 = new javax.swing.JPanel();
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
        jLabelThuongHieu = new javax.swing.JLabel();
        jLayeredPaneMain = new javax.swing.JLayeredPane();
        jPanelTrangChuMain = new javax.swing.JPanel();
        jPanelThanhTieuDeTrangChu1 = RoundedPanel.createRoundedPanel();
        jPanelNutTieuDeTrangChu1 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTrangChu1 = new javax.swing.JLabel();
        jPanel1 = RoundedPanel.createRoundedPanel();
        jLabelChonKhoa_Lop4 = new javax.swing.JLabel();
        jLabelHKXet = new javax.swing.JLabel();
        jLabelChonKhoa_Lop3 = new javax.swing.JLabel();
        jLabelNgayBD = new javax.swing.JLabel();
        jLabelChonKhoa_Lop7 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop5 = new javax.swing.JLabel();
        jLabelHanCV = new javax.swing.JLabel();
        jLabelChonKhoa_Lop8 = new javax.swing.JLabel();
        jLabelHanKhoa = new javax.swing.JLabel();
        jLabelChonKhoa_Lop6 = new javax.swing.JLabel();
        jLabelHanSV = new javax.swing.JLabel();
        jLabelHanCS = new javax.swing.JLabel();
        jPanelTableLop_Xet = new com.raven.swing.PanelBorder();
        jLabelTableTitleLop1 = new javax.swing.JLabel();
        jScrollPaneLopXet = new javax.swing.JScrollPane();
        jTableLopXet = new com.raven.swing.TableLop();
        choiceKhoa_LopXet = new java.awt.Choice();
        jLabelChonKhoa_Lop1 = new javax.swing.JLabel();
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
        jPanelDuyetDiem = new javax.swing.JPanel();
        jPanelThanhTieuDeTrangChu = new javax.swing.JPanel();
        jPanelNutTieuDeTrangChu = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTrangChu = new javax.swing.JLabel();
        jPanelNutChamLai = RoundedPanel.createRoundedPanel();
        jLabelNutChamLai = new javax.swing.JLabel();
        jPanelNutDuyet = RoundedPanel.createRoundedPanel();
        jLabelNutDuyet = new javax.swing.JLabel();
        jPanelTabeDRL = new com.raven.swing.PanelBorder();
        jScrollPaneDRL = new javax.swing.JScrollPane();
        jTableDRL = new com.raven.swing.TableDRL();
        choiceKhoa_DRL = new java.awt.Choice();
        jLabelChon2 = new javax.swing.JLabel();
        jLabelChon3 = new javax.swing.JLabel();
        jLabelChonLop_SV1 = new javax.swing.JLabel();
        choiceLop_DRL = new java.awt.Choice();
        choiceHK_DRL = new java.awt.Choice();
        jPanelSinhVienMain = new javax.swing.JPanel();
        jPanelTitleSV = new javax.swing.JPanel();
        jPanelNutTitleSV = RoundedPanel.createRoundedPanel();
        jLabelNutSV = new javax.swing.JLabel();
        jPanelXoaSV = RoundedPanel.createRoundedPanel();
        jLabelXoaSV = new javax.swing.JLabel();
        jPanelSuaSV = RoundedPanel.createRoundedPanel();
        jLabelSuaSV = new javax.swing.JLabel();
        jPanelThemSV = RoundedPanel.createRoundedPanel();
        jLabelThemSV = new javax.swing.JLabel();
        jPanelBorderSV = new com.raven.swing.PanelBorder();
        jLabelTitleSV = new javax.swing.JLabel();
        jScrollPaneSV = new javax.swing.JScrollPane();
        jTableSV = new com.raven.swing.TableSinhVien();
        jLabelChon_SV = new javax.swing.JLabel();
        jLabelChonLop_SV = new javax.swing.JLabel();
        choiceKhoa_SV = new java.awt.Choice();
        choiceLop_SV = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Hội đồng khoa");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelView.setBackground(new java.awt.Color(189, 56, 27));
        jPanelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setRequestFocusEnabled(false);
        jPanelMenu.setVerifyInputWhenFocusTarget(false);
        jPanelMenu.setLayout(new java.awt.GridLayout(12, 1));

        jPanelTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTrangChu.setForeground(new java.awt.Color(227, 70, 34));
        jLabelTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redhome.png"))); // NOI18N
        jLabelTrangChu.setText("TRANG CHỦ");

        jLabelTrangChuLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelTrangChuLayout = new javax.swing.GroupLayout(jPanelTrangChu);
        jPanelTrangChu.setLayout(jPanelTrangChuLayout);
        jPanelTrangChuLayout.setHorizontalGroup(
            jPanelTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTrangChuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTrangChuLayout.setVerticalGroup(
            jPanelTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelTrangChuLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelTrangChu);

        jPanelLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLop.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lop.png"))); // NOI18N
        jLabelLop.setText("LỚP");

        jLabelLopLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
        jPanelLop.setLayout(jPanelLopLayout);
        jPanelLopLayout.setHorizontalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLopLayout.setVerticalGroup(
            jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLop, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelLopLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLop);

        jPanelCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCoVan.setForeground(new java.awt.Color(227, 70, 34));
        jLabelCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/covan.png"))); // NOI18N
        jLabelCoVan.setText("CỐ VẤN");
        jLabelCoVan.setToolTipText("");

        jLabelCoVanLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCoVanLayout = new javax.swing.GroupLayout(jPanelCoVan);
        jPanelCoVan.setLayout(jPanelCoVanLayout);
        jPanelCoVanLayout.setHorizontalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoVanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCoVanLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCoVanLayout.setVerticalGroup(
            jPanelCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelCoVanLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelCoVan);

        jPanelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSinhVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSinhVien.setForeground(new java.awt.Color(227, 70, 34));
        jLabelSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redstudent32.png"))); // NOI18N
        jLabelSinhVien.setText("SINH VIÊN");
        jLabelSinhVien.setToolTipText("");

        jLabelSinhVienLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelSinhVienLayout = new javax.swing.GroupLayout(jPanelSinhVien);
        jPanelSinhVien.setLayout(jPanelSinhVienLayout);
        jPanelSinhVienLayout.setHorizontalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSinhVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSinhVienLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSinhVienLayout.setVerticalGroup(
            jPanelSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelSinhVienLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelSinhVien);

        jPanelDRL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelDRL.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDRL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDRL.setForeground(new java.awt.Color(227, 70, 34));
        jLabelDRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redtick.png"))); // NOI18N
        jLabelDRL.setText("DUYỆT ĐIỂM");
        jLabelDRL.setToolTipText("");

        jLabelDRLLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelDRLLayout = new javax.swing.GroupLayout(jPanelDRL);
        jPanelDRL.setLayout(jPanelDRLLayout);
        jPanelDRLLayout.setHorizontalGroup(
            jPanelDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDRLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDRLLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDRLLayout.setVerticalGroup(
            jPanelDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDRL, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelDRLLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelDRL);

        jPanelNullDot1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThreedots1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThreedots1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/threedot.png"))); // NOI18N

        javax.swing.GroupLayout jPanelNullDot1Layout = new javax.swing.GroupLayout(jPanelNullDot1);
        jPanelNullDot1.setLayout(jPanelNullDot1Layout);
        jPanelNullDot1Layout.setHorizontalGroup(
            jPanelNullDot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThreedots1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanelNullDot1Layout.setVerticalGroup(
            jPanelNullDot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNullDot1Layout.createSequentialGroup()
                .addComponent(jLabelThreedots1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelNullDot1);

        jPanelNullDot4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelNullDot4Layout = new javax.swing.GroupLayout(jPanelNullDot4);
        jPanelNullDot4.setLayout(jPanelNullDot4Layout);
        jPanelNullDot4Layout.setHorizontalGroup(
            jPanelNullDot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelNullDot4Layout.setVerticalGroup(
            jPanelNullDot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelNullDot4);

        jPanelNullDot3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelNullDot3Layout = new javax.swing.GroupLayout(jPanelNullDot3);
        jPanelNullDot3.setLayout(jPanelNullDot3Layout);
        jPanelNullDot3Layout.setHorizontalGroup(
            jPanelNullDot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelNullDot3Layout.setVerticalGroup(
            jPanelNullDot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelNullDot3);

        jPanelNullDot.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelNullDotLayout = new javax.swing.GroupLayout(jPanelNullDot);
        jPanelNullDot.setLayout(jPanelNullDotLayout);
        jPanelNullDotLayout.setHorizontalGroup(
            jPanelNullDotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelNullDotLayout.setVerticalGroup(
            jPanelNullDotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelNullDot);

        jPanelNullDot2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThreeDots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThreeDots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/threedot.png"))); // NOI18N

        javax.swing.GroupLayout jPanelNullDot2Layout = new javax.swing.GroupLayout(jPanelNullDot2);
        jPanelNullDot2.setLayout(jPanelNullDot2Layout);
        jPanelNullDot2Layout.setHorizontalGroup(
            jPanelNullDot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThreeDots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );
        jPanelNullDot2Layout.setVerticalGroup(
            jPanelNullDot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNullDot2Layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(jLabelThreeDots, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMenu.add(jPanelNullDot2);

        jPanelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelHelp.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHelp.setForeground(new java.awt.Color(227, 70, 34));
        jLabelHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.png"))); // NOI18N
        jLabelHelp.setText("Hướng dẫn");

        jLabelLeft8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft8, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHelpLayout.setVerticalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelLeft8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelHelp);

        jPanelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLogOut.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jLabelLogOut.setText("Thoát");
        jLabelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogOutMouseClicked(evt);
            }
        });

        jLabelLeft9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeft9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeft9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redleft.png"))); // NOI18N

        javax.swing.GroupLayout jPanelLogOutLayout = new javax.swing.GroupLayout(jPanelLogOut);
        jPanelLogOut.setLayout(jPanelLogOutLayout);
        jPanelLogOutLayout.setHorizontalGroup(
            jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLeft9, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLogOutLayout.setVerticalGroup(
            jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabelLeft9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelLogOut);

        jPanelView.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 140, 200, 600));

        jPanelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContact.setBackground(new java.awt.Color(189, 56, 27));
        jPanelContact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPtit.setBackground(new java.awt.Color(255, 255, 255));

        jLabelpanelPtit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoptithcm.png"))); // NOI18N
        jLabelpanelPtit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelNutLienHe.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutLienHe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutLienHe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutLienHe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/thongbaolienket.png"))); // NOI18N
        jLabelNutLienHe.setText("Xem thông tin mới nhất");
        jLabelNutLienHe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutLienHe.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutLienHeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutLienHeLayout = new javax.swing.GroupLayout(jPanelNutLienHe);
        jPanelNutLienHe.setLayout(jPanelNutLienHeLayout);
        jPanelNutLienHeLayout.setHorizontalGroup(
            jPanelNutLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutLienHeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );
        jPanelNutLienHeLayout.setVerticalGroup(
            jPanelNutLienHeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutLienHe, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPtitLayout = new javax.swing.GroupLayout(jPanelPtit);
        jPanelPtit.setLayout(jPanelPtitLayout);
        jPanelPtitLayout.setHorizontalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanelNutLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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

        jLabelCloud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cloud.png"))); // NOI18N
        jLabelCloud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCloud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloudMouseClicked(evt);
            }
        });
        jPanelContact.add(jLabelCloud, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, 30));

        jLabelFb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fb.png"))); // NOI18N
        jLabelFb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFbMouseClicked(evt);
            }
        });
        jPanelContact.add(jLabelFb, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, 30));

        jLabelThuongHieu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelThuongHieu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThuongHieu.setText("VERSION:PTITHCM's Student Training Point 2024 - DesignBy: ĐN");
        jLabelThuongHieu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanelContact.add(jLabelThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 400, 30));

        jPanelPanel.add(jPanelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 130));

        jPanelView.add(jPanelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        jLayeredPaneMain.setRequestFocusEnabled(false);
        jLayeredPaneMain.setVerifyInputWhenFocusTarget(false);
        jLayeredPaneMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTrangChuMain.setPreferredSize(new java.awt.Dimension(804, 612));
        jPanelTrangChuMain.setRequestFocusEnabled(false);
        jPanelTrangChuMain.setVerifyInputWhenFocusTarget(false);
        jPanelTrangChuMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTrangChu1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTrangChu1.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTrangChu1.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTrangChu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTrangChu1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTrangChu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitehome.png"))); // NOI18N
        jLabelNutTieuDeTrangChu1.setText("Trang chủ");
        jLabelNutTieuDeTrangChu1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTrangChu1.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTrangChu1Layout = new javax.swing.GroupLayout(jPanelNutTieuDeTrangChu1);
        jPanelNutTieuDeTrangChu1.setLayout(jPanelNutTieuDeTrangChu1Layout);
        jPanelNutTieuDeTrangChu1Layout.setHorizontalGroup(
            jPanelNutTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDeTrangChu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTrangChu1Layout.setVerticalGroup(
            jPanelNutTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTrangChu1Layout = new javax.swing.GroupLayout(jPanelThanhTieuDeTrangChu1);
        jPanelThanhTieuDeTrangChu1.setLayout(jPanelThanhTieuDeTrangChu1Layout);
        jPanelThanhTieuDeTrangChu1Layout.setHorizontalGroup(
            jPanelThanhTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTrangChu1Layout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTrangChu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanelThanhTieuDeTrangChu1Layout.setVerticalGroup(
            jPanelThanhTieuDeTrangChu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTrangChu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTrangChuMain.add(jPanelThanhTieuDeTrangChu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 770, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

        jLabelChonKhoa_Lop4.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop4.setText("Học kỳ đang xét:");

        jLabelHKXet.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHKXet.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHKXet.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHKXet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHKXet.setText("2025-2026 I");
        jLabelHKXet.setOpaque(true);

        jLabelChonKhoa_Lop3.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop3.setText(", hạn nộp của sinh viên:");

        jLabelNgayBD.setBackground(new java.awt.Color(221, 51, 51));
        jLabelNgayBD.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelNgayBD.setForeground(new java.awt.Color(221, 51, 51));
        jLabelNgayBD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNgayBD.setText("22-06-2023");

        jLabelChonKhoa_Lop7.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop7.setText("Hạn nộp của cán sự lớp:");

        jLabelChonKhoa_Lop5.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop5.setText("Hạn nộp của CVHT:");

        jLabelHanCV.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanCV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanCV.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanCV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanCV.setText("22-06-2023");

        jLabelChonKhoa_Lop8.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop8.setText(", hạn nộp của khoa:");

        jLabelHanKhoa.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanKhoa.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanKhoa.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanKhoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanKhoa.setText("2025-2026 I");

        jLabelChonKhoa_Lop6.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop6.setText(", ngày bắt đầu xét:");

        jLabelHanSV.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanSV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanSV.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanSV.setText("22-06-2023");

        jLabelHanCS.setBackground(new java.awt.Color(221, 51, 51));
        jLabelHanCS.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHanCS.setForeground(new java.awt.Color(221, 51, 51));
        jLabelHanCS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHanCS.setText("2025-2026 I");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelChonKhoa_Lop7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanCS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelChonKhoa_Lop5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanCV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelChonKhoa_Lop8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelChonKhoa_Lop4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHKXet, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelChonKhoa_Lop6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelChonKhoa_Lop3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHanSV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHKXet, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanSV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanCV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHanCS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        jPanelTrangChuMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 70));

        jPanelTableLop_Xet.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTableLop_Xet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

        jLabelTableTitleLop1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleLop1.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleLop1.setText("DS lớp thuộc khoa đang trong thời gian xét");

        jScrollPaneLopXet.setBorder(null);
        jScrollPaneLopXet.setVerticalScrollBar(new ScrollBar());
        jScrollPaneLopXet.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneLopXet.getViewport().setBackground(Color.WHITE);
        JPanel p24 = new JPanel();
        p24.setBackground(Color.WHITE);
        jScrollPaneLop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p24);

        jTableLopXet .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableLopXet.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableLopXet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableLopXet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableLopXet.setShowGrid(true);
        jTableLopXet.setShowVerticalLines(false);
        jScrollPaneLopXet.setViewportView(jTableLopXet);

        choiceKhoa_LopXet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_LopXet.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_LopXet.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_LopXet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_LopXetItemStateChanged(evt);
            }
        });

        jLabelChonKhoa_Lop1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop1.setText("Chọn khoa:");

        javax.swing.GroupLayout jPanelTableLop_XetLayout = new javax.swing.GroupLayout(jPanelTableLop_Xet);
        jPanelTableLop_Xet.setLayout(jPanelTableLop_XetLayout);
        jPanelTableLop_XetLayout.setHorizontalGroup(
            jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLop_XetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneLopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTableLop_XetLayout.createSequentialGroup()
                        .addComponent(jLabelTableTitleLop1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChonKhoa_Lop1)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_LopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTableLop_XetLayout.setVerticalGroup(
            jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLop_XetLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelTableLop_XetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTableTitleLop1)
                    .addComponent(choiceKhoa_LopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelChonKhoa_Lop1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneLopXet, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelTrangChuMain.add(jPanelTableLop_Xet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 440));

        jLayeredPaneMain.add(jPanelTrangChuMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanelCoVanMain.setPreferredSize(new java.awt.Dimension(645, 461));
        jPanelCoVanMain.setRequestFocusEnabled(false);
        jPanelCoVanMain.setVerifyInputWhenFocusTarget(false);
        jPanelCoVanMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeCoVan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeCoVan.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeCoVan.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteteacher.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeCoVanLayout.setVerticalGroup(
            jPanelNutTieuDeCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
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
                .addComponent(jLabelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaCoVanLayout.setVerticalGroup(
            jPanelNutXoaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutSuaCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutSuaCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutSuaCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSuaCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSuaCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
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
                .addComponent(jLabelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanelNutSuaCoVanLayout.setVerticalGroup(
            jPanelNutSuaCoVanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSuaCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutThemCoVan.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemCoVan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemCoVan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemCoVan.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemCoVan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
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
                .addComponent(jLabelNutThemCoVan, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
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
        jPanelTableCoVan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

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

        jTableCoVan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableCoVan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã cố vấn", "  Tên cố vấn", "  Email trường cấp", "  Khoa", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        choiceKhoa_CoVan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_CoVan.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_CoVan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_CoVanItemStateChanged(evt);
            }
        });

        jLabelChon1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
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
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addComponent(jScrollPaneCoVan, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanelCoVanMain.add(jPanelTableCoVan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

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
        jLabelNutTieuDeKhoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclass.png"))); // NOI18N
        jLabelNutTieuDeKhoa2.setText("Lớp");
        jLabelNutTieuDeKhoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeKhoa2.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeLopLayout = new javax.swing.GroupLayout(jPanelNutTieuDeLop);
        jPanelNutTieuDeLop.setLayout(jPanelNutTieuDeLopLayout);
        jPanelNutTieuDeLopLayout.setHorizontalGroup(
            jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeLopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTieuDeLopLayout.setVerticalGroup(
            jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
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
                .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelNutXoaLopLayout.setVerticalGroup(
            jPanelNutXoaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutSuaLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutSuaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutSuaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSuaLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSuaLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
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
                .addComponent(jLabelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
        );
        jPanelNutSuaLopLayout.setVerticalGroup(
            jPanelNutSuaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSuaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutThemLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutThemLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutThemLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutThemLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutThemLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
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
                .addComponent(jLabelNutThemLop, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
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
        jPanelTableLop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

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

        jTableLop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        choiceKhoa_Lop.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_Lop.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_Lop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_LopItemStateChanged(evt);
            }
        });

        jLabelChonKhoa_Lop.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
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
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanelLopMain.add(jPanelTableLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelLopMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelDuyetDiem.setPreferredSize(new java.awt.Dimension(804, 612));
        jPanelDuyetDiem.setRequestFocusEnabled(false);
        jPanelDuyetDiem.setVerifyInputWhenFocusTarget(false);
        jPanelDuyetDiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTrangChu.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTrangChu.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteview.png"))); // NOI18N
        jLabelNutTieuDeTrangChu.setText("Duyệt điểm rèn luyện sinh viên");
        jLabelNutTieuDeTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeTrangChu.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeTrangChuLayout = new javax.swing.GroupLayout(jPanelNutTieuDeTrangChu);
        jPanelNutTieuDeTrangChu.setLayout(jPanelNutTieuDeTrangChuLayout);
        jPanelNutTieuDeTrangChuLayout.setHorizontalGroup(
            jPanelNutTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );
        jPanelNutTieuDeTrangChuLayout.setVerticalGroup(
            jPanelNutTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutChamLai.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutChamLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutChamLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutChamLai.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutChamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclose.png"))); // NOI18N
        jLabelNutChamLai.setText("Chấm lại");
        jLabelNutChamLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutChamLai.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutChamLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutChamLaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutChamLaiLayout = new javax.swing.GroupLayout(jPanelNutChamLai);
        jPanelNutChamLai.setLayout(jPanelNutChamLaiLayout);
        jPanelNutChamLaiLayout.setHorizontalGroup(
            jPanelNutChamLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutChamLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );
        jPanelNutChamLaiLayout.setVerticalGroup(
            jPanelNutChamLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutDuyet.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutDuyet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutDuyet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutDuyet.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutDuyet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetick.png"))); // NOI18N
        jLabelNutDuyet.setText("Duyệt");
        jLabelNutDuyet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelNutDuyet.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelNutDuyet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNutDuyetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNutDuyetLayout = new javax.swing.GroupLayout(jPanelNutDuyet);
        jPanelNutDuyet.setLayout(jPanelNutDuyetLayout);
        jPanelNutDuyetLayout.setHorizontalGroup(
            jPanelNutDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutDuyetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutDuyet, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        );
        jPanelNutDuyetLayout.setVerticalGroup(
            jPanelNutDuyetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutDuyet, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTrangChuLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTrangChu);
        jPanelThanhTieuDeTrangChu.setLayout(jPanelThanhTieuDeTrangChuLayout);
        jPanelThanhTieuDeTrangChuLayout.setHorizontalGroup(
            jPanelThanhTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTrangChuLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jPanelNutDuyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutChamLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTrangChuLayout.setVerticalGroup(
            jPanelThanhTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutDuyet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelDuyetDiem.add(jPanelThanhTieuDeTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelTabeDRL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTabeDRL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

        jScrollPaneDRL.setBorder(null);
        jScrollPaneDRL.setVerticalScrollBar(new ScrollBar());
        jScrollPaneDRL.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneDRL.getViewport().setBackground(Color.WHITE);
        JPanel p22 = new JPanel();
        p22.setBackground(Color.WHITE);
        jScrollPaneDRL.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p22);

        jTableDRL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableDRL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sinh viên", "Họ và tên", "ĐSV", "ĐCS", "ĐCV", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDRL.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableDRL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDRL.setShowGrid(true);
        jTableDRL.setShowVerticalLines(false);
        jScrollPaneDRL.setViewportView(jTableDRL);

        choiceKhoa_DRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_DRL.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_DRL.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_DRL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_DRLItemStateChanged(evt);
            }
        });

        jLabelChon2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon2.setText("Chọn học kỳ:");

        jLabelChon3.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon3.setText("Chọn khoa:");

        jLabelChonLop_SV1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonLop_SV1.setText("Chọn lớp:");

        choiceLop_DRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceLop_DRL.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceLop_DRL.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceLop_DRL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceLop_DRLItemStateChanged(evt);
            }
        });

        choiceHK_DRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceHK_DRL.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceHK_DRL.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceHK_DRL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceHK_DRLItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelTabeDRLLayout = new javax.swing.GroupLayout(jPanelTabeDRL);
        jPanelTabeDRL.setLayout(jPanelTabeDRLLayout);
        jPanelTabeDRLLayout.setHorizontalGroup(
            jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                        .addComponent(jLabelChon3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceKhoa_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelChonLop_SV1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceLop_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelChon2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceHK_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelTabeDRLLayout.setVerticalGroup(
            jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                .addGroup(jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelChon3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelTabeDRLLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelTabeDRLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choiceKhoa_DRL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelChonLop_SV1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceLop_DRL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelChon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceHK_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(14, 14, 14)
                .addComponent(jScrollPaneDRL, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanelDuyetDiem.add(jPanelTabeDRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelDuyetDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelSinhVienMain.setPreferredSize(new java.awt.Dimension(574, 409));
        jPanelSinhVienMain.setRequestFocusEnabled(false);
        jPanelSinhVienMain.setVerifyInputWhenFocusTarget(false);
        jPanelSinhVienMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitleSV.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitleSV.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTitleSV.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteclass.png"))); // NOI18N
        jLabelNutSV.setText("Danh sách sinh viên");
        jLabelNutSV.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutSV.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTitleSVLayout = new javax.swing.GroupLayout(jPanelNutTitleSV);
        jPanelNutTitleSV.setLayout(jPanelNutTitleSVLayout);
        jPanelNutTitleSVLayout.setHorizontalGroup(
            jPanelNutTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTitleSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutSV, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTitleSVLayout.setVerticalGroup(
            jPanelNutTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelXoaSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelXoaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelXoaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelXoaSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelXoaSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitedelete.png"))); // NOI18N
        jLabelXoaSV.setText("Xóa");
        jLabelXoaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelXoaSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelXoaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXoaSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelXoaSVLayout = new javax.swing.GroupLayout(jPanelXoaSV);
        jPanelXoaSV.setLayout(jPanelXoaSVLayout);
        jPanelXoaSVLayout.setHorizontalGroup(
            jPanelXoaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelXoaSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        jPanelXoaSVLayout.setVerticalGroup(
            jPanelXoaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelSuaSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelSuaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSuaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSuaSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSuaSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
        jLabelSuaSV.setText("Sửa");
        jLabelSuaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSuaSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelSuaSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSuaSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSuaSVLayout = new javax.swing.GroupLayout(jPanelSuaSV);
        jPanelSuaSV.setLayout(jPanelSuaSVLayout);
        jPanelSuaSVLayout.setHorizontalGroup(
            jPanelSuaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuaSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSuaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        jPanelSuaSVLayout.setVerticalGroup(
            jPanelSuaSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSuaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelThemSV.setBackground(new java.awt.Color(221, 51, 51));
        jPanelThemSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelThemSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelThemSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThemSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteplus.png"))); // NOI18N
        jLabelThemSV.setText("Thêm");
        jLabelThemSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelThemSV.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelThemSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThemSVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelThemSVLayout = new javax.swing.GroupLayout(jPanelThemSV);
        jPanelThemSV.setLayout(jPanelThemSVLayout);
        jPanelThemSVLayout.setHorizontalGroup(
            jPanelThemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThemSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        );
        jPanelThemSVLayout.setVerticalGroup(
            jPanelThemSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelTitleSVLayout = new javax.swing.GroupLayout(jPanelTitleSV);
        jPanelTitleSV.setLayout(jPanelTitleSVLayout);
        jPanelTitleSVLayout.setHorizontalGroup(
            jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleSVLayout.createSequentialGroup()
                .addComponent(jPanelNutTitleSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(jPanelThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSuaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelXoaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTitleSVLayout.setVerticalGroup(
            jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTitleSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelSuaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelSinhVienMain.add(jPanelTitleSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelBorderSV.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBorderSV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 51, 51)));

        jLabelTitleSV.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTitleSV.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTitleSV.setText("Danh sách sinh viên");

        jScrollPaneSV.setBorder(null);

        jTableSV .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "   MSSV", "   Họ và tên", "   Lớp", "   Chức vụ", "Mật khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSV.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSV.setShowGrid(true);
        jTableSV.setShowVerticalLines(false);
        jScrollPaneSV.setViewportView(jTableSV);

        jLabelChon_SV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChon_SV.setText("Chọn khoa:");

        jLabelChonLop_SV.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonLop_SV.setText("Chọn lớp:");

        choiceKhoa_SV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_SV.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_SV.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_SV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_SVItemStateChanged(evt);
            }
        });

        choiceLop_SV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceLop_SV.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceLop_SV.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceLop_SV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceLop_SVItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelBorderSVLayout = new javax.swing.GroupLayout(jPanelBorderSV);
        jPanelBorderSV.setLayout(jPanelBorderSVLayout);
        jPanelBorderSVLayout.setHorizontalGroup(
            jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneSV, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                        .addComponent(jLabelTitleSV)
                        .addGap(122, 122, 122)
                        .addComponent(jLabelChon_SV)
                        .addGap(2, 2, 2)
                        .addComponent(choiceKhoa_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelChonLop_SV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choiceLop_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelBorderSVLayout.setVerticalGroup(
            jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelChonLop_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBorderSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelTitleSV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelChon_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelBorderSVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(choiceLop_SV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(choiceKhoa_SV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSV, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPaneSV.setVerticalScrollBar(new ScrollBar());
        jScrollPaneSV.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneSV.getViewport().setBackground(Color.WHITE);
        JPanel p7 = new JPanel();
        p7.setBackground(Color.WHITE);
        jScrollPaneSV.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p7);

        jPanelSinhVienMain.add(jPanelBorderSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelSinhVienMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelView.add(jLayeredPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 784, 600));

        getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    


    

    private void choiceKhoa_CoVanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_CoVanItemStateChanged
        // TODO add your handling code here:
        String maKhoa = ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa);
        if(maKhoa.equals("")){
            Database.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa, dsTaiKhoan);
        }
        else{
            Database.addListCoVanToTable_MaKhoa(dsCoVan, jTableCoVan, dsKhoa, maKhoa, dsTaiKhoan);
        }
        
    }//GEN-LAST:event_choiceKhoa_CoVanItemStateChanged

    private void jLabelNutSuaCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaCoVanMouseClicked
        // TODO add your handling code here:
        int chon = jTableCoVan.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần sửa!");
        }
        else{
            try {
                new FormThem_SuaCoVan(dsTaiKhoan, khoa, dsKhoa, jTableCoVan, chon, dsCoVan, choiceKhoa_CoVan, "SuaND", dsLop).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(FormHoiDongKhoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelNutSuaCoVanMouseClicked

    private void jLabelNutXoaCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaCoVanMouseClicked
        int selectedRow = jTableCoVan.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        String mcv = jTableCoVan.getValueAt(selectedRow, 1).toString();
        for(Lop lop: dsLop){
            if(lop.getMaCoVan().equals(mcv)){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa cố vấn đang cố vấn cho 1 lớp!");
                return;
            }
        }
        // Xóa hàng được chọn từ bảng
        int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?");
        if(chon == JOptionPane.YES_OPTION){
            Object cellValue = jTableCoVan.getValueAt(selectedRow, 1); // Lấy dữ liệu từ cột MaCV
            new Thread(() -> {

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
                int i=0;
                dsCoVan.remove(hub);
                for(TaiKhoan tk: dsTaiKhoan){

                    if(tk.getTenTK().equals(maCoVan)){
                        dsTaiKhoan.remove(i);
                        break;
                    }
                    i++;
                }
                if(choiceKhoa_CoVan.getSelectedItem().equals("Tất cả")){
                    Database.addListCoVanToTable(dsCoVan, jTableCoVan, dsKhoa, dsTaiKhoan);
                }
                else{
                    Database.addListCoVanToTable_MaKhoa(dsCoVan, jTableCoVan, dsKhoa, 
                    ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_CoVan.getSelectedItem(), dsKhoa), dsTaiKhoan);
                }
                new Thread(() -> {
                    Database.saveListLopToDB(dsLop);
                    Database.saveListCoVanToDB(dsCoVan);
                    Database.saveListTaiKhoanToDB(dsTaiKhoan);
                }).start();
                
            }).start();

        } else {
            // Nếu không xác nhận xóa, bạn có thể xử lý tùy ý ở đây
        }
        
    }//GEN-LAST:event_jLabelNutXoaCoVanMouseClicked

    private void jLabelNutThemCoVanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemCoVanMouseClicked
         try {
             // TODO add your handling code here:
             new FormThem_SuaCoVan(dsTaiKhoan, khoa, dsKhoa, jTableCoVan, dsCoVan, choiceKhoa_CoVan, "ThemND").setVisible(true);
         } catch (ParseException ex) {
             Logger.getLogger(FormHoiDongKhoa.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabelNutThemCoVanMouseClicked

    private void choiceKhoa_LopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_LopItemStateChanged
        // TODO add your handling code here:
        String maKhoa = ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_Lop.getSelectedItem(), dsKhoa);
        if(maKhoa.equals("")){
            Database.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
        }
        else{
            Database.addListLopToTable_Khoa(dsLop, jTableLop, dsKhoa, dsCoVan, maKhoa);
        }
    }//GEN-LAST:event_choiceKhoa_LopItemStateChanged

    private void jLabelNutXoaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaLopMouseClicked
        // TODO add your handling code here:
        int choose = jTableLop.getSelectedRow();
        if(choose == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        String lop = jTableLop.getValueAt(choose, 1).toString();
        for(SinhVien sv: dsSinhVien){
            if(sv.getLop().equals(lop)){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa lớp có sinh viên theo học!");
                return;
            }
        }
        
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
                    Database.addListLopToTable(dsLop, jTableLop, dsKhoa, dsCoVan);
                } else {
                   Database.addListLopToTable_Khoa(dsLop, jTableLop, dsKhoa, dsCoVan, ThuatToan.doiTenKhoaThanhMaKhoa(choiceKhoa_Lop.getSelectedItem(), dsKhoa));
                }
            ThuatToan.doiLopDsSV(dsSinhVien, cellValue.toString(), "");
            new Thread(() -> {
                Database.saveSinhVienToList(dsSinhVien);
                Database.saveListLopToDB(dsLop);
            }).start();
            
        }
        
    }//GEN-LAST:event_jLabelNutXoaLopMouseClicked

    private void jLabelNutThemLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutThemLopMouseClicked
        // TODO add your handling code here:
        new FormThem_SuaLop(dsKhoa, khoa, dsCoVan, dsKhoaHoc, dsLop, jTableLop, choiceKhoa_Lop, "ThemND").setVisible(true);
    }//GEN-LAST:event_jLabelNutThemLopMouseClicked

    private void jLabelNutSuaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutSuaLopMouseClicked
        // TODO add your handling code here:
        int choose = jTableLop.getSelectedRow();
        if(choose == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn lớp cần sửa!");
        }
        else{
            new FormThem_SuaLop(dsKhoa, khoa, dsCoVan, dsKhoaHoc, dsLop, jTableLop, choiceKhoa_Lop, choose, dsSinhVien, "SuaND").setVisible(true);
        }
        
    }//GEN-LAST:event_jLabelNutSuaLopMouseClicked

    private void jLabelThemSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThemSVMouseClicked
         try {
             // TODO add your handling code here:
             new FormThem_SuaSinhVien(dsTaiKhoan, khoa, dsKhoa, jTableSV, choiceKhoa_SV, choiceLop_SV, dsLop, dsSinhVien, dsChucVu, "ThemND").setVisible(true);
         } catch (ParseException ex) {
             Logger.getLogger(FormHoiDongKhoa.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabelThemSVMouseClicked

    private void choiceKhoa_SVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_SVItemStateChanged
        // TODO add your handling code here:
        
        if(choiceKhoa_SV.getSelectedItem().equals("Tất cả")){
            Database.addListSinhVienToTable(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan);
            //choiceLop_SV.removeAll();
            
        }
        else{
            
            Database.addListSinhVienToTable_Khoa(dsSinhVien, dsKhoa, dsLop, jTableSV, dsChucVu, dsTaiKhoan, choiceKhoa_SV.getSelectedItem());
        }
        
        
        ThuatToan.addChoiceLopTatCa(choiceLop_SV, dsLop, choiceKhoa_SV.getSelectedItem(), dsKhoa);
        choiceLop_SV.select("Tất cả");
        
    }//GEN-LAST:event_choiceKhoa_SVItemStateChanged

    private void choiceLop_SVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceLop_SVItemStateChanged
        // TODO add your handling code here:
        if(!choiceLop_SV.getSelectedItem().equals("Tất cả")){
            Database.addListSinhVienToTable_Lop(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan, choiceLop_SV.getSelectedItem());
        }
        else{
            if(choiceKhoa_SV.getSelectedItem().equals("Tất cả")){
            Database.addListSinhVienToTable(dsSinhVien, jTableSV, dsChucVu, dsTaiKhoan);
            //choiceLop_SV.removeAll();
            
            }
            else{

                Database.addListSinhVienToTable_Khoa(dsSinhVien, dsKhoa, dsLop, jTableSV, dsChucVu, dsTaiKhoan, choiceKhoa_SV.getSelectedItem());
            }
        }
        
    }//GEN-LAST:event_choiceLop_SVItemStateChanged

    private void jLabelSuaSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaSVMouseClicked
        // TODO add your handling code here:
        int chon = jTableSV.getSelectedRow();
        if(chon==-1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần cập nhật thông tin!");
        }
        else{
            try {
                new FormThem_SuaSinhVien(dsTaiKhoan, khoa, dsKhoa, jTableSV, chon, dsSinhVien, choiceKhoa_SV, choiceLop_SV, dsLop, dsChucVu, "SuaND").setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(FormHoiDongKhoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jLabelSuaSVMouseClicked

    private void jLabelNutChamLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutChamLaiMouseClicked
        // TODO add your handling code here:
        int chon = jTableDRL.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần chấm lại!");
        }
        else if(!ThuatToan.kTraTGXetKhoa(dsThongBao, dsHocKy)){
            JOptionPane.showMessageDialog(rootPane, "Không trong thời gian xét duyệt!");
        }
        
        else{
            Object cell = jTableDRL.getValueAt(chon, 6);
            String tt = cell.toString();
            Object cell5 = jTableDRL.getValueAt(chon, 1);
            String tt5 = cell5.toString();
            if(tt.equals("Chưa duyệt")){
                if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn hủy bỏ điểm của sinh viên này?") == JOptionPane.YES_OPTION){
                    new Thread(() -> {
                        for(DRL drl: dsDRL){
                            if(drl.getMSSV().equals(tt5) && drl.getMaHK().equals(ThuatToan.getHKXet(dsHocKy))){
                                drl.setTrangThai(false);
                                drl.setDiem1(0);
                                drl.setDiem2(0);
                                drl.setDiem3(0);
                                return;
                            }
                        }
                    }).start();
                    new Thread(() -> {
                        Database.updateDiem(tt5, ThuatToan.getHKXet(dsHocKy));
                    }).start();
                    
                    jTableDRL.setValueAt("0", chon, 3);
                    jTableDRL.setValueAt("0", chon, 4);
                    jTableDRL.setValueAt("0", chon, 5);
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sinh viên này đã duyệt điểm rồi!");
            }
        }
    }//GEN-LAST:event_jLabelNutChamLaiMouseClicked

    private void jLabelNutDuyetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutDuyetMouseClicked
        // TODO add your handling code here:
        int chon = jTableDRL.getSelectedRow();

        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần duyệt!");
        }
        else if(!ThuatToan.kTraTGXetKhoa(dsThongBao, dsHocKy)){
            JOptionPane.showMessageDialog(rootPane, "Không trong thời gian xét duyệt!");
        }
        else{
            Object cell = jTableDRL.getValueAt(chon, 6);
            String tt = cell.toString();
            Object cell5 = jTableDRL.getValueAt(chon, 1);
            String tt5 = cell5.toString();
            if(tt.equals("Chưa duyệt")){
                //JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn duyệt điểm sinh viên này?");
                Object cell2 = jTableDRL.getValueAt(chon, 5);
                String tt2 = cell2.toString();
                Object cell3 = jTableDRL.getValueAt(chon, 4);
                String tt3 = cell3.toString();
                Object cell4 = jTableDRL.getValueAt(chon, 3);
                String tt4 = cell4.toString();
                if(tt2.equals("0") || tt3.equals("0") || tt4.equals("0")){
                    JOptionPane.showMessageDialog(rootPane, "Sinh viên này chưa hoàn tất đủ 3 cột điểm");
                }
                else{
                    if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn duyệt điểm sinh viên này?") == JOptionPane.YES_OPTION){
                        new Thread(() -> {
                            for(DRL drl: dsDRL){
                                if(drl.getMSSV().equals(tt5) && drl.getMaHK().equals(ThuatToan.getHKXet(dsHocKy))){
                                    drl.setTrangThai(true);
                                    
                                    return;
                                }
                            }
                        }).start();
                        new Thread(() -> {
                            Database.updateTrangThai(tt5, ThuatToan.getHKXet(dsHocKy));
                        }).start();
                        jTableDRL.setValueAt("Đã duyệt", chon, 6);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sinh viên này đã duyệt điểm rồi!");
            }
        }
    }//GEN-LAST:event_jLabelNutDuyetMouseClicked

    private void jLabelNutLienHeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutLienHeMouseClicked
        // TODO add your handling code here:
        Link.openLink("https://ptithcm.edu.vn/");
    }//GEN-LAST:event_jLabelNutLienHeMouseClicked

    private void jLabelCloudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloudMouseClicked
        // TODO add your handling code here:
        Link.openLink("https://www.facebook.com/CUUSVPTITHCM");
    }//GEN-LAST:event_jLabelCloudMouseClicked

    private void jLabelFbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFbMouseClicked
        // TODO add your handling code here:
        Link.openLink("https://www.facebook.com/ptithochiminh");
    }//GEN-LAST:event_jLabelFbMouseClicked

    private void choiceKhoa_DRLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_DRLItemStateChanged
        // TODO add your handling code here:
        ThuatToan.addChoiceLop(choiceLop_DRL, dsLop, choiceKhoa_DRL.getSelectedItem(), dsKhoa);
        Database.deleteTable(jTableDRL);
        choiceHK_DRL.removeAll();
    }//GEN-LAST:event_choiceKhoa_DRLItemStateChanged

    private void choiceLop_DRLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceLop_DRLItemStateChanged
        // TODO add your handling code here:
        String khoaHoc = ThuatToan.getKhoaHocFromSV(dsLop, choiceLop_DRL.getSelectedItem());
        ThuatToan.addChoiceHocKy(dsHocKy, khoaHoc, ThuatToan.getSoNamHoc(dsKhoaHoc, khoaHoc), choiceHK_DRL);
        choiceHK_DRL.select("Chọn học kỳ");
        Database.deleteTable(jTableDRL);
    }//GEN-LAST:event_choiceLop_DRLItemStateChanged

    private void choiceHK_DRLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceHK_DRLItemStateChanged
        // TODO add your handling code here:
        if(!choiceHK_DRL.getSelectedItem().equals("Chọn học kỳ")){
            Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, choiceLop_DRL.getSelectedItem(), 
                                    ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem()));
            if(ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem()).equals(ThuatToan.getHKXet(dsHocKy))){
                jPanelNutDuyet.setVisible(true);
                jLabelNutDuyet.setVisible(true);
                jPanelNutChamLai.setVisible(true);
                jLabelNutChamLai.setVisible(true);
            }
            else{
                jPanelNutDuyet.setVisible(false);
                jLabelNutDuyet.setVisible(false);
                jPanelNutChamLai.setVisible(false);
                jLabelNutChamLai.setVisible(false);
            }
        }
        
    }//GEN-LAST:event_choiceHK_DRLItemStateChanged

    private void jLabelXoaSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXoaSVMouseClicked
        // TODO add your handling code here:
        
       int chon = jTableSV.getSelectedRow();
       if(chon == -1){
           JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần xóa!");
           return;
       }
        Object cellValue = jTableSV.getValueAt(chon, 1);
        String maSV = cellValue.toString().trim();


        for(DRL drl: dsDRL){
            if(drl.getMSSV().equals(maSV) && drl.isTrangThai() == true){
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa sinh viên đã từng có kết quả xét điểm!");
                return;
            }
        }
        if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn xóa không?") == JOptionPane.YES_OPTION){
            new Thread(() -> {
                int k=0;
                for(SinhVien sv: dsSinhVien){
                    if(sv.getMaSV().equals(maSV)){
                        dsSinhVien.remove(k);
                        break;
                    }
                    k++;
                }
                k=0;
                for(TaiKhoan tk: dsTaiKhoan){
                    if(tk.getTenTK().equals(maSV)){
                        dsTaiKhoan.remove(k);
                        break;
                    }
                    k++;
                }
                Database.saveListTaiKhoanToDB(dsTaiKhoan);
                Database.saveListSinhVienToDB(dsSinhVien);

            }).start();
            Database.deleteOneRow(jTableSV, chon);
        }

    }//GEN-LAST:event_jLabelXoaSVMouseClicked

    private void jLabelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelLogOutMouseClicked

    private void choiceKhoa_LopXetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_LopXetItemStateChanged
        // TODO add your handling code here:
        if(choiceKhoa_LopXet.getSelectedItem().equals("Tất cả")){
            Database.addListLopToTable_HKXet(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc);
        }
        else{
            Database.addListLopToTable_HKXet_Khoa(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, choiceKhoa_LopXet.getSelectedItem(), dsKhoaHoc);
        }
    }//GEN-LAST:event_choiceKhoa_LopXetItemStateChanged

    

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
            java.util.logging.Logger.getLogger(FormHoiDongKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHoiDongKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHoiDongKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHoiDongKhoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new FormHoiDongKhoa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceHK_DRL;
    private java.awt.Choice choiceKhoa_CoVan;
    private java.awt.Choice choiceKhoa_DRL;
    private java.awt.Choice choiceKhoa_Lop;
    private java.awt.Choice choiceKhoa_LopXet;
    private java.awt.Choice choiceKhoa_SV;
    private java.awt.Choice choiceLop_DRL;
    private java.awt.Choice choiceLop_SV;
    private javax.swing.JLabel jLabelChon1;
    private javax.swing.JLabel jLabelChon2;
    private javax.swing.JLabel jLabelChon3;
    private javax.swing.JLabel jLabelChonKhoa_Lop;
    private javax.swing.JLabel jLabelChonKhoa_Lop1;
    private javax.swing.JLabel jLabelChonKhoa_Lop3;
    private javax.swing.JLabel jLabelChonKhoa_Lop4;
    private javax.swing.JLabel jLabelChonKhoa_Lop5;
    private javax.swing.JLabel jLabelChonKhoa_Lop6;
    private javax.swing.JLabel jLabelChonKhoa_Lop7;
    private javax.swing.JLabel jLabelChonKhoa_Lop8;
    private javax.swing.JLabel jLabelChonLop_SV;
    private javax.swing.JLabel jLabelChonLop_SV1;
    private javax.swing.JLabel jLabelChon_SV;
    private javax.swing.JLabel jLabelCloud;
    private javax.swing.JLabel jLabelCoVan;
    private javax.swing.JLabel jLabelCoVanLeft;
    private javax.swing.JLabel jLabelDRL;
    private javax.swing.JLabel jLabelDRLLeft;
    private javax.swing.JLabel jLabelFb;
    private javax.swing.JLabel jLabelHKXet;
    private javax.swing.JLabel jLabelHanCS;
    private javax.swing.JLabel jLabelHanCV;
    private javax.swing.JLabel jLabelHanKhoa;
    private javax.swing.JLabel jLabelHanSV;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelLeft8;
    private javax.swing.JLabel jLabelLeft9;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLop;
    private javax.swing.JLabel jLabelLopLeft;
    private javax.swing.JLabel jLabelNgayBD;
    private javax.swing.JLabel jLabelNutChamLai;
    private javax.swing.JLabel jLabelNutDuyet;
    private javax.swing.JLabel jLabelNutLienHe;
    private javax.swing.JLabel jLabelNutSV;
    private javax.swing.JLabel jLabelNutSuaCoVan;
    private javax.swing.JLabel jLabelNutSuaLop;
    private javax.swing.JLabel jLabelNutThemCoVan;
    private javax.swing.JLabel jLabelNutThemLop;
    private javax.swing.JLabel jLabelNutTieuDeCoVan;
    private javax.swing.JLabel jLabelNutTieuDeKhoa2;
    private javax.swing.JLabel jLabelNutTieuDeTrangChu;
    private javax.swing.JLabel jLabelNutTieuDeTrangChu1;
    private javax.swing.JLabel jLabelNutXoaCoVan;
    private javax.swing.JLabel jLabelNutXoaLop;
    private javax.swing.JLabel jLabelSinhVien;
    private javax.swing.JLabel jLabelSinhVienLeft;
    private javax.swing.JLabel jLabelSuaSV;
    private javax.swing.JLabel jLabelTableTitleCoVan;
    private javax.swing.JLabel jLabelTableTitleLop;
    private javax.swing.JLabel jLabelTableTitleLop1;
    private javax.swing.JLabel jLabelThemSV;
    private javax.swing.JLabel jLabelThreeDots;
    private javax.swing.JLabel jLabelThreedots1;
    private javax.swing.JLabel jLabelThuongHieu;
    private javax.swing.JLabel jLabelTitleSV;
    private javax.swing.JLabel jLabelTrangChu;
    private javax.swing.JLabel jLabelTrangChuLeft;
    private javax.swing.JLabel jLabelXoaSV;
    private javax.swing.JLabel jLabelpanelPtit;
    private javax.swing.JLayeredPane jLayeredPaneMain;
    private javax.swing.JPanel jPanel1;
    private com.raven.swing.PanelBorder jPanelBorderSV;
    private javax.swing.JPanel jPanelCoVan;
    private javax.swing.JPanel jPanelCoVanMain;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelDRL;
    private javax.swing.JPanel jPanelDuyetDiem;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelLogOut;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNullDot;
    private javax.swing.JPanel jPanelNullDot1;
    private javax.swing.JPanel jPanelNullDot2;
    private javax.swing.JPanel jPanelNullDot3;
    private javax.swing.JPanel jPanelNullDot4;
    private javax.swing.JPanel jPanelNutChamLai;
    private javax.swing.JPanel jPanelNutDuyet;
    private javax.swing.JPanel jPanelNutLienHe;
    private javax.swing.JPanel jPanelNutSuaCoVan;
    private javax.swing.JPanel jPanelNutSuaLop;
    private javax.swing.JPanel jPanelNutThemCoVan;
    private javax.swing.JPanel jPanelNutThemLop;
    private javax.swing.JPanel jPanelNutTieuDeCoVan;
    private javax.swing.JPanel jPanelNutTieuDeLop;
    private javax.swing.JPanel jPanelNutTieuDeTrangChu;
    private javax.swing.JPanel jPanelNutTieuDeTrangChu1;
    private javax.swing.JPanel jPanelNutTitleSV;
    private javax.swing.JPanel jPanelNutXoaCoVan;
    private javax.swing.JPanel jPanelNutXoaLop;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JPanel jPanelSinhVienMain;
    private javax.swing.JPanel jPanelSuaSV;
    private com.raven.swing.PanelBorder jPanelTabeDRL;
    private com.raven.swing.PanelBorder jPanelTableCoVan;
    private com.raven.swing.PanelBorder jPanelTableLop;
    private com.raven.swing.PanelBorder jPanelTableLop_Xet;
    private javax.swing.JPanel jPanelThanhTieuDeCoVan;
    private javax.swing.JPanel jPanelThanhTieuDeLop;
    private javax.swing.JPanel jPanelThanhTieuDeTrangChu;
    private javax.swing.JPanel jPanelThanhTieuDeTrangChu1;
    private javax.swing.JPanel jPanelThemSV;
    private javax.swing.JPanel jPanelTitleSV;
    private javax.swing.JPanel jPanelTrangChu;
    private javax.swing.JPanel jPanelTrangChuMain;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPanel jPanelXoaSV;
    private javax.swing.JScrollPane jScrollPaneCoVan;
    private javax.swing.JScrollPane jScrollPaneDRL;
    private javax.swing.JScrollPane jScrollPaneLop;
    private javax.swing.JScrollPane jScrollPaneLopXet;
    private javax.swing.JScrollPane jScrollPaneSV;
    private com.raven.swing.TableCo5Cot jTableCoVan;
    private com.raven.swing.TableCo5Cot jTableDRL;
    private com.raven.swing.TableCo5Cot jTableLop;
    private com.raven.swing.TableCo5Cot jTableLopXet;
    private com.raven.swing.Table jTableSV;
    // End of variables declaration//GEN-END:variables


}
