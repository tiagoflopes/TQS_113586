package tqs.lab4_3;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(SeleniumJupiter.class)
class BetterBookFinderTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    void test(FirefoxDriver driver) {
        String sutUrl = "https://cover-bookstore.onrender.com/";
        driver.get(sutUrl);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", sutUrl, title);
        assertThat(title).isEqualTo("Cover - Find your favorite books.");

        WebElement searchBar = driver.findElement(By.cssSelector(".Navbar_searchBarContainer__3UbnF > div:nth-child(1) > input:nth-child(1)"));
        searchBar.sendKeys("Harry Potter");
        WebElement submitButton = driver.findElement(By.cssSelector(".Navbar_searchBarContainer__3UbnF > div:nth-child(1) > button:nth-child(2)"));
        submitButton.click();

        assertThat(driver.getCurrentUrl()).isEqualTo("https://cover-bookstore.onrender.com/search?query=Harry%20Potter");

        WebElement bookTitle = driver.findElement(By.cssSelector(".SearchList_bookTitle__1wo4a"));
        WebElement bookAuthor = driver.findElement(By.cssSelector(".SearchList_bookAuthor__3giPc"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> bookTitle.isDisplayed());
        wait.until(d -> bookAuthor.isDisplayed());

        assertThat(bookTitle.getText()).isEqualTo("Harry Potter and the Sorcerer's Stone");
        assertThat(bookAuthor.getText()).isEqualTo("J.K. Rowling");
    }

}
