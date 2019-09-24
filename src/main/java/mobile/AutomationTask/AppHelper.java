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
		{
			OpRes = num1 + ".00 " + operand + " " + num2 + ".00 = "+ result;
		}
		else
		{
			String resultString = String.valueOf(result);
			
			int resultLength = resultString.length();
			int decimalLength = resultString.substring(resultString.indexOf(".")).length();
			int reqLength = resultLength - decimalLength + 4;
			
			String finalResultStr = resultString.substring(0, Math.min(resultString.length(), reqLength));
			double finalResultValue = round(Double.parseDouble(finalResultStr),2);
			
			if(finalResultStr.substring(finalResultStr.indexOf(".")).length() < 3)
			{
				OpRes = num1 + ".00 " + operand + " " + num2 + ".00 = "+ finalResultValue+0;
			}
			else
			{
				OpRes = num1 + ".00 " + operand + " " + num2 + ".00 = "+ finalResultValue;
			}
		}
		
		return OpRes;
	}

	// ======================================================
	public static Object[][] csvFileReader(String filePath) throws Exception {
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
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

}
