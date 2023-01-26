package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class _04_ApachePOIGetNOTLAR {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/Capitals.xlsx";

        FileInputStream inputStream=new FileInputStream(path);


        Workbook workbook = WorkbookFactory.create(inputStream);


        Sheet sheet = workbook.getSheet("Sayfa1");

        int rows = sheet.getLastRowNum();
        int cols=sheet.getRow(0).getLastCellNum();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (sheet.getRow(i).getCell(j).getCellType())
                {
                    case STRING:
                        System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());break;
                    case NUMERIC:
                        System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());break;
                    case BOOLEAN:
                        System.out.println(sheet.getRow(i).getCell(j).getBooleanCellValue());break;
                }
            }
            System.out.println();

        }

        double num=sheet.getRow(0).getCell(2).getNumericCellValue(); // değerleri cinsine göre alma
        double num2=sheet.getRow(1).getCell(2).getNumericCellValue();
        double toplam=num+num2;
        System.out.println("toplam = " + toplam);

        // * ITERATOR METHOD
        System.out.println("ITERATOR METHOD");

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.iterator();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case STRING:
                        System.out.println(cell.getStringCellValue());break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue());break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());break;
                }
            }
            System.out.println();
            }

        // * FOREACH METHOD
        System.out.println("FOREACH METHOD");

        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                }
            }
            System.out.println();
        }
    }
}


