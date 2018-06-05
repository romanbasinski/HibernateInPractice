package sda.pl.repository;

import org.hibernate.Session;
import sda.pl.HibernateUtil;
import sda.pl.domain.AdvertisingBanner;

import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class AdvertisingBannerRepository {
    public static boolean saveOrUpdateProduct(AdvertisingBanner advertisingBanner){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(advertisingBanner);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(session != null && session.isOpen() && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            return false;
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }

    public static List<AdvertisingBanner> findAll(){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
//            String hql = "SELECT af FROM advertisement_for_the_user af"; //ma problem z taka tablica
//            String hql = "SELECT a FROM AdvertisingBanner a"; //działa
            String hql = "SELECT a FROM AdvertisingBanner a " +
                    "JOIN fetch a.userSet au JOIN fetch User u ON u.id=au.id"; //dobry trop ale jeszcze nie to zmienic albo rozwinąć
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static List<AdvertisingBanner> fingAdvertisingBannerForUser(Long id){
        Session session = null;

        try {
            session= HibernateUtil.openSession();
//            String hql = "SELECT a FROM AdvertisingBanner a " +
//                    "JOIN FETCH advertisement_for_the_user af ON a.id=af.advertising_banner_id " +
//                    "JOIN FETCH User u ON af.user_id=u.id " +
//                    "WHERE u.id=:id";
            String hql = "SELECT a FROM AdvertisingBanner a WHERE a.id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
