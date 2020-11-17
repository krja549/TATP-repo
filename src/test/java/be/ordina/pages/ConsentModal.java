package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsentModal extends BasePage {

    private final By btnAgree = By.xpath("/html/body/div[2]/div/div/div/div[3]/div/button[2]/span[2]");

    public ConsentModal(WebDriver driver) {
        super(driver);
    }

    public void clickAgreeButton() {
        driver.findElement(btnAgree).click();
    }
}
