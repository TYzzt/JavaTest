package com.zt;

import com.client.ServiceHelloService;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/3/9
 * \* Time: 10:40
 * \* Description:
 * \
 */
public class HelloClientTest {
    public static void main(String[] args) {
        com.client.ServiceHello serviceHello = new ServiceHelloService().getServiceHelloPort();
        String name = serviceHello.getValue("小明");
        System.out.println(name);
    }
}
