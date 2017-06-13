package 设计模式.AbstractFactory;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/12
 * \* Time: 10:25
 * \* Description:
 * \
 */
public class InterCPUFactory implements Provider {
    @Override
    public CPUFactory createCPUFactory() {
        return new IntelCPU();
    }
}
