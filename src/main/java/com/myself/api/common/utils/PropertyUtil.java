package com.myself.api.common.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyUtil {

    public static Properties getConfig(String path){
        Properties props=null;
        try{
            props = new Properties();
            InputStream in = PropertyUtil.class.getResourceAsStream(path);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            props.load(bf);
            in.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return props;
    }
}
