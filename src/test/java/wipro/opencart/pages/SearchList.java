package wipro.opencart.pages;

import java.io.BufferedWriter;
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

public class SearchList {
	
	final static Logger logger=Logger.getLogger(SearchList.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public SearchList(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	
	
	@FindBy(how = How.XPATH, using = "//select[@name='category_id']")
	WebElement category;
	
	public void selectCategory(String cat)
	{
		try{
		U.isElementPresent(category,30);
		Helper.highLightElement(Startup.wd, category);
		
		Select sel1= new Select(category);
		sel1.selectByValue(cat);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectcategory");
		
			logger.info("Category is selected");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Select Category ","Category is selected ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Category is not selected");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Select Category ","Category is not selected ",""+screenshot_path+"");
		}
	}

	
	
	@FindBy(how = How.XPATH, using = "//input[@id='sub_category']")
	WebElement selectSubCategory;
	
	public void selectSubCategory()
	{
		try{
		U.isElementPresent(selectSubCategory,30);
		Helper.highLightElement(Startup.wd, selectSubCategory);
		
		selectSubCategory.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectSubCategory");
		
			logger.info("SubCategory is selected");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Select SubCategory ","SubCategory is selected ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("SubCategory is not selected");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Select SubCategory ","SubCategory is not selected ",""+screenshot_path+"");
		}
	}
	
	
	public void getItemCount(BufferedWriter br) throws IOException
	{
		
		 List<WebElement> rowcount=Startup.wd.findElements(By.xpath("//div[@class='product-list']/div"));
         int count=rowcount.size();
         br.append("number of items in the grid = "+count);
	     br.newLine();
	    
		
         for(WebElement ele : rowcount)
         {
        	 Helper.highLightElement(Startup.wd,ele);	
        	 //screenshot_path=Utility.captureScreenshot(Startup.wd, "getPrice");
        	 //String Item=ele.getText();
    	     
    	    
         }
		
         
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='button-search']")
	WebElement SearchButton;
	
	public void clickSearchButton()
	{
		try{
		U.isElementPresent(SearchButton,30);
		Helper.highLightElement(Startup.wd, SearchButton);
		SearchButton.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "SearchButton");
		
			logger.info("SearchButton Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click SearchButton ","Clicked SearchButton ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("SearchButton not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click SearchButton ","SearchButton not clicked ",""+screenshot_path+"");
		}
		
	}

}
