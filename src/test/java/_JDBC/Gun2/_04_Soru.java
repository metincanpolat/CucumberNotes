package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    // Soru : Actor tablosundaki tüm verileri yeni exele yazdırınız.
    @Test
    public void Test1() throws SQLException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("actor");
        Row row = sheet.createRow(0);
        Cell cell;

        ResultSet rs = statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++)
            row.createCell(i-1).setCellValue(rsmd.getColumnName(i));

        int k = 1;
        while (rs.next())
        {
            row = sheet.createRow(k);

            for (int i = 1; i <= rsmd.getColumnCount() ; i++)
                row.createCell(i-1).setCellValue(rs.getString(i));

            k++;
        }

        String path = "src/test/java/ApachePOI/resource/SQLActor.xlsx";

        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("işlem tamamlandı");

    }
}
