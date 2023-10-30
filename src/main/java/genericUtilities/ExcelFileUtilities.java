package genericUtilities;
/**
 * 
 * Class for Excel utilities
 * @author rajes
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtilities {
	
	/**
	 * This method will Read data from Excel File
	 * @param sheetName
	 * @param x
	 * @param y
	 * @return String
	 * @throws Throwable
	 */
	public String readExcelData(String sheetName,int x, int y) throws Throwable {
		
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test_Data2.xlsx");
	String value = WorkbookFactory.create(fis).getSheet(sheetName).getRow(x).getCell(y).getStringCellValue();
	return value;
//	 Workbook wb = WorkbookFactory.create(fis);
//	 wb.createSheet("Contact").createRow(5).createCell(6).setCellValue("Hello World!");
//	FileOutputStream fos=new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\Test_Data2.xlsx");
//	wb.write(fos);
//	wb.close();
	}
	
	/**
	 * This method will Write data in Excel File
	 * @param setData
	 * @param row
	 * @param cell
	 * @param sheetName
	 * @throws Throwable
	 */
	public void writeExcelData(String setData, int row, int cell, String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test_Data2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(setData);
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Test_Data2.xlsx");
		book.write(fos);
		book.close();
		
	}

	/**
	 * This method will Read multiple data from Excel File
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test_Data2.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
			for(int x=0;x<lastRow;x++) {
				for(int y=0;y<lastCell;y++) {
					data[x][y] = sh.getRow(x+1).getCell(y).getStringCellValue();
				}
			}
			return data;
	}



}
