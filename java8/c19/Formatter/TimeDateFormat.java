package c19.Formatter;

import java.util.Calendar;
import java.util.Formatter;

/**
 * Created by ZhaoTao on 2016/8/1.
 */
public class TimeDateFormat {

    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        Calendar cal = Calendar.getInstance();

        fmt.format("%tr", cal);
        System.out.println(fmt);
        fmt.close();

        fmt = new Formatter();
        fmt.format("%tc", cal);
        System.out.println(fmt);
        fmt.close();


    }

}
