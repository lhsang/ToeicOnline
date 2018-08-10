package com.lhsang.core.test;

import com.lhsang.core.dao.RoleDao;
import com.lhsang.core.daoimpl.RoleDaoImpl;
import com.lhsang.core.persistence.entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.List;

public class RoleTest {

    @Test
    public void checkFindAll() {
        RoleDao roleDao= new RoleDaoImpl();
        List<RoleEntity> list= roleDao.findAll();
    }
}
