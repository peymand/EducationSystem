package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {

    JLabel usernameLbl;
    JTextField usernameTxt;
    JLabel passwordLbl;
    private JPasswordField passwordField;
    private GridBagConstraints layout;
    private JButton loginBtn;
    IloginNotifier iloginNotifier;

    public LoginForm() {
        setSize(500, 150);
        setVisible(true);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        createFields();
        //"Enter Key" keyboard action
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
        layout.ipadx = 15;

        usernameLbl = new JLabel("Username : ");
        usernameLbl.setVisible(true);
        layout.gridx = 0;
        layout.gridy = 0;
        add(usernameLbl, layout);

        usernameTxt = new JTextField(15);
        usernameTxt.setVisible(true);
        layout.gridx = 1;
        layout.gridy = 0;
        add(usernameTxt, layout);

        passwordLbl = new JLabel("Password : ");
        passwordLbl.setVisible(true);
        layout.gridx = 0;
        layout.gridy = 1;
        add(passwordLbl, layout);

        passwordField = new JPasswordField(15);
        passwordField.setVisible(true);
        layout.gridx = 1;
        layout.gridy = 1;
        add(passwordField, layout);

        loginBtn = createLoginButton("Login");
        layout.gridx = 1;
        layout.gridy = 2;
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
                if(Validation.checkTextFieldIsEmpty(usernameTxt.getText())& Validation.checkTextFieldIsEmpty(passwordField.getText())){
                    usernameTxt.setBorder(border);
                    passwordField.setBorder(border);
                    JOptionPane.showMessageDialog(null,"Please Enter Username/Password");
                }else {
                    usernameTxt.setBorder(defultBorder);
                    passwordField.setBorder(defultBorder);
                    iloginNotifier.loginEventOccurred(usernameTxt.getText(), passwordField.getText());
                }
                if(!iloginNotifier.loginEventOccurred(usernameTxt.getText(), passwordField.getText())){
                    JOptionPane.showMessageDialog(null, "Invalid User Name/Password");
                }

            }
        });
        return myButton;
    }
}


