package tqs.lab4_4;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import tqs.lab4_4.webpages.DeveloperApplyPage;
import tqs.lab4_4.webpages.DeveloperPortalPage;
import tqs.lab4_4.webpages.HomePage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumJupiter.class)
public class ApplyAsDeveloperTest {

    @Test
    public void applyAsDeveloper(FirefoxDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        HomePage home = new HomePage(driver);
        home.clickOnDeveloperApplyButton();

        DeveloperPortalPage devportal = new DeveloperPortalPage(driver);

        assertThat(devportal.isPageOpened()).isTrue();

        devportal.clickOnJoin();

        DeveloperApplyPage applyPage = new DeveloperApplyPage(driver);

        assertThat(applyPage.isPageOpened()).isTrue();

        applyPage.setDeveloper_email("<EMAIL>");
        applyPage.setDeveloper_full_name("<NAME>");
        applyPage.setDeveloper_password("");
        applyPage.setDeveloper_password_confirmation("");
        applyPage.setDeveloper_skype("");

        //applyPage.clickOnJoin();
    }


}
