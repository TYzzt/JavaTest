package c37;

import java.beans.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/10/25
 * \* Time: 15:58
 * \* Description:
 * \
 */
public class IntrospectorDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class<?> c = Class.forName("Colors");
            BeanInfo beanInfo = Introspector.getBeanInfo(c);

            System.out.println("Properties:");
            PropertyDescriptor propertyDescriptor[] = beanInfo.getPropertyDescriptors();

            for (int i = 0; i < propertyDescriptor.length; i++) {
                System.out.println("\t" + propertyDescriptor[i].getName());
            }

            System.out.println("Events:");
            EventSetDescriptor eventSetDescriptor[] = beanInfo.getEventSetDescriptors();

            for (int i = 0; i < eventSetDescriptor.length; i++) {
                System.out.println("\t" + eventSetDescriptor[i].getName());
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
