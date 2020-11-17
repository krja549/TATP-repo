package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoviesAndShowsPage extends BasePage {

    private final By tabs = By.cssSelector("a[data-qa-id='tabButton']");

    public MoviesAndShowsPage(WebDriver driver) {
        super(driver);
    }

    public Watchlist clickWatchListTab() {
        clickTab(1);
        return new Watchlist(driver);
    }
    public void clickCategoriesTab() {
        clickTab(2);
    }

    public void removeAllWatchlistItems() {
        Watchlist watchlist = clickWatchListTab();
        while (watchlist.getNumberOfWatchlistItems() > 0) {
            watchlist.removeItemFromWatchlist(0);
            clickCategoriesTab();
            clickWatchListTab();
        }
    }

    private void clickTab(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(tabs));
        driver.findElements(tabs).get(index).click();
    }
}
