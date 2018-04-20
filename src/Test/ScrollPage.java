package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollPage {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://localhost/tabulka.php");
        driver.manage().window().maximize();
    }
    @Test
    public void testScrollTo(){
        WebElement lastRow = driver.findElement(By.xpath("//table/tbody//tr[5]"));
        System.out.printf(lastRow.getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",lastRow);
    }

    @After
    public void tearDown(){

    }
}
