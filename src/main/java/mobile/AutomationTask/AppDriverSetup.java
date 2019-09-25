package mobile.AutomationTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class AppDriverSetup {
	
	public static  AndroidDriver<AndroidElement> AD;
	public static String APKPath = System.getProperty("user.dir") + "\\AppSource\\";
	
	
	public static void Setup() throws MalformedURLException
	{
		DesiredCapabilities DesCap = new DesiredCapabilities();
		DesCap.setCapability("deviceName", "192.168.160.103:5555");
		DesCap.setCapability(MobileCapabilityType.APP, APKPath+"android-sample-app.apk");
		DesCap.setCapability(MobileCapabilityType.PLATFORM_NAME , "Android");
		DesCap.setCapability("platformVersion" , "8");
		DesCap.setCapability("automationName", "UiAutomator2");
		AD = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), DesCap);
		AD.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
	}
	
	//=========================================================
	
	public static   AndroidDriver<AndroidElement> getDriver() {
		// TODO Auto-generated method stub
		return AD;
	}
	//=========================================================
	public static void termination()
	{
		AD.quit();
	}


}
