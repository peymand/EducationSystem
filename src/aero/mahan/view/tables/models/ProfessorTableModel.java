package aero.mahan.view.tables.models;

import aero.mahan.model.Professor;
import aero.mahan.model.Semester;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * Created by 926365 on 2/22/2016.
 */
public class ProfessorTableModel extends AbstractTableModel {

    private String[] column = {"Id","Name", "Family", "Degree", "Number"};
    private ArrayList<Professor> professorArrayList;

    public ProfessorTableModel() {
        professorArrayList= new ArrayList<Professor>();
    }
    @Override
    public String getColumnName(int i) {

        return this.column[i];
    }
    @Override
    public int getRowCount() {

        return professorArrayList.size();
    }
//    @Override
    public int getColumnCount() {

        return column.length;
    }
    @Override
    public Object getValueAt(int row, int col) {
        for (int i = 0; i < professorArrayList.size(); i++) {

            Professor p = professorArrayList.get(row);
            switch (col) {
                case 0:
                    return p.getProfessorId();
                case 1:
                    return p.getName();
                case 2:
                    return p.getFamily();
                case 3:
                    return p.getDegree();
                case 4:
                    return p.getProfessorNo();
                default:
                    break;
            }
        }
        return null;
    }
    @Override
    public void setValueAt(Object value, int row, int col) {
        if (professorArrayList == null) {
            return;
        }
        Professor p = (Professor) professorArrayList.get(row);

        switch (col) {

            case 0:
                p.setProfessorId((Integer) value);
                break;
            case 1:
                p.setName((String) value);
                break;
            case 2:
                p.setFamily((String) value);
                break;
            case 3:
                p.setDegree((String) value);
                break;
            case 4:
                p.setProfessorNo((Integer) value);
                break;
            default:
                break;
        }

    }

    public void setProfessorArrayList(ArrayList<Professor> professorArrayList) {
        this.professorArrayList = professorArrayList;
    }

    public ArrayList<Professor> getProfessorArrayList() {
        return professorArrayList;
    }
}

