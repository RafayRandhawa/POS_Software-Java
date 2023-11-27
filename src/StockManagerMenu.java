import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;

import java.io.IOException;

public class StockManagerMenu {


    public MenuButton manageInventory;
    public Label printStockManagerName;
    public MenuButton manageStocks;
    public MenuButton manageSuppliers;

    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void search(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchInventory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void Add(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddtoInventory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void Remove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveFromInventory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void StockMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewStockLevels.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void ExpiredItems(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExpiredItems.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void ViewSupplier(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchSupplier.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void SearchhForItems(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchForItemsBySupplier.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }
}
