package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IsemesterNotifier;
import aero.mahan.view.panels.SemesterPanel;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterForm extends JPanel {

    JSplitPane splitPane;
    SemesterPanel semesterPanel;
    SemesterTable semesterTable;
    IsemesterNotifier isemesterNotifier;

    public SemesterForm() {
        semesterPanel = new SemesterPanel();
        semesterTable = new SemesterTable();
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, semesterPanel, semesterTable);
        splitPane.setOneTouchExpandable(true);

    }


//    public static void main(String[] args) {
//        JFrame myFrame = new JFrame();
//        myFrame.setVisible(true);
//        SemesterForm s = new SemesterForm();
//        myFrame.add(s);
//    }

}
