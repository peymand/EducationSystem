package aero.mahan.view.interfaces;

import aero.mahan.model.Semester;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public interface IsemesterNotifier {

    void addEventOccurred(Semester value);
    void saveEventOccurred(ArrayList<Semester> values) throws SQLException;
    void editEventOccurred(Semester value);
    void deleteEventOccurred(Semester value);

}
