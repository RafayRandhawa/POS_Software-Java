import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageSalesController implements Initializable {
    @FXML
    TextField search;

    @FXML
    RadioButton code;

    @FXML
    RadioButton ID;

    @FXML
    private TableView<SalesRecord> salesTable;

    @FXML
    private TableColumn<SalesRecord,Integer> salesID;

    @FXML
    private TableColumn<SalesRecord,Integer> cashierCode;

    @FXML
    private TableColumn<SalesRecord,String> saleDate;

    @FXML
    private TableColumn<SalesRecord,String> saleTime;

    @FXML
    private TableColumn<SalesRecord,Double> amount;

    @FXML
    private TableColumn<SalesRecord,Integer> numberOfItems;

    @FXML
    private TableColumn<SalesRecord,String> paymentMethod;
    ArrayList<SalesRecord> salesRecord;
    HashMap<SalesRecord> hashMapSales;
    public void search(ActionEvent e) {
        if(!search.getText().isEmpty()) {
            String input = search.getText();
            int input1 = Integer.parseInt(input);
            if (code.isSelected()) {
                salesRecord = new ArrayList<>();
                salesRecord.add(hashMapSales.SearchKey(input1));
                sales = FXCollections.observableArrayList(salesRecord);
            } else if (ID.isSelected()) {
                salesRecord = new ArrayList<>();
                salesRecord.add(Main.hashMapSalesRecordID.SearchKey(input1));
                sales = FXCollections.observableArrayList(salesRecord);
            }
            salesTable.setItems(sales);
        }
        else{
            sales = FXCollections.observableArrayList(Database.getSalesRecord());
            salesTable.setItems(sales);
        }
    }
    ObservableList<SalesRecord> sales = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        salesRecord = Main.getSalesRecordList();
        hashMapSales = Main.getSalesRecordMap();
        salesID.setCellValueFactory(new PropertyValueFactory<SalesRecord,Integer>("SalesID"));
        cashierCode.setCellValueFactory(new PropertyValueFactory<SalesRecord,Integer>("CashierCode"));
        saleDate.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("SaleDate"));
        saleTime.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("SaleTime"));
        amount.setCellValueFactory(new PropertyValueFactory<SalesRecord,Double>("Amount"));
        numberOfItems.setCellValueFactory(new PropertyValueFactory<SalesRecord,Integer>("NoOfItems"));
        paymentMethod.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("PaymentMethod"));
        sales = FXCollections.observableArrayList(salesRecord);
        salesTable.setItems(sales);

    }
    public void setCashier(Cashier cashier) {

    }

    public void mainMenu(ActionEvent e) throws IOException {
        changeScene(e,"BranchManagerMenu.fxml");
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
