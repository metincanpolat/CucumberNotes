package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("İstenen sutun");
        int sutun= read.nextInt();


        String donenSonuc = bul(sutun);
        System.out.println("donenSonuc = " + donenSonuc);
    }

    public static String bul(int sutun)
    {
        String donecek="";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Sheet sheet;


        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(sutun) != null)
                donecek += sheet.getRow(i).getCell(sutun)+"\n";
        }
        return donecek;
    }

}
