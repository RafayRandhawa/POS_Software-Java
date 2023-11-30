import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private String ManagerName;
    public Manager(){}
    public Manager(String name){
        this.ManagerName = name;
    }

    static public ArrayList<Cashier> searchCashierList(String CashierName) {
        return Database.get_CashierDetails(CashierName);
    }
    static public ArrayList<Cashier> searchCashierList(int CashierName) {
        ArrayList<Cashier> cashiers = new ArrayList<>();
        cashiers.add(Database.get_CashierDetails(CashierName));
        return cashiers;
    }
}
class StockManager extends Manager{
    public StockManager(){}
    public StockManager(String ManagerName) {
        super(ManagerName);
    }


}