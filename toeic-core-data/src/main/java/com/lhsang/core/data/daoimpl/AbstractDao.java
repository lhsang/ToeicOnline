package com.lhsang.core.data.daoimpl;

import com.lhsang.core.common.utils.HibernateUtil;
import com.lhsang.core.data.dao.GenericDao;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private Class<T> persistenceClass;

    public AbstractDao(){
        this.persistenceClass= (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
    public List<T> findAll() {
        return null;
    }
}
