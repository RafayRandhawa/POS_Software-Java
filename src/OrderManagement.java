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

public class OrderManagement implements Initializable {
    @FXML
    public TableColumn OrderDate;
    @FXML
    public TableColumn OrderStatus;
    @FXML
    public TableColumn OrderTotal;
    @FXML
    private TableView<Order> OrdersTable;

    @FXML
    private TableColumn Address;

    @FXML
    private TableColumn CustomerID;

    @FXML
    private TableColumn DeliveryDate;

    @FXML
    private TableColumn ItemsOrdered;

    @FXML
    private TableColumn NumberOfItems;

    @FXML
    private TableColumn OrderID;


    @FXML
    private TextField code;

    private ArrayList<Order> Orders;
    ObservableList<Order> order;
    public void SearchByOrderID(ActionEvent event) {
        if (!code.getText().isEmpty()){
            Orders = Database.getOrderDetail(Integer.parseInt(code.getText()));
            order = FXCollections.observableArrayList(Orders);
            OrdersTable.setItems(order);
            code.clear();
        }
        else{
            Orders = Database.getOrderDetail();
            order = FXCollections.observableArrayList(Orders);
            OrdersTable.setItems(order);
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
        Orders = Database.getOrderDetail();
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        CustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        DeliveryDate.setCellValueFactory(new PropertyValueFactory<>("DeliveryDate"));
        OrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        OrderStatus.setCellValueFactory(new PropertyValueFactory<>("OrderStatus"));
        OrderTotal.setCellValueFactory(new PropertyValueFactory<>("OrderTotal"));
        ItemsOrdered.setCellValueFactory(new PropertyValueFactory<>("ItemsOrdered"));
        OrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        NumberOfItems.setCellValueFactory(new PropertyValueFactory<>("NumberOfItems"));
        order = FXCollections.observableArrayList(Orders);
        OrdersTable.setItems(order);
    }
}
