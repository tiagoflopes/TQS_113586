package tqs.lab4_4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;
    private static final String PAGE_URL = "https://www.toptal.com";

    @FindBy(how = How.XPATH, using = "/html/body/main/div[5]/div/div/div/a[2]")
    private WebElement developerApplyButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickOnDeveloperApplyButton() {
        developerApplyButton.click();
    }

}
