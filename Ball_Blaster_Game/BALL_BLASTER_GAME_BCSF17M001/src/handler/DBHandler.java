package handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBHandler {

    public static Statement stmt = null;

    public static void makeConnectionWithDataBase() {
        try {
            Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String DB_portno = "3305";
            String DB_userName = "root";
            String DB_password = "12345";
            String DB_databaseName = "ballblaster";
            con = DriverManager.getConnection("jdbc:mysql://localhost:" + DB_portno + "/" + DB_databaseName, DB_userName, DB_password);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
