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

public class ContactUs {

	final static Logger logger=Logger.getLogger(ContactUs.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();
	
	public ContactUs(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='captcha']")
	WebElement captchaText;
	
	@FindBy(how=How.XPATH,using="//input[@name='captcha']/following-sibling::img")
	WebElement captcha;
	public void verifyCaptcha() throws Exception {
		try{
		Thread.sleep(6000);	
		U.isElementPresent(captcha,30);
		Helper.highLightElement(Startup.wd,captcha);	
		Helper.highLightElement(Startup.wd,captchaText);
		
		System.out.println("----Reading captch image----");
		//String captchaImgText = Utility.captureScreenshotByElement(captcha,"captchaImg");
		String captchaImgText = Utility.captureScreenshotByElement();
		Thread.sleep(6000);
		System.out.println("Captcha enterd :-" + captchaImgText);
		captchaText.sendKeys(captchaImgText);
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifyCaptcha");
		logger.info("Captcha is verified and entered");			
		HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Captcha Text","Captcha is not verified and entered ",""+screenshot_path+"");

		}
		catch(Exception e)
		{
			e.getMessage();
			logger.error("Captcha is not verified and entered");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Captcha Text","Captcha is not verified and entered",""+screenshot_path+"");
		}
	}

	
	@FindBy(how=How.XPATH,using="//input[@name='name']")
	WebElement name;
	public void verifyName()
	{
		U.isElementPresent(name,30);		
		String n = name.getAttribute("value");
		System.out.println("name is -"+name);
		try{
		Helper.highLightElement(Startup.wd,name);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifyname");
		
		Assert.assertEquals(n, "ssss", "username text is verified");
		
			logger.info("username is verified");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Username text","Username text is verified ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("username is not verified");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Username text","Username text is not verified",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='email']")
	WebElement email;
	public void verifyEmail()
	{
		U.isElementPresent(email,30);
		String em = email.getAttribute("value");		
		System.out.println("email is -"+email);
		try{
		Helper.highLightElement(Startup.wd,email);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifyemail");
		
		Assert.assertEquals(em, "ssss@ssss.com", "email is verified");
		
			logger.info("email is verified");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Email ","Email is verified ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("email is not verified");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Email ","Email is not verified",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//textarea[@name='enquiry']")
	WebElement enquiry;
	public void enterEnquiry()
	{
		try{
		U.isElementPresent(enquiry,30);
		Helper.highLightElement(Startup.wd,enquiry);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enquiry");
		enquiry.sendKeys("This is to Change of Address/Phone number");
		
			logger.info("Clicked on Continue Button");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Type the Enquiry ","Enquiry is typed ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Success Message is not displayed:");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Type the Enquiry ","Enquiry is not typed",""+screenshot_path+"");
		}
	
	}
	
	@FindBy(how=How.XPATH,using="//input[@class='button'][@value='Continue']")
	WebElement ContinueButton;
	public void clickContinueButton()
	{
		try{
		U.isElementPresent(ContinueButton,30);
		Helper.highLightElement(Startup.wd,ContinueButton);			
		ContinueButton.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "ContinueButton");
		
			logger.info("Continue Button Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue Button ","Clicked continue button ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue Button not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue Button ","Continue button not clicked ",""+screenshot_path+"");
		}
		
	}
	
	
}
