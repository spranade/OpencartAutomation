package wipro.opencart.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

public class Wishlist {
	
	final static Logger logger = Logger.getLogger(Wishlist.class);
	String screenshot_path;
	Utility U = new Utility();

	public Wishlist(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//img[@title='Add to Cart']")
	WebElement addCartIcon;
	public void clickaddCartIcon()
	{
		try {
		U.isElementPresent(addCartIcon,30);
		Helper.highLightElement(Startup.wd, addCartIcon);
		addCartIcon.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "addCartIcon");
		
			logger.info("addCartIcon is clicked");

			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-click addCartIcon ",
					"addCartIcon is clicked: ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("addCartIcon is not clicked ");

			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-click addCartIcon ",
					"addCartIcon is not clicked ", "" + screenshot_path + "");
		}
	}
	
	

	@FindBy(how=How.XPATH,using="//div[@id='notification']/div[@class='success']")
	WebElement addCartSuccessMsg;
	public void verifyAddCartSuccessMsg()
	{
		try {
		U.isElementPresent(addCartSuccessMsg,30);
		Helper.highLightElement(Startup.wd, addCartSuccessMsg);
		String c = addCartSuccessMsg.getText();
		System.out.println(c);
		if(c.contains("Success: You have added"))
			Assert.assertTrue(true, "Add cart success message is verified");
		//Assert.assertEquals(h, "Your Account Has Been Created!", "Account created success message is displayed");
		screenshot_path = Utility.captureScreenshot(Startup.wd, "addCartSuccessMsg");
		
			logger.info("addCartSuccessMsg is displayed");

			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-click addCartSuccessMsg ",
					"addCartSuccessMsg is displayed: ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("addCartSuccessMsg is not displayed ");

			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-click addCartSuccessMsg ",
					"addCartSuccessMsg is not displayed ", "" + screenshot_path + "");
		}
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='container']/div[@class='success'][contains(text(),'modified your wishlist!')]/img[@class='close']")
	WebElement closeRemoveCartSuccessMsg;
	public void closeRemoveCartSuccessMsg()
	{
		try {
		U.isElementPresent(closeRemoveCartSuccessMsg,30);
		Helper.highLightElement(Startup.wd, closeRemoveCartSuccessMsg);
		closeRemoveCartSuccessMsg.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "closeRemoveCartSuccessMsg");
		
			logger.info("closeRemoveCartSuccessMsg is clicked");

			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-click closeRemoveCartSuccessMsg ",
					"closeRemoveCartSuccessMsg is clicked: ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("closeRemoveCartSuccessMsg is not clicked ");

			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-click closeRemoveCartSuccessMsg ",
					"closeRemoveCartSuccessMsg is not clicked ", "" + screenshot_path + "");
		}
		
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='notification']/div/img[@class='close']")
	WebElement closeCartSuccessMsg;
	public void closeAddCartSuccessMsg()
	{
		try {
		U.isElementPresent(closeCartSuccessMsg,30);
		Helper.highLightElement(Startup.wd, closeCartSuccessMsg);
		closeCartSuccessMsg.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "closeCartSuccessMsg");
		
			logger.info("closeCartSuccessMsg is clicked");

			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-click closeCartSuccessMsg ",
					"closeCartSuccessMsg is clicked: ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("closeCartSuccessMsg is not clicked ");

			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-click closeCartSuccessMsg ",
					"closeCartSuccessMsg is not clicked ", "" + screenshot_path + "");
		}
		
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='container']/div[@class='success']")
	WebElement RemoveMsg;
//	@FindBy(how=How.XPATH,using="//img[@title='Remove']")
//	WebElement Remove;
	public void Remove()
	{
		try {
		List<WebElement> rowcount= Startup.wd.findElements(By.xpath("//a/img[@title='Remove']"));
		for(WebElement ele : rowcount)
        {
			Helper.highLightElement(Startup.wd, ele);
			ele.click();
			//RemoveMsg.click();
			RemoveMsg();
        }
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Remove");
		
			logger.info("Remove is clicked");

			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-click Remove ",
					"Remove is clicked: ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Remove is not clicked ");

			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-click Remove ",
					"Remove is not clicked ", "" + screenshot_path + "");
		}
	}
	
	
	
	public void RemoveMsg()
	{
		U.isElementPresent(RemoveMsg,30);
		Helper.highLightElement(Startup.wd, RemoveMsg);
		RemoveMsg.click();
	}
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Continue')]")
	WebElement Continue;
	public void clickContinue()
	{
		try{
		U.isElementPresent(Continue,30);
		Helper.highLightElement(Startup.wd,Continue);	
		Continue.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Continue");
		
		
			logger.info("Continue Button Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue Button ","Clicked continue button ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue Button not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue Button ","Continue button not clicked ",""+screenshot_path+"");
		}
	}
	
//	@FindBy(how=How.XPATH,using="//div[@class='price']")
//	WebElement GetPrice;
	public void getPrice(BufferedWriter br) throws IOException
	{
		
		 List<WebElement> rowcount=Startup.wd.findElements(By.xpath("//div[@class='price']"));
         int count=rowcount.size();
         
	    
         /*for(int i=0;i<count;i++)
         {
        	 WebElement ele = rowcount.get(i);
        	 String dollar_price=ele.getText();
    	     br.append(dollar_price);
    	     br.newLine();
    	     br.close();
         }*/
		
         for(WebElement ele : rowcount)
         {
        	 Helper.highLightElement(Startup.wd,ele);	
        	 //screenshot_path=Utility.captureScreenshot(Startup.wd, "getPrice");
        	 String price=ele.getText();
    	     br.append(price);
    	     br.newLine();
    	    
         }
		
	     
	}
	
	
}
