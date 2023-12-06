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
    public ToggleGroup delete;
    @FXML
    TextField ItemName;
    @FXML
    TextField Quantity;
    @FXML
    TextField RemoveIndex;
    @FXML
    TableView<Item> CartTable;
    @FXML
    private TableColumn<Item,String> TableItemName;

    @FXML
    private TableColumn<Item,Double> TablePrice;

    @FXML
    private TableColumn<Item,Integer> TableQuantity;
    @FXML
    private TableColumn<Item,Integer> ItemNumber;


    @FXML
    Label total;
    @FXML
    Label discount;
    @FXML
    RadioButton editQuantity;
    @FXML
    RadioButton removeItem;
    @FXML
    TextField nameQuantity;
    @FXML
    TextField nameRemoveItem;

    static double total_amount=0;
    private static int itemNumber = 0;
    static double discounted_amount=0;
    static ObservableList<Item> itemList;
    Stack<Item> cartStack = new Stack<Item>();
    Stack<Item> tempStack = new Stack<Item>();

    public void AddToCart(){
        Item itemtemp = Database.get_itemDetails(ItemName.getText(),Integer.parseInt(Quantity.getText()));
        System.out.println(ItemName.getText()+" "+Quantity.getText());
        itemtemp.setItemNumber(itemNumber+1);
        ++itemNumber;
        Cart.add_item(itemtemp);
        cartStack.push(itemtemp);
        total_amount = 0;
        Stack.Node<Item> curr = cartStack.top;
        while(curr!=null){
            total_amount+=(curr.data.getPrice()*curr.data.getQuantity());
            curr = curr.next;
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
        itemList.add(itemtemp);
        ItemName.clear();
        Quantity.clear();
    }
    public void ProceedToPay(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentScreen.fxml"));
        Scene scene =new Scene(loader.load());
        Main.stg.setScene(scene);
        Main.stg.show();

    }
    public void Delete(ActionEvent e){

        if(editQuantity.isSelected()) {
            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setTitle("Quantity");
            textInputDialog.setContentText("Please enter the quantity of " + nameQuantity.getText() + " to be removed:");
            textInputDialog.showAndWait();
            int quantity = Integer.parseInt(textInputDialog.getEditor().getText());
            Stack.Node<Item> curr = cartStack.top;
            while (curr != null && curr.data.getItemNumber() != Integer.parseInt(nameQuantity.getText())) {
                curr = curr.next;
            }
            if (curr != null){
                if(curr.data.getQuantity()<=quantity){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid Quantity. Quantity entered is greater than current quantity");
                    alert.showAndWait();
                }
                else {
                    int newQuantity = curr.data.getQuantity() - quantity;
                    curr.data.setQuantity((newQuantity));
                    Item temp = itemList.get(Integer.parseInt(nameQuantity.getText())-1);
                    Cart.remove(Integer.parseInt(nameQuantity.getText()));
                    itemList.remove(itemList.get(Integer.parseInt(nameQuantity.getText())-1));
                    Cart.add_item(temp);
                    itemList.add(temp);
                }
            }
        }
        else if (removeItem.isSelected()) {
            Cart.remove(Integer.parseInt(nameRemoveItem.getText()));
            int itemNumber = Integer.parseInt(nameRemoveItem.getText());
            Stack.Node<Item> curr = cartStack.top;
            while(curr!=null && curr.data.getItemNumber() != (itemNumber)){
                tempStack.push(cartStack.pop());
                curr = curr.next;
            }

            cartStack.pop();
            curr = tempStack.top;
            while(curr!=null){
                cartStack.push(tempStack.pop());
                curr = curr.next;
            }

            itemList.remove(itemList.get(Integer.parseInt(nameRemoveItem.getText())-1));
            for (int i = Integer.parseInt(nameRemoveItem.getText())-1; i < itemList.size(); i++) {
                itemList.get(i).setItemNumber(itemList.get(i).getItemNumber()-1);
            }
            --CartController.itemNumber;
        }
        total_amount = 0;
        Stack.Node<Item> curr = cartStack.top;
        while(curr!=null) {
            total_amount += (curr.data.getPrice() * curr.data.getQuantity());
            curr = curr.next;
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
        itemList = FXCollections.observableArrayList(Cart.getInventoryList());
        CartTable.setItems(itemList);
        nameRemoveItem.clear();
        nameQuantity.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        total.setText(" ");
        discount.setText(" ");
        ArrayList<Item> ItemARRAYLIST = Cart.getInventoryList();
        itemList = FXCollections.observableArrayList(ItemARRAYLIST);
        ItemNumber.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemNumber"));
        TableItemName.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        TableQuantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));
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
