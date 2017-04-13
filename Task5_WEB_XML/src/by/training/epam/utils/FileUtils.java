package by.training.epam.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FileUtils {

	private static final Logger log = Logger.getLogger(FileUtils.class);
	private static final String PROP_FILE_NAME = "D://config.properties";
	
	public String getPropertyValue(String propName){
		
		FileInputStream fis;
        Properties property = new Properties();
 
        try {
            fis = new FileInputStream(PROP_FILE_NAME);
            property.load(fis);
            String value = property.getProperty(propName);
            
            return value;
            
        } catch (IOException e) {
        	log.error(e.getMessage());
        }
		return "";
	}
	
}
