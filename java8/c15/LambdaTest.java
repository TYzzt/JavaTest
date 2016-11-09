package c15;

import c15.c15_7.StringFunc;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/13
 * \* Time: 10:29
 * \* Description:
 * \
 */
public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        String up = lambdaTest.run(String::toUpperCase);
        String up1 = lambdaTest.run(StringOpts::toUp); //静态方法引用
        StringOpts stringOpts = new StringOpts();
        String up2 = lambdaTest.run(stringOpts::toUp2); //实例方法引用

        System.out.println(up);//输出ABCDEFG

        String aaa = "aaa";
        StringFunc stringFunc = s -> {
            //aaa = "111"; 错误，将导致编译不通过
            s += aaa;
            return s.toUpperCase();
        };
        System.out.println(stringFunc.func("abcdef"));//输出ABCDEF

    }

    public String run(StringFunc f) {
        return f.func("abcdefg");
    }
}
