import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/employees";
    private static final String username = "root";
    private static final String password = "Randhawa@147";
    public void hello_Database(){
        int a = 0;
        System.out.println("Hello World");

    }
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

    public static void addNewCashier(String CashierName,String Join,String Start,String End, int hrsWorked,String password1){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO cashierdetails (CashierName,JoiningDate,ShiftStartTime,ShiftEndTime,TotNoOfHoursWorked) VALUES (?,?,?,?,?)");
            stmt.setString(1,CashierName);
            stmt.setString(2,Join);
            stmt.setString(3,Start);
            stmt.setString(4,End);
            stmt.setInt(5,hrsWorked);

            int rowsInserted = stmt.executeUpdate();

            int CashierCode=0;
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery("SELECT * FROM cashierdetails ORDER BY CashierCode DESC LIMIT 1");
            while(rs.next()){
                CashierCode = rs.getInt("CashierCode");
            }

            stmt = conn.prepareStatement("INSERT INTO cashierlogininfo (CashierCode,CashierName,CashierPassword) VALUES (?,?,?)");
            stmt.setInt(1,CashierCode);
            stmt.setString(2,CashierName);
            stmt.setString(3,password1);

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
    public static void updateCashierInfo(String CashierCode,String CashierName,String Shift){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(true);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cashierlogininfo");
            int Code = Integer.parseInt(CashierCode);


            PreparedStatement pstmt = null;
            PreparedStatement pstmt1 = null;


            pstmt = conn.prepareStatement("UPDATE cashierdetails \nSET CashierName = ?\nWHERE CashierCode = ?");
            pstmt1 = conn.prepareStatement("UPDATE cashierlogininfo \n SET CashierName = ? \nWHERE CashierCode = ?");
            pstmt.setString(1, CashierName);

            pstmt.setInt(2,Code);

            pstmt1.setString(1, CashierName);

            pstmt1.setInt(2,Code);
            pstmt.executeUpdate();
            pstmt1.executeUpdate();


            PreparedStatement pstmt2 = null;
            if(Shift.contentEquals("Morning")|| Shift.contentEquals("morning")){
                pstmt2 = conn.prepareStatement("UPDATE cashierdetails\n SET ShiftStartTime = '08:00:00',ShiftEndTime = '16:00:00' \nWHERE CashierCode = ?");
                pstmt2.setInt(1,Code);
                pstmt2.executeUpdate();
            }
            else if (Shift.contentEquals("Evening")|| Shift.contentEquals("evening")) {
                pstmt2 = conn.prepareStatement("UPDATE cashierdetails \nSET ShiftStartTime = '16:00:00',ShiftEndTime = '00:00:00' \nWHERE CashierCode = ?");
                pstmt2.setInt(1,Code);
                pstmt2.executeUpdate();
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
    public static ArrayList<SalesRecord> getSalesRecord(int cashier_code){
        int SalesID = 0;
        int CashierCode = 0;
        String SaleDate = "";
        String SaleTime = "";
        Double Amount = 0.0;
        int NoOfItems = 0;
        String PaymentMethod = "";
        ArrayList<SalesRecord> salesRecords = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM cashiersales");

            while(rs.next()){
                SalesID = rs.getInt("SalesID");
                CashierCode= rs.getInt("CashierCode");
                SaleDate= rs.getString("SaleDate");
                SaleTime= rs.getString("SaleTIme");
                Amount= rs.getDouble("Amount");
                NoOfItems= rs.getInt("NoOfItems");
                PaymentMethod= rs.getString("PaymentMethod");
                if(CashierCode==cashier_code){

                    salesRecords.add(new SalesRecord(SalesID,CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod));
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return salesRecords;
    }
    public static ArrayList<SalesRecord> getSalesRecord(){
        int SalesID = 0;
        int CashierCode = 0;
        String SaleDate = "";
        String SaleTime = "";
        Double Amount = 0.0;
        int NoOfItems = 0;
        String PaymentMethod = "";
        ArrayList<SalesRecord> salesRecords = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM cashiersales");

            while(rs.next()){
                SalesID = rs.getInt("SalesID");
                CashierCode= rs.getInt("CashierCode");
                SaleDate= rs.getString("SaleDate");
                SaleTime= rs.getString("SaleTIme");
                Amount= rs.getDouble("Amount");
                NoOfItems= rs.getInt("NoOfItems");
                PaymentMethod= rs.getString("PaymentMethod");

                salesRecords.add(new SalesRecord(SalesID,CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return salesRecords;
    }

    public static  ArrayList<Order> getOrderDetail() {
        int ORDERID = 0;
        int CUSTOMERID = 0;
        String ADDRESS = "";
        String ORDERDATE = "";
        String ITEMSORDERED = "";
        int NUMBEROFITEMS = 0;
        String DELIVERYDATE = "";
        String ORDERSTATUS = "";
        double ORDERTOTAL = 0.0;
        ArrayList<Order> Orders= new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);
            conn.setAutoCommit(true);
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
                 Orders.add( new Order(ADDRESS,CUSTOMERID,DELIVERYDATE,ITEMSORDERED,NUMBEROFITEMS,ORDERSTATUS,ORDERTOTAL,ORDERID,ORDERDATE));
            }
            return Orders;

        } catch (SQLException e) {
            System.out.println("Error connecting to database" + e.getMessage());
        }
        return Orders;
    }
    public static ArrayList<Order> getOrderDetail(int orderID) {
        int ORDERID = 0;
        int CUSTOMERID = 0;
        String ADDRESS = "";
        String ORDERDATE = "";
        String ITEMSORDERED = "";
        int NUMBEROFITEMS = 0;
        String DELIVERYDATE = "";
        String ORDERSTATUS = "";
        double ORDERTOTAL = 0.0;
        ArrayList<Order> Orders = new ArrayList<>();
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
            Orders.add(new Order(ADDRESS,CUSTOMERID,DELIVERYDATE,ITEMSORDERED,NUMBEROFITEMS,ORDERSTATUS,ORDERTOTAL,ORDERID,ORDERDATE));
            return Orders;
        } catch (SQLException e) {
            System.out.println("error connecting to database" + e.getMessage());
            return Orders;
        }
    }
    public static ArrayList<Customer> getCustomerDetail(){
        int CUSTOMERID = 0;
        String CUSTOMERNAME = "";
        String ADDRESS = "";
        String PHNUMBER = "";
        String EMAILADDRESS = "";
        String PAYMENTMETHOD = "";
        ArrayList<Customer> Customers = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);
            conn.setAutoCommit(true);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                CUSTOMERID = rs.getInt("customerID");
                CUSTOMERNAME = rs.getString("customerName");
                ADDRESS = rs.getString("address");
                PHNUMBER = rs.getString("phoneNumber");
                EMAILADDRESS = rs.getString("emailAddress");
                PAYMENTMETHOD = rs.getString("paymentMethod");
                Customers.add(new Customer(CUSTOMERID,CUSTOMERNAME,ADDRESS,PHNUMBER,EMAILADDRESS,PAYMENTMETHOD));

            }

        } catch (SQLException e) {
            System.out.println("error connecting to database" + e.getMessage());
        }
        return Customers;
    }
    public static ArrayList<Customer> getCustomerDetail(int customerID){
        int CUSTOMERID = 0;
        String CUSTOMERNAME = "";
        String ADDRESS = "";
        String PHNUMBER = "";
        String EMAILADDRESS = "";
        String PAYMENTMETHOD = "";
        ArrayList<Customer> Customers = new ArrayList<>();
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
            Customers.add(new Customer(CUSTOMERID,CUSTOMERNAME,ADDRESS,PHNUMBER,EMAILADDRESS,PAYMENTMETHOD));
        } catch (SQLException e) {
            System.out.println("error connecting to database" + e.getMessage());
        }return Customers;
    }
    public static ArrayList<SalesRecord> getSalesRecordID(int salesID){
        int SalesID = 0;
        int CashierCode = 0;
        String SaleDate = "";
        String SaleTime = "";
        Double Amount = 0.0;
        int NoOfItems = 0;
        String PaymentMethod = "";
        ArrayList<SalesRecord> salesRecords = new ArrayList<>();
        //Second int parameter has no functional value
        //Parameter_Restriction was included to allow for function overloading
        try{
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM cashiersales");

            while(rs.next()){
                SalesID = rs.getInt("SalesID");
                CashierCode= rs.getInt("CashierCode");
                SaleDate= rs.getString("SaleDate");
                SaleTime= rs.getString("SaleTIme");
                Amount= rs.getDouble("Amount");
                NoOfItems= rs.getInt("NoOfItems");
                PaymentMethod= rs.getString("PaymentMethod");
                if(salesID==SalesID){
                    salesRecords.add(new SalesRecord(SalesID,CashierCode,SaleDate,SaleTime,Amount,NoOfItems,PaymentMethod));
                }
            }
            rs.close();
            stmt.close();
            conn.close();


        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return salesRecords;
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

                if(rs.getString("ItemName").contentEquals(itemName)) {
                     ITEMID=rs.getInt("itemID");
                     ITEMNAME =rs.getString("ItemName");
                     PRICE=rs.getDouble("Price");
                     QUANTITY=rs.getInt("Quantity");
                     EXPIRYDATE=rs.getString("ExpiryDate");
                }
            }

            if (quantity>QUANTITY){
                return new Item(ITEMID,ITEMNAME,PRICE,-1,EXPIRYDATE);
            }
            else {
                QUANTITY = quantity;
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }

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

        return new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE,SUPP);
    }
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

            while (rs.next()){
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");
                    int[] stock_levels = Database.printStock(ITEMID);
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
    }
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
    }
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
    }
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
    }
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
    }
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

            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
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

    public static void addNewDeliveryOrder(String orderDate, String itemsOrdered, int numberOfItems, String deliveryDate, String address, double orderTotal, String customerName, String phoneNumber, String emailAddress, String paymentMethod){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinedeliverysystem", username, password);

            conn.setAutoCommit(true);
            PreparedStatement stmt2;
            stmt2 = conn.prepareStatement("INSERT INTO customers (customerName, address, phoneNumber, emailAddress, paymentMethod) VALUES(?,?,?,?,?)");
            stmt2.setString(1,customerName);
            stmt2.setString(2,address);
            stmt2.setString(3,phoneNumber);
            stmt2.setString(4,emailAddress);
            stmt2.setString(5,paymentMethod);
            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            String cusID="";
            while (rs.next()){
                cusID = rs.getString("customerID");
            }
            PreparedStatement stmt1;
            stmt1 = conn.prepareStatement("INSERT INTO onlineorders (customerID,orderDate, itemsOrdered, numberOfItems, deliveryDate, address, orderTotal) VALUES (?,?,?,?,?,?,?)");
            stmt1.setString(1,cusID);
            stmt1.setString(2,orderDate);
            stmt1.setString(3,itemsOrdered);
            stmt1.setInt(4,numberOfItems);
            stmt1.setString(5,deliveryDate);
            stmt1.setString(6,address);
            stmt1.setDouble(7,orderTotal);



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

    public static ArrayList<ProdPerformance> displayProdPerformance(){
        int itemID=0;
        String ItemName="";
        int targetS = 0;
        int actualS = 0;
        int avgS = 0;
        double profitMargin = 0.0;
        double unitP = 0.0;
        double costP = 0.0;
        int salesRank = 0;
        ArrayList<ProdPerformance> prodPerformance = new ArrayList<ProdPerformance>();
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
                itemID=rs.getInt("itemID");
                ItemName =rs.getString("ItemName");
                targetS=rs.getInt("targetSaleQuantity");
                actualS=rs.getInt("actualSaleQuantity");
                avgS=rs.getInt("avgSaleQuantity");
                profitMargin=rs.getDouble("profitMargin");
                unitP=rs.getDouble("unitPrice");
                costP=rs.getDouble("costPrice");
                salesRank=rs.getInt("salesRank");
                prodPerformance.add(new ProdPerformance(itemID, ItemName, targetS, actualS, avgS, profitMargin, unitP, costP, salesRank));


            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodPerformance;
    }
    public static ArrayList<ProdPerformance> displayProdPerformance(int ID) throws SQLException {
        int itemID = 0;
        String ItemName = "";
        int targetS = 0;
        int actualS = 0;
        int avgS = 0;
        double profitMargin = 0.0;
        double unitP = 0.0;
        double costP = 0.0;
        int salesRank = 0;
        ArrayList<ProdPerformance> prodPerformance = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesrecords", username, password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM salesrecords.productperformance");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                if (rs.getInt("itemID") == ID) {
                    itemID = rs.getInt("itemID");
                    ItemName = rs.getString("ItemName");
                    targetS = rs.getInt("targetSaleQuantity");
                    actualS = rs.getInt("actualSaleQuantity");
                    avgS = rs.getInt("avgSaleQuantity");
                    profitMargin = rs.getDouble("profitMargin");
                    unitP = rs.getDouble("unitPrice");
                    costP = rs.getDouble("costPrice");
                    salesRank = rs.getInt("salesRank");
                    prodPerformance.add(new ProdPerformance(itemID, ItemName, targetS, actualS,avgS,profitMargin,unitP,costP,salesRank));
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodPerformance;
    }

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
    public static ArrayList<Stock> checkitemStock(){
        int itemID = 0;
        String iname = null;
        int current=0;
        int max=0;
        int min=0;
        ArrayList<Stock> Stocks = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventorylevels");

            while (rs.next()){
                itemID = rs.getInt("itemID");
                iname = rs.getString("ItemName");
                current = rs.getInt("CurrentstockLevel");
                max = rs.getInt("MaxStockLevel");
                min = rs.getInt("MinStockLevel");
                Stocks.add(new Stock(itemID,max,min,current,iname));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Stocks;
    }
    public static ArrayList<Stock> checkitemStock(int ID){
        int itemID = 0;
        String iname = null;
        int current=0;
        int max=0;
        int min=0;
        ArrayList<Stock> Stocks = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventorylevels");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if (rs.getInt("itemID")==ID){
                    iname = rs.getString("ItemName");
                    current = rs.getInt("CurrentstockLevel");
                    max = rs.getInt("MaxStockLevel");
                    min = rs.getInt("MinStockLevel");
                    Stocks.add(new Stock(ID,max,min,current,iname));
                }
            }
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Stocks;
    }
    public static ArrayList<Item> expDateReturn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", username, password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Item> Items = new ArrayList<>();
        try {
            Statement stmt1 = null;

            String query = "SELECT * FROM inventoryprods WHERE ExpirationStatus = 'Expired'";
            stmt1 = conn.createStatement();
            ResultSet rs = stmt1.executeQuery(query);
            while (rs.next()) {
                int ID = rs.getInt("itemID");
                String name = rs.getString("ItemName");
                Items.add(new Item(ID,name));
            }

            stmt1.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to database" + e.getMessage());
        }
        return Items;
    }
    public static ArrayList<Item> searchSupplier(String itemName){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SupplierName = "";
        Connection conn = null;
        ArrayList<Item> Suppliers = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventoryprods WHERE itemName = ?");
            pstmt.setString(1, itemName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getString("itemName").contentEquals(itemName)) {
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SupplierName = rs.getString("SupplierName");
                }
                Suppliers.add(new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE,SupplierName));
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Suppliers;
    }
    public static ArrayList<Item> searchSupplier(int itemID){
        String SUPPNAME = "";
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        Connection conn = null;
        ArrayList<Item> Suppliers = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventoryprods WHERE itemID = ?");
            pstmt.setInt(1, itemID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if(rs.getInt("itemID")==itemID) {
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPPNAME = rs.getString("SupplierName");
                }
                Item item = new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE);
                item.setSupp_name(SUPPNAME);

                Suppliers.add(item);
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Suppliers;
    }
    public static ArrayList<Supplier> getSupplierDetails(String suppName){
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
        ArrayList<Supplier> searchSupplier = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                searchSupplier.add(new Supplier(suppID,supplierName,cname,title,add,city,region,pcode,country,ph,fax,email,web));
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return searchSupplier;
    }
    public static ArrayList<Supplier> getSupplierDetails(){
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
        ArrayList<Supplier> searchSupplier = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery("SELECT * FROM inventory.supplierinfo");

            while (rs.next()){

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

                searchSupplier.add(new Supplier(suppID,supplierName,cname,title,add,city,region,pcode,country,ph,fax,email,web));

            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return searchSupplier;
    }
    public static ArrayList<Item> getitemDetails(){

        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        ArrayList<Item> Items = new ArrayList<>() ;
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            while (rs.next()){
                //System.out.println("ItemName: "+rs.getString("ItemName"));
                ITEMNAME =rs.getString("ItemName");
                ITEMID=rs.getInt("itemID");
                PRICE=rs.getDouble("Price");
                QUANTITY=rs.getInt("Quantity");
                EXPIRYDATE=rs.getString("ExpiryDate");
                SUPP= rs.getString("SupplierName");
                Items.add(new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE,SUPP));
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        //System.out.println("Check");;
        return Items;
    }
    public static ArrayList<Item> getitemDetails(int ItemID){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        ArrayList<Item> Items = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            while (rs.next()){
                if(ItemID==rs.getInt("itemID")){
                    //System.out.println("ItemName: "+rs.getString("ItemName"));
                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");
                    Items.add(new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE,SUPP));
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return Items;
        //System.out.println("Check");;
    }
    public static ArrayList<Item> getitemDetails(String itemName){
        int ITEMID=0;
        String ITEMNAME="";
        double PRICE=0;
        int QUANTITY=0;
        String EXPIRYDATE="";
        String SUPP="";
        ArrayList<Item> Items = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM inventoryprods ");
            while (rs.next()){
                if(itemName.contentEquals(rs.getString("ItemName"))){

                    ITEMNAME =rs.getString("ItemName");
                    ITEMID=rs.getInt("itemID");
                    PRICE=rs.getDouble("Price");
                    QUANTITY=rs.getInt("Quantity");
                    EXPIRYDATE=rs.getString("ExpiryDate");
                    SUPP= rs.getString("SupplierName");
                    Items.add(new Item(ITEMID,ITEMNAME,PRICE,QUANTITY,EXPIRYDATE,SUPP));
                }
            }


            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e){
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return Items;
    }

}