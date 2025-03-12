package tqs.lab4_4;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tqs.lab4_4.webpages.ConfirmationPage;
import tqs.lab4_4.webpages.HomePage;
import tqs.lab4_4.webpages.PurchasePage;
import tqs.lab4_4.webpages.ReservePage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumJupiter.class)
public class PurchaseTest {

    @Test
    public void applyAsDeveloper(FirefoxDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        // Home Page
        HomePage home = new HomePage(driver);
        String departureCity = "San Diego";
        String destinationCity = "Rome";
        assertThat(home.isDepartureValid(departureCity)).isTrue();
        assertThat(home.isDestinationValid(destinationCity)).isTrue();
        home.chooseDepartureDropdown(departureCity);
        home.chooseDestinationDropdown(destinationCity);
        home.clickOnFindFlightsButton();

        // Reserve Page
        ReservePage reserve = new ReservePage(driver);
        wait.until(d -> reserve.isPageOpened());
        int flightNumber = 2;
        assertThat(reserve.isFlightNumberValid(2)).isTrue();
        reserve.chooseFlight(flightNumber);

        // do not kms here

        // Purchase Page
        PurchasePage purchase = new PurchasePage(driver);
        wait.until(d -> purchase.isPageOpened());
        purchase.setName("José");
        purchase.setAddress("Rua da Travessa da Rua");
        purchase.setCity("Viseu");
        purchase.setState("Viseu");
        purchase.setZipCode("3515");
        String cardType = "visa";
        assertThat(purchase.isCardTypeValid(cardType)).isTrue();
        purchase.setCardType(cardType);
        purchase.setCreditCardNumber("4659630045645645");
        purchase.setCreditCardMonth("4");
        purchase.setCreditCardYear("2027");
        purchase.setNameOnCard("João");
        purchase.hitRememberMe();
        purchase.clickOnPurchase();

        // Confirmation Page
        ConfirmationPage confirmation = new ConfirmationPage(driver);
        wait.until(d -> confirmation.isPageOpened());
        assertThat(confirmation.isPageReallyOpened()).isTrue();
    }


}
