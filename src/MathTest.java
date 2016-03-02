/**
 * Created by ZhaoTao on 2016/2/24.
 */
public class MathTest {
    public static void main(String[] args) {
        System.out.println(new MathTest().a(125)-4);
    }
    double a (int count){
        double x;
        //x-4+x+4+x/4+x*4=count;
        //6.25 * x=count;
        x=count/6.25;
        return x;
    }
}
