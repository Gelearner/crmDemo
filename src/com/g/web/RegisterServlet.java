package com.g.web;
import com.g.domain.UserImpl;
import com.g.service.Userservice;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //防止乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/thml;charset=uft-8");

            //获取用户对象
            UserImpl user = new UserImpl();
            //使用开源的封装Javabean的工具将前端页面表单中的数据封装到javabean中
            Map<String, String[]> map = request.getParameterMap();
            BeanUtils.populate(user,map);

            //获取验证码servlet存放在域中的数据
            HttpSession session = request.getSession();
            String servercode = (String) session.getAttribute("servercode");
            String clientcheckcode = request.getParameter("clientcheckcode");

            //从域中清除验证码
            session.removeAttribute("servercode");

            if (servercode.equalsIgnoreCase(clientcheckcode)){
                //验证码正确
                boolean b = Userservice.adduser(user);
                if (b){
                    //判断是否添加成功，跳转到登录页面
                    request.setAttribute("msg","注册成功，请登陆！");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else {
                    //添加失败,跳转回本页面
                    request.setAttribute("msg","验证码输入错误");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }
            }else {
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
