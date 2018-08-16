package com.lhsang.core;

import com.lhsang.core.dao.UserDao;
import com.lhsang.core.daoimpl.UserDaoImpl;
import com.lhsang.core.persistence.entity.UserEntity;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginTest {
    private final Logger logger=Logger.getLogger(this.getClass());
    @Test
    public void CheckIsUserExist(){
        UserDao userDao=new UserDaoImpl();
        String name="lhsang";
        String password="1234";
        UserEntity userEntity=userDao.isUserExist(name,password);
        if(userEntity==null){
                logger.error("nullllllllllllllll");
        }else {
                logger.error("success");
        }
    }
}
