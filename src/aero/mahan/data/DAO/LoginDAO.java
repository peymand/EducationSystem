package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.sql.*;

/**
 * Created by 921532 on 1/26/2016.
 */
public class LoginDAO {
    DbUtil dbUtil;
    private Statement st;

    public void
    checkUser(String userName, String passWord) throws SQLException {
        dbUtil = new DbUtil();
        dbUtil.connect();
        st = dbUtil.con.createStatement();
        ResultSet res = st.executeQuery("SELECT [Username],[Password] FROM [JavaTraining].[dbo].[Edu_Core_User]   where Username='"
                + userName + "'and Password='" + passWord + "'");

        if (res.next()) {
            JOptionPane.showMessageDialog(null, "Login Sucessfull.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid User Name/Password");
        }
    }
}
