package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstMovieThumbnail = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/a");
    private final By accountButton = By.id("id-10");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void clickAccountButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        driver.findElement(accountButton).click();
    }

    public void playFirstMovie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstMovieThumbnail));
        wait.until(ExpectedConditions.elementToBeClickable(firstMovieThumbnail));
        driver.findElement(firstMovieThumbnail).click();
        WebElement consentModal = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
        wait.until(ExpectedConditions.visibilityOf(consentModal));
    }
}
