package aero.mahan.view.interfaces;

import aero.mahan.model.Semester;

import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public interface IsemesterNotifier {
    String test = null;
    void addEventOccurred(Semester value);
    void saveEventOccurred(ArrayList<Semester> values);
    void editEventOccurred(Semester value);
    void deleteEventOccurred(Semester value);

}
