
package org.youcode.foracademy.models;

public class Role {
    private long id_role;
    private String name_role;
    private String description_role;
    private boolean status_role;

    public Role() {
    }

    public Role(long id_role, String name_role, String description_role, boolean status_role) {
        this.id_role = id_role;
        this.name_role = name_role;
        this.description_role = description_role;
        this.status_role = status_role;
    }

    public long getId_role() {
        return this.id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public String getName_role() {
        return this.name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    public String getDescription_role() {
        return this.description_role;
    }

    public void setDescription_role(String description_role) {
        this.description_role = description_role;
    }

    public boolean isStatus_role() {
        return this.status_role;
    }

    public void setStatus_role(boolean status_role) {
        this.status_role = status_role;
    }

    public String toString() {
        return "Role{id_role=" + this.id_role + ", name_role='" + this.name_role + '\'' + ", description_role='" + this.description_role + '\'' + ", status_role=" + this.status_role + '}';
    }
}