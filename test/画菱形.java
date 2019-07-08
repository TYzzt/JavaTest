/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/8
 * \* Time: 9:00
 * \* Description:
 * \
 */
public class 画菱形 {

    public static void main(String[] args) {
        hua(5);
        hua(6);
        System.out.println(11 | 1);
        System.out.println((100 | 010));
    }

    static void hua(int n) {
        int z;
        if (n % 2 != 1) {
            n+=1;
        }
        z = (n-1)/2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(z - i)+Math.abs(z-j) <= z) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
