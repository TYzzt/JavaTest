package c15;

/**
 * Created by ZhaoTao on 2016/7/7.
 */
public class GenericFunctionalInterfaceDemo {

    public static void main(String[] args) {
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i = 0;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("lambda reversed is " + reverse.func("lambda"));

    }


}
