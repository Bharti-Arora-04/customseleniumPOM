package com.scrolltest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    //read the all property from the resource file
    static Properties properties;
    public PropertyReader(){
        loadAllProperties();
    }
    public void loadAllProperties(){
        properties = new Properties();
        try{
            String filename = System.getProperty("user.dir")+ "Users\\lenovo\\customseleniumPOM\\src\\main\\resources\\prod_config.properties";
            properties.load(new FileInputStream(filename));
        }catch (IOException e){
            throw new RuntimeException("file not found");
        }
    }
    public static String readItem(String propertyname){
        return properties.getProperty(propertyname);
    }
}
