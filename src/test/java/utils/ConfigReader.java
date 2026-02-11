package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    //méthode pour appeler la config dans le fichier config.properties
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Impossible de trouver config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement du fichier config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getBasePath() {
        return properties.getProperty("base.path");
    }
}
