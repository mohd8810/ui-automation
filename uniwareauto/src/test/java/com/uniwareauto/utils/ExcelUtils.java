package com.uniwareauto.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	
	private static final String CellData = null;

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	private static DataFormatter objDefaultFormat;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	 
	public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}
			

	}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	 
    public static String getCellData(int RowNum, int ColNum) throws Exception{

    	String CellData="";
			try{

  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
  			int type = Cell.getCellType();
  					if (type == XSSFCell.CELL_TYPE_NUMERIC){
  						 System.out.println((int)Cell.getNumericCellValue());
  						 int numdata=(int)Cell.getNumericCellValue();
  						 CellData=String.valueOf(numdata);
  					}else if(type==XSSFCell.CELL_TYPE_STRING){
  						CellData = Cell.getStringCellValue();
  						System.out.println(CellData);
  					}
  					 

  			return CellData;

  			}catch (Exception e){

				return"";

  			}

    }
	/*public static void main() throws Exception{
		ExcelUtils.setExcelFile("C:\\Users\\Administrator\\workspace\\ems\\testdata.xlsx", "Sheet1");
		String username=ExcelUtils.getCellData(1, 0);
		String password=ExcelUtils.getCellData(1, 1);
		System.out.println(username);
		System.out.println(password);
		
	}*/
}
