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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewStockLevels implements Initializable {
    @FXML
    public TableView<Stock> StockTable;
    @FXML
    public TableColumn<Stock,Integer> ItemID;
    @FXML
    public TableColumn<Stock,String> itemName;
    @FXML
    public TextField code;
    @FXML
    public TableColumn<Stock,Integer> MaxStockLevel;
    @FXML
    public TableColumn<Stock,Integer> MinStockLevel;
    @FXML
    public TableColumn<Stock,Integer> CurrStockLevel;
    ArrayList<Stock> Stocks;
    ObservableList<Stock> stock;

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
           Stocks = Database.checkitemStock(Integer.parseInt(code.getText()));
       }
       else {
           Stocks = Database.checkitemStock();
       }
        stock = FXCollections.observableArrayList(Stocks);
        StockTable.setItems(stock);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemID.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<Stock, String>("itemName"));
        MaxStockLevel.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("maxStockLevel"));
        MinStockLevel.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("minStockLevel"));
        CurrStockLevel.setCellValueFactory(new PropertyValueFactory<Stock,Integer>("currStockLevel"));
        Stocks = Database.checkitemStock();
        stock = FXCollections.observableArrayList(Stocks);
        StockTable.setItems(stock);

    }
}
