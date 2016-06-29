package c10;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class MyException extends Exception {
    private int detail;

    MyException(int a) {
        detail = a;
    }

    public static void main(String[] args) {
        try {
            ExceptionDemo.compute(1);
            ExceptionDemo.compute(20);
        } catch (MyException e) {
            System.out.println("caugh:" + e);
        }
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }

    static class ExceptionDemo {
        static void compute(int a) throws MyException {
            System.out.println("Called compute(" + a + ")");
            if (a > 10) {
                throw new MyException(a);
            }
            System.out.println("Normal exit");
        }
    }

}
