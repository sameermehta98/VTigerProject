package practice;

import org.testng.annotations.Test;

public class TestNGPractice {
	@Test(priority = 1)
	public void createTest() {
		System.out.println("create");
	}
	@Test(priority = 1)
	public void modifyTest() {
		System.out.println("modify");
	}
	@Test(priority = 3)
	public void deleteTest() {
		System.out.println("delete");
	}
	
	
	
}
