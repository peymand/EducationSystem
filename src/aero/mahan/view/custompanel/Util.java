package aero.mahan.view.custompanel;

import javax.swing.*;
import java.net.URL;

/**
 * Created by 921532 on 3/8/2016.
 */
public class Util {
    public static ImageIcon createIcon(String path){
        URL url = System.class.getResource(path);
        if(url == null){
            System.err.println("unable to load image: "+path);
        }
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }
}
