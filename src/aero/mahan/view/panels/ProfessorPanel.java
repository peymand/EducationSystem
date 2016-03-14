package aero.mahan.view.panels;

import aero.mahan.view.forms.ProfessorForm;
import aero.mahan.view.tables.ProfessorTable;

import javax.swing.*;

/**
 * Created by 926365 on 2/22/2016.
 */

    public class ProfessorPanel extends JSplitPane {

        private ProfessorForm professorForm;
        private ProfessorTable professorTable;

        public ProfessorPanel() {
            super(VERTICAL_SPLIT);
            this.professorForm = new ProfessorForm();
            this.professorTable = new ProfessorTable();
            this.setTopComponent(professorForm);
            this.setBottomComponent(professorTable);
        }
}
