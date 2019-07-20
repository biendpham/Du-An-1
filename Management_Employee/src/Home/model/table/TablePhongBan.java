
package Home.model.table;

import Home.common.Picture;
import Home.model.NhanVien;
import javafx.scene.control.Button;

public class TablePhongBan {
    private Button Delete;
    private Button Update;
    private String MaPB;
    private String TenPB;
    private NhanVien TruongPhong;
    
    public TablePhongBan(){
    
    }
    
    public TablePhongBan(String MaPB,String TenPB,NhanVien TruongPhong){
        this.MaPB = MaPB;
        this.TenPB = TenPB;
        this.TruongPhong = TruongPhong;
        
        Picture picture = new Picture();
        this.Delete = new Button("", picture.createIcone("delete.png"));
        this.Update = new Button("", picture.createIcone("edit.png"));
    }

    public Button getDelete() {
        return Delete;
    }

    public void setDelete(Button Delete) {
        this.Delete = Delete;
    }

    public Button getUpdate() {
        return Update;
    }

    public void setUpdate(Button Update) {
        this.Update = Update;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }

    public NhanVien getTruongPhong() {
        return TruongPhong;
    }

    public void setTruongPhong(NhanVien TruongPhong) {
        this.TruongPhong = TruongPhong;
    }
    
    
}