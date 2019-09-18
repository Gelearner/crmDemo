package com.g.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

@WebServlet(name = "checkcodeServlet",value ="/checkcode")
public class checkcodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=300;
        int heigh=300;
        BufferedImage image = new BufferedImage(width,heigh,BufferedImage.TYPE_BYTE_GRAY);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.orange);
        graphics.fillRect(0,0,width,heigh);
        graphics.drawRect(0,0,width-1,heigh-1);
        graphics.setColor(Color.black);
        String str="1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuffer strb = new StringBuffer();
        Random random = new Random();
        for (int i = 1; i <=4; i++) {
            int num = random.nextInt(str.length());
            char ch = str.charAt(num);
            graphics.drawString(ch+"",width/5*i,heigh/2);
            strb.append(ch);
        }
        String servercode = strb.toString();
        HttpSession session = request.getSession();
        session.setAttribute("servercode",servercode);
        graphics.setColor(Color.black);
        for (int j = 0; j < 10; j++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(heigh);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(heigh);
            graphics.drawLine(x1,y1,x2,y2);
        }
        ImageIO.write(image,"gif",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
