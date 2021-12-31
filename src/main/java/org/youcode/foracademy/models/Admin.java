package org.youcode.foracademy.models;

public class Admin extends User {
    private long id_user;
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

    public Admin(long id_user, String first_name, String last_name, String email, String password, String phone, String gander, boolean status_compte, Role role, Adress adress,  Fabrique fabrique) {
        this.id_user = id_user;
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

    @Override
    public long getId_user() {
        return id_user;
    }

    @Override
    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    @Override
    public String getFirst_name() {
        return first_name;
    }

    @Override
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String getLast_name() {
        return last_name;
    }

    @Override
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
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

    @Override
    public boolean isStatus_compte() {
        return status_compte;
    }

    @Override
    public void setStatus_compte(boolean status_compte) {
        this.status_compte = status_compte;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Adress getAdress() {
        return adress;
    }

    @Override
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public Fabrique getFabrique() {
        return fabrique;
    }

    @Override
    public void setFabrique(Fabrique fabrique) {
        this.fabrique = fabrique;
    }
}
