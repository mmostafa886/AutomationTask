package mobile.AutomationTask;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppLogic {
	

	public static AndroidDriver<AndroidElement> AD = AppDriverSetup.getDriver();
	public String OperationResult, ExpectedResult, FirstFieldTxt, SecondFieldTxt;
	AppHelper APH = new AppHelper();
	
	
	  public AppLogic() 
	  {
		  PageFactory.initElements(new AppiumFieldDecorator(AD), this);
	  }
	 
	 
	//======================================
	//Locators
	@FindBy(id = "com.vbanthia.androidsampleapp:id/inputFieldLeft")
	 static MobileElement FirstInputField;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/inputFieldRight")
	static MobileElement SecondInputField;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/additionButton")
	static MobileElement AdditionBtn;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/subtractButton")
	static MobileElement SubBtn;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/multiplicationButton")
	static MobileElement MultiBtn;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/divisionButton")
	static MobileElement DivBtn;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/resetButton")
	static MobileElement ResetBtn;
	
	@FindBy(id = "com.vbanthia.androidsampleapp:id/resultTextView")
	static MobileElement ResultsPan;
	
	//======================================
	public double Add(String int1 , String int2) throws InterruptedException
	{
		
		APH.SetFieldText(FirstInputField, int1);
		APH.SetFieldText(SecondInputField, int2);
		PerformOperation(AdditionBtn);
		System.out.println("Actual Result: "+OperationResult);
		double AddNums = Double.parseDouble(int1) +  Double.parseDouble(int2);
		ExpectedResult = APH.FormatResult(int1, int2, "+",AddNums);
		System.out.println("Expected Result: "+ExpectedResult);
		return AddNums;
	}
	//======================================
	public double Sub(String int1 , String int2)
	{
		APH.SetFieldText(FirstInputField, int1);
		APH.SetFieldText(SecondInputField, int2);
		SubBtn.click();
		OperationResult = ResultsPan.getText();
		System.out.println("Actual Result: "+OperationResult);
		double SubNums = Double.parseDouble(int1) -  Double.parseDouble(int2);
		ExpectedResult = APH.FormatResult(int1, int2, "-",SubNums);
		System.out.println("Expected Result: "+ExpectedResult);
		return SubNums;
	}
	//======================================
	public double Multi(String int1 , String int2)
	{
		APH.SetFieldText(FirstInputField, int1);
		APH.SetFieldText(SecondInputField, int2);
		MultiBtn.click();
		OperationResult = ResultsPan.getText();
		System.out.println("Actual Result: "+OperationResult);
		double MultiNums = Double.parseDouble(int1) *  Double.parseDouble(int2);
		ExpectedResult = APH.FormatResult(int1, int2, "*",MultiNums);
		System.out.println("Expected Result: "+ExpectedResult);
		return MultiNums;
	}
	//======================================
	public double Div(String int1 , String int2)
	{

		APH.SetFieldText(FirstInputField, int1);
		APH.SetFieldText(SecondInputField, int2);
		DivBtn.click();
		OperationResult = ResultsPan.getText();
		System.out.println("Actual Result: "+OperationResult);
		
		double DivNums = Double.parseDouble(int1) /  Double.parseDouble(int2);
		ExpectedResult = APH.FormatResult(int1, int2, "/",DivNums);
		System.out.println("Expected Result: "+ExpectedResult);
		
		return DivNums;
	}
	
	//======================================
	
	public void ResetBtnOperation(String int1 , String int2)
	{
		APH.SetFieldText(FirstInputField, int1);
		APH.SetFieldText(SecondInputField, int2);
		ResetBtn.click();
		FirstFieldTxt = FirstInputField.getText();
		SecondFieldTxt = SecondInputField.getText();
		System.out.println(FirstFieldTxt);
		System.out.println(SecondFieldTxt);
		
	}

	//======================================
	public void PerformOperation(MobileElement ME)
	{
		ME.click();
		OperationResult = ResultsPan.getText();
		
	}

	
}
