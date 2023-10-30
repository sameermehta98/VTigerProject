package practice;

import org.testng.annotations.Test;

public class LoadDataFromCmdLine {
	
		@Test
		public void test1() {
			String USERNAME=System.getProperty("username");
			String PASSWORD=System.getProperty("password");
			
			System.out.println(USERNAME);
			System.out.println(PASSWORD);
		}
}
