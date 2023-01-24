package Vtiger.practice1;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.BaseClass;

@Listeners(Vtiger.GenericUtility.ListenerImplimentationClass.class)
public class DemoTest extends BaseClass {
	
	@Test
	public void demoTest() throws InterruptedException {
		
		System.out.println("Demo");
		Thread.sleep(2000);
	}
	
	@Test
	public void sampleTest() throws InterruptedException {
		
		System.out.println("Sample");
		Thread.sleep(2000);
		Assert.fail();
	}
}
