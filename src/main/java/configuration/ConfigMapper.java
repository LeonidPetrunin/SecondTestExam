package configuration;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class ConfigMapper {
     private ConfigObject configObject;
     private static ConfigMapper instance = null;

    private ConfigMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        String configPath = "C:\\Users\\lpetrunin\\IdeaProjects\\SecondTestExam\\src\\main\\resources\\config.json";

        try {
            configObject = objectMapper.readValue(new File(configPath), ConfigObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigMapper getInstance(){
        if(null==instance){
            instance = new ConfigMapper();
            return instance;
        } else
            return instance;
    }

     public ConfigObject getConfigObject() {
        return configObject;
    }

}
