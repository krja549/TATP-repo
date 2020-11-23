package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Watchlist extends BasePage {

    private final By counter = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div[1]/span[2]");
    private By items = By.cssSelector("div[data-qa-id='cellItem']");
    private By moreButton = By.cssSelector("button[data-qa-id$='MoreButton']");
    private By dropDownItems = By.cssSelector("button[data-qa-id$='dropdownItem']");
    private By emptyPageMessage = By.cssSelector("[class^='EmptyPageDescription']");

    public Watchlist(WebDriver driver) {
        super(driver);
    }

    public int getCounter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(counter));
        return Integer.parseInt(driver.findElement(counter).getText());
    }

    public int getNumberOfWatchlistItems() {
        return driver.findElements(items).size();
    }

    public WebElement getWatchlistItem(int index) {
        return driver.findElements(items).get(index);
    }

    public void removeItemFromWatchlist(int index) {
        Actions action = new Actions(driver);
        WebElement firstItem = driver.findElements(items).get(0);
        WebElement btnMore = driver.findElement(moreButton);
        action.moveToElement(firstItem)
                .moveToElement(btnMore)
                .click()
                .build()
                .perform();
        WebElement removeFromWatchlistDropdownItem = driver.findElements(dropDownItems).get(4);
        wait.until(ExpectedConditions.elementToBeClickable(removeFromWatchlistDropdownItem));
        removeFromWatchlistDropdownItem.click();
    }
}
