package org.youcode.foracademy.models;

import java.util.Date;

public class Class {
    private long id_class;
    private String name_class;
    private Date start_of_day;
    private Date end_of_day;
    private Promotion promotion;

    public Class() {
    }

    public Class(long id_class, String name_class, Date start_of_day, Date end_of_day, Promotion promotion) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.start_of_day = start_of_day;
        this.end_of_day = end_of_day;
        this.promotion = promotion;
    }

    public long getId_class() {
        return id_class;
    }

    public void setId_class(long id_class) {
        this.id_class = id_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public Date getStart_of_day() {
        return start_of_day;
    }

    public void setStart_of_day(Date start_of_day) {
        this.start_of_day = start_of_day;
    }

    public Date getEnd_of_day() {
        return end_of_day;
    }

    public void setEnd_of_day(Date end_of_day) {
        this.end_of_day = end_of_day;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}

