import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private static ArrayList<Item> inventoryList = new ArrayList<Item>(1);

    public static int getInventoryListSize() {
        return Cart.inventoryList.size();
    }

    public static void add_item(int itemID,String itemName, double price, int quantity, String expiry_date){
        inventoryList.add(new Item(itemID,itemName, price, quantity, expiry_date));
    }
    public static void add_item(Item item){
        inventoryList.add(item);
    }
    public static ArrayList<Item> getInventoryList(){
        return inventoryList;
    }
    public static void remove_item(int index){
        index-=1;
        Item i = inventoryList.get(index);
        System.out.println("Are you sure you want to remove (press Y): " + i.getItemName());
        String opt = new Scanner(System.in).next();

        if(opt.contentEquals("Y")||opt.contentEquals("y")){
            inventoryList.remove(index);
        }
        else {
            System.out.println("Item was not removed. ");
        }
    }
    public static void remove_item(int index,int quantity){
        index-=1;
        Item i = inventoryList.get(index);
        System.out.println("Are you sure you want to remove (press Y): " + i.getItemName());
        String opt = new Scanner(System.in).nextLine();

        if(opt.contentEquals("Y")||opt.contentEquals("y")){
            inventoryList.remove(index);
            while(quantity > i.getQuantity()){
                System.out.println("Item quantity in the cart is less than the quantity entered");
                quantity = new Scanner(System.in).nextInt();
            }
            i.setQuantity(quantity);
            inventoryList.add(i);
            System.out.println("Item has been altered");
        }
    }
}
