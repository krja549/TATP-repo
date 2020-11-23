package be.ordina.test.classes.watchlist;

import be.ordina.test.suites.Include;
import be.ordina.utils.SeleniumUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class EmptyWatchlistTest extends WatchlistTest{

    @Category(Include.class)
    @Test
    public void messageIsDisplayedWhenWatchlistIsEmpty() throws IOException {
        getMoviesAndShowsPage().clickWatchListTab();

        String message = getDriver().findElement(By.cssSelector("[class^='EmptyPageDescription']")).getText();
        assertTrue(message.contains("You can add movies and shows to your Watchlist"));
        SeleniumUtils.screenshot(getDriver(), "messageIsDisplayedWhenWatchlistIsEmpty");
    }
}
