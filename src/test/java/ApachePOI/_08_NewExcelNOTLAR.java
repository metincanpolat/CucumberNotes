package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class _08_NewExcelNOTLAR {
    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("metin1");

        Object[][] objectListe =
                {
                        {"Personel ID","Name","Position"},
                        {101,"Metin","Amele"},
                        {102,"Ceyhun","Başkan"},
                        {103,"Ali","Müdür"}

                }; // Burada Object tipinde liste ürettik çünkü array üretseydik içerisine tek tipte eleman koymak zorundaydık.
                    // Bu şekilde istediğimiz tipte elaman ekleyebiliriz.

        // Using for loop

        for (int i = 0; i < objectListe.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < objectListe[i].length; j++) {
                Cell cell = row.createCell(j);
                Object value = objectListe[i][j];

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }

        String path = "src/test/java/ApachePOI/resource/NewNotlar.xlsx";
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            workbook.write(outputStream);

            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println("işlem başarıyla tamamlandı");




    }
}
