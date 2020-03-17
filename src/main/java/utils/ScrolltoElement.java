package utils;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScrolltoElement {
	
	
	
	private AndroidDriver<AndroidElement> driver;

	public ScrolltoElement(AndroidDriver<AndroidElement> driver) {
		
		// TODO Auto-generated constructor stub
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void scroll(String text) {
	
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
}

	