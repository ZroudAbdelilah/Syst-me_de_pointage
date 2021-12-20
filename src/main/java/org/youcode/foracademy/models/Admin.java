package org.youcode.foracademy.models;

public class Admin extends User{
    public Admin() {
    }

    public Admin(long id_user, String first_name, String last_name, String email, String password, long phone, String gander, boolean status_compte, Role role, Adress adress, Event event, Fabrique fabrique) {
        super(id_user, first_name, last_name, email, password, phone, gander, status_compte, role, adress, fabrique);
    }

}
