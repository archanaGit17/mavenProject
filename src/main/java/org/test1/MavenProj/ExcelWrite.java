package org.test1.MavenProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelWrite 
{
  public static void main(String[] args) throws IOException 
  {
	  File exl=new File("C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\Excel\\ExcelWrite11.xlsx");
	  Workbook w=new XSSFWorkbook();
	  Sheet s=w.createSheet("Test");
	  Row r=s.createRow(0);
	  Cell c=r.createCell(0);
	  c.setCellValue("JAVA");
	  FileOutputStream o=new FileOutputStream(exl);
	  w.write(o);
	  System.out.println("Over");
	  
  }

}
