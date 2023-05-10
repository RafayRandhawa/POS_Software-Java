import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.io.IOException;

public class BranchManagerMenu {

    Stage stage;

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
    public void manageDeliveryOrders(ActionEvent e) throws IOException {
        changeScene(e,"ManageDeliveryOrders.fxml");
    }


    public void manageSales(ActionEvent e) throws IOException {
        changeScene(e,"ManageSales.fxml");
    }

    public void logout(ActionEvent e) throws IOException {
        changeScene(e,"Home.fxml");
    }
    public void changeScene(ActionEvent e, String temp) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(temp));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }
}
