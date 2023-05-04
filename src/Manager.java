import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private String ManagerName;
    public Manager(){}
    public Manager(String name){
        this.ManagerName = name;
    }

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }
    public void searchCashier(int CashierCode){
        Cashier cashier = Database.get_CashierDetails(CashierCode);
        if(cashier.getCashierCode()==0||cashier.getCashierName()==null){
            System.out.println("Record does not exist in Database.....");
        }
        System.out.println("Cashier Code\tCashier Name\tJoining Date\t\t\t\tShift Start Time\t\t\t\tShift End Time\t\t\t\t\tTotal Number Of Hours Worked");
        System.out.printf("\n%s\t %-15s %-20s %-20s \t%-25s %-15s", cashier.getCashierCode(), cashier.getCashierName(), cashier.getJoinDate(), cashier.getShiftStart(), cashier.getEndShift(), cashier.getTotalHoursWorked());
    }
    public void searchCashier(String CashierName) {
        ArrayList<Cashier> cashiers = Database.get_CashierDetails(CashierName);
        if(cashiers.isEmpty()){
            System.out.println("Record does not exist in Database.....");
        }
        else{System.out.println("Cashier Code\tCashier Name\tJoining Date\t\t\t\tShift Start Time\t\t\t\tShift End Time\t\t\t\t\tTotal Number Of Hours Worked");
            for (Cashier cashier : cashiers) {
                System.out.printf("\n%s\t %-15s %-20s %-20s \t%-25s %-15s", cashier.getCashierCode(), cashier.getCashierName(), cashier.getJoinDate(), cashier.getShiftStart(), cashier.getEndShift(), cashier.getTotalHoursWorked());
            }
        }
    }
    public void displayCashiers(){
        ArrayList<Cashier> cashiers = Database.get_CashierDetails();
        System.out.println("Cashier Code\tCashier Name\tJoining Date\t\t\t\tShift Start Time\t\t\t\tShift End Time\t\t\t\t\tTotal Number Of Hours Worked");
        for (Cashier cashier : cashiers) {
            String parse = String.valueOf(cashier.getTotalHoursWorked());
            System.out.printf("\n%s\t %-15s %-20s %-20s \t%-25s %-15s", cashier.getCashierCode(), cashier.getCashierName(), cashier.getJoinDate(), cashier.getJoinDate(), cashier.getShiftStart(), cashier.getEndShift(), cashier.getTotalHoursWorked());

        }
    }
    public void addCashier(){
        System.out.println("Enter Cashier Name: ");
        String CashierName = new Scanner(System.in).nextLine();
        System.out.println("What Shift will the cashier work (Morning or Evening)");
        String shift = new Scanner(System.in).nextLine();
        String start="";
        String end="";
        if(shift.contentEquals("Morning")||shift.contentEquals("morning")){
            start="08:00:00";
            end = "16:00:00";
        }
        else if(shift.contentEquals("Evening")||shift.contentEquals("evening")){
            start="16:00:00";
            end="00:00:00";
        }
        String date = DateAndTime.get_Date();
        Database.addNewCashier(CashierName,date,start,end,0);
    }
    public void updateCashierDetails(){Database.updateCashierInfo();}
    public void removeCashier(int CashierCode){Database.removeCashier(CashierCode);}
    public void viewAllSales(){
        Database.get_SalesRecord();
    }
    public void viewAllSales(int SalesID,int ParameterRestriction){
        Database.get_SalesRecord(SalesID,1);
    }
    public void viewAllSales(int CashierCode){
        Database.get_SalesRecord(CashierCode);
    }



}
class StockManager extends Manager{
    public StockManager(){}
    public StockManager(String ManagerName) {
        super(ManagerName);
    }
    public void addNewItemToInv(){
        Inventory.addItem();
    }
    public void removeItemFromInv(){
        Inventory.removeItem();
    }
    public void viewAllItems(){
        Database.viewInventory();
    }
    public void findItem(int itemID){
        Database.findItem(itemID);
    }
    public void findItem(String itemName){Database.findItem(itemName);}
    public void viewItem(){Inventory.viewItem();}
    public void viewAllItemDetails(){Inventory.viewAllItemDetails();}
    public void checkStockLevels(){Inventory.checkStockLevels();}
    public void viewAllSuppliers(){Inventory.dispSupplierInfo();}
    public void searchForSupplier(){Inventory.searchSupplier();}
    public void ItemsBySupplier(){Inventory.searchBySupplier();}

}