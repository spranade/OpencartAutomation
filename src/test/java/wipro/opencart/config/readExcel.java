/**
 * 
 */
package wipro.opencart.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

/**
 * @author Swanand
 *
 */
public class readExcel  {
	
	
	/*
	@DataProvider(name = "testdata")
	public Object[][] passData(String ExcelFilename, String Sheetname) throws Exception {
	
		Hashtable<Integer,String[]> exceldata = Excel_Operations.ReadAllExcelFile(ExcelFilename,Sheetname);
		Set<Integer> keys = exceldata.keySet().stream().sorted().collect(Collectors.toSet());
		Object data[][] = new Object[keys.size() - 1][exceldata.get(keys.size() - 1).length];
		
		int rowIndex = 0;
		for(Integer i : keys){
			if(i != 0){
				String[] columns = exceldata.get(i);
				System.out.println("Reading row: " + i);
				for(int j = 0; j < columns.length; j++){
					System.out.println("column " + j + " value " + columns[j]);
					data[rowIndex][j]=columns[j];
				}
				
				System.out.println(data[0][0]);
				System.out.println(data[0][1]);
				rowIndex++;
			}
		}
		return data;
	}
	
	*/
	
	

		//@SuppressWarnings("deprecation")
		//@DataProvider(name = "testdata")
		public String[][] getExcelData(String excellocation, String sheetName) {
			try {
				String dataSets[][] = null;
				FileInputStream file = new FileInputStream(new File(excellocation));

				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheet(sheetName);
				// count number of active rows
				int totalRow = sheet.getLastRowNum();
				// count number of active columns in row
				int totalColumn = sheet.getRow(0).getLastCellNum();
				// Create array of rows and column
				dataSets = new String[totalRow][totalColumn];
				// Iterate through each rows one by one
				Iterator<Row> rowIterator = sheet.iterator();
				int i = 0;
				while (rowIterator.hasNext()) {
					//System.out.println(i);

					Row row = rowIterator.next();
					// For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					int j = 0;
					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();
						if (cell.getStringCellValue().contains("First Name")) {
							break;
						}

						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							
								int n = (int)cell.getNumericCellValue(); 
								String strCellValue = String.valueOf(n); 
								dataSets[i - 1][j++] =strCellValue;
							//dataSets[i - 1][j++] = cell.getNumericCellValue();
							//System.out.println(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_STRING:
							dataSets[i - 1][j++] = cell.getStringCellValue();
							//System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							dataSets[i - 1][j++] = cell.getStringCellValue();
							//System.out.println(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							dataSets[i - 1][j++] = cell.getStringCellValue();
							//System.out.println(cell.getStringCellValue());
							break;
						}

					}

					System.out.println("");
					i++;
				}
				file.close();
				workbook.close();
				return dataSets;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public static void main(String[] args) throws IOException {
		
			String excelFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\RegistrationDetails.xlsx";
			readExcel ex = new readExcel();
			//Object[][] data = ex.getExcelData("D:\\WIPRO\\Topgear\\automation_opencart_512_testcasesselenium_webdriver\\RegistrationDetails.xlsx", "Sheet1");
			Object[][] data = ex.getExcelData(excelFilepath, "Sheet1");
			System.out.println(data);
			
			
		}
		
}
	
