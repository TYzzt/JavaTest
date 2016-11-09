/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/9
 * \* Time: 11:39
 * \* Description:
 * \
 */
public class TestXX {
    public static void foo() {
        if ((Integer) null > 1) {
        }
    }

    public static void bar() {

        if ((Integer) null > 1) {
            System.out.println("abc");
        }
    }

    public static void main(String[] args) {
        try {
            foo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
