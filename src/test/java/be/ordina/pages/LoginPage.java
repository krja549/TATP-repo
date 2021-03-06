package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By btnSignup = By.className("signup");
    private final By btnSignin = By.className("signin");
    private final By btnLaunch = By.className("launch");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.plex.tv/nl/");
        wait.until(ExpectedConditions.urlToBe("https://www.plex.tv/nl/"));
    }

    public LoginModal clickSignupButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignup));
        driver.findElement(btnSignup).click();
        return new LoginModal(driver);
    }

    public LoginModal clickSigninButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignin));
        driver.findElement(btnSignin).click();
        return new LoginModal(driver);
    }
    public HomePage clickLaunchButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLaunch));
        driver.findElement(btnLaunch).click();
        wait.until(ExpectedConditions.urlToBe("https://app.plex.tv/desktop"));
        return new HomePage(driver);
    }
}
