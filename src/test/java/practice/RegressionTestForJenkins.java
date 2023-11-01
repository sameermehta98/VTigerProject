package practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class RegressionTestForJenkins extends BaseClass {
	
	@Test(groups = "regression")
	
	public void regressionDemo() {
		System.out.println("This is sample Regression Test");
	System.out.println("ok");
	}

}
