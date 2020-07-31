package com.youtube.org.E2E_FRAMEWORK_YOUTUBE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import ObjectRepository.YoutubeHomePage;
import Support.TestData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class MainTCYouTube extends BaseYouTube
{

	@Test (dataProvider = "YouTubeVideoSearch", dataProviderClass =TestData.class )
	public void TC002(String vVideo) throws Exception
	{
		service=startServer();
		AndroidDriver<MobileElement> myD=basecall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		YoutubeHomePage youtube=new YoutubeHomePage(myD);
		youtube.searchButton.click();
		Thread.sleep(4000);
		youtube.searchText.sendKeys(vVideo);
		Thread.sleep(4000);
		youtube.searchData.click();
		Thread.sleep(10000);
		youtube.ustVideo.click();
		Thread.sleep(10000);
		myD.closeApp();
		service.stop();
		
	}
	
}
