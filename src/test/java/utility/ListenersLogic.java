package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersLogic implements ITestListener 
{
	//public static WebDriver driver;
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestSuccess(result);
		Date d1 = new Date();
		Date d2 = new Date(d1.getTime());
		String s1 = d2.toString();
		String month = s1.substring(4, 7);
		String date = s1.substring(8, 10);
		String year = s1.substring(s1.length() - 4);
		String format1 = date.concat(month).concat(year);
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\anuna\\GroTechMinds-Automation Projects\\Project01_AmazonApplication\\test-output\\Screenshot\\Pass\\"+ result.getName() + format1 + ".png");
		try 
		{
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestFailure(result);
		Date d1 = new Date();
		Date d2 = new Date(d1.getTime());
		String s1 = d2.toString();
		String month = s1.substring(4, 7);
		String date = s1.substring(8, 10);
		String year = s1.substring(s1.length() - 4);
		String format1 = date.concat(month).concat(year);
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\anuna\\GroTechMinds-Automation Projects\\Project01_AmazonApplication\\test-output\\Screenshot\\Fail\\"+ result.getName() + format1 + ".png");
		try 
		{
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
