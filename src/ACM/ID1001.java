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
            int b = cin.nextInt(); //stripTrailingZeros() 返回一个BigDecimal，它在数值上等于这一个，但表示形式移除所有尾部零。
            String ans = a.pow(b).stripTrailingZeros().toPlainString(); //toPlainString()  返回不带指数字段的此 BigDecimal 的字符串表示形式
            if(ans.charAt(0)=='0'){
                cout.println(ans.substring(1));
            }else {
                cout.println(ans);
            }
        }
    }
}
