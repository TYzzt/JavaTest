package com.zt.fastRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/7/18
 * \* Time: 16:07
 * \* Description:
 * \
 */
@WebServlet(name = "RunnerServlet", urlPatterns = "/fastRunner/run")
public class RunnerServlet extends HttpServlet {
    /**
     * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
     */
    private static int bytesToInt2(byte[] src, int offset) {
        int value;
        value = (int) (((src[offset] & 0xFF) << 24)
                | ((src[offset + 1] & 0xFF) << 16)
                | ((src[offset + 2] & 0xFF) << 8)
                | (src[offset + 3] & 0xFF));
        return value;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream is = request.getInputStream();
        byte[] b = new byte[1024 * 1024];

        int nRead = 1;
        int nTotalRead = 0;
        while (nRead > 0) {
            nRead = is.read(b, nTotalRead, b.length - nTotalRead);
            if (nRead > 0) {
                nTotalRead = nTotalRead + nRead;
            }
        }
        byte[] b1 = new byte[4]; //长度信息
        System.arraycopy(b, 0, b1, 0, 4);
        int length = bytesToInt2(b1, 0);
        byte[] b2 = new byte[length];
        System.arraycopy(b, 4, b2, 0, length);

       /* InputStream is = new FileInputStream("D:\\keyset\\testcompiler\\TestRun.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();*/

        PrintWriter out = response.getWriter();
        out.println(JavaClassExecuter.execute(b2));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
