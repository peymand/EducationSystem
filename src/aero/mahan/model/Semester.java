package aero.mahan.model;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class Semester {
    private int semesterId;
    private int semesterYear;
    private int termNo;

    public int getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;
    }

    public int getTermNo() {
        return termNo;
    }

    public void setTermNo(int termNo) {
        this.termNo = termNo;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
