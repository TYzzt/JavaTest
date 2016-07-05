package c12;

/**
 * Created by ZhaoTao on 2016/7/4.
 */
//有构造函数的枚举类
public enum Apple2 {
    Jonathan(1), GoldenDel(2), RedDel(3), Winesap(4), Cortland(5);

    private int price;

    Apple2(int p) {
        price = p;
    }

    int getPrice() {
        return price;
    }
}
