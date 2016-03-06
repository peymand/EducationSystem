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

public class SemesterForm extends JPanel implements ActionListener {

    private JLabel semesterYearLbl, semesterNoLbl;
    private JTextField semesterYearTxt, semesterNoTxt;
    private JButton addBtn, saveBtn, deleteBtn, editBtn;
    private IsemesterNotifier iSemesterNotifier;


    public SemesterForm() {

        setSemesterBorder();
        setLayout(new GridBagLayout());
        createSemestersFieldsandBtns();
        designComponentLayout();
        addBtn.addActionListener(this);
        editBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        saveBtn.addActionListener(this);


    }


    public String getSemesterYearTxt() {
        return semesterYearTxt.getText();
    }

    public void setSemesterYearTxt(int text) {
        this.semesterYearTxt.setText(String.valueOf(text));
    }

    public void setSemesterNoTxt(int semesterNoTxt) {
        this.semesterNoTxt.setText(String.valueOf(semesterNoTxt));
    }

    public String getSemesterNoTxt() {
        return semesterNoTxt.getText();
    }

    public void setISemesterNotifier(IsemesterNotifier x) {
        this.iSemesterNotifier = x;
    }

    private void createSemestersFieldsandBtns() {
        semesterYearLbl = new JLabel("Semester Year:");
        semesterNoLbl = new JLabel("Semester No:");

        semesterYearTxt = new JTextField(10);
        semesterNoTxt = new JTextField(10);

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
    }

    private void setSemesterBorder() {
        Dimension dim = new Dimension();
        dim.height = 200;
        dim.width = 700;
        setPreferredSize(dim);
        setMinimumSize(dim);
        TitledBorder semesterTitledBorder = new TitledBorder("Semester Information");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(semesterTitledBorder, innerBorder));
    }


    private void designComponentLayout() {
        GridBagConstraints c = putAcademicYearOnForm();

    }

    public GridBagConstraints putAcademicYearOnForm() {
        GridBagConstraints c = new GridBagConstraints();

        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;

        c.gridx = 0;
        c.gridy = 0;
        add(semesterYearLbl, c);

        c.gridx = 0;
        c.gridy = 1;
        add(semesterNoLbl, c);

        c.gridx = 1;
        c.gridy = 0;
        add(semesterYearTxt, c);

        c.gridx = 1;
        c.gridy = 1;
        add(semesterNoTxt, c);

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

    public static void cleanTextFields(JTextField academicYearText, JTextField semesterNoText) {
        academicYearText.setText(null);
        semesterNoText.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            add();
            SemesterForm.cleanTextFields(semesterYearTxt, semesterNoTxt);
        } else if (e.getSource() == editBtn) {
            edit();
            SemesterForm.cleanTextFields(semesterYearTxt, semesterNoTxt);
        } else if (e.getSource() == deleteBtn) {
            delete();
            SemesterForm.cleanTextFields(semesterYearTxt, semesterNoTxt);
        } else {
            try {
                iSemesterNotifier.saveEventOccurred(null);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void delete() {
        Semester deleteSemester = new Semester();
        deleteSemester.setSemesterYear(Integer.parseInt(getSemesterYearTxt()));
        deleteSemester.setTermNo(Integer.parseInt(getSemesterNoTxt()));
        iSemesterNotifier.deleteEventOccurred(deleteSemester);
    }

    private void edit() {
        Semester editSemester = new Semester();
        editSemester.setSemesterYear(Integer.parseInt(getSemesterYearTxt()));
        editSemester.setTermNo(Integer.parseInt(getSemesterNoTxt()));
        iSemesterNotifier.editEventOccurred(editSemester);
    }

    private void add() {
        Semester addSemester = new Semester();
        addSemester.setSemesterYear(Integer.parseInt(getSemesterYearTxt()));
        addSemester.setTermNo(Integer.parseInt(getSemesterNoTxt()));
        iSemesterNotifier.addEventOccurred(addSemester);
    }
}
