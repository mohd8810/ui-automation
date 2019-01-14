package com.uniwareauto.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CsvReader {

	public static void setCsvFile(String Path,String SheetName)	{
		String[] line = null;
	    CSVReader reader = null;
	   
	        try {
				reader = new CSVReader(new FileReader(Path));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	        try {
				while ((line = reader.readNext()) != null) {
				    //System.out.println("Item SKU Code" + line[0] + ", MRP " + line[1] + " ,Units" + line[2] + "]");
				   
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
}
	    
	}