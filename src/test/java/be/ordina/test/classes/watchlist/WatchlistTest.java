package be.ordina.test.classes.watchlist;

import be.ordina.test.classes.BaseTest;
import be.ordina.pages.MoviesAndShowsPage;
import be.ordina.pages.Watchlist;
import org.junit.After;
import org.junit.Before;

public abstract class WatchlistTest extends BaseTest {

    private MoviesAndShowsPage moviesAndShowsPage;
    private Watchlist watchlist;

    @Before
    public void signInBeforeTestMethod() {
        super.signInBeforeTestMethod();
        moviesAndShowsPage = getHomePage().goToMoviesAndShows();
        moviesAndShowsPage.removeAllWatchlistItems();
    }

    @After
    public void signOutAfterTestMethod() {
        super.signOutAfterTestMethod();
    }

    // Some getters and setters we need throughout our tests
    public MoviesAndShowsPage getMoviesAndShowsPage() {
        return moviesAndShowsPage;
    }

    public Watchlist getWatchlist() {
        return watchlist;
    }

    public void setMoviesAndShowsPage(MoviesAndShowsPage moviesAndShowsPage) {
        this.moviesAndShowsPage = moviesAndShowsPage;
    }

    public void setWatchlist(Watchlist watchlist) {
        this.watchlist = watchlist;
    }
}
