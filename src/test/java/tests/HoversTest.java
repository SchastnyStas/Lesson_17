package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HoversTest {
    @Test
    public void userProfileRedirectionTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();
        String hoverSite = "https://the-internet.herokuapp.com/hovers";
        driver.get(hoverSite);

        //user 1
        WebElement userProfile1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        actions.moveToElement(userProfile1).perform();
        WebElement nameLabel1 = driver.findElement(By.xpath("//h5[text() = 'name: user1']"));
        softAssert.assertTrue(nameLabel1.isDisplayed());
        WebElement viewProfileLink1 = driver.findElement(By.xpath("//*[@href=\"/users/1\"]"));
        actions.moveToElement(userProfile1).moveToElement(viewProfileLink1).click().perform();
        WebElement viewFalseLink1 = driver.findElement(By.xpath("//h1[text() = 'Not Found']"));
        softAssert.assertFalse(viewFalseLink1.isDisplayed());
        driver.get(hoverSite);
        //user2
        WebElement userProfile2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        actions.moveToElement(userProfile2).perform();
        WebElement nameLabel2 = driver.findElement(By.xpath("//h5[text() = 'name: user2']"));
        softAssert.assertTrue(nameLabel2.isDisplayed());
        WebElement viewProfileLink2 = driver.findElement(By.xpath("//*[@href=\"/users/2\"]"));
        actions.moveToElement(userProfile2).moveToElement(viewProfileLink2).click().perform();
        WebElement viewFalseLink2 = driver.findElement(By.xpath("//h1[text() = 'Not Found']"));
        softAssert.assertFalse(viewFalseLink2.isDisplayed());
        driver.get(hoverSite);
        //user3
        WebElement userProfile3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        actions.moveToElement(userProfile3).perform();
        WebElement nameLabel3 = driver.findElement(By.xpath("//h5[text() = 'name: user3']"));
        softAssert.assertTrue(nameLabel3.isDisplayed());
        WebElement viewProfileLink3 = driver.findElement(By.xpath("//*[@href=\"/users/3\"]"));
        actions.moveToElement(userProfile3).moveToElement(viewProfileLink3).click().perform();
        WebElement viewFalseLink3 = driver.findElement(By.xpath("//h1[text() = 'Not Found']"));
        softAssert.assertFalse(viewFalseLink3.isDisplayed());

        softAssert.assertAll();
        driver.close();
    }
}