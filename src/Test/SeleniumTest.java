package Test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    @Test
    public void waitForInputText(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost/waitforit.php");
        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));
        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }


}