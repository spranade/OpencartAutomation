package wipro.opencart.modules;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wipro.opencart.config.Excel_Operations;
import wipro.opencart.config.Startup;
import wipro.opencart.config.readExcel;
import wipro.opencart.library.Utility;
import wipro.opencart.pages.AccountLogin;
import wipro.opencart.pages.AccountSuccesspage;
import wipro.opencart.pages.CheckOut;
import wipro.opencart.pages.ContactUs;
import wipro.opencart.pages.CreateAccount;
import wipro.opencart.pages.HTCphone;
import wipro.opencart.pages.Homepage;
import wipro.opencart.pages.MyAccount;
import wipro.opencart.pages.NewsLetter;
import wipro.opencart.pages.OrderHistory;
import wipro.opencart.pages.PhonesnPDAs;
import wipro.opencart.pages.ProductComparison;
import wipro.opencart.pages.SamsungTab;
import wipro.opencart.pages.SearchList;
import wipro.opencart.pages.ShoppingCart;
import wipro.opencart.pages.Specials;
import wipro.opencart.pages.Wishlist;
import wipro.opencart.pages.successEnquiry;
import wipro.opencart.results.HTMLReportGenerator;

public class CreateAccountModule  {

	final static Logger logger=Logger.getLogger(CreateAccountModule.class);
	//public int counter=1;
	String screenshot_path;
	int loginflag=0;
	String Username="ssss";
	String Pwd="pass";
	String EmailId="ssss@ssss.com";
	FileWriter fr;
	BufferedWriter br;
	//HTMLReportGenerator ext = new HTMLReportGenerator();
	
	
	
	@DataProvider(name = "testdata")
	public Object[][] passData() throws Exception {
		String excelFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegistrationDetails.xlsx";
		System.out.println("---->"+excelFilepath);
		Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile(excelFilepath, "Sheet1");
		
		//Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile("E:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\RegistrationDetails.xlsx", "Sheet1");
		Set<Integer> keys = exceldata.keySet().stream().sorted().collect(Collectors.toSet());
		Object data1[][] = new Object[keys.size() - 1][exceldata.get(keys.size() - 1).length];
		
		int rowIndex = 0;
		for(Integer i : keys){
			if(i != 0){
				String[] columns = exceldata.get(i);
				System.out.println("Reading row: " + i);
				for(int j = 0; j < columns.length; j++){
					
					if(j==0)
					{
						Username=columns[j];
					}
					if(j==2)
					{
						EmailId=columns[j];
					}
					if(j==9)
					{
						Pwd=columns[j];
					}
					
					System.out.println("column " + j + " value " + columns[j]);
					data1[rowIndex][j]=columns[j];
				}
				
//				System.out.println(data1[0][0]);
//				System.out.println(data1[0][1]);
				rowIndex++;
			}
		}
		return data1;
	}
	
	@DataProvider(name = "reviewdata")
	public Object[][] reviewData() throws Exception {
		String excelFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\ReviewProduct.xlsx";
		Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile(excelFilepath, "Sheet1");
		System.out.println("---->"+excelFilepath);
		//Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile("E:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\ReviewProduct.xlsx", "Sheet1");
		Set<Integer> keys = exceldata.keySet().stream().sorted().collect(Collectors.toSet());
		Object data2[][] = new Object[keys.size() - 1][exceldata.get(keys.size() - 1).length];
		
		int rowIndex = 0;
		for(Integer i : keys){
			if(i != 0){
				String[] columns = exceldata.get(i);
				System.out.println("Reading row: " + i);
				for(int j = 0; j < columns.length; j++){
					System.out.println("column " + j + " value " + columns[j]);
					data2[rowIndex][j]=columns[j];
				}
				
//				System.out.println(data2[0][0]);
//				System.out.println(data2[0][1]);
				rowIndex++;
			}
		}
		return data2;
	}
	
	@DataProvider(name = "searchproduct")
	public Object[][] searchProduct() throws Exception {
	
		String excelFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\SearchProduct.xlsx";
		Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile(excelFilepath, "Sheet1");
		System.out.println("---->"+excelFilepath);
//		Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile("E:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\SearchProduct.xlsx", "Sheet1");
		Set<Integer> keys = exceldata.keySet().stream().sorted().collect(Collectors.toSet());
		Object data3[][] = new Object[keys.size() - 1][exceldata.get(keys.size() - 1).length];
		
		int rowIndex = 0;
		for(Integer i : keys){
			if(i != 0){
				String[] columns = exceldata.get(i);
				System.out.println("Reading row: " + i);
				for(int j = 0; j < columns.length; j++){
					System.out.println("column " + j + " value " + columns[j]);
					data3[rowIndex][j]=columns[j];
				}
				
//				System.out.println(data3[0][0]);
//				System.out.println(data3[0][1]);
				rowIndex++;
			}
		}
		return data3;
	}
	
	@Test(dataProvider = "testdata")
	public void CreateAccount(String FirstName	,String LastName	,String Email	,String Telephone	,String Address1	,String City	,String PostalCode	,String Country ,String State	,String Password	,String ConfirmPassword ) throws Exception
	{
		//readExcel exl = new readExcel();
		//exl.passData("E:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\RegistrationDetails.xlsx", "Sheet1");
		Username=FirstName;
		Pwd=Password;
		EmailId=Email;
		Homepage hm = new Homepage(Startup.wd);
		hm.clickCreateAccountLink();		
		CreateAccount ca = new CreateAccount(Startup.wd);
		ca.enterFirstName(FirstName);
		ca.enterLastName(LastName);
		ca.enterEmail(Email);
		ca.enterTelephone(Telephone);
		ca.enterAddress1(Address1);
		ca.enterCity(City);
		ca.enterPostcode(PostalCode);
		ca.selectCountry(Country);
		ca.selectState(State);
		ca.enterPassword(Password);
		ca.ConfirmPassword(ConfirmPassword);
		ca.Agree();
		ca.clickContinue();
		Thread.sleep(10000);
		AccountSuccesspage ap = new AccountSuccesspage(Startup.wd);
		ap.verifytitle();
		ap.verifySuccessMessage();
		ap.verifyUsername(FirstName);		
//		hm.clickContactUs();		
//		ContactUs cu = new ContactUs(Startup.wd);
//		cu.verifyName();
//		cu.verifyEmail();
//		cu.enterEnquiry();
//		Thread.sleep(10000);
//		cu.clickContinueButton();
//		successEnquiry se = new successEnquiry(Startup.wd);
//		se.verifyEnquirySuccessMsg();
//		Thread.sleep(10000);
//		se.clickContinue();		
//		hm.clickTabImg();
		
		hm.clickLogout();
		ap.verifyLogOutMessage();
		
	}

	@Test(dataProvider = "reviewdata")
	public void reviewProduct(String username,String review, String rating) throws Exception
	{
		//readExcel exl = new readExcel();
		//exl.passData("E:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\ReviewProduct.xlsx", "Sheet1");
		Homepage hm = new Homepage(Startup.wd);
		SamsungTab st = new SamsungTab(Startup.wd);
		AccountLogin al = new AccountLogin(Startup.wd);
		AccountSuccesspage ap = new AccountSuccesspage(Startup.wd);
//		if(loginflag==0)
//		{
		//Homepage hm = new Homepage(Startup.wd);
		hm.clickLogin();
		
		al.enterEmailAddress(EmailId);
		al.enterPassword(Pwd);
		al.clickLoginButton();
		
		ap.verifyUsername(Username);
		
		hm.clickContactUs();		
		ContactUs cu = new ContactUs(Startup.wd);
		cu.verifyName();
		cu.verifyEmail();
		cu.enterEnquiry();
		//cu.verifyCaptcha();
		//Thread.sleep(10000);
		cu.clickContinueButton();
		successEnquiry se = new successEnquiry(Startup.wd);
		se.verifyEnquirySuccessMsg();
		//Thread.sleep(10000);
		se.clickContinue();		
		hm.clickTabImg();
		
		hm.verifyUserName();
		//SamsungTab st = new SamsungTab(Startup.wd);
		
		st.clickReviewsTab();
		
//		//loginflag=1;
//		}
		
		st.enterName(username);
		st.enterReview(review);
		st.selectRating(rating);
		Thread.sleep(10000);
		st.clickContinue();
		hm.clickLogout();
		ap.verifyLogOutMessage();
		
	}
	
	@Test
	public void getWishlistPrice() throws Exception
	{
		Homepage hm = new Homepage(Startup.wd);
		hm.clickLogin();
		AccountLogin al = new AccountLogin(Startup.wd);
		al.enterEmailAddress(EmailId);
		al.enterPassword(Pwd);
		al.clickLoginButton();
		AccountSuccesspage ap = new AccountSuccesspage(Startup.wd);
		ap.verifyUsername(Username);
		
		hm.clickHomeLink();
		hm.clickTabImg();
		SamsungTab st = new SamsungTab(Startup.wd);
		
		st.clickAddtoWishlist();
		st.clickSuccessRibbon();
		
		hm.clickWishList();
		Thread.sleep(1000);
		Wishlist wl = new Wishlist(Startup.wd);
		
		fr=new FileWriter("result.txt");
		br=new BufferedWriter(fr);
		 
		hm.clickPound();
		Thread.sleep(3000);
		wl.getPrice(br);
		
		hm.clickEuro();
		Thread.sleep(3000);
		wl.getPrice(br);
		
		hm.clickUSDollar();
		Thread.sleep(3000);
		wl.getPrice(br);
		br.close();
		
		wl.clickaddCartIcon();
		wl.verifyAddCartSuccessMsg();
		wl.closeAddCartSuccessMsg();
		wl.Remove();
		wl.closeRemoveCartSuccessMsg();
		wl.clickContinue();
		
		hm.clickLogout();
		ap.verifyLogOutMessage();
	}
	
	
	@Test(dataProvider = "searchproduct")
	public void ProductComparison(String Product) throws Exception
	{
		//readExcel exl = new readExcel();
		//exl.passData("E:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\SearchProduct.xlsx", "Sheet1");
		System.out.println("===>>"+Username+"===>>"+Pwd+"===>>"+EmailId);
		Homepage hm = new Homepage(Startup.wd);
		hm.clickLogin();
		AccountLogin al = new AccountLogin(Startup.wd);
		al.enterEmailAddress(EmailId);
		al.enterPassword(Pwd);
		al.clickLoginButton();
		AccountSuccesspage ap = new AccountSuccesspage(Startup.wd);
		ap.verifyUsername(Username);
		System.out.println("===>>"+Product);
		hm.searchProduct(Product);
		SearchList sl = new SearchList(Startup.wd);
		
		fr=new FileWriter("Product_Name.txt");
		br=new BufferedWriter(fr);
		sl.getItemCount(br);
		
		hm.searchProduct("apple");
		// select category monitors
		sl.selectCategory("28");  
		sl.selectSubCategory();
		sl.clickSearchButton();
//		Thread.sleep(5000);
		sl.getItemCount(br);
		
		hm.clickPhonesnPDAs();
//		System.out.println("=======================");
//		Thread.sleep(10000);
//		System.out.println("=======================");
		PhonesnPDAs p = new PhonesnPDAs(Startup.wd);
		p.clickSortBy("Price (High > Low)");
		p.clickAddToCompare(br);
		p.checkHighToLowPrice();
		p.clickProductComparison();
		Thread.sleep(1000);
		br.close();
		Thread.sleep(1000);
		//p.product_compare();
		ProductComparison pc = new ProductComparison(Startup.wd);
		pc.clickPhone();
		
		HTCphone htc = new HTCphone(Startup.wd);
		htc.getDescription();
		htc.clickAddToCart();
		htc.verifyAddToCartSuccessMsg();
		htc.clickShoppingCart();
		ShoppingCart sh = new ShoppingCart(Startup.wd);
		
		//Thread.sleep(500);
		sh.verifyShoppingCart();
		sh.clickCheckOut();
		
		CheckOut co = new CheckOut(Startup.wd);
		co.clickContinue1();
		co.clickContinue2();
		co.clickContinue3();
		co.clickAgreeTerms();
		co.clickContinue4();
		co.clickConfirmButton();
		co.verifyOrderSuccessMsg();
		Startup.wd.navigate().back();
		sh.verifyShoppingCart();
		sh.verifyEmptyShoppingCartMsg();
		hm.clickMyAccount();
		MyAccount acc = new MyAccount(Startup.wd);
		acc.verifytitle();
		acc.clickOrderHistory();
		OrderHistory ord = new OrderHistory(Startup.wd);
		ord.verifyOrderHistory();
		acc.clickNewsLetter();
		NewsLetter nws = new NewsLetter(Startup.wd);
		nws.verifyNewsletterSubscription();
		nws.clickContinueButton();
		acc.clickSpecials();
		Specials spl = new Specials(Startup.wd);
		spl.verifySpecialOffer();
		hm.clickLogout();
		ap.verifyLogOutMessage();
		
		

	}
	
	@Test
	public void AddPhonesToCart() throws Exception
	{
		System.out.println("===>>"+Username+"===>>"+Pwd+"===>>"+EmailId);
		Homepage hm = new Homepage(Startup.wd);
		hm.clickLogin();
		AccountLogin al = new AccountLogin(Startup.wd);
		al.enterEmailAddress(EmailId);
		al.enterPassword(Pwd);
		al.clickLoginButton();
		AccountSuccesspage ap = new AccountSuccesspage(Startup.wd);
		ap.verifyUsername(Username);
		hm.clickHomeLink();
		hm.clickTabImg();
		SamsungTab st = new SamsungTab(Startup.wd);
		st.ClickTabImage();
		st.CheckNoOfImages();
		HTCphone htc = new HTCphone(Startup.wd);
		htc.clickAddToCart();
		htc.verifyAddToCartSuccessMsg();
		htc.clickShoppingCart();
		ShoppingCart sh = new ShoppingCart(Startup.wd);
		sh.clickEstimateShippingAndTaxes();
		sh.clickGetQuotes();
		sh.SuccessMsg();
		sh.GetTotalAmt();
		sh.ClickCouponCode();
		sh.enterCouponCode();
		sh.applyCouponCode();
		sh.WarningMsg();
		sh.clickCheckOut();
		CheckOut co = new CheckOut(Startup.wd);
		co.clickContinue1();
		co.clickContinue2();
		co.clickContinue3();
		co.clickAgreeTerms();
		co.clickContinue4();
		co.clickConfirmButton();
		co.verifyOrderSuccessMsg();
		hm.clickLogout();
		ap.verifyLogOutMessage();
		
	}
	
}
