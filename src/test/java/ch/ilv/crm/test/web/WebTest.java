package ch.ilv.crm.test.web;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ch.ilv.crm.web.CrmApp;

public class WebTest {

	private WebDriver driver;
	
	@BeforeClass
	public static void startUp() {
		CrmApp.main(null);
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test
	public void createCustomer() {
		driver.get("http://localhost:7070/");
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("User");
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Test");
		WebElement save = driver.findElement(By.cssSelector("p:nth-child(9) > input"));
		save.click();

		WebElement confirmationElement = driver.findElement(By.xpath("//span[.='Customer User Test saved!']"));
		String confirmation = confirmationElement.getText();
		String confirmationSuccess = "Customer User Test saved!";

		assertEquals(confirmation, confirmationSuccess);

		WebElement find = driver.findElement(By.name("customerId"));
		find.sendKeys("0");
		WebElement search = driver.findElement(By.cssSelector("p:nth-child(4) > input"));
		search.click();

		WebElement firstnameElement = driver.findElement(By.cssSelector("span:nth-child(4)"));
		String firstnameTry = firstnameElement.getText();
		String firstnameSuccess = "Firstname: User";
		assertEquals(firstnameTry, firstnameSuccess);

		WebElement nameElement = driver.findElement(By.cssSelector("span:nth-child(6)"));
		String nameTry = nameElement.getText();
		String nameSuccess = "Name: Test";
		assertEquals(nameTry, nameSuccess);
	}
	
	@After
	public void finish() {
		driver.quit();
	}

}
