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
    private TableView salesTable;

    @FXML
    private TableColumn salesID;

    @FXML
    private TableColumn cashierCode;

    @FXML
    private TableColumn saleDate;

    @FXML
    private TableColumn saleTime;

    @FXML
    private TableColumn amount;

    @FXML
    private TableColumn numberOfItems;

    @FXML
    private TableColumn paymentMethod;
    ArrayList<SalesRecord> salesRecord;
    public void search(ActionEvent e) {
        if(!search.getText().isEmpty()) {
            String input = search.getText();
            int input1 = Integer.parseInt(input);
            if (code.isSelected()) {
                sales = FXCollections.observableArrayList(Database.getSalesRecord(input1));
            } else if (ID.isSelected()) {
                sales = FXCollections.observableArrayList(Database.getSalesRecordID(input1));
            }
//        cashiers = Database.get_CashierDetails();


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
        salesRecord = Database.getSalesRecord();

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
