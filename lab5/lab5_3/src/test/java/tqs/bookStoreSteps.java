package tqs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class bookStoreSteps {

    private WebDriver driver;
    private final String url = "https://cover-bookstore.onrender.com/";

    @Given("I'm on the bookStore webpage")
    public void setup() {
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @When("I type {string} on the search bar")
    public void search(String title) {

    }

    @And("I click the search button")
    public void searchButton() {

    }

    @Then("I'm redirected to a page which url includes 'query={string}'")
    public void resultUrl(String title) {
        
    }

    @And("the page contains card titled {string}")
    public void cardTitle(String title) {
        driver.quit();
    }

}
