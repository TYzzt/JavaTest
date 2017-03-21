package ACM;

import java.io.PrintWriter;
import java.util.Scanner;

public class ID1006 {
    private static Scanner cin = new Scanner(System.in);
    private static PrintWriter cout = new PrintWriter(System.out, true);

    public static void main(String[] args) {
        int p;
        int e;
        int i;
        int d;
        int num = 0;
        int day;
        while (cin.hasNext()) {
            p = cin.nextInt();
            e = cin.nextInt();
            i = cin.nextInt();
            d = cin.nextInt();

            if (p == e && e == i && i == d && d == -1) {
                return;
            } else {
                num++;
                day = 0;
            }
            int temp = d;
            for (; d < 21253 + temp; d++) {
                day++;
                if (d % (23 - p) == 0 && (28 - d) % e == 0 && (33 - d) % i == 0) {
                    cout.println(String.format("Case %d: the next triple peak occurs in %d days.", num, day));
                }
            }

        }
    }
}
