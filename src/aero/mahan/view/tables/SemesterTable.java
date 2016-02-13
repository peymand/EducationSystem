package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterTable extends JPanel {
    private SemesterTableModel semesterTableModel;
    private JTable semestrTble;
    private IDataLoader iDataLoader;

    public SemesterTable() {
        try {
            setSemesterTableModel(new SemesterTableModel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        semestrTble = new JTable(getSemesterTableModel());
        this.add(new JScrollPane(semestrTble), BorderLayout.CENTER);
        semestrTble.setRowHeight(50);

    }

    public void Refresh() {
        getSemesterTableModel().fireTableDataChanged();
    }

    public void addAndRefresh(Semester semester) {

        getSemesterTableModel().addSemesterArrayList(semester);
        Refresh();
    }
    public void deleteAndRefresh(Semester semester){
        getSemesterTableModel().deleteSemesterArrayList(semester);
        Refresh();
    }

    public void setiDataLoader(IDataLoader iDataLoader) {
        this.iDataLoader = iDataLoader;
    }

    public SemesterTableModel getSemesterTableModel() {
        return semesterTableModel;
    }

    public void setSemesterTableModel(SemesterTableModel semesterTableModel) {
        this.semesterTableModel = semesterTableModel;
    }
}
