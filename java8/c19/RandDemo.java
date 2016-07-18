package c19;

import java.util.Random;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class RandDemo {
    public static void main(String[] args) {
        Random r = new Random();
        double val;
        double sum = 0;

        int bell[] = new int[10];

        for (int i = 0; i < 100; i++) {
            val = r.nextGaussian();
            System.out.println(val);
            sum += val;
            double t = -2;

            for (int x = 0; x < 10; x++, t += 0.5) {
                System.out.println("t" + t);
                if (val < t) {
                    bell[x]++;
                    break;
                }
            }
        }

        System.out.println("Average of values:" + (sum / 100));

        for (int i = 0; i < 10; i++) {
            for (int x = bell[i]; x > 0; x--) {
                System.out.print("x");
            }
            System.out.println();
        }

    }
}
