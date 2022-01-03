package org.youcode.foracademy.models;

public class User {
    private long id_user;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private long phone;
    private String gander;
    private boolean status_compte;
    private Role role;
    private Adress adress;
    private Fabrique fabrique;

    public User() {
    }



    public User( String first_name, String last_name, String email, String password, long phone, String gander, boolean status_compte, Role role, Adress adress,  Fabrique fabrique) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gander = gander;
        this.status_compte = status_compte;
        this.role = role;
        this.adress = adress;
        this.fabrique = fabrique;
    }

    public User(long id_user, String first_name, String last_name, String email, String password, long phone, String gander, boolean status_compte, Role role, Adress adress,  Fabrique fabrique) {
        this.id_user = id_user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gander = gander;
        this.status_compte = status_compte;
        this.role = role;
        this.adress = adress;
        this.fabrique = fabrique;

    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public boolean isStatus_compte() {
        return status_compte;
    }

    public void setStatus_compte(boolean status_compte) {
        this.status_compte = status_compte;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }



    public Fabrique getFabrique() {
        return fabrique;
    }

    public void setFabrique(Fabrique fabrique) {
        this.fabrique = fabrique;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", gander='" + gander + '\'' +
                ", status_compte=" + status_compte +
                ", role=" + role +
                ", adress=" + adress +
                ", fabrique=" + fabrique +
                '}';
    }
}
