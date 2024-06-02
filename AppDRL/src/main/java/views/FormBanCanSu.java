/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.Color;

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
import models.TieuChi;

/**
 *
 * @author Dat
 * 
 * 
 */




public final class FormBanCanSu extends javax.swing.JFrame {

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
        private ArrayList <TieuChi> dsTieuChi = null;
        private Khoa khoa;
        private JFrame frame;
        private SinhVien sv;
        private final ArrayList<JLabel> dsLabel = new ArrayList<>();
        private Lop lop;
        private TaiKhoan tk;
        //private final static Color textColor = new Color(0, 0, 139);
        private final Color white = Color.WHITE;
        private final Color hoveColor = new Color(255,204,102);//màu đậm
        private final  Color hoveColor2 = new Color(255, 228, 181);//màu lợt
        private final Color buttonHoverColor = new Color(30,115,190);
        private final Color buttonColor = new Color(221,51,51);
    // Màu của viền
        
    public FormBanCanSu() {
        initComponents();
        suKienMenu();
    }
    
    //covan
    public FormBanCanSu(JFrame frame, Khoa khoa,  SinhVien sv, Lop lop, TaiKhoan tk, ArrayList <Khoa>dsKhoa, ArrayList <CoVan>dsCoVan, ArrayList<HocKy>dsHocKy,
            ArrayList<KhoaHoc>dsKhoaHoc, ArrayList<Lop> dsLop,  ArrayList<ChucVu> dsChucVu,  ArrayList<TaiKhoan>dsTaiKhoan,
            ArrayList<SinhVien>dsSinhVien, ArrayList <ThongBao> dsThongBao, ArrayList<DRL> dsDRL, ArrayList<TieuChi> dsTieuChi) {
        this.dsKhoa = dsKhoa;
        this.dsCoVan = dsCoVan;
        this.dsHocKy = dsHocKy;
        this.khoa = khoa;
        this.tk = tk;
        this.frame = frame;
        this.lop = lop;
        this.dsKhoaHoc = dsKhoaHoc;
        this.dsLop = dsLop;
        this.dsTieuChi = dsTieuChi;
        this.dsTaiKhoan = dsTaiKhoan;
        this.dsSinhVien = dsSinhVien;
        this.dsChucVu = dsChucVu;
        this.dsThongBao = dsThongBao;
        this.dsDRL = dsDRL;
        this.sv = sv;
        initComponents();
        suKienMenu();
    }
    
    //Xử lý khi click vào menu nào thì bảng của menu đó có dữ liệu
    public void addTable(String text){

        if(text.contains("ĐIỂM CỦA BẠN")){
            DRLCaNhan();
        }

        else if(text.contains("TÀI KHOẢN")){
            TaiKhoan();
        }
        else if(text.contains("ĐÁNH GIÁ ĐIỂM")){
            DRL();
        }
        else {
            moTrangChu();
        }
    }    
    
    public void TaiKhoan(){
        jLabelMSV.setText(sv.getMaSV());
        jLabelHoTen.setText(sv.getHoTen());
        jLabelLop_TK.setText(sv.getLop());
        jLabelChucVu.setText(ThuatToan.doiMaChucVuThanhTen(sv.getChucVu(), dsChucVu));
        jLabelGioiTinh.setText(ThuatToan.doiBoolToGioiTinh(Boolean.toString(sv.isGioiTinh())));
        jLabelNgaySinh.setText(ThuatToan.doiNgay(sv.getNgaySinh()));
        jLabelSdt.setText(sv.getSdt());
        jLabelEmail.setText(sv.getEmail().toLowerCase());
        jLabelQueQuan.setText(sv.getQueQuan());
        jLabelDiaChi.setText(sv.getDiaChi());
        jLabelTenDN.setText(sv.getMaSV());
        jLabelMatKhau.setText(ThuatToan.anMatKhau(tk.getMatKhau()));
    }
    
    public void DRL(){
        new Thread(() -> {
            Database.saveHocKyToList(dsHocKy);
            Database.saveDRLToList(dsDRL);
            choiceKhoa_DRL.removeAll();
            choiceKhoa_DRL.add(ThuatToan.doiMaKhoaThanhTenKhoa(khoa.getMaKhoa(), dsKhoa));
            choiceLop_DRL.removeAll();
            choiceLop_DRL.add(sv.getLop());
            String hk = ThuatToan.getHKXet(dsHocKy);
            float soNamHoc = ThuatToan.getSoNamHoc(dsKhoaHoc, lop.getMaKhoaHoc());
            ThuatToan.addChoiceHocKy(dsHocKy, lop.getMaKhoaHoc(), soNamHoc, choiceHK_DRL);
            choiceHK_DRL.select(ThuatToan.doiMaHKSangHK(hk));
            Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, lop.getLop(), hk);
            if(choiceHK_DRL.getSelectedItem().equals(ThuatToan.doiMaHKSangHK(hk))){
                jPanelNutChamLai.setVisible(true);
                jLabelNutChamLai.setVisible(true);
            }
        }).start();
    }
    
    public void DRLCaNhan(){
        new Thread(() -> {
            Database.saveDRLToList(dsDRL);
            String hk = ThuatToan.getHKXet(dsHocKy);
            hk = Database.chuyenMaHocKy(hk);
            jLabelHKXet_DRL.setText("Học kỳ đang xét là: "+hk);
            Database.addListDRLToTable_SV_HK(dsDRL, sv, jTableDRLCaNhan);
        }).start();
    }
    
    public void moTrangChu(){
        new Thread(() -> {
            Database.saveLopToList(dsLop);
            Database.saveThongBaoToList(dsThongBao);
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
        }).start();
    }
        
        // Sử dụng màu này trong ứng dụng của bạn
    
    //Khi chọn vào menu nào thì menu đó có màu vàng còn tất cả còn lại reset màu trắng    
    public void viewMenuClick(JPanel main, JPanel p2, JPanel p3, JPanel p4){
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
        

        
    }    
    // rê vào menu nào thì menu đó có màu vàng lợt, trừ menu được chọn
    public void viewMenuHover(JPanel main, JPanel p2, JPanel p3, JPanel p4){
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


    }
    // rê ra khỏi menu thì menu màu trắng
    public void viewExit(JPanel main, JPanel p2, JPanel p3, JPanel p4){
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
        EnterEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft, jPanelSinhVien,  jPanelLop, jPanelDRL);
        EnterEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelLop, jPanelSinhVien, jPanelTrangChu);
        EnterEvent(jPanelLop, jLabelLop, jLabelLopLeft,  jPanelDRL, jPanelSinhVien, jPanelTrangChu);
        EnterEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft,  jPanelLop, jPanelDRL, jPanelTrangChu);
    }
    
    public void clickMenu(){
        //Kích vào menu nào thì đó hiện màu vàng đậm
       ClickEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft,  jPanelLop,  jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelLop, jLabelLop, jLabelLopLeft,  jPanelDRL,  jPanelSinhVien, jPanelTrangChu);
       ClickEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelLop,  jPanelDRL, jPanelTrangChu);
       ClickEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft,jPanelSinhVien, jPanelLop, jPanelDRL);
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

        buttonHoverEvent(jLabelDoiTT, jPanelDoiTT);

        buttonHoverEvent(jLabelNutLienHe, jPanelNutLienHe);
        //nút xóa

        buttonHoverEvent(jLabelDoiTT, jPanelDoiTT);
        buttonHoverEvent(jLabelNutXoaLop, jPanelNutXoaLop);

        //nút sử
        buttonHoverEvent(jLabelDoiMK, jPanelDoiMK);

    }
    
    public void openFromMenu(){
        ClickMenuEvent(jPanelDRL, jLabelDRL, jLabelDRLLeft, jPanelChamDiem,   jPanelDRLCaNhan,  jPanelTTCN, jPanelTrangChuMain);
        ClickMenuEvent(jPanelLop, jLabelLop, jLabelLopLeft, jPanelDRLCaNhan,   jPanelChamDiem,  jPanelTTCN, jPanelTrangChuMain);
        ClickMenuEvent(jPanelSinhVien, jLabelSinhVien, jLabelSinhVienLeft, jPanelTTCN,   jPanelDRLCaNhan,  jPanelChamDiem, jPanelTrangChuMain);       
        ClickMenuEvent(jPanelTrangChu, jLabelTrangChu, jLabelTrangChuLeft,jPanelTrangChuMain, jPanelTTCN,  jPanelDRLCaNhan,  jPanelChamDiem); 
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
        hienManHinhCanMo(jPanelTrangChu, jPanelDRLCaNhan, jPanelTTCN, jPanelChamDiem);
        moTrangChu();
        dsLabel.add(jLabelHoTen);
        dsLabel.add(jLabelSdt);
        dsLabel.add(jLabelGioiTinh);
        dsLabel.add(jLabelNgaySinh);

        dsLabel.add(jLabelQueQuan);
        dsLabel.add(jLabelDiaChi);
        dangXuat(jPanelLogOut, jLabelLogOut, jLabelLeft9, this, frame);
    }
    
    public void anMenu(JPanel main, JLabel label, JLabel icon){
        main.setVisible(false);
        label.setVisible(false);
        icon.setVisible(false);
    }
    
    
    
    //Xử lý các sự kiện click
    public void ClickEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4){
        
        main1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2, p3, p4);
            }
        });
        
    }
    
    
    
    //kích vô menu nào hiện màn hình đó
    //jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, PanelXemDiemMain
    public void ClickMenuEvent(JPanel main, JLabel main2, JLabel main3, JPanel main1, JPanel p2, JPanel p3, JPanel p4){
        
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4);
                addTable(main2.getText());
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4);
                addTable(main2.getText());
            }
        });
        
        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2, p3, p4);
                addTable(main2.getText());
            }
        });
        
    }
    
    public void EnterEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2, JPanel p3, JPanel p4){
        
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelKhoa2
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4);
                }
            });

            // Bắt sự kiện khi rê chuột vào jLabelLeft
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    viewMenuHover(main1, p2, p3, p4);
                }
            });
            
            main1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4);
                }
            });
            
            main2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4);
                }
            });
            
            main3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    viewExit(main1, p2, p3, p4);
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
    
    public void hienManHinhCanMo(JPanel main, JPanel p2, JPanel p3, JPanel p4){
        main.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
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
        jPanelSinhVien = new javax.swing.JPanel();
        jLabelSinhVien = new javax.swing.JLabel();
        jLabelSinhVienLeft = new javax.swing.JLabel();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jLabelLopLeft = new javax.swing.JLabel();
        jPanelDRL = new javax.swing.JPanel();
        jLabelDRL = new javax.swing.JLabel();
        jLabelDRLLeft = new javax.swing.JLabel();
        jPanelNullDot1 = new javax.swing.JPanel();
        jLabelThreedots1 = new javax.swing.JLabel();
        jPanelNullDot5 = new javax.swing.JPanel();
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
        jPanelDRLCaNhan = new javax.swing.JPanel();
        jPanelThanhTieuDeLop = new javax.swing.JPanel();
        jPanelNutTieuDeLop = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeKhoa2 = new javax.swing.JLabel();
        jPanelNutXoaLop = RoundedPanel.createRoundedPanel();
        jLabelNutXoaLop = new javax.swing.JLabel();
        jScrollPaneLop = new javax.swing.JScrollPane();
        jPanelTabeDRLCaNhan = new com.raven.swing.PanelBorder();
        jScrollPaneDRLCaNhan = new javax.swing.JScrollPane();
        jTableDRLCaNhan = new com.raven.swing.TableDRLCaNhan();
        jLabelTableTitleLop2 = new javax.swing.JLabel();
        jLabelHKXet_DRL = new javax.swing.JLabel();
        jPanelChamDiem = new javax.swing.JPanel();
        jPanelThanhTieuDeTrangChu = new javax.swing.JPanel();
        jPanelNutTieuDeTrangChu = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDeTrangChu = new javax.swing.JLabel();
        jPanelNutChamLai = RoundedPanel.createRoundedPanel();
        jLabelNutChamLai = new javax.swing.JLabel();
        jPanelTabeDRL = new com.raven.swing.PanelBorder();
        jScrollPaneDRL = new javax.swing.JScrollPane();
        jTableDRL = new com.raven.swing.TableDRL();
        choiceKhoa_DRL = new java.awt.Choice();
        jLabelChon2 = new javax.swing.JLabel();
        jLabelChon3 = new javax.swing.JLabel();
        jLabelChonLop_SV1 = new javax.swing.JLabel();
        choiceLop_DRL = new java.awt.Choice();
        choiceHK_DRL = new java.awt.Choice();
        jPanelTTCN = new javax.swing.JPanel();
        jPanelTitleSV = RoundedPanel.createRoundedPanel();
        jPanelNutTitleSV = RoundedPanel.createRoundedPanel();
        jLabelNutSV = new javax.swing.JLabel();
        jPanel2 = RoundedPanel.createRoundedPanel();
        jLabelChonKhoa_Lop10 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop11 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop12 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop14 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop15 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop16 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop17 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop18 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop19 = new javax.swing.JLabel();
        jLabelChonKhoa_Lop20 = new javax.swing.JLabel();
        jLabelMSV = new javax.swing.JLabel();
        jLabelHoTen = new javax.swing.JLabel();
        jLabelLop_TK = new javax.swing.JLabel();
        jLabelChucVu = new javax.swing.JLabel();
        jLabelGioiTinh = new javax.swing.JLabel();
        jLabelNgaySinh = new javax.swing.JLabel();
        jLabelSdt = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelDiaChi = new javax.swing.JLabel();
        jLabelQueQuan = new javax.swing.JLabel();
        jPanel3 = RoundedPanel.createRoundedPanel();
        jLabelChonKhoa_Lop9 = new javax.swing.JLabel();
        jPanel4 = RoundedPanel.createRoundedPanel();
        jLabelChonKhoa_Lop13 = new javax.swing.JLabel();
        jPanel5 = RoundedPanel.createRoundedPanel();
        jLabelChonKhoa_Lop31 = new javax.swing.JLabel();
        jLabelTenDN = new javax.swing.JLabel();
        jLabelChonKhoa_Lop33 = new javax.swing.JLabel();
        jLabelMatKhau = new javax.swing.JLabel();
        jPanelDoiTT = RoundedPanel.createRoundedPanel();
        jLabelDoiTT = new javax.swing.JLabel();
        jPanelDoiMK = RoundedPanel.createRoundedPanel();
        jLabelDoiMK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ban cán sự lớp");
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

        jPanelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelSinhVien.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSinhVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSinhVien.setForeground(new java.awt.Color(227, 70, 34));
        jLabelSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/acc.png"))); // NOI18N
        jLabelSinhVien.setText("TÀI KHOẢN");
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

        jPanelLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelLop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLop.setForeground(new java.awt.Color(227, 70, 34));
        jLabelLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redpoint.png"))); // NOI18N
        jLabelLop.setText("ĐIỂM CỦA BẠN");

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

        jPanelDRL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDRL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelDRL.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDRL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDRL.setForeground(new java.awt.Color(227, 70, 34));
        jLabelDRL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redtick.png"))); // NOI18N
        jLabelDRL.setText("ĐÁNH GIÁ ĐIỂM");
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
            .addComponent(jLabelThreedots1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );
        jPanelNullDot1Layout.setVerticalGroup(
            jPanelNullDot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNullDot1Layout.createSequentialGroup()
                .addComponent(jLabelThreedots1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jPanelMenu.add(jPanelNullDot1);

        jPanelNullDot5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelNullDot5Layout = new javax.swing.GroupLayout(jPanelNullDot5);
        jPanelNullDot5.setLayout(jPanelNullDot5Layout);
        jPanelNullDot5Layout.setHorizontalGroup(
            jPanelNullDot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
        jPanelNullDot5Layout.setVerticalGroup(
            jPanelNullDot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanelMenu.add(jPanelNullDot5);

        jPanelNullDot4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNullDot4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelNullDot4Layout = new javax.swing.GroupLayout(jPanelNullDot4);
        jPanelNullDot4.setLayout(jPanelNullDot4Layout);
        jPanelNullDot4Layout.setHorizontalGroup(
            jPanelNullDot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
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
            .addGap(0, 211, Short.MAX_VALUE)
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
            .addGap(0, 211, Short.MAX_VALUE)
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
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

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
        jPanelTableLop_Xet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelTableLop_Xet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTableTitleLop1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleLop1.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleLop1.setText("DS lớp thuộc khoa đang trong thời gian xét");
        jPanelTableLop_Xet.add(jLabelTableTitleLop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jScrollPaneLopXet.setBorder(null);
        jScrollPaneLopXet.setVerticalScrollBar(new ScrollBar());
        jScrollPaneLopXet.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneLopXet.getViewport().setBackground(Color.WHITE);
        JPanel p24 = new JPanel();
        p24.setBackground(Color.WHITE);
        jScrollPaneLop.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p24);

        jTableLopXet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

        jPanelTableLop_Xet.add(jScrollPaneLopXet, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 47, 723, 380));

        choiceKhoa_LopXet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        choiceKhoa_LopXet.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        choiceKhoa_LopXet.setPreferredSize(new java.awt.Dimension(28, 50));
        choiceKhoa_LopXet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceKhoa_LopXetItemStateChanged(evt);
            }
        });
        jPanelTableLop_Xet.add(choiceKhoa_LopXet, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 13, 207, 20));

        jLabelChonKhoa_Lop1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop1.setText("Khoa:");
        jPanelTableLop_Xet.add(jLabelChonKhoa_Lop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 45, 30));

        jPanelTrangChuMain.add(jPanelTableLop_Xet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 440));

        jLayeredPaneMain.add(jPanelTrangChuMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanelDRLCaNhan.setPreferredSize(new java.awt.Dimension(684, 505));
        jPanelDRLCaNhan.setRequestFocusEnabled(false);
        jPanelDRLCaNhan.setVerifyInputWhenFocusTarget(false);
        jPanelDRLCaNhan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeLop.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeLop.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeLop.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeKhoa2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeKhoa2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeKhoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitepoint.png"))); // NOI18N
        jLabelNutTieuDeKhoa2.setText("Điểm rèn luyện của bạn");
        jLabelNutTieuDeKhoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutTieuDeKhoa2.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTieuDeLopLayout = new javax.swing.GroupLayout(jPanelNutTieuDeLop);
        jPanelNutTieuDeLop.setLayout(jPanelNutTieuDeLopLayout);
        jPanelNutTieuDeLopLayout.setHorizontalGroup(
            jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTieuDeLopLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNutTieuDeLopLayout.setVerticalGroup(
            jPanelNutTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutTieuDeKhoa2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanelNutXoaLop.setBackground(new java.awt.Color(221, 51, 51));
        jPanelNutXoaLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNutXoaLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutXoaLop.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutXoaLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitewrite.png"))); // NOI18N
        jLabelNutXoaLop.setText("Chấm điểm");
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
                .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
        );
        jPanelNutXoaLopLayout.setVerticalGroup(
            jPanelNutXoaLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeLopLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeLop);
        jPanelThanhTieuDeLop.setLayout(jPanelThanhTieuDeLopLayout);
        jPanelThanhTieuDeLopLayout.setHorizontalGroup(
            jPanelThanhTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeLopLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                .addComponent(jPanelNutXoaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeLopLayout.setVerticalGroup(
            jPanelThanhTieuDeLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutXoaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThanhTieuDeLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPaneLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelDRLCaNhan.add(jPanelThanhTieuDeLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelTabeDRLCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTabeDRLCaNhan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jScrollPaneDRLCaNhan.setBorder(null);
        jScrollPaneDRLCaNhan.setVerticalScrollBar(new ScrollBar());
        jScrollPaneDRLCaNhan.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPaneDRLCaNhan.getViewport().setBackground(Color.WHITE);
        JPanel p25 = new JPanel();
        p25.setBackground(Color.WHITE);
        jScrollPaneDRLCaNhan.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p25);

        jTableDRLCaNhan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTableDRLCaNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Học kỳ", "Mã sinh viên", "  Họ và tên", "ĐSV", "ĐCS", "ĐCV", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDRLCaNhan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTableDRLCaNhan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDRLCaNhan.setShowGrid(true);
        jTableDRLCaNhan.setShowVerticalLines(false);
        jScrollPaneDRLCaNhan.setViewportView(jTableDRLCaNhan);

        jLabelTableTitleLop2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelTableTitleLop2.setForeground(new java.awt.Color(127, 127, 127));
        jLabelTableTitleLop2.setText("Điểm rèn luyện các học kỳ");

        jLabelHKXet_DRL.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelHKXet_DRL.setText("Học kỳ đang xét là: II 2023-2024");

        javax.swing.GroupLayout jPanelTabeDRLCaNhanLayout = new javax.swing.GroupLayout(jPanelTabeDRLCaNhan);
        jPanelTabeDRLCaNhan.setLayout(jPanelTabeDRLCaNhanLayout);
        jPanelTabeDRLCaNhanLayout.setHorizontalGroup(
            jPanelTabeDRLCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabeDRLCaNhanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPaneDRLCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanelTabeDRLCaNhanLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelTableTitleLop2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelHKXet_DRL)
                .addGap(23, 23, 23))
        );
        jPanelTabeDRLCaNhanLayout.setVerticalGroup(
            jPanelTabeDRLCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabeDRLCaNhanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTabeDRLCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTableTitleLop2)
                    .addComponent(jLabelHKXet_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDRLCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanelDRLCaNhan.add(jPanelTabeDRLCaNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 756, 490));

        jLayeredPaneMain.add(jPanelDRLCaNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelChamDiem.setPreferredSize(new java.awt.Dimension(804, 612));
        jPanelChamDiem.setRequestFocusEnabled(false);
        jPanelChamDiem.setVerifyInputWhenFocusTarget(false);
        jPanelChamDiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelThanhTieuDeTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelThanhTieuDeTrangChu.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTieuDeTrangChu.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutTieuDeTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutTieuDeTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutTieuDeTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitetieuchi.png"))); // NOI18N
        jLabelNutTieuDeTrangChu.setText("Chấm điểm sinh viên");
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
        jLabelNutChamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitepoint.png"))); // NOI18N
        jLabelNutChamLai.setText("Chấm điểm");
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
                .addComponent(jLabelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );
        jPanelNutChamLaiLayout.setVerticalGroup(
            jPanelNutChamLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelThanhTieuDeTrangChuLayout = new javax.swing.GroupLayout(jPanelThanhTieuDeTrangChu);
        jPanelThanhTieuDeTrangChu.setLayout(jPanelThanhTieuDeTrangChuLayout);
        jPanelThanhTieuDeTrangChuLayout.setHorizontalGroup(
            jPanelThanhTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThanhTieuDeTrangChuLayout.createSequentialGroup()
                .addComponent(jPanelNutTieuDeTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                .addComponent(jPanelNutChamLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelThanhTieuDeTrangChuLayout.setVerticalGroup(
            jPanelThanhTieuDeTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTieuDeTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNutChamLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelChamDiem.add(jPanelThanhTieuDeTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanelTabeDRL.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTabeDRL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

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
        jLabelChon3.setText("Khoa: ");

        jLabelChonLop_SV1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonLop_SV1.setText("Lớp: ");

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
                        .addComponent(choiceKhoa_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelChonLop_SV1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choiceLop_DRL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanelChamDiem.add(jPanelTabeDRL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 760, 520));

        jLayeredPaneMain.add(jPanelChamDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelTTCN.setPreferredSize(new java.awt.Dimension(574, 409));
        jPanelTTCN.setRequestFocusEnabled(false);
        jPanelTTCN.setVerifyInputWhenFocusTarget(false);
        jPanelTTCN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitleSV.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitleSV.setPreferredSize(new java.awt.Dimension(770, 34));

        jPanelNutTitleSV.setBackground(new java.awt.Color(221, 51, 51));

        jLabelNutSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNutSV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNutSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whiteacc.png"))); // NOI18N
        jLabelNutSV.setText("Tài khoản");
        jLabelNutSV.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabelNutSV.setPreferredSize(new java.awt.Dimension(32, 16));

        javax.swing.GroupLayout jPanelNutTitleSVLayout = new javax.swing.GroupLayout(jPanelNutTitleSV);
        jPanelNutTitleSV.setLayout(jPanelNutTitleSVLayout);
        jPanelNutTitleSVLayout.setHorizontalGroup(
            jPanelNutTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutTitleSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNutSV, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutTitleSVLayout.setVerticalGroup(
            jPanelNutTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNutSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelTitleSVLayout = new javax.swing.GroupLayout(jPanelTitleSV);
        jPanelTitleSV.setLayout(jPanelTitleSVLayout);
        jPanelTitleSVLayout.setHorizontalGroup(
            jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleSVLayout.createSequentialGroup()
                .addComponent(jPanelNutTitleSV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(624, Short.MAX_VALUE))
        );
        jPanelTitleSVLayout.setVerticalGroup(
            jPanelTitleSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNutTitleSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTTCN.add(jPanelTitleSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelChonKhoa_Lop10.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop10.setText("Mã số sinh viên:");

        jLabelChonKhoa_Lop11.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop11.setText("Lớp:");

        jLabelChonKhoa_Lop12.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop12.setText("Họ và tên:");

        jLabelChonKhoa_Lop14.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop14.setText("Chức vụ:");

        jLabelChonKhoa_Lop15.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop15.setText("Giới tính:");

        jLabelChonKhoa_Lop16.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop16.setText("Ngày sinh:");

        jLabelChonKhoa_Lop17.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop17.setText("Quê quán:");

        jLabelChonKhoa_Lop18.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop18.setText("Email:");

        jLabelChonKhoa_Lop19.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop19.setText("Số điện thoại:");

        jLabelChonKhoa_Lop20.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop20.setText("Địa chỉ:");

        jLabelMSV.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelMSV.setText("N21DCAT010");

        jLabelHoTen.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelHoTen.setText("Ngô Văn Đạt");

        jLabelLop_TK.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelLop_TK.setText("D21CQAT01-N");

        jLabelChucVu.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelChucVu.setText("Sinh viên");

        jLabelGioiTinh.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelGioiTinh.setText("Nam");

        jLabelNgaySinh.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelNgaySinh.setText("05-06-2003");

        jLabelSdt.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelSdt.setText("0352752950");

        jLabelEmail.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelEmail.setText("n21dcat010@student.ptithcm.edu.vn");

        jLabelDiaChi.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelDiaChi.setText("Thủ Đức");

        jLabelQueQuan.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelQueQuan.setText("Tây Hòa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelChonKhoa_Lop11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLop_TK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelChonKhoa_Lop19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelChonKhoa_Lop15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelChonKhoa_Lop10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelMSV, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelChonKhoa_Lop16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelChonKhoa_Lop14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelChonKhoa_Lop12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelChonKhoa_Lop18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelChonKhoa_Lop17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQueQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelChonKhoa_Lop20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelChonKhoa_Lop12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop11, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabelChonKhoa_Lop14, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabelLop_TK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelChonKhoa_Lop15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelChonKhoa_Lop16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelChonKhoa_Lop18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelChonKhoa_Lop19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQueQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106))
        );

        jPanelTTCN.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 755, 210));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.setForeground(new java.awt.Color(221, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(755, 30));

        jLabelChonKhoa_Lop9.setBackground(new java.awt.Color(221, 51, 51));
        jLabelChonKhoa_Lop9.setFont(new java.awt.Font("Segoe UI Variable", 1, 16)); // NOI18N
        jLabelChonKhoa_Lop9.setForeground(new java.awt.Color(255, 255, 255));
        jLabelChonKhoa_Lop9.setText(" Thông tin cá nhân:");
        jLabelChonKhoa_Lop9.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelChonKhoa_Lop9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 600, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelChonKhoa_Lop9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelTTCN.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 755, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabelChonKhoa_Lop13.setBackground(new java.awt.Color(221, 51, 51));
        jLabelChonKhoa_Lop13.setFont(new java.awt.Font("Segoe UI Variable", 1, 16)); // NOI18N
        jLabelChonKhoa_Lop13.setForeground(new java.awt.Color(255, 255, 255));
        jLabelChonKhoa_Lop13.setText(" Tài khoản:");
        jLabelChonKhoa_Lop13.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabelChonKhoa_Lop13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 661, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelChonKhoa_Lop13, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanelTTCN.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 755, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabelChonKhoa_Lop31.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop31.setText("Tên đăng nhập:");

        jLabelTenDN.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        jLabelTenDN.setText("N21DCAT010");

        jLabelChonKhoa_Lop33.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabelChonKhoa_Lop33.setText("Mật khẩu:");

        jLabelMatKhau.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabelMatKhau.setText("**********");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelChonKhoa_Lop31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelChonKhoa_Lop33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChonKhoa_Lop31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTenDN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelChonKhoa_Lop33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );

        jPanelTTCN.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 755, 90));

        jPanelDoiTT.setBackground(new java.awt.Color(221, 51, 51));
        jPanelDoiTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelDoiTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDoiTT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoiTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitepoint.png"))); // NOI18N
        jLabelDoiTT.setText("Cập nhật thông tin");
        jLabelDoiTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDoiTT.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelDoiTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoiTTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDoiTTLayout = new javax.swing.GroupLayout(jPanelDoiTT);
        jPanelDoiTT.setLayout(jPanelDoiTTLayout);
        jPanelDoiTTLayout.setHorizontalGroup(
            jPanelDoiTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDoiTTLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jLabelDoiTT, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelDoiTTLayout.setVerticalGroup(
            jPanelDoiTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDoiTT, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanelTTCN.add(jPanelDoiTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jPanelDoiMK.setBackground(new java.awt.Color(221, 51, 51));
        jPanelDoiMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDoiMK.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/whitechange.png"))); // NOI18N
        jLabelDoiMK.setText("Đổi mật khẩu");
        jLabelDoiMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDoiMK.setPreferredSize(new java.awt.Dimension(32, 16));
        jLabelDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoiMKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDoiMKLayout = new javax.swing.GroupLayout(jPanelDoiMK);
        jPanelDoiMK.setLayout(jPanelDoiMKLayout);
        jPanelDoiMKLayout.setHorizontalGroup(
            jPanelDoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDoiMKLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabelDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDoiMKLayout.setVerticalGroup(
            jPanelDoiMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDoiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jPanelTTCN.add(jPanelDoiMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, -1, -1));

        jLayeredPaneMain.add(jPanelTTCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 612));

        jPanelView.add(jLayeredPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 784, 600));

        getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    


    

    private void jLabelNutXoaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutXoaLopMouseClicked

        Database.saveThongBaoToList(dsThongBao);
        
        int chon = jTableDRLCaNhan.getSelectedRow();
        if(chon==-1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn học kỳ cần đánh giá!");
            return;
        }
        
        Object cell = jTableDRLCaNhan.getValueAt(chon, 6);
        Object cell2 = jTableDRLCaNhan.getValueAt(chon, 3);
        if(cell.toString().equals("Đã duyệt") ){
            JOptionPane.showMessageDialog(rootPane, "Bảng điểm đã được duyệt!");
            return;
        }
        if(!ThuatToan.kTraTGXetSV(dsThongBao, dsHocKy)){
            JOptionPane.showMessageDialog(rootPane, "Không trong thời gian xét duyệt!");
            return;
        }
        if(!cell2.toString().equals(("0"))){
            JOptionPane.showMessageDialog(rootPane, "Bạn đã đánh giá điểm học kỳ này!");
            return;
        }
        new Thread(() -> {
            Database.saveTieuChiToList(dsTieuChi);
            String hk = ThuatToan.getHKXet(dsHocKy);
            new FormChamDiem(dsDRL, dsTieuChi, hk, sv.getMaSV(), jTableDRLCaNhan, chon, "SV").setVisible(true);
        }).start();
        
        
    }//GEN-LAST:event_jLabelNutXoaLopMouseClicked

    private void jLabelDoiTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiTTMouseClicked
         try {
             new FormSuaSinhVien(dsSinhVien, sv, dsLabel).setVisible(true);
         } catch (ParseException ex) {
             Logger.getLogger(FormBanCanSu.class.getName()).log(Level.SEVERE, null, ex);
         }
         TaiKhoan();
    }//GEN-LAST:event_jLabelDoiTTMouseClicked

    private void jLabelNutChamLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNutChamLaiMouseClicked
        // TODO add your handling code here:
        Database.saveThongBaoToList(dsThongBao);
        int chon = jTableDRL.getSelectedRow();
        if(chon == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sinh viên cần đánh giá!");
            return;
        }
        if(!ThuatToan.kTraTGXetCS(dsThongBao, dsHocKy)){
            JOptionPane.showMessageDialog(rootPane, "Không trong thời gian xét duyệt!");
            return;
        }
        String duyet = jTableDRL.getValueAt(chon, 6).toString();
        if(duyet.equals("Đã duyệt")){
            JOptionPane.showMessageDialog(rootPane, "Bảng điểm này đã duyệt!");
            return;
        }
        String diemSV = jTableDRL.getValueAt(chon, 3).toString();
        if(diemSV.equals("0")){
            JOptionPane.showMessageDialog(rootPane, "Sinh viên này chưa tự đánh giá!");
            return;
        }
        String diemCS = jTableDRL.getValueAt(chon, 4).toString();
        if(!diemCS.equals("0")){
            JOptionPane.showMessageDialog(rootPane, "Đã đánh giá điểm sinh viên này!");
            return;
        }
        String msv = jTableDRL.getValueAt(chon, 1).toString();
        if(msv.equals(sv.getMaSV())){
            JOptionPane.showMessageDialog(rootPane, "Không thể tự đánh giá điểm của bản thân ở cột này!");
            return;
        }
        new Thread(() -> {
            Database.saveTieuChiToDB(dsTieuChi);
            String hk = ThuatToan.getHKXet(dsHocKy);
            new FormChamDiem(dsDRL, dsTieuChi, hk, msv, jTableDRL, chon, "CS").setVisible(true);
        }).start();
            
        
    }//GEN-LAST:event_jLabelNutChamLaiMouseClicked

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
        new Thread(() -> {
            if(!choiceHK_DRL.getSelectedItem().equals("Chọn học kỳ")){
                Database.addListDRLToTable(dsDRL, dsSinhVien, jTableDRL, choiceLop_DRL.getSelectedItem(), 
                                        ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem()));
                if(ThuatToan.doiHKSangMaHK(choiceHK_DRL.getSelectedItem()).equals(ThuatToan.getHKXet(dsHocKy))){

                    jPanelNutChamLai.setVisible(true);
                    jLabelNutChamLai.setVisible(true);
                }
                else{

                    jPanelNutChamLai.setVisible(false);
                    jLabelNutChamLai.setVisible(false);
                }
            }
        }).start();
        
    }//GEN-LAST:event_choiceHK_DRLItemStateChanged

    private void jLabelLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogOutMouseClicked

    }//GEN-LAST:event_jLabelLogOutMouseClicked

    private void choiceKhoa_LopXetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceKhoa_LopXetItemStateChanged
        // TODO add your handling code here:
        new Thread(() -> {
            Database.saveKhoaToList(dsKhoa);
            Database.saveLopToList(dsLop);
            Database.saveCoVanToList(dsCoVan);
            if(choiceKhoa_LopXet.getSelectedItem().equals("Tất cả")){
                Database.addListLopToTable_HKXet(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, dsKhoaHoc);
            }
            else{
                Database.addListLopToTable_HKXet_Khoa(dsLop, jTableLopXet, dsKhoa, dsCoVan, dsHocKy, choiceKhoa_LopXet.getSelectedItem(), dsKhoaHoc);
            }
        }).start();
    }//GEN-LAST:event_choiceKhoa_LopXetItemStateChanged

    private void jLabelDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMKMouseClicked
        // TODO add your handling code here:
        new FormDoiMatKhau(dsTaiKhoan, sv.getMaSV()).setVisible(true);
    }//GEN-LAST:event_jLabelDoiMKMouseClicked

    

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
            java.util.logging.Logger.getLogger(FormBanCanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBanCanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBanCanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBanCanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormBanCanSu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceHK_DRL;
    private java.awt.Choice choiceKhoa_DRL;
    private java.awt.Choice choiceKhoa_LopXet;
    private java.awt.Choice choiceLop_DRL;
    private javax.swing.JLabel jLabelChon2;
    private javax.swing.JLabel jLabelChon3;
    private javax.swing.JLabel jLabelChonKhoa_Lop1;
    private javax.swing.JLabel jLabelChonKhoa_Lop10;
    private javax.swing.JLabel jLabelChonKhoa_Lop11;
    private javax.swing.JLabel jLabelChonKhoa_Lop12;
    private javax.swing.JLabel jLabelChonKhoa_Lop13;
    private javax.swing.JLabel jLabelChonKhoa_Lop14;
    private javax.swing.JLabel jLabelChonKhoa_Lop15;
    private javax.swing.JLabel jLabelChonKhoa_Lop16;
    private javax.swing.JLabel jLabelChonKhoa_Lop17;
    private javax.swing.JLabel jLabelChonKhoa_Lop18;
    private javax.swing.JLabel jLabelChonKhoa_Lop19;
    private javax.swing.JLabel jLabelChonKhoa_Lop20;
    private javax.swing.JLabel jLabelChonKhoa_Lop3;
    private javax.swing.JLabel jLabelChonKhoa_Lop31;
    private javax.swing.JLabel jLabelChonKhoa_Lop33;
    private javax.swing.JLabel jLabelChonKhoa_Lop4;
    private javax.swing.JLabel jLabelChonKhoa_Lop5;
    private javax.swing.JLabel jLabelChonKhoa_Lop6;
    private javax.swing.JLabel jLabelChonKhoa_Lop7;
    private javax.swing.JLabel jLabelChonKhoa_Lop8;
    private javax.swing.JLabel jLabelChonKhoa_Lop9;
    private javax.swing.JLabel jLabelChonLop_SV1;
    private javax.swing.JLabel jLabelChucVu;
    private javax.swing.JLabel jLabelCloud;
    private javax.swing.JLabel jLabelDRL;
    private javax.swing.JLabel jLabelDRLLeft;
    private javax.swing.JLabel jLabelDiaChi;
    private javax.swing.JLabel jLabelDoiMK;
    private javax.swing.JLabel jLabelDoiTT;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFb;
    private javax.swing.JLabel jLabelGioiTinh;
    private javax.swing.JLabel jLabelHKXet;
    private javax.swing.JLabel jLabelHKXet_DRL;
    private javax.swing.JLabel jLabelHanCS;
    private javax.swing.JLabel jLabelHanCV;
    private javax.swing.JLabel jLabelHanKhoa;
    private javax.swing.JLabel jLabelHanSV;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelHoTen;
    private javax.swing.JLabel jLabelLeft8;
    private javax.swing.JLabel jLabelLeft9;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLop;
    private javax.swing.JLabel jLabelLopLeft;
    private javax.swing.JLabel jLabelLop_TK;
    private javax.swing.JLabel jLabelMSV;
    private javax.swing.JLabel jLabelMatKhau;
    private javax.swing.JLabel jLabelNgayBD;
    private javax.swing.JLabel jLabelNgaySinh;
    private javax.swing.JLabel jLabelNutChamLai;
    private javax.swing.JLabel jLabelNutLienHe;
    private javax.swing.JLabel jLabelNutSV;
    private javax.swing.JLabel jLabelNutTieuDeKhoa2;
    private javax.swing.JLabel jLabelNutTieuDeTrangChu;
    private javax.swing.JLabel jLabelNutTieuDeTrangChu1;
    private javax.swing.JLabel jLabelNutXoaLop;
    private javax.swing.JLabel jLabelQueQuan;
    private javax.swing.JLabel jLabelSdt;
    private javax.swing.JLabel jLabelSinhVien;
    private javax.swing.JLabel jLabelSinhVienLeft;
    private javax.swing.JLabel jLabelTableTitleLop1;
    private javax.swing.JLabel jLabelTableTitleLop2;
    private javax.swing.JLabel jLabelTenDN;
    private javax.swing.JLabel jLabelThreeDots;
    private javax.swing.JLabel jLabelThreedots1;
    private javax.swing.JLabel jLabelThuongHieu;
    private javax.swing.JLabel jLabelTrangChu;
    private javax.swing.JLabel jLabelTrangChuLeft;
    private javax.swing.JLabel jLabelpanelPtit;
    private javax.swing.JLayeredPane jLayeredPaneMain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelChamDiem;
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelDRL;
    private javax.swing.JPanel jPanelDRLCaNhan;
    private javax.swing.JPanel jPanelDoiMK;
    private javax.swing.JPanel jPanelDoiTT;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelLogOut;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNullDot;
    private javax.swing.JPanel jPanelNullDot1;
    private javax.swing.JPanel jPanelNullDot2;
    private javax.swing.JPanel jPanelNullDot3;
    private javax.swing.JPanel jPanelNullDot4;
    private javax.swing.JPanel jPanelNullDot5;
    private javax.swing.JPanel jPanelNutChamLai;
    private javax.swing.JPanel jPanelNutLienHe;
    private javax.swing.JPanel jPanelNutTieuDeLop;
    private javax.swing.JPanel jPanelNutTieuDeTrangChu;
    private javax.swing.JPanel jPanelNutTieuDeTrangChu1;
    private javax.swing.JPanel jPanelNutTitleSV;
    private javax.swing.JPanel jPanelNutXoaLop;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSinhVien;
    private javax.swing.JPanel jPanelTTCN;
    private com.raven.swing.PanelBorder jPanelTabeDRL;
    private com.raven.swing.PanelBorder jPanelTabeDRLCaNhan;
    private com.raven.swing.PanelBorder jPanelTableLop_Xet;
    private javax.swing.JPanel jPanelThanhTieuDeLop;
    private javax.swing.JPanel jPanelThanhTieuDeTrangChu;
    private javax.swing.JPanel jPanelThanhTieuDeTrangChu1;
    private javax.swing.JPanel jPanelTitleSV;
    private javax.swing.JPanel jPanelTrangChu;
    private javax.swing.JPanel jPanelTrangChuMain;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JScrollPane jScrollPaneDRL;
    private javax.swing.JScrollPane jScrollPaneDRLCaNhan;
    private javax.swing.JScrollPane jScrollPaneLop;
    private javax.swing.JScrollPane jScrollPaneLopXet;
    private com.raven.swing.TableCo5Cot jTableDRL;
    private com.raven.swing.TableCo5Cot jTableDRLCaNhan;
    private com.raven.swing.TableCo5Cot jTableLopXet;
    // End of variables declaration//GEN-END:variables


}
