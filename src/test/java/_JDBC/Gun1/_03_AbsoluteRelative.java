package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs=statement.executeQuery("select * from film");

        rs.absolute(10); // 10. satıra git
        String title = rs.getString("title");
        System.out.println(title);

        rs.absolute(15); // 15. satıra git
        title = rs.getString("title");
        System.out.println(title);

        rs.absolute(-15); // sondan 15. satıra gider
        title = rs.getString("title");
        System.out.println(title);

        rs.absolute(10); // 10.satıra git
        title=rs.getString("title");
        System.out.println(title);

        rs.relative(5); // bulunduğum konumdan 5 satır ileri git.
        title=rs.getString("title");
        System.out.println(title);
    }



}
