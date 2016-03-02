package generics;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ZhaoTao on 2016/3/1.
 */
public class GenericHibernateDao<T, PK extends Serializable>
         implements GenericDao<T, PK> {
    // 实体类类型(由构造方法自动赋值)
    private Class<PK> entityClass;

    // 构造方法，根据实例类自动获取实体类类型
    public GenericHibernateDao() {
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        Class z = this.getClass();
//        Type[] tt =c.getGenericInterfaces();
//        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
//                .getGenericSuperclass()).getActualTypeArguments()[0];

        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<PK>) p[0];
        }
        System.out.println(0);
    }

    @Override
    public T get(PK id) {
        return null;
    }

    @Override
    public T getWithLock(PK id) {
        return null;
    }

    @Override
    public T load(PK id) {
        return null;
    }

    @Override
    public T loadWithLock(PK id) {
        return null;
    }

    @Override
    public List<T> loadAll() {
        return null;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void updateWithLock(T entity) {

    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void saveOrUpdate(T entity) {

    }

    @Override
    public void saveOrUpdateAll(Collection<T> entities) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void deleteWithLock(T entity) {

    }

    @Override
    public void deleteByKey(PK id) {

    }

    @Override
    public void deleteByKeyWithLock(PK id) {

    }

    @Override
    public void deleteAll(Collection<T> entities) {

    }

    @Override
    public int bulkUpdate(String queryString) {
        return 0;
    }

    @Override
    public int bulkUpdate(String queryString, Object[] values) {
        return 0;
    }

    @Override
    public List find(String queryString) {
        return null;
    }

    @Override
    public List find(String queryString, Object[] values) {
        return null;
    }

    @Override
    public List findByNamedParam(String queryString, String[] paramNames, Object[] values) {
        return null;
    }

    @Override
    public List findByNamedQuery(String queryName) {
        return null;
    }

    @Override
    public List findByNamedQuery(String queryName, Object[] values) {
        return null;
    }

    @Override
    public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) {
        return null;
    }

    @Override
    public Iterator iterate(String queryString) {
        return null;
    }

    @Override
    public Iterator iterate(String queryString, Object[] values) {
        return null;
    }

    @Override
    public void closeIterator(Iterator it) {

    }

    @Override
    public List<T> findEqualByEntity(T entity, String[] propertyNames) {
        return null;
    }

    @Override
    public List<T> findLikeByEntity(T entity, String[] propertyNames) {
        return null;
    }

    @Override
    public void initialize(Object proxy) {

    }

    @Override
    public void flush() {

    }

    // -------------------- 基本检索、增加、修改、删除操作 --------------------


}