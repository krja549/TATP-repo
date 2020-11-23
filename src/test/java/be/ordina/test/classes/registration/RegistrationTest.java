package be.ordina.test.classes.registration;

import be.ordina.test.classes.BaseTest;
import be.ordina.pages.HomePage;
import be.ordina.pages.LoginPage;
import be.ordina.pages.LoginModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {

    private WebDriver driver;

    /*
     * US1. As a user, I want to be able to create a new account.
     * Context: A new user can create an account by providing his email address and choosing a password.
     * Acceptance criteria:
     * - After registration, the user is automatically logged in
     * - The user is brought to the home page
     */

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","/Users/krja/Documents/Work/3. Ordina/Training/AQuA/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void homePageDisplayedAfterSuccessfulRegistration() {
        String uuid = UUID.randomUUID().toString();
        String emailAddress = uuid + "@mailinator.com";

        LoginPage loginPage = new LoginPage(driver);

        LoginModal loginModal = loginPage.clickSignupButton();
        loginModal.enterCredentials(emailAddress,"PlexTest123");

        HomePage homePage = loginModal.clickSubmitButton();

        //Acceptance criterion: The user is brought to the home page
        assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://app.plex.tv/desktop"));

        homePage.clickAccountButton();

        //Acceptance criterion: After registration, the user is automatically logged in
        assertTrue(driver.findElement(By.id("id-10")).isDisplayed());
    }

    @Test
    public void signOutAfterLogin() {
        String uuid = UUID.randomUUID().toString();
        String emailAddress = uuid + "@mailinator.com";

        LoginPage loginPage = new LoginPage(driver);

        LoginModal loginModal = loginPage.clickSignupButton();
        loginModal.enterCredentials(emailAddress,"PlexTest123");

        HomePage homePage = loginModal.clickSubmitButton();

        homePage.signOut();
    }
}
