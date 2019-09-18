package com.g.web;

import com.g.service.Customerservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "delcheckServlet",value = "/delcheck")
public class delcheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String[] cids = request.getParameterValues("item_cb");
            boolean b=new Customerservice().delcheck(cids);
            if (b){
                request.getRequestDispatcher("/findall").forward(request,response);
            }else {
                response.getWriter().write("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
