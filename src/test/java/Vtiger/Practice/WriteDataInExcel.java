package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// Step 1: Load the File Into file Input Stream - Java readable format
		FileInputStream fis = new FileInputStream("C:\\Chaitra Advanced selenuim 2022 Dec\\Data driven Testing datas Sel Adava\\Book1.xlsx");
		
		// Step 2: Create a WorkBook
		Workbook book=WorkbookFactory.create(fis);
		
		// Step 3: Navigate to the required sheet
		Sheet sh=book.getSheet("contact");
		System.out.println();
		
		// Step 4: Navigate to the required row
		Row rw = sh.getRow(4);
		
		// Step 5: Navigate to the required Cell
		Cell ce = rw.createCell(6);
		
		// Step 6: Capture the data present inside the cell
		ce.setCellValue("Qspiders");
		
	}
}
