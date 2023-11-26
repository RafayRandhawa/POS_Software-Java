import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CashierLogin implements Initializable {
    static boolean verificationStatus = false;
    public static int CashierCode;
    int tries = 3;
    @FXML
    TextField CashierUserName;
    @FXML
    PasswordField PasswordFieldCashier;
    @FXML
    Label ErrorMessage;
    @FXML
    Button CashierLoginButton;

    public String getPasswordFieldCashier() {
        return PasswordFieldCashier.getText();
    }

    public void verification(ActionEvent e) throws Exception {
        if (tries==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("LOCKED OUT\nPlease Contact Manager");
            alert.show();
            Main.stg.close();
        }
        Login.setEmployeeType();
        CashierCode = Integer.parseInt(CashierUserName.getText());
        if (Login.verify(CashierCode,PasswordFieldCashier.getText())){
            verificationStatus = true;
            new Login().loginPortal();
            switchScene();
        }
        else{
            tries = tries - 1;
            ErrorMessage.setText("Error!....Please recheck Cashier Code and password\nYou have "+tries+" attempts remaining before system is locked");
        }
    }
    public void switchScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CashierSelection.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ErrorMessage!=null&&tries!=3){
            ErrorMessage.setText(" ");
        }
        CashierUserName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    if (!t1.matches("\\d*")) {
                        CashierUserName.setText(t1.replaceAll("[^\\d]", ""));
                    }
            }
        });
    }
}