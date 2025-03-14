package tqs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class bookStoreSteps {

    private WebDriver driver;

    @Given("I'm on the bookStore webpage")
    public void setup() {
        driver = WebDriverManager.firefoxdriver().create();
        String url = "https://cover-bookstore.onrender.com/";
        driver.get(url);
    }

    @When("I type {string} on the search bar")
    public void search(String title) {
        WebElement searchBar = driver.findElement(By.cssSelector(".Navbar_searchBarContainer__3UbnF > div:nth-child(1) > input:nth-child(1)"));
        searchBar.sendKeys(title);
    }

    @And("I click the search button")
    public void searchButton() {
        WebElement submitButton = driver.findElement(By.cssSelector(".Navbar_searchBarContainer__3UbnF > div:nth-child(1) > button:nth-child(2)"));
        submitButton.click();
    }

    @Then("I'm redirected to a page which url includes \"query={string}\"")
    public void resultUrl(String title) {
        String formatedTitle = WordUtils.capitalizeFully(title).replace(" ", "%20");
        assertThat(driver.getCurrentUrl()).isEqualTo("https://cover-bookstore.onrender.com/search?query=" + formatedTitle);
    }

    @And("the page contains card titled {string} with author {string}")
    public void cardTitle(String title, String author) {
        WebElement bookTitle = driver.findElement(By.cssSelector(".SearchList_bookTitle__1wo4a"));
        WebElement bookAuthor = driver.findElement(By.cssSelector(".SearchList_bookAuthor__3giPc"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> bookTitle.isDisplayed());
        wait.until(d -> bookAuthor.isDisplayed());

        assertThat(bookTitle.getText()).containsIgnoringCase(title);
        assertThat(bookAuthor.getText()).isEqualTo(author);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
