package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.tables.models.ProfessorTableModel;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by 926365 on 2/22/2016.
 */
public class ProfessorTable extends JPanel {

    ProfessorTableModel professorTableModel;
    private JTable professorTable;

    public ProfessorTable() {
        professorTableModel = new ProfessorTableModel();
        professorTable = new JTable(professorTableModel);

        this.add(new JScrollPane(professorTable), BorderLayout.CENTER);
        professorTable.setRowHeight(30);

    }

//    public void refresh() {
//        getSemesterTableModel().fireTableDataChanged();
//    }
//
//    public void addAndRefresh(Semester semester) {
//
//        getSemesterTableModel().addSemesterArrayList(semester);
//        Refresh();
//    }
//    public void deleteAndRefresh(Semester semester){
//        getSemesterTableModel().deleteSemesterArrayList(semester);
//        Refresh();
//    }

//    public SemesterTableModel getSemesterTableModel() {
//        return professorTableModel;
//    }
//    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {
//        this.professorTableModel.setSemesterArrayList(semesterArrayList);
//        this.refresh();
//    }
//


}
