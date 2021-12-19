package ranstad.com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ranstad.com.qa.base.TestBase;
import ranstad.com.qa.util.TestUtil;

public class HomePage extends TestBase {
    
	  @FindBy(xpath="//a[normalize-space()='get job alerts for this search']")
	  WebElement getAlerText;
	  
	  @FindBy(xpath="//input[@placeholder='job title or keyword']")
	  WebElement enterJobName;
	  
	  
	  @FindBy(xpath=".//span[contains(text(),'search')and contains(text(),'jobs')]")
	  WebElement searchbtn;
	  
	  @FindBy(xpath="//div[@class='form-group hidden--until-l']//button/span[@class='button__text']")
	  WebElement countResearch;
	  
	  // intializing OR
	  public HomePage() {
		  
		  PageFactory.initElements(driver, this);
	  }
	  
	  //Actions:
	  
	  public String verifytext() { 
		  return getAlerText.getText();
	  }
	  
	  public void searchName(String jobname) throws InterruptedException {
		  enterJobName.click();
		  enterJobName.sendKeys(jobname);
		  System.out.println(jobname);
		  Thread.sleep(3000);
		  searchbtn.click();
	  }
	  
	public  int fetchSearchNumber() {
		String countJobsWithtext = countResearch.getText();
		String numberOnly = countJobsWithtext.replaceAll("[^0-9]", "");
		System.out.println(numberOnly);
		return Integer.parseInt(numberOnly);
	}
		  
}
