package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Odev {
    /**  Soru 1:
     *  yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
     */

    /**  Soru 2:
     * yeni excel
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
     */
    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("CarpimTablosuAlt");

        Row row;
        Cell cell;
        int t=1;

        while (t<=10) {
            for (int i = 1; i <= 10; i++) {
                row = sheet1.createRow(sheet1.getPhysicalNumberOfRows());
                cell = row.createCell(row.getPhysicalNumberOfCells());
                cell.setCellValue(i + " x " + t + " = " + (i * t));
            }
            row = sheet1.createRow(sheet1.getPhysicalNumberOfRows());
            t++;
        }

        Sheet sheet2 = workbook.createSheet("CarpimTablosuYan");

        CellStyle cellStyle;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
            row = sheet2.createRow(sheet2.getPhysicalNumberOfRows());
            row.createCell(row.getPhysicalNumberOfCells()).setCellValue(i+ "x"+j+"="+i*j);

            }
        }

//        int z=2;
//
//        for (int i = 0; i <= 10; i++) {
//            sheet2.getRow(i).createCell(2).setCellValue(333);
//        }
//            z+=2;






















        for (int i = 1; i <= 10; i++) {
            int n=1;
            row = sheet2.createRow(sheet2.getPhysicalNumberOfRows());
            for (int j = 0; j < 20; j+=2) {
                cell = row.createCell(j);
                cellStyle = cell.getSheet().getWorkbook().createCellStyle();
                cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
                cellStyle.setFillPattern(FillPatternType.DIAMONDS);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(i + " x " + n + " = " + (i * n));
                n++;
            }
        }




        String path = "src/test/java/ApachePOI/resource/CarpimTablosu.xlsx";

        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

//        for (int i = 1; i <= 10; i++) {
//            row = sheet2.createRow(sheet2.getPhysicalNumberOfRows());
//            cell = row.createCell(row.getPhysicalNumberOfCells());
//            cell.setCellValue(i + " x " + t + " = " + (i * t));
//        }
//        for (int i = 2; i <= 20; i+=2) {
//            int k=2;
//            for (int j = 0; j <= 10; j++) {
//                sheet2.getRow(j).createCell(i).setCellValue((j+1) + " x " + k + " = " + ((j+1) * k));
//            k++;
//            }
//        }