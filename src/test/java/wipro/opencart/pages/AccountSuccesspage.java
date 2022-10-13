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

public class AccountSuccesspage {

	final static Logger logger=Logger.getLogger(AccountSuccesspage.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();
	
	public AccountSuccesspage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//div[@id='content']/h1[contains(text(),'Created')]")
	WebElement successMessage;
	public String verifySuccessMessage()
	{
		
		U.isElementPresent(successMessage,30);
		String h = successMessage.getText();
		try{
		Helper.highLightElement(Startup.wd,successMessage);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "successMessage");
		
		Assert.assertEquals(h, "Your Account Has Been Created!", "Account created success message is displayed");
		
			logger.info("Success Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Success Message ","Success Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Success Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Success Message ","Success Message is not displayed ",""+screenshot_path+"");
		}
		return h;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='content']/h1[contains(text(),'Logout')]")
	WebElement LogoutMessage;
	public String verifyLogOutMessage()
	{
		U.isElementPresent(LogoutMessage,30);
		String h = LogoutMessage.getText();
		try{
		Helper.highLightElement(Startup.wd,LogoutMessage);	
		screenshot_path=Utility.captureScreenshot(Startup.wd, "LogoutMessage");
		
		Assert.assertEquals(h, "Account Logout", "The user is logged out.");
		
			logger.info("Logout Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Logout Message ","Logout Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Logout Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Logout Message ","Logout Message is not displayed ",""+screenshot_path+"");
		}
		return h;
	}
	
	
	public String verifytitle()
	{
		
		String t = Startup.wd.getTitle();
		System.out.println(t);
		try{
		//Assert.assertEquals(Startup.wd.getTitle(), "Your Account Has Been Created!", "Title is verified");
				screenshot_path=Utility.captureScreenshot(Startup.wd, "verifytitle");
		
			logger.info("Title is verified:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Title ","Title is verified: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Success Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Title ","Title is not verified ",""+screenshot_path+"");
		}
		return t;
		
			
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='welcome']/a[1]")
	WebElement username;
	public void verifyUsername(String Username)
	{
		U.isElementPresent(username,30);
		String un = username.getText();
		try{
		Helper.highLightElement(Startup.wd,username);
		
		Assert.assertEquals(un, Username, "username is verified.");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifyUsername");
	
			logger.info("Username is verified:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Username ","Username is verified: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Username is not verified:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Username ","Username is not verified ",""+screenshot_path+"");
		}
			
	}
	
	
	
	
}
