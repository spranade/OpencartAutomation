package wipro.opencart.pages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import wipro.opencart.config.Startup;
import wipro.opencart.library.Helper;
import wipro.opencart.library.Utility;
import wipro.opencart.results.HTMLReportGenerator;

public class SamsungTab {

	final static Logger logger = Logger.getLogger(SamsungTab.class);
	// public int counter=1;
	String screenshot_path;
	Utility U = new Utility();

	public SamsungTab(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='review']//a[contains(text(),'Write a review')]")
	WebElement ReviewsTab;

	public void clickReviewsTab() {
		try {
		U.isElementPresent(ReviewsTab, 30);
		Helper.highLightElement(Startup.wd, ReviewsTab);
		// Actions action = new Actions(Startup.wd);
		// action.moveToElement(ReviewsTab).doubleClick().build().perform();
		ReviewsTab.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "clickReviewsTab");
		
			logger.info("ReviewsTab is clicked");

			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-click ReviewsTab ",
					"ReviewsTab is clicked: ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("ReviewsTab is not clicked ");

			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-click ReviewsTab ",
					"ReviewsTab is not clicked ", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement name;

	public void enterName(String FirstName) {
		try {
		U.isElementPresent(name, 30);
		Helper.highLightElement(Startup.wd, name);
		name.clear();
		name.sendKeys(FirstName);
		screenshot_path = Utility.captureScreenshot(Startup.wd, "name");
		
			logger.info("username is entered");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Enter Username text",
					"Username text is entered ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("username is not entered");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-enter Username text",
					"Username text is not entered", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//textarea[@name='text']")
	WebElement Review;

	public void enterReview(String Rev) {
		try {
		U.isElementPresent(Review, 30);
		Helper.highLightElement(Startup.wd, Review);
		Review.clear();
		Review.sendKeys(Rev);
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Review");
		
			logger.info("Review is entered");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Enter Review text",
					"Review text is entered ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Review is not entered");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-enter Review text",
					"Review text is not entered", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='rating'][@value='1']")
	WebElement Rating1;

	public void selectRating1() {
		try {
		U.isElementPresent(Rating1, 30);
		Helper.highLightElement(Startup.wd, Rating1);
		Rating1.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating1");
		
			logger.info("Rating1 is selected");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating1 ",
					"Rating1 text is selected ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Rating1 is not selected");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating1 ",
					"Rating1 text is not selected", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='rating'][@value='2']")
	WebElement Rating2;

	public void selectRating2() {
		try {
		U.isElementPresent(Rating2, 30);
		Helper.highLightElement(Startup.wd, Rating2);
		Rating2.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating2");
		
			logger.info("Rating2 is selected");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating2 ",
					"Rating2 text is selected ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Rating2 is not selected");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating2 ",
					"Rating2 text is not selected", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='rating'][@value='3']")
	WebElement Rating3;

	public void selectRating3() {
		try {
		U.isElementPresent(Rating3, 30);
		Helper.highLightElement(Startup.wd, Rating3);
		Rating3.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating3");
		
			logger.info("Rating3 is selected");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating3 ",
					"Rating3 text is selected ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Rating3 is not selected");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating3 ",
					"Rating3 text is not selected", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='rating'][@value='4']")
	WebElement Rating4;

	public void selectRating4() {
		try {
		U.isElementPresent(Rating4, 30);
		Helper.highLightElement(Startup.wd, Rating4);
		Rating4.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating4");
		
			logger.info("Rating4 is selected");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating4 ",
					"Rating4 text is selected ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Rating4 is not selected");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating4 ",
					"Rating4 text is not selected", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='rating'][@value='5']")
	WebElement Rating5;

	public void selectRating5() {
		try {
		U.isElementPresent(Rating5, 30);
		Helper.highLightElement(Startup.wd, Rating5);
		Rating5.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating5");
		
			logger.info("Rating5 is selected");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating5 ",
					"Rating5 text is selected ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Rating5 is not selected");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating5 ",
					"Rating5 text is not selected", "" + screenshot_path + "");
		}
	}

	public void selectRating(String r) {
		System.out.println("rating====" + r);
		if (r.equals("1.0")) {
			try {
			U.isElementPresent(Rating1,30);
			Helper.highLightElement(Startup.wd, Rating1);
			Rating1.click();
			screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating1");
			
				logger.info("Rating1 is selected");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating1 ",
						"Rating1 text is selected ", "" + screenshot_path + "");
			} catch (Exception e) {
				logger.error("Rating1 is not selected");
				HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating1 ",
						"Rating1 text is not selected", "" + screenshot_path + "");
			}
		}

		if (r.equals("2.0")) {
			try {
			U.isElementPresent(Rating2,30);
			Helper.highLightElement(Startup.wd, Rating2);
			Rating2.click();
			screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating2");
			
				logger.info("Rating2 is selected");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating2 ",
						"Rating2 text is selected ", "" + screenshot_path + "");
			} catch (Exception e) {
				logger.error("Rating2 is not selected");
				HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating2 ",
						"Rating2 text is not selected", "" + screenshot_path + "");
			}
		}

		if (r.equals("3.0")) {
			try {
			U.isElementPresent(Rating3,30);
			Helper.highLightElement(Startup.wd, Rating3);
			Rating3.click();
			screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating3");
			
				logger.info("Rating3 is selected");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating3 ",
						"Rating3 text is selected ", "" + screenshot_path + "");
			} catch (Exception e) {
				logger.error("Rating3 is not selected");
				HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating3 ",
						"Rating3 text is not selected", "" + screenshot_path + "");
			}
		}

		if (r.equals("4.0")) {
			try {
			U.isElementPresent(Rating4,30);
			Helper.highLightElement(Startup.wd, Rating4);
			Rating4.click();
			screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating4");
			
				logger.info("Rating4 is selected");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating4 ",
						"Rating4 text is selected ", "" + screenshot_path + "");
			} catch (Exception e) {
				logger.error("Rating4 is not selected");
				HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating4 ",
						"Rating4 text is not selected", "" + screenshot_path + "");
			}
		}

		if (r.equals("5.0")) {
			try {
			U.isElementPresent(Rating5,30);
			Helper.highLightElement(Startup.wd, Rating5);
			Rating5.click();
			screenshot_path = Utility.captureScreenshot(Startup.wd, "Rating5");
			
				logger.info("Rating5 is selected");
				HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Select Rating5 ",
						"Rating5 text is selected ", "" + screenshot_path + "");
			} catch (Exception e) {
				logger.error("Rating5 is not selected");
				HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Select Rating5 ",
						"Rating5 text is not selected", "" + screenshot_path + "");
			}
		}
	}

	@FindBy(how = How.XPATH, using = "//a[@id='button-review'][contains(text(),'Continue')]")
	WebElement ClickContinue;

	public void clickContinue() {
		try {
		U.isElementPresent(ClickContinue, 30);
		Helper.highLightElement(Startup.wd, ClickContinue);
		ClickContinue.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "ClickContinue");
		
			logger.info("Continue Button Clicked");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click Continue Button ",
					"Clicked continue button ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("Continue Button not clicked");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click Continue Button ",
					"Continue button not clicked ", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@class='warning']")
	WebElement warningmsg;

	public void warningmsg() {
		try{
		U.isElementPresent(warningmsg,30);
		String h = warningmsg.getText();
		
		Helper.highLightElement(Startup.wd, warningmsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "warningmsg");
		
		Assert.assertEquals(h, "Warning: Verification code does not match the image!", "The user is logged out.");
		
			logger.info("warning Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify warning Message ","warning Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("warning Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify warning Message ","warning Message is not displayed ",""+screenshot_path+"");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tab-review']/div[@class='success']")
	WebElement successmsg;

	public void successmsg() {
		try{
		U.isElementPresent(successmsg,30);
		String h = successmsg.getText();
	
		Helper.highLightElement(Startup.wd, successmsg);
		screenshot_path=Utility.captureScreenshot(Startup.wd, "successmsg");
		
		Assert.assertEquals(h, "Thank you for your review. It has been submitted to the webmaster for approval.", "The user is logged out.");
		
			logger.info("success Message is displayed:");
			
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ "-Verify success Message ","success Message is displayed: ",""+screenshot_path+"");
		}
		catch(Exception e)
		{
			logger.error("success Message is not displayed:");
			
			HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ "-Verify success Message ","success Message is not displayed ",""+screenshot_path+"");
		}
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add to Wish List')]")
	WebElement AddtoWishlist;

	public void clickAddtoWishlist() {
		try {
		U.isElementPresent(AddtoWishlist,30);
		Helper.highLightElement(Startup.wd, AddtoWishlist);
		AddtoWishlist.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "AddtoWishlist");
		
			logger.info("AddtoWishlist  Clicked");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click AddtoWishlist  ",
					"Clicked AddtoWishlist  ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("AddtoWishlist  not clicked");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click AddtoWishlist  ",
					"AddtoWishlist  not clicked ", "" + screenshot_path + "");
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='notification']/div/img[@class='close']")
	WebElement SuccessRibbon;

	public void clickSuccessRibbon() {
		try {
		U.isElementPresent(SuccessRibbon,30);
		Helper.highLightElement(Startup.wd, SuccessRibbon);
		SuccessRibbon.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "SuccessRibbon");
		
			logger.info("SuccessRibbon  Clicked");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click SuccessRibbon  ",
					"Clicked SuccessRibbon  ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("SuccessRibbon  not clicked");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click SuccessRibbon  ",
					"SuccessRibbon  not clicked ", "" + screenshot_path + "");
		}
	}

	
	@FindBy(how = How.XPATH, using = "//img[@title='Samsung Galaxy Tab 10.1'][@id='image']")
	WebElement TabImage;

	public void ClickTabImage() {
		try {
		U.isElementPresent(TabImage,30);
		Helper.highLightElement(Startup.wd, TabImage);
		TabImage.click();
		screenshot_path = Utility.captureScreenshot(Startup.wd, "TabImage");
		
			logger.info("TabImage  Clicked");
			HTMLReportGenerator.StepDetails("PASS", (Startup.counter++) + "-Click TabImage  ",
					"Clicked TabImage  ", "" + screenshot_path + "");
		} catch (Exception e) {
			logger.error("TabImage  not clicked");
			HTMLReportGenerator.StepDetails("FAIL", (Startup.counter++) + "-Click TabImage  ",
					"TabImage  not clicked ", "" + screenshot_path + "");
		}
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='cboxNext']")
	WebElement NextArrow;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cboxClose']")
	WebElement close;	
	
	public void CheckNoOfImages() throws Exception
	{
		List<WebElement> imgageList = Startup.wd.findElements(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/a"));
		int imgCnt = imgageList.size()+1;
		System.out.println("imgCnt " +imgCnt);
		FileWriter fr = new FileWriter("no_of_images.txt");
		BufferedWriter bw = new BufferedWriter(fr);
		bw.write("No of Samsung images:");
		bw.write(""+imgCnt);
		bw.close();
		
		int i=1;
		WebDriverWait wait = new WebDriverWait(Startup.wd,20);
		while(i < imgCnt)
		{
			wait.until(ExpectedConditions.elementToBeClickable(NextArrow)).click();
			i++;
			
		}
		
		close.click();
		
	}
}
