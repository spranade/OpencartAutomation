package wipro.opencart.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import wipro.opencart.config.Startup;
import wipro.opencart.library.Helper;
import wipro.opencart.library.Utility;
import wipro.opencart.results.HTMLReportGenerator;

public class ProductComparison {
	
	final static Logger logger=Logger.getLogger(ProductComparison.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();
	
	public ProductComparison(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='content']/table//a[contains(text(),'iPhone')]")
	WebElement iphone;
	
	public void clickPhone()
	{
		try{
		U.isElementPresent(iphone,30);
		Helper.highLightElement(Startup.wd, iphone);
		
		iphone.click();
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickPhone");
		
			logger.info("phone link Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click phone ","Clicked phone ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("phone link not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click phone ","phone not clicked ",""+screenshot_path+"");
		}
	}
	
	
	
	

}
