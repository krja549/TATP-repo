package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By firstMovieThumbnail = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/a");
    private final By accountButton = By.xpath("//*[@id=\"id-10\"]/div");
    private final By accountMenuItems= By.xpath("/html/body/div[2]");
    private final By tbSearch = By.cssSelector("input[data-qa-id='quickSearchInput']");
    private final By searchSuggestionsOverlay = By.xpath("//*[@id=\"plex\"]/div[2]/div/div[1]/div/div[2]");
    private final By searchSuggestionItems = By.cssSelector("div[data-qa-id='quickSearchItemButton']");
    //private final By searchSuggestionHubs = By.cssSelector("div[data-qa-id='quickSearchHub']");
    private final By menuItems = By.cssSelector("div[data-qa-id='sidebarSource']");
    //private final By menuItems = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/div/div/div[2]/a");

    public HomePage(WebDriver driver) {
        super(driver);
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

    public DetailPage clickFirstSearchSuggestionItem() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchSuggestionItems));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class*='spinner']")));
        WebElement firstSearchSuggestionItem = driver.findElements(searchSuggestionItems).get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchSuggestionItem));
        firstSearchSuggestionItem.click();
        return new DetailPage(driver);
    }

    public void selectItemFromMenu(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItems));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(menuItems).get(index)));
        driver.findElements(menuItems).get(index).click();
    }

    public MoviesAndShowsPage goToMoviesAndShows() {
        selectItemFromMenu(1);
        return new MoviesAndShowsPage(driver);
    }

    public void clickAccountButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        driver.findElement(accountButton).click();
    }

    public void signOut() {
        clickAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountMenuItems));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"id-13\"]/div/button[4]"))));
        driver.findElement(By.xpath("//*[@id=\"id-13\"]/div/button[4]")).click();
        //wait.until(ExpectedConditions.urlToBe("https://app.plex.tv/desktop#!/login"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[id='iFrameResizer0']")));
        //driver.switchTo().frame("iFrameResizer0");
    }
}
