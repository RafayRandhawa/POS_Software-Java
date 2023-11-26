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

public class ManagerController implements Initializable{
    static boolean verificationStatus = false;
    int tries = 3;
    static String ManagerType = "";
    @FXML
    Label ErrorMessage;
    @FXML
    TextField ManagerUserName;
    @FXML
    PasswordField PasswordFieldManager;
    @FXML
    Button ManagerLoginButton;
    Stage stage;
    public String getManagerUserName() {
        return ManagerUserName.getText();
    }

    public String getPasswordFieldManager() {
        return PasswordFieldManager.getText();
    }
    public void ManagerTypeStock(javafx.event.ActionEvent e)throws Exception{
        ManagerType = "S";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginManager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void ManagerTypeBranch(javafx.event.ActionEvent e)throws Exception{
        ManagerType = "B";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginManager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void verification(javafx.event.ActionEvent e) throws Exception {
        if (tries==0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("LOCKED OUT\nPlease Contact Admin");
            alert.show();
            Main.stg.close();
        }
        Login.setEmployeeType();
        if (Login.verify(ManagerUserName.getText(),PasswordFieldManager.getText())){
            verificationStatus = true;
             new Login().loginPortal();
             if(ManagerType == "B")
                 changeScene(e,"BranchManagerMenu.fxml");

             else
                 changeScene(e,"StockManagerMenu.fxml");
        }
        else{
            tries = tries - 1;
            ErrorMessage.setText("Error!....Please recheck username and password\nYou have "+tries+" attempts remaining before system is locked");
        }

    }
    public void changeScene(ActionEvent e, String temp) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(temp));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ErrorMessage!=null&&tries!=3){
            ErrorMessage.setText(" ");
        }
    }
}
