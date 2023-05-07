import java.util.Scanner;

class PurchaseBilling {
    public static void billing(){
        double total_amount=0;

        for(Item item:Cart.getInventoryList()){
            total_amount+=(item.getPrice()* item.getQuantity());
        }
        System.out.println("Your Total Amount is: "+total_amount+"\n\n");

        double discounted_amount;
        if(total_amount>=100){
            discounted_amount=total_amount-(total_amount*0.05);
        }
        else if(total_amount>=50){
            discounted_amount=total_amount-(total_amount*0.02);
        }
        else {
            discounted_amount=total_amount;
        }

        int selection= 0;
        while(selection>5 || selection<1) {
            System.out.println("Choose your Payment Method: \n" +
                    "1: Credit Card\n" +
                    "2: Master Card\n" +
                    "3: Debit Card\n" +
                    "4: Cash\n" +
                    "5: Visa Card\n");
            selection = new Scanner(System.in).nextInt();
            if(selection>5 || selection<1){
                System.out.println("Invalid Selection: Please pick one of the given options... ");
            }
        }
        String payment_method="";
        switch(selection){
            case 1: payment_method = "Card (Credit)";
                break;
            case 2: payment_method = "Card (Debit)";
                break;
            case 3: payment_method = "Card (Master)";
                break;
            case 4: payment_method = "Cash";
                break;
            case 5: payment_method = "Card (Visa)";
                break;
        }
        Database.add_SalesRecord(Login.cashier.getCashierCode(), DateAndTime.get_Date(),DateAndTime.get_Time(),total_amount,Cart.getInventoryListSize(),payment_method);
        System.out.println("-----Receipt-----");
        System.out.println("Sales ID: "+Database.getSalesID());
        System.out.println("Date: "+DateAndTime.get_Date()+"\tTime: "+DateAndTime.get_Time());
        System.out.println("Cashier "+Login.cashier.getCashierName());
        System.out.println("Shift: "+Login.cashier.getShiftStart()+"-"+Login.cashier.getEndShift());
        //System.out.println("\nItem# \t tem Name \t Quantity \t Price \t Total");
        System.out.println("\nItem#  Item Name      Quantity     Price       Total");
        int itemCount = 1;
        int totalQuantity = 0;
        for (Item item : Cart.getInventoryList()) {
            System.out.printf("%-6d %-15s %-11d $%-10.2f $%-10.2f\n", itemCount, item.getItemName(), item.getQuantity(), item.getPrice(), item.getTotal());
            itemCount++;
            totalQuantity += item.getQuantity();
        }
        /*for(Item item:Cart.getInventoryList()){
            //System.out.printf(" %d \t%10s %12d %12.2f %8.2f\n", itemCount, item.getItemName(), item.getQuantity(), item.getPrice(), item.getTotal());
            System.out.printf(" " + itemCount + " \t\t " + item.getItemName()+ " \t\t " + item.getQuantity() + " \t\t\t %.2f \t\t %.2f\n",item.getPrice(),item.getTotal());
            itemCount++;
            totalQuantity+=item.getQuantity();
        }*/
        System.out.println("\n\nTotal items: "+(itemCount-1)+"\tTotal Quantity = "+totalQuantity);
        System.out.printf("Net Amount: %.2f\n",total_amount);
        System.out.printf("Amount after applying discount (if any): %.2f",discounted_amount);
        if (payment_method.contentEquals("Cash")){
            System.out.println("\nPayment Method: Cash");
            System.out.println("Enter the amount received from the customer");
            double enteredAmount = new Scanner(System.in).nextInt();
            System.out.printf("Amount received: %.2f\n",enteredAmount);
            System.out.printf("Change: %.2f\n",(enteredAmount-total_amount));
        }
        else{
            System.out.println("\nPayment Method: " + payment_method);
        }
    }
}