package aero.mahan.model;

/**
 * Created by 92474747 on 1/26/2016.
 */
public enum Role {

    admin("Admin"),
    professor("Professor"),
    student("Student");

    String title;
    Role(String title) {
        this.title=title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
