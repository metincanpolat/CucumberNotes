package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    // city tablosundaki tüm kayıtlardaki isimleri next ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri absolute ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri relative ile yazdırınız.


    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        int countRow = 0;
        while (rs.next())
        {
            System.out.println(rs.getString("city"));
            countRow++;
        }
        System.out.println("Toplam Satır Saytısı = "+countRow);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rsCount=statement.executeQuery("select count(*) from city");
        rsCount.next();
        int countDB= rsCount.getInt(1);
        rsCount.close();

        ResultSet rs=statement.executeQuery("select * from city");


        for (int i = 1; i <= countDB; i++) {
            rs.absolute(i);
            String title=rs.getString("city");
            System.out.println(title);

        }
        // bunu da aynı şekilde while döngüsü ile de yapabiliriz

    }

    @Test
    public void test3() throws SQLException {
        ResultSet rsCount=statement.executeQuery("select count(*) from city");
        rsCount.next();
        int countDB= rsCount.getInt(1);
        rsCount.close();

        ResultSet rs = statement.executeQuery("select * from city");

        int n = 1;

        for (int i = 0; i < countDB; i++) {
            rs.relative(n);
            System.out.println(rs.getString("city"));
        }
    }
}
