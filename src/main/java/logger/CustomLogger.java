package logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by lpetrunin on 2/13/2017.
 */
public class CustomLogger {
    private static CustomLogger instance = null;
    private Logger logger = null;

    private CustomLogger() {
        logger = Logger.getLogger("");
    }

    private static CustomLogger getInstance(){
        if (null == instance){
            instance = new CustomLogger();
            return instance;
        } else
            return instance;
    }
    public static void customLog(String input){
        getInstance().logger.log(Level.INFO, input);
    }
}
