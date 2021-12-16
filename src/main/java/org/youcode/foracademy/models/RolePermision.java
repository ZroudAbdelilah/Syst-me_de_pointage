package org.youcode.foracademy.models;

import java.util.Date;

public class RolePermision {
    private long id_role_permision;
    private Role role;
    private Permission permission;
    private Date assigned_at;
    private Date update_at;

    public RolePermision() {
    }

    public RolePermision(long id_role_permision, Role role, Permission permission, Date assigned_at, Date update_at) {
        this.id_role_permision = id_role_permision;
        this.role = role;
        this.permission = permission;
        this.assigned_at = assigned_at;
        this.update_at = update_at;
    }

    public long getId_role_permision() {
        return id_role_permision;
    }

    public void setId_role_permision(long id_role_permision) {
        this.id_role_permision = id_role_permision;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Date getAssigned_at() {
        return assigned_at;
    }

    public void setAssigned_at(Date assigned_at) {
        this.assigned_at = assigned_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
