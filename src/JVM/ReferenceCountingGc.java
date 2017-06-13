package JVM;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/1
 * \* Time: 16:38
 * \* Description:
 * \
 */
public class ReferenceCountingGc {
    private static final int _1MB = 1024 * 1024;
    public Object instance = null;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();

        objA.instance = objB;
        objB.instance = objA;

        //假设发生GC
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }

}
