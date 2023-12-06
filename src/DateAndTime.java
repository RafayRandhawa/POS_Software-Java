import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Date;

public class DateAndTime {
    public static String get_Date() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return myDateObj.format(date);
    }
    public static String get_Time(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        return myDateObj.format(time);
    }
    public static long get_CurrentTime(){
       return System.nanoTime();
    }


}
