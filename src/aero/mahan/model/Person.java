package aero.mahan.model;

/**
 * Created by 92474747 on 1/26/2016.
 */
public class Person {
    private String username;
    private String password;
    private String name;
    private String family;
    public int idType;

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String name) {
        this.family = family;
    }

    public int getIdType() {
        return idType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public String getName() { return name; }

    public String getFamily() { return family; }




}
