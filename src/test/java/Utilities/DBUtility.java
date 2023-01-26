package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {


    public static ArrayList<ArrayList<String>> getListData(String query){
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        // DB den bütün satırları ve kolonları okuyup liste atıcam

        DBConnectionOpen();

        try {
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();


            while (rs.next()) {
                ArrayList<String> rowData = new ArrayList<>(); // Her bir satırı arraylist yaptık
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getString(i));
                }
                table.add(rowData);                            // Yaptığımız satır arraylist lerini table arraylist ine ekledik.
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DBConnectionClose();

        return table;
    }

    public static void main(String[] args){ // deneme maksatlı var.
        ArrayList<ArrayList<String>> tablo = getListData("select * from actor");

        System.out.println(tablo);
    }

    public static Connection connection;

    public static Statement statement;

    public static void DBConnectionOpen()
    {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
