package 设计模式.Builder;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 9:17
 * \* Description:
 * \
 */
public class ConcreteBuilder implements Builder {
    Product product;

    @Override
    public void buildPartA() {

    }

    @Override
    public void buildPartB() {

    }

    @Override
    public void buildPartC() {

    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
