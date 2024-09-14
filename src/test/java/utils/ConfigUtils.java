package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {
//    readGenericElementFromConfig method reads the property value from the config file
    public static String readGenericElementFromConfig(String configFile, String propertyName, String defaultValue) {
        String elementValue = defaultValue;
        try {
            Properties props = new Properties();
            String path = Paths.get("").toAbsolutePath().toString();
            props.load(new FileInputStream(path + "/src/test/resources/config/" + configFile));
            elementValue = props.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println("Cannot read" + propertyName + " from:" + configFile + " error:" + e.getMessage());
        }
        return elementValue;
    }

    public static String readGenericElementFromConfig(String configFile, String propertyName) {
        return readGenericElementFromConfig(configFile, propertyName, "");
    }
}
