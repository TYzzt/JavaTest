package c15.c15_7;

/**
 * Created by ZhaoTao on 2016/7/7.
 */
public class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "lambdas add power to java";

        String outStr;

        MethodRefDemo demo = new MethodRefDemo();

        outStr = stringOp(MyStringOps::strReverse, inStr);
        outStr = stringOp(demo::testString, inStr);

        System.out.println(outStr);
    }

    String testString(String str) {
        return str;
    }

}
