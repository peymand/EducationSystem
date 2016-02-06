package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import aero.mahan.model.Semester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterDAO {

    public Connection con;
    DbUtil dbUtil;

    public void SemesterDAO(){
        dbUtil = new DbUtil();
    }


    public void save(ArrayList<Semester> semesters) {

    }


    void delete(ArrayList<Semester> semesters){

    }

    void update(ArrayList<Semester> semesters){

    }

    ArrayList<Semester> read() throws SQLException {

        dbUtil.connect();
        String semesterReadSQLCommand = "select * from [JavaTraining].[dbo].[Edu_Core_Semester]";
        Statement semesterListStatement = con.createStatement();
        ResultSet semesterResultSet = semesterListStatement.executeQuery(semesterReadSQLCommand);
        ArrayList<Semester> semesterList = new ArrayList<>();
        while (semesterResultSet.next()) {
            Semester newSemester = new Semester();
            newSemester.setSemesterYear(semesterResultSet.getInt("SemesterYear"));
            newSemester.setTermNo(semesterResultSet.getInt("TermNo"));
            semesterList.add(newSemester);
        }
        dbUtil.disConnect();
        return semesterList;
    }


    public static void main(String[] args) throws SQLException {
        SemesterDAO semesterDAO = new SemesterDAO();
        semesterDAO.read();
    }
}
