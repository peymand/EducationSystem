package aero.mahan.controller;

import aero.mahan.biz.BLO.SemesterBLO;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.panels.SemesterPanel;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class AdminMainFrame extends JFrame {

  //  JTabbedPane adminTabs;
    SemesterForm semesterForm;
//    SemesterBLO semesterBLO;

    public AdminMainFrame() {
        super("Administration Environment");
        setBounds(700, 200, 900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        semesterForm = new SemesterForm();
  //      adminTabs = new JTabbedPane();

  //      this.add(adminTabs, BorderLayout.CENTER);
  //      adminTabs.add(semesterForm);
   //     adminTabs.insertTab("Semester", null, semesterForm, null, 0);
   //     adminTabs.setTabPlacement(JTabbedPane.LEFT);

this.add(semesterForm);
    }

}
