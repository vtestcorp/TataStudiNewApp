package com.studi.base;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class Keyword extends BaseClass{

	/**
	 * This method returns the property for the key which we will pass which are
	 * defined in the .property File in Config file
	 * 
	 * @param key
	 * @param fileNamewithExtension
	 * @return
	 * @throws IOException
	 */
	public static String getPropertyFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("src\\main\\java\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String s = prop.getProperty(key);
		return s;
	}

	/**
	 * We can navigate back by using this method.
	 * 
	 */
//	@SuppressWarnings("deprecation")
//	public static void navigateBack() {
//		getDriver().pressKeyCode(AndroidKeyCode.BACK);
//	}

	/**
	 * This method will tap on the element on which we want to tap on
	 * 
	 * @param element
	 */
//	public static void tapOnElement(WebElement element) {
//		TouchAction action = new TouchAction(getDriver());
//		action.tap((TapOptions) element);
//	}

	/**
	 * This method performs click operation on the element which we have passed as
	 * an argument
	 * 
	 * @param element
	 */
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	/**
	 * This method will perform click operation on the Element for the text
	 * attribute which matches to text which we have passed as an argument out of
	 * the List<WebElements>
	 * 
	 * @param listOfElements
	 * @param text
	 */
	public static void clickAfterTextMatch(List<WebElement> listOfElements, String text) {
		int size = listOfElements.size();
		for (int i = 0; i < size; i++) {
			WebElement ele = listOfElements.get(i);
			String s = ele.getText();
			if (s.equalsIgnoreCase(text)) {
				ele.click();
				break;
			}

		}
	}

	/**
	 * This method performs click operation on the element for which the text
	 * property has been passed as an argument
	 * 
	 * @param:text:The text
	 *                     property of the element on which we want to click
	 */
	public static void clickOnElementUsingText(String text) {
		((FindsByAndroidUIAutomator<MobileElement>) getDriver()).findElementByAndroidUIAutomator("text(\"" + text + "\")").click();
	}

	/**
	 * This method will send the text at the location for which we have specified
	 * the locator
	 * 
	 * @param element
	 *            at which we want to send the text
	 * @param text:which
	 *            we want to send
	 */
	public static void sendText(WebElement element, String text) {
		element.sendKeys(text);

	}
	/**
	 * This method clears the text if there is already some pre-typed/saved text in the textbox
	 * @param:element Accepts a paramter for the element which we want to clear the text
	 */
	public static void clearText(WebElement element) {
		element.clear();
	}
	/**
	 * This method will return the text value of the Element of our interest which
	 * we have passed as an argument
	 */
	public static String getTextOfElement(WebElement element) {
		String s = element.getText();
		return s;
	}

	/**
	 * This method will perform scroll function until an element for which the text
	 * is matching and we pass this as an argument
	 * 
	 * @param text
	 */
	public static void scrollTo1(String text) {
		getDriver().findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}
	/**
	 * This method performs 
	 * @param text
	 */
	public static void scrollTo2(String text){                
	     ((FindsByAndroidUIAutomator<MobileElement>) getDriver()).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
	   }
	
	/**
	 * 
	 * This method will perform long press on the WebElement parameter passed
	 * 
	 * @param:WebElement ele
	 *                       on which we want to perform long press on
	 */
//	public static void longPressOnElement(LongPressOptions ele) {
//		TouchAction action = new TouchAction(getDriver());
//		action.longPress(ele);
//	}

	/**
	 * This will apply fluent wait until the given element is visible
	 * 
	 * @param element:Accepts
	 *            WebElement element as an argumentS
	 * @throws MalformedURLException
	 */
	public static void applyWaitsUntilElementVisible(WebElement element) throws MalformedURLException {
		WebDriverWait wait=new WebDriverWait(BaseClass.getDriver(), 15);
		wait.until(ExpectedConditions.visibilityOf(element)); 
	}

	/**
	 * This method will apply fluent wait until the specified element becomes
	 * clickable
	 * 
	 * @param element
	 */
	public static void applyWaitsUntilElementClickable(WebElement element) {
		WebDriverWait wait=new WebDriverWait(BaseClass.getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.withTimeout(15, TimeUnit.SECONDS); 
	}

	/**
	 * This method will give explicit wait for the specified duration
	 * 
	 * @param timeInSeconds
	 * @throws MalformedURLException
	 */
	public static void applyFluentWait(int timeInSeconds) throws MalformedURLException {
		WebDriverWait wait=new WebDriverWait(BaseClass.getDriver(), 15); 
		wait.withTimeout(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method apply implicit wait and takes argument as integer value as time
	 * duration in seconds for which time the wait will be applied for
	 * 
	 * @param timeInSeconds
	 * @throws MalformedURLException
	 */
	public static void applyImplicitWait(int timeInSeconds) throws MalformedURLException {
		getDriver().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * This method takes String filepath as a parameter and it is
	 * 
	 * @param filepath:The
	 *            path where we want to save the screenshot
	 * @return the filepath which we have passed as a parameter
	 * @throws IOException
	 */
	public static String takeScreenshot(String filepath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		FileUtils.copyFile(srcFile, destFile);
		return filepath;
	}

	/**
	 * This method takes screenshot whenever called and returns the String filepath
	 * where we want the screenshot to save
	 * 
	 * @param filepath
	 * @return: String filepath where we want to save the Buffered Image of PNG type
	 * @throws HeadlessException
	 * @throws AWTException
	 * @throws IOException
	 */
	public static String takeScreenshotUsingRobot(String filepath) throws HeadlessException, AWTException, IOException {
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "PNG", new File(filepath));
		return filepath;

	}

	/**
	 * This method will give us the attribute or property value for the element of
	 * our interest and it needs that WebElement as well as the attribute key 
	 * 
	 * @param :
	 *            Locator of type accessibilityID
	 * @param:elementPropertyOrAttribute for
	 *                                       which we want to get the
	 *                                       property/attribute value
	 * @return value of the property/attribute
	 */
	public static String getElementAttribute(WebElement element, String attributeKey) {
		
		AndroidElement ele=(AndroidElement) element; 
		String value=ele.getAttribute(attributeKey); 
		return value; 
		
	}

	/**
	 * 
	 * @return:boolean result if the given element is selected or not
	 */
	public static boolean isElementSelected(String accessibilityID) {
		MobileElement element = ((MobileElement) getDriver()).findElementById(accessibilityID);
		boolean isSelected = element.isSelected();
		return isSelected;
	}

	public static void dragAndDrop(WebElement element) {
		TouchAction action = new TouchAction((PerformsTouchActions) getDriver());
		// action.longPress(element(source)).moveTo
	}

	public static void getColorFromScreenshot(WebElement element) throws HeadlessException, AWTException {
		MobileElement ele = (MobileElement) element;
		Point point = ele.getCenter();
		int centreX = point.getX();
		int centreY = point.getY();
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		int color = image.getRGB(centreX, centreY);
		int red = (color & 0x00ff0000) >> 16;
		int green = (color & 0x0000ff00) >> 8;
		int blue = color & 0x000000ff;
		System.out.println("Red Color value = " + red);
		System.out.println("Green Color value = " + green);
		System.out.println("Blue Color value = " + blue);
	}

	/**
	 * This method will handle when the video starts. It accepts parameter as two
	 * WebElements. One which will click on the screen and the other which will
	 * fetch the exact video time
	 * 
	 * @param element1
	 * @param element2
	 */
	public static void handleVideoWait(WebElement element1, WebElement element2) {

		element1.click();
		String totalVideoTime = element2.getText();
		System.out.println(totalVideoTime);
		int totalWaitingMins = Integer.parseInt(totalVideoTime.split(":")[0]);
		int totalWaitingSecs = Integer.parseInt(totalVideoTime.split(":")[1]);
		int minSecs = (totalWaitingMins) * 60;
		int totalWait = (minSecs + totalWaitingSecs + 5) * 1000;
		System.out.println("Waiting for Video to complete. Waiting for '" + (totalWait) / 1000 + "' seconds");
		int wait = 0;
		try {
			while (wait < totalWait) {
				applyFluentWait(5);
				element1.click();
				wait = wait + 5000;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Waited till '" + (totalWait) / 1000 + "' seconds");
	}

	/**
	 * This method presses the TAB button and will move the location of the driver
	 * instance from current element to the next available element
	 * 
	 * @throws AWTException
	 */
	public void tabPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

	}

}
