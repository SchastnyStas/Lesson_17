package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @Test
    public void checkCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement element = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        if (!element.isSelected()) {
            element.click();
        }
        Assert.assertTrue(element.isSelected());
        driver.close();
    }

    @Test
    public void uncheckCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        Assert.assertFalse(checkbox.isSelected());
        driver.close();
    }
}
