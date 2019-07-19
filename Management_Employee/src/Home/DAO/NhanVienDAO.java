package Home.DAO;

import Home.common.JDBC;
import Home.model.NhanVien;
import Home.model.table.TableNhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class NhanVienDAO {

    public ObservableList<TableNhanVien> getDataForTable() {
        ObservableList<TableNhanVien> data = FXCollections.observableArrayList();
        try {
            String sql = "{Call SP_TBLNhanVien}";
            ResultSet rs = JDBC.executeQuery(sql);
            while (rs.next()) {
                TableNhanVien nv = new TableNhanVien(rs.getString(1), rs.getString(2), rs.getBoolean(3)?"Nam":"Nữ", rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), 
                        rs.getBoolean(16)?"Chính thức":"Không chính thức", rs.getBoolean(17)?"Đang làm việc":"Đã nghỉ việc");
                data.add(nv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public ObservableList<PieChart.Data> getDataForPieChart() {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        try {
            String sql = "{call SP_SLNamNu(?)}";
            ResultSet rs = JDBC.executeQuery(sql, "");
            while (rs.next()) {
                data.add(new PieChart.Data(rs.getBoolean(1)? "Nam" : "Nữ", rs.getInt(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
    public XYChart.Series getDataForBarChart() {
        XYChart.Series data = new XYChart.Series<>();
        double SLNV = 0; //tong so luong nhan vien
        int count = 0; //So luong phong ban
        try {
            String sql = "{call SP_SLNhanVien(?)}";
            ResultSet rs = JDBC.executeQuery(sql, "");
            while (rs.next()) {
                data.getData().add(new XYChart.Data(rs.getString(1), rs.getDouble(2)));
                SLNV += rs.getDouble(2);
                count++;
            }
            data.getData().add(new XYChart.Data("Trung bình", SLNV/count));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }
   
    public NhanVien findByCode(String code){
        NhanVien nhanVien = null;
        try {
            String sql = "{Call SP_FindNVByCode(?)}";
            ResultSet rs = JDBC.executeQuery(sql, code);
            while (rs.next()) {                
                nhanVien = new NhanVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), 
                        rs.getString(12), rs.getString(13), rs.getDate(14), rs.getDate(15), rs.getInt(16), rs.getBoolean(17), rs.getBoolean(18));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }
    
}
