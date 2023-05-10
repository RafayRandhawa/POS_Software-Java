import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Scanner;

enum Employee_type{
    BranchManager,
    StockManager,
    Cashier,
    Invalid
};
public class Login  {
    public static String name="";
    public static Employee_type employeeType;
    public static Cashier cashier;
    public static Manager manager;
    public static StockManager stockManager;
    public static boolean proceed=false;
    public static void setEmployeeType(){
        if(ManagerController.ManagerType.contentEquals("B")){
            employeeType = Employee_type.BranchManager;
//            System.out.println("yup b");
        } else if (ManagerController.ManagerType.contentEquals("S")) {
            employeeType = Employee_type.StockManager;
        } else if (HomeController.employeeType.contentEquals("C")) {
            employeeType = Employee_type.Cashier;
        }
        else {
            Employee_type employeeType = Employee_type.Invalid;
        }
    }
    public void loginPortal() throws Exception{

        if(HomeController.employeeType.contentEquals("M")){
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginManager.fxml"));
            loader.load();
            ManagerController controller = loader.getController();
            String Username = controller.getManagerUserName();
            proceed = ManagerController.verificationStatus;
            name = Database.get_ManagerName(Username);
            if (employeeType == Employee_type.BranchManager) {
                manager = Database.get_ManagerDetails(Username);
            }
            else if(employeeType == Employee_type.StockManager){
                stockManager = Database.get_StockManagerDetails(Username);
            }

        } else if (HomeController.employeeType.contentEquals("C")) {
            int CashierCode = CashierLogin.CashierCode;
            employeeType = Employee_type.Cashier;
            proceed=CashierLogin.verificationStatus;
            name = Database.get_CashierName(CashierCode);
            cashier = Database.get_CashierDetails(CashierCode);
        }

    }

    public static boolean verify(String username,String password) throws IOException {
       return Verify.Validate_Password(username,password,employeeType);
    }
    public static boolean verify(int cashierCode,String password) throws IOException {
        return Verify.Validate_Password(cashierCode,password,employeeType);
    }
}
class Verify{
    public Verify(){}
    public static boolean Validate_Password(int CashierCode,String passcode,Employee_type employeeType ) throws IOException {
        if (employeeType==Employee_type.Cashier) {

            boolean checkPasscode = Database.Validate_Cashier(CashierCode,passcode);
            System.out.println("heree");
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("CashierLogin.fxml"));
            loader.load();
            CashierLogin controller = loader.getController();
            if (controller.tries<0){
                System.exit(1);
            }
            return checkPasscode;
        }
        else {
            return false;
        }
    }
    public static boolean Validate_Password(String Username,String passcode,Employee_type employeeType ) throws IOException {
        if (employeeType == Employee_type.BranchManager||employeeType==Employee_type.StockManager) {

            boolean checkPasscode = Database.Validate_Manager(Username,passcode);
            System.out.println("heree");
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoginManager.fxml"));
            loader.load();
            ManagerController controller = loader.getController();
            if (controller.tries<0){
                System.exit(1);
            }
            return checkPasscode;
        }
        else {
            return false;
        }
    }
}