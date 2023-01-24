package Vtiger.practice1;

import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;

public class DataProvider {

	
		
		@Test(dataProvider = "getData")
		public void addProductTocartTest(String phone,int price,String model) {
			
			System.out.println(phone+" "+price+" "+model);
		}
		
		@org.testng.annotations.DataProvider
		public Object[][] getData(){
			
			Object[][] data = new Object[2][3];
			
			data[0][0] = "Samsung";
			data[0][1] = 1200;
			data[0][2] = "A80";
			
			data[1][0] = "Iphone";
			data[1][1] = 1500;
			data[1][2] = "S13";
			
			return data;
			
		}
		
		
	

}
