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

public class MyAccount {
	
	final static Logger logger=Logger.getLogger(MyAccount.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public MyAccount(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//div[@id='content']/h1[contains(text(),'My Account')]")
	WebElement MyAccount;
	public void verifyMyAccount()
	{
		
	}
	
	public String verifytitle()
	{
		Assert.assertEquals(Startup.wd.getTitle(), "My Account", "Title is verified");
		
		String t = Startup.wd.getTitle();
		System.out.println(t);
		return t;
		
			
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@class='box-content']/ul/li/a[contains(text(),'Order History')]")
	WebElement OrderHistory;
	public void clickOrderHistory()
	{
		try{
		U.isElementPresent(OrderHistory,30);
		Helper.highLightElement(Startup.wd,OrderHistory);
		OrderHistory.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "OrderHistory");
		
			logger.info("OrderHistory link is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click OrderHistory ","OrderHistory is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("OrderHistory link is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click OrderHistory ","OrderHistory is not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='box-content']/ul/li/a[contains(text(),'Newsletter')]")
	WebElement NewsLetter;
	public void clickNewsLetter()
	{
		try{
		U.isElementPresent(NewsLetter,30);
		Helper.highLightElement(Startup.wd,NewsLetter);
		NewsLetter.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "NewsLetter");
		
			logger.info("NewsLetter link is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click NewsLetter ","NewsLetter is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("NewsLetter link is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click NewsLetter ","NewsLetter is not clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div/ul/li/a[contains(text(),'Specials')]")
	WebElement Specials;
	public void clickSpecials()
	{
		try{
		U.isElementPresent(Specials,30);
		Helper.highLightElement(Startup.wd,Specials);
		Specials.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Specials");
		
			logger.info("Specials link is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Specials ","Specials is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Specials link is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Specials ","Specials is not clicked ",""+screenshot_path+"");
		}
	}
	
	

}
