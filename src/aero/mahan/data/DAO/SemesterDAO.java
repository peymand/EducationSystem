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
    public SemesterDAO(){
        dbUtil = new DbUtil();
    }

    public void save(ArrayList<Semester> semestersArray) throws SQLException {
        dbUtil.connect();
        ArrayList<String> semesterYearAndTermArray = selectYearAndTermConcatenatedFromDatBase();
        String insertSemesterQuery = "insert into[JavaTraining].[dbo].[Edu_Core_Semester] (SemesterYear,SemesterNumber) VALUES (?,?)";
        int duplicateCounter=0;
        for (Semester semester : semestersArray) {
            PreparedStatement insertSemesterStatement = dbUtil.con.prepareStatement(insertSemesterQuery);
            insertSemesterStatement.setInt(1, semester.getSemesterYear());
            insertSemesterStatement.setInt(2, semester.getSemesterNo());

            String concatenatedSemesterYearAndTerm = concatenateDigits(semester.getSemesterYear(),semester.getSemesterNo());
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
        ArrayList<String> semesterYearAndTermDBArray = selectYearAndTermConcatenatedFromDatBase();
        ArrayList<String> concatenatedSemesterYearAndTermArray = new ArrayList<String>();
        for (int i = 0; i <semestersArray.size() ; i++) {
            concatenatedSemesterYearAndTermArray.add(i, concatenateDigits(semestersArray.get(i).getSemesterYear(), semestersArray.get(i).getSemesterNo()));
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

   public void update(ArrayList<Semester> semestersArray) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.connect();
        int updateCounter=0;
        ArrayList<Semester> semesterYearAndTermAndIdDBArray = selectSemesterFromDataBaseArray();
        String updateQuery = "UPDATE [dbo].[Edu_Core_Semester] SET [SemesterYear] = ? ,[SemesterNumber] = ?  WHERE Id=?";
        for (int i = 0; i <semestersArray.size() ; i++) {
            for (int j = 0; j <semesterYearAndTermAndIdDBArray.size() ; j++) {
                if (semestersArray.get(i).getSemesterId()==semesterYearAndTermAndIdDBArray.get(j).getSemesterId()
                        && (semestersArray.get(i).getSemesterYear()!=semesterYearAndTermAndIdDBArray.get(j).getSemesterYear()
                        || semestersArray.get(i).getSemesterNo()!=semesterYearAndTermAndIdDBArray.get(j).getSemesterNo())){
                    updateCounter++;
                    PreparedStatement updateStatement = dbUtil.con.prepareStatement(updateQuery);
                    updateStatement.setInt(1, semestersArray.get(i).getSemesterYear());
                    updateStatement.setInt(2, semestersArray.get(i).getSemesterNo());
                    updateStatement.setInt(3, semesterYearAndTermAndIdDBArray.get(j).getSemesterId());
                    updateStatement.executeUpdate();
                }
            }
        }
       if (updateCounter>1){
           JOptionPane.showMessageDialog(null, updateCounter+" records are updated");
       }else if (updateCounter==1){
           JOptionPane.showMessageDialog(null, updateCounter+" record is updated");
       }
        dbUtil.disConnect();
   }

    public ArrayList<Semester> read() throws SQLException {
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

    private ArrayList<String> selectYearAndTermConcatenatedFromDatBase() throws SQLException {
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

    private ArrayList<Semester> selectSemesterFromDataBaseArray() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.connect();
        String semesterYearAndTermAndIdSQLQuery = "select Id,SemesterYear,SemesterNumber from [JavaTraining].[dbo].[Edu_Core_Semester]";
        Statement semesterYearAndTermStmt = dbUtil.con.createStatement();
        ResultSet semesterYearAndTermAndIdResultSet = semesterYearAndTermStmt.executeQuery(semesterYearAndTermAndIdSQLQuery);

        ArrayList<Semester> semesterYearAndTermArray = new ArrayList<>();
        while (semesterYearAndTermAndIdResultSet.next()) {
            Semester semester = new Semester();
            semester.setSemesterId(semesterYearAndTermAndIdResultSet.getInt("Id"));
            semester.setSemesterYear(semesterYearAndTermAndIdResultSet.getInt("SemesterYear"));
            semester.setTermNo(semesterYearAndTermAndIdResultSet.getInt("SemesterNumber"));
            semesterYearAndTermArray.add(semester);
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

    public ArrayList<Semester> loadSemester() throws SQLException {
        ArrayList<Semester> output = new ArrayList<>();
        output = this.read();
        return output;
    }

//    public static void main(String[] args) throws SQLException {
//        ArrayList<Semester> semesterArrayList = new ArrayList<Semester>();
//        Semester semester = new Semester();
//        Semester semester1 = new Semester();
//        Semester semester2 = new Semester();
//        Semester semester3 = new Semester();
//        semester.setSemesterId(10);
//        semester.setSemesterYear(2010);
//        semester.setTermNo(6);
//        semester1.setSemesterId(9);
//        semester1.setSemesterYear(1000);
//        semester1.setTermNo(5);
//        semester2.setSemesterId(11);
//        semester2.setSemesterYear(2002);
//        semester2.setTermNo(7);
//        semester3.setSemesterId(12);
//        semester3.setSemesterYear(2002);
//        semester3.setTermNo(1);
//        semesterArrayList.add(0,semester);
//        semesterArrayList.add(1,semester1);
//        semesterArrayList.add(2,semester2);
//        semesterArrayList.add(3,semester3);
//
//        SemesterDAO semesterDAO = new SemesterDAO();
//        semesterDAO.update(semesterArrayList);
//    }
}
