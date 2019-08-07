
package Home.helper;

import Home.controller.NhanVienController;
import Home.controller.ToChucController;
import Home.model.TaiKhoan;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Share {
    
    public static Stage mainStage = null;
    public static BorderPane mainPane;
    public static NhanVienController nvController;
    public static ToChucController tcController;
    
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static TaiKhoan USER = null;

    /**
     * Đối tượng này chứa mã Phòng ban mà tài khoản quản lý
     */
    public static Object MAPB = null;
    
    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logOut() {
        Share.USER = null;
    }
}