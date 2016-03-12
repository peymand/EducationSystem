package aero.mahan.view.panels;

import aero.mahan.model.Semester;
import aero.mahan.view.custompanel.CrudPanel;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.interfaces.IGeneralNotifier;
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

    CrudPanel crudPanel;
    SemesterForm semesterForm;
    SemesterTable semesterTable;
    ArrayList<Semester> semesters;
    private ISemesterPanelToMainFrame iSemesterPanelToMainFrame;
    int rowOfSelectedSemester;

    public SemesterPanel() {
        super(VERTICAL_SPLIT);
        this.semesterForm = new SemesterForm();
        this.crudPanel = new CrudPanel(this.semesterForm);
        this.semesterForm.setCrudPanel(this.crudPanel);
        this.semesterTable = new SemesterTable();
        this.setTopComponent(semesterForm);
        this.setBottomComponent(semesterTable);
        setGeneralNotifier();
        semesterTable.setIsemesterTableNotifier(new IsemesterTableNotifier() {
            @Override
            public void rowSelectionEventOccured(Semester value1,int row) {
            semesterForm.setAcademicYearText(value1.getSemesterYear());
            semesterForm.setSemesterNoText(value1.getSemesterNo());
            rowOfSelectedSemester = row;
            }
        });
    }

    private void setGeneralNotifier() {
        crudPanel.setiGeneralNotifier(new IGeneralNotifier() {
            @Override
            public void addEventOccured(Object o) {
                Semester value = (Semester) o;
                boolean input = controllAddObject(value);
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
            public void editEventOccured(Object object) {
                Semester value=(Semester)object;
                boolean input = controllAddObject(value);
                if (input == true) {
                    JOptionPane.showMessageDialog(null, "The record is Duplicate");

                } else {
                    semesters.get(rowOfSelectedSemester).setSemesterYear(value.getSemesterYear());
                    semesters.get(rowOfSelectedSemester).setTermNo(value.getSemesterNo());
                    setSemesterArrayList(semesters);
                }
            }

            @Override
            public void deleteEventOccured(Object object) {
                semesters.remove(rowOfSelectedSemester);
                setSemesterArrayList(semesters);
            }
        });
    }



//            @Override
//            public void saveEventOccurred(ArrayList<Semester> values) throws SQLException {
//                values = semesters;
//                iSemesterPanelToMainFrame.saveOccured(values);
//            }


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