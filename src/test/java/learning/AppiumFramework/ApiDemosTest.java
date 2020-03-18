package learning.AppiumFramework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.HomePage;
import pageobjects.Preferences;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiDemosTest extends base {

	@Test (dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		startServer();
		System.out.println("Server started");
		AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage hp=new HomePage(driver);
		Preferences pref=new Preferences(driver);
		
		/*driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();*/
		hp.preferences.click();
		pref.preference_dependencies.click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		//driver.findElementById("android:id/button1").click();
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		
		/* xpath syntax
		 * 
		 *  //tagname[@attribute='value']
		 */ 
		
		 

	}
	
			
		
		
	}


