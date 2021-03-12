package config;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {
    private static String path;
    private static final Properties PROPERTIES = new Properties();

    public PropertyLoader(String path){
        this.path = path;
        try(InputStream in = PropertyLoader.class.getClassLoader().getResourceAsStream(path)){
            PROPERTIES.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String name){
        String property = PROPERTIES.getProperty(name);
        return property;
    }
}
