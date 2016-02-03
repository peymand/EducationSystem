package aero.mahan.controller;

import aero.mahan.view.forms.LoginForm;
import aero.mahan.view.interfaces.IloginNotifier;

import javax.swing.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
/**
 * @Auther Mohsen Javadi
 */

public class LoginMainFrame extends JFrame {
    
    LoginForm loginForm;
    
    
    
    LoginMainFrame(){

        loginForm.setIloginformNotifier(new IloginNotifier() {
            @Override
            public void loginEventOccurred(String username, String password) {




            }
        });

    }
    
}
