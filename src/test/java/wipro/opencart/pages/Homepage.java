package wipro.opencart.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class Homepage {

	final static Logger logger=Logger.getLogger(Homepage.class);
	//public int counter=1;
	String screenshot_path;
	Utility U = new Utility();
	
	public Homepage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Home')]")
	WebElement HomeLink;
	public void clickHomeLink()
	{
		try{
		U.isElementPresent(HomeLink,30);
		Helper.highLightElement(Startup.wd,HomeLink);
		HomeLink.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "HomeLink");
		
			logger.info("HomeLink is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click HomeLink ","HomeLink is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("HomeLink is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click HomeLink ","HomeLink is not clicked ",""+screenshot_path+"");
		}
	}
	

	@FindBy(how=How.XPATH,using="//div[@id='welcome']/a[contains(text(),'login')]")
	WebElement loginLink;
	public void clickLogin()
	{
		try{
		U.isElementPresent(loginLink,30);
		Helper.highLightElement(Startup.wd,loginLink);
		loginLink.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickLogin");
		
			logger.info("loginLink is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click loginLink ","loginLink is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("loginLink is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click loginLink ","loginLink is not clicked ",""+screenshot_path+"");
		}
	}
	
	
	
	@FindBy(how=How.XPATH,using="//div[@class='links']/a[contains(text(),'My Account')]")
	WebElement MyAccountlink;
	public void clickMyAccount()
	{
		try{
		U.isElementPresent(MyAccountlink,30);
		Helper.highLightElement(Startup.wd,MyAccountlink);
		MyAccountlink.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "MyAccountlink");
		
			logger.info("My Account link is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click MyAccountlink ","MyAccountlink is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("My Account link is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click MyAccountlink ","MyAccountlink is not clicked ",""+screenshot_path+"");
		}
	}
	
	
	
	@FindBy(how=How.XPATH,using="//div[@id='welcome']/a[1]")
	WebElement username;
	public void verifyUserName()
	{
		try{
		U.isElementPresent(username,30);
		String user = username.getText();
		System.out.println("user == " + user);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "verifyUsername");
		
			logger.info("Username is verified:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify Username ","Username is verified: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Username is not verified:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify Username ","Username is not verified ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='welcome']/a[contains(text(), 'create an account')]")
	WebElement createaccountlink;
	public void clickCreateAccountLink()
	{
		try{
		U.isElementPresent(createaccountlink,30);
		Helper.highLightElement(Startup.wd,createaccountlink);
		createaccountlink.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "createaccountlink");
		
			logger.info("createaccountlink is clicked: ");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click createaccountlink ","createaccountlink is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("createaccountlink is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click createaccountlink ","createaccountlink is not clicked ",""+screenshot_path+"");
		}
		
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='slideshow0']/a[@class='nivo-imageLink']")
	WebElement TabImg;
	public void clickTabImg()
	{
		try{
		U.isElementPresent(TabImg,30);
		Helper.highLightElement(Startup.wd,TabImg);		
		TabImg.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "TabImg");
		
			logger.info("TabImg is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click TabImg ","TabImg is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("TabImg is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click TabImg ","TabImg is not clicked ",""+screenshot_path+"");
		}
		
	}
	
	@FindBy(how=How.XPATH,using="//a[@id='wishlist-total']")
	WebElement WishList;
	public void clickWishList()
	{
		try{
		U.isElementPresent(WishList,30);
		Helper.highLightElement(Startup.wd,WishList);
		WishList.click();
		String wishno =WishList.getText();		
		int len=wishno.length();
		int i=0;
		String n="";
		for(i=0;i<len;i++)
		{
			if((Character.isDigit(wishno.charAt(i))))
			{
				n=n+wishno.charAt(i);
			}
		}
		System.out.println("wishno="+wishno);
		System.out.println(n);
		int no= Integer.parseInt(n);
		System.out.println(no);
		
		List<WebElement> rowcount=Startup.wd.findElements(By.xpath("//*[@id='wishlist-row49']/tr"));
        int count=rowcount.size();
        Assert.assertEquals(no, count);
		
		screenshot_path=Utility.captureScreenshot(Startup.wd, "WishList");	
		
			logger.info("WishList is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click WishList ","WishList is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("WishList is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click WishList ","WishList is not clicked ",""+screenshot_path+"");
		}
		
		
	
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='currency']/a[@title='Pound Sterling']")
	WebElement Pound;
	public void clickPound()
	{
		try{
		U.isElementPresent(Pound,30);
		Helper.highLightElement(Startup.wd,Pound);			
		Pound.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickPound");	
		
			logger.info("Pound is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click Pound ","Pound is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Pound is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click Pound ","Pound is not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='currency']/a[@title='Euro']")
	WebElement Euro;
	public void clickEuro()
	{
		try{
		U.isElementPresent(Euro,30);
		Helper.highLightElement(Startup.wd,Euro);			
		Euro.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickEuro");	
		
			logger.info("Euro is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click Euro ","Euro is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Euro is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click Euro ","Euro is not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='currency']/a[@title='US Dollar']")
	WebElement USDollar;
	public void clickUSDollar()
	{
		try{
		U.isElementPresent(USDollar,30);
		Helper.highLightElement(Startup.wd,USDollar);			
		USDollar.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "clickUSDollar");	
		
			logger.info("USDollar is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click USDollar ","USDollar is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("USDollar is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click USDollar ","USDollar is not clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='welcome']/a[contains(text(),'Logout')]")
	WebElement Logout;
	public void clickLogout()
	{
		try{
		U.isElementPresent(Logout,30);
		Helper.highLightElement(Startup.wd,Logout);			
		Logout.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "Logout");	
		
			logger.info("Logout is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click Logout ","Logout is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Logout is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click Logout ","Logout is not clicked ",""+screenshot_path+"");
		}
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Contact Us')]")
	WebElement ContactUs;
	public void clickContactUs()
	{
		try{
		U.isElementPresent(ContactUs,30);
		Helper.highLightElement(Startup.wd,ContactUs);
		ContactUs.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "ContactUs");	
		
			logger.info("ContactUs is clicked");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-click ContactUs ","ContactUs is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("ContactUs is not clicked ");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-click ContactUs ","ContactUs is not clicked ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@id='search']/input[@name='search']")
	WebElement search;
	public void searchProduct(String Product)
	{
		try{
		U.isElementPresent(search,30);
		Helper.highLightElement(Startup.wd,search);
		search.clear();
		search.sendKeys(Product);
		search.sendKeys(Keys.ENTER);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "searchProduct");
		
		
			logger.info("Product is searched:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click Search ","Product is searched: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("Product is not searched:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click Search ","Product is not searched ",""+screenshot_path+"");
		}
	}
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Phones & PDAs')]")
	WebElement PhonesnPDAslink;
	
	public void clickPhonesnPDAs()
	{
		try{
		U.isElementPresent(PhonesnPDAslink,30);
		Helper.highLightElement(Startup.wd,PhonesnPDAslink);
		PhonesnPDAslink.click();
		screenshot_path=Utility.captureScreenshot(Startup.wd, "PhonesnPDAslink");
		
		
			logger.info("PhonesnPDAslink is clicked:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Click PhonesnPDAslink ","PhonesnPDAslink is clicked: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("PhonesnPDAslink is not clicked:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Click PhonesnPDAslink ","PhonesnPDAslink is not clicked ",""+screenshot_path+"");
		}
	}
	
}
