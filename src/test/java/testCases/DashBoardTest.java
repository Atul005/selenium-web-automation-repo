package testCases;

import org.testng.annotations.Test;
import pages.*;
import utility.ReadExcelFile;

public class DashBoardTest extends BaseTest {

    String fileName = System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

    @Test
    public void subscribeCourseTest(){
        LoginPage loginPage = new LoginPage(webDriver);

        String userName = ReadExcelFile.getCellValue(fileName,"LoginData",1,0);
        String password = ReadExcelFile.getCellValue(fileName,"LoginData",1,1);
        String courseName = ReadExcelFile.getCellValue(fileName,"Courses",0,0);

        loginPage.loginPortal(userName,password);
        DashboardPage dashboardPage = new DashboardPage(webDriver);
        dashboardPage.subscribeCourse();

    }

}
