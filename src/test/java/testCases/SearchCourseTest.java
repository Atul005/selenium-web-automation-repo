package testCases;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;
import pages.SearchPage;
import utility.ReadExcelFile;

public class SearchCourseTest extends BaseTest {

    String fileName = System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

    @Test
    public void searchCourse(){
        LoginPage loginPage = new LoginPage(webDriver);

        String userName = ReadExcelFile.getCellValue(fileName,"LoginData",1,0);
        String password = ReadExcelFile.getCellValue(fileName,"LoginData",1,1);
        String courseName = ReadExcelFile.getCellValue(fileName,"Courses",0,0);

        loginPage.loginPortal(userName,password);
        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.SearchCourse(courseName);
    }

}
