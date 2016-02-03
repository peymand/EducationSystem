package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IsemesterNotifier;
import aero.mahan.view.panels.SemesterPanel;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterFrom extends JPanel{

    SemesterPanel semesterPanel;
    SemesterTable semesterTable;
    IsemesterNotifier isemesterNotifier;

public SemesterFrom(){
    semesterPanel = new SemesterPanel();
    semesterTable = new SemesterTable();
    add(semesterPanel);
    add(semesterTable);
}
}
