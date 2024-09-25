package utility;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    Properties property;

    public ConfigDataProvider()
    {
        File src = new File("./Configurations/config.properties");

        try {
            FileInputStream fis= new FileInputStream(src);

            property= new Properties();

            property.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load config file "+e.getMessage());
        }
    }


    public String getBrowser() {
        return property.getProperty("browser");
    }



    public String getStagingUrl() {
        return property.getProperty("testUrl");
    }
}
