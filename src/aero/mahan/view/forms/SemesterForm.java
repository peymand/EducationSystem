package aero.mahan.view.forms;

import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IsemesterNotifier;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterForm extends JPanel {

    private JLabel semesterYear, semesterNo;



    private JTextField academicYearText, semesterNoText;
    private JButton addBtn, saveBtn, deleteBtn, editBtn;
    private IsemesterNotifier iSemesterNotifier;


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

        semesterYear = new JLabel("Semester Year:");
        semesterNo = new JLabel("Semester No:");

        academicYearText = new JTextField(10);
        semesterNoText = new JTextField(10);

        addBtn = new JButton();
        ImageIcon addImg = new ImageIcon("resources\\icons\\folder-plus.png");
        addBtn.setIcon(addImg);

        saveBtn = new JButton();
        ImageIcon saveImg = new ImageIcon("resources\\icons\\floppy-disk.png");
        saveBtn.setIcon(saveImg);

        deleteBtn = new JButton();
        ImageIcon deleteImg = new ImageIcon("resources\\icons\\folder-minus.png");
        deleteBtn.setIcon(deleteImg);

        editBtn = new JButton();
        ImageIcon editImg = new ImageIcon("resources\\icons\\pencil.png");
        editBtn.setIcon(editImg);

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {

                Semester s = new Semester();
                s.setSemesterYear(Integer.parseInt(getAcademicYearText()));
                s.setTermNo(Integer.parseInt(getSemesterNoText()));
                iSemesterNotifier.addEventOccurred(s);
                SemesterForm.clreanTextFields(academicYearText,semesterNoText);
            }
        });


        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Semester s = new Semester();
                s.setSemesterYear(Integer.parseInt(getAcademicYearText()));
                s.setTermNo(Integer.parseInt(getSemesterNoText()));
                iSemesterNotifier.editEventOccurred(s);
                SemesterForm.clreanTextFields(academicYearText,semesterNoText);

            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    iSemesterNotifier.saveEventOccurred(null);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Semester deletedSemester = new Semester();
                deletedSemester.setSemesterYear(Integer.parseInt(getAcademicYearText()));
                deletedSemester.setTermNo(Integer.parseInt(getSemesterNoText()));
                iSemesterNotifier.deleteEventOccurred(deletedSemester);
                SemesterForm.clreanTextFields(academicYearText,semesterNoText);
            }
        });
        designComponentLayout();

    }

    public String getAcademicYearText() {
        return academicYearText.getText();
    }
    public void setAcademicYearText(int text){
        this.academicYearText.setText(String.valueOf(text));
    }
    public void setSemesterNoText(int semesterNoText) {
        this.semesterNoText.setText(String.valueOf(semesterNoText));
    }
    public String getSemesterNoText() {
        return semesterNoText.getText();
    }

    public void setISemesterNotifier(IsemesterNotifier x) {
        this.iSemesterNotifier = x;
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
        add(semesterYear, c);

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

    public static void clreanTextFields(JTextField academicYearText, JTextField semesterNoText){
        academicYearText.setText(null);
        semesterNoText.setText(null);
    }

}
