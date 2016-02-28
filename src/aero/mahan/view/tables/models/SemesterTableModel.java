package aero.mahan.view.tables.models;

import aero.mahan.model.Semester;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


/**
 * Created by 92474747 on 1/26/2016.
 */

public class SemesterTableModel extends AbstractTableModel {

    private String[] column = {"Nember","Semester year", "Semester No"};
    private ArrayList<Semester> semesterArrayList;

    public SemesterTableModel() {
        semesterArrayList= new ArrayList<Semester>();
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
    public Object getValueAt(int row, int col) {
        for (int i = 0; i < semesterArrayList.size(); i++) {

            Semester s = semesterArrayList.get(row);
            switch (col) {
                case 0:
                    return s.getSemesterId();
                case 1:
                    return s.getSemesterYear();
                case 2:
                    return s.getSemesterNo();

                default:

                    break;
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (semesterArrayList == null) {
            return;
        }
        Semester s = (Semester) semesterArrayList.get(row);

        switch (col) {

            case 0:
                s.setSemesterId((Integer) value);

                break;

            case 1:
                s.setSemesterYear((Integer) value);

                break;
            case 2:
                s.setTermNo((Integer) value);
                break;
            default:
                break;
        }

    }

    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {
        this.semesterArrayList = semesterArrayList;
    }
}
