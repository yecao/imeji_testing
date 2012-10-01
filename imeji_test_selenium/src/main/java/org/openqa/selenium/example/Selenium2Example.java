package org.openqa.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium2Example {
	static String imeji_instance_url = new String("http://localhost:8080/imeji/");
	static String username_admin = new String("admin@imeji.org");
	static String password_admin = new String("a_password");
	static String username = new String("cao@mpdl.mpg.de");
	static String password = new String("test");

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		WebDriver driver = new FirefoxDriver();
		Selenium2Example instance = new Selenium2Example();
		// instance.testSample(driver);
		instance.testCreateUser(driver);
		// Close the browser
		// driver.quit();

	}

	public void testSample(WebDriver driver) {
		// And now use this to visit Imeji server
		driver.get(imeji_instance_url);
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// Find the text input element by Xpath/name/id
		WebElement usernameField = driver.findElement(By
				.name("formular:Header:j_id24"));
		usernameField.clear();
		usernameField.sendKeys(username);
		WebElement passwordField = driver.findElement(By
				.name("formular:Header:j_id25"));
		passwordField.clear();
		passwordField.sendKeys(password);
		WebElement loginSubmitButton = driver.findElement(By
				.id("formular:Header:lnkLogin"));
		loginSubmitButton.click();
		// Check the title of the page
		System.out.println("After login, Page title is: " + driver.getTitle());
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
//		TODO verify psw wrong, show HTTP Status 404 ?
		//2.go to admin page
		
		//driver.get(imeji_instance_url + "imeji/");
		driver.findElement(By.id("formular:Header:lnkAdmin")).click();
		//3. go to create new user
		driver.findElement(By.linkText("Create new User")).click();
//		4. create user (send an email selected)
		driver.findElement(By.id("formular:inputEmailText")).clear();
		driver.findElement(By.id("formular:inputEmailText")).sendKeys("bobcaonjut@gmail.com");
		driver.findElement(By.id("formular:inputNameText")).clear();
		driver.findElement(By.id("formular:inputNameText")).sendKeys("Cao");
		driver.findElement(By.id("formular:inputNickText")).clear();
		driver.findElement(By.id("formular:inputNickText")).sendKeys("Ye_test");
//		Send an email checked
		driver.findElement(By.name("formular:j_id108")).click();
//		save
		driver.findElement(By.name("formular:j_id114")).click();
//	    TODO verify a) page display: User created successfully. 
//	    b)Username already exists. please choose another one. 
//		5. login with new user (via email link) TODO hard to implement?
//		6.change password
	}
}