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
    private JTable smstrTble;

    public SemesterTable() {
        try {
            semesterTableModel = new SemesterTableModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        smstrTble = new JTable(semesterTableModel);
        this.add(new JScrollPane(smstrTble), BorderLayout.CENTER);
        smstrTble.setRowHeight(50);

    }

    void Refresh() {
        semesterTableModel.fireTableDataChanged();
    }

    void SetAndRefresh(ArrayList<Semester> semester) {
        semesterTableModel.setSemesterArrayList(semester);
        Refresh();
    }

}
