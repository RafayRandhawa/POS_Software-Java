public class SalesRecord {
    private int SalesID;
    private int CashierCode;
    private String SaleDate;
    private String SaleTime;
    private Double amount;
    private int NoOfItems;
    private String paymentMethod;

    public int getSalesID() {
        return SalesID;
    }

    public int getCashierCode() {
        return CashierCode;
    }

    public String getSaleDate() {
        return SaleDate;
    }

    public String getSaleTime() {
        return SaleTime;
    }

    public Double getAmount() {
        return amount;
    }

    public int getNoOfItems() {
        return NoOfItems;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setSalesID(int salesID) {
        SalesID = salesID;
    }

    public void setCashierCode(int cashierCode) {
        CashierCode = cashierCode;
    }

    public void setSaleDate(String saleDate) {
        SaleDate = saleDate;
    }

    public void setSaleTime(String saleTime) {
        SaleTime = saleTime;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setNoOfItems(int noOfItems) {
        this.NoOfItems = noOfItems;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SalesRecord(int salesID, int cashierCode, String saleDate, String saleTime, Double amount, int numberOfItems, String paymentMethod) {
        SalesID = salesID;
        CashierCode = cashierCode;
        SaleDate = saleDate;
        SaleTime = saleTime;
        this.amount = amount;
        this.NoOfItems = numberOfItems;
        this.paymentMethod = paymentMethod;
    }

}
