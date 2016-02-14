package aero.mahan.controller;

//import aero.mahan.biz.BLO.LoginBLO;
import aero.mahan.biz.BLO.LoginBLO;
import aero.mahan.view.forms.LoginForm;
import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginMainFrame extends JFrame {
    
    LoginForm loginForm;
    LoginBLO loginBLO;

    public LoginMainFrame(){

        loginForm = new LoginForm();
        loginBLO = new LoginBLO();

        setTitle("Login Page");
        setBounds(700, 500, 500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(loginForm);

        loginForm.setiLoginNotifer(new IloginNotifier() {
            @Override
           public void loginEventOccurred(String username, String password) {
                try {
                    loginBLO.checkUser(username, password);

               } catch (SQLException e) {
                   JOptionPane.showMessageDialog(null, "DB is not ready");
                }
            }
        });
    }
}
