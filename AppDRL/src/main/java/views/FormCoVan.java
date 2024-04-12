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




public final class FormCoVan extends javax.swing.JFrame {

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
    
    public void viewMenuClick(JPanel main, JPanel p2){
        main.setBackground(hoveColor);
        main.revalidate(); // Cập nhật giao diện
        main.repaint();    // Vẽ lại giao diện
        
        p2.setBackground(white);
        p2.revalidate(); // Cập nhật giao diện
        p2.repaint();    // Vẽ lại giao diện
        
        
    }    
    
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
        
    public void suKienMenu(){
        setLocationRelativeTo(null);
        
        
        //Kích vào menu nào thì đó hiện màu vàng đậm
       ClickEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft1, jPanelLop);
       ClickEvent(jPanelLop, jLabelLop, jLabelLeft2, jPanelTaiKhoan);

       
       //rê vào menu nào thì menu đó màu vàng nhạt
       EnterEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft1, jPanelLop, jPanelLogOut, jPanelHelp);
       EnterEvent(jPanelLop, jLabelLop, jLabelLeft2, jPanelTaiKhoan, jPanelLogOut, jPanelHelp);
       EnterEvent(jPanelHelp, jLabelHelp, jLabelLeft3, jPanelLop, jPanelTaiKhoan, jPanelLogOut);
       EnterEvent(jPanelLogOut, jLabelLogOut, jLabelLeft4, jPanelLop, jPanelHelp, jPanelTaiKhoan);

        //Mặc định khi mở sẽ hiện màn hình tài khoản khi kích vào nút nào thì nút đó hiện ra phần màn hình đó
       jPanelTaiKhoan.setBackground(hoveColor);
        hienManHinhCanMo(jPanelTaiKhoanMain,  jPanelLopMain);
       
        ClickMenuEvent(jPanelTaiKhoan, jLabelTaiKhoan, jLabelLeft1, jPanelTaiKhoanMain, jPanelLopMain);
        ClickMenuEvent(jPanelLop, jLabelLop, jLabelLeft2, jPanelLopMain, jPanelTaiKhoanMain);
        
        
        //thêm vào các choice

        
        
        //rê vào các nút thêm sửa xóa sẽ đổi màu xanh
        
        //nút thêm
        buttonHoverEvent(jLabelNutThem, jPanelNutThem);
        
        //nút xóa
        buttonHoverEvent(jLabelNutXoa, jPanelNutXoa);
        buttonHoverEvent(jLabelNutXem, jPanelNutXem);
        //nút sửa
        buttonHoverEvent(jLabelNutSua, jPanelNutSua);
        buttonHoverEvent(jLabelNutLienHe, jPanelNutLienHe);

    }
    
    public FormCoVan() {
        initComponents();
        suKienMenu();
    }
    
    public void ClickEvent(JPanel main1, JLabel main2, JLabel main3, JPanel p2){
        
        main1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewMenuClick(main1, p2);
            }
        });
        
    }
    //jPanelKhoa, jLabelKhoa, jLabelLeft1, jPanelHocKyMain, jPanelKhoaMain, jPanelChamDiemMain, jPanelCoVanMain, jPanelLopMain, jPanelTaiKhoanMain, PanelXemDiemMain
    public void ClickMenuEvent(JPanel main, JLabel main2, JLabel main3, JPanel main1, JPanel p2){
        
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelKhoa2
        main2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2);
                
            }
        });

        // Bắt sự kiện khi rê chuột vào jLabelLeft
        main3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hienManHinhCanMo(main1, p2);
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
   
   public void hienManHinhCanMo(JPanel main, JPanel p2){
        main.setVisible(true);
        p2.setVisible(false);
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
        jPanelPanel = new javax.swing.JPanel();
        jPanelContact = new javax.swing.JPanel();
        jPanelPtit = new javax.swing.JPanel();
        jLabelpanelPtit = new javax.swing.JLabel();
        jPanelNutLienHe = RoundedPanel.createRoundedPanel();
        jLabelNutLienHe = new javax.swing.JLabel();
        jLabelCloud = new javax.swing.JLabel();
        jLabelFb = new javax.swing.JLabel();
        jLayeredPaneMain = new javax.swing.JLayeredPane();
        jPanelLopMain = new javax.swing.JPanel();
        jLabelND = new javax.swing.JLabel();
        jPanelThanhTieuDe2 = new javax.swing.JPanel();
        jPanelNutTieuDe2 = RoundedPanel.createRoundedPanel();
        jLabelNutTieuDe2 = new javax.swing.JLabel();
        jPanelNutXoa = RoundedPanel.createRoundedPanel();
        jLabelNutXoa = new javax.swing.JLabel();
        jPanelNutSua = RoundedPanel.createRoundedPanel();
        jLabelNutSua = new javax.swing.JLabel();
        jPanelNutThem = RoundedPanel.createRoundedPanel();
        jLabelNutThem = new javax.swing.JLabel();
        jPanelNutXem = RoundedPanel.createRoundedPanel();
        jLabelNutXem = new javax.swing.JLabel();
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
        jPanelMenu = new javax.swing.JPanel();
        jPanelTaiKhoan = new javax.swing.JPanel();
        jLabelTaiKhoan = new javax.swing.JLabel();
        jLabelLeft1 = new javax.swing.JLabel();
        jPanelLop = new javax.swing.JPanel();
        jLabelLop = new javax.swing.JLabel();
        jLabelLeft2 = new javax.swing.JLabel();
        jPanelNull1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelNull2 = new javax.swing.JPanel();
        jPanelNull3 = new javax.swing.JPanel();
        jPanelNull4 = new javax.swing.JPanel();
        jPanelNull5 = new javax.swing.JPanel();
        jPanelNull6 = new javax.swing.JPanel();
        jPanelNull7 = new javax.swing.JPanel();
        jPanelNull9 = new javax.swing.JPanel();
        jLabelThreeDots = new javax.swing.JLabel();
        jPanelHelp = new javax.swing.JPanel();
        jLabelHelp = new javax.swing.JLabel();
        jLabelLeft3 = new javax.swing.JLabel();
        jPanelLogOut = new javax.swing.JPanel();
        jLabelLogOut = new javax.swing.JLabel();
        jLabelLeft4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cố vấn học tập");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelView.setBackground(new java.awt.Color(189, 56, 27));
        jPanelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanelView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jPanelNutLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanelPtitLayout.setVerticalGroup(
            jPanelPtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addComponent(jLabelpanelPtit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanelPtitLayout.createSequentialGroup()
                .addGap(27, 27, 27)
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

jPanelLopMain.setBackground(new java.awt.Color(255, 255, 255));
jPanelLopMain.setPreferredSize(new java.awt.Dimension(684, 505));
jPanelLopMain.setRequestFocusEnabled(false);
jPanelLopMain.setVerifyInputWhenFocusTarget(false);
jPanelLopMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

jLabelND.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabelND.setText("(Bảng danh sách các sinh viên thuộc lớp quản lý của cố vấn");
jPanelLopMain.add(jLabelND, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 764, 420));

jPanelThanhTieuDe2.setPreferredSize(new java.awt.Dimension(770, 34));

jPanelNutTieuDe2.setBackground(new java.awt.Color(221, 51, 51));

jLabelNutTieuDe2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabelNutTieuDe2.setForeground(new java.awt.Color(255, 255, 255));
jLabelNutTieuDe2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whiteclass.png")));
jLabelNutTieuDe2.setText("Danh sách lớp");
jLabelNutTieuDe2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
jLabelNutTieuDe2.setPreferredSize(new java.awt.Dimension(32, 16));

javax.swing.GroupLayout jPanelNutTieuDe2Layout = new javax.swing.GroupLayout(jPanelNutTieuDe2);
jPanelNutTieuDe2.setLayout(jPanelNutTieuDe2Layout);
jPanelNutTieuDe2Layout.setHorizontalGroup(
    jPanelNutTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutTieuDe2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
    );
    jPanelNutTieuDe2Layout.setVerticalGroup(
        jPanelNutTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
    );

    jPanelNutXoa.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXoa.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXoa.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitedelete.png")));
    jLabelNutXoa.setText("Xóa");
    jLabelNutXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXoa.setPreferredSize(new java.awt.Dimension(32, 16));

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

    jPanelNutXem.setBackground(new java.awt.Color(221, 51, 51));
    jPanelNutXem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelNutXem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelNutXem.setForeground(new java.awt.Color(255, 255, 255));
    jLabelNutXem.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("whitewrite.png")));
    jLabelNutXem.setText("Chấm điểm");
    jLabelNutXem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabelNutXem.setPreferredSize(new java.awt.Dimension(32, 16));

    javax.swing.GroupLayout jPanelNutXemLayout = new javax.swing.GroupLayout(jPanelNutXem);
    jPanelNutXem.setLayout(jPanelNutXemLayout);
    jPanelNutXemLayout.setHorizontalGroup(
        jPanelNutXemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNutXemLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelNutXem, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
            .addComponent(jPanelNutXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanelNutXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanelThanhTieuDe2Layout.setVerticalGroup(
        jPanelThanhTieuDe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelNutTieuDe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelNutXem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelLopMain.add(jPanelThanhTieuDe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 764, 40));

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
    jLabelNoiDungDRL.setText("Giảng viên");
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

    jPanelView.add(jLayeredPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 140, 784, -1));

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

    jPanelLop.setBackground(new java.awt.Color(255, 255, 255));
    jPanelLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelLop.setBackground(new java.awt.Color(255, 255, 255));
    jLabelLop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelLop.setForeground(new java.awt.Color(227, 70, 34));
    jLabelLop.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("lop.png")));
    jLabelLop.setText("XEM DS LỚP");

    jLabelLeft2.setBackground(new java.awt.Color(255, 255, 255));
    jLabelLeft2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelLeft2.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

    javax.swing.GroupLayout jPanelLopLayout = new javax.swing.GroupLayout(jPanelLop);
    jPanelLop.setLayout(jPanelLopLayout);
    jPanelLopLayout.setHorizontalGroup(
        jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelLopLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabelLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelLopLayout.setVerticalGroup(
        jPanelLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelLop, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        .addComponent(jLabelLeft2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelLop);

    jPanelNull1.setBackground(new java.awt.Color(255, 255, 255));
    jPanelNull1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

    javax.swing.GroupLayout jPanelNull1Layout = new javax.swing.GroupLayout(jPanelNull1);
    jPanelNull1.setLayout(jPanelNull1Layout);
    jPanelNull1Layout.setHorizontalGroup(
        jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
    );
    jPanelNull1Layout.setVerticalGroup(
        jPanelNull1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelNull1Layout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    javax.swing.GroupLayout jPanelNull3Layout = new javax.swing.GroupLayout(jPanelNull3);
    jPanelNull3.setLayout(jPanelNull3Layout);
    jPanelNull3Layout.setHorizontalGroup(
        jPanelNull3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 200, Short.MAX_VALUE)
    );
    jPanelNull3Layout.setVerticalGroup(
        jPanelNull3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelNull3);

    jPanelNull4.setBackground(new java.awt.Color(255, 255, 255));
    jPanelNull4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    javax.swing.GroupLayout jPanelNull4Layout = new javax.swing.GroupLayout(jPanelNull4);
    jPanelNull4.setLayout(jPanelNull4Layout);
    jPanelNull4Layout.setHorizontalGroup(
        jPanelNull4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 200, Short.MAX_VALUE)
    );
    jPanelNull4Layout.setVerticalGroup(
        jPanelNull4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelNull4);

    jPanelNull5.setBackground(new java.awt.Color(255, 255, 255));
    jPanelNull5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    javax.swing.GroupLayout jPanelNull5Layout = new javax.swing.GroupLayout(jPanelNull5);
    jPanelNull5.setLayout(jPanelNull5Layout);
    jPanelNull5Layout.setHorizontalGroup(
        jPanelNull5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 200, Short.MAX_VALUE)
    );
    jPanelNull5Layout.setVerticalGroup(
        jPanelNull5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelNull5);

    jPanelNull6.setBackground(new java.awt.Color(255, 255, 255));
    jPanelNull6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    javax.swing.GroupLayout jPanelNull6Layout = new javax.swing.GroupLayout(jPanelNull6);
    jPanelNull6.setLayout(jPanelNull6Layout);
    jPanelNull6Layout.setHorizontalGroup(
        jPanelNull6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 200, Short.MAX_VALUE)
    );
    jPanelNull6Layout.setVerticalGroup(
        jPanelNull6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelNull6);

    jPanelNull7.setBackground(new java.awt.Color(255, 255, 255));
    jPanelNull7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    javax.swing.GroupLayout jPanelNull7Layout = new javax.swing.GroupLayout(jPanelNull7);
    jPanelNull7.setLayout(jPanelNull7Layout);
    jPanelNull7Layout.setHorizontalGroup(
        jPanelNull7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 200, Short.MAX_VALUE)
    );
    jPanelNull7Layout.setVerticalGroup(
        jPanelNull7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelNull7);

    jPanelNull9.setBackground(new java.awt.Color(255, 255, 255));
    jPanelNull9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelThreeDots.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelThreeDots.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("threedot.png")));

    javax.swing.GroupLayout jPanelNull9Layout = new javax.swing.GroupLayout(jPanelNull9);
    jPanelNull9.setLayout(jPanelNull9Layout);
    jPanelNull9Layout.setHorizontalGroup(
        jPanelNull9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelThreeDots, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
    );
    jPanelNull9Layout.setVerticalGroup(
        jPanelNull9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNull9Layout.createSequentialGroup()
            .addGap(0, 39, Short.MAX_VALUE)
            .addComponent(jLabelThreeDots, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanelMenu.add(jPanelNull9);

    jPanelHelp.setBackground(new java.awt.Color(255, 255, 255));
    jPanelHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelHelp.setBackground(new java.awt.Color(255, 255, 255));
    jLabelHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelHelp.setForeground(new java.awt.Color(227, 70, 34));
    jLabelHelp.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("help.png")));
    jLabelHelp.setText("Trợ giúp");

    jLabelLeft3.setBackground(new java.awt.Color(255, 255, 255));
    jLabelLeft3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelLeft3.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

    javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
    jPanelHelp.setLayout(jPanelHelpLayout);
    jPanelHelpLayout.setHorizontalGroup(
        jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelHelpLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabelLeft3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelHelpLayout.setVerticalGroup(
        jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        .addComponent(jLabelLeft3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelHelp);

    jPanelLogOut.setBackground(new java.awt.Color(255, 255, 255));
    jPanelLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    jLabelLogOut.setBackground(new java.awt.Color(255, 255, 255));
    jLabelLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabelLogOut.setForeground(new java.awt.Color(227, 70, 34));
    jLabelLogOut.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("logout.png")));
    jLabelLogOut.setText("Thoát");

    jLabelLeft4.setBackground(new java.awt.Color(255, 255, 255));
    jLabelLeft4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabelLeft4.setIcon(new javax.swing.ImageIcon(Icon.getUrlIcon("redleft.png")));

    javax.swing.GroupLayout jPanelLogOutLayout = new javax.swing.GroupLayout(jPanelLogOut);
    jPanelLogOut.setLayout(jPanelLogOutLayout);
    jPanelLogOutLayout.setHorizontalGroup(
        jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelLogOutLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabelLeft4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelLogOutLayout.setVerticalGroup(
        jPanelLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabelLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        .addComponent(jLabelLeft4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
    );

    jPanelMenu.add(jPanelLogOut);

    jPanelView.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 140, 200, -1));

    getContentPane().add(jPanelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 748));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDoiMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMatKhauMouseExited
        // TODO add your handling code here:
        jPanelDoiMK.setBackground(buttonColor);
        jPanelDoiMK.revalidate(); // Cập nhật giao diện
        jPanelDoiMK.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelDoiMatKhauMouseExited

    private void jLabelDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoiMatKhauMouseEntered
        // TODO add your handling code here:
        jPanelDoiMK.setBackground(buttonHoverColor);
        jPanelDoiMK.revalidate(); // Cập nhật giao diện
        jPanelDoiMK.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelDoiMatKhauMouseEntered

    private void jPanelSuaTTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSuaTTMouseEntered
        // TODO add your handling code here:
        jPanelSuaTT.setBackground(buttonHoverColor);
        jPanelSuaTT.revalidate(); // Cập nhật giao diện
        jPanelSuaTT.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jPanelSuaTTMouseEntered

    private void jLabelSuaThongTinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaThongTinMouseExited
        // TODO add your handling code here:
        jPanelSuaTT.setBackground(buttonColor);
        jPanelSuaTT.revalidate(); // Cập nhật giao diện
        jPanelSuaTT.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelSuaThongTinMouseExited

    private void jLabelSuaThongTinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSuaThongTinMouseEntered
        // TODO add your handling code here:
        jPanelSuaTT.setBackground(buttonHoverColor);
        jPanelSuaTT.revalidate(); // Cập nhật giao diện
        jPanelSuaTT.repaint();    // Vẽ lại giao diện
    }//GEN-LAST:event_jLabelSuaThongTinMouseEntered


    
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
            java.util.logging.Logger.getLogger(FormCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCoVan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new FormCoVan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCloud;
    private javax.swing.JLabel jLabelDoiMatKhau;
    private javax.swing.JLabel jLabelFb;
    private javax.swing.JLabel jLabelHelp;
    private javax.swing.JLabel jLabelLeft1;
    private javax.swing.JLabel jLabelLeft2;
    private javax.swing.JLabel jLabelLeft3;
    private javax.swing.JLabel jLabelLeft4;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLop;
    private javax.swing.JLabel jLabelND;
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
    private javax.swing.JLabel jLabelNutThem;
    private javax.swing.JLabel jLabelNutTieuDe2;
    private javax.swing.JLabel jLabelNutXem;
    private javax.swing.JLabel jLabelNutXoa;
    private javax.swing.JLabel jLabelSuaThongTin;
    private javax.swing.JLabel jLabelTaiKhoan;
    private javax.swing.JLabel jLabelTenDangNhap;
    private javax.swing.JLabel jLabelThreeDots;
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
    private javax.swing.JPanel jPanelContact;
    private javax.swing.JPanel jPanelDoiMK;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelLogOut;
    private javax.swing.JPanel jPanelLop;
    private javax.swing.JPanel jPanelLopMain;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNull1;
    private javax.swing.JPanel jPanelNull2;
    private javax.swing.JPanel jPanelNull3;
    private javax.swing.JPanel jPanelNull4;
    private javax.swing.JPanel jPanelNull5;
    private javax.swing.JPanel jPanelNull6;
    private javax.swing.JPanel jPanelNull7;
    private javax.swing.JPanel jPanelNull9;
    private javax.swing.JPanel jPanelNutLienHe;
    private javax.swing.JPanel jPanelNutSua;
    private javax.swing.JPanel jPanelNutThem;
    private javax.swing.JPanel jPanelNutTieuDe2;
    private javax.swing.JPanel jPanelNutXem;
    private javax.swing.JPanel jPanelNutXoa;
    private javax.swing.JPanel jPanelPanel;
    private javax.swing.JPanel jPanelPtit;
    private javax.swing.JPanel jPanelSuaTT;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JPanel jPanelTaiKhoanMain;
    private javax.swing.JPanel jPanelThanhTieuDe2;
    private javax.swing.JPanel jPanelTitle1;
    private javax.swing.JPanel jPanelTitle2;
    private javax.swing.JPanel jPanelTitleColor;
    private javax.swing.JPanel jPanelTitleColor1;
    private javax.swing.JPanel jPanelView;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
