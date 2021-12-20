package org.youcode.foracademy.models;

import java.util.Date;

public class Pointer {
    private long id_pointer;
    private User user;
    private Pointeur pointeur;
    private Date arrival_date;
    private Date do_date;

    public Pointer() {
    }

    public Pointer(long id_pointer, User user, Pointeur pointeur, Date arrival_date, Date do_date) {
        this.id_pointer = id_pointer;
        this.user = user;
        this.pointeur = pointeur;
        this.arrival_date = arrival_date;
        this.do_date = do_date;
    }

    public long getId_pointer() {
        return id_pointer;
    }

    public void setId_pointer(long id_pointer) {
        this.id_pointer = id_pointer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pointeur getPointeur() {
        return pointeur;
    }

    public void setPointeur(Pointeur pointeur) {
        this.pointeur = pointeur;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getDo_date() {
        return do_date;
    }

    public void setDo_date(Date do_date) {
        this.do_date = do_date;
    }

    @Override
    public String toString() {
        return "Pointer{" +
                "id_pointer=" + id_pointer +
                ", user=" + user +
                ", pointeur=" + pointeur +
                ", arrival_date=" + arrival_date +
                ", do_date=" + do_date +
                '}';
    }
}
