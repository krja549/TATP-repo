package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstMovieThumbnail = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a");
    private final By accountButton = By.id("id-10");
    private final By tbSearch = By.cssSelector("input[data-qa-id='quickSearchInput']");
    private final By searchSuggestionsOverlay = By.xpath("//*[@id=\"plex\"]/div[2]/div/div[1]/div/div[2]");
    private final By searchSuggestionItems = By.cssSelector("input[data-qa-id='quickSearchItemButton']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void clickAccountButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        driver.findElement(accountButton).click();
    }

    public ConsentModal playFirstMovie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstMovieThumbnail));
        wait.until(ExpectedConditions.elementToBeClickable(firstMovieThumbnail));
        driver.findElement(firstMovieThumbnail).click();
        return new ConsentModal(driver);
    }

    public void waitForVideoPlayerToStart() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("show-video-player"))));
    }

    public void enterSearchCriteria(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tbSearch));
        driver.findElement(tbSearch).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionsOverlay));
    }

    public DetailPage clickFirstSearchSuggestionItem() throws InterruptedException {
        WebElement firstSearchSuggestionItem = driver.findElements(searchSuggestionItems).get(0);
        driver.findElementsLocated()
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchSuggestionItem));
        Thread.sleep(2000);
        firstSearchSuggestionItem.click();
        return new DetailPage(driver);
    }
}
