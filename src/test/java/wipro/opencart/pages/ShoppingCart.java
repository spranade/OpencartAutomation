package wipro.opencart.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ShoppingCart {
	
	final static Logger logger=Logger.getLogger(ShoppingCart.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();
	
	public ShoppingCart(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//input[@type='radio'][@value='shipping']")
	WebElement EstimateShippingAndTaxes;
	public void clickEstimateShippingAndTaxes() throws Exception
	{
		try{
		U.isElementPresent(EstimateShippingAndTaxes,30);
		Helper.highLightElement(Startup.wd, EstimateShippingAndTaxes);	
		EstimateShippingAndTaxes.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "EstimateShippingAndTaxes");
		
		
			logger.info("EstimateShippingAndTaxes Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click EstimateShippingAndTaxes ","Clicked EstimateShippingAndTaxes ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("EstimateShippingAndTaxes not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click EstimateShippingAndTaxes ","EstimateShippingAndTaxes not clicked ",""+screenshot_path+"");
		}
	}	
	
	
	
	@FindBy(how=How.XPATH,using="//a[@class='button'][contains(text(),'Checkout')]")
	WebElement Checkout;
	public void clickCheckOut() throws Exception
	{
		try{
		U.isElementPresent(Checkout,30);
		Helper.highLightElement(Startup.wd, Checkout);			
		Checkout.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Checkout");
		
		//Thread.sleep(100);
		
			logger.info("Checkout Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Checkout ","Clicked Checkout ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Checkout not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Checkout ","Checkout not clicked ",""+screenshot_path+"");
		}
	}
	
	
	
	@FindBy(how=How.XPATH,using="//div[@class='content'][contains(text(),'Your shopping cart is empty!')]")
	WebElement emptyShoppingCartMsg;
	public void verifyEmptyShoppingCartMsg()
	{
		try{
		U.isElementPresent(emptyShoppingCartMsg,30);
		Helper.highLightElement(Startup.wd, emptyShoppingCartMsg);
		
		String ekartmsg = emptyShoppingCartMsg.getText();
		Assert.assertEquals(ekartmsg, "Your shopping cart is empty!", "empty shopping cart message verified.");
		screenshot_path=Utility.captureScreenshot(Startup.wd, "emptyShoppingCartMsg");
		
			logger.info("empty Shopping Cart Message verified");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify empty shopping cart ","empty shopping cart verified ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.info("empty Shopping Cart Message not verified");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify empty shopping cart ","empty shopping cart not verified ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Shopping Cart')]")
	WebElement shoppingCart;
	public void verifyShoppingCart()
	{
		try{
		U.isElementPresent(shoppingCart,30);
		Helper.highLightElement(Startup.wd,shoppingCart);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "shoppingCart");
		String h = shoppingCart.getText();
		Assert.assertEquals(h, shoppingCart.getText(), "Shopping Cart is displayed");
		
			logger.info("Shopping Cart is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Shopping Cart ","Shopping Cart is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Shopping Cart is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Shopping Cart ","Shopping Cart is not displayed ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@value='flat.flat'][@id='flat.flat'][@name='shipping_method']")
	WebElement FlatRate;
	
	
	@FindBy(how=How.XPATH,using="//input[@value='Apply Shipping'][@id='button-shipping']")
	WebElement ApplyShipping;
		
	@FindBy(how=How.XPATH,using="//input[@value='Get Quotes'][@id='button-quote']")
	WebElement GetQuotes;
	public void clickGetQuotes() throws Exception
	{
		try{
		U.isElementPresent(GetQuotes,30);
		Helper.highLightElement(Startup.wd, GetQuotes);	
		GetQuotes.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "GetQuotes");
		
		Helper.highLightElement(Startup.wd, FlatRate);	
		FlatRate.click();
		Helper.highLightElement(Startup.wd, ApplyShipping);	
		ApplyShipping.click();
			
		
		
			logger.info("GetQuotes Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click GetQuotes ","Clicked GetQuotes ",""+screenshot_path+"");
			logger.info("FlatRate Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click FlatRate ","Clicked FlatRate ",""+screenshot_path+"");
			logger.info("ApplyShipping Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click ApplyShipping ","Clicked ApplyShipping ",""+screenshot_path+"");
		
		}
		catch(Exception e)
		{
			logger.error("GetQuotes not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click GetQuotes ","GetQuotes not clicked ",""+screenshot_path+"");
		
			logger.error("FlatRate not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click FlatRate ","FlatRate not clicked ",""+screenshot_path+"");
			logger.error("ApplyShipping not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click ApplyShipping ","ApplyShipping not clicked ",""+screenshot_path+"");
		
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@class='success']")
	WebElement SuccessMsg;
	
	public void SuccessMsg() {
		try{
		U.isElementPresent(SuccessMsg,30);
		Helper.highLightElement(Startup.wd, SuccessMsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "successmsg");
		String h = SuccessMsg.getText();
		Assert.assertEquals(h, SuccessMsg.getText(), "The apply shipping success message is verified.");
		
//		JavascriptExecutor js=(JavascriptExecutor)Startup.wd;
//		js.executeScript("arguments[0].scrollIntoView()", FlatRate);
		
		
			logger.info("success Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify success Message ","success Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("success Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify success Message ","success Message is not displayed ",""+screenshot_path+"");
		}
	}
	
	public void GetTotalAmt() throws Exception
	{
		FileWriter fr = new FileWriter("FlatRate.txt");
        BufferedWriter brRate = new BufferedWriter(fr);
        String tot_amount = Startup.wd.findElement(By.xpath("//div[@class='cart-total']/table[@id='total']/tbody[1]/tr[3]/td[2]")).getText();
        System.out.println("tot_amount  " + tot_amount);
        brRate.write(tot_amount);
        brRate.newLine();
        brRate.close();
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='coupon'][@id='use_coupon']")
	WebElement UseCouponCode;
	
	public void ClickCouponCode()
	{
		try{
		U.isElementPresent(UseCouponCode,30);
		Helper.highLightElement(Startup.wd, UseCouponCode);		
		UseCouponCode.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "UseCouponCode");
		
		
			logger.info("UseCouponCode Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click UseCouponCode ","Clicked UseCouponCode ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("UseCouponCode not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click UseCouponCode ","UseCouponCode not clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@type='text'][@name='coupon']")
	WebElement CouponCode;
	
	public void enterCouponCode()
	{
		try{
		U.isElementPresent(CouponCode,30);
		Helper.highLightElement(Startup.wd, CouponCode);		
		CouponCode.sendKeys("Coupon12345");;
		screenshot_path=Utility.captureScreenshot(Startup.wd, "CouponCode");
		
		
			logger.info("CouponCode Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click CouponCode ","Clicked CouponCode ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("CouponCode not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click CouponCode ","CouponCode not clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@class='button'][@value='Apply Coupon']")
	WebElement ApplyCoupon;
	
	public void applyCouponCode()
	{
		try{
		U.isElementPresent(ApplyCoupon,30);
		Helper.highLightElement(Startup.wd, ApplyCoupon);		
		CouponCode.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "applyCouponCode");
		
		
			logger.info("CouponCode Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click CouponCode ","Clicked CouponCode ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("CouponCode not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click CouponCode ","CouponCode not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='success']")
	WebElement WarningMsg;
	
	public void WarningMsg() throws IOException {
		try{
		U.isElementPresent(WarningMsg,30);
		Helper.highLightElement(Startup.wd, WarningMsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "WarningMsg");
		String h = WarningMsg.getText();
		Assert.assertEquals(h, WarningMsg.getText(), " Warning message is verified.");
		
		FileWriter fr = new FileWriter("Warning.txt");
        BufferedWriter br = new BufferedWriter(fr);
        String warning = WarningMsg.getAttribute("innerHTML");
        br.write(warning);
        br.newLine();
        br.close();
		
		
			logger.info("WarningMsg Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify WarningMsg Message ","WarningMsg Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("WarningMsg Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify WarningMsg Message ","WarningMsg Message is not displayed ",""+screenshot_path+"");
		}
	}
	
}
