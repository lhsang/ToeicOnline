package com.lhsang.core.utils;

import com.lhsang.core.dto.RoleDTO;
import com.lhsang.core.persistence.entity.RoleEntity;

public class RoleBeanUtil {
    public static RoleDTO entity2DTO(RoleEntity roleEntity){
        RoleDTO roleDTO =new RoleDTO();
        roleDTO.setName(roleEntity.getName());
        roleDTO.setRoleId(roleEntity.getRoleId());
        return roleDTO;
    }
    public static RoleEntity dto2Entity(RoleDTO roleDTO){
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setName(roleDTO.getName());
        roleEntity.setRoleId(roleDTO.getRoleId());
        return roleEntity;
    }
}
