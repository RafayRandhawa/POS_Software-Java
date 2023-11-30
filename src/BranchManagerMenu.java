import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BranchManagerMenu {
    @FXML
    public Button logout;
    @FXML
    Stage stage;
    @FXML
    public Label printBranchManagerName;
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle){
//        ManagerController m = new ManagerController();
//        String name = m.getManagerUserName();
//        printBranchManagerName.setText(name);
//    }
    public void displayName(String username){
        printBranchManagerName.setText(username);
        System.out.println("something");
    }



    public void searchCashierCode(ActionEvent e) throws IOException {
        changeScene(e,"SearchCashierCode.fxml");
    }

    public void registerCashier(ActionEvent e) throws IOException {
        changeScene(e,"RegisterCashier.fxml");
    }

    public void updateCashierInfo(ActionEvent e) throws IOException {
        changeScene(e,"UpdateCashierInfo.fxml");
    }

    public void removeCashier(ActionEvent e) throws IOException {
        changeScene(e,"RemoveCashier.fxml");
    }

//    public void manageSales(ActionEvent e) throws IOException {
//        changeScene(e,"ManageSales.fxml");
//    }

    public void logout(ActionEvent e) throws IOException {
        changeScene(e,"Home.fxml");
    }
    public void changeScene(ActionEvent e, String temp) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(temp));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void OrderManagement(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent,"OrderManagement.fxml");
    }

    public void CustomerManagement(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent,"CustomerManagement.fxml");
    }

    public void salesRecord(ActionEvent e) throws IOException {
        changeScene(e,"ManageSales.fxml");
    }

    public void salesAnalytics(ActionEvent e) throws IOException {
        changeScene(e,"SalesAnalytics.fxml");
    }

    public void inventoryPerformance(ActionEvent actionEvent) {

    }
}
