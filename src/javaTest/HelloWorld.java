package javaTest;

import java.util.Arrays;

public class HelloWorld {

    char[] value = {'a', 'b', 'c', 'd'};

    public static void main(String[] args) {
        //launch(args);
        new HelloWorld().testRev();

    }


    public void sayHello() {
        SerializableTest<ACMEBicycle> test = new SerializableBean<>();
        System.out.println(test.getClazz());
    }


    public void testRev() {
        System.out.println(Arrays.toString(value));
        int count = value.length;
        System.out.println(count);
        int n = count - 1;
        System.out.println((n - 1) >> 1);
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            System.out.println(j + "," + k);
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
        }
        System.out.println(Arrays.toString(value));
    }


}