import java.util.Scanner;

enum Employee_type{
    BranchManager,
    StockManager,
    Cashier,
    Invalid
};
public class Login {
    public static String name="";
    public static Employee_type employeeType;
    public static Cashier cashier;
    public static Manager manager;
    public static StockManager stockManager;
    public static boolean proceed=false;
    public static void loginPortal() {


        System.out.println("*****WELCOME TO THE POS SOFTWARE*****");
        System.out.println("\n\nPlease verify your employee type: ");
        System.out.println("Are you a Manager or a Cashier (M/C)");
        String selection = new Scanner(System.in).nextLine();

        if(selection.contentEquals("M")||selection.contentEquals("m")){

            while(true){System.out.println("Are you the Branch Manager or the Stock Manager (B/S)");
            selection = new Scanner(System.in).nextLine();
            if(selection.contentEquals("B")||selection.contentEquals("b")){
            employeeType = Employee_type.BranchManager;
            break;
            } else if (selection.contentEquals("S")||selection.contentEquals("s")) {
                employeeType = Employee_type.StockManager;
                break;
            }
            else {
                System.out.println("Please enter a valid input (B/S)");
            }
            }
            System.out.println("Please enter your Manager Username: ");
            String Username = new Scanner(System.in).nextLine();
            System.out.println("Please enter the Password: ");
            String passcode =  new Scanner(System.in).nextLine();
            proceed=Verify.Validate_Password(Username,passcode,employeeType);
            name = Database.get_ManagerName(Username);
            if (employeeType == Employee_type.BranchManager) {
                manager = Database.get_ManagerDetails(Username);
            }
            else if(employeeType == Employee_type.StockManager){
                stockManager = Database.get_StockManagerDetails(Username);
            }

        } else if (selection.contentEquals("C")||selection.contentEquals("c")) {
            employeeType = Employee_type.Cashier;
            System.out.println("Please enter your cashier code: ");
            int CashierCode = new Scanner(System.in).nextInt();
            System.out.println("Please enter the passcode corresponding to your cashier code: ");
            String passcode = new Scanner(System.in).nextLine();
            proceed=Verify.Validate_Password(CashierCode,passcode,employeeType);
            name = Database.get_CashierName(CashierCode);
            cashier = Database.get_CashierDetails(CashierCode);
        }
        else {
            Employee_type employeeType = Employee_type.Invalid;
        }
        ;

    }
}
class Verify{
    public Verify(){}
    public static boolean Validate_Password(int CashierCode,String passcode,Employee_type employeeType ){
        if (employeeType==Employee_type.Cashier) {
            boolean checkPasscode = Database.Validate_Cashier(CashierCode,passcode);
            int i = 1;
            while(!checkPasscode && i<3){
                System.out.println("Incorrect password entered.\nEnter password again.");
                passcode = new Scanner(System.in).nextLine();
                checkPasscode = Database.Validate_Cashier(CashierCode,passcode);
                if (!checkPasscode){
                    i++;
                }
            }
            if(i==3){
                System.out.println("\nIncorrect password entered thrice.\nSystem is locked.\nContact admin.");
                System.exit(1);
            }
            return checkPasscode;
        }
        else {return false;}
    }
    public static boolean Validate_Password(String Username,String passcode,Employee_type employeeType ) {
        if (employeeType == Employee_type.BranchManager||employeeType==Employee_type.StockManager) {

            boolean checkPasscode = Database.Validate_Manager(Username,passcode);
            int i = 1;
            while(!checkPasscode && i<3){
                System.out.println("Incorrect password entered.\nEnter password again.");
                passcode = new Scanner(System.in).nextLine();
                checkPasscode = Database.Validate_Manager(Username,passcode);
                if (!checkPasscode){
                    i++;
                }
            }
            if(i==3){
                System.out.println("\nIncorrect password entered thrice.\nSystem is locked.\nContact admin.");
                System.exit(1);
            }
            return checkPasscode;
        }
        else {
            return false;
        }
    }
}