package Home.helper;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.control.Alert;

public class Validate {

    //Hiện thông báo lỗi của JFX
    public static RequiredFieldValidator createValidatorJFX(String errMessage) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(errMessage);
        validator.setIcon(new Picture().createImageView("warning16px.png"));
        return validator;
    }

    //Kiểm lỗi TextField not null
    public static boolean isNull(JFXTextField txt, String errMessage) {
        try {
            if (txt.getText().trim().equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            CustomDialog.showAlert(Alert.AlertType.WARNING, errMessage);
            txt.requestFocus();
            return true;
        }
        return false;
    }

    //Kiểm lỗi PasswordField not null
    public static boolean isNull(JFXPasswordField txt, String errMessage) {
        try {
            if (txt.getText().trim().equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            CustomDialog.showAlert(Alert.AlertType.WARNING, errMessage);
            txt.requestFocus();
            return true;
        }
        return false;
    }

    //Kiểm lỗi Combobox chưa được chọn giá trị
    public static boolean isNotSelected(JFXComboBox cbo, String errMessage) {
        try {
            if (cbo.getSelectionModel().getSelectedIndex() == -1) {
                throw new Exception();
            }
        } catch (Exception e) {
            CustomDialog.showAlert(Alert.AlertType.WARNING, errMessage);
            return true;
        }

        return false;
    }

    //Kiểm lỗi TextField không đúng với mẫu
    public static boolean isNotMatches(JFXTextField txt, String regex, String errMessage) {
        try {
            if (!txt.getText().matches(regex)) {
                throw new Exception();
            }
        } catch (Exception e) {
            CustomDialog.showAlert(Alert.AlertType.WARNING, errMessage);
            txt.requestFocus();
            return true;
        }

        return false;
    }
    
    //Kiểm lỗi xác nhận Password không giống với password
    public static boolean isNotMatches(JFXPasswordField pass, JFXPasswordField pass2, String errMessage) {
        try {
            if (!pass2.getText().matches(pass.getText())) {
                throw new Exception();
            }
        } catch (Exception e) {
            CustomDialog.showAlert(Alert.AlertType.WARNING, errMessage);
            pass2.requestFocus();
            return true;
        }

        return false;
    }
}