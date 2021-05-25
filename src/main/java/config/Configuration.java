package config;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configuration {
    public static String URI;

    static {
        try (InputStream inputStream = Files.newInputStream(Paths.get("src", "main", "resources", "configuration.yaml"))) {

            YamlConfigurations yamlConfigurations = new Yaml().loadAs(inputStream, YamlConfigurations.class);
            URI = yamlConfigurations.getUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Configuration() {

    }
}