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

public class Specials {
	
	final static Logger logger=Logger.getLogger(Specials.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public Specials(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Special Offers')]")
	WebElement SpecialOffer;
	public void verifySpecialOffer()
	{
		try{
		U.isElementPresent(SpecialOffer,30);
		Helper.highLightElement(Startup.wd,SpecialOffer);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "SpecialOffer");
		String h = SpecialOffer.getText();
		Assert.assertEquals(h, SpecialOffer.getText(), "SpecialOffer is displayed");
		
			logger.info("SpecialOffer is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify SpecialOffer ","SpecialOffer is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("SpecialOffer is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify SpecialOffer ","SpecialOffer is not displayed ",""+screenshot_path+"");
		}
	}

	

}
