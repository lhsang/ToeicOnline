package com.lhsang.controller.login;

import com.lhsang.core.dto.UserDTO;
import com.lhsang.core.web.utils.FormUtil;
import com.lhsang.model.UserModel;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger log =Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher rd=request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
        UserModel command = FormUtil.populate(UserModel.class, request);
        UserDTO pojo=command.getPojo();
        log.error(command.getConfirmPassword());
        RequestDispatcher rd=request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request,response);
    }
}
