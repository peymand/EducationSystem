package aero.mahan.view.forms;

import aero.mahan.view.interfaces.IsemesterNotifier;
import aero.mahan.view.panels.SemesterPanel;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterForm extends JPanel {

    private JLabel academicYear, semesterNo;
    private JTextField academicYearText, semesterNoText;
    private JButton addbtn,savebtn,deletebtn,editbtn;

    public SemesterForm() {
        Dimension dim = new Dimension();
        dim.height = 200;
        dim.width = 700;
        setPreferredSize(dim);
        setMinimumSize(dim);
        TitledBorder professorTitledBorder = new TitledBorder("Academic Year");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(professorTitledBorder, innerBorder));
        setLayout(new GridBagLayout());
        designComponentLayout();

    }

    private void designComponentLayout() {
        GridBagConstraints c = putAcademicYearOnForm();

    }

    public GridBagConstraints putAcademicYearOnForm() {
        GridBagConstraints c = new GridBagConstraints();

        academicYear = new JLabel("Academic Year:");
        semesterNo = new JLabel("semesterNo:");

        academicYearText = new JTextField(10);
        semesterNoText = new JTextField(10);

        addbtn = new JButton("Add");
        savebtn=new JButton("Save");
        deletebtn = new JButton("Delete");
        editbtn = new JButton("Edit");

        c.weighty = 0.05;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        add(academicYear, c);

        c.gridx = 0;
        c.gridy = 1;
        add(semesterNo, c);

        c.gridx = 1;
        c.gridy = 0;
        add(academicYearText, c);

        c.gridx = 1;
        c.gridy = 1;
        add(semesterNoText, c);

        c.gridx = 0;
        c.gridy = 3;
        add(addbtn,c);

        c.gridx=1;
        c.gridy = 3;
        add(savebtn,c);

        c.gridx = 2;
        c.gridy = 3;
        add(deletebtn,c);

        c.gridx = 3;
        c.gridy = 3;
        add(editbtn,c);

        return c;
    }

}
