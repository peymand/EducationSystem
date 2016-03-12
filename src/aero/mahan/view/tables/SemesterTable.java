package aero.mahan.view.tables;

import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IsemesterTableNotifier;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
        this.setLayout(new GridLayout());

        semesterTableModel = new SemesterTableModel();
        semestrTable = new JTable(semesterTableModel);

        this.add(new JScrollPane(semestrTable), BorderLayout.CENTER);

        semestrTable.setRowHeight(30);

        semestrTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Semester semester = new Semester();
                int row = semestrTable.rowAtPoint(e.getPoint());
                semester = semesterTableModel.getSemesterArrayList().get(row);
                isemesterTableNotifier.rowSelectionEventOccured(semester, row);}
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        semestrTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        semestrTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        semestrTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );



    }

    public void setIsemesterTableNotifier(IsemesterTableNotifier value){
        this.isemesterTableNotifier = value ;
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
