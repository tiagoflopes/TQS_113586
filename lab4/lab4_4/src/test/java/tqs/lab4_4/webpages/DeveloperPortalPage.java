package tqs.lab4_4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperPortalPage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div/div/header/div/h1")
    private WebElement heading;

    @FindBy(linkText = "JOIN TOPTAL")
    private WebElement joinToptalButton;

    public DeveloperPortalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Developer Portal");
    }

    public void clickOnJoin() {
        joinToptalButton.click();
    }

}
