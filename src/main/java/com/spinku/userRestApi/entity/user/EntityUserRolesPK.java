package com.spinku.userRestApi.entity.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Embeddable
public class EntityUserRolesPK implements Serializable {

    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "role_name", nullable = false)
    private String roleName;

    public EntityUserRolesPK() {
    }

    public EntityUserRolesPK(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (roleName != null ? roleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EntityUserRolesPK)) {
            return false;
        }
        EntityUserRolesPK other = (EntityUserRolesPK) object;
        if (((id == null) && (id != null)) || ((id != null) && (!id.equals(id)))) {
            return false;
        }
        if (((roleName == null) && (roleName != null)) || ((roleName != null) && (!roleName.equals(roleName)))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spinku.userRestApi.entity.user.EntityUserRolesPK[ id=" + id + ", roleName=" + roleName + "]";
    }
}
