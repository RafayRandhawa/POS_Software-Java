public class Customer {
    private int CustomerID;
    private String CustomerName;
    private String Address;
    private String PhoneNumber;
    private String Email;
    private String PaymentMethod;

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public Customer(int customerID, String customerName, String address, String phoneNumber, String email, String paymentMethod) {
        CustomerID = customerID;
        CustomerName = customerName;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
        PaymentMethod = paymentMethod;
    }
}
