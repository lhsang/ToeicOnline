package com.lhsang.core.utils;

import com.lhsang.core.dto.UserDTO;
import com.lhsang.core.persistence.entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO entity2DTO(UserEntity userEntity){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setName(userEntity.getName());
        userDTO.setFullName(userEntity.getFullName());
        userDTO.setCreateDate(userEntity.getCreateDate());
        userDTO.setRoleDTO(RoleBeanUtil.entity2DTO(userEntity.getRoleEntity()));
        return userDTO;
    }
    public static UserEntity dto2Entity (UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setName(userDTO.getName());
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setCreateDate(userDTO.getCreateDate());
        userEntity.setRoleEntity(RoleBeanUtil.dto2Entity(userDTO.getRoleDTO()));
        return userEntity;
    }
}
