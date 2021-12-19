package ranstad.com.qa.testcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ranstad.com.qa.base.TestBase;
import ranstad.com.qa.pages.HomePage;
import ranstad.com.qa.pages.LandingPageJoinOurTeam;

public class LandingPageTest extends TestBase{
	LandingPageJoinOurTeam landingPageJoinOurTeam;
	HomePage  homePage;
	
	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		landingPageJoinOurTeam = new LandingPageJoinOurTeam();	
		homePage = new HomePage();
	}
	
	@Test(priority=1, enabled = false)
	public void landingPageTitleTest() {
		String title = landingPageJoinOurTeam.ValidateLandingPageTitle();
		Assert.assertEquals(title, "Randstad Australia | Leading Specialist Recruitment Agency");
	}
	@Test(priority=2)
	public void naviagteToSearchTest() throws InterruptedException {
		landingPageJoinOurTeam.clickJoinOurteam();
		landingPageJoinOurTeam.navigateToFindJobs();
		String message = homePage.verifytext();
		Assert.assertEquals(message, "get job alerts for this search");
		homePage.searchName("consultant");
		homePage.fetchSearchNumber();
		
		List<WebElement> openJobsList = driver.findElements(By.xpath("//div[@class='cards']//ul//h3"));	    
	    Assert.assertEquals(homePage.fetchSearchNumber(), openJobsList.size());
	}
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
}
