package aero.mahan.view.forms;

import aero.mahan.model.Semester;
import aero.mahan.view.custompanel.CrudPanel;
import aero.mahan.view.custompanel.CustomJPanel;
import aero.mahan.view.interfaces.IsemesterNotifier;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;

/**
 * Created by 92474747 on 1/26/2016.
 */
//test for git
public class SemesterForm extends CustomJPanel {

    private JLabel semesterYear, semesterNo,state1,state2;

    private Semester currentSemester;


    private IsemesterNotifier iSemesterNotifier;

    public void setCrudPanel(CrudPanel crudPanel) {
        this.crudPanel = crudPanel;
        designComponentLayout();
    }

    private CrudPanel crudPanel;

    private JTextField academicYearText, semesterNoText;




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

        semesterYear = new JLabel("    Semester Year:");
        semesterNo = new JLabel("    Semester No:");
        state1 = new JLabel("");
        state2= new JLabel("");

        academicYearText = new JTextField(10);
        semesterNoText = new JTextField(10);




        /*
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Semester s = new Semester();
                s.setSemesterYear(Integer.parseInt(getAcademicYearText()));
                s.setTermNo(Integer.parseInt(getSemesterNoText()));
                iSemesterNotifier.editEventOccurred(s);
                SemesterForm.cleanTextFields(academicYearText, semesterNoText);

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
                SemesterForm.cleanTextFields(academicYearText, semesterNoText);
            }
        });*/


    }
    public CrudPanel getCrudPanel() {
        return crudPanel;
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

        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.LINE_START;

        c.gridx = 0;
        c.gridy = 0;
        add(semesterYear, c);

        c.gridx = 0;
        c.gridy = 1;
        add(semesterNo, c);

        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 0;
        add(academicYearText, c);

        c.gridx = 1;
        c.gridy = 1;
        add(semesterNoText, c);

        c.gridx = 2;
        c.gridy = 0;
        add(state1, c);

        c.gridx = 2;
        c.gridy = 1;
        add(state2, c);

        c.gridx = 0;
        c.gridy = 3;
        add(this.crudPanel, c);


        return c;
    }

    public static void cleanTextFields(JTextField academicYearText, JTextField semesterNoText){
        academicYearText.setText(null);
        semesterNoText.setText(null);
    }

    @Override
    public Object getInsertedData() {
        Border border = BorderFactory.createLineBorder(Color.red, 1);
        Border defultBorder = BorderFactory.createLineBorder(Color.black, 1);

        ImageIcon imageIcon1 = new ImageIcon("resources\\icons\\ok.gif");

        ImageIcon imageIcon2 = new ImageIcon("resources\\icons\\cancel.gif");
        Semester newSemester = new Semester();
        String error = "";
        if(!Validation.checkTextFieldIsEmpty((getAcademicYearText()))& Validation.acceptOnlyFourDigits(getAcademicYearText())){
            newSemester.setSemesterYear(Integer.parseInt(getAcademicYearText()));
            state1.setIcon(imageIcon1);
            academicYearText.setBorder(defultBorder);
        }else {
            error += "Invalid Year\n";
            academicYearText.setBorder(border);
            state1.setIcon(imageIcon2);
        }
        if(!Validation.checkTextFieldIsEmpty(getSemesterNoText())& Validation.acceptDigitBetweenOneAndThree(getSemesterNoText())){
            newSemester.setTermNo(Integer.parseInt(getSemesterNoText()));
            state2.setIcon(imageIcon1);
            semesterNoText.setBorder(defultBorder);

        }else {
            error += "Invalid Term No.";
            semesterNoText.setBorder(border);
            state2.setIcon(imageIcon2);
        }

        if(error.equals("")){
            this.currentSemester = newSemester;

        }
        else {
            JOptionPane.showMessageDialog(null,error);
        }
        SemesterForm.cleanTextFields(academicYearText, semesterNoText);
        return this.currentSemester;
    }
}
