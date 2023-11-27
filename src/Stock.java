public class Stock {
    int itemID,maxStockLevel,minStockLevel,currStockLevel;
    String itemName;

    public Stock(int itemID, int maxStockLevel, int minStockLevel, int currStockLevel, String itemName) {
        this.itemID = itemID;
        this.maxStockLevel = maxStockLevel;
        this.minStockLevel = minStockLevel;
        this.currStockLevel = currStockLevel;
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getMaxStockLevel() {
        return maxStockLevel;
    }

    public void setMaxStockLevel(int maxStockLevel) {
        this.maxStockLevel = maxStockLevel;
    }

    public int getMinStockLevel() {
        return minStockLevel;
    }

    public void setMinStockLevel(int minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    public int getCurrStockLevel() {
        return currStockLevel;
    }

    public void setCurrStockLevel(int currStockLevel) {
        this.currStockLevel = currStockLevel;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
