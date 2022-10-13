package wipro.opencart.pages;

import org.apache.log4j.Logger;
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

public class successEnquiry {

	final static Logger logger = Logger.getLogger(successEnquiry.class);
	String screenshot_path;
	Utility U = new Utility();
	
	public successEnquiry(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//div[@id='content']/p[contains(text(),'Your enquiry has been successfully sent to the store owner!')]")
	WebElement enquirySuccessMsg;
	public void verifyEnquirySuccessMsg()
	{
		try{
		U.isElementPresent(enquirySuccessMsg,30);
		Helper.highLightElement(Startup.wd,enquirySuccessMsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enquirySuccessMsg");
		String h = enquirySuccessMsg.getText();
		Assert.assertEquals(h, "Your enquiry has been successfully sent to the store owner!", "enquirySuccessMsg message is displayed");
		
			logger.info("enquirySuccessMsg Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify enquirySuccessMsg Message ","enquirySuccessMsg Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("enquirySuccessMsg Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify enquirySuccessMsg Message ","enquirySuccessMsg Message is not displayed ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='content']//div/a[contains (text(),'Continue')]")
	WebElement clickContinue;
	public void clickContinue()
	{
		try{
		U.isElementPresent(clickContinue,30);
		Helper.highLightElement(Startup.wd,clickContinue);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickContinuebutton");
		
			logger.info("Continue Button Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue Button ","Clicked continue button ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue Button not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue Button ","Continue button not clicked ",""+screenshot_path+"");
		}
		clickContinue.click();
	}
	
	


	
	
}
