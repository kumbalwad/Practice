package config;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.FrameworkBase;

public class UtilityPage extends FrameworkBase {

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void waitforsec(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

	public static void explicitWait(int i, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
	}

	public static void hardAssert(String str, String a) {
		Assert.assertEquals(str, a);
	}

	public static void hardAssert(String str, String a, String msg) {
		Assert.assertEquals(str, a, msg);
	}

	public static boolean isEnabled(WebElement ele) {
		boolean cond = ele.isEnabled();
		return cond;
	}

	public static boolean isSelected(WebElement ele) {
		boolean cond = ele.isSelected();
		return cond;
	}

	public static boolean isDisplayed(WebElement ele) {
		boolean cond = ele.isDisplayed();
		return cond;
	}

	public static void takeScreenShot() {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\akash\\eclipse-workspace\\Guru99Project\\Guru99Practice\\Screenshots");
		try {
			FileUtils.copyDirectory(scrFile, dest);
		} catch (IOException e) {
		}

	}
}
