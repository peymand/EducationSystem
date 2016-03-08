package aero.mahan.view.panels;

import aero.mahan.model.Semester;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.interfaces.IEventNotifier;
import aero.mahan.view.interfaces.ISemesterPanelToMainFrame;
import aero.mahan.view.interfaces.IEventTableNotifier;
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
    int rowOfSelectedSemester;

    public SemesterPanel() {
        super(VERTICAL_SPLIT);
        this.semesterForm = new SemesterForm();
        this.semesterTable = new SemesterTable();
        this.setTopComponent(semesterForm);
        this.setBottomComponent(semesterTable);
        setISemesterNotifire();
        semesterTable.setSemesterIEventTableNotifier(new IEventTableNotifier<Semester>() {

            @Override
            public void rowSelectionEventOccured(Semester value1, int row) {
                semesterForm.setSemesterYearTxt(value1.getSemesterYear());
                semesterForm.setSemesterNoTxt(value1.getSemesterNo());
                rowOfSelectedSemester = row;
            }
        });
    }

    private void setISemesterNotifire() {
        semesterForm.setSemesterEventNotifier(new IEventNotifier<Semester>() {

            @Override
            public void addEventOccurred(Semester value) {
                boolean input = controlAddObject(value);
                if (input == true) {
                    JOptionPane.showMessageDialog(null, "The record is Duplicate");

                } else {
                    if (semesters.size() == 0) {
                        value.setSemesterId(1);
                        semesters.add(value);
                        setSemesterArrayList(semesters);
                    } else {
                        value.setSemesterId(semesters.get(semesters.size() - 1).getSemesterId() + 1);
                        semesters.add(value);
                        setSemesterArrayList(semesters);
                    }
                }
            }

            @Override
            public void saveEventOccurred(ArrayList<Semester> values) throws SQLException {
                values = semesters;
                iSemesterPanelToMainFrame.saveOccured(values);
            }

            @Override
            public void editEventOccurred(Semester value) {

                boolean input = controlAddObject(value);
                if (input == true) {
                    JOptionPane.showMessageDialog(null, "The record is Duplicate");

                } else {
                    semesters.get(rowOfSelectedSemester).setSemesterYear(value.getSemesterYear());
                    semesters.get(rowOfSelectedSemester).setTermNo(value.getSemesterNo());
                    setSemesterArrayList(semesters);
                }
            }

            @Override
            public void deleteEventOccurred(Semester value) {
                semesters.remove(rowOfSelectedSemester);
                setSemesterArrayList(semesters);
            }
        });
    }
    //check object
    private boolean controlAddObject(Semester value) {
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

    public void setISemesterPanelToMainFrame(ISemesterPanelToMainFrame iSemesterPanelToMainFrame) {
        this.iSemesterPanelToMainFrame = iSemesterPanelToMainFrame;
    }
}