package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPrac {
	
	
	@Test
	public void prac1() {
		
		
		System.out.println("hi 1");
		
		System.out.println("hi 2");
		Assert.assertEquals(1, 2);
		System.out.println("hi 3");
		
		System.out.println("hi 4");
		
		
	}
@Test
public void prac2() {
		
		
		System.out.println("hi 1");
		
		System.out.println("hi 2");
		SoftAssert sa=new SoftAssert();
		System.out.println("hi 3");
		sa.assertEquals(false, true);
		System.out.println("hi 4");
		sa.assertEquals(1, 4);
		sa.assertAll();
	}
	
	
	
	
	
	
	
}
