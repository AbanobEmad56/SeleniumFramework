import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Functions {
	
	

	protected static WebDriver driver;
	static ExtentReports extent;
	static int random_int;
	@BeforeSuite
	    public void globalSetup () throws IOException {
	    	
	      
	      
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	        
	        // create ExtentReports and attach reporter(s)
	         extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		
	    }
	 //this function to find elements with ID and send key
	public static void FindID_SendKey(String x , String y) {		
		 driver.findElement(By.id(x)).sendKeys(y);
	}
	 
	 //this function to find elements with xpath and send key
	public static void FindXpath_SendKey(String x , String y) {		
		 driver.findElement(By.xpath(x)).sendKeys(y);
			
	}
	
	
	 //this function to find elements with ID and press
	public static void FindID_Click(String x) {		
		 driver.findElement(By.id(x)).click();
			
	}
	
	 
	 //this function to find elements with xpath and press
	public static void FindXpath_Click(String x) {		
		 driver.findElement(By.xpath(x)).click();
			
	}
	//this function is used to scroll
	public static void Scrolling(int x , int y) {
		
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy("+x+","+y+")", "");
	       
	}
	
	//this function is used to wait element that located by Id
	public static void Wait_Id(int x , String y) {
		
	       WebDriverWait wait = new WebDriverWait(driver, x);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(y)));;
		
		
	}
	
	//this function is used to wait element that located by Xpath
	public static void Wait_xpath(int x , String y) {
		
	       WebDriverWait wait = new WebDriverWait(driver, x);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(y)));;
		
		
	}
	//this function to choose element from dropdown menu 
	public static void Dropdown_ID(String x , String y) {
		
		
		driver.findElement(By.id(x)).click();
	    {
	      WebElement dropdown = driver.findElement(By.id(x));
	      dropdown.findElement(By.xpath(y)).click();
	    }
		
	}
		public static void Dropdown_Xpath(String x , String y) {
			
			
			driver.findElement(By.cssSelector(x)).click();
		    {
		      WebElement dropdown = driver.findElement(By.cssSelector(x));
		      dropdown.findElement(By.cssSelector(y)).click();
		    }
				
		   
		   
	    
		   
	   }
   
	//this function is used to upload photos that not working with send key function
	public static void Uploadphoto(String x , String y) throws AWTException {
		
		
		 Robot robot = new Robot();
		 driver.findElement(By.id(x)).click();
		 robot.setAutoDelay(2000);
		 
	        StringSelection selection = new StringSelection(y);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
	 
	        robot.setAutoDelay(1000);
	 
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	 
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyRelease(KeyEvent.VK_V);
	 
	        robot.setAutoDelay(1000);
	 
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        
	      

}
	
public static void CreateReport(String x) throws IOException {
	
	ExtentTest test = extent.createTest("Contact Cars Test", "Sample Test case for 6/9/2020 Demo");
	test.log(Status.PASS, x+"done successfully)");
	test.log(Status.FAIL, x+ "failed)");
	test.addScreenCaptureFromPath("screenshot.png");
	test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	
}


public static void scroll(int x , int y){
	JavascriptExecutor js = (JavascriptExecutor) driver;
    driver.manage().window().maximize();
    js.executeScript("window.scrollBy(x,y)");
}


public static void dropdown(String X , String Y) {
	
	driver.findElement(By.xpath(X)).click();
	driver.findElement(By.xpath(Y)).click();
	
	

}
public static void RundomNumber() {

	int min = 500;
    int max = 1000;

      
    //Generate random int value from 50 to 100 
    System.out.println("Random value in int from "+min+" to "+max+ ":");
     random_int = (int)(Math.random() * (max - min + 1) + min);

             
}
	
	
	
	protected static void Assertion(String Xpath , String ExpectedTitle) {
	String ActualTitle = driver.findElement(By.xpath(Xpath)).getText();
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	System.out.println("Your Actual Titel is "+ActualTitle);
	System.out.println("Your Expected Titel is "+ExpectedTitle);
	System.out.println("text shown correctly");
	}
}
