package aero.mahan.view.interfaces;

import aero.mahan.model.Semester;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public interface IEventNotifier<T> {
//    String test = null;
    void addEventOccurred(T value);
    void saveEventOccurred(ArrayList<T> values) throws SQLException;
    void editEventOccurred(T value);
    void deleteEventOccurred(T value);
}
