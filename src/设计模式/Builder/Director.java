package 设计模式.Builder;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 9:18
 * \* Description:
 * \
 */
public class Director {

    Builder builder;

    //由具体的生产者来生产产品
    public Director(Builder builder) {
        this.builder = builder;
    }

    public static void main(String[] args) {
        //只需要关心具体建造者,无需关心产品内部构建流程。
        //如果需要其他的复杂产品对象，只需要选择其他的建造者.
        Builder builder = new ConcreteBuilder();
        //把建造者注入指导者
        Director director = new Director(builder);
        //指导者负责流程把控
        director.buildProduct();
        // 建造者返回一个组合好的复杂产品对象
        Product product = builder.buildProduct();
    }

    //生产流程
    public void buildProduct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }

}
