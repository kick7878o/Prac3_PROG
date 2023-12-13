package entities;

public class Entity {
    private String name;
    private String numTel;
    private String email;

    public Entity(String name, String numTel, String email) {
        this.name = name;
        this.numTel = numTel;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNumTel() {
        return numTel;
    }
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
