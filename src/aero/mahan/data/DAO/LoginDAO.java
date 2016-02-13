package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import aero.mahan.model.Person;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 921532 on 1/26/2016.
 */
public class LoginDAO {
    DbUtil dbUtil;
    private Statement st;
    private ArrayList<Person> arrayPerson;

    public ArrayList<Person> checkUser(String userName, String passWord) throws SQLException {
        dbUtil = new DbUtil();
        dbUtil.connect();
        st = dbUtil.con.createStatement();

        ResultSet res = st.executeQuery("SELECT [Username],[Password],[Id_Type] FROM [JavaTraining].[dbo].[Edu_Core_User]   where Username='"
                + userName + "'and Password='" + passWord + "'");

        if (res.next()) {
            checkUserIdType(res);
        }
        return checkUserIdType(res);
    }

    private ArrayList<Person> checkUserIdType(ResultSet res) throws SQLException {
        arrayPerson = new ArrayList<>();
        while (res.next()){
        Person person = new Person();
            person.setUsername(res.getString("Username"));
            person.setPassword(res.getString("Password"));
            person.setIdType(res.getInt("Id_Type"));
            arrayPerson.add(person);
        }
        return arrayPerson;
    }

}
