public class Cashier {
    private int CashierCode;
    private String CashierName;
    private int TotalHoursWorked;
    private String JoinDate;
    private String ShiftStart;
    private String EndShift;
    private String EmploymentStatus;

    public Cashier(){}
    public Cashier(int code,String name,int hrsWorked,String JD,String SS,String ES,String Status){
        this.CashierCode=code;
        this.CashierName=name;
        this.EndShift=ES;
        this.JoinDate=JD;
        this.TotalHoursWorked=hrsWorked;
        this.ShiftStart=SS;
        this.EmploymentStatus=Status;
    }

    public String getEmploymentStatus() {
        return EmploymentStatus;
    }

    public int getCashierCode() {
        return CashierCode;
    }

    public String getCashierName() {
        return CashierName;
    }

    public int getTotalHoursWorked() {
        return TotalHoursWorked;
    }

    public String getEndShift() {
        return EndShift;
    }

    public String getJoinDate() {
        return JoinDate;
    }

    public String getShiftStart() {
        return ShiftStart;
    }
}
