package Vtiger.GenericUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Date;

public class DatabaseUtility {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		JavaUtility jutil = new JavaUtility();
		int data = jutil.getRandomNumber();
		System.out.println(data);
		
		String date = jutil.getSystemDateInFormat();
		System.out.println(date);
		
		PropertyFileUtility pr = new PropertyFileUtility();
		String value1 = pr.readDataFromProprtyFile("browser");
		System.out.println(value1);
		
		ExcelFileUtility ex = new ExcelFileUtility();
		String value2 = ex.readDataFromExcel("contacts", 1, 2);
		System.out.println(value2);
		String contactName	= ex.readDataFromExcel("contacts", 1, 2);
		System.out.println(contactName);
		int numberOfRows = ex.getRowCount("contacts");
		System.out.println(numberOfRows);
		ex.writeDataInExcellShee("contacts", 6, 8,"writing Data");
		
	}
}
