import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HomeDeliveryController {
    public Button logout;
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
        Database.addNewDeliveryOrder(DateAndTime.get_Date(), itemsOrdered.getText(), Integer.parseInt(numberOfItems.getText()), DeliveryDate.getText(), Address.getText(), Double.parseDouble(OrderTotal.getText()), CustomerName.getText(), ContactNumber.getText(), EmailAddress.getText(), PaymentMethod.getText());
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
