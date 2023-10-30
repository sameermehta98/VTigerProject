package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class addProductsToCart {

	@DataProvider
	public Object[][] addProducts(){
		Object[][] send=new Object[2][3];
		send[0][0]="Samsung";
		send[0][1]="s20";
		send[0][2]=78000;
		
		send[1][0]="Apple";
		send[1][1]="15";
		send[1][2]=79999;
		
		return send;
	}
	
	@Test(dataProvider = "addProducts")
	public void test(String name, String model, int price) {
		System.out.println("Name is "+name+". Model is "+model+". Price is "+price);
	}
}
