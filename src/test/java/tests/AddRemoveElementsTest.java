package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest {

    @Test
    public void addRemoveElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//*[@onclick=\"addElement()\"]")).click();
        driver.findElement(By.xpath("//*[@onclick=\"addElement()\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"added-manually\"]")).click();
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='elements']/button"));
        int size = buttons.size();
        int expectedSize = 1;
        Assert.assertEquals(size, expectedSize);
        driver.close();

    }
}
