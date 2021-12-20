package org.youcode.foracademy.models;

public class Specialiter {
    private long id_specialiter;
    private String name_specialiter;
    private String description;

    public Specialiter() {
    }

    public Specialiter(long id_specialiter, String name_specialiter, String description) {
        this.id_specialiter = id_specialiter;
        this.name_specialiter = name_specialiter;
        this.description = description;
    }

    public long getId_specialiter() {
        return id_specialiter;
    }

    public void setId_specialiter(long id_specialiter) {
        this.id_specialiter = id_specialiter;
    }

    public String getName_specialiter() {
        return name_specialiter;
    }

    public void setName_specialiter(String name_specialiter) {
        this.name_specialiter = name_specialiter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Specialiter{" +
                "id_specialiter=" + id_specialiter +
                ", name_specialiter='" + name_specialiter + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
