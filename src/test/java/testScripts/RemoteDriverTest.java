package testScripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteDriverTest {
	WebDriver driver;
  @Test
  public void test() throws IOException {
	  ChromeOptions options =new ChromeOptions();
	  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	  String strHub="http://172.31.23.236:4444";
	  driver=new RemoteWebDriver(new URL(strHub), options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");
	  WebElement searchbox=driver.findElement(By.name("q"));
	  searchbox.sendKeys("Java Tutorial");
	  searchbox.submit();
	  System.out.println("Page title" +driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  
	  //java -jar selenium-server-4.10.0.jar standalone
	  
	  
  }
}
