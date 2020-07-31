package com.youtube.org.E2E_FRAMEWORK_YOUTUBE;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseYouTube
{
	public AndroidDriver<MobileElement> myD;
	public AppiumDriverLocalService service;
	
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
	
	public AndroidDriver<MobileElement> basecall() throws Exception
	{
	DesiredCapabilities DC=new DesiredCapabilities();
	DC.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	DC.setCapability(MobileCapabilityType.DEVICE_NAME,"sharonEmulator");

	DC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.youtube");
	DC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.youtube.HomeActivity");
	
	myD=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),DC);
	return myD;
	
	}

	

	}
