package pages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.BrowserFactory;
import utility.ConfigDataProvider;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver webDriver;
    ConfigDataProvider configDataProvider = new ConfigDataProvider();

    @BeforeClass
    public void setUp(){
        webDriver = BrowserFactory.startApplication(webDriver, configDataProvider.getBrowser(), configDataProvider.getStagingUrl());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quit(webDriver);
    }

    public void captureScreenShot(WebDriver driver,String testName) throws IOException
    {
        // Convert webdriver object to TakesScreenshot interface
        TakesScreenshot screenshot= ((TakesScreenshot)driver);

        // Step 2 :call getScreenshotAs method to capture image file

        File src= screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath=new File("."+"//Screenshots//"+ testName + ".png");

        // Step 3 : copy image file to destination
        FileUtils.copyFile(src, srcpath);

    }



}
