package ACM;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;
public class ID1001 {
    static Scanner cin = new Scanner(System.in);
    static PrintWriter cout = new PrintWriter(System.out, true);
    public static void main(String[] args) {
        while (cin.hasNext()){
            BigDecimal a = cin.nextBigDecimal();
            int b = cin.nextInt();
            String ans = a.pow(b).stripTrailingZeros().toPlainString();
            if(ans.charAt(0)=='0'){
                cout.println(ans.substring(1));
            }else {
                cout.println(ans);
            }
        }
    }
}
