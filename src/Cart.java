import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    public static ArrayList<Item> inventoryList = new ArrayList<Item>(1);

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

    public static void remove(int index){
        index-=1;
        Item i = inventoryList.get(index);
       inventoryList.remove(index);
    }

}
