package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        // dosyanın yolu alındı
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";


        // JavaDosya okuma işlemcisine dosyanın yolunu veriyoruz:
        // böylece program ile dosya arasında bağlantı oluştu.
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);

        // Dosya okuma işlemcisi üzerinden Çalışma Kitabını alıyorum.
        // hafızada workbook u alıp oluşturdu
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);


        // istediğim isimdeki çalışma sayfasını alıyorum. Hangi çalışma sayfasını istiyorsak onun ismini yazıyoruz.
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");
//        Sheet calismaSayfasi = calismaKitabi.getSheetAt(0); // bu şekilde indexini de vererek çağırabiliyoruz.

        // istenen satırı alıyorum
        Row satir = calismaSayfasi.getRow(0);

        Cell hucre = satir.getCell(0);

        System.out.println(hucre);




    }
}
