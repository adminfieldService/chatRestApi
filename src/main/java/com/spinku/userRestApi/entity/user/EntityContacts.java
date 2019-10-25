package com.spinku.userRestApi.entity.user;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tbl_contacts")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityContacts.findAll", query = "SELECT c FROM EntityContacts c")
    ,
    @javax.persistence.NamedQuery(name = "EntityContacts.findByIdUser", query = "SELECT c FROM EntityContacts c where c.id = :id")
})
public class EntityContacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false)
    private Long contactId;
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email Address")
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "realname")
    private String realname;
    @Column(name = "photo")
    private String photo;

    @ManyToOne()
    @JoinColumn(name = "id")
    private EntityUsers entityUsers;

    public EntityContacts() {

    }

    public EntityContacts(Long contactId, String userName, String email, String realname, String photo, EntityUsers entityUsers) {
        this.contactId = contactId;
        this.userName = userName;
        this.email = email;
        this.realname = realname;
        this.photo = photo;
        this.entityUsers = entityUsers;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public EntityUsers getEntityUsers() {
        return entityUsers;
    }

    public void setEntityUsers(EntityUsers entityUsers) {
        this.entityUsers = entityUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EntityUsers)) {
            return false;
        }
        EntityUsers other = (EntityUsers) object;
        return !(((contactId == null) && (contactId != null)) || ((contactId != null) && (!contactId.equals(contactId))));
    }

    @Override
    public String toString() {
        return "com.spinku.userRestApi.entity.user.EntityContacts[ contactId=" + contactId + " ]";
    }
}
