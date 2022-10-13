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

public class NewsLetter {
	
	final static Logger logger=Logger.getLogger(NewsLetter.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public NewsLetter(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Newsletter Subscription')]")
	WebElement NewsletterSubscription;
	public void verifyNewsletterSubscription()
	{
		U.isElementPresent(NewsletterSubscription,30);
		String h = NewsletterSubscription.getText();
		try{
		Helper.highLightElement(Startup.wd,NewsletterSubscription);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "NewsletterSubscription");
		
		Assert.assertEquals(h, "Newsletter Subscription", "Newsletter Subscription is displayed");
		
			logger.info("NewsletterSubscription is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify NewsletterSubscription ","NewsletterSubscription is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("NewsletterSubscription is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify NewsletterSubscription ","NewsletterSubscription is not displayed ",""+screenshot_path+"");
		}
	}

	@FindBy(how=How.XPATH,using="//div[@class='right']/input[@value='Continue']")
	WebElement ContinueButton;
	public void clickContinueButton()
	{
		try{
		U.isElementPresent(ContinueButton,30);
		Helper.highLightElement(Startup.wd,ContinueButton);
		ContinueButton.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickContinueButton");
	
			logger.info("ContinueButton is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click ContinueButton ","ContinueButton is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("ContinueButton is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click ContinueButton ","ContinueButton is not clicked ",""+screenshot_path+"");
		}
	}

}
