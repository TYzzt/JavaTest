package c19.Formatter;

import java.util.Formatter;

/**
 * Created by ZhaoTao on 2016/8/1.
 */
public class FormatDemo {


    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        for (double i = 1.23; i < 1.0e+6; i *= 100) {
            fmt.format("%f %e", i, i);
            System.out.println(fmt);

        }
        fmt.close();

        //八进制与十六进制
        fmt = new Formatter();
        fmt.format("Hex: %x,Octal:%o", 196, 196);

        System.out.println(fmt);
        fmt.close();


    }


}
