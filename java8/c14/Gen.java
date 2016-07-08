package c14;

/**
 * Created by ZhaoTao on 2016/7/6.
 */
public class Gen<T> {

    T ob;

    Gen(T o) {
        ob = o;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    void showType() {
        System.out.println("T type:" + ob.getClass().getName());
    }

}
