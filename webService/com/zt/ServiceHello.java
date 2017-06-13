package com.zt;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/3/9
 * \* Time: 10:23
 * \* Description:
 * public String getValue(String name) {
 * i++;
 * System.out.println("Service used!"+i);
 * return "Hello " + name;
 * }
 * <p>
 * public static void main(String[] args) {
 * Endpoint.publish("http://localhost:9001/Service/ServiceHello" , new ServiceHello());
 * System.out.println("service publish success!");
 * \
 */
@WebService
public class ServiceHello {


}
