package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import aero.mahan.model.Person;

import java.sql.*;

public class LoginDAO {
    DbUtil dbUtil;
    private Statement st;

    public Integer checkUser(String userName, String passWord) throws SQLException {
        dbUtil = new DbUtil();
        dbUtil.connect();
        st = dbUtil.con.createStatement();
        Person person;
        ResultSet res = st.executeQuery("SELECT [Username],[Password],[Id_Type] FROM [JavaTraining].[dbo].[Edu_Core_User]   where Username='" + userName + "'and Password='" + passWord + "'");

        if (res.next()) {
            person = new Person();
            person.setIdType(res.getInt("Id_Type"));
            if (person.getIdType() == 1) {
                return 1;
            } else if (person.getIdType() == 2) {
                return 2;
            } else
                return 3;
        } else {
            throw new SQLException("Invalid User Name/Password");
        }
    }

}
