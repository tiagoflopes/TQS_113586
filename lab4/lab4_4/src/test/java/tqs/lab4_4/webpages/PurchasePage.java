package tqs.lab4_4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class PurchasePage {

    private final WebDriver driver;
    private static final List<String> cardTypes = Arrays.asList("visa", "amex", "dinersclub");

    @FindBy(tagName = "h2")
    WebElement heading;

    @FindBy(id = "inputName")
    WebElement name;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "zipCode")
    WebElement zipCode;

    @FindBy(id = "cardType")
    WebElement cardButton;
    private final Select cardDropdown;

    @FindBy(id = "creditCardNumber")
    WebElement creditCard;

    @FindBy(id = "creditCardMonth")
    WebElement month;

    @FindBy(id = "creditCardYear")
    WebElement year;

    @FindBy(id = "nameOnCard")
    WebElement nameOnCard;

    @FindBy(id = "rememberMe")
    WebElement rememberMe;

    @FindBy(css = "input.btn")
    WebElement purchaseButton;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.cardDropdown = new Select(cardButton);
    }

    public void setName(String value) {
        name.clear();
        name.sendKeys(value);
    }

    public void setAddress(String value) {
        address.clear();
        address.sendKeys(value);
    }

    public void setCity(String value) {
        city.clear();
        city.sendKeys(value);
    }

    public void setState(String value) {
        state.clear();
        state.sendKeys(value);
    }

    public void setZipCode(String value) {
        zipCode.clear();
        zipCode.sendKeys(value);
    }

    public boolean isCardTypeValid(String value) {
        return cardTypes.contains(value);
    }

    public void setCardType(String value) {
        cardDropdown.selectByValue(value);
    }

    public void setCreditCardNumber(String value) {
        creditCard.clear();
        creditCard.sendKeys(value);
    }

    public void setCreditCardMonth(String value) {
        month.clear();
        month.sendKeys(value);
    }

    public void setCreditCardYear(String value) {
        year.clear();
        year.sendKeys(value);
    }

    public void setNameOnCard(String value) {
        nameOnCard.clear();
        nameOnCard.sendKeys(value);
    }

    public void hitRememberMe() {
        rememberMe.click();
    }

    public void clickOnPurchase() {
        purchaseButton.click();
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Your flight from");
    }

}
