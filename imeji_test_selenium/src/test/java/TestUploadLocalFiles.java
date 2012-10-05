import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUploadLocalFiles {
	private WebDriver driver;
	String baseUrl=new String("http://dev-faces.mpdl.mpg.de");
	static String username_user = new String("cao@mpdl.mpg.de");
	static String password_user = new String("test");

	static String filename = new String("C:/Users/cao/Downloads/test1.jpg");

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@Test
	public void test() {
		// And now use this to visit Imeji server
		driver.get(baseUrl + "/imeji/");
//				1.login
		// Find the text input element by Xpath/name/id
		WebElement usernameField = driver.findElement(By
				.name("formular:Header:j_id24"));
		usernameField.clear();
		usernameField.sendKeys(username_user);
		WebElement passwordField = driver.findElement(By
				.name("formular:Header:j_id25"));
		passwordField.clear();
		passwordField.sendKeys(password_user);
		WebElement loginSubmitButton = driver.findElement(By
				.id("formular:Header:lnkLogin"));
		loginSubmitButton.click();
		

//		driver.findElement(By.id("formular:Header:lnkCollections")).click();
		//TODO replace with collection name
//		driver.findElement(By.xpath("//span[@id='formular:ajaxList']/div/ol/li[3]/div/span[5]/a/b")).click();
//		driver.findElement(By.id("formular:lnkUploadImages")).click();

		driver.get(baseUrl + "/imeji/collection/325/upload?init=1");
		driver.findElement(By.id("uploader_browse")).sendKeys(filename);

		
		
//		driver.findElement(By.id("p178ejergv1hvef53160s1tajilq0_html5")).sendKeys(filename);
		// now click the button to finish
		driver.findElement(By.linkText("Start upload")).click();
//		Assert.assertEquals("darkbulb.jpg (image/jpeg)", driver.findElement(By.tagName("p")).getText());
//		 assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
}
