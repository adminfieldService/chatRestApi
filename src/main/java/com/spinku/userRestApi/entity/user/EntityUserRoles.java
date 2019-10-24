package com.spinku.userRestApi.entity.user;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_roles")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityUserRoles.findId", query = "SELECT u FROM EntityUserRoles u WHERE u.user_roles_pk.id = :id"),
    @javax.persistence.NamedQuery(name = "EntityUserRoles.findByRoleName", query = "SELECT u FROM EntityUserRoles u WHERE u.user_roles_pk.roleName = :roleName")})
public class EntityUserRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntityUserRolesPK user_roles_pk;

    public EntityUserRoles() {
    }

    public EntityUserRolesPK getUser_roles_pk() {
        return user_roles_pk;
    }

    public void setUser_roles_pk(EntityUserRolesPK user_roles_pk) {
        this.user_roles_pk = user_roles_pk;
    }

    public int hashCode() {
        int hash = 0;
        hash += (user_roles_pk != null ? user_roles_pk.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof EntityUserRoles)) {
            return false;
        }
        EntityUserRoles other = (EntityUserRoles) object;
        if (((user_roles_pk == null) && (user_roles_pk != null)) || ((user_roles_pk != null) && (!user_roles_pk.equals(user_roles_pk)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.spinku.userRestApi.entity.user.EntityUserRoles[ user_roles_pk=" + user_roles_pk + " ]";
    }
}
