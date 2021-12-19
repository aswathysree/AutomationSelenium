package ranstad.com.qa.pages;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ranstad.com.qa.base.TestBase;
import ranstad.com.qa.util.TestUtil;

public class LandingPageJoinOurTeam extends TestBase {

	// OR : Page Factory

	@FindBy(xpath = "//*[@class='navigation__menu-item']/a[text()='join our team']")
	WebElement textjointeam;

	@FindBy(xpath = "//div[@class='content-block__split']//a[@class='button'][normalize-space()='our jobs']")
	WebElement ourjobbtn;

	// intializing the page objects
	public LandingPageJoinOurTeam() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String ValidateLandingPageTitle() {
		return driver.getTitle();
	}

	public void clickJoinOurteam() {
		textjointeam.click();
		// to perform Scroll on application using Selenium
		TestUtil.jsExecutorScrollToView(ourjobbtn);
	}

	public void navigateToFindJobs() {
		ourjobbtn.click();
	}
}
