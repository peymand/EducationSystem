package aero.mahan.data.DAO;

import aero.mahan.controller.AdminMainFrame;
import aero.mahan.controller.LoginMainFrame;
import aero.mahan.data.DbUtil;
import aero.mahan.model.Person;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.sql.*;

public class LoginDAO {
    DbUtil dbUtil;
    private Statement st;

    public void checkUser(String userName, String passWord) throws SQLException {
        dbUtil = new DbUtil();
        dbUtil.connect();
        st = dbUtil.con.createStatement();

        ResultSet res = st.executeQuery("SELECT [Username],[Password],[Id_Type] FROM [JavaTraining].[dbo].[Edu_Core_User]   where Username='" + userName + "'and Password='" + passWord + "'");

//        Person person = new Person();
//        person.setUsername(res.getString("Username"));
//        person.setPassword(res.getString("Password"));
//        person.setIdType(res.getInt("Id_Type"));
        if (res.next()) {
            new AdminMainFrame();

        } else {
//            JOptionPane.showMessageDialog(null, "Invalid User Name/Password");
            throw new SQLException("Invalid User Name/Password");
        }
    }

}
