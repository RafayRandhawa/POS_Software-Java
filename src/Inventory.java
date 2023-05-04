import java.sql.SQLException;
import java.util.Scanner;

class Item{
    private int itemID;
    private String itemName;
    private String expiry_date;
    private String supp_name;
    private double price;
    private int quantity;
    private double total;
    public Item(){}
    public Item(int itemID,String itemName,double price,int quantity,String expiry_date,String supp_name){
        this.itemID=itemID;
        this.itemName=itemName;
        this.expiry_date=expiry_date;
        this.price=price;
        this.quantity=quantity;
        this.supp_name=supp_name;
        total = price * quantity;
    }
    public Item(int itemID,String itemName,double price,int quantity,String expiry_date){
        this.itemID=itemID;
        this.itemName=itemName;
        this.expiry_date=expiry_date;
        this.price=price;
        this.quantity=quantity;
        total = price * quantity;
    }

    public double getTotal() {return total;}
    public double getPrice() {
        return price;
    }

    public int getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public String getSupp_name() {
        return supp_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public void setSupp_name(String supp_name) {
        this.supp_name = supp_name;
    }
}

public class Inventory extends Item{

    private int currStockLev;
    private int maxStockLev;
    private int minStockLev;

    public Inventory(){}

    public static void addItem(){
        System.out.println("Enter Item Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Enter Item Price: ");
        double price = new Scanner(System.in).nextDouble();

        System.out.println("Enter Item Quantity: ");
        int quantity = new Scanner(System.in).nextInt();

        System.out.println("Enter Expiry Date: ");
        String expiry_date = new Scanner(System.in).nextLine();

        System.out.println("Enter Supplier Name: ");
        String suppName = new Scanner(System.in).nextLine();

        System.out.println("Enter Current stock level of item: ");
        int currStockLev = new Scanner(System.in).nextInt();

        System.out.println("Enter Minimum stock level of item: ");
        int minStockLev = new Scanner(System.in).nextInt();

        System.out.println("Enter Maximum stock level of item: ");
        int maxStockLev = new Scanner(System.in).nextInt();

        try {
            Database.addNewItemInv(name,price,quantity,expiry_date,currStockLev,maxStockLev,minStockLev,suppName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//adds a new item in the inventory

    public static void updateStockLevels(){
        for(Item item:Cart.getInventoryList()){
            Database.updateStock(item.getItemID(),item.getQuantity());
        }
    }//update stock levels when a sale is made

    public static void checkStockLevels(){
        System.out.println("Enter the ID of item you want to check stock of: ");
        int id = new Scanner(System.in).nextInt();

        int[] stockLevs = Database.checkStock(id);

        if(stockLevs[0]>stockLevs[2]&&stockLevs[0]<stockLevs[1]){
            System.out.println("\nStock levels are optimal");
            System.out.println("\nCurrent stock level: " + stockLevs[0]);
            System.out.println("\nMinimum stock level: " + stockLevs[2]);
            System.out.println("\nMaximum stock level: " + stockLevs[1]);
        }
        else if(stockLevs[0]<stockLevs[2] && stockLevs[0]<=10){
            System.out.println("\nWARNING!!Stock levels are too low.\nOrder new stock.");
            System.out.println("\nCurrent stock level: " + stockLevs[0]);
            System.out.println("\nMinimum stock level: " + stockLevs[2]);
            System.out.println("\nMaximum stock level: " + stockLevs[1]);
        }
        else if(stockLevs[0]<stockLevs[2]){
            System.out.println("\nStock levels are below minimum");
            System.out.println("\nCurrent stock level: " + stockLevs[0]);
            System.out.println("\nMinimum stock level: " + stockLevs[2]);
            System.out.println("\nMaximum stock level: " + stockLevs[1]);
        }
        else if(stockLevs[0]>stockLevs[1]){
            System.out.println("\nStock levels exceeding limit");
            System.out.println("\nCurrent stock level: " + stockLevs[0]);
            System.out.println("\nMinimum stock level: " + stockLevs[2]);
            System.out.println("\nMaximum stock level: " + stockLevs[1]);
        }
    }//checks stock levels and displays message accordingly

    public static void viewItem(){
        System.out.println("Enter Item Name or Item ID: ");
        String name = new Scanner(System.in).nextLine();
        int[] stockLevs;

        Item item = Database.get_itemDetails(name);
        try{
            int ID = Integer.parseInt(name);
            stockLevs = Database.printStock(ID);

        }catch(Exception e){
            stockLevs = Database.printStock(name);
        }

        System.out.println("\nThe item details are as follows: ");
        System.out.println("\nItem ID: " + item.getItemID());
        System.out.println("Item name: " + item.getItemName());
        System.out.println("Quantity: " + item.getQuantity());
        System.out.println("Price: " + item.getPrice());
        System.out.println("Expiry Date: " + item.getExpiry_date());
        System.out.println("Supplier Name: " + item.getSupp_name());
        System.out.println("\nStock Levels:");
        System.out.println("\nCurrent stock level: " + stockLevs[0]);
        System.out.println("Minimum stock level: " + stockLevs[2]);
        System.out.println("Maximum stock level: " + stockLevs[1]);
    }//displays all details about the item

    public static void viewAllItemDetails(){
    Database.viewAllItems();
    }//displays all details about all items

    public static void searchBySupplier(){
        System.out.println("Enter Supplier Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println();
        Database.searchBySupplier(name);
    }//displays all records that belong to same supplier

    public static void removeItem(){
        System.out.println("Enter Item ID: ");
        int ID = new Scanner(System.in).nextInt();

        System.out.println();
        Database.removeItemInv(ID);
    }//removes an item from all inventory tables

    public static void dispSupplierInfo(){
        Database.supplierInfo();
    }//displays info of all suppliers

    public static void searchSupplier(){
        System.out.println("Enter supplier name: ");
        String name = new Scanner(System.in).nextLine();

        Database.supplierInfoSearch(name);
    }//Enter supplier name to view details+

    public static void expDateControl(){

    }
}