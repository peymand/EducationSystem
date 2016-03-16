package aero.mahan.view.forms;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by 926365 on 2/22/2016.
 */
public class ProfessorForm extends JPanel {

    private JLabel nameLbl, familyLbl, passwordLbl, degreeLbl, professorNoLbl;
    private JTextField nameTxt, familyText, passwordText, degreeText, professorNoText;
    private JButton addBtn, saveBtn, deleteBtn, editBtn;
    // private IprofessorNotifier iprofessorNotifier;

    public ProfessorForm() {

        setDimension();
        setBorder();
        setLayout(new GridBagLayout());
        createFields();
        designComponentLayout();
    }

    private void createFields() {
        nameLbl = new JLabel("    Name:");
        familyLbl = new JLabel("    Family:");
        passwordLbl = new JLabel("    Password:");
        degreeLbl = new JLabel("    Degree:");
        professorNoLbl = new JLabel("    Professor No:");


        nameTxt = new JTextField(10);
        familyText = new JTextField(10);
        passwordText = new JTextField(10);
        degreeText = new JTextField(10);
        professorNoText = new JTextField(10);


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

    private void setBorder() {
        TitledBorder professorTitledBorder = new TitledBorder("Professor");
        EtchedBorder innerBorder = new EtchedBorder(2);
        setBorder(BorderFactory.createCompoundBorder(professorTitledBorder, innerBorder));
    }

    private void setDimension() {
        Dimension dim = new Dimension();
        dim.height = 300;
        dim.width = 900;
        setPreferredSize(dim);
        setMinimumSize(dim);
    }

    private void designComponentLayout() {
        GridBagConstraints c = putProfessorOnForm();

    }

    public GridBagConstraints putProfessorOnForm() {
        GridBagConstraints c = new GridBagConstraints();


        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.LINE_START;

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
        c.anchor = GridBagConstraints.CENTER;

        c.gridx = 1;
        c.gridy = 0;
        add(nameTxt, c);

        c.gridx = 4;
        c.gridy = 0;
        add(familyText, c);

        c.gridx = 1;
        c.gridy = 1;
        add(passwordText, c);

        c.gridx = 4;
        c.gridy = 1;
        add(degreeText, c);

        c.gridx = 1;
        c.gridy = 2;
        add(professorNoText, c);

        c.gridx = 0;
        c.gridy = 3;
        add(addBtn, c);

        c.gridx = 1;
        c.gridy = 3;
        add(editBtn, c);

        c.gridx = 3;
        c.gridy = 3;
        add(deleteBtn, c);

        c.gridx = 4;
        c.gridy = 3;
        add(saveBtn, c);

        return c;

    }


}

