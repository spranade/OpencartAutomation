package wipro.opencart.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
import com.google.common.collect.Lists;

public class PhonesnPDAs {
	
	final static Logger logger=Logger.getLogger(PhonesnPDAs.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();


	public PhonesnPDAs(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//div[@class='sort']/select")
	WebElement SortBy;
	public void clickSortBy(String val)
	{
		try{
		U.isElementPresent(SortBy,30);
		Helper.highLightElement(Startup.wd, SortBy);
		Select sel1= new Select(SortBy);
		sel1.selectByVisibleText(val);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "SortBy");
		
			logger.info("SortBy is selected");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Select SortBy ","SortBy is selected ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("SortBy is not selected");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Select SortBy ","SortBy is not selected ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@class='name']/a")
	WebElement ProductName;
	
	public void clickAddToCompare(BufferedWriter br) throws IOException, InterruptedException
	{
		
		 List<WebElement> rowcount=Startup.wd.findElements(By.xpath("//div[@class='compare']//a[contains(text(),'Add to Compare')]"));
         int count=rowcount.size();
         
         List<WebElement> items=Startup.wd.findElements(By.xpath("//div[@class='name']/a"));
         int icount=items.size();
		
         if(count==icount)
         {
		     for(WebElement ele : rowcount)
		    	
		     {
		    	 Thread.sleep(500);
		    	 Helper.highLightElement(Startup.wd,ele);	
		    	 
		    	 //screenshot_path=Utility.captureScreenshot(Startup.wd, "getPrice");
		    	 //String Item=ele.getText();
		    	 
			     ele.click();
			     //this.successmsg();
			     //this.closesuccessmsg();
		     }
		     for(WebElement iele : items)
		     {
		    	 String item = iele.getText();
		    	 br.append("Product Name ="+item);
			     br.newLine();
		     }
        	 
         }
         
	}
	
	public void checkHighToLowPrice()
	{
		List<WebElement> price_list=Startup.wd.findElements(By.className("price-tax"));
    	//List<Integer> price_int=new ArrayList<Integer>();
		
    	List<String> price=new ArrayList<String>();
    	for(WebElement a: price_list)
    	{
    		  Helper.highLightElement(Startup.wd,a);
              price.add(a.getText().substring(9,15).trim());
        	
    	    
    	 }
    	System.out.println(price);
    	List<Float> newList=Lists.transform(price, Float::parseFloat);
    	System.out.println(newList);
    	System.out.println(newList.get(0));
    	int  flag=0;
    	
    	for(int i=0;i<newList.size()-1;i++)
    	{
    		if(newList.get(i)>newList.get(i+1))
    		{   flag=1;
    			continue;
    		
    		}
    		else
    		{
    			System.out.println("The prices are not in high to low");
    		}
    	}
    	if(flag==1)
    	{
    		System.out.println("The prices are sorted in High to  Low!!");
    	}
    	
    	
    }
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='notification']/div[@class='success']")
	WebElement successmsg;
	public void successmsg() {
		try{
		U.isElementPresent(successmsg,30);
		Helper.highLightElement(Startup.wd, successmsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "successmsg");
		
			logger.info("success Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify success Message ","success Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("success Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify success Message ","success Message is not displayed ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='notification']/div[@class='success']/img")
	WebElement closesuccessmsg;
	public void closesuccessmsg() {
		try{
		U.isElementPresent(closesuccessmsg,30);
		Helper.highLightElement(Startup.wd, closesuccessmsg);
		
		closesuccessmsg.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "successmsg");

		
			logger.info("success Message is closed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify success Message ","success Message is closed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("success Message is not closed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify success Message ","success Message is not closed ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//a[@id='compare-total']")
	WebElement ProductComparison;
	
	public void clickProductComparison()
	{
		try{
		U.isElementPresent(ProductComparison,30);
		Helper.highLightElement(Startup.wd, ProductComparison);
		
		ProductComparison.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "ProductComparison");
		
			logger.info("ProductComparison link Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click ProductComparison ","Clicked ProductComparison ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("ProductComparison link not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click ProductComparison ","ProductComparison not clicked ",""+screenshot_path+"");
		}

	}
	
	public void product_compare() throws IOException
    {   String file="Product_Name.txt";
    	System.out.println("=======================");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String lineText=null;
        //ProductComparison.click();
    	List<WebElement> product_name=Startup.wd.findElements(By.xpath("//td[@class='name']/a"));
    	int flag=0;
    	//System.out.println("=======================");
    	while((lineText=br.readLine())!=null)
    	{
    		//System.out.println("=======================");
    	 for(WebElement e:product_name)
    	 {
    		 //System.out.println("=======================");
    		if(lineText.equals(e.getText()))
    		{
    			//System.out.println("=======================");
    			flag=1;
    			System.out.println(e.getText());
    			System.out.println(lineText+" Names Match!");
    		}
    	 }
    	
    	}
    	br.close();
   
    }
	
}
