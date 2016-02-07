package aero.mahan.data.DAO;

import aero.mahan.data.DbUtil;
import aero.mahan.model.Semester;

import javax.swing.*;
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
        String semesterYearAndTermSQLQuery = "select SemesterYear,SemesterNumber from [JavaTraining].[dbo].[Edu_Core_Semester]";
        Statement semesterYearAndTermStmt = dbUtil.con.createStatement();
        ResultSet semesterYearAndTermResultSet = semesterYearAndTermStmt.executeQuery(semesterYearAndTermSQLQuery);

        ArrayList<String> semesterYearAndTermArray = new ArrayList<>();
        while (semesterYearAndTermResultSet.next()) {
            int semesterYear = semesterYearAndTermResultSet.getInt("SemesterYear");
            int semesterNumber = semesterYearAndTermResultSet.getInt("SemesterNumber");
            semesterYearAndTermArray.add(concatenateDigits(semesterYear,semesterNumber));
        }
        String insertSemesterQuery = "insert into[JavaTraining].[dbo].[Edu_Core_Semester] (SemesterYear,SemesterNumber) VALUES (?,?)";
        int duplicateCounter=0;
        for (Semester semester : semestersArray) {
            PreparedStatement insertSemesterStatement = dbUtil.con.prepareStatement(insertSemesterQuery);
            insertSemesterStatement.setInt(1, semester.getSemesterYear());
            insertSemesterStatement.setInt(2, semester.getTermNo());

            String concatenatedSemesterYearAndTerm = concatenateDigits(semester.getSemesterYear(),semester.getTermNo());
            if (semesterYearAndTermArray.contains(concatenatedSemesterYearAndTerm)) {
                duplicateCounter++;
                continue;
            }
            insertSemesterStatement.execute();
            System.out.println("Semester added");
        }
        if (duplicateCounter>1){
            JOptionPane.showMessageDialog(null, duplicateCounter+" records are duplicated");
        }else if (duplicateCounter==1){
            JOptionPane.showMessageDialog(null, duplicateCounter+" record is duplicated");
        }
        dbUtil.disConnect();
    }

    void delete(ArrayList<Semester> semestersArray){

    }

    void update(ArrayList<Semester> semestersArray){

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

    public static String concatenateDigits(int... digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }
}
