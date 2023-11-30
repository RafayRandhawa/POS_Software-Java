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
import java.util.List;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    @FXML
    TextField ItemName;
    @FXML
    TextField Quantity;
    @FXML
    TextField RemoveIndex;
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

    @FXML
    Label total;
    @FXML
    Label discount;
    static double total_amount=0;
    private static int itemNumber = 0;
    static double discounted_amount=0;
    static ObservableList<Item> itemList;

    public void AddToCart(){
        Item itemtemp = Database.get_itemDetails(ItemName.getText(),Integer.parseInt(Quantity.getText()));
        System.out.println(ItemName.getText()+" "+Quantity.getText());
        itemtemp.setItemNumber(itemNumber+1);
        if (itemtemp.getQuantity()==-1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Quantity required is more than present in stock");
            alert.showAndWait();
            ItemName.clear();
            Quantity.clear();
        }
        else {
            ++itemNumber;
            Cart.add_item(itemtemp);
            total_amount = 0;
            for(Item item:Cart.getInventoryList()){
                total_amount+=(item.getPrice()* item.getQuantity());
            }
            total.setText(String.format("%.2f",new BigDecimal(total_amount)));

            if(total_amount>=100){
                discounted_amount=total_amount-(total_amount*0.05);
            }
            else if(total_amount>=50){
                discounted_amount=total_amount-(total_amount*0.02);
            }
            else {
                discounted_amount=total_amount;
            }
            discount.setText(String.format("%.2f",new BigDecimal(discounted_amount)));
            System.out.println(Database.get_itemDetails(ItemName.getText(),Integer.parseInt(Quantity.getText())).getItemNumber());
            itemList.add(itemtemp);
            ItemName.clear();
            Quantity.clear();
        }
    }
    public void ProceedToPay(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentScreen.fxml"));
        Scene scene =new Scene(loader.load());
        Main.stg.setScene(scene);
        Main.stg.show();

    }
    public void Delete(ActionEvent e){
        Cart.remove(Integer.parseInt(RemoveIndex.getText()));
        total_amount = 0;
        for(Item item:Cart.getInventoryList()){
            total_amount=(item.getPrice()* item.getQuantity());
        }
        total.setText(String.format("%.2f",new BigDecimal(total_amount)));

        if(total_amount>=100){
            discounted_amount=total_amount-(total_amount*0.05);
        }
        else if(total_amount>=50){
            discounted_amount=total_amount-(total_amount*0.02);
        }
        else {
            discounted_amount=total_amount;
        }
        discount.setText(String.format("%.2f",new BigDecimal(discounted_amount)));
        itemList.remove(itemList.get(Integer.parseInt(RemoveIndex.getText())-1));
        for (int i = Integer.parseInt(RemoveIndex.getText())-1; i < itemList.size(); i++) {
            itemList.get(i).setItemNumber(itemList.get(i).getItemNumber()-1);
        }

        CartTable.setItems(itemList);
        RemoveIndex.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        total.setText(" ");
        discount.setText(" ");
        ArrayList<Item> ItemARRAYLIST = Cart.getInventoryList();
        itemList = FXCollections.observableArrayList(ItemARRAYLIST);
        ItemNumber.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemNumber"));
        TableItemName.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemName"));
        TableQuantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<Item, Integer>("price"));
        CartTable.setItems(itemList);
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CashierSelection.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }
}
