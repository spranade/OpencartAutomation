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

public class OrderHistory {
	
	final static Logger logger=Logger.getLogger(OrderHistory.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public OrderHistory(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Order History')]")
	WebElement OrderHistory;
	public void verifyOrderHistory()
	{
		U.isElementPresent(OrderHistory,30);
		String h = OrderHistory.getText();
		try{
		Helper.highLightElement(Startup.wd,OrderHistory);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "OrderHistory");
		
		Assert.assertEquals(h, "Order History", "Order History is displayed");
		
			logger.info("Order History is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Order History ","Order History is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Order History is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Order History ","Order History is not displayed ",""+screenshot_path+"");
		}
	}

	

}
