package practice.jdbc;

import java.sql.*;

public class HelloDb {
    public static void main(String[] args) {
        JDBCexample("root", "root");
    }

    public static void JDBCexample(String userid, String passwd)
    {
        try
        {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world",
                    userid, passwd);
            Statement stmt = conn.createStatement();
            try {
                stmt.executeUpdate(
                        "insert into city values (5003, 'Tasgaon', 'IND', 'Sangli',100000)");
            } catch (SQLException sqle)
            {
                System.out.println("Could not insert tuple. " + sqle);
            }
            ResultSet rset = stmt.executeQuery(
                    "select * from city");
            while (rset.next()) {
                System.out.println(rset.getString("name") + " " +
                        rset.getLong(1));
            }
            stmt.close();
            conn.close();
        }
        catch (Exception sqle)
        {
            System.out.println("Exception : " + sqle);
        }
    }
}
