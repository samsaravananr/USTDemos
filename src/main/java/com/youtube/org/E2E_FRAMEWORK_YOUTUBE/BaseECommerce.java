package com.youtube.org.E2E_FRAMEWORK_YOUTUBE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.GetPageSource;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseECommerce 
{
	public static AppiumDriverLocalService service;
	public static AndroidDriver<MobileElement> myD;

	public AppiumDriverLocalService startServer() throws Exception
	{
		
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	
	
	
	public void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Support\\Emulator.bat");
		Thread.sleep(20000);
	}
	
	public AndroidDriver<MobileElement> basecall() throws Exception
	{	
		
	FileInputStream fis=new FileInputStream("C:\\Users\\SARAVANAN R\\Mobile\\E2E_FRAMEWORK_YOUTUBE\\src\\main\\java\\com\\youtube\\org\\E2E_FRAMEWORK_YOUTUBE\\config.properties");
	Properties prop=new Properties();
	prop.load(fis);
	
	String vMobileType=prop.getProperty("MobilePlatformType");
	String vOS=prop.getProperty("MobilePlatformOS");
	//String vEmulatorName=prop.getProperty("EmulatorName");
	String vPackage=prop.getProperty("PackageName");
	String vActivity=prop.getProperty("ActivityName");
	String vTime=prop.getProperty("TimeOut");
	//String vDriver=prop.getProperty("DriverURL");
	
	String vEmulatorName=System.getProperty("eName");
	String vDriver=System.getProperty("eDriver");
	
	startEmulator();
		
	DesiredCapabilities DC=new DesiredCapabilities();
	DC.setCapability(vMobileType, vOS);
	DC.setCapability(MobileCapabilityType.DEVICE_NAME,vEmulatorName);
	//APP Details
	DC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, vPackage);
	DC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, vActivity);
	DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, vTime);
	myD=new AndroidDriver<>(new URL(vDriver),DC);
	return myD;
	}

	
		


}