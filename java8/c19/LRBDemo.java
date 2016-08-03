package c19;

import java.util.ResourceBundle;

/**
 * Created by ZhaoTao on 2016/8/2.
 */
public class LRBDemo {
    public static void main(String[] args) {
        ResourceBundle rd = ResourceBundle.getBundle("SampleRB");

        System.out.println(rd.getString("title"));

    }
}
