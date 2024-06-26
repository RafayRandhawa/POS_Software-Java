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

public class InventoryManagement implements Initializable {


    public TextField code;
    public TableColumn<Item,Integer> ItemID;
    public TableColumn<Item,String> itemName;
    public TableColumn<Item,Double> Price;
    public TableView<Item> ItemTable;
    public TableColumn<Item,Integer> Quantity;
    public TableColumn<Item,String> ExpiryDate;
    public TableColumn<Item,String> SupplierName;
    ArrayList<Item> Items;
    ObservableList<Item> item;
    HashMap<Item> hashMapItems;
    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StockManagerMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void Search(ActionEvent actionEvent) {
       if (!code.getText().isEmpty()){
           String search = code.getText();
           try {
               int id = Integer.parseInt(search);
               Item tempItem = hashMapItems.SearchKey(id);
               Items = new ArrayList<Item>();
               Items.add(tempItem);
           }
           catch (Exception a){
               Items = Database.getitemDetails(search);
           }

           item = FXCollections.observableArrayList(Items);
           ItemTable.setItems(item);
       }
       else {
           Items = Main.getItemList();
           item = FXCollections.observableArrayList(Items);
           ItemTable.setItems(item);

       }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
        SupplierName.setCellValueFactory(new PropertyValueFactory<Item,String>("supp_name"));
        ExpiryDate.setCellValueFactory(new PropertyValueFactory<Item,String>("expiry_date"));
        hashMapItems = Main.getItemMap();
        Items = Main.getItemList();
        item = FXCollections.observableArrayList(Items);
        ItemTable.setItems(item);

    }
}
