import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HomeDeliveryController {
    @FXML
    private TextField Address;

    @FXML
    private TextField ContactNumber;

    @FXML
    private TextField CustomerName;

    @FXML
    private TextField DeliveryDate;

    @FXML
    private TextField EmailAddress;

    @FXML
    private TextField OrderTotal;

    @FXML
    private TextField PaymentMethod;

    @FXML
    private TextField itemsOrdered;

    @FXML
    private TextField numberOfItems;

    public void PlaceOrder(ActionEvent actionEvent) {
        String items = itemsOrdered.getText();
        int number = Integer.parseInt(numberOfItems.getText());
        String date = DeliveryDate.getText();
        String address = Address.getText();
        Double total = Double.parseDouble(OrderTotal.getText());
        String name = CustomerName.getText();
        String cNumber = ContactNumber.getText();
        String email = EmailAddress.getText();
        String payment = PaymentMethod.getText();

        Database.addNewDeliveryOrder(DateAndTime.get_Date(), items, number, date, address, total, name, cNumber, email, payment);
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
