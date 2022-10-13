package wipro.opencart.library;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;

public class Utility {

	static WebDriver drv;

	public void isElementPresent(WebElement ele, int time) {

		// WebElement ele = null;
		
		//drv.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);		
		//WebDriverWait wait=new WebDriverWait(drv, time);
		//wait.until(ExpectedConditions.visibilityOf(ele));

		for (int i = 0; i < time; i++) {
			try {
				// ele=driver.findElement(By.id(id));
				// driver.findElement(ele);
				ele.isDisplayed();
				System.out.println("Element displayed" + ele);
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		
		// return ele;

	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			String dest = System.getProperty("user.dir") + "\\Screenshots\\"+screenshotName+".png";

			File destination = new File(dest);

			// FileUtils.copyFile(source, new
			// File("./Screenshots/"+screenshotName+".png"));

			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot taken");
			System.out.println(dest);
			return dest;
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}

	}
	
	
	//public static String captureScreenshotByElement(WebElement ele, String screenshotName) throws Exception {
	public static String captureScreenshotByElement() throws Exception {
		
		System.out.println("====Reading captch image====");
		//File source = ele.getScreenshotAs(OutputType.FILE);
		File source = drv.findElement(By.id("//input[@name='captcha']/following-sibling::img")).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Screenshots/captchaImg.png";
		FileHandler.copy(source, new File (dest));
		ITesseract image = new Tesseract();
		String imageText = image.doOCR(new File(dest));
		//String imageText = image.doOCR(new File("D:\\ejagruti\\index.jpeg"));
		String finalText = imageText.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("Captcha ====>" + finalText);
		return finalText;
		
	}

	
}