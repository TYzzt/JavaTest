package c37;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/10/25
 * \* Time: 15:56
 * \* Description:
 * \
 */
public class ColorsBeanInfo extends SimpleBeanInfo {
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor rectangular = new PropertyDescriptor("rectangular", Colors.class);
            PropertyDescriptor pd[] = {rectangular};
            return pd;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
