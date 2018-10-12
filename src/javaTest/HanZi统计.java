package javaTest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/3/8
 * \* Time: 10:21
 * \* Description:
 * \
 */
public class HanZi统计 {

    public static void main(String[] args) {
        String str = "蛤蛤蛤的了个么了去顶顶顶";

        int[] test = new int[65536];
        for (char c : str.toCharArray()) {
            System.out.println((int) c);
            test[c] += 1;
        }
        for (int i = 0; i < test.length; i++) {
            if (test[i] != 0) {
                System.out.println((char)i+"|"+test[i]);
            }
        }
    }
}
