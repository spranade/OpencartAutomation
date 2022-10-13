package wipro.opencart.listeners;

import java.net.UnknownHostException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.log4testng.Logger;

//import wipro.opencart.config.SendMail;
import wipro.opencart.results.HTMLReportGenerator;

public class SuiteListener implements ISuiteListener {

	final static Logger logger=Logger.getLogger(SuiteListener.class);
	public void onStart(ISuite suite) {
		String suitename = suite.getName();
		String reportFilePath = System.getProperty("user.dir") + "\\result.html";
		System.out.println("Suite Execution Start. Suite Name:" + suitename);
		logger.info("Suite Execution Start. Suite Name:" + suitename);
		
		System.out.println("Running Suite:--"+suite.getName());
		System.out.println("Running Suite:--"+suite.getAllMethods().size());
		System.out.println("--"+suite.getAllInvokedMethods());
		System.out.println("===============================================");
		
		try {
			//HTMLReportGenerator.TestSuiteStart("D:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\report.html", "Opencart");
			HTMLReportGenerator.TestSuiteStart(reportFilePath, "Opencart");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ISuite suite) {
		String reportFilePath = System.getProperty("user.dir") + "\\result.html";
		String suitename = suite.getName();
		System.out.println("Suite Execution Over. Suite Name:" + suitename);
		logger.info("Suite Execution Over. Suite Name:" + suitename);
		
		System.out.println("Running Suite:--"+suite.getName());
		System.out.println("Running Suite:--"+suite.getAllMethods().size());
		System.out.println("--"+suite.getAllInvokedMethods());
		System.out.println("===============================================");
		
		HTMLReportGenerator.TestSuiteEnd();

		//SendMail.SendReportThroughMail("spranade91@gmail.com", "spranade91@gmail.com", "smtp.gmail.com" , "465", "your_password", reportFilePath , "smtp");
	
		
	}

}