package org.youcode.foracademy.models;

public class Formateur extends User {
    private Specialiter specialiter;

    public Formateur(Specialiter specialiter) {
        this.specialiter = specialiter;
    }

    public Formateur(long id_user, String first_name, String last_name, String email, String password, long phone, String gander, boolean status_compte, Role role, Adress adress, Event event, Fabrique fabrique, Specialiter specialiter) {
        super(id_user, first_name, last_name, email, password, phone, gander, status_compte, role, adress, event, fabrique);
        this.specialiter = specialiter;
    }

    public Specialiter getSpecialiter() {
        return specialiter;
    }

    public void setSpecialiter(Specialiter specialiter) {
        this.specialiter = specialiter;
    }

    @Override
    public String toString() {
        return "Formateur{" +
                "specialiter=" + specialiter +
                '}';
    }
}
