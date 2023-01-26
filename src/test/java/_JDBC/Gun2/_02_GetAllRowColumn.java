package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void Test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        // ResultSet : data + dğer bilgiler yani MetaData (data dışındaki bilgiler; kolın sayısı, tipleri, isimleri)

        ResultSetMetaData rsmd = rs.getMetaData();
        // Sonuçların haricindeki diğer bilgiler: colonSayisi.....

        int columncount = rsmd.getColumnCount();
        System.out.println("columncount = " + columncount);

        for (int i = 1; i <=columncount ; i++)
        {
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);

            System.out.println("columnName = " + columnName);
            System.out.println("columnType = " + columnType);
        }
    }
    @Test
    public void Test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // tablonun başlıkları için
        for (int i = 1; i <= columnCount; i++)
            System.out.print(rsmd.getColumnName(i)+"\t");

        System.out.println();

        while (rs.next())
        {
            // kürsorun bulunduğu satırdaki tüm kolonlardaki datalar yazdırılıyor
            for (int i = 1; i <= rsmd.getColumnCount() ; i++)
                System.out.print(rs.getString(i)+"\t");

            System.out.println();
        }

    }
    @Test
    public void Test3() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // tablonun başlıkları için
        for (int i = 1; i <= columnCount; i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next())
        {
            // kürsorun bulunduğu satırdaki tüm kolonlardaki datalar yazdırılıyor
            for (int i = 1; i <= rsmd.getColumnCount() ; i++)
                System.out.printf("%-20s",rs.getString(i));

            System.out.println();
        }
        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2f" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane

    }
    // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız,
    // aynı mysql sonuç ekranında olduğu gibi
    // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

    @Test
    public void Test4() throws SQLException {
        getTable("select * from actor");
    }

    public void getTable(String query) throws SQLException {
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // tablonun başlıkları için
        for (int i = 1; i <= columnCount; i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next())
        {
            // kürsorun bulunduğu satırdaki tüm kolonlardaki datalar yazdırılıyor
            for (int i = 1; i <= rsmd.getColumnCount() ; i++)
                System.out.printf("%-20s",rs.getString(i));

            System.out.println();
        }

    }

    public void getTable2(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%d ", rsmd.getColumnDisplaySize(i));

        System.out.println();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                if (rsmd.getColumnDisplaySize(i) > 100) {
                    System.out.printf("%-100s ", rs.getString(i).substring(0, rs.getString(i).length() > 100 ? 100 : rs.getString(i).length()));
                } else
                    System.out.printf("%-" + rsmd.getColumnDisplaySize(i) + "s ", rs.getString(i));
            }

            System.out.println();
        }
    }




}
