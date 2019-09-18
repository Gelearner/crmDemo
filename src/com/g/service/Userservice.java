package com.g.service;
import com.g.dao.Usedao;
import com.g.domain.UserImpl;

public class Userservice {
    public static UserImpl islogin(UserImpl user) throws Exception {
        Usedao usedao = new Usedao();
        UserImpl finduse = usedao.finduse(user);
        return finduse;
    }

    public static boolean adduser(UserImpl user) throws Exception {
        boolean b=Usedao.adduser(user);
        return b;
    }

    public boolean findusername(String username) throws Exception {
        boolean b=Usedao.findusername(username);
        return b;
    }
}
