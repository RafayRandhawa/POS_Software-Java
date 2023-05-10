public class Item{
    private int itemNumber;
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

    public int getQuantity() { return quantity; }

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

    public void setItemNumber(int itemNumber) {this.itemNumber = itemNumber;}

    public int getItemNumber() {return itemNumber;}
}
