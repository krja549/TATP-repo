package be.ordina.test.classes;

import be.ordina.pages.HomePage;
import be.ordina.pages.LoginModal;
import be.ordina.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private LoginModal loginModal;
    private HomePage homePage;

    // initialize a browser driver, connect to servers
    @Before
    public void setUpBeforeTestClass() {
        System.setProperty("webdriver.chrome.driver","/Users/krja/Documents/Work/3. Ordina/Training/AQuA/webdrivers/chromedriver 2");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    // automatically logs in an existing account
    public void signInBeforeTestMethod() {
        loginPage = new LoginPage(driver);

        loginModal = loginPage.clickSigninButton();
        loginModal.enterCredentials("kris.janssen@mailinator.com", "PlexTest123");

        loginPage = loginModal.clickLoginButton();
        homePage = loginPage.clickLaunchButton();
    }

    // creates a random user account and automatically logs it in
    public void signUpBeforeTestMethod() {
        loginPage = new LoginPage(driver);

        loginModal = loginPage.clickSignupButton();
        loginModal.enterCredentials(UUID.randomUUID().toString() + "@mailinator.com", "PlexTest123");

        homePage = loginModal.clickSubmitButton();
    }

    // logout of the app
    public void signOutAfterTestMethod() {
        homePage.signOut();
    }

    // close connections, close browser
    @After
    public void tearDownAfterTestClass() {
        driver.quit();
    }

    // Some getters and setters we need throughout our tests
    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
