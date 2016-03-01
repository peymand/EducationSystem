package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IsemesterTableNotifier;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterTable extends JPanel {
    private SemesterTableModel semesterTableModel;
    private JTable semestrTable;
    private IsemesterTableNotifier isemesterTableNotifier;


    public SemesterTable() {
        semesterTableModel = new SemesterTableModel();
        semestrTable = new JTable(semesterTableModel);

        this.add(new JScrollPane(semestrTable), BorderLayout.CENTER);
        semestrTable.setRowHeight(30);
        semestrTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Semester semester = new Semester();
                int row = semestrTable.rowAtPoint(e.getPoint());
                semester = (Semester)semesterTableModel.getSemesterArrayList().get(row);
                isemesterTableNotifier.rowSelectionEventOccured(semester);
            }
        });
    }
    public void setIsemesterTableNotifier(IsemesterTableNotifier value){
        isemesterTableNotifier = value ;
    }
    public void refresh() {
        getSemesterTableModel().fireTableDataChanged();
    }

    public SemesterTableModel getSemesterTableModel() {
        return semesterTableModel;
    }
    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {

        this.semesterTableModel.setSemesterArrayList(semesterArrayList);
        this.refresh();
    }
}
