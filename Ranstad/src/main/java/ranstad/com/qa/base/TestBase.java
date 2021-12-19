package ranstad.com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ranstad.com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public String projectpath = System.getProperty("user.dir", "dirctName");
	

	
	public TestBase(){
		try {
			prop = new Properties();
			System.out.println(projectpath);
			FileInputStream ip = new FileInputStream(projectpath + "\\src\\main\\java\\ranstad\\com"  + "\\qa\\config\\properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		String projectpath = System.getProperty("user.dir", "dirctName");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",  projectpath +"\\driver\\chromeDriver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", projectpath + "\\driver\\geckoDriver\\geckodriver.exe");	
			driver = new FirefoxDriver();  
		}
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}