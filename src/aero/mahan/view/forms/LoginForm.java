package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class LoginForm extends JPanel {
    IloginNotifier iloginNotifier;

    public void setIloginformNotifier(IloginNotifier loginNotifier) {
        this.iloginNotifier = loginNotifier;
    }
}
