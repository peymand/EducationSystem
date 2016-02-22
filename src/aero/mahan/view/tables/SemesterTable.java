package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterTable extends JPanel {
    private SemesterTableModel semesterTableModel;
    private JTable semestrTable;


    public SemesterTable() {
        semesterTableModel = new SemesterTableModel();
        semestrTable = new JTable(semesterTableModel);
        this.add(new JScrollPane(semestrTable), BorderLayout.CENTER);
        semestrTable.setRowHeight(50);

    }

    public void refresh() {
        getSemesterTableModel().fireTableDataChanged();
    }
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

    public SemesterTableModel getSemesterTableModel() {
        return semesterTableModel;
    }
    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {
        this.semesterTableModel.setSemesterArrayList(semesterArrayList);
        this.refresh();
    }
}
