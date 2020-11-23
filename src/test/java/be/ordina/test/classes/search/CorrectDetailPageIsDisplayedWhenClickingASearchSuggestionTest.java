package be.ordina.test.classes.search;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class CorrectDetailPageIsDisplayedWhenClickingASearchSuggestionTest extends SearchTest {

    /*
     * US3. As a user, I want to be able to search for a specific movie.
     * Context: A user should be able to perform a search using the search field in the
     * header of the web application.
     */

    private final By content = By.id("content");

    @Test
    public void correctDetailPageIsDisplayedWhenClickingASearchSuggestion() {
        getHomePage().enterSearchCriteria("Popeye the Sailor");
        getHomePage().clickFirstSearchSuggestionItem();

        //Clicking on a suggestion will open the correct detail page
        assertTrue(getDriver().findElement(content).isDisplayed());
    }
}
