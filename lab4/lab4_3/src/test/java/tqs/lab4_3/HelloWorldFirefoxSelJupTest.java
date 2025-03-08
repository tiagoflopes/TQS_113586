package tqs.lab4_3;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
class HelloWorldFirefoxSelJupTest {

    static final Logger log = getLogger(lookup().lookupClass());

    @Test
    void test(FirefoxDriver driver) {
        String sutUrl = "https://cover-bookstore.onrender.com/";
        driver.get(sutUrl);
        String title = driver.getTitle();
        log.debug("The title of {} is {}", sutUrl, title);
        assertThat(title).isEqualTo("Cover - Find your favorite books.");

        WebElement searchBar = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[1]/div/input"));
        searchBar.sendKeys("Harry Potter");
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[1]/div/button"));
        submitButton.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://cover-bookstore.onrender.com/search?query=Harry%20Potter");

        WebElement bookTitle = driver.findElement(By.className("SearchList_bookTitle__1wo4a"));
        assertThat(bookTitle.getText()).isEqualTo("Harry Potter and the Sorcerer's Stone");
        WebElement bookAuthor = driver.findElement(By.className("SearchList_bookAuthor__3giPc"));
        assertThat(bookAuthor.getText()).isEqualTo("J.K. Rowling");
    }

}