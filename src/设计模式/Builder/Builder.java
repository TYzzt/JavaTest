package 设计模式.Builder;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 9:16
 * \* Description:
 * \
 */
public interface Builder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product buildProduct();
}
