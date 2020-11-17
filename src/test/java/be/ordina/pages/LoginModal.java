package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginModal extends BasePage {

    By tbEmail = By.id("email");
    By tbPassword = By.id("password");
    By btnSubmit = By.xpath("//*[@id=\"plex\"]/div/div/div/div[1]/form/button");

    public LoginModal(WebDriver driver) {
        super(driver);
        this.driver.switchTo().frame("fedauth-iFrame");
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.tbEmail));
        driver.findElement(this.tbEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.tbPassword));
        driver.findElement(this.tbPassword).sendKeys(password);
    }

    public void enterCredentials(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    public HomePage clickSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit));
        driver.findElement(btnSubmit).click();
        wait.until(ExpectedConditions.urlToBe("https://app.plex.tv/desktop"));
        return new HomePage(driver);
    }
    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSubmit));
        driver.findElement(btnSubmit).click();
        wait.until(ExpectedConditions.urlToBe("https://www.plex.tv/nl/?signUp=0"));
        return new LoginPage(driver);
    }
}
