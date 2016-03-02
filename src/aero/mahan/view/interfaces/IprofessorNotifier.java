package aero.mahan.view.interfaces;

import aero.mahan.model.Professor;
import aero.mahan.model.Semester;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 926365 on 2/22/2016.
 */
public interface IprofessorNotifier {
    void addEventOccurred(Professor value);
    void saveEventOccurred(ArrayList<Professor> values) throws SQLException;
    void editEventOccurred(Professor value);
    void deleteEventOccurred(Professor value);

}
