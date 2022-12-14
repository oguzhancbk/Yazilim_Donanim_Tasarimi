package org.selenium.pom.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    private static Properties prop;
    private static ReadConfig readConfig;
    private static final String path = "C:\\Users\\o84269812\\IntellijIdeaProjects\\Trendyol_Fe_Test_Automation\\Configuration\\config.properties";

    public ReadConfig() {
        try {
            prop = new Properties();
            FileInputStream fs = new FileInputStream(path);
            prop.load(fs);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getBaseUrl(){
        String value = prop.getProperty("baseUrl");
        if (value != null){
            return value;
        } else {
            throw new RuntimeException("url not specified in config file");
        }
    }
    public static ReadConfig getInstance() {
        if (readConfig == null) {
            readConfig = new ReadConfig();
        }
        return readConfig;
    }
    public static String getBrowser() {
        String value = prop.getProperty("browser");
        if (value != null) return value;
        else throw new RuntimeException("url not specified in config file");
    }

}
