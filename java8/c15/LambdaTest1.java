package c15;

import c15.c15_7.StringFunc;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/13
 * \* Time: 15:49
 * \* Description:
 * \
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        StringFunc stringFunc = s -> s.toUpperCase();
        System.out.println(stringFunc.func("abcdef"));//输出ABCDEF
    }
}
