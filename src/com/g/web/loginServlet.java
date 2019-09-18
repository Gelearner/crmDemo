package com.g.web;

import com.g.domain.User;
import com.g.domain.UserImpl;
import com.g.service.Userservice;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;


@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //防止乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            //将表单数据封装
            Map<String, String[]> map = request.getParameterMap();
            UserImpl user = new UserImpl();
            BeanUtils.populate(user, map);

            User user1 = Userservice.islogin(user);
            if (user1 == null) {
                //用户不存在
                request.setAttribute("msg", "用户或密码输入错误！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            } else {
                //用户存在,登录成功
                //将用户名传给前台页面
                String rem = request.getParameter("rem");
                if (rem!=null) {
                    Cookie ucookie = new Cookie("ucookie", user.getUsername());
                    Cookie pcookie = new Cookie("pcookie", user.getPassword());
                    ucookie.setMaxAge(60 * 60 * 24 * Integer.parseInt(rem));
                    pcookie.setMaxAge(60 * 60 * 24 * Integer.parseInt(rem));
                    response.addCookie(ucookie);
                    response.addCookie(pcookie);
                }
                HttpSession session = request.getSession();
                session.setAttribute("user", user1);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
