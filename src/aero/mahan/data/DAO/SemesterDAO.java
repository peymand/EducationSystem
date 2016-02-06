package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import aero.mahan.model.Semester;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by 92474747 on 1/26/2016.
 */
public class SemesterDAO {

    DbUtil dbUtil;

    public void SemesterDAO(){
        dbUtil= new DbUtil();
    }

    public void add(ArrayList<Semester> semestersArray) throws SQLException {
        dbUtil.connect();
        String insertSemesterQuery = "insert into[JavaTraining].[dbo].[Edu_Core_Semester] (SemesterYear,SemesterNumber) VALUES (?,?)";
        for (Semester semester : semestersArray) {
            PreparedStatement insertSemesterStatement = dbUtil.con.prepareStatement(insertSemesterQuery);
            insertSemesterStatement.setInt(1, semester.getSemesterYear());
            insertSemesterStatement.setInt(2, semester.getTermNo());

//            if (professorNumbers.contains(professor.getProfessorNo())) {
//                continue;
//            }
            insertSemesterStatement.execute();
            System.out.println("Semester added");
            dbUtil.disConnect();
        }
    }

    void delete(ArrayList<Semester> semesters){

    }

    void update(ArrayList<Semester> semesters){

    }

    ArrayList<Semester> read() throws SQLException {
        dbUtil.connect();
        String semesterReadSQLCommand = "select * from [JavaTraining].[dbo].[Edu_Core_Semester]";
        Statement semesterListStatement = dbUtil.con.createStatement();
        ResultSet semesterResultSet = semesterListStatement.executeQuery(semesterReadSQLCommand);
        ArrayList<Semester> semesterList = new ArrayList<>();
        while (semesterResultSet.next()) {
            Semester newSemester = new Semester();
            newSemester.setSemesterYear(semesterResultSet.getInt("SemesterYear"));
            newSemester.setTermNo(semesterResultSet.getInt("SemesterNumber"));
            semesterList.add(newSemester);
        }
        dbUtil.disConnect();
        return semesterList;
    }

}
