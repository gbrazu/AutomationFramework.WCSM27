package vtiger.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws Exception 
	{
		//Step1: Load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: get control over sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step4: get control over row
		Row rw = sh.getRow(1);
		
		//Step5: get control over cell
		Cell ce = rw.getCell(2);
		
		//Step6: read the data inside the cell
		String value= ce.getStringCellValue();
		System.out.println(value);
	}

	
	}


