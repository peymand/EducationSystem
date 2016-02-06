package aero.mahan.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class DbUtil {

    public Connection con;

    public boolean connect() throws SQLException {

        if (con != null) {
            return true;
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionURL = "jdbc:sqlserver://swsql.mahanair.aero;user=sa;password=123;database=javaTraining";
        con = DriverManager.getConnection(connectionURL);
        System.out.println("Connected");

        if (con == null) {
            return false;
        }
        return true;
    }

    public boolean disConnect(){
        if (con != null) {
            try {
                con.close();
                System.out.println("Disconnected");
            } catch (SQLException e) {
                System.out.println("Could not disconnect");
            }
        }
        return true;
    }

}
