/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import ConnectDB.ConnectionUtils;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.DatPhong;
import model.KhachHang;
import model.NhanVien;
/**
 *
 * @author ASUS
 */
public class DatPhongDAO {
    
        public ArrayList<DatPhong> getAllDatPhong() {
        ArrayList<DatPhong> dsDatPhong = new ArrayList<>();
        String query = "SELECT * FROM DATPHONG";

        try (Connection conn = ConnectionUtils.getMyConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            while (rs.next()) {
                // Lấy chuỗi ngày từ CSDL
                String ngayBDStr = rs.getString("NGAYBD");
                String ngayTraStr = rs.getString("NGAYTRA");

                // Chuyển định dạng
                String ngayBDFormatted = LocalDateTime.parse(ngayBDStr, inputFormatter)
                                                       .toLocalDate()
                                                       .format(outputFormatter);

                String ngayTraFormatted = LocalDateTime.parse(ngayTraStr, inputFormatter)
                                                        .toLocalDate()
                                                        .format(outputFormatter);

                // Tạo đối tượng DatPhong
                DatPhong currentDatPhong = new DatPhong(
                    rs.getString("MADP"),
                    rs.getString("MAKH"),
                    rs.getString("MAPHONG"),
                    ngayBDFormatted,
                    ngayTraFormatted,
                    rs.getString("TRANGTHAI")
                );

                dsDatPhong.add(currentDatPhong);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi truy vấn dữ liệu đặt phòng: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHangDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return dsDatPhong;
    }
    public int addDatPhong(String maDatPhong, String maKhachHang, String maPhong, String ngayBatDau, String ngayTra, String trangThai) {
    int i = 0;
    String query = "INSERT INTO DATPHONG (MADP, MAKH, MAPHONG, NGAYBD, NGAYTRA, TRANGTHAI) VALUES (?, ?, ?, TO_DATE(?, 'DD-MM-YYYY'), TO_DATE(?, 'DD-MM-YYYY'), ?)";

    try (Connection con = ConnectionUtils.getMyConnection()) {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, maDatPhong);
        ps.setString(2, maKhachHang);
        ps.setString(3, maPhong);
        ps.setString(4, ngayBatDau); // ví dụ: "2025-05-20"
        ps.setString(5, ngayTra);    // ví dụ: "2025-05-25"
        ps.setString(6, trangThai);
        i = ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
    }
        return i;
    }
    
    public void updateDatPhong(String maDatPhong,String trangThai) {
    String query = "UPDATE DATPHONG SET TRANGTHAI = ? WHERE MADP=?";

    try (Connection conn = ConnectionUtils.getMyConnection()) {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, trangThai);
        ps.setString(2, maDatPhong);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
        }
    }
    public static int deleteDatPhong(String maKhachHang) {
    int i = 0;
    try (Connection con = ConnectionUtils.getMyConnection()) {
        String query = "DELETE FROM DATPHONG WHERE MAKH = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, maKhachHang.trim());
        i = ps.executeUpdate();
    } catch (Exception e) {
        System.out.print(e);
    }
    return i;
}
    public static int demSoDatPhong() {
        String sql = "SELECT COUNT(*) FROM DatPhong";
        try (Connection conn =ConnectionUtils.getMyConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1); // số lượng KH hiện có
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
     public static DatPhong getDatPhong(String maKhachHang){
        String query = "SELECT * FROM DATPHONG WHERE MAKH = ?";
    try (Connection conn = ConnectionUtils.getMyConnection()) {
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, maKhachHang);
        ResultSet rs = ps.executeQuery();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        if (rs.next()) {
            // Lấy chuỗi ngày từ CSDL
            String ngayBDStr = rs.getString("NGAYBD");
            String ngayTraStr = rs.getString("NGAYTRA");

            // Chuyển định dạng giống getAllDatPhong
            String ngayBDFormatted = LocalDateTime.parse(ngayBDStr, inputFormatter)
                                                  .toLocalDate()
                                                  .format(outputFormatter);

            String ngayTraFormatted = LocalDateTime.parse(ngayTraStr, inputFormatter)
                                                   .toLocalDate()
                                                   .format(outputFormatter);

            return new DatPhong(
                rs.getString("MADP"),
                rs.getString("MAKH"),
                rs.getString("MAPHONG"),
                ngayBDFormatted,
                ngayTraFormatted,
                rs.getString("TRANGTHAI")
            );
        }
    } catch (Exception e) {
        System.out.println("Lỗi khi truy vấn đặt phòng: " + e.getMessage());
    }
    return null;
     }
    

}
