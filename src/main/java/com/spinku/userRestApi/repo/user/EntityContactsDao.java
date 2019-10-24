package com.spinku.userRestApi.repo.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.spinku.userRestApi.entity.user.EntityContacts;
import com.spinku.userRestApi.entity.user.EntityUsers;

@Repository("contactDao")
public class EntityContactsDao {
//    @Qualifier("datasource2")
//    @Autowired
//    private DataSource dataSource;

    @PersistenceContext
    private EntityManager entityManagerContact;

    public void insertContact(EntityContacts dataContact) {
        entityManagerContact.persist(dataContact);
    }

    public List<EntityContacts> selectAllContact() {
        Query query = entityManagerContact.createQuery("SELECT c FROM EntityContacts c");
        return (List<EntityContacts>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<EntityContacts> findByIdUser(Long id_user) {

        return entityManagerContact.createNamedQuery("EntityContacts.findByIdUser").setParameter("id", id_user).getResultList();

    }

    

}
