package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {

    private JLabel usernameLbl,passwordLbl;

    public void setUsernameTxt(JTextField usernameTxt) {
        this.usernameTxt = usernameTxt;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JTextField getUsernameTxt() {
        return usernameTxt;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    private JTextField usernameTxt;
    private JPasswordField passwordField;
    private GridBagConstraints layout;
    private JButton loginBtn;
    IloginNotifier iloginNotifier;

    public LoginForm() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        createFields();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iloginNotifier.loginEventOccurred(usernameTxt.getText(), passwordField.getText());
            }
        });
    }

    public void setiLoginNotifer(IloginNotifier loginNotifier) {
        this.iloginNotifier = loginNotifier;
    }

    private void createFields() {
        layout = new GridBagConstraints();
        layout.ipadx = 10;
        layout.ipady = 4;


        usernameLbl = new JLabel("Username : ");
        layout.gridx = 0;
        layout.gridy = 0;

        add(usernameLbl, layout);

        usernameTxt = new JTextField(15);
        layout.gridx = 1;
        layout.gridy = 0;
        add(usernameTxt, layout);
        layout.insets = new Insets(8,0,0,0);

        passwordLbl = new JLabel("Password : ");
        layout.gridx = 0;
        layout.gridy = 2;
        add(passwordLbl, layout);

        passwordField = new JPasswordField(15);
        layout.gridx = 1;
        layout.gridy = 2;
        add(passwordField, layout);

        loginBtn = createLoginButton("Login");
        layout.gridx = 1;
        layout.gridy = 3;

        add(loginBtn, layout);

    }


    private JButton createLoginButton(String login) {
        JButton myButton = new JButton(login);
        myButton.setVisible(true);
        myButton.setSize(25, 30);
        myButton.addActionListener(new ActionListener() {
            Border border = BorderFactory.createLineBorder(Color.red, 1);
            Border defultBorder = BorderFactory.createLineBorder(Color.black, 1);

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Validation.checkTextFieldIsEmpty(usernameTxt.getText()) & Validation.checkTextFieldIsEmpty(passwordField.getText())) {
                    usernameTxt.setBorder(border);
                    passwordField.setBorder(border);
                    JOptionPane.showMessageDialog(null, "Please Enter Username/Password");
                } else {
                    usernameTxt.setBorder(defultBorder);
                    passwordField.setBorder(defultBorder);
                    iloginNotifier.loginEventOccurred(usernameTxt.getText(), passwordField.getText());
                }
            }
        });
        return myButton;
    }
}




