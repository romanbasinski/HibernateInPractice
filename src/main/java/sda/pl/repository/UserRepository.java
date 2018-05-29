package sda.pl.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.pl.HibernateUtil;
import sda.pl.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    public static Long saveOrUpdate(User user){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            return user.getId();
        } catch (Exception e) {
            if(session != null && session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return -1L;
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }

    public static Optional<User> findByEmailAndPassword(String email, String password){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);
            User singleResult = (User) query.getSingleResult();
            return Optional.ofNullable(singleResult);
        } catch (Exception e) {

            e.printStackTrace();
            return Optional.empty();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Optional<User> findUser(Long id){
        Session session = null;
        try {
            session =HibernateUtil.openSession();
            return Optional.ofNullable(session.find(User.class, id));
        }catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }

    public static List<User> findAllWithTotalOrderPrice(){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT new sda.pl.domain.User(u.id, u.email, SUM(o.totalPrice.priceGross) ) FROM User u LEFT JOIN u.orderSet o GROUP BY u.id ";
            Query query = session.createQuery(hql);
            return query.getResultList();

        }catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }
}
