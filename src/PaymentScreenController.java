import com.sun.webkit.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class PaymentScreenController implements Initializable {
    public Label ModeOfPayment;
    public Label CashReturned;
    public Label AmountReceived;
    public Label FinalAmount;
    @FXML
    private RadioButton Crd,Mst,Dbt,Cash,Visa;
    @FXML
    private Label Cashier;

    @FXML
    private Label Date;

    @FXML
    private Label SalesID;

    @FXML
    private Label Shift;
    @FXML
    TableView<Item> CartTable;
    @FXML
    private TableColumn TableItemName;

    @FXML
    private TableColumn TablePrice;

    @FXML
    private TableColumn TableQuantity;
    @FXML
    private TableColumn ItemNumber;
    static double cashReceived = CartController.discounted_amount;;
    static String PaymentMethod;
    public void PaymentChoice(ActionEvent e) throws Exception {
        if (Crd.isSelected()){
            PaymentMethod = "Credit Card";
        } else if (Mst.isSelected()) {
            PaymentMethod = "Master Card";
        } else if (Dbt.isSelected()) {
            PaymentMethod = "Debit Card";
        } else if (Cash.isSelected()) {
            PaymentMethod = "Cash";
            while (cashReceived<CartController.discounted_amount){
                TextInputDialog CashReceived= new TextInputDialog();
                CashReceived.setTitle("Enter Cash Received");
                Optional<String> result = CashReceived.showAndWait();
                if (result.isPresent()){
                    cashReceived = Double.parseDouble(CashReceived.getEditor().getText());
                }

            }
        } else if (Visa.isSelected()) {
            PaymentMethod = "Visa Card";
        }
        else PaymentMethod = "Cash";
        Database.add_SalesRecord(Login.cashier.getCashierCode(), DateAndTime.get_Date(),DateAndTime.get_Time(),CartController.discounted_amount,Cart.getInventoryListSize(),PaymentMethod);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentScreen2.fxml"));
        Scene scene =new Scene(loader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Cashier!=null&&Date!=null&&SalesID!=null&&Shift!=null){
            Cashier.setText(Login.cashier.getCashierName());
            Date.setText(DateAndTime.get_Date()+"\tTime: "+DateAndTime.get_Time());
            SalesID.setText(String.valueOf(Database.getSalesID()));
            Shift.setText(Login.cashier.getShiftStart()+"-"+Login.cashier.getEndShift());
            FinalAmount.setText(String.format("%.2f",new BigDecimal(CartController.discounted_amount)));
            AmountReceived.setText(String.valueOf(cashReceived));
            CashReturned.setText(String.format("%.2f",new BigDecimal(cashReceived-CartController.discounted_amount)));
            ModeOfPayment.setText(PaymentMethod);

            ItemNumber.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemNumber"));
            TableItemName.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemName"));
            TableQuantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
            TablePrice.setCellValueFactory(new PropertyValueFactory<Item, Integer>("price"));
            CartTable.setItems(CartController.itemList);
        }
    }
}
