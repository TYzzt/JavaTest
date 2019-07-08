package leetcode.t7;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/5/5
 * \* Time: 10:35
 * \* Description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * \
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-325610));
    }

    public int reverse(int x) {
        String str = String.valueOf(x);

        char[] chars = str.toCharArray();

        int n = chars.length - 1;
        boolean hasNegative = false; //是否包含负数
        if (chars[0] == '-') {
            hasNegative = true;
        }

        //翻转
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = chars[j];
            char ck = chars[k];
            chars[j] = ck;
            chars[k] = cj;
        }
        int a = 0;
        int b = chars.length;
        if (hasNegative) {
            b -= 1;
        }
        for (int i = 0; i <= n; i++) {
            if (chars[i] != 0) {
                a = i;
                break;
            }
        }
        int num = 0;
        try {
            num = Integer.valueOf(String.valueOf(chars, a, b));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
        if (hasNegative) {
            num = -num;
        }
        return num;
    }


}
