// This file was generated automatically using the cucumber plugin to create all the step definitions

package tqs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindBookSteps {

    private Library library;
    private List<Book> result;

    @Before
    public void setUp() {
        library = new Library();
        result = new ArrayList<>();
    }

    @Given("I have a list of books")
    public void iHaveAListOfBooks(DataTable table) {
        List<Map<String, String>> books = table.asMaps(String.class, String.class);
        for (Map<String, String> field : books) {
            try {
                library.addBook(new Book(field.get("Title"), field.get("Author"), DateUtils.parseDate(field.get("Date"), new String[] {"yyyy-MM-dd-HH:mm+ss"})));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @When("I search for books by author {string}")
    public void iSearchForBooksByAuthor(String arg0) {
        result = library.findBooksByAuthor(arg0);
    }

    @When("I search for books by title {string}")
    public void iSearchForBooksByTitle(String arg0) {
        result = library.findBooksByTitle(arg0);
    }

    @When("I search for books by the date {string} to {string}")
    public void iSearchForBooksByTheDateTo(String arg0, String arg1) {
        try {
            Date start = DateUtils.parseDate(arg0, new String[] {"yyyy-MM-dd-HH:mm+ss"});
            Date end = DateUtils.parseDate(arg1, new String[] {"yyyy-MM-dd-HH:mm+ss"});
            result = library.findBooks(start, end);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = null;
        }
    }

    @Then("I should find 1 book")
    public void iShouldFindOneBook() {
        assertEquals(1, result.size());
    }

    @Then("I should find {int} books")
    public void iShouldFindBooks(int arg0) {
        assertEquals(arg0, result.size());
    }

}
