package learning.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider (name="InputData")
	public Object[][] getDataforInputField() {
		// 2 sets of data
		Object[][] obj=new Object[][]
				{
			{"hello"},{"$@#"}
				};
				return obj;
	}
		
}
