package testScripts;

import org.testng.annotations.Test;

public class SampleFourTest {
  @Test (groups="featureOne")
  public void testOne() {
	  System.out.println("Test 41 in Sample Four");
  }
  @Test(groups="featureTwo")
  public void testTwo() {
	  System.out.println("Test 42 in Sample Four");
  }
  @Test(groups="featureThree")
  public void testThree() {
	  System.out.println("Test 43 in Sample Four");
  }
  @Test(groups="featureFour")
  public void testFour() {
	  System.out.println("Test 44 in Sample Four");
  }
}
