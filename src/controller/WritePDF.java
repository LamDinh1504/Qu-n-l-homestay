/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class WritePDF {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public WritePDF() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) throws DocumentException {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
} catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }
    
        public void writeHoaDon(
            String maHoaDon,
            String maPhong,
            String loaiPhong,
            String kieuPhong,
            String maDatPhong,
            String maKhachHang,
            String ngayDen,
            String ngayTraPhong,
            String ngayLapHoaDon,
            JTable tableDichVu,
            String tongTienPhaiTraText 
    ) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu hóa đơn PDF");
        int userSelection = fileChooser.showSaveDialog(null); 

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Đảm bảo file có đuôi .pdf
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            Document document = new Document(PageSize.A4);
            FileOutputStream fileOutputStream = null;

            try {
                fileOutputStream = new FileOutputStream(filePath);
                PdfWriter.getInstance(document, fileOutputStream);
                document.open();

      
                BaseFont bf = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font fontHeader = new Font(bf, 24, Font.BOLD, new BaseColor(0, 143, 143)); 
                Font fontTitle = new Font(bf, 16, Font.BOLD, BaseColor.BLACK);
                Font fontNormal = new Font(bf, 12, Font.NORMAL, BaseColor.BLACK);
                Font fontBold = new Font(bf, 12, Font.BOLD, BaseColor.WHITE); 

                // Tiêu đề chính
                Paragraph mainTitle = new Paragraph("HÓA ĐƠN THANH TOÁN", fontHeader);
                mainTitle.setAlignment(Element.ALIGN_CENTER);
                mainTitle.setSpacingAfter(20);
                document.add(mainTitle);

                // Thông tin chung của hóa đơn
                Paragraph infoPara = new Paragraph();
                infoPara.setFont(fontNormal);
                infoPara.add("Mã hóa đơn: " + maHoaDon + "\n");
                infoPara.add("Mã phòng: " + maPhong + "\n");
                infoPara.add("Loại phòng: " + loaiPhong + "\n");
                infoPara.add("Kiểu phòng: " + kieuPhong + "\n");
                infoPara.add("Mã đặt phòng: " + maDatPhong + "\n");
                infoPara.add("Khách hàng: " + maKhachHang + "\n");
                infoPara.add("Ngày đến: " + ngayDen + "\n");
                infoPara.add("Ngày trả phòng: " + ngayTraPhong + "\n");
                infoPara.add("Ngày lập hóa đơn: " + ngayLapHoaDon + "\n");
                infoPara.setIndentationLeft(40);
                document.add(infoPara);
                document.add(Chunk.NEWLINE);

                // Tiêu đề phần dịch vụ
                Paragraph serviceTitle = new Paragraph("CHI TIẾT DỊCH VỤ", fontTitle);
                serviceTitle.setAlignment(Element.ALIGN_LEFT);
                serviceTitle.setSpacingAfter(10);
                document.add(serviceTitle);

                // Bảng dịch vụ
                PdfPTable pdfTable = new PdfPTable(3);
                pdfTable.setWidthPercentage(100);
                pdfTable.setSpacingBefore(10f);
                pdfTable.setSpacingAfter(10f);

        
                PdfPCell cell;
                cell = new PdfPCell(new Phrase("Tên dịch vụ", fontBold));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor(0, 143, 143)); 
                cell.setPadding(5);
                pdfTable.addCell(cell);

                cell = new PdfPCell(new Phrase("Đơn giá", fontBold));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor(0, 143, 143));
                cell.setPadding(5);
                pdfTable.addCell(cell);

                cell = new PdfPCell(new Phrase("Số lượng", fontBold));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor(0, 143, 143));
                cell.setPadding(5);
                pdfTable.addCell(cell);

                // Lấy DefaultTableModel từ JTable
                DefaultTableModel model = (DefaultTableModel) tableDichVu.getModel();
                // Truyền thông tin từng chi tiết vào table từ DefaultTableModel
                for (int i = 0; i < model.getRowCount(); i++) { // Đã đổi từ tableDichVuModel sang model
                    pdfTable.addCell(new PdfPCell(new Phrase(model.getValueAt(i, 0).toString(), fontNormal)));
                    pdfTable.addCell(new PdfPCell(new Phrase(model.getValueAt(i, 1).toString(), fontNormal)));
                    pdfTable.addCell(new PdfPCell(new Phrase(model.getValueAt(i, 2).toString(), fontNormal)));
                }
                document.add(pdfTable);
                document.add(Chunk.NEWLINE);

                // Thông tin tổng kết
                Paragraph summaryPara = new Paragraph();
                summaryPara.setFont(fontNormal);
//                summaryPara.add(new Phrase(tienDichVuText + "\n"));
//                summaryPara.add(new Phrase(phuThuText + "\n"));
//                summaryPara.add(new Phrase(tongTienPhongText + "\n")); // Tổng tiền phòng
                summaryPara.add(new Phrase("----------------------------------------\n"));
                summaryPara.add(new Phrase("Tổng tiền phải trả (VND): ", fontTitle)); // Sử dụng fontTitle cho tổng cuối cùng
                summaryPara.add(new Phrase(tongTienPhaiTraText, fontTitle));
                summaryPara.setAlignment(Element.ALIGN_RIGHT); // Căn phải
                summaryPara.setIndentationRight(40); // Thụt lề phải
                document.add(summaryPara);

                document.close();
                JOptionPane.showMessageDialog(null, "Hóa đơn đã được tạo thành công tại:\n" + filePath);

                // Mở file PDF sau khi tạo
                openFile(filePath);

            } catch (DocumentException | FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi tạo hóa đơn PDF: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi I/O khi xử lý font hoặc file: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    private void openFile(String filePath) {
        try {
            File pdfFile = new File(filePath);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Desktop không được hỗ trợ để mở file.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "File không tồn tại: " + filePath, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thể mở file PDF: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}


