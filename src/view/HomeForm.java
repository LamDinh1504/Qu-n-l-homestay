/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author ASUS
 */
public class HomeForm extends javax.swing.JFrame {

    /**
     * Creates new form HomeForm
     */
    public HomeForm() {
       super("Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        
        setTitle("QUAN LY KHACH SAN");
        
        ChuyenManHinhController controller = new ChuyenManHinhController(JpnMain);
        
        controller.setView(TrangChu,JlbTrangChu);
        
        List<DanhMucBean> listItem=new ArrayList<>();
        listItem.add(new DanhMucBean("TrangChu", TrangChu, JlbTrangChu));
        listItem.add(new DanhMucBean("NhanVien", NhanVien, JlbNhanVien));
        listItem.add(new DanhMucBean("DichVu", DichVu, JlbDichVu));
        listItem.add(new DanhMucBean("Phong", Phong, JlbPhong));
        listItem.add(new DanhMucBean("KhachHang", KhachHang, JlbKhachHang));
        listItem.add(new DanhMucBean("ThongKe", ThongKe, JlbThongKe));
        listItem.add(new DanhMucBean("TaiKhoan", TaiKhoan, JlbTaiKhoan));
        listItem.add(new DanhMucBean("DangXuat", DangXuat, JlbDangXuat));
        controller.setEvent(listItem);
        
        JlbTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            controller.setView(TrangChu, JlbTrangChu); // Gọi lại controller để chuyển view
        }
    });
       
        pack();                      
        setLocationRelativeTo(null);  
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TrangChu = new javax.swing.JPanel();
        JlbTrangChu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NhanVien = new javax.swing.JPanel();
        JlbNhanVien = new javax.swing.JLabel();
        DichVu = new javax.swing.JPanel();
        JlbDichVu = new javax.swing.JLabel();
        Phong = new javax.swing.JPanel();
        JlbPhong = new javax.swing.JLabel();
        KhachHang = new javax.swing.JPanel();
        JlbKhachHang = new javax.swing.JLabel();
        ThongKe = new javax.swing.JPanel();
        JlbThongKe = new javax.swing.JLabel();
        TaiKhoan = new javax.swing.JPanel();
        JlbTaiKhoan = new javax.swing.JLabel();
        DangXuat = new javax.swing.JPanel();
        JlbDangXuat = new javax.swing.JLabel();
        JpnMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(54, 55, 55));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TrangChu.setBackground(new java.awt.Color(54, 55, 55));
        TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        TrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrangChuMouseClicked(evt);
            }
        });

        JlbTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        JlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_1318085.png"))); // NOI18N
        JlbTrangChu.setText("Trang chủ");
        JlbTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbTrangChuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TrangChuLayout = new javax.swing.GroupLayout(TrangChu);
        TrangChu.setLayout(TrangChuLayout);
        TrangChuLayout.setHorizontalGroup(
            TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(JlbTrangChu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TrangChuLayout.setVerticalGroup(
            TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JlbTrangChu)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 143, 143));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HOMESTAY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        NhanVien.setBackground(new java.awt.Color(54, 55, 55));
        NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhanVienMouseClicked(evt);
            }
        });

        JlbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        JlbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-service_1908409.png"))); // NOI18N
        JlbNhanVien.setText("Nhân Viên");

        javax.swing.GroupLayout NhanVienLayout = new javax.swing.GroupLayout(NhanVien);
        NhanVien.setLayout(NhanVienLayout);
        NhanVienLayout.setHorizontalGroup(
            NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JlbNhanVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NhanVienLayout.setVerticalGroup(
            NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JlbNhanVien)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        DichVu.setBackground(new java.awt.Color(54, 55, 55));
        DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DichVuMouseClicked(evt);
            }
        });

        JlbDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbDichVu.setForeground(new java.awt.Color(255, 255, 255));
        JlbDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sofa-bed_12602580.png"))); // NOI18N
        JlbDichVu.setText("Dịch vụ");

        javax.swing.GroupLayout DichVuLayout = new javax.swing.GroupLayout(DichVu);
        DichVu.setLayout(DichVuLayout);
        DichVuLayout.setHorizontalGroup(
            DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DichVuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JlbDichVu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DichVuLayout.setVerticalGroup(
            DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DichVuLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(JlbDichVu)
                .addGap(16, 16, 16))
        );

        Phong.setBackground(new java.awt.Color(54, 55, 55));
        Phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhongMouseClicked(evt);
            }
        });

        JlbPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbPhong.setForeground(new java.awt.Color(255, 255, 255));
        JlbPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-service_1908409.png"))); // NOI18N
        JlbPhong.setText("Phòng");
        JlbPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbPhongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PhongLayout = new javax.swing.GroupLayout(Phong);
        Phong.setLayout(PhongLayout);
        PhongLayout.setHorizontalGroup(
            PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhongLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JlbPhong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PhongLayout.setVerticalGroup(
            PhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhongLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JlbPhong)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        KhachHang.setBackground(new java.awt.Color(54, 55, 55));

        JlbKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        JlbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/animal_16434247.png"))); // NOI18N
        JlbKhachHang.setText("Khách hàng");

        javax.swing.GroupLayout KhachHangLayout = new javax.swing.GroupLayout(KhachHang);
        KhachHang.setLayout(KhachHangLayout);
        KhachHangLayout.setHorizontalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(JlbKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KhachHangLayout.setVerticalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JlbKhachHang)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ThongKe.setBackground(new java.awt.Color(54, 55, 55));

        JlbThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        JlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/analytic_5413452.png"))); // NOI18N
        JlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(JlbThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JlbThongKe)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        TaiKhoan.setBackground(new java.awt.Color(54, 55, 55));

        JlbTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        JlbTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile_14534426.png"))); // NOI18N
        JlbTaiKhoan.setText("Tài khoản");

        javax.swing.GroupLayout TaiKhoanLayout = new javax.swing.GroupLayout(TaiKhoan);
        TaiKhoan.setLayout(TaiKhoanLayout);
        TaiKhoanLayout.setHorizontalGroup(
            TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(JlbTaiKhoan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TaiKhoanLayout.setVerticalGroup(
            TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JlbTaiKhoan)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        DangXuat.setBackground(new java.awt.Color(54, 55, 55));

        JlbDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JlbDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        JlbDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log-out_10117554.png"))); // NOI18N
        JlbDangXuat.setText("Đăng xuất");

        javax.swing.GroupLayout DangXuatLayout = new javax.swing.GroupLayout(DangXuat);
        DangXuat.setLayout(DangXuatLayout);
        DangXuatLayout.setHorizontalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangXuatLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(JlbDangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DangXuatLayout.setVerticalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangXuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(JlbDangXuat)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Phong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        JpnMain.setBackground(new java.awt.Color(54, 55, 55));

        javax.swing.GroupLayout JpnMainLayout = new javax.swing.GroupLayout(JpnMain);
        JpnMain.setLayout(JpnMainLayout);
        JpnMainLayout.setHorizontalGroup(
            JpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
        );
        JpnMainLayout.setVerticalGroup(
            JpnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JpnMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JpnMain.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMouseClicked
        NhanVienForm tk = new NhanVienForm();
        JpnMain.removeAll();
        JpnMain.add(tk).setVisible(true);
        JpnMain.validate();
        JpnMain.repaint();
    }//GEN-LAST:event_NhanVienMouseClicked

    private void TrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrangChuMouseClicked
        TrangChuForm tk = new TrangChuForm();
        JpnMain.removeAll();
        JpnMain.add(tk).setVisible(true);
        JpnMain.validate();
        JpnMain.repaint();
    }//GEN-LAST:event_TrangChuMouseClicked

    private void PhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhongMouseClicked
        PhongForm tk = new PhongForm();
        JpnMain.removeAll();
        JpnMain.add(tk).setVisible(true);
        JpnMain.validate();
        JpnMain.repaint();
    }//GEN-LAST:event_PhongMouseClicked

    private void JlbTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbTrangChuMouseClicked
       
    }//GEN-LAST:event_JlbTrangChuMouseClicked

    private void DichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DichVuMouseClicked
        DichVuForm tk = new DichVuForm();
        JpnMain.removeAll();
        JpnMain.add(tk).setVisible(true);
        JpnMain.validate();
        JpnMain.repaint();
    }//GEN-LAST:event_DichVuMouseClicked

    private void JlbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbPhongMouseClicked
     
    }//GEN-LAST:event_JlbPhongMouseClicked
    
                   
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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DangXuat;
    private javax.swing.JPanel DichVu;
    private javax.swing.JLabel JlbDangXuat;
    private javax.swing.JLabel JlbDichVu;
    private javax.swing.JLabel JlbKhachHang;
    private javax.swing.JLabel JlbNhanVien;
    private javax.swing.JLabel JlbPhong;
    private javax.swing.JLabel JlbTaiKhoan;
    private javax.swing.JLabel JlbThongKe;
    private javax.swing.JLabel JlbTrangChu;
    private javax.swing.JPanel JpnMain;
    private javax.swing.JPanel KhachHang;
    private javax.swing.JPanel NhanVien;
    private javax.swing.JPanel Phong;
    private javax.swing.JPanel TaiKhoan;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JPanel TrangChu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
