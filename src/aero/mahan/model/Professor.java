package aero.mahan.model;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class Professor extends Person {
    private int professorNo;
    private int professorId;
    private String degree;


    public int getProfessorNo() {
        return professorNo;
    }

    public void setProfessorNo(int professorNo) {
        this.professorNo = professorNo;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = getProfessorId();
    }




}
