
public class Order {
    private String Address;


    private int CustomerID;


    private String DeliveryDate;


    private String ItemsOrdered;

    private String orderDate;

    private int NumberOfItems;
    private String OrderStatus;
    private double OrderTotal;


    private int OrderID;
    public Order(){}

    public Order(String address, int customerID, String deliveryDate, String itemsOrdered, int numberOfItems, String orderStatus, double orderTotal, int orderID, String orderDate) {
        Address = address;
        CustomerID = customerID;
        DeliveryDate = deliveryDate;
        ItemsOrdered = itemsOrdered;
        NumberOfItems = numberOfItems;
        OrderStatus = orderStatus;
        OrderTotal = orderTotal;
        OrderID = orderID;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public double getOrderTotal() {
        return OrderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        OrderTotal = orderTotal;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getItemsOrdered() {
        return ItemsOrdered;
    }

    public void setItemsOrdered(String itemsOrdered) {
        ItemsOrdered = itemsOrdered;
    }

    public int getNumberOfItems() {
        return NumberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        NumberOfItems = numberOfItems;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
