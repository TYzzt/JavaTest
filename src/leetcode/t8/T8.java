package leetcode.t8;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/7/18
 * \* Time: 14:13
 * \* Description:请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * \
 */
public class T8 {

/*
    public int myAtoi(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        int result = 0;
        boolean fs = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0 && (c=='-'||c=='+')) {
                if (c == '-') {
                    fs = true;
                }
            }else if(Character.isDigit(c)){
                if (!fs && (result > Integer.MAX_VALUE / 10 || (result ==Integer.MAX_VALUE/10 && ((int)c - 48)>7)) ) {
                    return Integer.MAX_VALUE;
                }
                if (fs && (result > Integer.MAX_VALUE / 10 || (result ==Integer.MAX_VALUE/10 && ((int)c - 48)>8)) ) {
                    return Integer.MIN_VALUE;
                }
                result = result*10+(c - '0');
            }else{
                break;
            }
        }
        return fs?-result:result;
    }
*/

    boolean sign; // false :正数
    boolean signFlag; // true 出现过正负号

    boolean start;
    boolean startFlag;  // 直接以数字开头
    int val;

    public static void main(String[] args) {
        System.out.println(new T8().myAtoi("2147483648"));
    }

    //递归解法 3ms 99.26% 38.1M 70.77%
    public int myAtoi(String str) {


        // 整串都是数字
        if (str == null || str.length() == 0) return sign ? -val : val;

        //
        char ch = str.charAt(0);

        // 是个空格符号，判断
        if (ch == ' ' && !start && !signFlag) return myAtoi(str.substring(1));
        else if (ch == '+' && !start && !signFlag) {
            signFlag = true;
            return myAtoi(str.substring(1));
        } else if (ch == '-' && !start && !signFlag) {
            signFlag = true;
            sign = true;
            return myAtoi(str.substring(1));
        } else if (ch >= '0' && ch <= '9' && (start || !startFlag)) {
            start = true;

            double d1 = (double) val;
            double d2 = (double) Integer.MAX_VALUE;

            if (d1 * 10 + (ch - '0') > d2) return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            else {
                val = val * 10 + (ch - '0');
                return myAtoi(str.substring(1));

            }
        } else return sign ? -val : val;

    }

}
