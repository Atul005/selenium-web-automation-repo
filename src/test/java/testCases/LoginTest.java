package testCases;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userName = "Demo12";
        String password = "Test123456$";
        loginPage.loginPortal(userName, password);
        loginPage.logOut();
    }

}
