package com.framework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {
        File configFile = new File("./Configuration/config.properties");

        try {

            FileInputStream inputStream = new FileInputStream(configFile);
            pro = new Properties();
            pro.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Expection is"+e.getMessage());
        }
    }


    public String getApplicationURL(){
        return pro.getProperty("baseURL");
    }

    public String getemailId(){
        return pro.getProperty("emailId");
    }
    public String getpassword(){
        return pro.getProperty("password");
    }
    public String getchromePath(){
        return pro.getProperty("chromePath");
    }

    public String getfirefoxPath(){
        return pro.getProperty("firefoxPath");
    }

    public String getedgePath(){
        return pro.getProperty("edgePath");
    }

}
