package aero.mahan.view.panels;

import aero.mahan.model.Semester;
import aero.mahan.view.forms.ProfessorForm;
import aero.mahan.view.forms.SemesterForm;
import aero.mahan.view.interfaces.IsemesterNotifier;
import aero.mahan.view.tables.ProfessorTable;
import aero.mahan.view.tables.SemesterTable;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by 926365 on 2/22/2016.
 */

    public class ProfessorPanel extends JSplitPane {

        ProfessorForm professorForm;
        ProfessorTable professorTable;


        public ProfessorPanel() {
            super(VERTICAL_SPLIT);
            this.professorForm = new ProfessorForm();
            this.professorTable = new ProfessorTable();
            this.setTopComponent(professorForm);
            this.setBottomComponent(professorTable);

//            semesterForm.setISemesterNotifier(new IsemesterNotifier() {
//
//                //changed with zahra
//                @Override
//                public void addEventOccurred(Semester value) {
//                    professorTable.addAndRefresh(value);
//                }
//
//                @Override
//                public void saveEventOccurred(ArrayList<Semester> values) {
//
//                }
//
//                @Override
//                public void editEventOccurred(Semester value) {
//
//                }
//
//                @Override
//                public void deleteEventOccurred(Semester value) {
//
//                }
//            });
        }


}
