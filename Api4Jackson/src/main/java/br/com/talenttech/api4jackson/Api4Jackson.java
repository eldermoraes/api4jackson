/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.talenttech.api4jackson;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author eldermoraes
 */
public class Api4Jackson {

    public static File getObjectAsJSONFile(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        
        try {
            jsonFile = File.createTempFile("file", "json");
            mapper.writeValue(jsonFile, object);
        } catch (IOException ex) {
            Logger.getLogger(Api4Jackson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonFile;
    }
    
    public static String getObjectAsJSONString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;

        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (IOException ex) {
            Logger.getLogger(Api4Jackson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonString;
    }
    
    public static Object getJSONFileAsObject(File file, Class clazz){
        ObjectMapper mapper = new ObjectMapper();
        Object object = null;
        
        try {
            object = mapper.readValue(file, clazz);
        } catch (IOException ex) {
            Logger.getLogger(Api4Jackson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return object;
    }
    
    public static Object getJSONStringAsObject(String jsonString, Class clazz){
        ObjectMapper mapper = new ObjectMapper();
        Object object = null;

        try {
            object = mapper.readValue(jsonString, clazz);
        } catch (IOException ex) {
            Logger.getLogger(Api4Jackson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return object;
    }
}
