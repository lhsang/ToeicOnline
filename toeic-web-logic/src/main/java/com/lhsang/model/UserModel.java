package com.lhsang.model;

import com.lhsang.core.dto.UserDTO;
import com.lhsang.core.web.model.AbstractModel;

import java.io.PrintWriter;

public class UserModel extends AbstractModel<UserDTO> {
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserModel(){

        this.pojo=new UserDTO();

    }
}
