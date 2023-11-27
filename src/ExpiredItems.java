import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExpiredItems implements Initializable {
    public TableColumn<Item,String> itemName;
    public TableColumn<Item,Integer> ItemID;
    public TableView<Item> ExpiryTable;

    public void mainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StockManagerMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemName.setCellValueFactory(new PropertyValueFactory<Item,String>("itemName"));
        ItemID.setCellValueFactory(new PropertyValueFactory<Item,Integer>("itemID"));
        ArrayList<Item> Items = Database.expDateReturn();
        ObservableList<Item> item = FXCollections.observableArrayList(Items);
        ExpiryTable.setItems(item);
    }
}
