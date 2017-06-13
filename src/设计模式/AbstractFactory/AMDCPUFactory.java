package 设计模式.AbstractFactory;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/12
 * \* Time: 10:26
 * \* Description:
 * \
 */
public class AMDCPUFactory implements Provider {
    @Override
    public CPUFactory createCPUFactory() {
        return new AMDCPU();
    }
}
