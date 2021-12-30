package org.youcode.foracademy.models;

public class Adress {
    private long id_adress;
    private String country;
    private String region;
    private String city;
    private Integer code_postal;

    public Adress() {
    }

    public Adress(long id_adress, String country, String region, String city, Integer code_postal) {
        this.id_adress = id_adress;
        this.country = country;
        this.region = region;
        this.city = city;
        this.code_postal = code_postal;

    }
    public Adress(String country, String region, String city, Integer code_postal) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.code_postal = code_postal;
    }

    public long getId_adress() {
        return id_adress;
    }

    public void setId_adress(long id_adress) {
        this.id_adress = id_adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(Integer code_postal) {
        this.code_postal = code_postal;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id_adress=" + id_adress +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", code_postal=" + code_postal +
                '}';
    }
}
