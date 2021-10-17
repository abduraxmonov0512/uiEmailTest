package utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private PropertyLoader() {}

    public static String returnConfigValue(final String property) throws Exception {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("test.properties")) {

            properties.load(propFileInpStream);
            return properties.getProperty(property);
        } catch (IOException e) {

            throw new Exception("Without configuration file!");
        }
    }
}
