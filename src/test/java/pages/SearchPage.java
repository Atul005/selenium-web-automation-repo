package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "search_course")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"primary_menu\"]/nav[1]/form/button")
    WebElement searchButton;


    public void SearchCourse(String courseName){
        searchBar.sendKeys(courseName);
        searchButton.click();
    }



}
