package be.ordina.test.classes.watchlist;

import be.ordina.test.suites.Include;
import be.ordina.pages.DetailPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

public class AddMovieToWatchlistTest extends WatchlistTest {

    private DetailPage detailPage;

    @Before
    public void signInBeforeTestMethod() {
        super.signInBeforeTestMethod();
        getHomePage().enterSearchCriteria("Little Paradise");
        detailPage = getHomePage().clickFirstSearchSuggestionItem();
    }

    @Category(Include.class)
    @Test
    public void addMovieToWatchList() {
        detailPage.clickAddToWatchlistButton();

        // go to the watchlist and see that the counter has been changed to 1
        setMoviesAndShowsPage(getHomePage().goToMoviesAndShows());
        setWatchlist(getMoviesAndShowsPage().clickWatchListTab());
        assertEquals(1, getWatchlist().getCounter());
    }
}
