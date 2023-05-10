import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class RemoveCashier implements Initializable {
    public TextField code;
    public TableView CashierTable;
    public TableColumn cashierCode;
    public TableColumn cashierName;
    public TableColumn joiningDate;
    public TableColumn shiftStartTime;
    public TableColumn shiftEndTime;
    public TableColumn totalHoursWorked;
    public TableColumn employmentStatus;
    ArrayList<Cashier> cashiers;
    ObservableList<Cashier> cashier = FXCollections.observableArrayList();

    public void cashierCode(ActionEvent actionEvent) {
        Database.removeCashier(Integer.parseInt(code.getText()));
        cashiers = Database.get_CashierDetails();
        cashier = FXCollections.observableArrayList(cashiers);
        CashierTable.setItems(cashier);
    }

    public void mainMenu(ActionEvent e) throws IOException {
        changeScene(e,"BranchManagerMenu.fxml");
    }

    public void logout(ActionEvent e) throws IOException {
        changeScene(e,"Home.fxml");
    }
    public void changeScene(ActionEvent e, String temp) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(temp));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cashiers = Database.get_CashierDetails();

        cashierCode.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("CashierCode"));
        cashierName.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("CashierName"));
        totalHoursWorked.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("TotalHoursWorked"));
        joiningDate.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("JoinDate"));
        shiftStartTime.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("ShiftStart"));
        shiftEndTime.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("EndShift"));
        employmentStatus.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("EmploymentStatus"));
        cashier = FXCollections.observableArrayList(cashiers);
        CashierTable.setItems(cashier);

    }
}
