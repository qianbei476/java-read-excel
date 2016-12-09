package com;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcel {

	
	public void PrintStringArray(String[] s){	
		for(int i=0;i<s.length;i++)
			System.out.println(s[i]);
	}
	
	public String readexcel() {
		try {

			Workbook workbook = Workbook.getWorkbook(new File("excels/subject_01.xls"));

			Sheet sheet = workbook.getSheet(0);


			for (int j = 0; j < sheet.getRows(); j++){
				for (int i = 0; i < sheet.getColumns(); i++) {
					Cell cell = sheet.getCell(i, j);

					String var1 = cell.getContents();
					
					if(var1.contains("#")){
					String[] var2 =null;
					var2= var1.split("\\#");
					PrintStringArray(var2);
					}
					else
					System.out.println(var1);
				}
				System.out.println("");
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ReadExcel read = new ReadExcel();
		read.readexcel();
		
		
	}
}
