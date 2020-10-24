package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstMovieThumbnail = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a");
    private final By accountButton = By.id("id-10");

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
}
