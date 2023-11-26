import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {
    @FXML
    private Button managerButton;

    @FXML
    private Button cashierButton;
    static String employeeType="";
    public void onManagerButtonClick(javafx.event.ActionEvent actionEvent) throws Exception {
        Main main = new Main();
        employeeType = "M";
        main.managerWindow("ManagerSelection.fxml");
    }

    public void onCashierButtonClick(javafx.event.ActionEvent actionEvent) throws Exception {
        Main main = new Main();
        employeeType = "C";
        main.cashierLogin("CashierLogin.fxml");
    }
}
