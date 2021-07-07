package com.application.utils.filehandlingutils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {


    Properties properties;
    FileInputStream file;

    public ReadProperties(String filePath) {
        try {
            file = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            e.getMessage();
        }
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
