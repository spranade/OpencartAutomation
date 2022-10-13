package wipro.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import wipro.opencart.config.Startup;
import wipro.opencart.library.Helper;
import wipro.opencart.library.Utility;
import wipro.opencart.results.HTMLReportGenerator;

public class CreateAccount {
	
	final static Logger logger=Logger.getLogger(CreateAccount.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public CreateAccount(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='firstname']")
	WebElement firstname;
	public void enterFirstName(String FirstName)
	{
		try{
		U.isElementPresent(firstname,30);	
		Helper.highLightElement(Startup.wd,firstname);		
		firstname.sendKeys(FirstName);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterFirstName");
		
			logger.info("Firstname is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter First Name ","Firstname is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Firstname is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter First Name ","Firstname is not entered ",""+screenshot_path+"");
		}
	}
	

	@FindBy(how=How.XPATH,using="//input[@name='lastname']")
	WebElement lastname;
	public void enterLastName(String LastName)
	{
		try{
		U.isElementPresent(lastname,30);
		Helper.highLightElement(Startup.wd,lastname);			
		lastname.sendKeys(LastName);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterLastName");
		
			logger.info("lastname is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter lastname ","lastname is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("lastname is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter lastname ","lastname is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='email']")
	WebElement email;
	public void enterEmail(String Email)
	{
		try{
		U.isElementPresent(email,30);
		Helper.highLightElement(Startup.wd,email);			
		email.sendKeys(Email);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterEmail");
		
			logger.info("Email is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter Email ","Email is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Email is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter Email ","Email is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='telephone']")
	WebElement telephone;
	public void enterTelephone(String Tel)
	{
		try{
		U.isElementPresent(telephone,30);
		Helper.highLightElement(Startup.wd,telephone);			
		telephone.sendKeys(Tel);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterTelephone");
		
			logger.info("telephone is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter telephone ","telephone is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("telephone is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter telephone ","telephone is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='address_1']")
	WebElement address1;
	public void enterAddress1(String Address1)
	{
		try{
		U.isElementPresent(address1,30);
		Helper.highLightElement(Startup.wd,address1);			
		address1.sendKeys(Address1);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterAddress1");
		
			logger.info("address1 is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter address1 ","address1 is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("address1 is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter address1 ","address1 is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	WebElement city;
	public void enterCity(String City)
	{
		try{
		U.isElementPresent(city,30);
		Helper.highLightElement(Startup.wd,city);			
		city.sendKeys(City);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterCity");
		
			logger.info("City is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter City ","City is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("City is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter City ","City is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='postcode']")
	WebElement postcode;
	public void enterPostcode(String PostalCode)
	{
		try{
		U.isElementPresent(postcode,30);
		Helper.highLightElement(Startup.wd,postcode);			
		postcode.sendKeys(PostalCode);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterPostcode");
		
			logger.info("PostalCode is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter PostalCode ","PostalCode is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("PostalCode is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter PostalCode ","PostalCode is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//select[@name='country_id']")
	WebElement countryid;
	public void selectCountry(String Country)
	{
		try{
		U.isElementPresent(countryid,30);
		Helper.highLightElement(Startup.wd,countryid);			
		Select sel1= new Select(countryid);
		sel1.selectByVisibleText(Country);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectCountry");
	
			logger.info("Country is selected");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Select Country ","Country is selected ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Country is not selected");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Select Country ","Country is not selected ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//select[@name='zone_id']")
	WebElement state;
	public void selectState(String State)
	{
		try{
		U.isElementPresent(state,30);
		Helper.highLightElement(Startup.wd,state);			
		Select sel2= new Select(state);
		sel2.selectByVisibleText(State);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "selectCountry");
		
			logger.info("State is selected");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Select State ","State is selected ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("State is not selected");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Select State ","State is not selected ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement password;
	public void enterPassword(String Password)
	{
		try{
		U.isElementPresent(password,30);
		Helper.highLightElement(Startup.wd,password);			
		password.sendKeys(Password);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "enterPassword");
		
			logger.info("Password is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter Password ","Password is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Password is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter Password ","Password is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='confirm']")
	WebElement ConfirmPassword;
	public void ConfirmPassword(String ConfrmPassword)
	{
		try{
		U.isElementPresent(ConfirmPassword,30);
		Helper.highLightElement(Startup.wd,ConfirmPassword);			
		ConfirmPassword.sendKeys(ConfrmPassword);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "ConfirmPassword");
		
			logger.info("ConfirmPassword is entered");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Enter ConfirmPassword ","ConfirmPassword is entered ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("ConfirmPassword is not entered");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Enter ConfirmPassword ","ConfirmPassword is not entered ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='agree']")
	WebElement agree;
	public void Agree()
	{
		try{
		U.isElementPresent(agree,30);
		Helper.highLightElement(Startup.wd,agree);			
		agree.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Agree");
		
			logger.info("Agree is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click Agree ","Agree is clicked ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Agree is not clicked");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click Agree ","Agree is not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@class='button'][@value='Continue']")
	WebElement clickContinue;
	public void clickContinue()
	{
		try{
		U.isElementPresent(clickContinue,30);
		Helper.highLightElement(Startup.wd,clickContinue);	
		clickContinue.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "continue1");
		
			logger.info("Continue Button Clicked");			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Continue Button ","Clicked continue button ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Continue Button not clicked");			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Continue Button ","Continue button not clicked ",""+screenshot_path+"");
		}
		
	}
}
