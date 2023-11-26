import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddToInventory implements Initializable {
    @FXML
    private TextField CurrStockLevel;


    @FXML
    private TextField ExpiryDateText;


    @FXML
    private TextField MInStockLEv;

    @FXML
    private TextField MaxStockLev;



    @FXML
    private TextField PriceText;



    @FXML
    private TextField QuantityText;



    @FXML
    private TextField SupplierNameText;



    @FXML
    private TextField itemNameText;
    public TableColumn<Item,Integer> ItemID;
    public TableColumn<Item,String> itemName;
    public TableColumn<Item,Double> Price;
    public TableView<Item> ItemTable;
    public TableColumn<Item,Integer> Quantity;
    public TableColumn<Item,String> ExpiryDate;
    public TableColumn<Item,String> SupplierName;
    ArrayList<Item> Items;
    ObservableList<Item> item;
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

    public void Add(ActionEvent actionEvent) throws SQLException {
        Database.addNewItemInv(itemNameText.getText(),Double.parseDouble(PriceText.getText()),Integer.parseInt(QuantityText.getText()),ExpiryDateText.getText(),Integer.parseInt(CurrStockLevel.getText()),Integer.parseInt(MaxStockLev.getText()),Integer.parseInt(MInStockLEv.getText()),SupplierNameText.getText());
        Items = Database.getitemDetails();
        item = FXCollections.observableArrayList(Items);
        ItemTable.setItems(item);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemID.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
        SupplierName.setCellValueFactory(new PropertyValueFactory<Item,String>("supp_name"));
        ExpiryDate.setCellValueFactory(new PropertyValueFactory<Item,String>("expiry_date"));
        Items = Database.getitemDetails();
        item = FXCollections.observableArrayList(Items);
        ItemTable.setItems(item);

    }
}
