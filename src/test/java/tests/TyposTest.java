package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TyposTest {
    @Test
    public void checkTyposTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement firstParagraph = driver.findElement(By.xpath("//p[1]"));
        String firstText = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        softAssert.assertEquals(firstText, firstParagraph.getText());
        WebElement secondParagraph = driver.findElement(By.xpath("//p[2]"));
        String secondText = "Sometimes you'll see a typo, other times you won,t.";
        softAssert.assertEquals(secondText, secondParagraph.getText(), "The text has spelling mistakes.");
        softAssert.assertAll();
        driver.close();
    }
}
