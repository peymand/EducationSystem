package aero.mahan.view.panels;

import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterPanel extends JSplitPane {

    SemesterForm semesterForm;
    SemesterTable semesterTable;

    public SemesterPanel(int i) {
        super(VERTICAL_SPLIT);
        this.semesterForm = new SemesterForm();
        this.semesterTable = new SemesterTable();
        this.setTopComponent(semesterForm);
        this.setBottomComponent(semesterTable);
    }

}