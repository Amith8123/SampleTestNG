package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.emulation.Emulation;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Headers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeTest
	public void setup() {
		driver= new ChromeDriver();
		devTools=driver.getDevTools();
		devTools.createSession();
		
	}
 
//@Test
  public void deviceModeTest() {
	  @SuppressWarnings("rawtypes")
	Map deviceMetrics=new HashMap() {{
	put("width", 600);
	put("height",  1000);
	put("deviceScaleFactor",  50); 
	  put("mobile",  true);	  
	  }};
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	  driver.get("https://www.selenium.dev/");
	  
  }
//@Test
public void geoLoc() {
	devTools.send(Emulation.setGeolocationOverride(
			Optional.of(36.7728),
			Optional.of(-199.4),
			Optional.of(100)));
	
	
	driver.get("https://oldnavy.gap.com/stories");
}
@Test

public void basicAuthTest() {
	devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	Map<String, Object> headers=new HashMap<>();
	String strUser="admin";
	String strPwd="admin";
	
	//Basic YWRtaW46YWRtaW4=
			String basicAuth="Basic " +new String(new Base64().encode
					(String.format("%s:%s", strUser, strPwd).getBytes()));
	
	System.out.println("Auth.......+ " +basicAuth);
	//Set Header-AuthToken
	headers.put("Authorization", basicAuth);
	devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
	
	driver.get("https://the-internet.herokuapp.com/basic_auth");
	WebElement strMsg= driver.findElement(By.cssSelector("div.example p"));
	Assert.assertEquals(strMsg, "Congratulations! You must have the proper credentials");
	
}


}
