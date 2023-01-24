package Vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcel(String sheet,int rowNo,int ceNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.getCell(ceNo);
		String value = ce.getStringCellValue();
		return value;
		
		
		
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	
	public void writeDataInExcellShee(String sheet,int rowNo,int celNo,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(rowNo);
		Cell ce  = rw.createCell(celNo);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	/*this method will read multiple data from 
	 * 
	 */
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IConstantsUtility.excelFilePath);
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh  = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j = 0;j<lastCell;j++) {
				
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
				
				
			}
			
		}
		return data;
		
		
		
		
		
		
		
		 
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
