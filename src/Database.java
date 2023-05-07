import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/employees";
    private static final String username = "root";
    private static final String password = "Randhawa@147";
    public static int getSalesID() {
        int SalesID =0;
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashiersales ORDER BY SalesID DESC LIMIT 1");

            while (rs.next()){
                SalesID = rs.getInt("SalesID");
            }
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: "+e.getMessage());
        }

        return SalesID;
    }
    public static String get_ManagerName(String Username){

        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM managerlogininfo");


            while (rs.next()) {
                String MUsername = rs.getString("MUsername");
                String name = rs.getString("ManagerName");
                if(MUsername.contentEquals(Username)){
                    return name;
                }
            }


            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return "Name not found.";
    }
    public static String get_CashierName(int CashierCode){

        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierlogininfo");


            while (rs.next()) {
                int id = rs.getInt("CashierCode");
                String name = rs.getString("CashierName");
                if(id==CashierCode){
                    return name;
                }
            }


            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return "Name not found.";
    }
    public static boolean Validate_Cashier(int code, String passcode) {

        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierlogininfo");


            while (rs.next()) {
                int id = rs.getInt("CashierCode");
                String pass = rs.getString("CashierPassword");
                if(id==code&&passcode.contentEquals(pass)){
                    System.out.println("\nThe password has been validated");
                    return true;
                }
            }


            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        System.out.println("The Username and Password don't match");
        return false;
    }
    public static boolean Validate_Manager(String Username,String passcode) {

        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM managerlogininfo");


            while (rs.next()) {
                String id = rs.getString("MPassword");
                String name = rs.getString("MUsername");
                if(id.contentEquals(passcode)&&Username.contentEquals(name)){
                    System.out.println("The Password has been validated");
                    return true;
                }
            }


            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        System.out.println("The Username and Password don't match");
        return false;
    }
    public static ArrayList<Cashier> get_CashierDetails(){

        ArrayList<Cashier> cashierArrayList = null;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            cashierArrayList = new ArrayList<>(1);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierdetails");
            while (rs.next()) {
                int id = rs.getInt("CashierCode");
                String name = rs.getString("CashierName");
                int TotalHoursWorked = rs.getInt("TotNoOfHoursWorked");
                String JoinDate = rs.getString("JoiningDate");
                String ShiftStart = rs.getString("ShiftStartTime");
                String EndShift = rs.getString("ShiftEndTime");
                String EmploymentStatus = rs.getString("EmploymentStatus");
                cashierArrayList.add(new Cashier(id, name, TotalHoursWorked, JoinDate, ShiftStart, EndShift,EmploymentStatus));

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return cashierArrayList;
    }
    public static Cashier get_CashierDetails(int code){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierdetails");
            while (rs.next()){
            int id = rs.getInt("CashierCode");
            String name = rs.getString("CashierName");
            int TotalHoursWorked = rs.getInt("TotNoOfHoursWorked");
            String JoinDate = rs.getString("JoiningDate");
            String ShiftStart = rs.getString("ShiftStartTime");
            String EndShift = rs.getString("ShiftEndTime");
            String EmploymentStatus = rs.getString("EmploymentStatus");
            if (id == code){
                return new Cashier(id,name,TotalHoursWorked,JoinDate,ShiftStart,EndShift,EmploymentStatus);
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return new Cashier();
    }
    public static ArrayList<Cashier> get_CashierDetails(String Cname) {
        ArrayList<Cashier> cashierArrayList = null;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            cashierArrayList = new ArrayList<>(1);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierdetails");
            while (rs.next()) {
                int id = rs.getInt("CashierCode");
                String name = rs.getString("CashierName");
                int TotalHoursWorked = rs.getInt("TotNoOfHoursWorked");
                String JoinDate = rs.getString("JoiningDate");
                String ShiftStart = rs.getString("ShiftStartTime");
                String EndShift = rs.getString("ShiftEndTime");
                String EmploymentStatus = rs.getString("EmploymentStatus");
                if (name.contentEquals(Cname)) {
                    cashierArrayList.add(new Cashier(id, name, TotalHoursWorked, JoinDate, ShiftStart, EndShift,EmploymentStatus));
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return cashierArrayList;
    }
    public static void addNewCashier(String CashierName,String Join,String Start,String End, int hrsWorked){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO cashierdetails (CashierName,JoiningDate,ShiftStartTime,ShiftEndTime,TotNoOfHoursWorked) VALUES (?,?,?,?,?)");
            stmt.setString(1,CashierName);
            stmt.setString(2,Join);
            stmt.setString(3,Start);
            stmt.setString(4,End);
            stmt.setInt(5,hrsWorked);

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Enter Password for new cashier: ");
            String password = new Scanner(System.in).nextLine();

            int CashierCode=0;
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery("SELECT * FROM cashierdetails ORDER BY CashierCode DESC LIMIT 1");
            while(rs.next()){
                CashierCode = rs.getInt("CashierCode");
            }

            stmt = conn.prepareStatement("INSERT INTO cashierlogininfo (CashierCode,CashierName,CashierPassword) VALUES (?,?,?)");
            stmt.setInt(1,CashierCode);
            stmt.setString(2,CashierName);
            stmt.setString(3,password);

            rowsInserted += stmt.executeUpdate();
            stmt.close();
            stmt2.close();
            conn.close();
            if(rowsInserted==0){
                System.out.println("Error writing in database");
            }
        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }

    }
    public static void removeCashier(int CashierCode){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM cashierlogininfo WHERE CashierCode = ?");
            stmt.setInt(1,CashierCode);
            PreparedStatement stmt2 = conn.prepareStatement("UPDATE cashierdetails SET EmploymentStatus=? WHERE CashierCode = ?");
            stmt2.setString(1,"Former");
            stmt2.setInt(2,CashierCode);
            int rowsInserted = stmt.executeUpdate()+ stmt2.executeUpdate();
            stmt.close();
            stmt2.close();
            conn.close();
            if(rowsInserted==0){
                System.out.println("Error writing in database");
            }
            else{
                System.out.println("Cashier Employment Status changed to former Employee..");
            }
        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
    public static void updateCashierInfo(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(true);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierlogininfo");

            while(rs.next()){
                System.out.println("\nCashier Code: "+rs.getInt("CashierCode")+"\tCashier Name: "+rs.getString("CashierName"));
            }
            System.out.println("Enter Cashier Code of of the cashier you want to update");
            int Code = new Scanner(System.in).nextInt();
            System.out.println("What would you like to update: \n1: Cashier Name\n2: Shift\n");
            int option = new Scanner(System.in).nextInt();
            PreparedStatement pstmt = null;
            switch(option){
                case 1:
                    pstmt = conn.prepareStatement("UPDATE cashierdetails, cashierlogininfo \nSET cashierdetails.CashierName = ?, cashierlogininfo.CashierName = ? \nWHERE cashierdetails.CashierCode = ?");
                    System.out.println("Enter new Cashier Name: ");
                    String name = new Scanner(System.in).nextLine();
                    pstmt.setString(1,name);
                    pstmt.setString(2,name);
                    pstmt.setInt(3,Code);
                    pstmt.executeUpdate();
                    break;
                case 2:

                    System.out.println("Enter Shift Time (Morning/Evening): ");
                    String shift = new Scanner(System.in).nextLine();
                    if(shift.contentEquals("Morning")||shift.contentEquals("morning")){
                        pstmt = conn.prepareStatement("UPDATE cashierdetails\n SET ShiftStartTime = 08:00:00,ShiftEndTime = 16:00:00 \nWHERE CashierCode = ?");
                        pstmt.setInt(1,Code);
                        pstmt.executeUpdate();
                    }
                    else if (shift.contentEquals("Evening")||shift.contentEquals("evening")) {
                        pstmt = conn.prepareStatement("UPDATE cashierdetails \nSET ShiftStartTime = 16:00:00,ShiftEndTime = 00:00:00 \nWHERE CashierCode = ?");
                        pstmt.setInt(1,Code);
                        pstmt.executeUpdate();
                    }
                    break;

            }
            pstmt.close();
            conn.close();

        }
        catch (SQLException e){
            System.out.println("Error Connecting to Database: "+e.getMessage());
        }
    }
    public static Manager get_ManagerDetails(String Username){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM managerlogininfo");
            while (rs.next()) {
                String MPassword = rs.getString("MPassword");
                String MUsername = rs.getString("MUsername");
                String ManagerName = rs.getString("ManagerName");
                if(MUsername.contentEquals(Username)) {
                    return new Manager(ManagerName);
                }
            }

            rs.close();
            stmt.close();
            conn.close();


        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return new Manager();
    }
    public static StockManager get_StockManagerDetails(String Username){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM managerlogininfo");
            while (rs.next()) {
                String MPassword = rs.getString("MPassword");
                String MUsername = rs.getString("MUsername");
                String ManagerName = rs.getString("ManagerName");
                if(MUsername.contentEquals(Username)) {
                    return new StockManager(ManagerName);
                }
            }

            rs.close();
            stmt.close();
            conn.close();


        }
        catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return new StockManager();
    }
    public static void get_SalesRecord(){
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM cashiersales ORDER BY SaleDate ASC");

            while(rs.next()){
                int SalesID = rs.getInt("SalesID");
                int CashierCode= rs.getInt("CashierCode");
                String SaleDate= rs.getString("SaleDate");
                String SaleTime= rs.getString("SaleTIme");
                double Amount= rs.getDouble("Amount");
                int NoOfItems= rs.getInt("NoOfItems");
                String PaymentMethod= rs.getString("PaymentMethod");
                System.out.printf("\nSalesID: %d\nCashier Code: %d\nSale Date: %s\nSale Time: %s\nAmount: %.2f\nNumber Of Items: %d\nPayment Method: %s\n",SalesID,CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod);
            }
            rs.close();
            stmt.close();
            conn.close();


        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
    public static boolean get_SalesRecord(int cashier_code){
        boolean found=false;
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM cashiersales");

            while(rs.next()){
                int SalesID = rs.getInt("SalesID");
                int CashierCode= rs.getInt("CashierCode");
                String SaleDate= rs.getString("SaleDate");
                String SaleTime= rs.getString("SaleTIme");
                double Amount= rs.getDouble("Amount");
                int NoOfItems= rs.getInt("NoOfItems");
                String PaymentMethod= rs.getString("PaymentMethod");
                if(CashierCode==cashier_code){
                    found=true;
                System.out.printf("\nSalesID: %d\nCashier Code: %d\nSale Date: %s\nSale Time: %s\nAmount: %.2f\nNumber Of Items: %d\nPayment Method: %s\n",SalesID,CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod);
            }
            }
            rs.close();
            stmt.close();
            conn.close();


        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return found;
    }
    public static void get_SalesRecord(int salesID,int Parameter_Restriction){
        //Second int parameter has no functional value
        //Parameter_Restriction was included to allow for function overloading
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM cashiersales");

            while(rs.next()){
                int SalesID = rs.getInt("SalesID");
                int CashierCode= rs.getInt("CashierCode");
                String SaleDate= rs.getString("SaleDate");
                String SaleTime= rs.getString("SaleTIme");
                double Amount= rs.getDouble("Amount");
                int NoOfItems= rs.getInt("NoOfItems");
                String PaymentMethod= rs.getString("PaymentMethod");
                if(salesID==SalesID){
                    System.out.printf("\nSalesID: %d\nCashier Code: %d\nSale Date: %s\nSale Time: %s\nAmount: %.2f\nNumber Of Items: %d\nPayment Method: %s\n",SalesID,CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod);
                }
            }
            rs.close();
            stmt.close();
            conn.close();


        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
    public static void add_SalesRecord(int CashierCode, String SaleDate, String SaleTime, double Amount, int NoOfItems, String PaymentMethod){
        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(true);
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO cashiersales (CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1,CashierCode);
            stmt.setString(2,SaleDate);
            stmt.setString(3,SaleTime);
            stmt.setDouble(4,Amount);
            stmt.setInt(5,NoOfItems);
            stmt.setString(6,PaymentMethod);
            int rowsInserted = stmt.executeUpdate();
            stmt.close();

            conn.close();
            if(rowsInserted==0){
                System.out.println("Error writing in database");
            }

        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
    public static Item get_itemDetails(String itemName,int quantity){
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0,ITEMID=0;
        String EXPIRYDATE="";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");

            while (rs.next()){
                //System.out.println("ItemName: "+rs.getString("ItemName"));
                if(rs.getString("ItemName").contentEquals(itemName)) {
                     ITEMID=rs.getInt("itemID");
                     ITEMNAME =rs.getString("ItemName");
                     PRICE=rs.getDouble("Price");
                     QUANTITY=quantity;
                     EXPIRYDATE=rs.getString("ExpiryDate");
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        //System.out.println("Check");
        return new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE);
    }
    public static Item get_itemDetails(String itemName){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");

            while (rs.next()){
                //System.out.println("ItemName: "+rs.getString("ItemName"));
                if(rs.getString("ItemName").contentEquals(itemName)) {
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        //System.out.println("Check");
        return new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE,SUPP);
    }//used in updateStockLevels() in class inventory
    public static void viewAllItems(){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            System.out.println("Item ID\t\tItem Name\t\t\tPrice\t\t\t\tQuantity\t\t\tExpiry Date\t\t\t\t\tSupplier Name\t\t\tCurrent Stock Levels\t\t\tMax Stock Level\t\t\tMinimum Stock Level");
            while (rs.next()){


                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");
                    int[] stock_levels = Database.printStock(ITEMID);
                System.out.printf("\n%-10s\t %-20s %-20s %-15s \t%-27s %-30s %-31s %-29s %-20s",ITEMID,ITEMNAME,String.valueOf(PRICE),String.valueOf(QUANTITY),EXPIRYDATE,SUPP,stock_levels[0],stock_levels[1],stock_levels[2]);
                System.out.println();
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        //System.out.println("Check");

    }
    public static void viewInventory(){

        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            System.out.println("Item ID\t\tItem Name\t\t\tPrice\t\t\t\tQuantity\t\t\tExpiry Date\t\t\t\t\tSupplier Name");
            while (rs.next()){
                //System.out.println("ItemName: "+rs.getString("ItemName"));
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");

                System.out.printf("\n%-10s\t %-20s %-20s %-15s \t%-27s %s",ITEMID,ITEMNAME,String.valueOf(PRICE),String.valueOf(QUANTITY),EXPIRYDATE,SUPP);
                System.out.println();
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        //System.out.println("Check");;
    }
    public static void findItem(int ItemID){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            System.out.println("Item ID\t\tItem Name\t\t\tPrice\t\t\t\tQuantity\t\t\tExpiry Date\t\t\t\t\tSupplier Name");
            while (rs.next()){
                if(ItemID==rs.getInt("itemID")){
                    //System.out.println("ItemName: "+rs.getString("ItemName"));
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");

                    System.out.printf("\n%-10s\t %-20s %-20s %-15s \t%-27s %s",ITEMID,ITEMNAME,String.valueOf(PRICE),String.valueOf(QUANTITY),EXPIRYDATE,SUPP);
                    System.out.println();
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        //System.out.println("Check");;
    }
    public static void findItem(String itemName){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            System.out.println("Item ID\t\tItem Name\t\t\tPrice\t\t\t\tQuantity\t\t\tExpiry Date\t\t\t\t\tSupplier Name");
            while (rs.next()){
                if(itemName.contentEquals(rs.getString("ItemName"))){

                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");

                    System.out.printf("\n%-10s\t %-20s %-20s %-15s \t%-27s %s",ITEMID,ITEMNAME,String.valueOf(PRICE),String.valueOf(QUANTITY),EXPIRYDATE,SUPP);
                    System.out.println();
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }

    }
    public static void updateStock(int itemID, int quantity){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            Statement stmt1 = null;

            String query = "SELECT * FROM inventorylevels";
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(query);
            PreparedStatement stmt2=null;
            while(rs.next()) {
                if(itemID==rs.getInt("itemID")){
                    int currentStockLevel = rs.getInt("CurrentstockLevel");
                    stmt2 = conn.prepareStatement("UPDATE inventorylevels SET CurrentstockLevel = ? WHERE itemID = ?");
                    stmt2.setInt(1, (currentStockLevel - quantity));
                    stmt2.setInt(2, itemID);
                    break;
                }
            }

            int rowsInserted = stmt2.executeUpdate();

            stmt1.close();
            stmt2.close();
            conn.close();

            if (rowsInserted == 0) {
                System.out.println("Error! Stock levels could not be updated");
            }
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }//used in updateStockLevels() in class inventory
    public static void addNewItemInv(String ItemName, double price,int quantity,String expiry_date, int currStockLev, int maxStockLev, int minStockLev, String suppName) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", username, password);
        try {
            conn.setAutoCommit(true);

            PreparedStatement stmt2;
            stmt2 = conn.prepareStatement("INSERT INTO inventorylevels (ItemName,MaxStockLevel,MinStockLevel,CurrentstockLevel) VALUES (?, ?, ?, ?)");
            stmt2.setString(1, ItemName);
            stmt2.setInt(2, maxStockLev);
            stmt2.setInt(3, minStockLev);
            stmt2.setInt(4, currStockLev);

            PreparedStatement stmt3;
            stmt3 = conn.prepareStatement("INSERT INTO inventoryprods (ItemName,Price,Quantity,ExpiryDate,SupplierName) VALUES (?, ?, ?, ?, ?)");
            stmt3.setString(1, ItemName);
            stmt3.setDouble(2, price);
            stmt3.setInt(3, quantity);
            stmt3.setString(4, expiry_date);
            stmt3.setString(5, suppName);


            int rowsInserted2 = stmt2.executeUpdate();
            int rowsInserted3 = stmt3.executeUpdate();

            stmt2.close();
            stmt3.close();
            conn.close();

            if (rowsInserted2 > 0 && rowsInserted3 > 0) {
                System.out.println("A new sales record was inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            conn.rollback();
        }
    }//used in addItem() in class inventory
    public static int[] checkStock(int ID){
        String iname = null;
        int current=0;
        int max=0;
        int min=0;
        int[] stocks = new int[3];

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventoryprods INNER JOIN inventorylevels ON inventoryprods.itemID = inventorylevels.itemID WHERE inventoryprods.itemID = ?");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getInt("itemID")==ID) {
                    iname = rs.getString("ItemName");
                    current = rs.getInt("CurrentstockLevel");
                    max = rs.getInt("MaxStockLevel");
                    min = rs.getInt("MinStockLevel");
                }
            }
            System.out.println("\nItem name: " + iname);

            stocks[0] = current;
            stocks[1] = max;
            stocks[2] = min;

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stocks;
    }//used in CheckStockLevels() in class inventory
    public static int[] printStock(String itemName){
        int current=0;
        int max=0;
        int min=0;
        int[] stocks = new int[3];

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventoryprods INNER JOIN inventorylevels ON inventoryprods.itemID = inventorylevels.itemID WHERE inventoryprods.ItemName = ?");
            pstmt.setString(1, itemName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getString("ItemName").contentEquals(itemName)) {
                    current = rs.getInt("CurrentstockLevel");
                    max = rs.getInt("MaxStockLevel");
                    min = rs.getInt("MinStockLevel");
                }
            }

            stocks[0] = current;
            stocks[1] = max;
            stocks[2] = min;

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stocks;
    }//used in viewItems() in class inventory
    public static int[] printStock(int ID){
        int current=0;
        int max=0;
        int min=0;
        int[] stocks = new int[3];

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventoryprods INNER JOIN inventorylevels ON inventoryprods.itemID = inventorylevels.itemID WHERE inventoryprods.itemID = ?");
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getInt("ItemID")==ID) {
                    current = rs.getInt("CurrentstockLevel");
                    max = rs.getInt("MaxStockLevel");
                    min = rs.getInt("MinStockLevel");
                }
            }

            stocks[0] = current;
            stocks[1] = max;
            stocks[2] = min;

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stocks;
    }//used in viewItems() in class inventory
    public static void searchBySupplier(String suppName){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventory.inventoryprods WHERE inventoryprods.SupplierName = ?");
            pstmt.setString(1, suppName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getString("SupplierName").contentEquals(suppName)) {
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                }
                System.out.println("--Item ID: " + ITEMID + " --Item Name: " + ITEMNAME + " --Price: " + PRICE + " --Quantity: " + QUANTITY + " --Expiry date: " + EXPIRYDATE);
                System.out.println();
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//used in searchBySupplier() inventory class
    public static void removeItemInv(int ID){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            String query = "DELETE inventory.inventoryprods,  inventory.inventorylevels\n" +
                    "FROM inventory.inventoryprods\n" +
                    "INNER JOIN inventory.inventorylevels ON inventory.inventoryprods.itemID = inventory.inventorylevels.itemID\n" +
                    "WHERE inventory.inventoryprods.itemID = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, ID);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + " record(s) deleted");

            pstmt.close();
            conn.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }//used in removeItem() inventory class
    public static void supplierInfo(){
        int suppID=0;
        String suppName="";
        String cname="";
        String title="";
        String add="";
        String city="";
        String region="";
        String pcode="";
        String country="";
        String ph="";
        String fax="";
        String email="";
        String web="";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ID\tSupplier Name\tContact Name\t\t\t\tTitle\t\t\t\tAddress\t\t\t\t\tCity\t\t\tRegion\t\tPostal Code\t\tCountry\t\t\t\t\tPhone\t\t\t\t\t Fax\t\t\t\t\tEmail\t\t\t\t\tWebsite");
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventory.supplierinfo");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                suppID=rs.getInt("SupplierID");
                    suppName =rs.getString("SupplierName");
                    cname=rs.getString("ContactName");
                    title=rs.getString("ContactTitle");
                    add=rs.getString("Address");
                    city=rs.getString("City");
                    region=rs.getString("Region");
                    pcode=rs.getString("PostalCode");
                    country=rs.getString("Country");
                    ph=rs.getString("Phone");
                    fax=rs.getString("Fax");
                    email=rs.getString("Email");
                    web=rs.getString("Website");

                //System.out.println("--Item ID: " + ITEMID + " --Item Name: " + ITEMNAME + " --Price: " + PRICE + " --Quantity: " + QUANTITY + " --Expiry date: " + EXPIRYDATE);
                System.out.printf("\n%s\t %-15s %-20s %-20s \t%-25s %-15s %-15s %-15s %-15s %-25s %-20s %-25s %-30s",suppID,suppName,cname,title,add,city,region,pcode,country,ph,fax,email,web);
                System.out.println();
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//used in dispSupplierInfo() in class inventory
    public static void supplierInfoSearch(String suppName){
        int suppID=0;
        String supplierName="";
        String cname="";
        String title="";
        String add="";
        String city="";
        String region="";
        String pcode="";
        String country="";
        String ph="";
        String fax="";
        String email="";
        String web="";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ID\tSupplier Name\tContact Name\t\t\t\tTitle\t\t\t\tAddress\t\t\t\t\tCity\t\t\tRegion\t\tPostal Code\t\tCountry\t\t\t\t\tPhone\t\t\t\t\t Fax\t\t\t\t\tEmail\t\t\t\t\tWebsite");
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventory.supplierinfo WHERE supplierinfo.SupplierName=?");
            pstmt.setString(1, suppName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getString("SupplierName").contentEquals(suppName)) {
                    suppID = rs.getInt("SupplierID");
                    supplierName = rs.getString("SupplierName");
                    cname = rs.getString("ContactName");
                    title = rs.getString("ContactTitle");
                    add = rs.getString("Address");
                    city = rs.getString("City");
                    region = rs.getString("Region");
                    pcode = rs.getString("PostalCode");
                    country = rs.getString("Country");
                    ph = rs.getString("Phone");
                    fax = rs.getString("Fax");
                    email = rs.getString("Email");
                    web = rs.getString("Website");
                }
                //System.out.println("--Item ID: " + ITEMID + " --Item Name: " + ITEMNAME + " --Price: " + PRICE + " --Quantity: " + QUANTITY + " --Expiry date: " + EXPIRYDATE);
                System.out.printf("\n%s\t %-15s %-20s %-20s \t%-25s %-15s %-15s %-15s %-15s %-25s %-20s %-25s %-30s",suppID,supplierName,cname,title,add,city,region,pcode,country,ph,fax,email,web);
                System.out.println();
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//used in searchSupplier() inventory class
    public static void getDeliveryCustomerDetail(){
        int CUSTOMERID = 0;
        String CUSTOMERNAME = "";
        String ADDRESS = "";
        String PHNUMBER = "";
        String EMAILADDRESS = "";
        String PAYMENTMETHOD = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);
            conn.setAutoCommit(true);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            System.out.println("CustomerID\t Customer Name\t\t\t\t  Address\t\t\t\t\t  Phone Number\t\t\tEmail Address\t\t\t\t   Payment Method");
            while (rs.next()) {
                CUSTOMERID = rs.getInt("customerID");
                CUSTOMERNAME = rs.getString("customerName");
                ADDRESS = rs.getString("address");
                PHNUMBER = rs.getString("phoneNumber");
                EMAILADDRESS = rs.getString("emailAddress");
                PAYMENTMETHOD = rs.getString("paymentMethod");
                System.out.printf("\n%d \t\t %-20s\t%-35s %-15s %-30s\t\t %s",CUSTOMERID, CUSTOMERNAME, ADDRESS, PHNUMBER, EMAILADDRESS, PAYMENTMETHOD);
            }

        } catch (SQLException e) {
            System.out.println("error connecting to database" + e.getMessage());
        }
    }
    public static void getDeliveryCustomerDetail(int customerID){
        int CUSTOMERID = 0;
        String CUSTOMERNAME = "";
        String ADDRESS = "";
        String PHNUMBER = "";
        String EMAILADDRESS = "";
        String PAYMENTMETHOD = "";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);
            conn.setAutoCommit(true);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                if (rs.getInt("customerID") == (customerID)) {
                    CUSTOMERID = rs.getInt("customerID");
                    CUSTOMERNAME = rs.getString("customerName");
                    ADDRESS = rs.getString("address");
                    PHNUMBER = rs.getString("phoneNumber");
                    EMAILADDRESS = rs.getString("emailAddress");
                    PAYMENTMETHOD = rs.getString("paymentMethod");
                    break;
                }
            }
            System.out.println("\nCustomer ID: " + CUSTOMERID + "\nCustomer Name: " + CUSTOMERNAME + " \nAddress: " + ADDRESS + " \nPhone Number: " + PHNUMBER + "\nEmail Address: " + EMAILADDRESS + "\nPayment Method: " + PAYMENTMETHOD);

        } catch (SQLException e) {
            System.out.println("error connecting to database" + e.getMessage());
        }
    }
    public static void expDateCheck() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", username, password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Statement stmt1 = null;

            String query = "SELECT * FROM inventoryprods WHERE ExpirationStatus IS NULL";
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(query);
            PreparedStatement stmt2 = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                System.out.println("Item Name: "+rs.getString("ItemName"));
                if (dateFormat.format(rs.getDate("ExpiryDate")).contentEquals(DateAndTime.get_Date())) {
                    int ID = rs.getInt("itemID");
                    query = "UPDATE inventoryprods SET ExpirationStatus = ? WHERE itemID = ?";
                    stmt2 = conn.prepareStatement(query);
                    stmt2.setString(1,"Expired");
                    stmt2.setInt(2, ID);
                    stmt2.executeUpdate();
                }
            }

            stmt1.close();
            if (stmt2 != null) {
                stmt2.close();
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to database" + e.getMessage());
        }
    }

    public static void expDate() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", username, password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Statement stmt1 = null;

            System.out.println("Item ID\t\t Item Name\n");
            String query = "SELECT * FROM inventoryprods WHERE ExpirationStatus = 'Expired'";
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(query);
            while (rs.next()) {
                int ID = rs.getInt("itemID");
                String name = rs.getString("ItemName");
                System.out.printf("%-13s %-10s\n", ID, name);
            }

            stmt1.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to database" + e.getMessage());
        }
    }
    public static void getHomeOrderDetail() {
        int ORDERID = 0;
        int CUSTOMERID = 0;
        String ADDRESS = "";
        String ORDERDATE = "";
        String ITEMSORDERED = "";
        int NUMBEROFITEMS = 0;
        String DELIVERYDATE = "";
        String ORDERSTATUS = "";
        double ORDERTOTAL = 0.0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);
            conn.setAutoCommit(true);
            System.out.println("OrderID\t CustomerID\t\tOrder Date\t\t\tItems Ordered\t\tNumber Of Items\t\t\tDelivery Date\t\t\tAddress\t\t\t\t\t\tOrder Status\tOrder Total");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM onlineorders");
            while (rs.next()) {

                ORDERID = rs.getInt("orderID");
                CUSTOMERID = rs.getInt("customerID");
                ORDERDATE = rs.getString("orderDate");
                ITEMSORDERED = rs.getString("itemsOrdered");
                NUMBEROFITEMS = rs.getInt("numberOfItems");
                DELIVERYDATE = rs.getString("deliveryDate");
                ADDRESS = rs.getString("address");
                ORDERSTATUS = rs.getString("orderStatus");
                ORDERTOTAL = rs.getDouble("orderTotal");
                System.out.printf("\n%d \t\t   %-10d  \t%-15s %-30s %-15d\t %-15s %-35s %-15s  %.2f", ORDERID, CUSTOMERID, ORDERDATE, ITEMSORDERED, NUMBEROFITEMS, DELIVERYDATE, ADDRESS, ORDERSTATUS, ORDERTOTAL);

            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database" + e.getMessage());
        }
    }
    public static void getHomeOrderDetail(int orderID) {
        int ORDERID = 0;
        int CUSTOMERID = 0;
        String ADDRESS = "";
        String ORDERDATE = "";
        String ITEMSORDERED = "";
        int NUMBEROFITEMS = 0;
        String DELIVERYDATE = "";
        String ORDERSTATUS = "";
        double ORDERTOTAL = 0.0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);
            conn.setAutoCommit(true);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM onlineorders");
            while (rs.next()) {
                if (rs.getInt("orderID") == (orderID)) {
                    ORDERID = rs.getInt("orderID");
                    CUSTOMERID = rs.getInt("customerID");
                    ORDERDATE = rs.getString("orderDate");
                    ITEMSORDERED = rs.getString("itemsOrdered");
                    NUMBEROFITEMS = rs.getInt("numberOfItems");
                    DELIVERYDATE = rs.getString("deliveryDate");
                    ADDRESS = rs.getString("address");
                    ORDERSTATUS = rs.getString("orderStatus");
                    ORDERTOTAL = rs.getDouble("orderTotal");
                    break;
                }
            }
            System.out.println("\nOrder ID: " + ORDERID + "\nCustomer ID: " + CUSTOMERID + " \nOrder Date: " + ORDERDATE + " \nItems Ordered: " + ITEMSORDERED + "\nNumber of Items: " + NUMBEROFITEMS + "\nDelivery Date: " + DELIVERYDATE + "\nAddress: " + ADDRESS + "\nOrder Status: " + ORDERSTATUS + "\nOrder Total: " + ORDERTOTAL);

        } catch (SQLException e) {
            System.out.println("error connecting to database" + e.getMessage());
        }
    }
    public static void addNewDeliveryOrder(String orderDate, String itemsOrdered, int numberOfItems, String deliveryDate, String address, double orderTotal, String customerName, String phoneNumber, String emailAddress, String paymentMethod){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);

            conn.setAutoCommit(true);

            PreparedStatement stmt1;
            stmt1 = conn.prepareStatement("INSERT INTO onlineorders (orderDate, itemsOrdered, numberOfItems, deliveryDate, address, orderTotal) VALUES (?,?,?,?,?,?)");
            stmt1.setString(1,orderDate);
            stmt1.setString(2,itemsOrdered);
            stmt1.setInt(3,numberOfItems);
            stmt1.setString(4,deliveryDate);
            stmt1.setString(5,address);
            stmt1.setDouble(6,orderTotal);

            PreparedStatement stmt2;
            stmt2 = conn.prepareStatement("INSERT INTO customers (customerName, address, phoneNumber, emailAddress, paymentMethod) VALUES(?,?,?,?,?)");
            stmt2.setString(1,customerName);
            stmt2.setString(2,address);
            stmt2.setString(3,phoneNumber);
            stmt2.setString(4,emailAddress);
            stmt2.setString(5,paymentMethod);

            int rowsInserted1 = stmt1.executeUpdate();
            int rowsInserted2 = stmt2.executeUpdate();

            stmt1.close();
            stmt2.close();
            conn.close();

            if(rowsInserted1>0 && rowsInserted2>0)
                System.out.println("A new online record was inserted successfully");
        }catch(SQLException e) {
            System.out.println("Error connecting to database: "+e.getMessage());
            try {
                conn.rollback();
            }
            catch (SQLException a){

            }
            }
        }

    public static void dispProdPerformance(){
        int itemID=0;
        String ItemName="";
        int targetS = 0;
        int actualS = 0;
        int avgS = 0;
        double profitMargin = 0.0;
        double unitP = 0.0;
        double costP = 0.0;
        int salesRank = 0;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesrecords",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ID\tIteam Name\t\tTarget Sale Quantity\t\tActual Sale Quantity\t\tAverage Sale Quantity\t\t Profit Margin\t\tUnit Price\t\tCost Price\t\tSales Rank");
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM salesrecords.productperformance");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                itemID=rs.getInt("itemID");
                ItemName =rs.getString("ItemName");
                targetS=rs.getInt("targetSaleQuantity");
                actualS=rs.getInt("actualSaleQuantity");
                avgS=rs.getInt("avgSaleQuantity");
                profitMargin=rs.getDouble("profitMargin");
                unitP=rs.getDouble("unitPrice");
                costP=rs.getDouble("costPrice");
                salesRank=rs.getInt("salesRank");

                System.out.printf("\n%s\t %-20s %-30s %-25s \t%-25s %-15s %-15s %-17s %-18s",itemID,ItemName,targetS,actualS,avgS,profitMargin,unitP,costP,salesRank);
                System.out.println();
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//displays product performance during one month

    public static sales calcSalesAnalytics(int ID){
        int itemID=0;
        String ItemName="";
        int targetS = 0;
        int actualS = 0;
        int avgS = 0;
        double profitMargin = 0.0;
        double unitP = 0.0;
        double costP = 0.0;
        int salesRank = 0;

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesrecords",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM salesrecords.productperformance");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getInt("itemID") == ID) {
                    itemID = rs.getInt("itemID");
                    ItemName = rs.getString("ItemName");
                    targetS = rs.getInt("targetSaleQuantity");
                    actualS = rs.getInt("actualSaleQuantity");
                    avgS = rs.getInt("avgSaleQuantity");
                    profitMargin = rs.getDouble("profitMargin");
                    unitP = rs.getDouble("unitPrice");
                    costP = rs.getDouble("costPrice");
                    salesRank = rs.getInt("salesRank");
                }
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new sales(itemID, ItemName, targetS, actualS,  avgS, profitMargin, unitP, costP, salesRank);
    }//used in prodPerformanceInsight() in sales class

    public static void inventoryPerformance(){
        int targetS = 0;
        int actualS = 0;
        double unitP = 0.0;
        double costP = 0.0, profit = 0, loss = 0;
        int itemsSold = 0, titemsSold = 0;
        int targetCount = 0, actualCount = 0, equalCount = 0;
        double totalRev = 0, expectedRev = 0, totalExpenses = 0;
        ArrayList<String> popular = new ArrayList<>();
        ArrayList<String> least = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesrecords",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM salesrecords.productperformance");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                targetS=rs.getInt("targetSaleQuantity");
                actualS=rs.getInt("actualSaleQuantity");
                unitP=rs.getDouble("unitPrice");
                costP=rs.getDouble("costPrice");

                if(targetS > actualS){
                    targetCount++;
                }
                else if(targetS < actualS){
                    actualCount++;
                }
                else{
                    equalCount++;
                }

                totalExpenses = totalExpenses + (actualS * costP);
                totalRev = totalRev + (actualS * unitP);

                expectedRev = expectedRev + (targetS * unitP);
                itemsSold = itemsSold + actualS;
                titemsSold = titemsSold + targetS;

                if(actualS > 2000){
                    popular.add(rs.getString("ItemName"));
                }

                if(actualS < 300){
                    least.add(rs.getString("ItemName"));
                }
            }
            System.out.println("***Monthly Inventory Performance Insight***\n");
            System.out.printf("Total Expenses: %.2f\n", totalExpenses);
            System.out.println("Expected Revenue: " + expectedRev);
            System.out.println("Revenue generated: " + totalRev);
            System.out.println();

            if(totalRev > totalExpenses){
                profit = totalRev - totalExpenses;
                System.out.printf("Gross Profit: %.2f\n", profit);
            }
            else{
                loss = totalExpenses - totalRev;
                System.out.printf("Net Loss: %.2f\n", loss);
            }

            System.out.println();
            System.out.println("Number of items which did not surpass target sales: " + targetCount);
            System.out.println("Number of items which surpassed target sales: " + actualCount);
            System.out.println("Number of items with equal target and actual sales: " + equalCount);
            System.out.println("Expected number of items to be sold: " + titemsSold);
            System.out.println("Number of items sold: " + itemsSold);
            System.out.println();

            System.out.println("Most popular product(s)\n");
            for (String value : popular) {
                System.out.println(value);
            }
            System.out.println("\nLeast popular product(s)\n");
            for (String s : least) {
                System.out.println(s);
            }

            System.out.println();
            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}