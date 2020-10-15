package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By btnSignup = By.className("signup");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.plex.tv/nl/");
        wait.until(ExpectedConditions.urlToBe("https://www.plex.tv/nl/"));
    }

    public LoginModal clickSignupButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignup));
        driver.findElement(btnSignup).click();
        return new LoginModal(driver);
    }
}
