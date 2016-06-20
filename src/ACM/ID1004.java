package ACM;

import java.util.Scanner;

public class ID1004 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        double f = 0;
        for(int i=1;i<2049;i=i<<1){
            f+=scan.nextFloat()/12;
        }
        System.out.println(String.format("$%.2f",f));
        System.out.println("$"+(double)(Math.round((f)*100))/100);
    }
}
