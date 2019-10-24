package com.spinku.userRestApi.repo.openfire;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.spinku.userRestApi.entity.Ofuser;

@Repository("userDao")
public class UserDao {
//    @Qualifier("datasource1")
//    @Autowired
//    private DataSource dataSource;

    @PersistenceContext
    private EntityManager entityManagerUser;

    public Ofuser selectUserById(long username) {
        return entityManagerUser.find(Ofuser.class, username);
    }

    public void insertUser(Ofuser user) {
        entityManagerUser.persist(user);
    }

    public void updateUser(Ofuser user) {

//		User userToUpdate = selectUserById(user.getUserId());
//
//		userToUpdate.setUserName(user.getUserName());
//		userToUpdate.setUserEmail(user.getUserEmail());
//		userToUpdate.setUserPhoneNo(user.getUserPhoneNo());
//		userToUpdate.setUserDob(user.getUserDob());
//		entityManager.flush();
    }

    public void deleteUser(long userId) {
        entityManagerUser.remove(selectUserById(userId));
    }

    public List<Ofuser> selectAllUser() {
        Query query = entityManagerUser.createQuery("from Ofuser usr");//from Ofuser as usr order by usr.username
        return (List<Ofuser>) query.getResultList();
    }

    public void loginUser(String emailUser, String password, String apkVer) {

    }

    @SuppressWarnings("unchecked")
    public List<Ofuser> findByEmail(String email) {
//		Query selectQuery = entityManager.createQuery("FROM Ofuser usr  WHERE usr.email = :email").setParameter("email", email);
//		return (List<Ofuser>) selectQuery.getResultList();
//		return entityManager.createNamedQuery("Ofuser.findByUserName").setParameter("username", name).getResultList();
        return entityManagerUser.createNamedQuery("Ofuser.findByEmail").setParameter("email", email).getResultList();
//		Query query = entityManager.createQuery("from Ofuser as usr order by usr.username"+email);
//		return (List<Ofuser>) query.getResultList();

//		
    }

}
