package com.lhsang.core.dao;

import com.lhsang.core.data.dao.GenericDao;
import com.lhsang.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    UserEntity isUserExist(String userName, String password);
    UserEntity findRoleByUser(String userName,String password);
}
