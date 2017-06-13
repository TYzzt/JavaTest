package ACM;

import java.util.Scanner;

public class ID1005 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int num = scan.nextInt();
        for(int i = 1;i<=num;i++){
            float x = scan.nextFloat();
            float y = scan.nextFloat();
            double r2 = x*x+y*y;
            int year = 1;
            int mj = 0;
            double mjAC = r2 * Math.PI;
            while(true){
                mj+=100;
                if(mj>mjAC) {System.out.println("Property "+i+": This property will begin eroding in year "+year+".");
                    break;}else year++;
            }
        }
        System.out.println("END OF OUTPUT.");
    }
}


//    public static void main(String[] args) {
//        int num = scan.nextInt();
//        for(int i = 1;i<=num;i++){
//            float x = Float.valueOf(scan.nextFloat());
//            float y = Float.valueOf(scan.nextFloat());
//            double r2 = x*x+y*y;
//            int year = 1;
//            int mj = 0;
//            while(true){
//                mj+=100;
//                double actualR2 =mj/Math.PI;
//                if(actualR2>r2) {System.out.println("Property "+i+": This property will begin eroding in year "+year+".");
//                    break;}else year++;
//            }
//        }
//        System.out.println("END OF OUTPUT.");
//    }



//    public static void main(String[] args) {
//        int num = scan.nextInt();
//        for(int i = 1;i<=num;i++){
//            float x = Float.valueOf(scan.nextFloat());
//            float y = Float.valueOf(scan.nextFloat());
//            double r2 = x*x+y*y;
//            System.out.println("Property "+i+": This property will begin eroding in year "+((int)(r2*Math.PI/100+1))+".");
//        }
//        System.out.println("END OF OUTPUT.");
//    }
