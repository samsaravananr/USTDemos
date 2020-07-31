package com.youtube.org.E2E_FRAMEWORK_YOUTUBE;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;
import ObjectRepository.PaymentsPage;
import ObjectRepository.ProductPage;
import Support.Scrolls;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainTCEcommerce extends BaseECommerce 
{

	@Test
	public void TC001() throws Exception
	{
		service=startServer();
		AndroidDriver<MobileElement> myD=basecall();
		myD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage loginPage=new LoginPage(myD);
		Scrolls scroll=new Scrolls(myD);
		ProductPage products=new ProductPage(myD);
		
		loginPage.countryList.click();
		scroll.ScrollToText("Australia");
		loginPage.countryData.click();
		loginPage.userName.sendKeys("Sharon");
		loginPage.female.click();
		Thread.sleep(2000);
		loginPage.male.click();
		loginPage.letsShop.click();
		Thread.sleep(4000);
		scroll.ScrollToText("Converse All Star");
		//myD.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))"));
		Thread.sleep(2000);
		products.productAddCart.get(0).click();
		Thread.sleep(2000);
		products.productAddCart.get(1).click();
		products.addToCartButton.click();
		
		
		Thread.sleep(4000);
		
		PaymentsPage payments=new PaymentsPage(myD);
		String vPrice1= payments.productPrice.get(0).getText();
		String vPrice2= payments.productPrice.get(1).getText();
		String vTotal = payments.totalAmount.getText();
		System.out.println(vPrice1);
		System.out.println(vPrice2);
		System.out.println(vTotal);
		myD.closeApp();
		service.stop();
			
	}
	
	@BeforeTest
	public void killprocess() throws Exception
	{
		System.out.println("All TASK KILLED");
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	

}
