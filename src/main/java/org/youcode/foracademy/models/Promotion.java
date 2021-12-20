package org.youcode.foracademy.models;

import java.util.Date;

public class Promotion {
    private long id_promotion;
    private String name;
    private Date year;
    private Date start_date;
    private Date end_date;

    public Promotion() {
    }

    public Promotion(long id_promotion, String name, Date year, Date start_date, Date end_date) {
        this.id_promotion = id_promotion;
        this.name = name;
        this.year = year;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public long getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(long id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id_promotion=" + id_promotion +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
