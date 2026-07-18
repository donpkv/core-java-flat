package dbaselogin;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class SearchExcelAndStroeInDB {
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
             String fileName="D:\\data\\java_post_test.xls";
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
                        if (ansVal.startsWith("A")) {

                            cell.setCellValue("A");
                        } else if (ansVal.startsWith("B")) {

                            cell.setCellValue("B");
                        } else if (ansVal.startsWith("C")) {

                            cell.setCellValue("C");
                        } else if (ansVal.startsWith("D")) {

                            cell.setCellValue("D");
                        } else if (ansVal.startsWith("E")) {

                            cell.setCellValue("E");
                        } else if (ansVal.startsWith("F")) {

                            cell.setCellValue("F");
                        } else if (ansVal.startsWith("G")) {

                            cell.setCellValue("G");
                        }


                    }

                }


            }
        }
            try {
                if(inputStream!=null) {
                    inputStream.close();
                }
                FileOutputStream outputStream = new FileOutputStream("D:\\data\\copy_java_post_test.xls");
                my_workbook.write(outputStream);
                outputStream.close();
            }catch (Exception e)
            {
                e.printStackTrace();
        }

    }


 /*               if (cell0 != null && cell1 != null && cell2 != null && cell3 != null
            && cell4 != null && cell5 != null && cell6 != null && cell7 != null && cell8 != null) {
        //if(cellref.getCellType()==Cell.CELL_TYPE_NUMERIC)
        //               {


        cell0.setCellType(Cell.CELL_TYPE_STRING);
        cell1.setCellType(Cell.CELL_TYPE_STRING);
        cell2.setCellType(Cell.CELL_TYPE_STRING);
        cell3.setCellType(Cell.CELL_TYPE_STRING);
        cell4.setCellType(Cell.CELL_TYPE_STRING);
        cell5.setCellType(Cell.CELL_TYPE_STRING);
        cell6.setCellType(Cell.CELL_TYPE_STRING);
        cell7.setCellType(Cell.CELL_TYPE_STRING);
        cell8.setCellType(Cell.CELL_TYPE_STRING);

        String reportTitle = String.valueOf(cell0.getStringCellValue());
        String subGroupName = String.valueOf(cell1.getStringCellValue());
        String testName = String.valueOf(cell2.getStringCellValue());
        String unit = String.valueOf(cell3.getStringCellValue());
        String normValMale = String.valueOf(cell4.getStringCellValue());
        String normValFemale = String.valueOf(cell5.getStringCellValue());
        String normValChildMale = String.valueOf(cell6.getStringCellValue());
        String normValChildFemale = String.valueOf(cell7.getStringCellValue());
        String testType = String.valueOf(cell8.getStringCellValue());



        //JOptionPane.showMessageDialog(fr, "numeric converted to string "+searchValue, "", 1);


    }
*/


}
