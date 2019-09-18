package com.g.dao;
import com.g.Utils.Utils;
import com.g.domain.UserImpl;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class Usedao {
    public static UserImpl finduse(UserImpl user) throws Exception {
        DataSource dataSource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String password = Utils.getmd5(user.getPassword());
        UserImpl u = queryRunner.query("select * from user where username=? and password =? ", new BeanHandler<UserImpl>(UserImpl.class),user.getUsername(),password);
        return u;
    }


    public static boolean adduser(UserImpl user) throws Exception {
        DataSource dataSource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String password = user.getPassword();
         password= Utils.getmd5(password);
        String uid = Utils.getuuid();
        int i = queryRunner.update("insert into user values(?,?,?)",uid, user.getUsername(), password);
        return i>0;
    }

    public static boolean findusername(String username) throws Exception {
        DataSource dataSource = Utils.getdatasource();
        Connection conn = dataSource.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("select * from user where username=?");
        preparedStatement.setString(1,username);
        return preparedStatement.executeQuery().next();
    }
}
