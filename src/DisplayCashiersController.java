import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DisplayCashiersController implements Initializable {
    @FXML
    private TableView CashierTable;

    @FXML
    private TableColumn<Cashier,Integer> cashierCode;

    @FXML
    private TableColumn cashierName;

    @FXML
    private TableColumn employmentStatus;

    @FXML
    private TableColumn joiningDate;

    @FXML
    private TableColumn shiftEndTime;

    @FXML
    private TableColumn shiftStartTime;

    @FXML
    private TableColumn totalHoursWorked;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ArrayList<Cashier> cashiers = Database.get_CashierDetails();

        cashierCode.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("CashierCode"));
        cashierName.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("CashierName"));
        totalHoursWorked.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("TotalHoursWorked"));
        joiningDate.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("JoinDate"));
        shiftStartTime.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("ShiftStart"));
        shiftEndTime.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("EndShift"));
        employmentStatus.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("EmploymentStatus"));
        ObservableList<Cashier> cashier = FXCollections.observableArrayList(cashiers);
        CashierTable.setItems(cashier);

    }

    public void mainMenu(ActionEvent e) throws IOException {
        changeScene(e,"BranchManagerMenu.fxml");
    }
    public void logout(ActionEvent e) throws IOException {
        changeScene(e,"Home.fxml");
    }
    public void changeScene(ActionEvent e, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }
}
