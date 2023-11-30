import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchForItemsBySupplier implements Initializable {
    public TextField code;
    public TableColumn<Item,String> SupplierName;
    public TableColumn<Item,String> ExpiryDate;
    public TableColumn<Item,Integer> Quantity;
    public TableColumn<Item,Double> Price;
    public TableColumn<Item,String> itemName;
    public TableColumn<Item,Integer> ItemID;
    public TableView<Item> ItemTable;
    private ArrayList<Item> Items;
    ObservableList<Item> item ;

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

    public void Search(ActionEvent actionEvent) {

        if (!code.getText().isEmpty()){
            try {
                int searchValue = Integer.parseInt(code.getText());
                Items = Database.searchSupplier(searchValue);
                for (Item item1 : Items) {
                    item1.setSupp_name(code.getText());
                }
                item = FXCollections.observableArrayList(Items);
                ItemTable.setItems(item);
            }catch(Exception e){
                Items = Database.searchSupplier(code.getText());
                for (Item item1 : Items) {
                    item1.setSupp_name(code.getText());
                }
                item = FXCollections.observableArrayList(Items);
                ItemTable.setItems(item);
            }
        }
        else {
            Items = Database.getitemDetails();
            item = FXCollections.observableArrayList(Items);
            ItemTable.setItems(item);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        ExpiryDate.setCellValueFactory(new PropertyValueFactory<>("expiry_date"));
        SupplierName.setCellValueFactory(new PropertyValueFactory<>("supp_name"));
        Items = Database.getitemDetails();
        item = FXCollections.observableArrayList(Items);
        ItemTable.setItems(item);
    }
}
