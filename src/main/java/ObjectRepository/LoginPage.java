package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{

	public LoginPage(AppiumDriver myD)
	{
		PageFactory.initElements(new AppiumFieldDecorator(myD), this);
	}
	
	@AndroidFindBy(id = "android:id/text1")
	public WebElement countryList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Australia']")
	public WebElement countryData;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement userName;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	public WebElement female;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	public WebElement male;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;
	
	public WebElement signIn()
	{
		return letsShop;
	}
	
}
