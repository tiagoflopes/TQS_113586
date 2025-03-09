package tqs.lab4_4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeveloperApplyPage {

    private final WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(id = "developer_email")
    WebElement developer_email;

    @FindBy(id = "developer_password")
    WebElement developer_password;

    @FindBy(id = "developer_password_confirmation")
    WebElement developer_password_confirmation;

    @FindBy(id = "developer_full_name")
    WebElement developer_full_name;

    @FindBy(id = "developer_skype")
    WebElement developer_skype;

    @FindBy(id = "save_new_developer")
    WebElement join_toptal_button;

    public DeveloperApplyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setDeveloper_email(String email) {
        developer_email.clear();
        developer_email.sendKeys(email);
    }

    public void setDeveloper_password(String password) {
        developer_password.clear();
        developer_password.sendKeys(password);
    }

    public void setDeveloper_password_confirmation(String password_confirmation) {
        developer_password_confirmation.clear();
        developer_password_confirmation.sendKeys(password_confirmation);
    }

    public void setDeveloper_full_name(String full_name) {
        developer_full_name.clear();
        developer_full_name.sendKeys(full_name);
    }

    public void setDeveloper_skype(String skype) {
        developer_skype.clear();
        developer_skype.sendKeys(skype);
    }

    public void clickOnJoin() {
        join_toptal_button.click();
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Apply to join our network as a developer");
    }

}
