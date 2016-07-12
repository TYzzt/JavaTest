package c8;

/**
 * Created by ZhaoTao on 2016/6/27.
 */
public class A {
    String a;

    A(String a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a1 = (A) o;

        return !(a != null ? !a.equals(a1.a) : a1.a != null);

    }

    @Override
    public int hashCode() {
        return a != null ? a.hashCode() : 0;
    }

    void function() {
        System.out.println("fA");
    }

}
