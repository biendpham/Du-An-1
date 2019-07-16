/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author nucle
 */
public class ChamCongController implements Initializable {

    @FXML
    private TableView<TableChamCong> tblChamCong;

    private ObservableList<TableChamCong> data = FXCollections.observableArrayList();

    @FXML
    private BarChart chartTyLeDiLam;
    
    @FXML
    private PieChart chartTyLeNgayLamViec;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setChartTyLeDiLam();
        setChartTyLeNgayLamViec();
        setDataTable();
        
    }

    private void setDataTable(){
        setColumnModel();

        TableChamCong tableChamCong = new TableChamCong();
        tableChamCong.setMaNV("IT001");
        tableChamCong.setHoTen("Phạm Duy Biên");
        tableChamCong.setPhongBan("Kỹ thuật");
        tableChamCong.setNgay1(true);
        tableChamCong.setNgay2(false);
        tableChamCong.setNgay3(true);
        tableChamCong.setNgay4(true);
        tableChamCong.setNgay5(true);
        tableChamCong.setNgay6(true);
        tableChamCong.setNgay7(false);
        tableChamCong.setNgay8(true);
        tableChamCong.setNgay9(true);
        tableChamCong.setNgay10(true);
        tableChamCong.setNgay11(true);
        tableChamCong.setNgay12(true);
        tableChamCong.setNgay13(true);
        tableChamCong.setNgay14(true);
        tableChamCong.setNgay15(true);
        tableChamCong.setNgay16(true);
        tableChamCong.setNgay17(true);
        tableChamCong.setNgay18(false);
        tableChamCong.setNgay19(true);
        tableChamCong.setNgay20(true);
        tableChamCong.setNgay21(true);
        tableChamCong.setNgay22(true);
        tableChamCong.setNgay23(true);
        tableChamCong.setNgay24(true);
        tableChamCong.setNgay25(false);
        tableChamCong.setNgay26(true);
        tableChamCong.setNgay27(true);
        tableChamCong.setNgay28(true);
        tableChamCong.setNgay29(true);
        tableChamCong.setNgay30(true);
        tableChamCong.setNgay31(false);
        data.add(tableChamCong);
        tblChamCong.setItems(data);
    }
    
    private void setColumnModel() {
        //Khai bao cot
        col1 = new TableColumn<>("Mã nhân viên");
        col1.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        col2 = new TableColumn<>("Họ tên");
        col2.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        col3 = new TableColumn<>("Phòng ban");
        col3.setCellValueFactory(new PropertyValueFactory<>("phongBan"));
        dateCol = new TableColumn<>("Ngày tháng");
        col4 = new TableColumn<>("Ngày1");
        col5 = new TableColumn<>("Ngày2");
        col6 = new TableColumn<>("Ngày3");
        col7 = new TableColumn<>("Ngày4");
        col8 = new TableColumn<>("Ngày5");
        col9 = new TableColumn<>("Ngày6");
        col10 = new TableColumn<>("Ngày7");
        col11 = new TableColumn<>("Ngày8");
        col12 = new TableColumn<>("Ngày9");
        col13 = new TableColumn<>("Ngày10");
        col14 = new TableColumn<>("Ngày11");
        col15 = new TableColumn<>("Ngày12");
        col16 = new TableColumn<>("Ngày13");
        col17 = new TableColumn<>("Ngày14");
        col18 = new TableColumn<>("Ngày15");
        col19 = new TableColumn<>("Ngày16");
        col20 = new TableColumn<>("Ngày17");
        col21 = new TableColumn<>("Ngày18");
        col22 = new TableColumn<>("Ngày19");
        col23 = new TableColumn<>("Ngày20");
        col24 = new TableColumn<>("Ngày21");
        col25 = new TableColumn<>("Ngày22");
        col26 = new TableColumn<>("Ngày23");
        col27 = new TableColumn<>("Ngày24");
        col28 = new TableColumn<>("Ngày25");
        col29 = new TableColumn<>("Ngày26");
        col30 = new TableColumn<>("Ngày27");
        col31 = new TableColumn<>("Ngày28");
        col32 = new TableColumn<>("Ngày29");
        col33 = new TableColumn<>("Ngày30");
        col34 = new TableColumn<>("Ngày31");
        //them cot 35 de cot 34 ko bi thieu do dai
        col35 = new TableColumn<>("  ");

        //dinh dang CheckBox cho cac cot
        col4.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay1());
                return booleanProp;
            }
        });
        col4.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col5.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay2());
                return booleanProp;
            }
        });
        col5.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col6.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay3());
                return booleanProp;
            }
        });
        col6.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col7.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay4());
                return booleanProp;
            }
        });
        col7.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col8.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay5());
                return booleanProp;
            }
        });
        col8.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col9.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay6());
                return booleanProp;
            }
        });
        col9.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col10.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay7());
                return booleanProp;
            }
        });
        col10.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col11.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay8());
                return booleanProp;
            }
        });
        col11.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col12.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay9());
                return booleanProp;
            }
        });
        col12.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col13.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay10());
                return booleanProp;
            }
        });
        col13.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col14.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay11());
                return booleanProp;
            }
        });
        col14.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col15.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay12());
                return booleanProp;
            }
        });
        col15.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col16.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay13());
                return booleanProp;
            }
        });
        col16.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col17.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay14());
                return booleanProp;
            }
        });
        col17.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col18.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay15());
                return booleanProp;
            }
        });
        col18.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col19.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay16());
                return booleanProp;
            }
        });
        col19.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col20.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay17());
                return booleanProp;
            }
        });
        col20.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col21.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay18());
                return booleanProp;
            }
        });
        col21.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col22.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay19());
                return booleanProp;
            }
        });
        col22.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col23.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay20());
                return booleanProp;
            }
        });
        col23.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col24.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay21());
                return booleanProp;
            }
        });
        col24.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col25.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay22());
                return booleanProp;
            }
        });
        col25.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col26.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay23());
                return booleanProp;
            }
        });
        col26.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col27.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay24());
                return booleanProp;
            }
        });
        col27.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col28.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay25());
                return booleanProp;
            }
        });
        col28.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col29.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay26());
                return booleanProp;
            }
        });
        col29.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col30.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay27());
                return booleanProp;
            }
        });
        col30.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col31.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay28());
                return booleanProp;
            }
        });
        col31.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col32.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay29());
                return booleanProp;
            }
        });
        col32.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col33.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay30());
                return booleanProp;
            }
        });
        col33.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        col34.setCellValueFactory(new Callback<CellDataFeatures<TableChamCong, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<TableChamCong, Boolean> param) {
                TableChamCong obj = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(obj.getNgay31());
                return booleanProp;
            }
        });
        col34.setCellFactory(new Callback<TableColumn<TableChamCong, Boolean>, TableCell<TableChamCong, Boolean>>() {
            @Override
            public TableCell<TableChamCong, Boolean> call(TableColumn<TableChamCong, Boolean> p) {
                CheckBoxTableCell<TableChamCong, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        dateCol.getColumns().addAll(col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16, col17,
                col18, col19, col20, col21, col22, col23, col24, col25, col26, col27, col28, col29, col30, col31, col32, col33, col34, col35);

        tblChamCong.getColumns().addAll(col1, col2, col3, dateCol);
    }

    
    
    private void setChartTyLeDiLam() {
        
        XYChart.Series col = new XYChart.Series<>();
        
        col.getData().add(new XYChart.Data(98.0, "Tất cả"));
        col.getData().add(new XYChart.Data(98.0, "Kỹ thuậṭ"));
        col.getData().add(new XYChart.Data(89.0, "Kế toáṇ"));
        col.getData().add(new XYChart.Data(100, "Marketting̣"));
        col.getData().add(new XYChart.Data(90.5, "Nhân sự"));
        col.getData().add(new XYChart.Data(90.5, "Bán hàng̣"));
        col.getData().add(new XYChart.Data(100, "Giám đốc̣"));

        chartTyLeDiLam.getData().add(col);
        chartTyLeDiLam.setTitle("Tỷ lệ nhân viên đi làm đầy đủ");
    }
    
    private void setChartTyLeNgayLamViec(){
        PieChart.Data slice1 = new PieChart.Data("Ngày làm việc", 26);

        PieChart.Data slice2 = new PieChart.Data("CN, ngày lễ", 5);

        chartTyLeNgayLamViec.getData().add(slice1);
        chartTyLeNgayLamViec.getData().add(slice2);
    }

    private TableColumn<TableChamCong, String> col1;
    private TableColumn<TableChamCong, String> col2;
    private TableColumn<TableChamCong, String> col3;
    private TableColumn<TableChamCong, String> dateCol;
    private TableColumn<TableChamCong, Boolean> col4;
    private TableColumn<TableChamCong, Boolean> col5;
    private TableColumn<TableChamCong, Boolean> col6;
    private TableColumn<TableChamCong, Boolean> col7;
    private TableColumn<TableChamCong, Boolean> col8;
    private TableColumn<TableChamCong, Boolean> col9;
    private TableColumn<TableChamCong, Boolean> col10;
    private TableColumn<TableChamCong, Boolean> col11;
    private TableColumn<TableChamCong, Boolean> col12;
    private TableColumn<TableChamCong, Boolean> col13;
    private TableColumn<TableChamCong, Boolean> col14;
    private TableColumn<TableChamCong, Boolean> col15;
    private TableColumn<TableChamCong, Boolean> col16;
    private TableColumn<TableChamCong, Boolean> col17;
    private TableColumn<TableChamCong, Boolean> col18;
    private TableColumn<TableChamCong, Boolean> col19;
    private TableColumn<TableChamCong, Boolean> col20;
    private TableColumn<TableChamCong, Boolean> col21;
    private TableColumn<TableChamCong, Boolean> col22;
    private TableColumn<TableChamCong, Boolean> col23;
    private TableColumn<TableChamCong, Boolean> col24;
    private TableColumn<TableChamCong, Boolean> col25;
    private TableColumn<TableChamCong, Boolean> col26;
    private TableColumn<TableChamCong, Boolean> col27;
    private TableColumn<TableChamCong, Boolean> col28;
    private TableColumn<TableChamCong, Boolean> col29;
    private TableColumn<TableChamCong, Boolean> col30;
    private TableColumn<TableChamCong, Boolean> col31;
    private TableColumn<TableChamCong, Boolean> col32;
    private TableColumn<TableChamCong, Boolean> col33;
    private TableColumn<TableChamCong, Boolean> col34;
    private TableColumn<TableChamCong, String> col35;
}