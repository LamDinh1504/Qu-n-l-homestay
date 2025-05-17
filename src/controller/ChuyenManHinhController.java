/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.DichVuForm;
import view.KhachHangForm;
import view.NhanVienForm;
import view.PhongForm;
import view.TaiKhoanForm;
import view.ThongKeForm;

import view.TrangChuForm;

/**
 *
 * @author ASUS
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem=null;
    
    public ChuyenManHinhController(JPanel jpnRoot) {
    this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(0,153,153));
        jlbItem.setBackground(new Color(0,153,153));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuForm());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem=listItem;
        for(DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpb(),item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jbnItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jbnItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jbnItem = jbnItem;
        }
        
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "TrangChu":
                    node=new TrangChuForm();
                case "NhanVien":
                    node=new NhanVienForm();
                    break;
                case "DichVu":
                    node=new DichVuForm();
                    break;
                case "Phong":
                    node=new PhongForm();
                case "KhachHang":
                    node=new KhachHangForm();
                case "ThongKe":
                    node=new ThongKeForm();
                case "TaiKhoan":
                    node=new TaiKhoanForm();
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected=kind;
            jpnItem.setBackground(new Color(0,153,153));
            jbnItem.setBackground(new Color(0,153,153));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(63,60,65));
            jbnItem.setBackground(new Color(63,60,65));
        }

        @Override
        public void mouseExited(MouseEvent e) {
           if(!kindSelected.equalsIgnoreCase(kind)) {
               jpnItem.setBackground(new Color(54,55,55));
               jbnItem.setBackground(new Color(54,55,55));
           }
        }
     
    }
    private void setChangeBackground(String kind) {
        for(DanhMucBean item : listItem) {
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpb().setBackground(new Color(54,55,55));
                item.getJlb().setBackground(new Color(54,55,55));
            } else {
                item.getJpb().setBackground(new Color(54,55,55));
                item.getJlb().setBackground(new Color(54,55,55));
            }
        }
    }
}
