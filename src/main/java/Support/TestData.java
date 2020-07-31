package Support;

import org.testng.annotations.DataProvider;

public class TestData 
{

	@DataProvider(name = "YouTubeVideoSearch")
	public String[][] YouTubeSearch()
	{
		String[][] vSearch=new String[][]
		{
			{"UST India"},{"UST Global"}
		};
			
	return vSearch;
	}
	
}
