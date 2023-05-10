import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

//        Login.loginPortal();
//        if(!Login.proceed) System.exit(1001);
//        if (Login.employeeType == Employee_type.Cashier) {
//            cashier_menu.menu();
//        }
//        else if (Login.employeeType == Employee_type.BranchManager){
//            manager_menu.menu();
//        }
//        else if (Login.employeeType == Employee_type.StockManager) {
//            stockmanager_menu.menu();
//        }

        launch();
    }

    static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;

        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void managerWindow(String fxml) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root2);
    }
    public void cashierLogin(String fxml) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root2);
    }
}