package com.fcyx.remote;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/27
 * \* Time: 15:57
 * \* Description:
 * \
 */
public class HackSystem {
    public static final InputStream in = System.in;
    public static final PrintStream err = out;
    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public static final PrintStream out = new PrintStream(buffer);

    public static void main(String[] args) {
        System.out.println();
    }

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static void setSecurityManager(final SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static void arraycopy(Object src, int srcPos,
                                 Object dest, int destPos,
                                 int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static int identityHashCode(Object x) {
        return System.identityHashCode(x);
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

}
