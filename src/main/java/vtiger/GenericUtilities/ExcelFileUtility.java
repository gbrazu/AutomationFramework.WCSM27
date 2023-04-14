package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author v-bgelli
 *
 */
public class ExcelFileUtility 
{
	public String ReadDataFromExcelFile(String sheet,int rowno, int cellno) throws IOException
	{
		FileInputStream fise = new FileInputStream(IConstantsUtiltiy.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		String value = wb.getSheet(sheet).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}
	
	public void WriteIntoExcel(String sheetname, int rowno, int cellno, String value) throws Exception, IOException
	{
		FileInputStream fise = new FileInputStream(IConstantsUtiltiy.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.createRow(rowno);
		Cell ce = rw.createCell(cellno);
		ce.setCellValue(value);
		
		FileOutputStream fose = new FileOutputStream(IConstantsUtiltiy.ExcelFilePath);
		wb.write(fose);
		wb.close();
		
		
	}
	/**
	 * This method will read data from excel sheet and return it to data provider
	 * @param sheetname
	 * @return
	 * @throws Exception
	 */
	public Object[][] readDataFromExcelToDataProvider(String sheetname) throws Exception
	{	
		FileInputStream fise = new FileInputStream(IConstantsUtiltiy.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][]data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)//for loop to navigate inside the row
		{
			for(int j=0;j<lastCell;j++)//for loop to navigate the cells
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();//we use i+1 here because we already have a header in the excel file
			}
			
				
		}
		return data;
		
		
	}
	

}
