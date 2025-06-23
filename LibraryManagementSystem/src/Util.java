import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Util {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static Date getCurrentDate(){
        return new Date();
    }

    public static Date getDueDate(int daysFromNow){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysFromNow);
        return calendar.getTime();
    }

    public static String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date);
    }
}
