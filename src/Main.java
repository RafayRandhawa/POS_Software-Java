public class Main {
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
        Manager m = new Manager();
        m.displayCashiers();
    }
}