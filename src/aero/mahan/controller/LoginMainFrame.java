package aero.mahan.controller;

import aero.mahan.biz.BLO.LoginBLO;
import aero.mahan.view.forms.LoginForm;
import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginMainFrame extends JFrame {

    LoginForm loginForm;
    LoginBLO loginBLO;
    AdminMainFrame adminMainFrame;

    public LoginMainFrame() {

        loginForm = new LoginForm();
        loginBLO = new LoginBLO();

        setTitle("Login Page");
        setBounds(700, 500, 390, 180);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(loginForm);

        loginForm.setiLoginNotifer(new IloginNotifier() {
            @Override
            public void loginEventOccurred(String username, String password) {
                try {
                    if (loginBLO.checkUser(username, password) == 1) {
                        dispose();
                        adminMainFrame = new AdminMainFrame();

                    } else
                        JOptionPane.showMessageDialog(null, "Frame has not implemented");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
    }
}
