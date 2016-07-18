package c19.Date;

import java.util.Calendar;

/**
 * Created by ZhaoTao on 2016/7/15.
 */
public class CalendarDemo {

    public static void main(String[] args) {
        String months[] = {
                "Jan", "Feb", "Mar", "Apr", "5", "6", "7", "8", "9", "10"
        };

        Calendar calendar = Calendar.getInstance();

        System.out.println("Date:" + months[calendar.get(Calendar.MONTH)]);
        System.out.println(" " + calendar.get(Calendar.DATE));
        System.out.println(" " + calendar.get(Calendar.YEAR));

        System.out.println("Time:");
        System.out.println(calendar.get(Calendar.HOUR));

        calendar.set(Calendar.HOUR, 10);


    }


}
    