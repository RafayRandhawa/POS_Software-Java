import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class StockManagerMenu {
    public Label printStockManagerName;
    @FXML
    Button manageInventory;
    @FXML
    Button manageStocks;
    @FXML
    Button manageSuppliers;
    Button logout;

    public void manageInventory(ActionEvent actionEvent) {
    }

    public void manageSuppliers(ActionEvent actionEvent) {
    }

    public void manageStocks(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }
}
