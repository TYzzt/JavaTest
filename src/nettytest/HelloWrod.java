package nettytest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/21
 * \* Time: 9:55
 * \* Description:
 * \
 */
public class HelloWrod {

    public static void main(String[] args) {

        for (String stringPropertyName : System.getProperties().stringPropertyNames()) {
            System.out.println(String.format("%s=%s", stringPropertyName, System.getProperty(stringPropertyName)));
        }

    }

}
