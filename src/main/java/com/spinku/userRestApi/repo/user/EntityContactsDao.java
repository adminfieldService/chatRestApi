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

    @PersistenceContext(unitName = "dbuserPU")
    private EntityManager entityManagerContact;

    public void insertContact(EntityContacts dataContact) {
        entityManagerContact.persist(dataContact);
    }

    public List<EntityContacts> selectAllContact(Long id) {
        try {
//            System.out.println("idUsers : " + id);
//            String sql = "from EntityContacts o where o.id = :idUsers";
            String sql = "from EntityContacts as o LEFT JOIN o.entityUsers as u where u.id = :idUsers";
            Query query = entityManagerContact.createQuery(sql);
            query.setParameter("idUsers", id);
//         return entityManagerContact.createQuery("select object(o) from EntityContacts as o LEFT JOIN o.entityUsers as u where u.id = " + id).getResultList();
            System.out.println("sql : " + sql);
            System.out.println("query.getResultList() : " + query.getResultList());
//        System.out.println("query.getResultList()" + query.getResultList());
            return (List<EntityContacts>) query.getResultList();
        } catch (Exception ex) {
//            LogSystem.error(getClass(), e);
            System.out.println("ERROR: " + ex.getMessage());
            return null;

        }
    }

    @SuppressWarnings("unchecked")
    public List<EntityContacts> findByIdUser(Long id_user) {

        return entityManagerContact.createNamedQuery("EntityContacts.findByIdUser").setParameter("id", id_user).getResultList();

    }

}
