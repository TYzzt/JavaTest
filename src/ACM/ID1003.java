package ACM;

import java.io.PrintWriter;
import java.util.Scanner;

public class ID1003 {
    static Scanner cin = new Scanner(System.in);
    static PrintWriter cout = new PrintWriter(System.out, true);
        public static void main(String[] args) {
        float f;
        double sum;
        int num;
        while (cin.hasNext() && (f=cin.nextFloat())!=0.00){
            sum = 0;
            num = 1;
            while(sum<f){
                num++;
                sum = sum+1.0/num;
            }
            cout.println(String.format("%d card(s)",num-1));
        }
    }
}
//    public static void main(String[] args) {
//        float f;
//        while (cin.hasNext() && (f=cin.nextFloat())!=0.00){
//            cout.println(summ(f,0,1)-2+" card(s)");
//        }
//    }
//
//    public static int summ(float f,double num,int n){
//        n++;
//        if (num<f) return summ(f,num + 1.0/n,n);
//        else return n;
//    }
