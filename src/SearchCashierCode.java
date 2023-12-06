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
    private TableView<Cashier> CashierTable;

    @FXML
    private TableColumn<Cashier,Integer> cashierCode;

    @FXML
    private TableColumn<Cashier,String> cashierName;

    @FXML
    private TableColumn<Cashier,String> employmentStatus;

    @FXML
    private TableColumn<Cashier,String> joiningDate;

    @FXML
    private TableColumn<Cashier,String> shiftEndTime;

    @FXML
    private TableColumn<Cashier,String> shiftStartTime;

    @FXML
    private TableColumn<Cashier,Integer> totalHoursWorked;
    HashMap<Cashier> hashMapCashier;
    ArrayList<Cashier> cashiers;
    public void cashierCode(ActionEvent e) {

        String input = code.getText();
//        cashiers = Database.get_CashierDetails();
        try {
            int input1 = Integer.parseInt(input);
            cashiers = new ArrayList<>();
            cashiers.add(hashMapCashier.SearchKey(input1));
            cashier = FXCollections.observableArrayList(cashiers);
        } catch (Exception e1) {
            cashier = FXCollections.observableArrayList(Login.manager.searchCashierList(input));
        }


        CashierTable.setItems(cashier);
        System.out.println("something");
    }
    ObservableList<Cashier> cashier = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cashiers = Main.getCashierList();
        hashMapCashier = Main.getCashierMap();
        cashierCode.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("CashierCode"));
        cashierName.setCellValueFactory(new PropertyValueFactory<Cashier,String>("CashierName"));
        totalHoursWorked.setCellValueFactory(new PropertyValueFactory<Cashier,Integer>("TotalHoursWorked"));
        joiningDate.setCellValueFactory(new PropertyValueFactory<Cashier,String>("JoinDate"));
        shiftStartTime.setCellValueFactory(new PropertyValueFactory<Cashier,String>("ShiftStart"));
        shiftEndTime.setCellValueFactory(new PropertyValueFactory<Cashier,String>("EndShift"));
        employmentStatus.setCellValueFactory(new PropertyValueFactory<Cashier,String>("EmploymentStatus"));
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
