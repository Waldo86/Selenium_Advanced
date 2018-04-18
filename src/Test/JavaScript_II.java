package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScript_II {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://localhost/waitforit.php");
        driver.manage().window().maximize();
    }
    @Test
    public void blurTest(){
        driver.findElement(By.id("waitForBlur")).sendKeys("akafukafundelukafundekavakevenduka");
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur()",driver.findElement(By.id("waitForBlur")));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForBlur")), "value", "blured!"));
    }
    @Test
    public void testClick(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",driver.findElement(By.id("startWaitForText")));
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForTextInput")), "value", "dary !!!"));
    }

    @After
    public void tearDown(){
     driver.close();
    }
}
