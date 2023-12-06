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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SalesAnalytics implements Initializable {
    @FXML
    TextField search;

    @FXML
    private TableView<ProdPerformance> prodPerformanceTable;

    @FXML
    private TableColumn<ProdPerformance,Integer> itemID;

    @FXML
    private TableColumn<ProdPerformance,String> itemName;

    @FXML
    private TableColumn<ProdPerformance,Integer> targetS;

    @FXML
    private TableColumn<ProdPerformance,Integer> actualS;

    @FXML
    private TableColumn<ProdPerformance,Integer> avgS;

    @FXML
    private TableColumn<ProdPerformance,Double> profitMargin;

    @FXML
    private TableColumn<ProdPerformance,Double> unitPrice;

    @FXML
    private TableColumn<ProdPerformance,Double> costPrice;

    @FXML
    private TableColumn<ProdPerformance,Integer> salesRank;
    HashMap<ProdPerformance> hashMapProdPerformance;

    ArrayList<ProdPerformance> prodPerformanceList = new ArrayList<>();

    public void search(ActionEvent actionEvent) throws SQLException {
        if(search.getText().isEmpty()){
            prodPerformance = FXCollections.observableArrayList(prodPerformanceList);
            prodPerformanceTable.setItems(prodPerformance);
        }
        else {
            String input = search.getText();
            int input1 = Integer.parseInt(input);
            ArrayList<ProdPerformance> prodPerformanceListTemp = new ArrayList<>();
            ProdPerformance found = hashMapProdPerformance.SearchKey(input1);
            prodPerformanceListTemp.add(found);
            prodPerformance = FXCollections.observableArrayList(prodPerformanceListTemp);
            prodPerformanceTable.setItems(prodPerformance);

            //Get HashMap time
            long HashMapStartTime = System.nanoTime();
            hashMapProdPerformance.SearchKey(input1);
            long HashMapEndTime = System.nanoTime();
            //
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            for (ProdPerformance p : prodPerformanceList) {
                binarySearchTree.insert(p);
            }
            //Get BST time
            long BSTStartTime = System.nanoTime();
            binarySearchTree.SearchValue(binarySearchTree.root,input1);
            long BSTEndTime = System.nanoTime();
            //
            //Get ArrayList time
            long ArrayListStartTime = System.nanoTime();
            long ArrayListEndTime = 0;
            for (ProdPerformance perf :prodPerformanceList) {
                if (perf.getItemID()==input1){
                    ArrayListEndTime = System.nanoTime();
                }
            }

            //
            System.out.println("Hash Map Search Time: "+(HashMapEndTime-HashMapStartTime)+" nanoSeconds");
            System.out.println("Binary Search Tree Search Time: "+(BSTEndTime-BSTStartTime)+" nanoSeconds");
            System.out.println("ArrayList Search Time: "+(ArrayListEndTime-ArrayListStartTime)+" nanoSeconds");
//            System.out.println(HashMapEndTime);
//            System.out.println(HashMapStartTime);
//            System.out.println(BSTEndTime);
//            System.out.println(BSTStartTime);
//            System.out.println(ArrayListEndTime);
//            System.out.println(ArrayListStartTime);
        }
    }
    ObservableList<ProdPerformance> prodPerformance = FXCollections.observableArrayList();
    public void initialize(URL url, ResourceBundle resourceBundle){
        prodPerformanceList = Main.getProdPerformance();
        hashMapProdPerformance = Main.hashMapProdPerformance;
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

    public void descendingSort(ActionEvent actionEvent) {
        prodPerformanceList = Main.getProdPerformance();
        MinHeap minHeap = new MinHeap(prodPerformanceList.size());
        //Get min heap time
        long HeapStartTime = DateAndTime.get_CurrentTime();
        for (ProdPerformance p : prodPerformanceList) {
            minHeap.insert(p);
        }
        prodPerformanceList = new ArrayList<>();
        for (int i = 0; i <minHeap.size; i++) {
            prodPerformanceList.add(minHeap.root());
            minHeap.deleteRoot();
        }
        long HeapEndTime = DateAndTime.get_CurrentTime();
        //

        prodPerformance = FXCollections.observableArrayList(prodPerformanceList);
        prodPerformanceTable.setItems(prodPerformance);
        System.out.println("Heap Time: "+(HeapEndTime-HeapStartTime));

    }
    public void ascendingSort(){
        prodPerformanceList = Main.getProdPerformance();
        MaxHeap maxHeap = new MaxHeap(prodPerformanceList.size());
        for (ProdPerformance p : prodPerformanceList) {
            maxHeap.insert(p);
        }
        prodPerformanceList = new ArrayList<>();
        for (int i = 0; i < maxHeap.size; i++) {
            prodPerformanceList.add(maxHeap.root());
            maxHeap.deleteRoot();
        }
        prodPerformance = FXCollections.observableArrayList(prodPerformanceList);
        prodPerformanceTable.setItems(prodPerformance);
    }
}
