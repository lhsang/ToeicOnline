package com.lhsang.model;

import com.lhsang.core.dto.UserDTO;
import com.lhsang.core.web.model.AbstractModel;

public class UserModel extends AbstractModel<UserDTO> {
    public UserModel(){
        this.pojo=new UserDTO();

    }
}
