package be.ordina.features.watchlist;

import be.ordina.pages.*;
import be.ordina.utils.SeleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class EmptyWatchlistTest extends WatchlistTest{

    private MoviesAndShowsPage moviesAndShowsPage;

    @Test
    public void messageIsDisplayedWhenWatchlistIsEmpty() throws IOException {
        moviesAndShowsPage = getHomePage().goToMoviesAndShows();
        moviesAndShowsPage.clickWatchListTab();

        String message = getDriver().findElement(By.cssSelector("[class^='EmptyPageDescription']")).getText();

        assertTrue(message.contains("You can add movies and shows to your Watchlist"));
        SeleniumUtils.screenshot(getDriver(), "messageIsDisplayedWhenWatchlistIsEmpty");
    }
}
