package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver webDriver;

    public DashboardPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"login-list\"]/li[1]")
    WebElement dashBoardButton;

    @FindBy(xpath = "//*[@id=\"learn-press-user-profile\"]/ul/li[3]/a")
    WebElement offeredAcademicsClick;

//    @FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button")
    @FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form")
    WebElement subscribeClick;

    public void subscribeCourse(){
        dashBoardButton.click();
        offeredAcademicsClick.click();


        subscribeClick.submit();
    }


}
