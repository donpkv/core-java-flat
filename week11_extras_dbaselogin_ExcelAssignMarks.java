package dbaselogin;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class ExcelAssignMarks {
  static JFrame fr=null;
   //JDialog jd=null;
  static JFileChooser jf=null;
  static File f;
  static String picFileName;
  static int count=0;
  static int rowCount=0;
  static HSSFWorkbook my_workbook=null;
  static HSSFSheet sheet =null;
   private String value1;
   private String value2;
   private String value3;


          public static void main(String...ar)
          {
             String fileName="D:\\data\\java_post_test_11_to_21.xls";
              searchPicCol(fileName,"Form Responses 1");
          }

             static void searchPicCol(String fileName, String sheetName) {
                 FileInputStream inputStream=null;
       try {

                     inputStream = new FileInputStream(new File(fileName));

                     my_workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
                     /* my_workbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream("D:\\jamuna_rani\\data\\new_auto_numbring.xls")));*/
                     sheet = my_workbook.getSheet(sheetName);
                     /* Read the input image into InputStream */

                 } catch (Exception e) {

                     System.out.println("There is an Error my dear " + e);
                 }

                 System.out.println(" Total : " + sheet.getPhysicalNumberOfRows());


                 Boolean flag = false;
                 String searchValue = "";




                   setSheet1tDetail(inputStream,my_workbook);


               /*  if(sheetName.equals("Sheet1")) {
                     //setsheet1Detail(LObj, dbob, groupNameTableName, testDetailTableName, subGroupNameTableName);
                 }else if(sheetName.equals("Sheet4"))
             */
             }





    private static void setSheet1tDetail(FileInputStream inputStream, HSSFWorkbook my_workbook) {
        for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {

            count = 0;


            Row row = sheet.getRow(i);

            if (row != null) {


                int cellCount = row.getPhysicalNumberOfCells();

                //JOptionPane.showMessageDialog(fr, "CellCount "+cellCount, "", 1);


                for (int j = 2; j <= cellCount; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);

                        String ansVal = cell.getStringCellValue();

                        System.out.println("CellVal : "+ansVal);

                         setCellValues(j,cell,ansVal);


                    }

                }


            }
        }
            try {
                if(inputStream!=null) {
                    inputStream.close();
                }
                FileOutputStream outputStream = new FileOutputStream("D:\\data\\marks_copy_java_post_test_11_to_21.xls");
                my_workbook.write(outputStream);
                outputStream.close();
            }catch (Exception e)
            {
                e.printStackTrace();
        }

    }


    private static void setCellValues(int pos, Cell cell, String ansVal) {

        if (pos == 2) {

            if(ansVal.startsWith("B"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 3) {

            if(ansVal.startsWith("D"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 4) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 5) {

            if(ansVal.startsWith("B"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 6) {

            if(ansVal.startsWith("A"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 7) {

            if(ansVal.startsWith("B"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 8) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 9) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 10) {

            if(ansVal.startsWith("D"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 11) {

            if(ansVal.startsWith("D"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }        else  if (pos == 12) {

            if(ansVal.startsWith("B"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }        else  if (pos == 13) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }        else  if (pos == 14) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 15) {

            if(ansVal.startsWith("B"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }        else  if (pos == 16) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }

    }



}


/*
 For Genpact Test Day 1 to 5
    private static void setCellValues(int pos, Cell cell, String ansVal) {

        if (pos == 2) {

            if(ansVal.startsWith("D"))
                cell.setCellValue("2");
            else if(ansVal.startsWith("B") || ansVal.startsWith("C"))
                cell.setCellValue("1");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 3) {

            if(ansVal.startsWith("F"))
                cell.setCellValue("2");
            else if(ansVal.startsWith("B") || ansVal.startsWith("C") || ansVal.startsWith("D"))
                cell.setCellValue("1");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 4) {

            if(ansVal.startsWith("G"))
                cell.setCellValue("3");
            else if(ansVal.startsWith("C") || ansVal.startsWith("D") || ansVal.startsWith("E"))
                cell.setCellValue("1");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 5) {

            if(ansVal.startsWith("C") || ansVal.startsWith("E"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 6) {

            if(ansVal.startsWith("D"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 7) {

            if(ansVal.startsWith("E"))
                cell.setCellValue("3");
            else if(ansVal.startsWith("B") || ansVal.startsWith("D"))
                cell.setCellValue("1");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 8) {

            if(ansVal.startsWith("F"))
                cell.setCellValue("3");
            else if(ansVal.startsWith("C") || ansVal.startsWith("D"))
                cell.setCellValue("1");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 9) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 10) {

            if(ansVal.startsWith("E"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 11) {

            if(ansVal.startsWith("D"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }        else  if (pos == 12) {

            if(ansVal.startsWith("A") || ansVal.startsWith("C"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }        else  if (pos == 13) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }        else  if (pos == 14) {

            if(ansVal.startsWith("A"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }
        else  if (pos == 15) {

            if(ansVal.startsWith("C"))
                cell.setCellValue("2");
            else
                cell.setCellValue("0");


        }        else  if (pos == 16) {

            if(ansVal.startsWith("A") || ansVal.startsWith("B"))
                cell.setCellValue("3");
            else
                cell.setCellValue("0");


        }

    }
*/
