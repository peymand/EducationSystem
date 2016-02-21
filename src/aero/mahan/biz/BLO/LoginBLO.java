package aero.mahan.biz.BLO;

import aero.mahan.data.DAO.LoginDAO;

import java.sql.SQLException;

public class LoginBLO {
    LoginDAO loginDAO;

    public LoginBLO() {
        loginDAO = new LoginDAO();
    }

    public Integer checkUser(String username, String password) throws SQLException {
        return loginDAO.checkUser(username, password);
    }

}
