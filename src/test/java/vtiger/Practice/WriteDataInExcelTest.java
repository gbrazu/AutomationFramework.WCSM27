package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelTest {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Organization");
		
		Row rw = sh.getRow(1);
		
		Cell ce = rw.createCell(7);
		
		ce.setCellValue("Raju");
		
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		wb.write(fos);
		System.out.println("Data added");
		wb.close();
		

	}

}
