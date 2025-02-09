package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NotificationMessagesTest {

    @Test
    public void checkNotificationMessage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        WebElement clickHereLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href=\"/notification_message\"]")));
        clickHereLink.click();
        WebElement flashMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );
        Assert.assertTrue(flashMessage.getText().contains("Action successful"), "Click was not successful");
        driver.close();
    }
}


