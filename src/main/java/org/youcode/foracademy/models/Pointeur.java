package org.youcode.foracademy.models;

public class Pointeur {
    private long id_pointeur;
    private String brand;
    private Boolean status_pointeur;

    public Pointeur() {
    }


    public Pointeur(long id_pointeur, String brand, Boolean status_pointeur) {
        this.id_pointeur = id_pointeur;
        this.brand = brand;
        this.status_pointeur = status_pointeur;

    }

    public Pointeur(Boolean status_pointeur, String brand) {
        this.brand = brand;
        this.status_pointeur = status_pointeur;
    }

    public Boolean getStatus_pointeur() {
        return status_pointeur;
    }
    public void setStatus_pointeur(Boolean status_pointeur) {
        this.status_pointeur = status_pointeur;
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

    @Override
    public String toString() {
        return "Pointeur{" +
                "id_pointeur=" + id_pointeur +
                ", brand='" + brand + '\'' +
                '}';
    }
}
