package ranstad.com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ranstad.com.qa.base.TestBase;
import ranstad.com.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
 
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test(priority=1, enabled = true)
	public void pageTestMessage() {
		String message = homepage.verifytext();
		Assert.assertEquals(message, "get job alerts for this search");
	}
	
	
	@AfterMethod(enabled = false)
	public void teardown() {
		driver.quit();
	}
}
