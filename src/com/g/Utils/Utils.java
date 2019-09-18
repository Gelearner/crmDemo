package com.g.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.UUID;

public class Utils {
    public static  String getuuid(){
        UUID uuid = UUID.randomUUID();
        String string = uuid.toString();
        String s = string.replaceAll("-", "");
        return s;
    }
    public static String getmd5(String str) throws NoSuchAlgorithmException {
        if (str==null){
            str="";
        }
        MessageDigest digest = MessageDigest.getInstance("Md5");
        byte[] bytes = digest.digest(str.getBytes());
        StringBuffer strb = new StringBuffer();
        for (byte aByte : bytes) {
            int by=aByte&0xff;
            String string = Integer.toHexString(by);
            if (string.length()<2){
                string="0"+string;
            }
            strb.append(string);
        }
        return strb.toString();
    }

    public static DataSource getdatasource() throws Exception {
        InputStream in = Utils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(in);
        return new DruidDataSourceFactory().createDataSource(properties);

    }
}
