package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage 
{

	public ProductPage(AppiumDriver myd)
	{
		PageFactory.initElements(new AppiumFieldDecorator(myd), this);
	}
		
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> productAddCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement addToCartButton;
	
	
}
