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
    public TableColumn<Order,String> OrderDate;
    @FXML
    public TableColumn<Order,String> OrderStatus;
    @FXML
    public TableColumn<Order,Double> OrderTotal;
    @FXML
    private TableView<Order> OrdersTable;

    @FXML
    private TableColumn<Order,String> Address;

    @FXML
    private TableColumn<Order,Integer> CustomerID;

    @FXML
    private TableColumn<Order,String> DeliveryDate;

    @FXML
    private TableColumn<Order,String> ItemsOrdered;

    @FXML
    private TableColumn<Order,Integer> NumberOfItems;

    @FXML
    private TableColumn<Order,Integer> OrderID;


    @FXML
    private TextField code;
    private ArrayList<Order> Orders;
    HashMap<Order> hashMapOrder;
    ObservableList<Order> order;
    public void SearchByOrderID(ActionEvent event) {
        if (!code.getText().isEmpty()){
            Orders = new ArrayList<>();
            Orders.add(hashMapOrder.SearchKey(Integer.parseInt(code.getText())));
            order = FXCollections.observableArrayList(Orders);
            OrdersTable.setItems(order);
            code.clear();
        }
        else{
            Orders = Main.getOrderList();
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
        hashMapOrder = Main.getOrderMap();
        Orders = Main.getOrderList();
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
