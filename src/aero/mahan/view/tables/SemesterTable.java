package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterTable extends JPanel {
    private JTable smstrTble;
    private SemesterTableModel semesterTableModel;

    public SemesterTable() {
        semesterTableModel = new SemesterTableModel();
        smstrTble = new JTable(semesterTableModel);
    }

    void Refresh() {
        semesterTableModel.fireTableDataChanged();
    }

    void SetAndRefresh(ArrayList<Semester> semester) {
        semesterTableModel.setSemesterArrayList(semester);
        Refresh();
    }

}
