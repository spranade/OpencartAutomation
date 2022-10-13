package wipro.opencart.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

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

public class HTCphone {
	
	final static Logger logger=Logger.getLogger(HTCphone.class);
	//public int counter=1;
	String lineText=null;
	String screenshot_path;
	Utility U = new Utility();
	
	public HTCphone(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	
	

//	@FindBy(how=How.XPATH,using="//div[@id='tab-description']/ul")
//	WebElement Feature;
	
	@FindBy(how=How.XPATH,using="//div[@id='tab-description']/p")
	WebElement Description;
	public void getDescription() throws Exception
	{
		
		U.isElementPresent(Description,30);
		String Desc = Description.getText();	
		String feature = null;
		try{
		Helper.highLightElement(Startup.wd, Description);
					
		//String feature = Feature.getText();
				
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Description");
		
			
				feature = (Startup.wd.findElement(By.xpath("//div[@id='tab-description']/p"))).getText();
				String file="Product_Name.txt";
			 	BufferedReader br=new BufferedReader(new FileReader(file));
		        BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
		       
		        lineText=br.readLine();		       
		       	lineText=lineText+"-"+Desc;		       
		        
		        bw.write(lineText);
		        bw.close();
		        br.close();
			
			
			logger.info("Description written in file");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Get Description ","Description written in file ",""+screenshot_path+"");
		}
		
		catch(Exception e)
		{
			
			String file="Product_Name.txt";
		 	BufferedReader bf=new BufferedReader(new FileReader(file));
	        BufferedWriter br=new BufferedWriter(new FileWriter(file,true));
	       
	        lineText=bf.readLine();
	        lineText=lineText+"-"+Desc;
	        
	        if(Desc==null)
	        {
	        	lineText=lineText+"- No Description";
	        }
	        lineText=lineText+"-"+feature;
	        if(feature==null)
	        {
	        	lineText=lineText+"- No Features";
	        }
	       	
	       
	        
	        br.write(lineText);
	        br.close();
	        bf.close();
			
			logger.error("Description not written in file");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Get Description ","Description not written in file ",""+screenshot_path+"");
		}
	}
	
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='notification']/div[@class='success']")
	WebElement AddToCartSuccess;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='notification']/div[@class='success']/img['close']")
	WebElement closeAddToCartSuccess;
	
	public void verifyAddToCartSuccessMsg()
	{
		try{
		U.isElementPresent(AddToCartSuccess,30);
		Helper.highLightElement(Startup.wd, AddToCartSuccess);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "AddToCartSuccessMsg");
		//closeAddToCartSuccess.click();
		
			logger.info("AddToCartSuccessMsg verified");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify AddToCartSuccessMsg ","AddToCartSuccessMsg verified",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("AddToCartSuccessMsg not verified");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify AddToCartSuccessMsg ","AddToCartSuccessMsg not verified ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='notification']/div[@class='success']/a[contains(text(),'shopping cart')]")
	WebElement ShoppingCart;
	public void clickShoppingCart()
	{
		try{
		U.isElementPresent(ShoppingCart,30);
		Helper.highLightElement(Startup.wd, ShoppingCart);
		ShoppingCart.click();		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "ShoppingCart");
		
			logger.info("ShoppingCart Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click ShoppingCart ","ShoppingCart Clicked",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("ShoppingCart not Clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click ShoppingCart ","ShoppingCart not Clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='button-cart']")
	WebElement AddToCart;
	public void clickAddToCart()
	{
		try{
		U.isElementPresent(AddToCart,30);
		Helper.highLightElement(Startup.wd, AddToCart);
		AddToCart.click();		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "AddToCart");
		
			logger.info("AddToCart Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click AddToCart ","Clicked AddToCart ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("AddToCart not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click AddToCart ","AddToCart not clicked ",""+screenshot_path+"");
		}
	}

}
