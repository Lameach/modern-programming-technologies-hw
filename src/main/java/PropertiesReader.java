import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
     public static Properties getProperties(String path) throws IOException {
         FileReader reader = new FileReader(path);
         Properties p = new Properties();
         p.load(reader);
         return p;
     }
}
