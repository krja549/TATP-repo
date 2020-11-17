package be.ordina.features.streaming;

import be.ordina.pages.ConsentModal;
import be.ordina.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class ClickingPlayBtnStartsVideoPlayerTest extends StreamingTest {

    /*
     * US2. As a user, I want to be able to start a stream directly from the home page.
     * Context: On the home page, a selection of movies will be shown. It should be
     * possible for a user to start a movie by clicking the play button in the thumbnail.
     * Acceptance criteria:
     * - Clicking the play button will start the video player
     * - The movie starts streaming
     */

    private HomePage homePage;
    private ConsentModal consent;

    @Test
    public void clickingPlayBtnStartsVideoPlayer() {
        homePage = getHomePage();

        consent = homePage.playFirstMovie();
        consent.clickAgreeButton();
        homePage.waitForVideoPlayerToStart();

        assertTrue(getDriver().findElement(By.id("plex")).getAttribute("class").contains("show-video-player"));
    }
}
