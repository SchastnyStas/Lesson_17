package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SortableDataTablesTest {
    @Test
    public void checkTablesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> priceCells = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr/td[4]"));
        for (WebElement priceCell : priceCells) {
            softAssert.assertTrue(priceCell.getText().startsWith("$"));
        }
        WebElement cellOne = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[1]/td[1]"));
        String cellOneText = "Smith";
        softAssert.assertEquals(cellOneText, cellOne.getText());
        WebElement cellSecond = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[2]/td[2]"));
        String cellSecondText = "Frank";
        softAssert.assertEquals(cellSecondText, cellSecond.getText());
        WebElement cellThird = driver.findElement(By.xpath("//table[@id=\"table2\"]/tbody/tr[3]/td[3]"));
        String cellThirdText = "jdoe@hotmail.com";
        softAssert.assertEquals(cellThirdText, cellThird.getText());
        WebElement cellFourth = driver.findElement(By.xpath("//table[@id=\"table2\"]/tbody/tr[4]/td[5]"));
        String cellFourthText = "http://www.timconway.com";
        softAssert.assertEquals(cellFourthText, cellFourth.getText());
        softAssert.assertAll();
        driver.close();
    }
}