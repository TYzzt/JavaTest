package c12.zhujie;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by ZhaoTao on 2016/7/5.
 */
@Retention(RetentionPolicy.RUNTIME)
        //保留策略，程序执行期间通过JVM可以获取
@interface MyAnno {
    String str();

    int val() default 9000; //默认这9000
}

class Meta {

    @MyAnno(str = "example", val = 100)
    public static void myMeth() {
        Meta ob = new Meta();

        try {
            Class<?> c = ob.getClass();

            Method m = c.getMethod("myMeth");
            /*Method m = c.getMethod("myMeth",String.class,int.class);*/ //如果有参数


            MyAnno anno = m.getAnnotation(MyAnno.class);

            System.out.println(anno.str() + "|||" + anno.val());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        myMeth();
    }

}
