package com.lhsang.core.data.daoimpl;

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
    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
    public List<T> findAll() {
        List<T> list=new ArrayList<T>();
        Transaction transaction=null;
        transaction=getSession().beginTransaction();

        //HQL
        try {
            StringBuilder sql=new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query=this.getSession().createQuery(sql.toString());
            list=query.list();
            transaction.commit();

        }catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }
}
