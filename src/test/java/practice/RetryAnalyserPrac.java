package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPrac {

	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void demo1() {
		Assert.fail();
	}
}
