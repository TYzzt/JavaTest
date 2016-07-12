package c17;

/**
 * Created by ZhaoTao on 2016/7/8.
 */
public class RuntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("totalMemory:" + runtime.totalMemory());
        System.out.println("free:" + runtime.freeMemory());
        Integer i[] = new Integer[1000];
        System.out.println("free:" + runtime.freeMemory());


    }
}
