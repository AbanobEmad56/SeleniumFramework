import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Variables{

	private static final String Text1_Value = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;


	@BeforeTest
	//this test case is test login 
	public static void StartBrowser() {
		 System.setProperty(DriverKey,DriverPath);
		 driver = new ChromeDriver();
		   driver.get(URL);
		   
	}


	//this test will test the first phase form signup process
	@Test(priority = 1)
	 public void SignUp() {
		Assertion(Text1_Xpath,Test1_Value);
		 Wait_xpath(30, CreateAccount_Xpath);
		 RundomNumber();//this function is user to generate rundom number to use this number to enter unique data every test
		 FindXpath_Click(CreateAccount_Xpath); // this function is used to press on create account button
		 FindXpath_SendKey(UserName_Xpath,UserName+random_int); // this function is used to write Random unique Name into Name field
		 FindXpath_SendKey(TenantName_Xpath,TenantName+random_int); //  this function is used to write Random unique Tenant Name into Tenant Name field
		 FindXpath_SendKey(AdminEmailAddress_Xpath,UserName+random_int+Domain); // this function is used to Random unique Email into Email field
		 FindXpath_SendKey(Phone_Xpath,Phone+random_int);// this function is used to Random unique Phone into Phone field
		 FindXpath_Click(Next_Xpath);//this function is used to press on finish
		
		 

		    }    


	//this test will test the second phase form signup process
	@Test(priority = 2)
	public void Signup2() {
		Wait_xpath(30, TaxId_Xpath);
		FindXpath_SendKey(TaxId_Xpath,TaxId);//this function is used to 
		FindXpath_SendKey(ContactName_Xpath,ContactName);
		FindXpath_SendKey(AdminPassword_Xpath,Password);
		FindXpath_SendKey(AdminConfirmPassword_Xpath,Password);
		FindXpath_Click(Submit_Xpath);
		
	}




}
