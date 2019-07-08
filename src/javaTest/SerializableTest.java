package javaTest;


import java.lang.reflect.ParameterizedType;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/23
 * \* Time: 14:31
 * \* Description:
 * \
 */
public interface SerializableTest<T> {

    default Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
