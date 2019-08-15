package org.test1.MavenProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead 
{
 public static void main(String[] args) throws IOException 
  {
    File exl=new File("C:\\Users\\subbian\\eclipse-workspace\\Arch\\MavenProj\\Excel\\ExcelRead.xlsx");
    FileInputStream stream = new FileInputStream(exl);
    Workbook w=new XSSFWorkbook(stream);
    Sheet s=w.getSheet("Datas");
    for(int i=0;i<s.getPhysicalNumberOfRows();i++)
    {
      Row r=s.getRow(i);
      for(int j=0;j<r.getPhysicalNumberOfCells();j++)
       {
         Cell c=r.getCell(j);
         int type=c.getCellType();
         if(type==1)
         {
             String name=c.getStringCellValue();
        	 System.out.println(name);
         }
         if(type==0)
         {
           if(DateUtil.isCellDateFormatted(c))
           {
        	   String name =new SimpleDateFormat("dd-MM-yyyy").format(c.getDateCellValue());
        	   System.out.println(name);
           }
           else
           {
        	 double d=c.getNumericCellValue();
        	 long l=(long)d;
        	 System.out.println("long: "+l);
        	 String name=String.valueOf(l);
        	 System.out.println("String: "+name);
           }
         }
       }
    }
    
  }
}
