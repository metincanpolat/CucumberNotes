package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_Soru {
    /*
      Yeni bir excele merhaba Dünya 1 şeklinde yazdıktan sonra , programı tekrar
      çalıştırdığınızda aynı excelin bir alt satırına devam ediniz.
      Program her çalıştıkça aşağıdaki gibi olmalı
      Merhaba Dünya 1
      Merhaba Dünya 2
      Merhaba Dünya 3
       ....
       ....
       path="";
       File dosya=new File(path)

       if (dosya.exists()  // dosya var mı
     */
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/Soru9.xlsx";
        File f = new File(path); // dosya kontrol için bir dosya değişkeni oluşturuldu, sadece varlık kontrolü için

        if (!f.exists()) // dosya yok ise
        {
            // hafizada oluştur yeni olduğu için
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");

            // bilgiyi yaz
            Row yeniSatir = sheet.createRow(0);
            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue("Merhaba Dünya 1");

            // save
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("işlem tamamlandı");
        }
        else //dosya var ise
        {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows(); // Kaç tane row
            // bilgini yaz
            Row newRow = sheet.createRow(rowCount); // varolanın 1 altına
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue("Merhaba Dünya "+(rowCount+1));

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }




    }
}
