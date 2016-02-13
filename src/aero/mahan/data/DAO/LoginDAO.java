package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import aero.mahan.model.Person;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.sql.*;

public class LoginDAO {
    DbUtil dbUtil;
    private Statement st;

    public void
    checkUser(String userName, String passWord) throws SQLException {
        dbUtil = new DbUtil();
        dbUtil.connect();
        st = dbUtil.con.createStatement();

        ResultSet res = st.executeQuery("SELECT [Username],[Password],[Id_Type] FROM [JavaTraining].[dbo].[Edu_Core_User]   where Username='"
                + userName + "'and Password='" + passWord + "'");

        if (res.next()) {

            JOptionPane.showMessageDialog(null, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid User Name/Password");
        }
    }

}
