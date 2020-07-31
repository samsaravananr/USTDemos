package Support;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Scrolls 
{

	AndroidDriver<MobileElement> myD;
	
	public Scrolls(AndroidDriver<MobileElement> myD)
	{
		this.myD=myD;
	}
	
	public void ScrollToText(String vText)
	{
		myD.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+vText+"\"));");
	}
	
}
