package aero.mahan.controller;

import aero.mahan.biz.BLO.SemesterBLO;
import aero.mahan.view.forms.SemesterFrom;
import aero.mahan.view.panels.SemesterPanel;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class AdminMainFrame extends JFrame {
    JTabbedPane adminTabs;
    JSplitPane splitPane;

    SemesterFrom semesterFrom;
    SemesterBLO semesterBLO;
    SemesterTable semesterTable;
    SemesterPanel semesterPanel;


    public AdminMainFrame() {
        super("Administration Environment");
        setBounds(700, 200, 900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        adminTabs = new JTabbedPane();
        semesterFrom = new SemesterFrom();
        semesterTable = new SemesterTable();

        add(adminTabs);
        add(semesterFrom);
        add(semesterTable);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, semesterPanel, semesterTable);
        splitPane.setOneTouchExpandable(true);
        adminTabs.add("Semester", splitPane);

    }



}
