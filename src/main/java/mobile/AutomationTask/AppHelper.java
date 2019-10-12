package mobile.AutomationTask;

import java.io.FileReader;
import java.util.List;
import com.opencsv.CSVReader;

import io.appium.java_client.MobileElement;

public class AppHelper {

	public void SetFieldText(MobileElement ME, String FieldText) {
		ME.clear();
		ME.sendKeys(FieldText);

	}

	// ====================================================
	public String FormatResult(String num1, String num2, String operand, double result) {

		String OpRes;
		if (result == Double.NEGATIVE_INFINITY || result == Double.POSITIVE_INFINITY)
			//In case of dividing by Zero
		{
			OpRes = num1 + ".00 " + operand + " " + num2 + ".00 = "+ result;
			//Display the result as it is
		}
		else
		{
			//Convert the double provided as a parameter into string in order to deal with it later in the script
			String resultString = String.valueOf(result);
			
			//Get the length of double result converted to string 
			int resultLength = resultString.length();
			
			//Get the length of sting after the decimal point "."
			int decimalLength = resultString.substring(resultString.indexOf(".")).length();
			//Calculating the required length to max 4 digits after the decimal point
			int reqLength = resultLength - decimalLength + 4;
			
			// Get the result as a string by getting the substring of "resultString"
			// starting from 0 to the minimum length between the resultString.length() &
			// reqLength
			String finalResultStr = resultString.substring(0, Math.min(resultString.length(), reqLength));
			//Perform rounding for the result retrieved in the previous step in order to limit the number of digits of the retrieved results
			//and that rounding is for 2 digits after the decimal point
			double finalResultValue = round(Double.parseDouble(finalResultStr),2);
			
			if(finalResultStr.substring(finalResultStr.indexOf(".")).length() < 3)
			{
				//if the length starting from the decimal point is less than 3 then add "0" at the end of the final result
				OpRes = num1 + ".00 " + operand + " " + num2 + ".00 = "+ finalResultValue+0;
			}
			else
			{
				//else if the length is longer than 3 , put the result as it is previously formulated without adding any extra digits
				OpRes = num1 + ".00 " + operand + " " + num2 + ".00 = "+ finalResultValue;
			}
		}
		
		return OpRes;
	}

	// ======================================================
	public static Object[][] csvFileReader(String filePath) throws Exception {
		//Reading the test data from a csv file
		CSVReader readPass = new CSVReader(new FileReader(filePath));
		List<String[]> list = readPass.readAll();
		String[][] array = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		readPass.close();
		return array;
	}

	// ========================================================
	//perform rounding on doible values
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

}
