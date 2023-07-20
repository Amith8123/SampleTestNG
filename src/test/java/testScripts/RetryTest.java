package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{
	private int retryCount=0;
	private static final int maxRetryCount =3;
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if (retryCount< maxRetryCount) {
				retryCount ++;
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

}
