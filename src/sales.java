import java.util.Scanner;

public class sales {

    public int itemID=0;
    public String ItemName="";
    public int targetS = 0;
    public int actualS = 0;
    public int avgS = 0;
    public double profitMargin = 0.0;
    public double unitP = 0.0;
    public double costP = 0.0;
    public int salesRank = 0;
    public sales(int itemID, String ItemName, int targetS, int actualS, int avgS, double profitMargin, double unitP, double costP, int salesRank){
        this.itemID = itemID;
        this.ItemName = ItemName;
        this.targetS = targetS;
        this.actualS = actualS;
        this.avgS = avgS;
        this.profitMargin = profitMargin;
        this.unitP = unitP;
        this.costP = costP;
        this.salesRank = salesRank;
    }
}
