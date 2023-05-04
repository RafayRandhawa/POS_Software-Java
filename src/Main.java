public class Main {
    public static void main(String[] args) {

        Login.loginPortal();
        if(!Login.proceed) System.exit(0);
        if (Login.employeeType == Employee_type.Cashier) {
            cashier_menu.menu();
        }
        else if (Login.employeeType == Employee_type.BranchManager){
            manager_menu.menu();
        }
        else if (Login.employeeType == Employee_type.StockManager) {
            stockmanager_menu.menu();
        }
    }
}