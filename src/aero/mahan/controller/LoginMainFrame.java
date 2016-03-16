package aero.mahan.controller;

import aero.mahan.biz.BLO.LoginBLO;
import aero.mahan.view.forms.LoginForm;
import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.SQLException;

public class LoginMainFrame extends JFrame {

    private LoginForm loginForm;
    private LoginBLO loginBLO;
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
                Border redBorder = BorderFactory.createLineBorder(Color.red, 1);
                Border defultBorder = BorderFactory.createLineBorder(Color.black, 1);
                try {
                    if (loginBLO.checkUser(username, password) == 1) {
                        dispose();
                         adminMainFrame = new AdminMainFrame();

                    } else
                        JOptionPane.showMessageDialog(null, "Frame has not implemented");
                } catch (SQLException e) {
                    loginForm.getUsernameTxt().setBorder(redBorder);
                    loginForm.getPasswordField().setBorder(redBorder);
                    JOptionPane.showMessageDialog(null, e.getMessage());


                }
            }
        });
    }
}
