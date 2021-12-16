package org.youcode.foracademy.models;

public class Pointeur {
    private long id_pointeur;
    private String brand;

    public Pointeur() {
    }

    public Pointeur(long id_pointeur, String brand) {
        this.id_pointeur = id_pointeur;
        this.brand = brand;
    }

    public long getId_pointeur() {
        return id_pointeur;
    }

    public void setId_pointeur(long id_pointeur) {
        this.id_pointeur = id_pointeur;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
