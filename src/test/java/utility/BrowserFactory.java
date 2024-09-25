package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl)
    {

        switch (browserName) {
            case "Chrome" -> {
                System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
                ChromeOptions op = new ChromeOptions();
                op.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(op);
            }
            case "Firefox" -> {
                System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            case "IE" -> {
                System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
            default -> System.out.println("We do not support this browser ");
        }

        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;

    }

    public static void quit(WebDriver driver){
        driver.quit();
    }

}
