/*
 * handle upload file from remote 
 */

import java.net.URL;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestingUploadSe2Sauce extends TestCase {
    private RemoteWebDriver driver;
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
        capabillities.setCapability("version", "7");
        capabillities.setCapability("platform", Platform.XP);
        capabillities.setCapability("selenium-version", "2.18.0");
        capabillities.setCapability("name", "Remote File Upload using Selenium 2's FileDetectors");

        driver = new RemoteWebDriver(
           new URL("http://<username>:<api-key>@ondemand.saucelabs.com:80/wd/hub"),
           capabillities);
        driver.setFileDetector(new LocalFileDetector());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testSauce() throws Exception {
        driver.get("http://sso.dev.saucelabs.com/test/guinea-file-upload");
        WebElement upload = driver.findElement(By.id("myfile"));
        upload.sendKeys("/Users/sso/the/local/path/to/darkbulb.jpg");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.tagName("img"));
        Assert.assertEquals("darkbulb.jpg (image/jpeg)", driver.findElement(By.tagName("p")).getText());
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}