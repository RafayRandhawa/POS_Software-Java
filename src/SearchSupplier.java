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

public class SearchSupplier implements Initializable {
    @FXML
    private TableColumn<Supplier, String> Address;

    @FXML
    private TableColumn<Supplier, String> City;

    @FXML
    private TableColumn<Supplier, String> ContactNumber;

    @FXML
    private TableColumn<Supplier, String> ContactTitle;

    @FXML
    private TableColumn<Supplier, String> Country;

    @FXML
    private TableColumn<Supplier, String> Email;

    @FXML
    private TableColumn<Supplier, String> Fax;

    @FXML
    private TableColumn<Supplier, String> Phone;

    @FXML
    private TableColumn<Supplier, String> PostalCode;

    @FXML
    private TableColumn<Supplier, String> Region;

    @FXML
    private TableColumn<Supplier, Integer> SupplierID;

    @FXML
    private TableColumn<Supplier, String> SupplierName;

    @FXML
    private TableView<Supplier> SupplierTable;

    @FXML
    private TableColumn<Supplier, String> Website;

    @FXML
    private TextField code;
    ArrayList<Supplier> Suppliers;
    ObservableList<Supplier> supplier;
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
            Suppliers = Database.supplierSearch(code.getText());
            supplier = FXCollections.observableArrayList(Suppliers);
            SupplierTable.setItems(supplier);
        }
        else {
            Suppliers = Database.supplierSearch();
            supplier = FXCollections.observableArrayList(Suppliers);
            SupplierTable.setItems(supplier);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SupplierID.setCellValueFactory(new PropertyValueFactory<Supplier,Integer>("SupplierID"));
        SupplierName.setCellValueFactory(new PropertyValueFactory<Supplier,String>("SupplierName"));
        Address.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Address"));
        Phone.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Phone"));
        PostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        Fax.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Fax"));
        Region.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Region"));
        Country.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Country"));
        Email.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Email"));
        Website.setCellValueFactory(new PropertyValueFactory<Supplier,String>("Website"));
        ContactTitle.setCellValueFactory(new PropertyValueFactory<Supplier,String>("ContactTitle"));
        ContactNumber.setCellValueFactory(new PropertyValueFactory<Supplier,String>("ContactNumber"));
        City.setCellValueFactory(new PropertyValueFactory<Supplier,String>("City"));
        Suppliers = Database.supplierSearch();
        supplier = FXCollections.observableArrayList(Suppliers);
        SupplierTable.setItems(supplier);
    }
}
