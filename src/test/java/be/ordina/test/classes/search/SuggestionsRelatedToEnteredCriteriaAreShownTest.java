package be.ordina.test.classes.search;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class SuggestionsRelatedToEnteredCriteriaAreShownTest extends SearchTest {

    /*
     * US3. As a user, I want to be able to search for a specific movie.
     * Context: A user should be able to perform a search using the search field in the
     * header of the web application.
     */

    private final By searchSuggestions = By.xpath("//*[@id=\"plex\"]/div[2]/div/div[1]/div/div[2]");

    @Test
    public void suggestionsRelatedToEnteredCriteriaAreShown() {
        getHomePage().enterSearchCriteria("Popeye");

        //Suggestions will be shown related to the entered search criteria
        assertTrue(getDriver().findElement(searchSuggestions).isDisplayed());
    }
}
