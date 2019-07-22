package Home.controller;

import Home.DAO.BangLuongDAO;
import Home.DAO.ChamCongDAO;
import Home.DAO.NhanVienDAO;
import Home.common.FormatNumber;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class HomeController implements Initializable, Runnable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            nvdao = new NhanVienDAO();
            ccdao = new ChamCongDAO();
            bldao = new BangLuongDAO();
            
            Thread thread = new Thread(this);
            thread.start();
            
            loadChartTangTruongNV(LocalDate.now().getYear());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void loadChartTangTruongNV(int year) {
        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("Giám đốc");
        series1.setData(nvdao.getSLNVTheoThoiGianVaPB("GD", year));
        
        XYChart.Series series2 = new XYChart.Series<>();
        series2.setName("Kỹ thuật");
        series2.setData(nvdao.getSLNVTheoThoiGianVaPB("IT", year));
        
        XYChart.Series series3 = new XYChart.Series<>();
        series3.setName("Kế toán");
        series3.setData(nvdao.getSLNVTheoThoiGianVaPB("KT", year));
        
        XYChart.Series series4 = new XYChart.Series<>();
        series4.setName("Marketing");
        series4.setData(nvdao.getSLNVTheoThoiGianVaPB("MK", year));
        
        XYChart.Series series5 = new XYChart.Series<>();
        series5.setName("Nhân sự");
        series5.setData(nvdao.getSLNVTheoThoiGianVaPB("NS", year));
        
        XYChart.Series series6 = new XYChart.Series<>();
        series6.setName("Bán hàng");
        series6.setData(nvdao.getSLNVTheoThoiGianVaPB("SL", year));
        
        XYChart.Series series7 = new XYChart.Series<>();
        series7.setName("Tất cả");
        series7.setData(nvdao.getSLNVTheoThoiGianVaPB("", year));
        
        //add series to chart
        chartTangTruongNV.getData().addAll(series1, series2, series3, series4, series5, series6, series7);
    }

    private NhanVienDAO nvdao;
    private ChamCongDAO ccdao;
    private BangLuongDAO bldao;
    
    @FXML
    private Label lblThuNhap;

    @FXML
    private Label lblSoGIoLamViec;

    @FXML
    private Label lblSLNhanVien;

    @FXML
    private LineChart chartTangTruongNV;

    

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            double plusNum1 = nvdao.getSLNVTheoPhongBan() / 20.0;
            double plusNum2 = bldao.getTongTienLuongTrongNam(2019)/ 20.0;
            double plusNum3 = ccdao.getSoGioLamViec(2019) / 20.0;
            for (int i = 1; i <= 20; i++) {
                int value1 = (int) (i * plusNum1);
                double value2 = i * plusNum2;
                int value3 = (int) (i * plusNum3);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        lblSLNhanVien.setText(value1 + "");
                        lblThuNhap.setText(FormatNumber.formatDouble(value2, "###,###.###"));
                        lblSoGIoLamViec.setText(value3 + "");

                    }
                });

                Thread.sleep(40);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}
