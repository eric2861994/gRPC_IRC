package if4031.server.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nim_13512065 on 9/27/15.
 */
public class ServerConfiguration {
    private final Properties prop;

    public ServerConfiguration(String propertiesFilename) throws IOException {
        prop = new Properties();
        InputStream inputStream = getClass().getResourceAsStream(propertiesFilename);

        if (inputStream != null) {
            prop.load(inputStream);

        } else {
            throw new FileNotFoundException("property file '" + propertiesFilename + "' not found in the classpath");
        }
    }

    public String getString(String propertyName) {
        return prop.getProperty(propertyName);
    }

    public int getInt(String propertyName) {
        return Integer.parseInt(prop.getProperty(propertyName));
    }
}
