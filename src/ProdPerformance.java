public class ProdPerformance {
    private int itemID;
    private String ItemName;
    private int targetS;
    private int actualS;
    private int avgS;
    private double profitMargin;
    private double unitP;
    private double costP;
    private int salesRank;

    public int getItemID() {
        return itemID;
    }

    public double getCostP() {
        return costP;
    }

    public void setCostP(double costP) {
        this.costP = costP;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getTargetS() {
        return targetS;
    }

    public void setTargetS(int targetS) {
        this.targetS = targetS;
    }

    public int getActualS() {
        return actualS;
    }

    public void setActualS(int actualS) {
        this.actualS = actualS;
    }

    public int getAvgS() {
        return avgS;
    }

    public void setAvgS(int avgS) {
        this.avgS = avgS;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getUnitP() {
        return unitP;
    }

    public void setUnitP(double unitP) {
        this.unitP = unitP;
    }

    public int getSalesRank() {
        return salesRank;
    }

    public void setSalesRank(int salesRank) {
        this.salesRank = salesRank;
    }

    public ProdPerformance(int itemID, String itemName, int targetS, int actualS, int avgS, double profitMargin, double unitP, double costP, int salesRank) {
        this.itemID = itemID;
        ItemName = itemName;
        this.targetS = targetS;
        this.actualS = actualS;
        this.avgS = avgS;
        this.profitMargin = profitMargin;
        this.unitP = unitP;
        this.costP = costP;
        this.salesRank = salesRank;
    }
}
