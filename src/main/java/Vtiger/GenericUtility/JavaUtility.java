package Vtiger.GenericUtility;


import java.util.Date;
import java.util.Random;



public class JavaUtility {
	// comment
	/* multi line comment*/
	
	/**description
	 * The class consists of Generic methods related to java
	 *@author Chetankumar
	 */
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int value = r.nextInt(1000);
		return value;
	}
	
	public String getSystemDateInFormat() {
	
		Date d = new Date();          			 // java.util
		System.out.println(d.toString());
		String[] dArr = new  String[20];
		dArr = d.toString().split(" ");
		String date = dArr[2];
		System.out.println(date);
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInFormat = date+" "+month+" "+year+" "+time;
		return dateInFormat;
		
	}
}

