package c19.Date;

import java.util.GregorianCalendar;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class GregorianCalendarDemo {
    public static void main(String[] args) {
        String months[] = {
                "Jan", "Feb", "Mar", "Apr", "5", "6", "7", "8", "9", "10"
        };
        int year = 2016;
        GregorianCalendar gregorian = new GregorianCalendar();
        System.out.println(gregorian.isLeapYear(year));


    }
}
