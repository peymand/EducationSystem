package aero.mahan.biz.BLO;

import aero.mahan.data.DAO.SemesterDAO;
import aero.mahan.model.Semester;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterBLO {

    SemesterDAO semesterDAO;

    public  SemesterBLO (){
        semesterDAO = new SemesterDAO();
    }


    public void save(ArrayList<Semester> semesters) throws SQLException {
        semesterDAO.save(semesters);
    }

    public ArrayList<Semester> loadSemesters() throws SQLException {
        return semesterDAO.loadSemester();
    }
}
