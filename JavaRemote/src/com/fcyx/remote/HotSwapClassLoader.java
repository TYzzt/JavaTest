package com.fcyx.remote;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/27
 * \* Time: 14:35
 * \* Description: 为了多次载入执行类而加入的加载器；把defineClass方法开放出来,只有外部显式调用的时候才会用到的loadByte方法
 * \
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
