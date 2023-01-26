package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _05_Soru {
    public static void main(String[] args) {

        /**
         * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
         * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
         * yani metoda "password" kelimesi gönderilecek, dönen değer password un değeri olacak.
         * bulup ve sonucun döndürülmesi için metod kullanınız.
         * src/test/java/ApachePOI/resources/LoginData.xlsx
         */

        Scanner read = new Scanner(System.in);
        System.out.println("Aranacak Kelime");
        String arananKelime= read.nextLine();


        String donenSonuc = bul(arananKelime);
        System.out.println("donenSonuc = " + donenSonuc);
    }

    public static String bul(String arananKelime)
    {
        String donecek="";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook;


        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);

            if (cell.toString().equalsIgnoreCase(arananKelime))
            {
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    donecek += row.getCell(j)+" ";
                }
            }
        }
        return donecek;
    }
    //2. kısa yazılış
//    public static String bul2(String arananKelime)
//    {
//        String donecek="";
//
//        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
//
//        Workbook workbook=null;
//
//
//        try {
//            FileInputStream inputStream = new FileInputStream(path);
//            workbook = WorkbookFactory.create(inputStream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Sheet sheet = workbook.getSheetAt(0);
//
//        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//
//            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(arananKelime))
//            {
//                for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
//                    donecek += sheet.getRow(i).getCell(j)+" ";
//                }
//            }
//        }
//        return donecek;
//    }



}
