package com.g.web;

import com.g.domain.PageBean;
import com.g.service.Customerservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findallServlet",value = "/findall")
public class findallServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String currentpage = request.getParameter("currentpage");
            PageBean pageBean = new PageBean();
            if (currentpage==null) {
                currentpage="1";
            }
            pageBean.setCurrentPage(Integer.parseInt(currentpage));
            Customerservice custumerservice = new Customerservice();
            PageBean pageBeanfin=custumerservice.findall(pageBean);
            request.setAttribute("bean",pageBeanfin);
            request.getRequestDispatcher("findallcustom.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
