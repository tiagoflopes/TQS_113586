package tqs.lab4_4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private static final String PAGE_URL = "https://blazedemo.com/";
    private static final List<String> departureCities = Arrays.asList("Paris", "Philadelphia", "Boston", "Portland", "San Diego", "Mexico City", "São Paolo");
    private static final List<String> destinationCities = Arrays.asList("Buenos Aires", "Rome", "London", "Berlin", "New York", "Dublin", "Cairo");

    @FindBy(css = "input.btn")
    private WebElement findFlightsButton;

    @FindBy(name = "fromPort")
    private WebElement departureButton;
    private final Select departureDropdown;

    @FindBy(name = "toPort")
    private WebElement destinationButton;
    private final Select destinationDropdown;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
        this.departureDropdown = new Select(this.departureButton);
        this.destinationDropdown = new Select(this.destinationButton);
    }

    public void clickOnFindFlightsButton() {
        findFlightsButton.click();
    }

    public boolean isDepartureValid(String value) {
        return departureCities.contains(value);
    }

    public void chooseDepartureDropdown(String value) {
        departureDropdown.selectByValue(value);
    }

    public boolean isDestinationValid(String value) {
        return destinationCities.contains(value);
    }

    public void chooseDestinationDropdown(String value) {
        destinationDropdown.selectByValue(value);
    }

}
