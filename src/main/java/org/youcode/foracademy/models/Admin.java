package org.youcode.foracademy.models;

public class Admin {
    private long id_admin;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private boolean status_compte;
    private Role role;
    private Adress adress;
    private Fabrique fabrique;

    public Admin() {
    }

    public Admin( String first_name, String last_name, String email, String password, String phone, String gender, boolean status_compte, Role role, Adress adress,  Fabrique fabrique) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.status_compte = status_compte;
        this.role = role;
        this.adress = adress;
        this.fabrique = fabrique;
    }

    public Admin(long id_admin, String first_name, String last_name, String email, String password, String phone, String gander, boolean status_compte, Role role, Adress adress,  Fabrique fabrique) {
        this.id_admin = id_admin;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.status_compte = status_compte;
        this.role = role;
        this.adress = adress;
        this.fabrique = fabrique;

    }

    public long getId_admin() {
        return id_admin;
    }

    public void setId_admin(long id_admin) {
        this.id_admin = id_admin;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
