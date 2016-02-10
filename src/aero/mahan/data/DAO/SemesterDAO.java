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
//    DbUtil dbUtil;

    public void SemesterDAO(){
//        dbUtil= new DbUtil();
    }

    public void save(ArrayList<Semester> semestersArray) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.connect();
        ArrayList<String> semesterYearAndTermArray = selectFromDatBase();
        String insertSemesterQuery = "insert into[JavaTraining].[dbo].[Edu_Core_Semester] (SemesterYear,SemesterNumber) VALUES (?,?,?)";
        int duplicateCounter=0;
        for (Semester semester : semestersArray) {
            PreparedStatement insertSemesterStatement = dbUtil.con.prepareStatement(insertSemesterQuery);
            insertSemesterStatement.setInt(1, semester.getSemesterId());
            insertSemesterStatement.setInt(2, semester.getSemesterYear());
            insertSemesterStatement.setInt(3, semester.getTermNo());

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

    public void delete(ArrayList<Semester> semestersArray) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        int deleteCounter=0;
        ArrayList<String> semesterYearAndTermDBArray = selectFromDatBase();
        ArrayList<String> concatenatedSemesterYearAndTermArray = new ArrayList<String>();
        for (int i = 0; i <semestersArray.size() ; i++) {
            concatenatedSemesterYearAndTermArray.add(i, concatenateDigits(semestersArray.get(i).getSemesterYear(), semestersArray.get(i).getTermNo()));
        }
        String deleteSemesterQuery ="delete from [JavaTraining].[dbo].[Edu_Core_Semester] where SemesterYear = ? and semesternumber = ?";
        boolean contains;
        dbUtil.connect();
        for (int i = 0; i < semesterYearAndTermDBArray.size(); i++) {
            contains = false;
            for (int j = 0; j < concatenatedSemesterYearAndTermArray.size(); j++) {
                if (concatenatedSemesterYearAndTermArray.get(j).equals(semesterYearAndTermDBArray.get(i))) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                deleteCounter++;
                PreparedStatement deleteSemesterStatement = dbUtil.con.prepareStatement(deleteSemesterQuery);
                deleteSemesterStatement.setString(1, semesterYearAndTermDBArray.get(i).substring(0,4));
                deleteSemesterStatement.setString(2, semesterYearAndTermDBArray.get(i).substring(4));
                deleteSemesterStatement.executeUpdate();
            }
        }
        if (deleteCounter>1){
            JOptionPane.showMessageDialog(null, deleteCounter+" records are deleted");
        }else if (deleteCounter==1){
            JOptionPane.showMessageDialog(null, deleteCounter+" record is deleted");
        }
        dbUtil.disConnect();
    }

//   public void update(ArrayList<Semester> semestersArray) throws SQLException {
//        DbUtil dbUtil = new DbUtil();
//        dbUtil.connect();
//        ArrayList<String> semesterYearAndTermDBArray = selectFromDatBase();
//        for (int i = 0; i <semestersArray.size() ; i++) {
//            for (int j = 0; j <semesterYearAndTermDBArray.size() ; j++) {
//                if (1==1){
//
//                }
//            }
//        }
//        dbUtil.disConnect();
//   }

    public ArrayList<Semester> read() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.connect();
        String semesterReadSQLCommand = "select * from [JavaTraining].[dbo].[Edu_Core_Semester]";
        Statement semesterListStatement = dbUtil.con.createStatement();
        ResultSet semesterResultSet = semesterListStatement.executeQuery(semesterReadSQLCommand);
        ArrayList<Semester> semesterList = new ArrayList<>();
        while (semesterResultSet.next()) {
            Semester newSemester = new Semester();
            newSemester.setSemesterId(semesterResultSet.getInt("Id"));
            newSemester.setSemesterYear(semesterResultSet.getInt("SemesterYear"));
            newSemester.setTermNo(semesterResultSet.getInt("SemesterNumber"));
            semesterList.add(newSemester);
        }
        dbUtil.disConnect();
        return semesterList;
    }

    private ArrayList<String> selectFromDatBase() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.connect();
        String semesterYearAndTermSQLQuery = "select SemesterYear,SemesterNumber from [JavaTraining].[dbo].[Edu_Core_Semester]";
        Statement semesterYearAndTermStmt = dbUtil.con.createStatement();
        ResultSet semesterYearAndTermResultSet = semesterYearAndTermStmt.executeQuery(semesterYearAndTermSQLQuery);

        ArrayList<String> semesterYearAndTermArray = new ArrayList<>();
        while (semesterYearAndTermResultSet.next()) {
//            int semesterId = semesterYearAndTermResultSet.getInt("Id");
            int semesterYear = semesterYearAndTermResultSet.getInt("SemesterYear");
            int semesterNumber = semesterYearAndTermResultSet.getInt("SemesterNumber");
            semesterYearAndTermArray.add(concatenateDigits(semesterYear,semesterNumber));
        }
        dbUtil.disConnect();
        return semesterYearAndTermArray;
    }

    public static String concatenateDigits(int... digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

//    public static void main(String[] args) throws SQLException {
//        ArrayList<Semester> semesterArrayList = new ArrayList<Semester>();
//        Semester semester = new Semester();
//        Semester semester1 = new Semester();
//        semester.setSemesterYear(2000);
//        semester.setTermNo(5);
//
//        semesterArrayList.add(0,semester);
//
//        SemesterDAO semesterDAO = new SemesterDAO();
//        semesterDAO.delete(semesterArrayList);
//    }
}
