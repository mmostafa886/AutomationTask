package mobile.AutomationTask;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mobile.AutomationTask.AppDriverSetup;
import mobile.AutomationTask.AppLogic;

public class AppTest extends AppDriverSetup {

	AppLogic ApL;
	AppHelper ApH = new AppHelper();

	@BeforeTest
	public void DSetup() throws MalformedURLException {

		AppDriverSetup.Setup();
		AppDriverSetup.getDriver();

	}

	@AfterTest
	public void close() {
		AppDriverSetup.termination();
	}

	// ================================================================
	@DataProvider(name = "NumbersDataProvider")
	public Object[][] PWordDataProvider() throws Exception {
		return AppHelper.csvFileReader("Data/Numbers.csv");
	}
	// ================================================================

	@Test(priority = 2, dataProvider = "NumbersDataProvider")
	public void Addition(String Num01, String Num02) throws InterruptedException {
		ApL = new AppLogic();
		System.out.println("TC#1: Addition");
		ApL.Add(Num01, Num02);
		Assert.assertEquals(ApL.OperationResult, ApL.ExpectedResult);

	}

	@Test(priority = 3, dataProvider = "NumbersDataProvider")
	public void Subtraction(String Num01, String Num02) {
		ApL = new AppLogic();
		System.out.println("TC#2: Subtraction");
		ApL.Sub(Num01, Num02);
		Assert.assertEquals(ApL.OperationResult, ApL.ExpectedResult);
	}

	@Test(priority = 4, dataProvider = "NumbersDataProvider")
	public void Multiblication(String Num01, String Num02) {
		ApL = new AppLogic();
		System.out.println("TC#3: Multiblication");
		ApL.Multi(Num01, Num02);
		Assert.assertEquals(ApL.OperationResult, ApL.ExpectedResult);

	}

	@Test(priority = 5, dataProvider = "NumbersDataProvider")
	public void Division(String Num01, String Num02) {
		ApL = new AppLogic();
		System.out.println("TC#4: Division");
		ApL.Div(Num01, Num02);
		Assert.assertEquals(ApL.OperationResult, ApL.ExpectedResult);

	}

	@Test(priority = 6, dataProvider = "NumbersDataProvider")
	public void ResetFields(String Num01, String Num02) {
		System.out.println("TC#5: ResetFields");
		ApL = new AppLogic();
		ApL.ResetBtnOperation(Num01, Num02);
		Assert.assertNotEquals(ApL.FirstFieldTxt, null);
		Assert.assertNotEquals(ApL.SecondFieldTxt, null);

	}

	@Test(priority = 1)
	public void OperationWithEmptyFields() {
		System.out.println("TC#6: Perform Operation With Empty_Fields");
		ApL = new AppLogic();
		ApL.PerformOperation(AppLogic.AdditionBtn);
		Assert.assertEquals(ApL.OperationResult, "Please, fill the input fields correctly");
		ApL.PerformOperation(AppLogic.SubBtn);
		Assert.assertEquals(ApL.OperationResult, "Please, fill the input fields correctly");
		ApL.PerformOperation(AppLogic.MultiBtn);
		Assert.assertEquals(ApL.OperationResult, "Please, fill the input fields correctly");
		ApL.PerformOperation(AppLogic.DivBtn);
		Assert.assertEquals(ApL.OperationResult, "Please, fill the input fields correctly");

	}

}
