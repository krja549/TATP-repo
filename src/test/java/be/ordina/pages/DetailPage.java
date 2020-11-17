package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailPage extends BasePage {

    private final By content = By.id("content");
    private final By btnAddToWatchlist = By.cssSelector("button[data-qa-id$='addToWatchlist']");
    private final By btnRemoveFromWatchlist = By.cssSelector("button[data-qa-id$='removeFromWatchlist']");

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToWatchlistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToWatchlist));
        driver.findElement(btnAddToWatchlist).click();
    }

    public void clickRemoveFromWatchlistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnRemoveFromWatchlist));
        driver.findElement(btnRemoveFromWatchlist).click();
    }
}
