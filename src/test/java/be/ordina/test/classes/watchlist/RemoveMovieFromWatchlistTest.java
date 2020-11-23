package be.ordina.test.classes.watchlist;

import be.ordina.pages.DetailPage;
import be.ordina.test.suites.Include;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class RemoveMovieFromWatchlistTest extends WatchlistTest {

    private DetailPage detailPage;

    @Before
    public void signInBeforeTestMethod() {
        super.signInBeforeTestMethod();
        getHomePage().enterSearchCriteria("Little Paradise");
        detailPage = getHomePage().clickFirstSearchSuggestionItem();
        detailPage.clickAddToWatchlistButton();
    }

    @Category(Include.class)
    @Test
    public void removeMovieFromWatchList() {
        detailPage.clickRemoveFromWatchlistButton();

        setMoviesAndShowsPage(getHomePage().goToMoviesAndShows());
        getMoviesAndShowsPage().clickWatchListTab();
        String message = getDriver().findElement(By.cssSelector("[class^='EmptyPageDescription']")).getText();
        assertTrue(message.contains("You can add movies and shows to your Watchlist"));
    }
}
