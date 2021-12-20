package org.youcode.foracademy.models;

import java.util.Date;

public class ChefFabrique extends User{

    private Date date_entry_fabrique;

    public ChefFabrique(Date date_entry_fabrique) {
        this.date_entry_fabrique = date_entry_fabrique;
    }

    public ChefFabrique(long id_user, String first_name, String last_name, String email, String password, long phone, String gander, boolean status_compte, Role role, Adress adress,  Fabrique fabrique, Date date_entry_fabrique) {
        super(id_user, first_name, last_name, email, password, phone, gander, status_compte, role, adress,  fabrique);
        this.date_entry_fabrique = date_entry_fabrique;
    }

    public Date getDate_entry_fabrique() {
        return date_entry_fabrique;
    }

    public void setDate_entry_fabrique(Date date_entry_fabrique) {
        this.date_entry_fabrique = date_entry_fabrique;
    }

    @Override
    public String toString() {
        return "ChefFabrique{" +
                "date_entry_fabrique=" + date_entry_fabrique +
                '}';
    }
}
