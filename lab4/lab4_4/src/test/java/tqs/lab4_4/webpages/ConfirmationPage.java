package tqs.lab4_4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    private final WebDriver driver;

    @FindBy(css = ".hero-unit > h1:nth-child(1)")
    private WebElement heading;

    @FindBy(css = ".table > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)")
    private WebElement reallyTest;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return heading.getText().equals("Thank you for your purchase today!");
    }

    public boolean isPageReallyOpened() {
        return reallyTest.getText().equals("xxxxxxxxxxxx1111");
    }

}
