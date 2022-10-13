package wipro.opencart.config;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wipro.opencart.library.Utility;
import wipro.opencart.results.HTMLReportGenerator;


public class LaunchApplication {
	
	//static int counter=1;
	Startup c= new Startup();
	static String screenshot_path;
	

		
	
//	@Parameters({"Browser","url","filepath"})
//	public static void launchApp(String Browser, String url,String filepath)
	@Test
	@Parameters({"Browser","url","filepath","execute_remotely"})
	public static void launchApp(String Browser, String url,String filepath, String execute_remotely)
	{
		
	try{
			if(Browser.equalsIgnoreCase("firefox"))
			{
				
				if(execute_remotely.equalsIgnoreCase("N"))
				{
				System.setProperty("webdriver.firefox.marionette",filepath);
				//System.setProperty("webdriver.geckodriver.driver",filepath);
				Startup.wd = new FirefoxDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "firefox");
				HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
				}
				else
				{
					DesiredCapabilities dc=new DesiredCapabilities("firefox", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),dc);
				}
			}
	}
	catch(Exception e)
	{
		HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
	}
			
	
	
	try{
			if(Browser.equalsIgnoreCase("chrome"))
			{
				if(execute_remotely.equalsIgnoreCase("N"))
				{
				System.setProperty("webdriver.chrome.driver",filepath);
				Startup.wd = new ChromeDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "chrome");
				HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
			
				}
				else
				{
					System.out.println("code will soon come here");
					DesiredCapabilities dc=new DesiredCapabilities("chrome", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),dc);
				}
			}
	}
	
	catch(Exception e)
	{
		HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
	}
	
	
	
	try{
			if(Browser.equalsIgnoreCase("IE"))
			{
				if(execute_remotely.equalsIgnoreCase("N"))
				{
				System.setProperty("webdriver.ie.driver",filepath);
				Startup.wd = new InternetExplorerDriver();
				screenshot_path=Utility.captureScreenshot(Startup.wd, "IE");
				HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
			
				}
				else
				{
					System.out.println("code will soon come here");
					DesiredCapabilities dc=new DesiredCapabilities("IE", "any",org.openqa.selenium.Platform.WINDOWS);
					Startup.wd=new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),dc);
				}
			}
	}
	catch(Exception e)
	{
		HTMLReportGenerator.StepDetails("FAIL",(Startup.counter++)+ " - Launch the "+Browser+" Browser","Browser should get launched",""+screenshot_path+"");
	}
	
	
	
	
			Startup.wd.get(url);
			Startup.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Startup.wd.manage().window().maximize();
			Startup.wd.manage().getCookies().clear();
			screenshot_path=Utility.captureScreenshot(Startup.wd, "url");
			HTMLReportGenerator.StepDetails("PASS",(Startup.counter++)+ " - Launch the URL of the Application","User should be able to launch the URL of the Application and application should be on the Login Page",""+screenshot_path+"");
	}

	
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//LaunchApplication exeapl = new LaunchApplication();
		
		
		//LaunchApplication.launchApp("firefox","http://server:90/finsys/login.html","D:\\selenium\\JARS\\gekodriver.exe");
		//LaunchApplication.launchApp("chrome","http://server:90/finsys/login.html","D:\\selenium\\JARS\\chromedriver.exe");
		LaunchApplication.launchApp("IE","http://server:90/finsys/login.html","D:\\selenium\\JARS\\IEDriverServer_32bit_OS.exe");

		
	}
*/
}
