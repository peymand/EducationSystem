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
    public SemesterDAO(){
        dbUtil = new DbUtil();
    }

    public void save(ArrayList<Semester> semestersArray) throws SQLException {
        this.delete();
        this.insert(semestersArray);
    }

    public void insert(ArrayList<Semester> semestersArray) throws SQLException {
        dbUtil.connect();
        String insertSemesterQuery = "insert into[JavaTraining].[dbo].[Edu_Core_Semester] (Id,SemesterYear,SemesterNumber) VALUES (?,?,?)";
        for (Semester semester : semestersArray) {
            PreparedStatement insertSemesterStatement = dbUtil.con.prepareStatement(insertSemesterQuery);
            insertSemesterStatement.setInt(1, semester.getSemesterId());
            insertSemesterStatement.setInt(2, semester.getSemesterYear());
            insertSemesterStatement.setInt(3, semester.getSemesterNo());
            insertSemesterStatement.execute();
        }
        dbUtil.disConnect();
    }

    public void delete() throws SQLException {

        dbUtil.connect();
        String deleteSemesterQuery ="delete from [JavaTraining].[dbo].[Edu_Core_Semester]";
        PreparedStatement deleteSemesterStatement = dbUtil.con.prepareStatement(deleteSemesterQuery);
        deleteSemesterStatement.executeUpdate();
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

    public ArrayList<Semester> loadSemester() throws SQLException {
        ArrayList<Semester> output;
        output = this.read();
        return output;
    }

    //   public void update(ArrayList<Semester> semestersArray) throws SQLException {
//        dbUtil.connect();
//        String updateQuery = "UPDATE [dbo].[Edu_Core_Semester] SET [SemesterYear] = ? ,[SemesterNumber] = ?  WHERE Id=?";
//                    PreparedStatement updateStatement = dbUtil.con.prepareStatement(updateQuery);
//                    updateStatement.setInt(1, semestersArray.get(i).getSemesterYear());
//                    updateStatement.setInt(2, semestersArray.get(i).getSemesterNo());
//                    updateStatement.executeUpdate();
//       dbUtil.disConnect();
//   }
}
