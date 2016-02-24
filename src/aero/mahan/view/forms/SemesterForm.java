package aero.mahan.view.forms;

import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IsemesterNotifier;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterForm extends JPanel {

    private JLabel academicYear, semesterNo;
    private JTextField academicYearText, semesterNoText;
    private JButton addBtn, saveBtn, deleteBtn, editBtn;
    private IsemesterNotifier isemesterNotifier;

    public String getAcademicYearText() {
        return academicYearText.getText();
    }

    public String getSemesterNoText() {
        return semesterNoText.getText();
    }

    public void setISemesterNotifier(IsemesterNotifier x) {
        this.isemesterNotifier = x;
    }

    public SemesterForm() {

        Dimension dim = new Dimension();
        dim.height = 200;
        dim.width = 700;
        setPreferredSize(dim);
        setMinimumSize(dim);
        TitledBorder semesterTitledBorder = new TitledBorder("Academic Year");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(semesterTitledBorder, innerBorder));
        setLayout(new GridBagLayout());

        academicYear = new JLabel("Academic Year:");
        semesterNo = new JLabel("Semester No:");

        academicYearText = new JTextField(10);
        semesterNoText = new JTextField(10);

        addBtn = new JButton("Add");
        saveBtn = new JButton("Save");
        deleteBtn = new JButton("Delete");
        editBtn = new JButton("Edit");

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {

                Semester s = new Semester();
                s.setSemesterYear(Integer.parseInt(getAcademicYearText()));
                s.setTermNo(Integer.parseInt(getSemesterNoText()));
                isemesterNotifier.addEventOccurred(s);
            }

        });

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isemesterNotifier.saveEventOccurred(null);
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        designComponentLayout();

    }

    private void designComponentLayout() {
        GridBagConstraints c = putAcademicYearOnForm();

    }

    public GridBagConstraints putAcademicYearOnForm() {
        GridBagConstraints c = new GridBagConstraints();
//        c.gridwidth =7;
//        c.gridheight= 3;

        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;

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
        add(addBtn, c);

        c.gridx = 1;
        c.gridy = 3;
        add(saveBtn, c);

        c.gridx = 2;
        c.gridy = 3;
        add(deleteBtn, c);

        c.gridx = 3;
        c.gridy = 3;
        add(editBtn, c);

        return c;
    }

}
