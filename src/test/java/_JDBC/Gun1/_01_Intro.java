package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {

        // başlangıç bilgilerini girme.
        // java bağlantı: mysql e bağlantı : url(hostname)  : port / DB name
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root"; // username
        String password="'\"-LhCB'.%k[4S]z"; // password

        //connection açılıyor (fileinputstream gibi)

        Connection connection = DriverManager.getConnection(url,username,password); // bağlantıya click

        // sql lerin yazılacağı sayfa
        Statement statement = connection.createStatement(); // sorguları çalıştırmam için sayfa aç (query tool)

        ResultSet rs = statement.executeQuery("select * from actor"); // sorgunun sonuçları oluştu, DB de bekliyor.
        // hızlı çalıştırmak için sonuçların hepsi bilgisayara gelmedi

        rs.next(); // ilk satır bilgisayara geldi, ilk satırı aldık.

        String firstname = rs.getString("first_name");
        String lastname = rs.getString("last_name");
        System.out.println("1.Satır firstname ve lastname = " + firstname +" "+ lastname);

        rs.next(); // ikinci satır bilgisayara geldi, ikinci satırı aldık.

        firstname = rs.getString("first_name");
        lastname = rs.getString("last_name");
        System.out.println("1.Satır firstname ve lastname = " + firstname +" "+ lastname);

        connection.close(); // connection kapatıldı

    }



}
