package aero.mahan.view.panels;

import aero.mahan.model.Semester;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.interfaces.ISemesterPanelToMainFrame;
import aero.mahan.view.interfaces.IsemesterNotifier;
import aero.mahan.view.interfaces.IsemesterTableNotifier;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterPanel extends JSplitPane {

    SemesterForm semesterForm;
    SemesterTable semesterTable;
    ArrayList<Semester> semesters;
    private ISemesterPanelToMainFrame iSemesterPanelToMainFrame;

    public SemesterPanel() {
        super(VERTICAL_SPLIT);
        this.semesterForm = new SemesterForm();
        this.semesterTable = new SemesterTable();
        this.setTopComponent(semesterForm);
        this.setBottomComponent(semesterTable);
        setIsemesterNotifire();
        semesterTable.setIsemesterTableNotifier(new IsemesterTableNotifier() {
            @Override
            public void rowSelectionEventOccured(Semester value1) {
            semesterForm.setAcademicYearText(value1.getSemesterYear());
            semesterForm.setSemesterNoText(value1.getSemesterNo());
                semesters.remove(value1);
            }
        });
    }

    private void setIsemesterNotifire() {
        semesterForm.setISemesterNotifier(new IsemesterNotifier() {

            @Override
            public void addEventOccurred(Semester value) {
                boolean input = controllAddObject(value);
                if (input == true) {
                    JOptionPane.showMessageDialog(null, "The record is Duplicate");

                } else {
                    if (semesters.size()==0){
                        value.setSemesterId(1);
                        semesters.add(value);
                        setSemesterArrayList(semesters);
                    }else {
                        value.setSemesterId(semesters.get(semesters.size()-1).getSemesterId() + 1);
                        semesters.add(value);
                        setSemesterArrayList(semesters);
                    }
                }
            }


            @Override
            public void saveEventOccurred(ArrayList<Semester> values) {

            }

            @Override
            public void editEventOccurred(Semester value) {

                boolean input = controllAddObject(value);
                if (input == true) {
                    JOptionPane.showMessageDialog(null, "The record is Duplicate");

                } else {
                    if (semesters.size()==0){
                        value.setSemesterId(1);
                    }else {
                        value.setSemesterId(semesters.get(semesters.size()-1).getSemesterId() + 1);
                        semesters.add(value);
                        setSemesterArrayList(semesters);
                    }
                }
            }

            @Override
            public void deleteEventOccurred(Semester value) {

            }
        });
    }
    //check object
    private boolean controllAddObject(Semester value) {
        boolean input = false;
        for (Semester temp : semesters) {
            if (value.getSemesterYear() == temp.getSemesterYear() && value.getSemesterNo() == temp.getSemesterNo()) {
                input = true;
            }
        }
        return input;
    }

    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {
        semesters = semesterArrayList;
        semesterTable.setSemesterArrayList(semesterArrayList);

    }
    public void setiSemesterPanelToMainFrame(ISemesterPanelToMainFrame iSemesterPanelToMainFrame) {
        this.iSemesterPanelToMainFrame = iSemesterPanelToMainFrame;
    }
}