package FarmRiseAndroid;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class WeatherSchemes extends FarmRiseBase {


	@Test
	public void  weatherDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("com.climate.farmrise:id/action_home").click();
		driver.findElementById("com.climate.farmrise:id/checkWeatherView").click();

		driver.findElementByClassName("android.widget.HorizontalScrollView").isEnabled();
		driver.findElementById("com.climate.farmrise:id/hourlyWeatherForecastScrollView").click();
		System.out.println("Pass");
		try {
			verifyTime();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	@Test
	public void verifyTime() throws Exception {

		WebElement el= driver.findElementById("com.climate.farmrise:id/hourlyWeatherForecastScrollView");

		Dimension size = driver.manage().window().getSize();
		Double anchorPercentage = size.getHeight()*0.635;
		int anchor = anchorPercentage.intValue();
		Double startPercentage= size.getWidth()*0.85;
		int startPoint = startPercentage.intValue();
		Double endPercentage = size.getWidth()*0.078;
		int endPoint = endPercentage.intValue();
		for(int i=0;i<=4;i++) {
			TouchAction t = new TouchAction(driver);
			t.press(point(startPoint, anchor))
			.waitAction(waitOptions(ofMillis(2000)))
			.moveTo(point(endPoint, anchor))
			.release().perform();
		}

		GovernmentSchemes schemes= new GovernmentSchemes();
		schemes.governement();
	}

}













//MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.climate.farmrise:id/hourlyValue\")).scrollIntoView("
//+ "new UiSelector().text(\"2 AM\"))")); working vertical







