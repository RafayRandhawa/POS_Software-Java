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

    public static double calcAcqBudget(int actualS, double unitP){
        double budgetAcq = actualS * unitP;
        return budgetAcq;
    }
    public static double calcExpBudget(int targetS, double unitP){
        double expBudget = targetS * unitP;
        return expBudget;
    }
    public static double budgetDiff(double expBudget, double budgetAcq){
        double budgetDiff;
        if(expBudget > budgetAcq){
            budgetDiff = expBudget - budgetAcq;
        }
        else if (budgetAcq > expBudget){
            budgetDiff = budgetAcq - expBudget;
        }
        else{
            budgetDiff = budgetAcq;
        }
        return budgetDiff;
    }
    public static double getActualProfit(double profitM, int actualS){
        double profit = 0;
        profit = profitM * actualS;
        return profit;
    }
    public static double getExpProfit(double profitM, int targetS){
        double profit = 0;
        profit = profitM * targetS;
        return profit;
    }

    public static void dispProdPerformane(){
        Database.dispProdPerformance();
    }

    public static void prodPerformanceInsight(){
        System.out.println("Enter the product ID: ");
        int ID = new Scanner(System.in).nextInt();

        sales sale = Database.calcSalesAnalytics(ID);
        int diff = sale.targetS - sale.actualS;

        System.out.println("\n*** Monthly Product Performance Insight ***");
        System.out.println();

        System.out.println("Item ID: " + sale.itemID);
        System.out.println("Item name: " + sale.ItemName);
        System.out.println();

        System.out.println("Target Sale Quantity: " + sale.targetS);
        System.out.println("Actual Sale Quantity: " + sale.actualS);
        System.out.println("Avg Sale Quantity: " + sale.avgS);
        System.out.println();

        System.out.println("Selling Price: " + sale.unitP);
        System.out.println("Cost Price: " + sale.costP);
        System.out.println();

        System.out.println("Expected product sale amount: " + calcExpBudget(sale.targetS, sale.unitP));
        System.out.println("Actual product sale amount: " + calcAcqBudget(sale.actualS, sale.unitP));
        System.out.println("Variance from expected amount: " + budgetDiff(calcExpBudget(sale.targetS, sale.unitP), calcAcqBudget(sale.actualS, sale.unitP)));
        System.out.println("Sales rank: " + sale.salesRank);
        System.out.println();

        System.out.println("Profit Margin: " + sale.profitMargin);
        System.out.println("Expected profit: " + getExpProfit(sale.profitMargin, sale.targetS));
        System.out.println("Actual profit: " + getActualProfit(sale.profitMargin, sale.actualS));

        if(diff>0){
            System.out.println("\nThe product did not perform up to the mark");
        }
        else if(diff<0){
            System.out.println("\nThe product performance was up to the mark");
        }
        else{
            System.out.println("\nThe product performance was sufficient");
        }

    }

    public static void inventoryPerformance(){
        Database.inventoryPerformance();
    }
}
