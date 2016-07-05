package c12;

/**
 * Created by ZhaoTao on 2016/7/1.
 */
public class TestApple {
    public static void main(String[] args) {
        Apple ap = Apple.Jonathan;

        if (ap == Apple.Cortland) {
            System.out.println("1");
        } else {
            System.out.println(ap);
        }

        switch (ap) {
            case Cortland:
                System.out.println("c");
                break;
            case Jonathan:
                System.out.println("right");
                break;
        }

        System.out.println(ap.values());
        System.out.println(ap.valueOf("Jonathan"));


        System.out.println("---------------apple2");

        System.out.println("J: " + Apple2.Jonathan.getPrice());
        System.out.println("All:");
        for (Apple2 a : Apple2.values()) {
            System.out.println(a + ":" + a.getPrice());
        }


        int a = new Integer("1");

        Integer iob = 1000;
        int i = iob.byteValue();

        System.out.println(i);
    }
}
