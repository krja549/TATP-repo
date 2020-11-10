package be.ordina;

import be.ordina.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PlexSearchTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private LoginModal loginModal;
    private HomePage homePage;
    private ConsentModal consent;
    private By searchSuggestions = By.xpath("//*[@id=\"plex\"]/div[2]/div/div[1]/div/div[2]");
    private By content = By.id("content");

    /*
     * US3. As a user, I want to be able to search for a specific movie.
     * Context: A user should be able to perform a search using the search field in the
     * header of the web application.
     * Acceptance criteria:
     * - Suggestions will be shown related to the entered search criteria
     * - Clicking on a suggestion will open the correct detail page
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

        loginModal = loginPage.clickSigninButton();
        loginModal.enterCredentials("kris.janssen@mailinator.com","PlexTest123");

        loginPage = loginModal.clickLoginButton();
        homePage = loginPage.clickLaunchButton();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void suggestionsRelatedToEnteredCriteriaAreShown() {
        homePage.enterSearchCriteria("Ricky Gervais");

        assertTrue(driver.findElement(searchSuggestions).isDisplayed());
    }

    @Test
    public void clickOnASearchSuggestion() throws InterruptedException {
        homePage.enterSearchCriteria("Ricky Gervais");
        DetailPage detailPage = homePage.clickFirstSearchSuggestionItem();

        assertTrue(driver.findElement(content).isDisplayed());
    }
}
