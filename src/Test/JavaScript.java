package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class JavaScript {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://localhost/tabulka.php");
        driver.manage().window().maximize();
    }

    @Test
    public void testHighLight(){
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Florian")){
                highLight(row);
            }
        }
    }

    private Object highLight(WebElement row) {
        return ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px red solid'",row);
    }

    @After
    public void tearDown(){
        driver.close();

    }
}
