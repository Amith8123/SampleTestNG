package testScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test(groups="featureOne")
  public void testOne() {
	  System.out.println("Test 31 in Sample three");
  }
  @Test(groups="featureTwo")
  public void testTwo() {
	  System.out.println("Test 32 in Sample three");
  }
  @Test(groups="featureThree")
  public void testThree() {
	  System.out.println("Test 33 in Sample three");
  }
  @Test(groups="featureFour")
  public void testFour() {
	  System.out.println("Test 34 in Sample three");
  }
}
