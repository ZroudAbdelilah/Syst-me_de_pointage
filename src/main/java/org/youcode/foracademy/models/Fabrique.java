package org.youcode.foracademy.models;

public class Fabrique {
    private long id_fabrique;
    private String name_fabrique;
    private Pointeur pointeur;
    private Adress adress;
    private Boolean status_fabrique;


    public Fabrique() {
    }

    public Fabrique(long id_fabrique, String name_fabrique, Pointeur pointeur, Adress adress, Boolean status_fabrique) {
        this.id_fabrique = id_fabrique;
        this.name_fabrique = name_fabrique;
        this.pointeur = pointeur;
        this.adress = adress;
        this.status_fabrique = status_fabrique;

    }

    public Fabrique( String name_fabrique, Boolean status_fabrique) {
        this.name_fabrique = name_fabrique;
        this.status_fabrique = status_fabrique;

    }

    public long getId_fabrique() {
        return id_fabrique;
    }

    public void setId_fabrique(long id_fabrique) {
        this.id_fabrique = id_fabrique;
    }

    public String getName_fabrique() {
        return name_fabrique;
    }

    public void setName_fabrique(String name_fabrique) {
        this.name_fabrique = name_fabrique;
    }

    public Pointeur getPointeur() {
        return pointeur;
    }

    public void setPointeur(Pointeur pointeur) {
        this.pointeur = pointeur;
    }

    public Boolean getStatus_fabrique() {
        return status_fabrique;
    }

    public Adress getadress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Fabrique{" +
                "id_fabrique=" + id_fabrique +
                ", name_fabrique='" + name_fabrique + '\'' +
                ", pointeur=" + pointeur +
                ", adress=" + adress +
                '}';
    }
}
