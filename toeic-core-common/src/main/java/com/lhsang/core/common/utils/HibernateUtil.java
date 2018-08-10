package com.lhsang.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY=buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            //create sessionfactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e){
            System.out.print("Init sessionfactory  fail");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
       return SESSION_FACTORY;
    }
}
