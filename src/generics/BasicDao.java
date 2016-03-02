package generics;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by ZhaoTao on 2016/3/1.
 */
public class BasicDao<T, ID extends Serializable> {
    private Class<T> persistentClass;
    /**
     *获取持久化对象的类型
     */
    @SuppressWarnings("unchecked")
    public BasicDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(0);
    }

    public static void main(String[] args) {
        BasicDao<String,Integer> b = new BasicDao<>();
    }

}
