package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class GooglePageTest {
	
		 WebDriver driver;
		 ExtentReports extentReport;
		 ExtentSparkReporter sparkReport;
		 ExtentTest extentTest;
		// @BeforeMethod
		
		 @BeforeMethod
		 public void setup() {
			 extentReport=new ExtentReports();
			sparkReport=new ExtentSparkReporter("test-output/SparkReport.html");
			extentReport.attachReporter(sparkReport);
			 driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 }
		 
		 @Test
		  public void javaSearchTest() {
			 extentTest = extentReport.createTest("Java Tutorial");
			driver.get("https://www.google.com");
			WebElement searchText=driver.findElement(By.name("q"));
			searchText.sendKeys("Java Tutorial");
			searchText.submit();
			Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	 }
  @Test
  public void gitSearchTest() {

	  extentTest = extentReport.createTest("Git Hub Tutorial");
		
		driver.get("https://www.google.com");
		WebElement searchText1=driver.findElement(By.name("q"));
		searchText1.sendKeys("Git hub");
		searchText1.submit();
		Assert.assertEquals(driver.getTitle(), "Git hub - Google Search");
		
  }
  
  @Test
  public void appiumSearchTest() {

	  extentTest = extentReport.createTest("Appium");
		
		driver.get("https://www.google.com");
		WebElement searchText1=driver.findElement(By.name("q"));
		searchText1.sendKeys("Appium");
		searchText1.submit();
		Assert.assertEquals(driver.getTitle(), "Appi - Google Search");
		
  }
  
  @AfterTest
  public void finishExtent() {
	  extentReport.flush();
  }
  
 @AfterMethod
  public void generateReport(ITestResult result)
  {
	 if(result.getStatus()==ITestResult.FAILURE)
	 {
		 extentTest.fail(result.getThrowable().getMessage());
	 String path=utility.Screenshot.getSceenshotPath(driver);
	 extentTest.addScreenCaptureFromPath(path);
	 }
	  driver.close();
  
  }
  
  
}
