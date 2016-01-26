package aero.mahan.utility;

import aero.mahan.view.forms.LoginForm;

import javax.swing.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class AppStart {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm();
            }
        });
    }
}
