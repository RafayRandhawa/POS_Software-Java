import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class CashierController {

    public void RetailStore(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RetailStore.fxml"));
        Scene scene =new Scene(loader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }


    public void HomeDelivery(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home_Delivery.fxml"));
        Scene scene =new Scene(loader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }
}
