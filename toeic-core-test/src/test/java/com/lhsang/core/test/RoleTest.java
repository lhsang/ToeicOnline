package com.lhsang.core.test;

import com.lhsang.core.dao.RoleDao;
import com.lhsang.core.daoimpl.RoleDaoImpl;
import com.lhsang.core.persistence.entity.RoleEntity;
import com.lhsang.core.persistence.entity.UserEntity;
import org.testng.annotations.Test;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    @Test
    public void checkFindAll(){
        RoleDao roleDao=new RoleDaoImpl();
        List<RoleEntity> list=roleDao.findAll();
    }

    @Test
    public void checkUpdateRole(){
        RoleDao roleDao=new RoleDaoImpl();

        RoleEntity roleEntity= new RoleEntity();
        roleEntity.setRoleId(2);
        roleEntity.setName("user");

        roleDao.update(roleEntity);
    }

    @Test
    public void checkSaveRole(){
        RoleDao roleDao=new RoleDaoImpl();

        RoleEntity roleEntity= new RoleEntity();
        roleEntity.setRoleId(1);
        roleEntity.setName("admin");

        roleDao.save(roleEntity);
    }

    @Test
    public void checkFindById(){
        RoleDao roleDao=new RoleDaoImpl();

        RoleEntity roleEntity =new RoleEntity();
        roleEntity=roleDao.findById(3);
    }

    @Test
    public void checkFindByProperty(){
        RoleDao roleDao=new RoleDaoImpl();

        String property=null;
        Object value=null;
        String sortExpression=null;
        String sortDirection=null;
        Object[] objects =roleDao.findByProperty(property,value,sortExpression,sortDirection);
    }

    @Test
    public  void checkDelete(){
        RoleDao roleDao=new RoleDaoImpl();

        List<Integer> list=new ArrayList<Integer>();
        list.add(3);
        list.add(1);

        roleDao.delete(list);
    }
}
