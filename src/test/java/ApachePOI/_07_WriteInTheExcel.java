package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // var olan Excel e yazma işlemi

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // okuma modu açıldı
        Workbook workbook = WorkbookFactory.create(inputStream); // excel deki workbook hafızaya alındı
        Sheet sheet = workbook.getSheetAt(0);

        // Hafızada işlemlere devam ediliyor

        Row yeniSatir = sheet.createRow(0); // satır oluşturuldu 0. yerde
        Cell yeniHucre = yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı

//        for (int i = 1; i < 10; i++) {
//            yeniSatir.createCell(i).setCellValue(i); // Merhaba Dünya 1 2 3 4 5 6 7 8 9
//
//        }

        // sıra kapatmaya geldi, bütün bilgiler hafızada buraya kadar , her şey Workbook da
        inputStream.close(); // okuma modu, kanalı kapatılıyor

        //Yazma işlemini YAZMA modunda açıp öyle yapacağız. (SAVE)
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); // workbook excel dosyasına yazıldı (save)
        workbook.close(); // workbook için ayrılan hafıza boşaltıldı. (excel kapatıldı)
        outputStream.close(); // yazma için açılan kanal kapatıldı. ( program excel kanalı kapatıldı)
        System.out.println("işlem tamamlandı");
    }
}
