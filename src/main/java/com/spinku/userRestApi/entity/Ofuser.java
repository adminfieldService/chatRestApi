package com.spinku.userRestApi.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ofuser database table.
 *
 */
@Entity
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Ofuser.findAll", query = "SELECT usr FROM Ofuser usr")
    ,
	@javax.persistence.NamedQuery(name = "Ofuser.findByEmail", query = "SELECT usr FROM Ofuser usr where usr.email= :email")
    ,
    @javax.persistence.NamedQuery(name = "Ofuser.findByUserName", query = "SELECT usr FROM Ofuser usr where usr.username= :username")
})
public class Ofuser implements Serializable {
//	private static final long serialVersionUID = 1L;

    @Id
    private String username;

    private String creationdate;

    private String email;

    private String encryptedpassword;

    private Integer iterations;

    private String modificationdate;

    private String name;

    private String plainpassword;

    private String salt;

    private String serverkey;

    private String storedkey;

    public Ofuser() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedpassword() {
        return this.encryptedpassword;
    }

    public void setEncryptedpassword(String encryptedpassword) {
        this.encryptedpassword = encryptedpassword;
    }

    public Integer getIterations() {
        return this.iterations;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public String getModificationdate() {
        return this.modificationdate;
    }

    public void setModificationdate(String modificationdate) {
        this.modificationdate = modificationdate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlainpassword() {
        return this.plainpassword;
    }

    public void setPlainpassword(String plainpassword) {
        this.plainpassword = plainpassword;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getServerkey() {
        return this.serverkey;
    }

    public void setServerkey(String serverkey) {
        this.serverkey = serverkey;
    }

    public String getStoredkey() {
        return this.storedkey;
    }

    public void setStoredkey(String storedkey) {
        this.storedkey = storedkey;
    }

}
