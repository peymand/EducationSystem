package aero.mahan.view.tables;

import aero.mahan.model.Professor;
import aero.mahan.model.Semester;
import aero.mahan.view.interfaces.IProfessorTableNotifier;
import aero.mahan.view.tables.models.ProfessorTableModel;
import aero.mahan.view.tables.models.SemesterTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by 926365 on 2/22/2016.
 */
public class ProfessorTable extends JPanel {

    private ProfessorTableModel professorTableModel;
    private JTable professorTable;
    private IProfessorTableNotifier iProfessorTableNotifier;


    public ProfessorTable() {
        this.setLayout(new GridLayout());
        professorTableModel = new ProfessorTableModel();

        professorTable = new JTable(professorTableModel);
        this.add(new JScrollPane(professorTable), BorderLayout.EAST);

        professorTable.setRowHeight(30);

        professorTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Professor professor = new Professor();
                int row = professorTable.rowAtPoint(e.getPoint());
                professor = (Professor)professorTableModel.getProfessorArrayList().get(row);
                getiProfessorTableNotifier().rowSelectionEventOccured(professor);
            }
        });

    }
    public void setIProfessorTableNotifier(IProfessorTableNotifier value) {
        this.iProfessorTableNotifier = value;
    }

    public void refresh() {
        getProfessorTableModel().fireTableDataChanged();
    }

//    public void addAndRefresh(Professor professor) {
//        getProfessorTableModel().addProfessorArrayList(professor);
//        Refresh();
//    }
//    public void deleteAndRefresh(Professor professor){
//        getProfessorTableModel().deleteProfessorArrayList(professor);
//        Refresh();
//    }
    public ProfessorTableModel getProfessorTableModel() {
        return professorTableModel;
    }

    public void setProfessorArrayList(ArrayList<Professor> professorArrayList) {
        this.getProfessorTableModel().setProfessorArrayList(professorArrayList);
        this.refresh();
    }

  

  //    public void setProfessorTableModel(ProfessorTableModel professorTableModel) {
//        this.professorTableModel = professorTableModel;
//    }
//
    public IProfessorTableNotifier getiProfessorTableNotifier() {
        return iProfessorTableNotifier;

        //this is the cmment
    }


}
