package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath="//*[@id=\"loginlabel\"]")
    WebElement loginClick;

    @FindBy(name="log")
    WebElement uName;

    @FindBy(name="pwd")
    WebElement pass;

    @FindBy(name="wp-submit")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"gk-login-toggle\"]/i")
    WebElement logOutImage;

    @FindBy(xpath = "//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a")
    WebElement getLogOutButton;

    public void loginPortal(String userName, String password){
        loginClick.click();
        uName.sendKeys(userName);
        pass.sendKeys(password);
        loginButton.click();
    }

    public void logOut(){
        logOutImage.click();
        getLogOutButton.click();
    }

}
