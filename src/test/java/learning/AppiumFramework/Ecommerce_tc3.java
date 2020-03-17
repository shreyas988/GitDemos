
package learning.AppiumFramework;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.CheckoutPage;
import pageobjects.FormPage;
import utils.ScrolltoElement;

public class Ecommerce_tc3 extends base {
	

	
	//public static void main(String[] args) throws MalformedURLException, InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
	@Test
	public void totalValidation() throws InterruptedException, IOException {
		
		
		startServer();
		startEmulator();
		AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		FormPage fp=new FormPage(driver);
		CheckoutPage cp=new CheckoutPage(driver);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		fp.nameField.sendKeys("Pooja");
		driver.hideKeyboard();
		//driver.findElementByXPath("//*[@text='Female']").click();
		fp.getRadioButton().click();
		driver.findElementByXPath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		ScrolltoElement s=new ScrolltoElement(driver);
		s.scroll("Argentina");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		String amount1=cp.productPrice.get(0).getText();
				//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		/*amount1=amount1.substring(1);
		double product1price= Double.parseDouble(amount1);*/
		double product1price=getAmount(amount1);
		String amount2=cp.productPrice.get(1).getText();
				//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		/*amount2=amount2.substring(1);
		double product2price= Double.parseDouble(amount2);*/
		double product2price=getAmount(amount2);
		double sum=product1price+product2price;
		System.out.println("Sum Calculated : "+ sum);
		
		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total=total.substring(1);
		double totalcartvalue=Double.parseDouble(total);
		System.out.println("Cart Value : "+totalcartvalue);
		//Assertion.assertEquals(sum, totalcartvalue,0.0);	
		service.stop();
		

	}
	
	@BeforeTest
	@Override
	public void killAllNodes() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.killAllNodes();
	}
	
		public static double getAmount(String value) {
			
			value=value.substring(1);
			double extractedValue=Double.parseDouble(value);
			return extractedValue;
			
			
		}

}
