package testCases;
/*
        This class will have test with data provided through sheet
 */

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;
import utility.ReadExcelFile;

import java.io.IOException;

public class DataDrivenLoginTest extends BaseTest {

    String fileName = System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

    @Test(priority = 2, dataProvider = "LoginDataProvider")
    void verifyLogin(String userName, String password){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginPortal(userName, password);
        loginPage.logOut();
    }

    @Test(priority = 1, dataProvider = "LoginDataProvider")
    void verifyLoginWithScreenshotFacilty(String userName, String password) throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginPortal(userName, password);
        loginPage.logOut();

        if(userName.equals("Demo123") && password.equals("Test123456$")){
            System.out.println("Test case passed");
            Assert.assertTrue(true);
            loginPage.logOut();
        } else {
            System.out.println("Test case failed");
            captureScreenShot(webDriver, "verifyLoginWithScreenshotFacilty");
            Assert.fail();
        }

    }
    
    
    @DataProvider(name="LoginDataProvider")
    public String[][] loginDataProvider(){
        String loginSheetName = "LoginData";
        int rowCount = ReadExcelFile.getRowCount(fileName, loginSheetName);
        int colCount = ReadExcelFile.getColCount(fileName, loginSheetName);

        String[][] userNamePasswordArray = new String[rowCount][colCount];

        for(int i=1; i<rowCount; i++){
            for(int j=0 ; j<colCount; j++){
                userNamePasswordArray[i-1][j] = ReadExcelFile.getCellValue(fileName,loginSheetName,i,j);
            }
        }

        return userNamePasswordArray;
    }


}
