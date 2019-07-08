package javaTest;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/23
 * \* Time: 14:57
 * \* Description:
 * \
 */
public class SerializableBean<T> extends TypeReference<T> implements SerializableTest<T> {


}
