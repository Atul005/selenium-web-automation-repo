package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver webDriver;

    public PaymentPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label")
    WebElement selectPaymentMethod;

    @FindBy(name="learn_press_checkout_place_order")
    WebElement placeOrder;

    @FindBy(xpath = "//*[@id=\"card-element\"]/div/iframe")
    WebElement frameElement;

    @FindBy(name="cardnumber")
    WebElement cardNumberBar;

    @FindBy(xpath = "//*[@id=\"payment-button\"]")
    WebElement payNowOption;

    @FindBy(name="exp-date")
    WebElement expiryDate;

    @FindBy(name="cvc")
    WebElement cvvElement;

    public void buyCourse(String cardNumber, String expDate, String cvv){
        selectPaymentMethod.click();
        placeOrder.submit();

        webDriver.switchTo().frame(frameElement);
        cardNumberBar.sendKeys(cardNumber);
        expiryDate.sendKeys(expDate);
        cvvElement.sendKeys(cvv);

        webDriver.switchTo().defaultContent();
        payNowOption.click();

    }
}
