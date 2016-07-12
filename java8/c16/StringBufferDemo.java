package c16;

/**
 * Created by ZhaoTao on 2016/7/8.
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("aaaaa");
        sb.setLength(10);
        sb.setLength(1);
        System.out.println(sb.capacity());
        System.out.println(sb.toString());

        System.out.println(Runtime.getRuntime());
    }
}
