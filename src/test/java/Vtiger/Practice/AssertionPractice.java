package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void hardAssertTest1() {
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		//Assert.assertEquals(true,true);     // passed
		//Assert.assertEquals(true, false);  	// fail
		//Assert.assertTrue(true);  				// pass
		
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
	}
	
	
	@Test
	public void softAssertTest1() {
		
		SoftAssert sf = new SoftAssert();
		System.out.println("-------------------------softAssertTest1---------------------------------------");
		System.out.println("step 1");
		System.out.println("step 2");
		sf.assertEquals(true, true);  // pass
		System.out.println("step 3");
		System.out.println("step 4");
		sf.assertTrue(false);		// false        
		System.out.println("step 5");
		System.out.println("step 6");
		sf.assertAll();
	}
}
