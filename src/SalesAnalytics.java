import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SalesAnalytics implements Initializable {
    @FXML
    TextField search;

    @FXML
    private TableView<ProdPerformance> prodPerformanceTable;

    @FXML
    private TableColumn itemID;

    @FXML
    private TableColumn itemName;

    @FXML
    private TableColumn targetS;

    @FXML
    private TableColumn actualS;

    @FXML
    private TableColumn avgS;

    @FXML
    private TableColumn profitMargin;

    @FXML
    private TableColumn unitPrice;

    @FXML
    private TableColumn costPrice;

    @FXML
    private TableColumn salesRank;

    ArrayList<ProdPerformance> prodPerformanceList = new ArrayList<>();

    public void search(ActionEvent actionEvent) throws SQLException {
        if(search.getText().isEmpty()){
            prodPerformanceList = Database.displayProdPerformance();
            prodPerformance = FXCollections.observableArrayList(prodPerformanceList);
            prodPerformanceTable.setItems(prodPerformance);
        }
        else {
            String input = search.getText();
            int input1 = Integer.parseInt(input);
            prodPerformance = FXCollections.observableArrayList(Database.displayProdPerformance(input1));
            prodPerformanceTable.setItems(prodPerformance);
        }
    }

    ObservableList<ProdPerformance> prodPerformance = FXCollections.observableArrayList();
    public void initialize(URL url, ResourceBundle resourceBundle){
         prodPerformanceList = Database.displayProdPerformance();

        itemID.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Integer>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<ProdPerformance,String>("ItemName"));
        targetS.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Integer>("targetS"));
        actualS.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Integer>("actualS"));
        avgS.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Integer>("avgS"));
        profitMargin.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Double>("profitMargin"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Double>("unitP"));
        costPrice.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Double>("costP"));
        salesRank.setCellValueFactory(new PropertyValueFactory<ProdPerformance,Integer>("salesRank"));
        prodPerformance = FXCollections.observableArrayList(prodPerformanceList);
        prodPerformanceTable.setItems(prodPerformance);

    }

    public void logout(ActionEvent e) throws IOException {
        changeScene(e,"Home.fxml");
    }

    public void mainMenu(ActionEvent e) throws IOException {
        changeScene(e,"BranchManagerMenu.fxml");
    }
    public void changeScene(ActionEvent e, String temp) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(temp));
        Scene scene = new Scene(fxmlLoader.load());
        Main.stg.setScene(scene);
        Main.stg.show();
    }

}
