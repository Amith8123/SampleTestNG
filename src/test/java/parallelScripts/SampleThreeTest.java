package parallelScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
	  @Test 
	  public void testOne() {
		  long id=Thread.currentThread().getId();
		  System.out.println("Test One in Sample Three...."+id);
	  }
	  @Test 
	  public void testTwo() {
		  long id=Thread.currentThread().getId();
		  System.out.println("Test two in Sample Three...."+id);
	  }
	  @Test 
	  public void testThree() {
		  long id=Thread.currentThread().getId();
		  System.out.println("Test Three in Sample Three...."+id);
	  }
}
