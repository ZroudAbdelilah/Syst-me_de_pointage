package org.youcode.foracademy.models;

public class Permission {
    private long id_permission;
    private String name_permission;
    private String description_permission;
    private boolean status_permission;

    public Permission() {
    }

    public Permission(long id_permission, String name_permission, String description_permission, boolean status_permission) {
        this.id_permission = id_permission;
        this.name_permission = name_permission;
        this.description_permission = description_permission;
        this.status_permission = status_permission;
    }

    public long getId_permission() {
        return id_permission;
    }

    public void setId_permission(long id_permission) {
        this.id_permission = id_permission;
    }

    public String getName_permission() {
        return name_permission;
    }

    public void setName_permission(String name_permission) {
        this.name_permission = name_permission;
    }

    public String getDescription_permission() {
        return description_permission;
    }

    public void setDescription_permission(String description_permission) {
        this.description_permission = description_permission;
    }

    public boolean isStatus_permission() {
        return status_permission;
    }

    public void setStatus_permission(boolean status_permission) {
        this.status_permission = status_permission;
    }
}
