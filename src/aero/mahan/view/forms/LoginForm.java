package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;

/**
 * Created by 92474747 on 1/26/2016.
 */

/*
* @Author : Fatemeh Kashefi
* */
public class LoginForm extends JPanel {
    IloginNotifier iloginNotifier;

    JLabel usernameLbl;
    JTextField username;

    public void setIloginformNotifier(IloginNotifier loginNotifier) {
        this.iloginNotifier = loginNotifier;
    }
}
