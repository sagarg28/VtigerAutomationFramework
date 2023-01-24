package Vtiger.practice1;

import org.testng.annotations.Test;

public class DataProvider2 {
	
	@Test(dataProvider = "orgName")
	public void addProductTocartTest(String orgName,String indusType) {
		
		System.out.println(orgName+"  "+indusType);
	}
	
	@org.testng.annotations.DataProvider(name = "orgName")
	public Object[][] getData(){
		
		Object[][] data = new Object[4][2];
		
		data[0][0] = "abc";
		data[0][1] = "Education";
		
		
		data[1][0] = "def";
		data[1][1] = "Consulting";
		
		data[2][0] = "ghi";
		data[2][1] = "Electronics";
		
		data[3][0] = "jkl";
		data[3][1] = "Entertainment";
		
	//	
		return data;
		
	}
}
