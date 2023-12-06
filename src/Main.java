import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application  {

    public static void main(String[] args) {
        launch();
    }

    static Stage stg;
    static HashMap<Cashier> hashMapCashier;
    static HashMap<Supplier> hashMapSupplier;
    static HashMap<Item> hashMapItem;
    static HashMap<Order> hashMapOrder;
    static HashMap<Customer> hashMapCustomer;
    static HashMap<SalesRecord> hashMapSalesRecord;
    static HashMap<SalesRecord> hashMapSalesRecordID;
    static HashMap<ProdPerformance> hashMapProdPerformance;
    static ArrayList<Customer> customerList ;
    static ArrayList<Order> OrderList;
    static ArrayList<Supplier> SupplierList;
    static ArrayList<Item> itemList;
    static ArrayList<SalesRecord> salesRecordList ;
    static ArrayList<ProdPerformance> ProdPerformance;

    public static ArrayList<Cashier> getCashierList() {
        return cashierList;
    }
    static ArrayList<Cashier> cashierList;

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public static ArrayList<Order> getOrderList() {
        return OrderList;
    }

    public static ArrayList<Supplier> getSupplierList() {
        return SupplierList;
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public static ArrayList<SalesRecord> getSalesRecordList() {
        return salesRecordList;
    }

    public static ArrayList<ProdPerformance> getProdPerformance() {
        return ProdPerformance;
    }

    @Override
    public void start(Stage stage) throws Exception {
        SetReset();
        stg = stage;

        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void managerWindow(String fxml) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root2);
    }
    public void cashierLogin(String fxml) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root2);
    }
    public static HashMap<Item> getItemMap(){
        return hashMapItem;
    }
    public static HashMap<Supplier> getSupplierMap(){
        return hashMapSupplier;
    }
    public static HashMap<Order> getOrderMap(){
        return hashMapOrder;
    }
    public static HashMap<Customer> getCustomerMap(){
        return hashMapCustomer;
    }
    public static HashMap<SalesRecord> getSalesRecordMap(){
        return hashMapSalesRecord;
    }
    public static HashMap<Cashier> getCashierMap(){
        return hashMapCashier;
    }

    public static void SetReset() {
        cashierList = Database.get_CashierDetails();
         customerList = Database.getCustomerDetail();
         OrderList = Database.getOrderDetail();
        SupplierList = Database.getSupplierDetails();
         itemList = Database.getitemDetails();
         salesRecordList = Database.getSalesRecord();
         ProdPerformance = Database.displayProdPerformance();
         hashMapProdPerformance = new HashMap<>(ProdPerformance.size());
        for (ProdPerformance prodPerformance:ProdPerformance){
            hashMapProdPerformance.Insert(prodPerformance.getItemID(),prodPerformance);
        }
        hashMapCustomer = new HashMap<>(customerList.size());
        for (Customer customer: customerList) {
            hashMapCustomer.Insert(customer.getCustomerID(),customer);
        }
        hashMapItem = new HashMap<>(itemList.size());
        for (Item item: itemList) {
            hashMapItem.Insert(item.getItemID(),item);
        }
        hashMapSupplier = new HashMap<>(SupplierList.size());
        for (Supplier supplier: SupplierList) {
            hashMapSupplier.Insert(supplier.getSupplierID(),supplier);
        }
        hashMapOrder = new HashMap<>(OrderList.size());
        for (Order order: OrderList) {
            hashMapOrder.Insert(order.getOrderID(),order);
        }
        hashMapSalesRecord = new HashMap<>(salesRecordList.size());
        for (SalesRecord salesRecord: salesRecordList) {
            hashMapSalesRecord.Insert(salesRecord.getSalesID(),salesRecord);
        }
        hashMapCashier = new HashMap<>(cashierList.size());
        for (Cashier cashier: cashierList) {
            hashMapCashier.Insert(cashier.getCashierCode(),cashier);
        }
        hashMapSalesRecordID = new HashMap<>(salesRecordList.size());
        for (SalesRecord salesRecord: salesRecordList) {
            hashMapSalesRecordID.Insert(salesRecord.getCashierCode(),salesRecord);
        }
    }
}