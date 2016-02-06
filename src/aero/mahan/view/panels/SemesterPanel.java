package aero.mahan.view.panels;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterPanel extends JPanel {
    private JLabel academicYear;
    private JLabel semesterNo;
    private JTextField academicYearText;
    private JTextField semesterNoText;

    public JLabel getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(JLabel academicYear) {
        this.academicYear = academicYear;
    }

    public JLabel getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(JLabel semesterNo) {
        this.semesterNo = semesterNo;
    }

    public JTextField getAcademicYearText() {
        return academicYearText;
    }

    public void setAcademicYearText(JTextField academicYearText) {
        this.academicYearText = academicYearText;
    }

    public JTextField getSemesterNoText() {
        return semesterNoText;
    }

    public void setSemesterNoText(JTextField semesterNoText) {
        this.semesterNoText = semesterNoText;
    }

    public SemesterPanel() {
        Dimension dim = new Dimension();
        dim.height = 200;
        dim.width = 700;
        setPreferredSize(dim);
        setMinimumSize(dim);
        TitledBorder professorTitledBorder = new TitledBorder("Academic Year");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(professorTitledBorder,innerBorder));
        setLayout(new GridBagLayout());
        designComponentLayout();
    }


    private void designComponentLayout() {
        GridBagConstraints c = putAcademicYearOnForm();
        putSemesterNoOnForm(c);
    }

    public GridBagConstraints putAcademicYearOnForm() {
        GridBagConstraints c = new GridBagConstraints();
        setAcademicYear(new JLabel("Academic Year"));
        c.ipadx = 3;
        c.weighty = 0.05;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(getAcademicYear(), c);

        setSemesterNoText(new JTextField(10));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 1;
        add(getSemesterNoText(), c);
        return c;
    }

    public void putSemesterNoOnForm(GridBagConstraints c) {
        setSemesterNo(new JLabel("Semester Number"));
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 1;
        add(getSemesterNo(), c);

        setSemesterNoText(new JTextField(10));
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 1;
        add(getSemesterNoText(), c);
    }
}