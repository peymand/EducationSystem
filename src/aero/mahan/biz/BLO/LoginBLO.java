package aero.mahan.biz.BLO;

import aero.mahan.data.DAO.LoginDAO;
import aero.mahan.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginBLO {
    LoginDAO loginDAO;
    public  LoginBLO(){
        loginDAO = new LoginDAO();
    }

    public ArrayList<Person> checkUser(String username,String password) throws SQLException{
        return loginDAO.checkUser(username,password);
    }

}
