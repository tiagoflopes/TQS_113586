package tqs.lab4_5;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(SeleniumJupiter.class)
class DockerChromeSelJupTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    void test(@DockerBrowser(type = CHROME) WebDriver driver) {
        // Exercise
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(sutUrl);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", sutUrl, title);

        // Verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
        System.out.println("Debug message to assert that the test ran successfully");
    }

    @Test
    void anotherTest(@DockerBrowser(type = CHROME) WebDriver driver) {
        // Exercise
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(sutUrl);

        WebElement slowCalc = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[1]/div/div/a[8]"));
        slowCalc.click();

        // Verify
        assertThat(driver.findElement(By.id("calculator"))).isNotNull();
        System.out.println("Debug message to assert that the test ran successfully");
    }

}