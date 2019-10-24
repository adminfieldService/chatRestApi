package com.spinku.userRestApi.entity.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tbl_users")
@NamedQueries({
    @javax.persistence.NamedQuery(name = "EntityUsers.findAll", query = "SELECT us FROM EntityUsers us")
    ,
    @javax.persistence.NamedQuery(name = "EntityUsers.findById", query = "SELECT us FROM EntityUsers us WHERE us.id = :id")
    ,
    @javax.persistence.NamedQuery(name = "EntityUsers.findByuserName", query = "SELECT us FROM EntityUsers us WHERE us.userName = :userName")
    ,
    @javax.persistence.NamedQuery(name = "EntityUsers.findByuserPass", query = "SELECT us FROM EntityUsers us WHERE us.userPass = :userPass")
    ,
    @javax.persistence.NamedQuery(name = "EntityUsers.findByaddress", query = "SELECT us FROM EntityUsers us WHERE us.address = :address")
    ,
    @javax.persistence.NamedQuery(name = "EntityUsers.findByroleName", query = "SELECT us FROM EntityUsers us WHERE us.roleName = :roleName")})

public class EntityUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @Column(name = "user_pass", nullable = false)
    private String userPass;
    @Column(name = "pass_user", nullable = false)
    private String passUser;
    @Column(name = "address")
    private String address;
    @Column(name = "nomor_imei")
    private String nomorIMEI;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email Address")
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "date_register")
    @Temporal(TemporalType.DATE)
    private Date dateRegister;
    @Column(name = "date_last_login")
    @Temporal(TemporalType.DATE)
    private Date dateLasetLogin;
    @Column(name = "time_last_login")
    private String timeLastLogin;
    @Column(name = "sesion_id")
    private String sesionID;
    @Column(name = "device_id_login")
    private String device_id_login;
    @Column(name = "token")
    private String token;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @OneToMany(mappedBy = "id")
    private Collection<EntityContacts> entityContacts;

    public EntityUsers() {
    }

    public static enum Gender {

        M, F;

        private Gender() {
        }
    }

    public EntityUsers(Long id, String userName, String roleName, String userPass, String passUser, String address,
            String nomorIMEI, boolean isActive,
            @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email Address") String email,
            Date dateRegister, Date dateLasetLogin, String timeLastLogin, String sesionID, String device_id_login,
            String token, Gender gender, Collection<EntityContacts> entityContacts) {
        super();
        this.id = id;
        this.userName = userName;
        this.roleName = roleName;
        this.userPass = userPass;
        this.passUser = passUser;
        this.address = address;
        this.nomorIMEI = nomorIMEI;
        this.isActive = isActive;
        this.email = email;
        this.dateRegister = dateRegister;
        this.dateLasetLogin = dateLasetLogin;
        this.timeLastLogin = timeLastLogin;
        this.sesionID = sesionID;
        this.device_id_login = device_id_login;
        this.token = token;
        this.gender = gender;
        this.entityContacts = entityContacts;
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

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNomorIMEI() {
        return nomorIMEI;
    }

    public void setNomorIMEI(String nomorIMEI) {
        this.nomorIMEI = nomorIMEI;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateLasetLogin() {
        return dateLasetLogin;
    }

    public void setDateLasetLogin(Date dateLasetLogin) {
        this.dateLasetLogin = dateLasetLogin;
    }

    public String getTimeLastLogin() {
        return timeLastLogin;
    }

    public void setTimeLastLogin(String timeLastLogin) {
        this.timeLastLogin = timeLastLogin;
    }

    public String getSesionID() {
        return sesionID;
    }

    public void setSesionID(String sesionID) {
        this.sesionID = sesionID;
    }

    public String getDevice_id_login() {
        return device_id_login;
    }

    public void setDevice_id_login(String device_id_login) {
        this.device_id_login = device_id_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Collection<EntityContacts> getEntityContacts() {
        return entityContacts;
    }

    public void setEntityContacts(Collection<EntityContacts> entityContacts) {
        this.entityContacts = entityContacts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EntityUsers)) {
            return false;
        }
        EntityUsers other = (EntityUsers) object;
        return !(((id == null) && (id != null)) || ((id != null) && (!id.equals(id))));
    }

    @Override
    public String toString() {
        return "com.spinku.userRestApi.entity.user.EntityUsers[ id=" + id + " ]";
    }
}
