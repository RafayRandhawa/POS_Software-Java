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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateCashierInfo implements Initializable {
    public RadioButton Evening;
    public RadioButton Morning;
    public TextField CashierName;
    public ToggleGroup toggleGroup;
    @FXML
    TextField code;
    @FXML
    private TableView<Cashier> CashierTable;

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
    ObservableList<Cashier> cashier = FXCollections.observableArrayList();

    @FXML
    void Update(ActionEvent event) throws Exception {
        String Shift = "Morning";
        if (Morning.isSelected()){
            Shift = "Morning";
        }
        else if (Evening.isSelected()) {
            Shift = "Evening";
        }
        Database.updateCashierInfo(code.getText(),CashierName.getText(),Shift);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update Status");
        alert.setContentText("Details for Cashier("+code.getText()+") have been updated");
        alert.showAndWait();
        cashiers = Database.get_CashierDetails();
        cashier = FXCollections.observableArrayList(cashiers);
        CashierTable.setItems(cashier);
    }

    @FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    @FXML
    public void mainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BranchManagerMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cashiers = Database.get_CashierDetails();
        Evening.setToggleGroup(toggleGroup);
        Morning.setToggleGroup(toggleGroup);
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
