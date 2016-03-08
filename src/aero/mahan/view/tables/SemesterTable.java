package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IEventTableNotifier;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterTable extends JPanel {
    private SemesterTableModel semesterTableModel;
    private JTable semesterTable;
    private IEventTableNotifier<Semester> semesterIEventTableNotifier;


    public SemesterTable() {
        semesterTableModel = new SemesterTableModel();
        semesterTable = new JTable(semesterTableModel);

        this.add(new JScrollPane(semesterTable), BorderLayout.CENTER);
        semesterTable.setRowHeight(30);
        semesterTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Semester semester = new Semester();
                int row = semesterTable.rowAtPoint(e.getPoint());
                Semester semester = semesterTableModel.getSemesterArrayList().get(row);
                semesterIEventTableNotifier.rowSelectionEventOccured(semester, row);
            }
        });
    }

    public void setSemesterIEventTableNotifier(IEventTableNotifier<Semester> value){
        this.semesterIEventTableNotifier = value ;
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
