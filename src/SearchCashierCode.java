import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class SearchCashierCode implements Initializable {
    @FXML
    TextField code;
    @FXML
    private TableView CashierTable;

    @FXML
    private TableColumn cashierCode;

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
    ArrayList<Cashier> cashiers;
    public void cashierCode(ActionEvent e) {

        String input = code.getText();
//        cashiers = Database.get_CashierDetails();
        try {
            int input1 = Integer.parseInt(input);
            cashier = FXCollections.observableArrayList(Login.manager.searchCashierList(input1));
        } catch (Exception e1) {
            cashier = FXCollections.observableArrayList(Login.manager.searchCashierList(input));
        }


        CashierTable.setItems(cashier);
        System.out.println("something");
    }
    ObservableList<Cashier> cashier = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
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
}
