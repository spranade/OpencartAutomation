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

public class AccountLogin {
	
	final static Logger logger=Logger.getLogger(AccountLogin.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public AccountLogin(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//div[@class='content']/input[@name='email']")
	WebElement emailaddress;
	public void enterEmailAddress(String emailAddress)
	{
		try{
		U.isElementPresent(emailaddress,30);
		Helper.highLightElement(Startup.wd,emailaddress);
		emailaddress.sendKeys(emailAddress);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "emailaddress");
		
			logger.info("emailaddress is entered:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter emailaddress ","emailaddress is entered: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("emailaddress is not entered:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter emailaddress ","emailaddress is not entered ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@class='content']/input[@name='password']")
	WebElement enterPassword;
	public void enterPassword(String password)
	{
		try{
		U.isElementPresent(enterPassword,30);
		Helper.highLightElement(Startup.wd,enterPassword);
		enterPassword.sendKeys(password);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterPassword");
		
			logger.info("password is entered:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter password ","password is entered: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("password is not entered:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter password ","password is not entered ",""+screenshot_path+"");
		}
	}
	
	
	
	
	@FindBy(how=How.XPATH,using="//div[@class='content']/input[@value='Login'][@class='button']")
	WebElement loginButton;
	public void clickLoginButton()
	{
		try{
		U.isElementPresent(loginButton,30);
		Helper.highLightElement(Startup.wd,loginButton);
		loginButton.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickloginButton");
		
			logger.info("loginButton is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click loginButton ","loginButton is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("loginButton is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click loginButton ","loginButton is not clicked ",""+screenshot_path+"");
		}
	}
	
	public String verifytitle()
	{
		Assert.assertEquals(Startup.wd.getTitle(), "My Account", "Title is verified");
		
		String t = Startup.wd.getTitle();
		System.out.println(t);
		return t;
		
			
	}
	
	

}
