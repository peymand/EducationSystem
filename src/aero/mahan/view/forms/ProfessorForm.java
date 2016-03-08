package aero.mahan.view.forms;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ProfessorForm extends JPanel {

    private JLabel nameLbl, familyLbl, passwordLbl, degreeLbl, professorNoLbl;
    private JTextField nameTxt, familyTxt, passwordTxt, degreeTxt, professorNoTxt;
    private JButton addBtn, saveBtn, deleteBtn, editBtn;
//    private IprofessorNotifier iprofessorNotifier;

    public ProfessorForm() {

        setProfessorBorder();
        setLayout(new GridBagLayout());
        createProfessorsFieldsandBtns();
        designComponentLayout();
    }

//    public String getNameTxt() {
//        return nameTxt.getText();
//    }
//
//    public String getFamilyTxt() {
//        return familyTxt.getText();
//    }
//
//    public String getPasswordTxt() {
//        return passwordTxt.getText();
//    }
//
//    public String getDegreeTxt() {
//        return degreeTxt.getText();
//    }
//
//    public String getProfessorNoTxt() {
//        return professorNoTxt.getText();
//    }

//    public void setProfessorEventNotifier(IEventNotifier x) {
//        this.iprofessorNotifier = x;
//    }

    private void createProfessorsFieldsandBtns() {
        nameLbl = new JLabel("Name:");
        familyLbl = new JLabel("Family:");
        passwordLbl = new JLabel("Password:");
        degreeLbl = new JLabel("Degree:");
        professorNoLbl = new JLabel("Professor No:");


        nameTxt = new JTextField(10);
        familyTxt = new JTextField(10);
        passwordTxt = new JTextField(10);
        degreeTxt = new JTextField(10);
        professorNoTxt = new JTextField(10);

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

    private void setProfessorBorder() {
        Dimension dim = new Dimension();
        dim.height = 300;
        dim.width = 900;
        setPreferredSize(dim);
        setMinimumSize(dim);
        TitledBorder professorTitledBorder = new TitledBorder("Professor");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(professorTitledBorder, innerBorder));
    }

    private void designComponentLayout() {
        GridBagConstraints c = putProfessorOnForm();

    }

    public GridBagConstraints putProfessorOnForm() {
        GridBagConstraints c = new GridBagConstraints();


        c.weighty = 0.001;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        add(nameLbl, c);

        c.gridx = 3;
        c.gridy = 0;
        add(familyLbl, c);

        c.gridx = 0;
        c.gridy = 1;
        add(passwordLbl, c);

        c.gridx = 3;
        c.gridy = 1;
        add(degreeLbl, c);

        c.gridx = 0;
        c.gridy = 2;
        add(professorNoLbl, c);

        c.gridx = 1;
        c.gridy = 0;
        add(nameTxt, c);

        c.gridx = 4;
        c.gridy = 0;
        add(familyTxt, c);

        c.gridx = 1;
        c.gridy = 1;
        add(passwordTxt, c);

        c.gridx = 4;
        c.gridy = 1;
        add(degreeTxt, c);

        c.gridx = 1;
        c.gridy = 2;
        add(professorNoTxt, c);

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

