package practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
//		Step 1 Open the data in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test_Data2.xlsx");
		
//		Step2 Create Workbook
		Workbook book = WorkbookFactory.create(fis);
		
//		Step3 Navigate to required sheet
		Sheet sheet = book.getSheet("Contact");
		
//		Step4 Navigate to required row
		Row row = sheet.getRow(1);
		
//		Step5 Navigate to required Cell
		Cell cell = row.getCell(2);
		
//		Step6 Capture the value and Print
		String val = cell.getStringCellValue();
		System.out.println(val);
	}

}
