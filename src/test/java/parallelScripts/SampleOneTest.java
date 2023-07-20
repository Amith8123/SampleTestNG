package parallelScripts;

import org.testng.annotations.Test;

public class SampleOneTest {
  @Test 
  public void testOne() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Test One in Sample One...."+id);
  }
  @Test (invocationCount = 8, threadPoolSize = 3, timeOut = 2000)
  public void testTwo() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Test two in Sample One...."+id);
  }
  @Test 
  public void testThree() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Test Three in Sample One...."+id);
  }
}
