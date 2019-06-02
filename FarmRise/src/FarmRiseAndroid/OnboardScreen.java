package FarmRiseAndroid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OnboardScreen extends FarmRiseBase {
	

	@Test
public void onBoard() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='English']").click();
	driver.findElementById("com.climate.farmrise:id/btn_Proceed").click();
	driver.findElementById("com.climate.farmrise:id/btn_agree").click();
	driver.findElementById("com.climate.farmrise:id/tv_dismiss").click();
	driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@index='2']")).click();
	
	WeatherSchemes weather=new WeatherSchemes();
	weather.weatherDetails();
}
	
	
}
