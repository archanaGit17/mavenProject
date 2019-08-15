package org.test1.MavenProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate 
{
	public static void main(String[] args) throws IOException 
	  {
	    File exl=new File("C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\Excel\\ExcelRead.xlsx");
	    FileInputStream stream = new FileInputStream(exl);
	    Workbook w=new XSSFWorkbook(stream);
	    Sheet s=w.getSheet("Datas");
	    Row r=s.getRow(2);
	    Cell c=r.getCell(0);
	    String name= c.getStringCellValue();
	    if(name.equals("Hema"))
	    {
	    	c.setCellValue("Hemalatha");
	    }
	    FileOutputStream o=new FileOutputStream(exl);
	    w.write(o);
	    System.out.println("Update Over");
	  }
}
