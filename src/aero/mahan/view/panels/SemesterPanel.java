package aero.mahan.view.panels;

import aero.mahan.model.Semester;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.interfaces.IsemesterNotifier;
import aero.mahan.view.tables.SemesterTable;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterPanel extends JSplitPane {

    SemesterForm semesterForm;
    SemesterTable semesterTable;


    public SemesterPanel() {
        super(VERTICAL_SPLIT);
        this.semesterForm = new SemesterForm();
        this.semesterTable = new SemesterTable();
        this.setTopComponent(semesterForm);
        this.setBottomComponent(semesterTable);


        semesterForm.setISemesterNotifier(new IsemesterNotifier() {

            //changed with zahra
            @Override
            public void addEventOccurred(Semester value) {
//                semesterTable.addAndRefresh(value);
            }

            @Override
            public void saveEventOccurred(ArrayList<Semester> values) {

            }

            @Override
            public void editEventOccurred(Semester value) {

            }

            @Override
            public void deleteEventOccurred(Semester value) {

            }
        });
    }

    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {
        semesterTable.setSemesterArrayList(semesterArrayList);

    }
}