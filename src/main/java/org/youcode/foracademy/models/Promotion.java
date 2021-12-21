package org.youcode.foracademy.models;

import java.util.Date;

public class Promotion {
    private long id_promotion;
    private String name;
    private Date year;
    private Date star_date;
    private Date end_date;

    public Promotion() {
    }

    public Promotion(long id_promotion, String name, Date year, Date star_date, Date end_date) {
        this.id_promotion = id_promotion;
        this.name = name;
        this.year = year;
        this.star_date = star_date;
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

    public Date getStar_date() {
        return star_date;
    }

    public void setStar_date(Date star_date) {
        this.star_date = star_date;
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
                ", star_date=" + star_date +
                ", end_date=" + end_date +
                '}';
    }
}
