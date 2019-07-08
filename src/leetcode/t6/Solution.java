package leetcode.t6;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/4/30
 * \* Time: 10:40
 * \* Description:将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * \
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert(
                "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."
                , 3));
    }

    public String convert(String s, int numRows) {
        int size = s.length();
        if (size <= numRows || numRows == 1) {
            return s;
        }

        int maxRow = size - numRows; //有可能的最大行
        int[][] pos = new int[maxRow][numRows];

        int row = 0;
        int column = 0;
        int now = 1;
        for (int i = 0; i < size; i++) {
            pos[row][column] = i;

            column += now;
            if (now == 1 && column == numRows) {
                now = -1;
                column -= 2;
            } else if (now == -1 && column < 0) {
                now = 1;
                column = 1;
            }
            if (now == -1) {
                row += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 0; i < numRows; i++) {
            for (int[] po : pos) {
                if (0 != po[i]) {
                    sb.append(s.charAt(po[i]));
                }
            }
        }
        return sb.toString();
    }

}
