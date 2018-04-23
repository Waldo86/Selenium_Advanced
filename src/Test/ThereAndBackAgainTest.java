package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThereAndBackAgainTest {
    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void SetUp (){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("http://localhost/tabulka.php");
        driver.manage().window().maximize();
    }
    @Test
    public void testScroll(){
        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,200)");
        }
    }

    @Test
    public void testScrollToEnd() {
        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        js.executeScript("window.scrollBy(0," + bodyHeight + ")");
    }

    @After
    public void tarDown(){
        //driver.close();
    }
}
