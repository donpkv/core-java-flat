/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaselogin;

   import javax.swing.*;
  
   import java.io.*;
   import java.awt.image.*;
   import java.awt.*;
   import javax.imageio.ImageIO;
   import java.awt.event.*;

import java.util.Iterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;


/**
 *
 * @author abhi
 */
public class Wcd {

        static JFrame fr=null; 
     //JDialog jd=null;
    static JFileChooser jf=null; 	  	
    static File f;
    static String  vehNo;
    static JButton btnAutoMalik,btnAutoChalak;
    static String picFileName;  
    static int count=0; 
    static int trckCount=0;
    static int rowCount=0; 	
    static String value="";
    static HSSFWorkbook my_workbook=null;  
    static HSSFSheet sheet =null;
    static boolean flag=true;
    static JButton btnAutoMalikChalak;
   // private static HSSFRow row;
   


    
    /**
     * @param args the command line arguments
*/
                /* Read the input image into InputStream */
 public static void main(String[] args) throws Exception{
       // Workbook workbook =  WorkbookFactory.create(new POIFSFileSystem(new FileInputStream("U:\\java_projects_tutorials\\wcd\\vajan_tyohar.xls")));
        //Sheet sheet = workbook.getSheet("Sheet1");
        //copyRow(workbook, sheet, 0, 3);
      //  FileOutputStream out = new FileOutputStream("U:\\java_projects_tutorials\\wcd\\vajan_tyohar.xls");
        //workbook.write(out);
       // out.close();

         //  insertRowFun();
           calcRowFun();      
 
 }

    private static void insertRowFun() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Row row;
   
     String cellValueMaybeNull="";
 
  String excelFilePath = "U:\\java_projects_tutorials\\wcd\\vajan_tyohar.xls";
         
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            /*Object[][] bookData = {
                    {" ", " ", ""},
                    {" ", " ", ""},
                    {" ", " ", ""},
                    {" ", " ", ""},
            };
            */
            
            
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
    row = sheet.getRow(rowIndex);
  if (row != null) {
    Cell cell = row.getCell(4);
    if (cell != null) {
      // Found column and there is value in the cell.
      //cellValueMaybeNull = cell.getStringCellValue();
      // Do something with the cellValueMaybeNull here ...
  
             cellValueMaybeNull=  cell.getStringCellValue()+","+ cellValueMaybeNull;   

           //System.out.println(rowIndex+"value -->"+cellValueMaybeNull);
            
            String arr[]=  cellValueMaybeNull.split(",");
             
             
                   for (int idx = arr.length-1; idx >= 0; idx--) {
 
                             //System.out.println(idx+"value -->"+arr[idx]);
   
           if(idx>=1 && (arr[idx].equals(arr[idx-1])))
                     {
           
                System.out.println(rowIndex+"--->"+arr[idx]+" and "+arr[idx-1]+"-->"+arr[idx].equals(arr[idx-1]));
                             
                     }  
           else if(idx>=1)
           {
               
                         System.out.println(rowIndex+"--->"+arr[idx]+" and "+arr[idx-1]+"-->"+arr[idx].equals(arr[idx-1]));
 
                         sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
                Row nrow = sheet.createRow(rowIndex);
 
                int columnCount = 0;
                 
                Cell ncell = nrow.createCell(columnCount);
 
               cellValueMaybeNull="";
           }
             /*          
           if(arr[idx]!=arr[idx+1])
                     {
           
                         System.out.println(idx+"value -->"+arr[idx]);
            int rowCount = rowIndex;
 sheet.shiftRows(rowCount, sheet.getLastRowNum(), 1);
                Row nrow = sheet.createRow(rowCount);
 
                int columnCount = 0;
                 
                Cell ncell = nrow.createCell(columnCount);
                   }
         */
                   }
           
    
    }
  }
}
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("U:\\java_projects_tutorials\\wcd\\workbook.xls");
            workbook.write(outputStream);
            outputStream.close();
   
 
                //cell.setCellValue(rowCount);
 
 /*           for (Object[] aBook : bookData) {
 sheet.shiftRows(rowCount, sheet.getLastRowNum(), 2);
                Row row = sheet.createRow(rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 */
            
            
        } catch (IOException  ex) {
            ex.printStackTrace();
        }

    
    }
 
    
    
    
    
      private static void calcRowFun() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Row row;
   
     String cellValueMaybeNull="";
  int intcellValueMaybeNull=0;
  int storeCellValue=0;

  
  String excelFilePath = "U:\\java_projects_tutorials\\wcd\\workbook.xls";
         
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            
            DataFormatter formatter = new DataFormatter();
//String val = formatter.formatCellValue(sheet.getRow(col).getCell(row));

            
            /*Object[][] bookData = {
                    {" ", " ", ""},
                    {" ", " ", ""},
                    {" ", " ", ""},
                    {" ", " ", ""},
            };
            */
            Cell cell=null;
     Cell cell2=null;       
            for (int rowIndex = 3; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
    row = sheet.getRow(rowIndex);
  if (row != null) {
     cell = row.getCell(4);
      cell2 = row.getCell(7);
   
   // if (cell != null && cell2 != null) {
   
        if ( cell2 != null) {
         cell2.setCellType(Cell.CELL_TYPE_STRING);        
        }// Found column and there is value in the cell.
  }  //cellValueMaybeNull = cell.getStringCellValue();
      // Do something with the cellValueMaybeNull here ...
  
         if (row != null && cell != null ) {
             cellValueMaybeNull=  cell.getStringCellValue()+","+ cellValueMaybeNull;   
         }
             
             
             
             String val3="";
             try{
             
                 
                    if (row != null ) {
      
                 
                val3= cell2.getStringCellValue();
                 
                System.out.println(rowIndex+"===>"+val3);
                 
                 intcellValueMaybeNull=  Integer.parseInt(val3)+ intcellValueMaybeNull;   
              // System.out.println(rowIndex+"if --->"+intcellValueMaybeNull);
               
                   }
                    else 
                    {
                      storeCellValue  =intcellValueMaybeNull;
              
                    //   System.out.println(rowIndex+"else--->"+storeCellValue);
              
                      
                        intcellValueMaybeNull=0;
                    }
              
             
             }
             catch(Exception inte)
             {
                 inte.printStackTrace();
                System.out.println(rowIndex+""+val3);
                 
             }
           //System.out.println(rowIndex+"value -->"+cellValueMaybeNull);
            
            String arr[]=  cellValueMaybeNull.split(",");
             
             
                   for (int idx = arr.length-1; idx >= 0; idx--) {
 
                             //System.out.println(idx+"value -->"+arr[idx]);
   
                       
           if(idx>=1 && (arr[idx].equals(arr[idx-1])))
                     {
           
              //  System.out.println(rowIndex+"--->"+arr[idx]+" and "+arr[idx-1]+"-->"+arr[idx].equals(arr[idx-1]));
                             
                     }  
           else if(idx>=1)
           {
               
                //         System.out.println(rowIndex+"--->"+arr[idx]+" and "+arr[idx-1]+"-->"+arr[idx].equals(arr[idx-1]));
 
       //                  sheet.shiftRows(rowIndex, sheet.getLastRowNum(), 1);
             /*   Row nrow = sheet.createRow(rowIndex);
 
                int columnCount = 0;
                 
                Cell ncell = nrow.createCell(columnCount);
 
               cellValueMaybeNull="";
               */
              System.out.println("rowIndex --"+(rowIndex-1));
               Row nrow = sheet.createRow(rowIndex-1);
 
                int columnCount = 0;
                 
                Cell ncell = nrow.createCell(columnCount);
 
               cellValueMaybeNull="";
              
             //if(ncell!=null)              
               ncell.setCellValue(storeCellValue);
               
               System.out.println((rowIndex-1)+"setting rowid val--->"+storeCellValue);
               //intcellValueMaybeNull=0;
               //storeCellValue=0;
              // storeCellValue=0;
           }
             /*          
           if(arr[idx]!=arr[idx+1])
                     {
           
                         System.out.println(idx+"value -->"+arr[idx]);
            int rowCount = rowIndex;
 sheet.shiftRows(rowCount, sheet.getLastRowNum(), 1);
                Row nrow = sheet.createRow(rowCount);
 
                int columnCount = 0;
                 
                Cell ncell = nrow.createCell(columnCount);
                   }
         */
                   }
           
    
  //  }
//  }
}
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("U:\\java_projects_tutorials\\wcd\\workbook2.xls");
            workbook.write(outputStream);
            outputStream.close();
   
 
                //cell.setCellValue(rowCount);
 
 /*           for (Object[] aBook : bookData) {
 sheet.shiftRows(rowCount, sheet.getLastRowNum(), 2);
                Row row = sheet.createRow(rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 */
            
            
        } catch (Exception  ex) {
            ex.printStackTrace();
        }

    
    }
    
    

}   
   


   
  
 

//}
	     //      }
    

