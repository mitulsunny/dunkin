package com.dunkin.shadman.onlineStore.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.dunkin.shadman.onlineStore.helper.logger.LoggerHelper;
import com.dunkin.shadman.onlineStore.helper.resource.ResourceHelper;

/**
 * 
 * @author shadmanshahriyar
 *
 */

public class ExcelHelper {
	Logger log = LoggerHelper.getLogger(ExcelHelper.class);
	
	/**
	 * This method will help us to get the data from excel sheet
	 * @return Object[][]
	 */
	
	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSet[][] = null;
			log.info("Trying to read excel sheet");
			FileInputStream file = new FileInputStream(new File(excelLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file); //create workbook instance
			XSSFSheet sheet = workbook.getSheet(sheetName); //get sheet by sheet name
			log.info("Success!");
			int totalRow = sheet.getLastRowNum() + 1; //getting total active number of row
			int totalCollumn = sheet.getRow(0).getLastCellNum();// getting total active number of cells
			
			dataSet = new Object[totalRow][totalCollumn];
			
			Iterator<Row> rowIterator = sheet.iterator(); //iterate through each rows one by one
			int i = 0;
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					switch(cell.getCellTypeEnum()) {
					case STRING:
						dataSet[i][j] = cell.getStringCellValue();
						log.info("Added: cell number ["+i+"]["+j+"]->" + cell.getStringCellValue());
						break;
					case NUMERIC:
						dataSet[i][j] = cell.getNumericCellValue();
						log.info("Added: cell number ["+i+"]["+j+"]->" + cell.getNumericCellValue());
						break;
					case BOOLEAN:
						dataSet[i][j] = cell.getBooleanCellValue();
						log.info("Added: cell number ["+i+"]["+j+"]->" + cell.getBooleanCellValue());
						break;
					case FORMULA:
						dataSet[i][j] = cell.getCellFormula();
						log.info("Added: cell number ["+i+"]["+j+"]->" + cell.getCellFormula());
						break;
					default:
						log.info("Error: cell number ["+i+"]["+j+"]: cell data type not matched");
						break;
					}
					j++;
				}	
				i++;
			}
			
			return dataSet;
		} catch(Exception e) {
			log.info("Error reading excel file...");
			log.info("Details: "+e.getCause());
			return null;
		}
	}
	
	public void printExcelSheet(String sheetLocation, String sheetName) {
		ExcelHelper ex = new ExcelHelper();
		String excelLocation = ResourceHelper.getResourcePath(sheetLocation);
		Object[][] obj = ex.getExcelData(excelLocation, sheetName);
		
		for(int i = 0; i<obj.length; i++) {
			for(int j = 0; j<obj[i].length; j++) {
				System.out.print(obj[i][j].toString() + " ");
			}
			System.out.println("");
		}
	}
	
	public  void updateResult(String sheetLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			log.info("Trying to read excel sheet");
			FileInputStream file = new FileInputStream(new File(sheetLocation));
			XSSFWorkbook workbook = new XSSFWorkbook(file); //create workbook instance
			XSSFSheet sheet = workbook.getSheet(sheetName); //get sheet by sheet name
			log.info("Success!");
			int totalRow = sheet.getLastRowNum() + 1; //getting total active number of row
			
			for(int i = 1; i<totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue(); //here 0 is the cell number
				if(ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus); // here 1 is the second cell number
					file.close();
					FileOutputStream fileOut = new FileOutputStream(new File(sheetLocation));
					workbook.write(fileOut);
					log.info("Updated -> " + testCaseName + ":" + testStatus);
					fileOut.close();
					break;
				}
			}
		} catch(Exception e) {
			log.info("Error reading excel file...");
			log.info("Details: "+e.getCause());
		}
	}
}
