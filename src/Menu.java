import com.mysql.cj.jdbc.ha.ServerAffinityStrategy;
import com.mysql.cj.log.Log;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Savepoint;
import java.util.Date;
import java.util.Scanner;

public class Menu {}
class cashier_menu {
    public static void menu() {
        System.out.println("Press H for home delivery or R for retail store");
        String choice = new Scanner(System.in).next();
        if (choice.contentEquals("H") || choice.contentEquals("h")) {
            while (true) {
                System.out.println("Enter a new record for the the home delivery system:\n(Type done when you're finished)");
                System.out.println("Order date: ");
                String orderDate = new Scanner(System.in).nextLine();
                if (orderDate.equals("Done") || orderDate.equals("done"))
                    break;
                System.out.println("Items ordered: ");
                String itemsOrdered = new Scanner(System.in).nextLine();
                System.out.println("Number of items: ");
                int numberOfItems = new Scanner(System.in).nextInt();
                System.out.println("Delivery Date: ");
                String deliveryDate = new Scanner(System.in).nextLine();
                System.out.println("Address: ");
                String address = new Scanner(System.in).nextLine();
                System.out.println("Order Total: ");
                double orderTotal = new Scanner(System.in).nextDouble();
                System.out.println("Customer Name: ");
                String customerName = new Scanner(System.in).nextLine();
                System.out.println("Customer's Contact number: ");
                String phNumber = new Scanner(System.in).next();
                System.out.println("Customer's E-mail address: ");
                String email = new Scanner(System.in).next();
                System.out.println("Payment Method: ");
                String paymentMethod = new Scanner(System.in).next();

                Database.addNewDeliveryOrder(orderDate, itemsOrdered, numberOfItems, deliveryDate, address, orderTotal, customerName, phNumber, email, paymentMethod);
            }

        } else if (choice.equals("r") || choice.equals("R")) {

            boolean first = true;
            while (true) {
                if (!first) {
                    System.out.println("Type exit if you would like to Logout");
                    String status = new Scanner(System.in).nextLine();
                    if (status.contentEquals("exit") || status.contentEquals("exit")) {
                        break;
                    }
                } else {
                    first = false;
                }
                while (true) {
                    System.out.println("\nEnter Items to add to cart --> \n(Type done when you're finished)");
                    System.out.println("\nItem Name: ");
                    String itemName = new Scanner(System.in).nextLine();
                    if (itemName.contentEquals("Done") || itemName.contentEquals("done")) {
                        break;
                    }
                    System.out.println("Item Quantity: ");
                    int itemQuantity = new Scanner(System.in).nextInt();
                    Cart.add_item(Database.get_itemDetails(itemName, itemQuantity));
                }


                System.out.println("Do you want to remove an item? (y/n)");
                String opt = new Scanner(System.in).nextLine();

                if (opt.contentEquals("y") || opt.contentEquals("Y")) {
                    System.out.println("Enter index number of item");
                    int index = new Scanner(System.in).nextInt();
                    Cart.remove_item(index);
                }


                System.out.println("Proceeding to Payment -->");
                PurchaseBilling.billing();
                Inventory.updateStockLevels();
                System.out.println("\n\n\n\n\n");
            }
        }
    }
}
class manager_menu {
    public static void menu() {
        System.out.println("Welcome " + Login.manager.getManagerName() + "!");
        while (true) {

            System.out.println("\nWhat would you like to do today");
            System.out.println("1: Manage Cashiers\n2: Manage Sales\n3: Manage Delivery Orders\n4: Logout");
            int choice = new Scanner(System.in).nextInt();
            while (choice < 1 || choice > 4) {
                System.out.println("Invalid Choice, Please choose again...\n1: Manage Cashiers\n2: Manage Sales\n3: Logout   \nChoose one of the above...\n");
                choice = new Scanner(System.in).nextInt();
            }
            switch (choice) {
                case 1:
                    //Cashier Management menu
                    while (true) {
                        System.out.println("\n1: View Cashiers");
                        System.out.println("2: Register a new Cashier");
                        System.out.println("3: Update information of an existing Cashier");
                        System.out.println("4: Remove Cashier");
                        System.out.println("5: Back to Main Menu\n");
                        choice = new Scanner(System.in).nextInt();
                        switch (choice) {

                            case 1:
                                while (true) {
                                    System.out.println("\n1: Display all Cashiers\n2: Search by Cashier Code or Name\n3: Back to Main Menu\n4: Back to Cashier Menu\n");
                                    choice = new Scanner(System.in).nextInt();
                                    if (choice == 1) {
                                        Login.manager.displayCashiers();
                                    } else if (choice == 2) {
                                        while (true){
                                            System.out.println("\nPlease enter Cashier Code or Name: ");
                                            String SearchValue = new Scanner(System.in).nextLine();
                                            if(SearchValue.contentEquals("back")||SearchValue.contentEquals("Back")){break;}
                                            try {
                                                int CashierCode = Integer.parseInt(SearchValue);
                                                Login.manager.searchCashier(CashierCode);
                                            } catch (Exception e) {
                                                Login.manager.searchCashier(SearchValue);
                                            }

                                        }
                                    } else if (choice == 3) {
                                        choice=5;
                                        break;
                                    } else if (choice==4) {
                                        break;
                                    } else {
                                        System.out.println("Please Give a valid input....\nChoose from the following options and enter the # of your choice");
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("\n\n");
                                Login.manager.addCashier();
                                break;

                            case 3:
                                System.out.println("\n\n");
                                Login.manager.updateCashierDetails();
                                break;
                            case 4:
                                System.out.println("Enter Cashier Code of the Cashier you wish to remove: ...\n");
                                Login.manager.removeCashier(new Scanner(System.in).nextInt());
                                break;
                            case 5:
                                break;
                        }
                        if (choice==5) {
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("\n1: View all Sales Records");
                        System.out.println("2: Search for a specific Sales Record");
                        System.out.println("3: View Sales Analytics for Inventory");
                        System.out.println("4: View Sales Analytics for a Specific Product");
                        System.out.println("5: Monthly Inventory Performance Insight");
                        System.out.println("6: Back to Main Menu\n");
                        choice = new Scanner(System.in).nextInt();
                        while (choice < 1 || choice > 6) {
                            System.out.println("Invalid choice... Please choose again:\n");
                            System.out.println("1: View all Sales Records");
                            System.out.println("2: Search for a specific Sales Record");
                            System.out.println("3: View Sales Analytics for Inventory");
                            System.out.println("4: View Sales Analytics for a Specific Product");
                            System.out.println("5: Monthly Inventory Performance Insight");
                            System.out.println("6: Back to Main Menu\n");
                            choice = new Scanner(System.in).nextInt();
                        }
                        switch (choice) {

                            case 1:
                               Login.manager.viewAllSales();
                                break;

                            case 2:
                                while (true){
                                    System.out.println("\nPlease enter Sales ID or CashierCode: \n(Enter 'Back' to go back to Sales menu)");
                                    String SearchValue = new Scanner(System.in).nextLine();
                                    if(SearchValue.contentEquals("back")||SearchValue.contentEquals("Back")){break;}
                                        int CashierCode = Integer.parseInt(SearchValue);
                                        boolean found = Login.manager.viewAllSales(CashierCode);
                                        if (!found){
                                        Login.manager.viewAllSales(Integer.parseInt(SearchValue),1);
                                }
                                }
                                break;

                            case 3:
                                sales.dispProdPerformane();
                                break;
                            case 4:
                                sales.prodPerformanceInsight();
                                break;
                            case 5:
                                sales.inventoryPerformance();
                                break;
                            case 6:
                                break;
                        }
                        if (choice==6) {
                            break;
                        }
                    }
                    break;
                case 3:                     //Home delivery menu
                    while(true) {
                        System.out.println("What do you want to do?\n1. Get a specific order detail\n2. View all Home delivery orders\n3. Get a specific customer's detail\n4. Get all customer details\n5. Exit to main menu");
                        choice = new Scanner(System.in).nextInt();
                        while (choice < 1 || choice > 5) {
                            System.out.println("Invalid choice... Please choose again:\n1. Get a specific order detail\n2. View all Home delivery orders\n3. Get a specific customer's detail\n4. Get all customer details\n5. Exit to main menu");
                            choice = new Scanner(System.in).nextInt();
                        }
                        switch (choice) {
                            case 1:
                                System.out.println("Enter order ID for the record to be retrieved: ");
                                int orderID = new Scanner(System.in).nextInt();
                                Database.getHomeOrderDetail(orderID);
                                break;
                            case 2:
                                Database.getHomeOrderDetail();
                                break;
                            case 3:
                                System.out.println("Enter the customer ID for the record to be retrieved: ");
                                int customerID = new Scanner(System.in).nextInt();
                                Database.getDeliveryCustomerDetail(customerID);
                                break;
                            case 4:
                                Database.getDeliveryCustomerDetail();
                                break;
                            case 5:
                                break;
                        }
                        if(choice == 5)
                            break;
                    }
                    break;
                case 4:
                    System.exit(1);
                    break;

            }

        }
    }
}
class stockmanager_menu{
    public static void menu(){
        System.out.println("Welcome " + Login.stockManager.getManagerName() + "!");
        while (true) {
            System.out.println("What do you have in mind for today\n1: Manage Inventory\n2: Manage Stocks\n3: Manage Suppliers\n4: Logout");
            int selection = new Scanner(System.in).nextInt();
            switch (selection) {
                case 1:
                    while (true) {
                        System.out.println("\nWhat would you like to do today\n");
                        System.out.println("\n1: View Inventory");
                        System.out.println("2: Add a New Item to Inventory");
                        System.out.println("3: Remove Item from Inventory");
                        System.out.println("4: Back to Main Menu\n");
                        int choice = new Scanner(System.in).nextInt();
                        switch (choice) {

                            case 1:
                                while (true) {
                                    System.out.println("\n1: Display all Items\n2: Search by Item ID or Name\n3: Back to Main Menu\n4: Back to Item Menu\n");
                                    choice = new Scanner(System.in).nextInt();
                                    if (choice == 1) {
                                        Login.stockManager.viewAllItems();
                                    } else if (choice == 2) {
                                        while (true) {
                                            System.out.println("\nPlease enter Item ID or Name: ");
                                            String SearchValue = new Scanner(System.in).nextLine();
                                            if (SearchValue.contentEquals("back") || SearchValue.contentEquals("Back")) {
                                                break;
                                            }
                                            try {
                                                int Id = Integer.parseInt(SearchValue);
                                                Login.stockManager.findItem(Id);
                                            } catch (Exception e) {
                                                Login.stockManager.findItem(SearchValue);
                                            }

                                        }
                                    } else if (choice == 3) {

                                        break;
                                    } else if (choice == 4) {
                                        break;
                                    } else {
                                        System.out.println("Please Give a valid input....\nChoose from the following options and enter the # of your choice");
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("\n\n");
                                Login.stockManager.addNewItemToInv();
                                break;

                            case 3:
                                Login.stockManager.removeItemFromInv();
                                break;

                            case 4:
                                break;
                        }
                        if (choice == 4) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("\nWhat would you like to do today\n");
                        System.out.println("\n1: View Item Details");
                        System.out.println("2: Check Stock Levels");
                        System.out.println("3: Check Expired Items");
                        System.out.println("4: Back to Main Menu\n");
                        int choice = new Scanner(System.in).nextInt();
                        switch (choice) {

                            case 1:
                                while (true) {
                                    System.out.println("\n1: Display all Items\n2: Search by Item ID or Name\n3: Back to Main Menu\n4: Back to Item Menu\n");
                                    choice = new Scanner(System.in).nextInt();
                                    if (choice == 1) {
                                        Login.stockManager.viewAllItemDetails();
                                    } else if (choice == 2) {
                                        while (true) {
                                            Login.stockManager.viewItem();
                                            System.out.println("\nWould you like to exit or continue viewing items ?(Press E to exit)");
                                            String exit = new Scanner(System.in).nextLine();
                                            if (exit.contentEquals("E") || exit.contentEquals("e")) {
                                                break;
                                            }
                                        }
                                    } else if (choice == 3) {

                                        break;
                                    } else if (choice == 4) {
                                        break;
                                    } else {
                                        System.out.println("Please Give a valid input....\nChoose from the following options and enter the # of your choice");
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("\n\n");
                                Login.stockManager.checkStockLevels();
                                break;

                            case 3:
                                //Expired Items display Function
                                break;

                            case 4:
                                break;
                        }
                        if (choice == 4) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("\nWhat would you like to do today\n");
                        System.out.println("\n1: View All Suppliers");
                        System.out.println("2: Search for Items by a Supplier");
                        System.out.println("3: Search for a Supplier");
                        System.out.println("4: Back to Main Menu\n");
                        int choice = new Scanner(System.in).nextInt();
                        switch (choice) {

                            case 1:
                                Login.stockManager.viewAllSuppliers();
                                break;

                            case 2:

                                Login.stockManager.ItemsBySupplier();
                                break;

                            case 3:
                                Login.stockManager.searchForSupplier();
                                break;

                            case 4:
                                break;
                        }
                        if (choice == 4) {
                            break;
                        }
                    }
                    break;
                case 4:
                    System.exit(1);
                    break;
            }
        }
    }
}