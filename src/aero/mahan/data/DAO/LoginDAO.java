package aero.mahan.data.DAO;

import aero.mahan.controller.AdminMainFrame;
import aero.mahan.controller.LoginMainFrame;
import aero.mahan.data.DbUtil;
import aero.mahan.model.Person;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class LoginDAO {
    DbUtil dbUtil;
    private Statement st;

    public Integer checkUser(String userName, String passWord) throws SQLException {
        dbUtil = new DbUtil();
        dbUtil.connect();
        st = dbUtil.con.createStatement();
        String result;
        Person person = new Person();
        ResultSet res = st.executeQuery("SELECT [Username],[Password],[Id_Type] FROM [JavaTraining].[dbo].[Edu_Core_User]   where Username='" + userName + "'and Password='" + passWord + "'");

        if (res.next()) {
            person.setIdType(res.getInt("Id_Type"));
            if (person.getIdType()==1){
                return 1;
            }else if (person.getIdType()==2){
                return 2;
            }else
                return 3;


        } else {
            throw new SQLException("Invalid User Name/Password");
        }
    }

}
