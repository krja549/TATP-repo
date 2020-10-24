package be.ordina;

import be.ordina.pages.ConsentModal;
import be.ordina.pages.HomePage;
import be.ordina.pages.LoginModal;
import be.ordina.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class PlexStreamingTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private LoginModal loginModal;
    private HomePage homePage;
    private ConsentModal consent;

    /*
     * US2. As a user, I want to be able to start a stream directly from the home page.
     * Context: On the home page, a selection of movies will be shown. It should be
     * possible for a user to start a movie by clicking the play button in the thumbnail.
     * Acceptance criteria:
     * - Clicking the play button will start the video player
     * - The movie starts streaming
     */

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","/Users/krja/Documents/Work/3. Ordina/Training/AQuA/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        String uuid = UUID.randomUUID().toString();
        String emailAddress = uuid + "@mailinator.com";

        loginPage = new LoginPage(driver);

        loginModal = loginPage.clickSignupButton();
        loginModal.enterCredentials(emailAddress,"PlexTest123");

        homePage = loginModal.clickSubmitButton();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void clickingPlayBtnStartsVideoPlayer() {
        consent = homePage.playFirstMovie();
        consent.clickAgreeButton();
        homePage.waitForVideoPlayerToStart();

        assertTrue(driver.findElement(By.id("plex")).getAttribute("class").contains("show-video-player"));
    }
}
