package 数学复习;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/8
 * \* Time: 8:51
 * \* Description:
 * \
 */
public class 级数 {

    public static void main(String[] args) {
        System.out.println(jishu(2));
        System.out.println(jishu(1));
    }

    //2[n+1]-1
    private static int  jishu(int n) {
        int z = 1;
        for (int i = 0; i < n + 1; i++) {
            z*=2;
        }
        return z-1;
    }

}
