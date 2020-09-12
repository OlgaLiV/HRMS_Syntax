package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * Method that sends text to any given element
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method return object of Java Script Executor type
	 * 
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

	}

	/**
	 * Method performs click using JavaScript executor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click()", element);

	}

	/**
	 * Method scrolls up using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0,-" + pixel + ")");

	}

	/**
	 * Method scrolls down using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");

	}

	/**
	 * Method performs Explicit wait
	 * 
	 * @return new object of WebDriverWait
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

	}

	/**
	 * Method wait for element to be clickable.
	 * 
	 * @param element
	 */
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Method wait for element visability
	 * 
	 * @param element
	 */
	public static void waitForVisability(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method performs click
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

//	public static void handlingTable(List<WebElement> table, String user, WebElement btn) {
//		boolean flag = true;
//		while (flag) {
//			for (int i = 0; i < table.size(); i++) {
//				String rowText = table.get(i).getText();
//				if (rowText.contains(user)) {
//					flag = false;
//					break;
//				}
//			}
//			jsClick(btn);
//
//		}
//	}
	
	/**
	 * Method that create a screenshot and store it in specif
	 * @param fileName
	 */
	public static void takeScreen(String fileName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file,new File (Constants.SCREENSHOT_FILE_PATH + fileName + getTimeStamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
public static String getTimeStamp() {
		
		Date date = new Date();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		return sdf.format(date);
		
		
	}
}
