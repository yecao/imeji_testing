package org.openqa.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium2Example {
	String baseUrl=new String("http://localhost:8080");
	static String imeji_instance_url = new String(
			"http://localhost:8080/imeji/");
	static String username_admin = new String("admin@imeji.org");
	static String password_admin = new String("a_password");
	static String username_user = new String("cao@mpdl.mpg.de");
	static String password_user = new String("test");

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		WebDriver driver = new FirefoxDriver();
		Selenium2Example instance = new Selenium2Example();
		 instance.testCollection(driver);
		//instance.testCreateUser(driver);
		// Close the browser
		 driver.quit();

	}

	public void testCollection(WebDriver driver) {
		// And now use this to visit Imeji server
		driver.get(imeji_instance_url);
//		1.login
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
		// Check the title of the page
		//System.out.println("After login, Page title is: " + driver.getTitle());
//		2.Create collection on collection pages (many users and organisations?)
		driver.findElement(By.id("formular:Header:lnkCollections")).click();
		driver.findElement(By.id("formular:lnkCreate")).click();
		driver.findElement(By.id("formular:inputTitleText")).clear();
		driver.findElement(By.id("formular:inputTitleText")).sendKeys("col_test");
		driver.findElement(By.id("formular:j_id99:0:inputFamiliyName")).clear();
		driver.findElement(By.id("formular:j_id99:0:inputFamiliyName")).sendKeys("cao");
		driver.findElement(By.id("formular:j_id99:0:inputGivenName")).clear();
		driver.findElement(By.id("formular:j_id99:0:inputGivenName")).sendKeys("ye");
		driver.findElement(By.id("formular:j_id99:0:j_id118:0:inputCreator")).clear();
		driver.findElement(By.id("formular:j_id99:0:j_id118:0:inputCreator")).sendKeys("MPDL");
		driver.findElement(By.name("formular:j_id99:0:j_id111")).click();
		driver.findElement(By.id("formular:j_id99:1:inputFamiliyName")).clear();
		driver.findElement(By.id("formular:j_id99:1:inputFamiliyName")).sendKeys("cao2");
		driver.findElement(By.id("formular:j_id99:1:inputGivenName")).clear();
		driver.findElement(By.id("formular:j_id99:1:inputGivenName")).sendKeys("ye2");
		driver.findElement(By.id("formular:j_id99:1:j_id118:0:inputCreator")).clear();
		driver.findElement(By.id("formular:j_id99:1:j_id118:0:inputCreator")).sendKeys("mpdl2");
		driver.findElement(By.name("formular:j_id99:1:j_id111")).click();
		driver.findElement(By.id("formular:j_id99:2:inputFamiliyName")).clear();
		driver.findElement(By.id("formular:j_id99:2:inputFamiliyName")).sendKeys("cao3");
		driver.findElement(By.id("formular:j_id99:2:inputGivenName")).clear();
		driver.findElement(By.id("formular:j_id99:2:inputGivenName")).sendKeys("ye3");
		driver.findElement(By.id("formular:j_id99:2:j_id118:0:inputCreator")).clear();
		driver.findElement(By.id("formular:j_id99:2:j_id118:0:inputCreator")).sendKeys("mpdl3");
		driver.findElement(By.name("formular:j_id99:0:j_id111")).click();
		driver.findElement(By.id("formular:j_id99:1:inputFamiliyName")).clear();
		driver.findElement(By.id("formular:j_id99:1:inputFamiliyName")).sendKeys("cao4");
		driver.findElement(By.id("formular:j_id99:1:inputGivenName")).clear();
		driver.findElement(By.id("formular:j_id99:1:inputGivenName")).sendKeys("ye4");
		driver.findElement(By.id("formular:j_id99:1:j_id118:0:inputCreator")).clear();
		driver.findElement(By.id("formular:j_id99:1:j_id118:0:inputCreator")).sendKeys("mpdl4");
		driver.findElement(By.name("formular:j_id134")).click();
//		3. Upload images
		driver.get(baseUrl + "/imeji/collections?q=");
		driver.findElement(By.cssSelector("b")).click();
		driver.findElement(By.id("formular:lnkUploadImages")).click();
		driver.findElement(By.id("uploader_browse")).click();
		driver.findElement(By.id("p178ejergv1hvef53160s1tajilq0_html5")).clear();
//		TODO how to select image/ HTML5 drag image?
//		remotewebdriver http://stackoverflow.com/questions/8851051/selenium-webdriver-and-browsers-select-file-dialog
		driver.findElement(By.id("p178ejergv1hvef53160s1tajilq0_html5")).sendKeys("");
		//now click the button to finish
		driver.findElement(By.linkText("Start upload")).click();
		//TODO verify success text on page:e.g., 1 files uploaded successfully: 20120827_135439 (Small).jpg

	}

	public void testCreateUser(WebDriver driver) {
		// 1. login as system administrator
		// And now use this to visit Imeji server
		driver.get(imeji_instance_url);
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// Find the text input element by Xpath/name/id
		WebElement usernameField = driver.findElement(By
				.name("formular:Header:j_id24"));
		usernameField.clear();
		usernameField.sendKeys(username_admin);
		WebElement passwordField = driver.findElement(By
				.name("formular:Header:j_id25"));
		passwordField.clear();
		passwordField.sendKeys(password_admin);
		WebElement loginSubmitButton = driver.findElement(By
				.id("formular:Header:lnkLogin"));
		loginSubmitButton.click();
		// TODO verify psw wrong, show HTTP Status 404 ?
		// 2.go to admin page

		// driver.get(imeji_instance_url + "imeji/");
		driver.findElement(By.id("formular:Header:lnkAdmin")).click();
		// 3. go to create new user
		driver.findElement(By.linkText("Create new User")).click();
		// 4. create user (send an email selected)
		driver.findElement(By.id("formular:inputEmailText")).clear();
		driver.findElement(By.id("formular:inputEmailText")).sendKeys(
				"bobcaonjut@gmail.com");
		driver.findElement(By.id("formular:inputNameText")).clear();
		driver.findElement(By.id("formular:inputNameText")).sendKeys("Cao");
		driver.findElement(By.id("formular:inputNickText")).clear();
		driver.findElement(By.id("formular:inputNickText")).sendKeys("Ye_test");
		// Send an email checked
		driver.findElement(By.name("formular:j_id108")).click();
		// save
		driver.findElement(By.name("formular:j_id114")).click();
		// TODO verify a) page display: User created successfully.
		// b)Username already exists. please choose another one.
		// 5. login with new user (via email link) TODO hard to implement?
//		http://www.seleniumtests.com/2011/08/verify-email-confirmation-using.html
		// 6.change password
	}


}