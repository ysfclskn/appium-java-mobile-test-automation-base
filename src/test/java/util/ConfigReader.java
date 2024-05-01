package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getPlatform() {
        return System.getProperty("platform", "Android");
    }

    private static final String PATH = getPlatform() + ".properties";
    private static Properties properties = new Properties();

    static {
        loadProperties(PATH);
    }

    private static void loadProperties(String path) {
        try (FileInputStream input = new FileInputStream("src/test/java/configs/" + path)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    public static String get(String keyName, String path) {
        Properties tempProperties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/java/configs/" + path)) {
            tempProperties.load(input);
            return tempProperties.getProperty(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
