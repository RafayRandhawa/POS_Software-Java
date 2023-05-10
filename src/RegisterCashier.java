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

public class RegisterCashier implements Initializable {
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
    void Add(ActionEvent event) throws Exception {
        String shift = "Morning";
        if (Morning.isSelected()){
            shift = "Morning";
        }
        else if (Evening.isSelected()) {
            shift = "Evening";
        }
        String start="08:00:00",end="16:00:00";
        if(shift.contentEquals("Morning")||shift.contentEquals("morning")){
            start="08:00:00";
            end = "16:00:00";
        }
        else if(shift.contentEquals("Evening")||shift.contentEquals("evening")){
            start="16:00:00";
            end="00:00:00";
        }
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Password Required");
        textInputDialog.setContentText("Please enter a password for the new Cashier");
        textInputDialog.showAndWait();
        String password = textInputDialog.getEditor().getText();
        Database.addNewCashier(CashierName.getText(),DateAndTime.get_Date(),start,end,0,password);
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Addition Status");
//        alert.setContentText("Cashier ("+Database.get_CashierDetails(CashierName.getText()).get(0).getCashierCode()+") has been added");
//        alert.showAndWait();
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
