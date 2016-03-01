package aero.mahan.view.interfaces;

import aero.mahan.model.Semester;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 921229 on 2/29/2016.
 */
public interface ISemesterPanelToMainFrame {
    void saveOccured(ArrayList<Semester> semesters) throws SQLException;
}
