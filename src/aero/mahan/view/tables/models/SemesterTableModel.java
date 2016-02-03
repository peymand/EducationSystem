package aero.mahan.view.tables.models;

import aero.mahan.model.Semester;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */

public class SemesterTableModel extends AbstractTableModel  {

    private String[] column = {"Semester Name", "Term"};
    private ArrayList<Semester> semesterArrayList;

    public SemesterTableModel() {

        semesterArrayList = new ArrayList<Semester>();

    }

    public void setSemesterArrayList(ArrayList<Semester> semesterList) {
        this.semesterArrayList = semesterList;
    }

    @Override
    public String getColumnName(int i) {

        return this.column[i];
    }

    @Override
    public int getRowCount() {

        return semesterArrayList.size();

    }

    @Override
    public int getColumnCount() {

        return column.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return null;

    }

}
