package FarmRiseAndroid;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FarmRiseBase {
	public static AndroidDriver<AndroidElement> driver;
	
	
		// TODO Auto-generated method stub
		@BeforeTest
		
		public void base() throws MalformedURLException {
			// Real Device
			
			DesiredCapabilities mb = new DesiredCapabilities();
			mb.setCapability("device", "Android");
			mb.setCapability("deviceName", "9483ce4f"); 
			mb.setCapability("appPackage", "com.climate.farmrise");
			mb.setCapability("appActivity", "com.climate.farmrise.SplashScreen");
			mb.setCapability("noReset", "true");
			mb.setCapability("unicodeKeyboard", "true");
			mb.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
			mb.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),mb);
	}
	

		
	}


