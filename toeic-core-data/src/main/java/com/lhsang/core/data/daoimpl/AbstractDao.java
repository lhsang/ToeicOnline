package com.lhsang.core.data.daoimpl;

import com.lhsang.core.common.constant.CoreConstant;
import com.lhsang.core.common.utils.HibernateUtil;
import com.lhsang.core.data.dao.GenericDao;
import org.hibernate.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private Class<T> persistenceClass;

    public AbstractDao(){
        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }
/*    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }*/
    public List<T> findAll() {
        List<T> list=new ArrayList<T>();
        Transaction transaction=null;
        Session session=HibernateUtil.getSessionFactory().openSession();

        try {
            transaction=session.beginTransaction();

            StringBuilder sql=new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query=session.createQuery(sql.toString());
            list=query.list();

            transaction.commit();

        }catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        T result =null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            Object object  = session.merge(entity);
            result= (T) object;
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }

    public void save(T entity) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        try {
            session.persist(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

    }

    public T findById(ID id) {
        T result =null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        try {
                result = session.get(persistenceClass,id);
                if(result == null){
                    throw new ObjectNotFoundException("Not found "+id,null);
                }
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result ;
    }

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {

        List<T> list= new ArrayList<T>();
        Object totalItems =0;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        try{
            StringBuilder sql1=new StringBuilder("from ");
            sql1.append(getPersistenceClassName());
            if(property!=null && value!=null){
                sql1.append(" where ").append(property).append("=:value");
            }
            if(sortDirection!=null&& sortExpression!=null){
                sql1.append(" order by ").append(sortExpression).append(" " + (sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query query1 = session.createQuery(sql1.toString());
            if(value!=null){
                query1.setParameter("value",value);
            }
            list=query1.list();

            StringBuilder sql2=new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName());

            if(value!=null && property!=null){
                sql2.append(" where ").append(property).append(" =:value");
            }

            Query query2=session.createQuery(sql2.toString());
            if(value!=null) {
                query2.setParameter("value", value);
            }
            totalItems=query2.list().get(0);

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return new Object[]{totalItems,list};
    }

    public Integer delete(List<ID> ids) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Integer count=0;
        try {
            for(ID item:ids){
                T t = (T) session.get(persistenceClass,item);
                session.delete(t);
                count++;
            }
           transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return count;
    }
}
