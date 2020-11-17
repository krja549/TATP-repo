package be.ordina.features.watchlist;

import be.ordina.pages.DetailPage;
import be.ordina.pages.HomePage;
import be.ordina.pages.MoviesAndShowsPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class RemoveMovieFromWatchlistTest extends WatchlistTest {

    private HomePage homePage;
    private DetailPage detailPage;
    private MoviesAndShowsPage moviesAndShowsPage;

    @Test
    public void removeMovieFromWatchList() {
        homePage = getHomePage();
        homePage.enterSearchCriteria("Popeye");
        detailPage = homePage.clickFirstSearchSuggestionItem();
        detailPage.clickAddToWatchlistButton();

        detailPage.clickRemoveFromWatchlistButton();

        moviesAndShowsPage = homePage.goToMoviesAndShows();
        moviesAndShowsPage.clickWatchListTab();
        String message = getDriver().findElement(By.cssSelector("[class^='EmptyPageDescription']")).getText();
        assertTrue(message.contains("You can add movies and shows to your Watchlist"));
    }
}
