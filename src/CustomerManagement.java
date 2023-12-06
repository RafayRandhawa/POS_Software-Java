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

public class CustomerManagement implements Initializable {
    @FXML
    public TableColumn<Customer,String> CustomerName;
    @FXML
    public TableColumn<Customer,String> PhoneNumber;
    @FXML
    public TableColumn<Customer,String> Email;
    @FXML
    private TableView<Customer> CustomersTable;

    @FXML
    private TableColumn<Customer,String> Address;

    @FXML
    private TableColumn<Customer,Integer> CustomerID;

    @FXML
    private TableColumn<Customer,String> PaymentMethod;

    HashMap<Customer> hashMapOrder;

    @FXML
    private TextField code;

    private ArrayList<Customer> Customers;
    ObservableList<Customer> customer;
    public void SearchByCustomerID(ActionEvent event) {
        if (!code.getText().isEmpty()){
            Customers = new ArrayList<>();
            Customers.add(hashMapOrder.SearchKey(Integer.parseInt(code.getText())));
            customer = FXCollections.observableArrayList(Customers);
            CustomersTable.setItems(customer);
            code.clear();
        }
        else {
            Customers = Main.getCustomerList();
            customer = FXCollections.observableArrayList(Customers);
            CustomersTable.setItems(customer);
        }
    }
    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BranchManagerMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hashMapOrder = Main.getCustomerMap();
        Customers = Main.getCustomerList();
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        CustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        PaymentMethod.setCellValueFactory(new PropertyValueFactory<>("PaymentMethod"));
        CustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        customer = FXCollections.observableArrayList(Customers);
        CustomersTable.setItems(customer);
    }
}
