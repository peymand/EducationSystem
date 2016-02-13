package aero.mahan.view.tables.models;

import aero.mahan.data.DAO.SemesterDAO;
import aero.mahan.model.Semester;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by 92474747 on 1/26/2016.
 */

public class SemesterTableModel extends AbstractTableModel {

    private String[] column = {"Semester Name", "Term"};
    private ArrayList<Semester> semesterArrayList;

    private SemesterDAO db;

    public void addSemesterArrayList(Semester semester) {
        getSemesterArrayList().add(semester);
    }
    public void deleteSemesterArrayList(Semester semester) {
        getSemesterArrayList().remove(semester);
    }

    public SemesterTableModel() throws SQLException {
        db = new SemesterDAO();
        setSemesterArrayList(db.read());


    }

    @Override
    public String getColumnName(int i) {

        return this.column[i];
    }

    @Override
    public int getRowCount() {

        return getSemesterArrayList().size();

    }

    @Override
    public int getColumnCount() {

        return column.length;

    }

    @Override
    public Object getValueAt(int row, int col) {
        for (int i = 0; i < getSemesterArrayList().size(); i++) {

            Semester s = getSemesterArrayList().get(row);
            switch (col) {
                case 0:
                    return s.getSemesterYear();
                case 1:
                    return s.getTermNo();



                default:

                    break;
            }

        }
        return null;

    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (getSemesterArrayList() == null) {
            return;
        }
        Semester s = (Semester) getSemesterArrayList().get(row);

        switch (col) {

            case 0:
                s.setSemesterYear((Integer) value);

                break;

            case 1:
                s.setTermNo((Integer) value);

                break;
//            case 2: s.setSemesterId((Integer) value);
//
//                break;
            default:
                break;
        }

    }

    public ArrayList<Semester> getSemesterArrayList() {
        return semesterArrayList;
    }

    public void setSemesterArrayList(ArrayList<Semester> semesterArrayList) {
        this.semesterArrayList = semesterArrayList;
    }
}
