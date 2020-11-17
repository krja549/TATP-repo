package be.ordina.features.watchlist;

import be.ordina.BaseTest;
import be.ordina.pages.MoviesAndShowsPage;
import be.ordina.pages.Watchlist;
import org.junit.After;
import org.junit.Before;

public class WatchlistTest extends BaseTest {

    private MoviesAndShowsPage moviesAndShowsPage;
    private Watchlist watchlist;

    @Before
    public void setUpBeforeTestClass() {
        super.setUpBeforeTestClass();
    }

/*    @Before
    public void signUpBeforeTestMethod() {
        super.signUpBeforeTestMethod();
    }*/

    @Before
    public void signInBeforeTestMethod() {
        super.signInBeforeTestMethod();
        moviesAndShowsPage = getHomePage().goToMoviesAndShows();
        moviesAndShowsPage.removeAllWatchlistItems();
    }

    @After
    public void tearDownAfterTestClass() {
        super.tearDownAfterTestClass();
    }
}
