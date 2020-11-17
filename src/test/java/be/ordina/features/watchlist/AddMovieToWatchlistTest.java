package be.ordina.features.watchlist;

import be.ordina.pages.DetailPage;
import be.ordina.pages.HomePage;
import be.ordina.pages.MoviesAndShowsPage;
import be.ordina.pages.Watchlist;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddMovieToWatchlistTest extends WatchlistTest {

    private HomePage homePage;
    private DetailPage detailPage;
    private MoviesAndShowsPage moviesAndShowsPage;
    private Watchlist watchlist;

    @Test
    public void addMovieToWatchList() {
        homePage = getHomePage();
        homePage.enterSearchCriteria("Popeye");
        detailPage = homePage.clickFirstSearchSuggestionItem();

        detailPage.clickAddToWatchlistButton();

        // go to the watchlist and see that the counter has been changed to 1
        moviesAndShowsPage = homePage.goToMoviesAndShows();
        watchlist = moviesAndShowsPage.clickWatchListTab();
        assertEquals(1, watchlist.getCounter());
    }
}
