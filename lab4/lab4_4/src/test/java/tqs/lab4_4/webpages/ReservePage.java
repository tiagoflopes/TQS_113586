package tqs.lab4_4.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReservePage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/h3")
    private WebElement heading;

    @FindBy(className = "table")
    private WebElement table;
    private final List<WebElement> flights;

    public ReservePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.flights = table.findElements(By.xpath("//tbody/tr/td[1]/input"));
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Flights from");
    }

    public int getFlightCount() {
        return flights.size();
    }

    public boolean isFlightNumberValid(int number) {
        return number > 0 & number < getFlightCount();
    }

    public void chooseFlight(int number) {
        flights.get(number).click();
    }

}
