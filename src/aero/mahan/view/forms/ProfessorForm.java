package aero.mahan.view.forms;

import aero.mahan.model.Professor;
import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IsemesterNotifier;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 926365 on 2/22/2016.
 */
public class ProfessorForm extends JPanel {

    private JLabel name, family,password,degree,professorNo;
    private JTextField nameText, familyText, passwordText, degreeText, professorNoText;
    private JButton addBtn, saveBtn, deleteBtn, editBtn;
   // private IprofessorNotifier iprofessorNotifier;

    public String getNameText() {
        return nameText.getText();
    }

    public String getFamilyText() {
        return familyText.getText();
    }

    public String getPasswordText() {
        return passwordText.getText();
    }

    public String getDegreeText() {
        return degreeText.getText();
    }

    public String getProfessorNoText() {
        return professorNoText.getText();
    }

 //   public void setISemesterNotifier(IsemesterNotifier x) {
//        this.iprofessorNotifier = x;
//    }

    public ProfessorForm() {

        Dimension dim = new Dimension();
        dim.height = 200;
        dim.width = 700;
        setPreferredSize(dim);
        setMinimumSize(dim);
        TitledBorder professorTitledBorder = new TitledBorder("Professor");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(professorTitledBorder, innerBorder));
        setLayout(new GridBagLayout());

        name = new JLabel("Name:");
        family = new JLabel("Family:");
        password=new JLabel("Password:");
        degree=new JLabel("Degree:");
        professorNo=new JLabel("Professor No:");


        nameText = new JTextField(10);
        familyText = new JTextField(10);
        passwordText = new JTextField(10);
        degreeText = new JTextField(10);
        professorNoText=new JTextField(10);

        addBtn = new JButton("Add");
        saveBtn = new JButton("Save");
        deleteBtn = new JButton("Delete");
        editBtn = new JButton("Edit");

//        addBtn.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent event) {
//
//                Professor p = new Professor();
//                p.setSemesterYear(Integer.parseInt(getAcademicYearText()));
//                s.setTermNo(Integer.parseInt(getSemesterNoText()));
//                isemesterNotifier.addEventOccurred(s);
//            }
//
//        });

//        editBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        saveBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                isemesterNotifier.saveEventOccurred(null);
//            }
//        });
//        deleteBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        designComponentLayout();
//
//    }

//    private void designComponentLayout() {
//        GridBagConstraints c = putAcademicYearOnForm();
//
//    }

//    public GridBagConstraints putAcademicYearOnForm() {
//        GridBagConstraints c = new GridBagConstraints();
//

//        c.weighty = 0.05;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.fill = GridBagConstraints.HORIZONTAL;
//
//        c.gridx = 0;
//        c.gridy = 0;
//        add(academicYear, c);
//
//        c.gridx = 0;
//        c.gridy = 1;
//        add(semesterNo, c);
//
//        c.gridx = 1;
//        c.gridy = 0;
//        add(academicYearText, c);
//
//        c.gridx = 1;
//        c.gridy = 1;
//        add(semesterNoText, c);
//
//        c.gridx = 0;
//        c.gridy = 3;
//        add(addBtn, c);
//
//        c.gridx = 1;
//        c.gridy = 3;
//        add(saveBtn, c);
//
//        c.gridx = 2;
//        c.gridy = 3;
//        add(deleteBtn, c);
//
//        c.gridx = 3;
//        c.gridy = 3;
//        add(editBtn, c);
//
//        return c;
    }

}

