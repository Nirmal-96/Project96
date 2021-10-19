package org.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.Select;


public   class BaseClass {
	
public static	WebDriver driver;
	
	public static WebDriver getbrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\NIRMAL\\eclipse-workspace\\Ram\\Driver\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
			}
	
	public static void Url(String Url) {
		
		driver.get(Url);
}

public static void inputValues(WebElement Element,String Value) {
	Element.sendKeys(Value);

}

public static void clickOnElement(WebElement Element) {
	Element.click();

}

public static void sleep(int values) throws InterruptedException {
	Thread.sleep(values);
	}

public static void wait(int values) {
	driver.manage().timeouts().implicitlyWait(values,TimeUnit.SECONDS);

}

public static void ScreenShot() throws IOException {
	
	TakesScreenshot tk=(TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File des=new File("C:\\Users\\NIRMAL\\eclipse-workspace\\Ram\\screenShot");
	FileUtils.copyFile(src, des);

}

public static void js(WebElement Element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].scrollIntoView(true)",Element);


}

public static void selectBy(WebElement Element, String Type , String value  ) {
	
	Select s=new Select(Element);
	if (Type.equalsIgnoreCase("value")) {
		s.selectByValue(value);
		}else if (Type.equalsIgnoreCase("index")) {
			int a = Integer.parseInt(value);
			s.selectByIndex(a);
		}else if (Type.equalsIgnoreCase("visibleText")) {
			s.selectByVisibleText(value);
			}
	}

public static void mouse(WebElement target ) {
	
	Actions a=new Actions(driver);
	a.moveToElement(target).perform();
}


public static void quit() {
	
	driver.quit();

}






}