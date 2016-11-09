package c22;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/20
 * \* Time: 14:35
 * \* Description:
 * \
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);

        InetAddress SW[] = InetAddress.getAllByName("www.dtuchina.yuwey.com");
        for (int i = 0; i < SW.length; i++) {
            System.out.println(SW[i]);
        }

    }
}
