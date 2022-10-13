package wipro.opencart.pages;

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

public class CheckOut {
	
	final static Logger logger=Logger.getLogger(CheckOut.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public CheckOut(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	
	
	
	@FindBy(how=How.XPATH,using="//input[@id='button-payment-address'][@value='Continue']")
	WebElement Continue1;
	public void clickContinue1()
	{
		try{
		U.isElementPresent(Continue1,30);
		Helper.highLightElement(Startup.wd, Continue1);
		
		Continue1.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Continue1");
		
			logger.info("Continue1 Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue1 ","Continue1 clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue1 not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue1 ","Continue1 not clicked ",""+screenshot_path+"");
		}
	}
	

	@FindBy(how=How.XPATH,using="//input[@id='button-shipping-address'][@value='Continue']")
	WebElement Continue2;
	public void clickContinue2()
	{
		try{
		U.isElementPresent(Continue2,30);
		Helper.highLightElement(Startup.wd, Continue2);
		
		Continue2.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Continue2");
		
			logger.info("Continue2 Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue2 ","Continue2 clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue2 not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue2 ","Continue2 not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='button-shipping-method'][@value='Continue']")
	WebElement Continue3;
	public void clickContinue3()
	{
		try{
		U.isElementPresent(Continue3,30);
		Helper.highLightElement(Startup.wd, Continue3);
		
		Continue3.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Continue3");
		
			logger.info("Continue3 Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue3 ","Continue3 clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue3 not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue3 ","Continue3 not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='agree'][@type='checkbox']")
	WebElement AgreeTerms;
	public void clickAgreeTerms()
	{
		try{
		U.isElementPresent(AgreeTerms,30);
		Helper.highLightElement(Startup.wd, AgreeTerms);
		
		AgreeTerms.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "AgreeTerms");
		
			logger.info("AgreeTerms Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click AgreeTerms ","AgreeTerms clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("AgreeTerms not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click AgreeTerms ","AgreeTerms not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='button-payment-method'][@value='Continue']")
	WebElement Continue4;
	public void clickContinue4()
	{
		try{
		U.isElementPresent(Continue4,30);
		Helper.highLightElement(Startup.wd, Continue4);
		
		Continue4.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Continue4");
		
			logger.info("Continue4 Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue4 ","Continue4 clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue4 not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue4 ","Continue4 not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='button-confirm'][@value='Confirm Order']")
	WebElement ConfirmButton;
	public void clickConfirmButton()
	{
		try{
		U.isElementPresent(ConfirmButton,30);
		Helper.highLightElement(Startup.wd, ConfirmButton);
		
		ConfirmButton.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "ConfirmButton");
		
			logger.info("ConfirmButton Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click ConfirmButton ","ConfirmButton clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("ConfirmButton not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click ConfirmButton ","ConfirmButton not clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Your Order Has Been Processed!')]")
	WebElement orderSuccessMsg;
	public void verifyOrderSuccessMsg()
	{
		try{
		U.isElementPresent(orderSuccessMsg,30);
		Helper.highLightElement(Startup.wd,orderSuccessMsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "orderSuccessMsg");
		String h = orderSuccessMsg.getText();
		Assert.assertEquals(h, "Your Order Has Been Processed!", "order success message is displayed");
		
			logger.info("orderSuccessMsg Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify orderSuccessMsg Message ","orderSuccessMsg Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("orderSuccessMsg Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify orderSuccessMsg Message ","orderSuccessMsg Message is not displayed ",""+screenshot_path+"");
		}
	}
}
