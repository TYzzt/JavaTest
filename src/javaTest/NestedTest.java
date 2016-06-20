package javaTest;

/**
 * Created by ZhaoTao on 2015/12/14.
 */
public class NestedTest {
    private int numPrivate = 0;
    public int numPublic = 0;

    public static void main(String[] args) {
        NestedTest nestedTest = new NestedTest();

        StaticNestedClass.main(args);

        StaticNestedClass staticNestedClass = new StaticNestedClass();
        staticNestedClass.main(args);

        NestedTest.StaticNestedClass sc = new NestedTest.StaticNestedClass();
        NestedTest.InnerClass ic =nestedTest.new InnerClass();

    }

    static class StaticNestedClass {
        public static void main(String[] args) {
            System.out.println("static");
        }
    }
    class InnerClass {
        public  void main(String[] args) {
            System.out.println(numPrivate);
        }
    }

}
