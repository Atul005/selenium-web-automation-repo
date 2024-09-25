package testCases;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PaymentPage;
import utility.ReadExcelFile;

public class PaymentTest extends BaseTest {

    String fileName = System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

    @Test
    public void testCourseBuy(){

        String userName = ReadExcelFile.getCellValue(fileName,"LoginData",1,0);
        String password = ReadExcelFile.getCellValue(fileName,"LoginData",1,1);
        String cardNumber = ReadExcelFile.getCellValue(fileName,"payment",0,0);
        String cvvNum = ReadExcelFile.getCellValue(fileName,"payment",0,1);
        String expDate = ReadExcelFile.getCellValue(fileName,"payment",0,2);

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginPortal(userName, password);

        DashboardPage dashboardPage = new DashboardPage(webDriver);
        dashboardPage.subscribeCourse();

        PaymentPage paymentPage = new PaymentPage(webDriver);
        paymentPage.buyCourse(cardNumber, expDate, cvvNum);



    }

}
