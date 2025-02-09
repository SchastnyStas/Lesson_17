package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputsTest {
    @Test
    public void inputsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys(Keys.ARROW_UP);
        String actualText = inputField.getAttribute("value");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText, "1");
        inputField.sendKeys(Keys.ARROW_DOWN);
        String actualText2 = inputField.getAttribute("value");
        softAssert.assertEquals(actualText2, "0");
        softAssert.assertAll();
        driver.close();
    }
}
