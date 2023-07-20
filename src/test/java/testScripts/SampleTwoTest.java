package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleTwoTest {
	WebDriver driver;
	@Parameters("browser")
//	@BeforeTest
	public void setup(String strbrowser) {
		if (strbrowser.equalsIgnoreCase("Chrome"))
		{
		 driver=new ChromeDriver();
		}
		if (strbrowser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		 
	}
	
	@Test(retryAnalyzer = RetryTest.class)
	  public void CypressSearchTest() {
		 driver=new ChromeDriver();
		  driver.get("https://www.google.com");
		WebElement searchText=driver.findElement(By.name("q"));
		SoftAssert softassert=new SoftAssert();
				softassert.assertEquals(driver.getTitle(), "Google");
		searchText.sendKeys("Cypress");
		searchText.submit();
		
		Assert.assertEquals(driver.getTitle(), "Cypress - Google page Search");
	softassert.assertAll();
	driver.close();
}
  }

