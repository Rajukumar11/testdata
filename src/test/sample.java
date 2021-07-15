package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class sample {
	    public static void main(String[] args) {
    	//gecko driver to support latest firefox
    	//Note: Starting Firefox 35, you need to use gecko driver created by Mozilla 
    	//to use Web Driver. Selenium 3.0, gecko and firefox has compatibility issues and 
    	//setting them correctly could become an uphill task. If the code does not work, 
    	//downgrade to Firefox version 47 or below. Alternatively, you can run your scripts on
    	//Chrome. Selenium works out of the box for Chrome. You just need to change 3 lines
    	//of code to make your script work with Chrome or Firefox 
    	System.setProperty("webdriver.gecko.driver", "D:/browserdrivers/geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		By username = By.name("login");
		By password = By.name("password");
		By login = By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button");
		By logout = By.xpath("/html/body/my-app/header/nav/div/my-login/div/ul/li[3]/a");
		
		String baseUrl1 = "https://buggy.justtestit.org/";
        driver.get(baseUrl1);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        String Actual = driver.getTitle();
        String Expected = "Buggy Cars Rating";

        if (Actual.equals(Expected)) {
                   System.out.println("Test 1: Page title verification:Test PASS. Page title is: " +Actual);
        } else {
                   System.out.println("Test 1: Page title verification:Test FAIL. Page title is: " +Actual);
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String strUserName="kumar";
        String strPwd="Testtest1@";
         
        driver.findElement(username).sendKeys(strUserName);
        driver.findElement(password).sendKeys(strPwd);
        driver.findElement(login).click();
            
        String welcomemessage = driver.findElement(By.cssSelector("span.nav-link")).getAttribute("innerHTML");
        
        System.out.println("Test 2: Login functionality:Test PASS. Welcome message appeared after login is: " +welcomemessage);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(logout).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       
        String url = "https://buggy.justtestit.org/"; 
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // get current page URL 
        String strUrl = driver.getCurrentUrl();
        
        if (strUrl.equals(url)) {
            System.out.println("Test 3:Logout functionality:Test PASS. Logout worked");
        } else {
        	System.out.println("Test 3:Logout functionality:Test FAILED. Logout failed. Current URL is" +strUrl);
 }
    }

}