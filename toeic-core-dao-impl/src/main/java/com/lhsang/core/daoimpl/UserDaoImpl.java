package com.lhsang.core.daoimpl;

import com.lhsang.core.common.utils.HibernateUtil;
import com.lhsang.core.dao.UserDao;
import com.lhsang.core.data.daoimpl.AbstractDao;
import com.lhsang.core.persistence.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {
    public UserEntity isUserExist(String userName, String password) {
        UserEntity userEntity =new UserEntity();
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        try{
            StringBuilder sql=new StringBuilder(" FROM UserEntity WHERE name=:name AND password=:password ");
            Query query=session.createQuery(sql.toString());
            query.setParameter("name",userName);
            query.setParameter("password",password);
            userEntity= (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
                session.close();
        }
        return userEntity;
    }

    public UserEntity findRoleByUser(String userName, String password) {

        UserEntity userEntity =new UserEntity();
        return userEntity;
    }
}
