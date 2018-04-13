package Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/minions.php");
        driver.manage().window().maximize();
    }

    @Test
    public void waitForMinions() {
        int numberOfMinions = 8;
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(numberOfMinions));
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-warning')]")).click();
        new WebDriverWait(driver, 10)
                .withMessage("Nespravny pocet Mimonov, je ich" + numberOfMinions)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"), numberOfMinions));
        Assert.assertEquals(numberOfMinions, driver.findElements(By.xpath("//div[@class='minions']//img")).size());

    }

    @After
    public void tearDown() {
        driver.close();

    }
}
