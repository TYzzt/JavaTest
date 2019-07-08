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
            System.out.println(1);
        }
    }

    public static void bar() {

        if ((Integer) null > 1) {
            System.out.println("abc");
        }
    }

    public static void main(String[] args) {

        System.out.println(1 == 1);
        System.out.println(1 == new Integer(1));
        System.out.println(new Integer(1) == new Integer(1));
        System.out.println(new Integer(1).equals(new Integer(1)));


        final char[] DigitOnes = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        };

        for (char digitOne : DigitOnes) {
            System.out.println(digitOne + "_" + String.valueOf((int) digitOne));
        }

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
