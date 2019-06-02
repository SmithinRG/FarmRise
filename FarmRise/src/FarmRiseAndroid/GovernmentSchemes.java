package FarmRiseAndroid;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class GovernmentSchemes extends FarmRiseBase{


	@Test
	public void governement() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.climate.farmrise:id/action_more\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.climate.farmrise:id/more_govtSchemes\")").click();	
		WebElement el= driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[@index='0']"));
		int start = el.getSize().getHeight();
		int end  = el.getLocation().getY();	
		int x= el.getLocation().getX();
		for(int i=0;i<=3;i++) {
			TouchAction t = new TouchAction(driver);
			t.press(point(x, start))
			.waitAction(waitOptions(ofMillis(2000)))
			.moveTo(point(x, end))
			.release().perform();
		}

		search();
	}


	@Test
	public void search() {
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/search_button\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/search_src_text\")").sendKeys("scheme");
		((AndroidDriver<AndroidElement>) driver).pressKey(new KeyEvent(AndroidKey.SEARCH));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tearDown();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
