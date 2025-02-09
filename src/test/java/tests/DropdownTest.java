package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DropdownTest {

    @Test
    public void checkOptionsPresenceTest() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = dropdown.getOptions();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(options.isEmpty(), "Список опций пуст!");
        softAssert.assertAll();
        driver.close();
    }

    @Test
    public void checkFirstSelectTest() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        SoftAssert softAssert = new SoftAssert();
        dropdown.selectByValue("1");
        WebElement firstOption = dropdown.getFirstSelectedOption();
        softAssert.assertEquals("Option 1", firstOption.getText());
        softAssert.assertAll();
        driver.close();
    }


    @Test
    public void checkSecondSelectTest() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        SoftAssert softAssert = new SoftAssert();
        dropdown.selectByValue("2");
        WebElement secondOption = dropdown.getFirstSelectedOption();
        softAssert.assertEquals("Option 2", secondOption.getText());
        softAssert.assertAll();
        driver.close();
    }
}
